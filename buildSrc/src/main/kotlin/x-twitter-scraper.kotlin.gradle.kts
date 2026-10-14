// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.JvmDefaultMode
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("x-twitter-scraper.java")
    id("org.jetbrains.dokka")
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(26))
    }

    compilerOptions {
        allWarningsAsErrors.set(true)
        freeCompilerArgs = listOf(
            "-Xjdk-release=1.8",
        )
        jvmDefault.set(JvmDefaultMode.NO_COMPATIBILITY)
        jvmTarget.set(JvmTarget.JVM_1_8)
        languageVersion.set(KotlinVersion.KOTLIN_2_2)
        apiVersion.set(KotlinVersion.KOTLIN_2_2)
        coreLibrariesVersion = "2.3.20"
    }
}

tasks.withType<Test>().configureEach {
    systemProperty("junit.jupiter.execution.parallel.enabled", true)
    systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")

    inputs.property("skipMockTests", System.getenv("SKIP_MOCK_TESTS")).optional(true)
}

tasks.named<KotlinCompile>("compileTestKotlin") {
    compilerOptions {
        freeCompilerArgs.set(emptyList())
        jvmTarget.set(JvmTarget.JVM_26)
    }
}

val ktfmt = configurations.create("ktfmt")
dependencies {
    ktfmt("com.facebook:ktfmt:0.64")
}

fun registerKtfmt(
    name: String,
    description: String,
) {
    val kotlinName = "${name}Kotlin"
    tasks.register<JavaExec>(kotlinName) {
        group = "Verification"
        this.description = description

        classpath = ktfmt
        mainClass = "com.facebook.ktfmt.cli.Main"

        val argumentFile = project.layout.buildDirectory.file("ktfmt-$name-args.txt").get().asFile
        val lastRunTimeFile =
            project.layout.buildDirectory.file("ktfmt-$name-last-run.txt").get().asFile

        val lastRunTime = lastRunTimeFile.takeIf { it.exists() }?.readText()?.toLongOrNull() ?: 0L

        val kotlinFiles = project.fileTree("src") { include("**/*.kt") }

        onlyIf { kotlinFiles.any { it.lastModified() > lastRunTime } }

        inputs.files(kotlinFiles)

        doFirst {
            argumentFile.parentFile.mkdirs()
            argumentFile.writeText("--kotlinlang-style\n")

            if (name == "lint") {
                argumentFile.appendText("--dry-run\n")
                argumentFile.appendText("--set-exit-if-changed\n")
            }

            kotlinFiles.filter { it.lastModified() > lastRunTime }
                .forEach { argumentFile.appendText("${it.absolutePath}\n") }
        }

        doLast {
            lastRunTimeFile.writeText(System.currentTimeMillis().toString())
        }

        args = listOf("@${argumentFile.absolutePath}")

        outputs.upToDateWhen { kotlinFiles.none { it.lastModified() > lastRunTime } }
    }

    tasks.named(name) {
        dependsOn(tasks.named(kotlinName))
    }
}

registerKtfmt(name = "format", description = "Formats all Kotlin source files.")
registerKtfmt(name = "lint", description = "Verifies all Kotlin source files are formatted.")
