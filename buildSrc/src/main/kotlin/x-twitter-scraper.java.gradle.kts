// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

import org.gradle.api.attributes.java.TargetJvmVersion
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    `java-library`
    jacoco
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(26))
    }

    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

jacoco {
    toolVersion = "0.8.15"
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("-Werror")
    options.release.set(8)
}

tasks.named<JavaCompile>("compileTestJava") {
    options.release.set(26)
}

tasks.withType<Zip>().configureEach {
    isPreserveFileTimestamps = false
    isReproducibleFileOrder = true
    from(rootProject.file("LICENSE")) {
        into("META-INF")
    }
}

tasks.named<Jar>("jar") {
    manifest {
        attributes(mapOf(
            "Implementation-Title" to project.name,
            "Implementation-Version" to project.version
        ))
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()

    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
    forkEvery = 100

    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
    }
}

configurations.matching { it.name.startsWith("test") }.configureEach {
    attributes.attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 26)
}

val palantir = configurations.create("palantir")
dependencies {
    palantir("com.palantir.javaformat:palantir-java-format:2.96.0")
}

fun registerPalantir(
    name: String,
    description: String,
) {
    val javaName = "${name}Java"
    tasks.register<JavaExec>(javaName) {
        group = "Verification"
        this.description = description

        classpath = palantir
        mainClass = "com.palantir.javaformat.java.Main"

        jvmArgs(
            "--add-exports", "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
            "--add-exports", "jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED",
            "--add-exports", "jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED",
            "--add-exports", "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
            "--add-exports", "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
        )

        val argumentFile =
            project.layout.buildDirectory.file("palantir-$name-args.txt").get().asFile
        val lastRunTimeFile =
            project.layout.buildDirectory.file("palantir-$name-last-run.txt").get().asFile

        val lastRunTime = lastRunTimeFile.takeIf { it.exists() }?.readText()?.toLongOrNull() ?: 0L

        val javaFiles = project.fileTree("src") { include("**/*.java") }

        onlyIf { javaFiles.any { it.lastModified() > lastRunTime } }

        inputs.files(javaFiles)

        doFirst {
            argumentFile.parentFile.mkdirs()
            argumentFile.writeText("--palantir\n")

            if (name == "lint") {
                argumentFile.appendText("--dry-run\n")
                argumentFile.appendText("--set-exit-if-changed\n")
            } else {
                argumentFile.appendText("--replace\n")
            }

            javaFiles.filter { it.lastModified() > lastRunTime }
                .forEach { argumentFile.appendText("${it.absolutePath}\n") }
        }

        doLast {
            lastRunTimeFile.writeText(System.currentTimeMillis().toString())
        }

        args = listOf("@${argumentFile.absolutePath}")

        outputs.upToDateWhen { javaFiles.none { it.lastModified() > lastRunTime } }
    }

    tasks.named(name) {
        dependsOn(tasks.named(javaName))
    }
}

registerPalantir(name = "format", description = "Formats all Java source files.")
registerPalantir(name = "lint", description = "Verifies all Java source files are formatted.")
