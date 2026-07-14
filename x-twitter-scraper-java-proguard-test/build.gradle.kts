plugins {
    id("x-twitter-scraper.kotlin")
    id("com.gradleup.shadow") version "9.5.1"
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
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.14.3")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.22.1")
}

tasks.shadowJar {
    from(sourceSets.test.get().output)
    configurations = listOf(project.configurations.testRuntimeClasspath.get())
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    mergeServiceFiles()
    exclude("META-INF/LICENSE*")
    exclude("META-INF/NOTICE*")
    exclude("META-INF/versions/9/OSGI-INF/MANIFEST.MF")
}

val shadowJarPath = "${layout.buildDirectory.get()}/libs/${project.name}-${project.version}-all.jar"
val proguardJarPath = "${layout.buildDirectory.get()}/libs/${project.name}-${project.version}-proguard.jar"
val proguardJar = tasks.register<proguard.gradle.ProGuardTask>("proguardJar") {
    group = "verification"
    dependsOn(tasks.shadowJar)
    notCompatibleWithConfigurationCache("ProGuard")

    injars(shadowJarPath)
    outjars(proguardJarPath)
    printmapping("${layout.buildDirectory.get()}/proguard-mapping.txt")

    val javaHome = System.getProperty("java.home")
    if (System.getProperty("java.version").startsWith("1.")) {
        // Before Java 9, the runtime classes were packaged in a single jar file.
        libraryjars("$javaHome/lib/rt.jar")
    } else {
        // As of Java 9, the runtime classes are packaged in modular jmod files.
        libraryjars(
            // Filters must be specified first, as a map.
            mapOf("jarfilter" to "!**.jar", "filter" to "!module-info.class"),
            "$javaHome/jmods/java.base.jmod"
        )
    }

    configuration("./test.pro")
    configuration("../x-twitter-scraper-java-core/src/main/resources/META-INF/proguard/x-twitter-scraper-java-core.pro")
}

val testProGuard = tasks.register<JavaExec>("testProGuard") {
    group = "verification"
    dependsOn(proguardJar)
    notCompatibleWithConfigurationCache("ProGuard")

    mainClass.set("com.x_twitter_scraper.api.proguard.ProGuardCompatibilityTest")
    classpath = files(proguardJarPath)
}

val r8JarPath = "${layout.buildDirectory.get()}/libs/${project.name}-${project.version}-r8.jar"
val r8Jar = tasks.register<JavaExec>("r8Jar") {
    group = "verification"
    dependsOn(tasks.shadowJar)
    notCompatibleWithConfigurationCache("R8")

    mainClass.set("com.android.tools.r8.R8")
    classpath = buildscript.configurations["classpath"]

    args = listOf(
        "--release",
        "--classfile",
        "--output", r8JarPath,
        "--lib", System.getProperty("java.home"),
        "--pg-conf", "./test.pro",
        "--pg-conf", "../x-twitter-scraper-java-core/src/main/resources/META-INF/proguard/x-twitter-scraper-java-core.pro",
        "--pg-map-output", "${layout.buildDirectory.get()}/r8-mapping.txt",
        shadowJarPath,
    )
}

val testR8 = tasks.register<JavaExec>("testR8") {
    group = "verification"
    dependsOn(r8Jar)
    notCompatibleWithConfigurationCache("R8")

    mainClass.set("com.x_twitter_scraper.api.proguard.ProGuardCompatibilityTest")
    classpath = files(r8JarPath)
}

tasks.test {
    dependsOn(testProGuard)
    dependsOn(testR8)
    // We defer to the tests run via the ProGuard JAR.
    enabled = false
}
