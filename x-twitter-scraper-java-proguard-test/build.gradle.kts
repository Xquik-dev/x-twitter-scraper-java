import org.gradle.api.artifacts.component.ProjectComponentIdentifier

plugins {
    id("x-twitter-scraper.kotlin")
}

buildscript {
    repositories {
        google()
    }

    dependencies {
        classpath("com.guardsquare:proguard-gradle:7.9.1")
        classpath("com.android.tools:r8:9.1.31")
    }
}

dependencies {
    testImplementation(project(":x-twitter-scraper-java"))
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.22.1")
    testRuntimeOnly("org.codehaus.mojo:animal-sniffer-annotations:1.27")
    testRuntimeOnly("org.conscrypt:conscrypt-openjdk-uber:2.6.1")
    testRuntimeOnly("org.graalvm.sdk:nativeimage:25.1.3")
}

val runtimeLibraries = configurations.testRuntimeClasspath.get().incoming.artifactView {
    componentFilter { componentIdentifier ->
        componentIdentifier !is ProjectComponentIdentifier
    }
}.files

val sdkJarTasks = listOf(
    project(":x-twitter-scraper-java-core").tasks.named<Jar>("jar"),
    project(":x-twitter-scraper-java-client-okhttp").tasks.named<Jar>("jar"),
    project(":x-twitter-scraper-java").tasks.named<Jar>("jar"),
)

val compatibilityJar = tasks.register<Jar>("compatibilityJar") {
    group = "verification"
    dependsOn(sdkJarTasks)
    archiveClassifier.set("all")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(sourceSets.test.get().output)
    sdkJarTasks.forEach { sdkJarTask ->
        from(sdkJarTask.map { sdkJar -> zipTree(sdkJar.archiveFile.get().asFile) }) {
            exclude("META-INF/MANIFEST.MF")
        }
    }
    runtimeLibraries.files.sortedBy { file -> file.name }.forEach { runtimeLibrary ->
        from(zipTree(runtimeLibrary)) {
            exclude(
                "META-INF/MANIFEST.MF",
                "META-INF/*.DSA",
                "META-INF/*.RSA",
                "META-INF/*.SF",
                "META-INF/versions/**/module-info.class",
                "module-info.class",
            )
        }
    }
}

val compatibilityJarPath = "${layout.buildDirectory.get()}/libs/${project.name}-${project.version}-all.jar"
val proguardJarPath = "${layout.buildDirectory.get()}/libs/${project.name}-${project.version}-proguard.jar"
val compatibilityMainClass = "com.xquik.consumer.proguard.ProGuardCompatibilityTest"

fun shrinkerJavaHome(): File {
    val path = providers.environmentVariable("SHRINKER_JAVA_HOME").orNull
        ?: throw GradleException("Set SHRINKER_JAVA_HOME to a JDK 25 installation.")
    val javaHome = file(path)
    val releaseFile = javaHome.resolve("release")
    val isJava25 = releaseFile.isFile && releaseFile.useLines { lines ->
        lines.any { line -> line == "JAVA_VERSION=\"25\"" || line.startsWith("JAVA_VERSION=\"25.") }
    }
    if (!isJava25 || !javaHome.resolve("jmods/java.base.jmod").isFile) {
        throw GradleException("SHRINKER_JAVA_HOME must point to a JDK 25 installation with jmods.")
    }
    return javaHome
}

val proguardJar = tasks.register<proguard.gradle.ProGuardTask>("proguardJar") {
    group = "verification"
    dependsOn(compatibilityJar)
    notCompatibleWithConfigurationCache("ProGuard")

    injars(compatibilityJarPath)
    outjars(proguardJarPath)
    printmapping("${layout.buildDirectory.get()}/proguard-mapping.txt")

    val javaHome = shrinkerJavaHome()
    javaHome.resolve("jmods").listFiles { file -> file.extension == "jmod" }
        .orEmpty()
        .sortedBy { file -> file.name }
        .forEach { file ->
            libraryjars(
                mapOf("jarfilter" to "!**.jar", "filter" to "!module-info.class"),
                file,
            )
        }
    configuration("./test.pro")
    configuration("../x-twitter-scraper-java-core/src/main/resources/META-INF/proguard/x-twitter-scraper-java-core.pro")
}

val testProGuard = tasks.register<JavaExec>("testProGuard") {
    group = "verification"
    dependsOn(proguardJar)
    notCompatibleWithConfigurationCache("ProGuard")

    mainClass.set(compatibilityMainClass)
    classpath = files(proguardJarPath)
}

val r8JarPath = "${layout.buildDirectory.get()}/libs/${project.name}-${project.version}-r8.jar"
val r8Jar = tasks.register<JavaExec>("r8Jar") {
    group = "verification"
    dependsOn(compatibilityJar)
    notCompatibleWithConfigurationCache("R8")

    mainClass.set("com.android.tools.r8.R8")
    classpath = buildscript.configurations["classpath"]

    val javaHome = shrinkerJavaHome()
    args = listOf(
        "--release",
        "--classfile",
        "--output", r8JarPath,
        "--lib", javaHome.absolutePath,
        "--pg-conf", "./test.pro",
        "--pg-conf", "../x-twitter-scraper-java-core/src/main/resources/META-INF/proguard/x-twitter-scraper-java-core.pro",
        "--pg-map-output", "${layout.buildDirectory.get()}/r8-mapping.txt",
        compatibilityJarPath,
    )
}

val testR8 = tasks.register<JavaExec>("testR8") {
    group = "verification"
    dependsOn(r8Jar)
    notCompatibleWithConfigurationCache("R8")

    mainClass.set(compatibilityMainClass)
    classpath = files(r8JarPath)
}

tasks.test {
    dependsOn(testProGuard)
    dependsOn(testR8)
    // We defer to the tests run via the ProGuard JAR.
    enabled = false
}
