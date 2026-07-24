// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

import com.github.jk1.license.filter.DependencyFilter
import com.github.jk1.license.filter.SpdxLicenseBundleNormalizer
import com.github.jk1.license.render.CsvReportRenderer
import com.github.jk1.license.render.InventoryHtmlReportRenderer
import com.github.jk1.license.render.ReportRenderer
import org.gradle.testing.jacoco.tasks.JacocoCoverageVerification
import org.gradle.testing.jacoco.tasks.JacocoReport

plugins {
    id("com.github.jk1.dependency-license-report") version "3.1.4"
    jacoco
}

repositories {
    mavenCentral()
}

jacoco {
    toolVersion = "0.8.15"
}

licenseReport {
    configurations = arrayOf("runtimeClasspath", "testRuntimeClasspath")
    allowedLicensesFile = layout.projectDirectory.file("config/allowed-licenses.json")
    filters = arrayOf<DependencyFilter>(SpdxLicenseBundleNormalizer())
    renderers =
        arrayOf<ReportRenderer>(
            CsvReportRenderer("dependencies.csv"),
            InventoryHtmlReportRenderer("index.html", "Xquik Java SDK Dependencies"),
        )
}

allprojects {
    group = "com.xquik.api"
    version = "0.5.2" // x-release-please-version

    dependencyLocking {
        lockAllConfigurations()
    }

    configurations.configureEach {
        resolutionStrategy.force(
            "com.fasterxml.jackson.core:jackson-annotations:2.22",
            "com.fasterxml.jackson.core:jackson-core:2.22.1",
            "com.fasterxml.jackson.core:jackson-databind:2.22.1",
            "com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.22.1",
            "com.fasterxml.jackson.module:jackson-module-kotlin:2.22.1",
            "com.github.jknack:handlebars:4.5.3",
            "com.google.guava:guava:33.6.0-jre",
            "com.jayway.jsonpath:json-path:3.0.0",
            "commons-fileupload:commons-fileupload:1.6.0",
            "commons-io:commons-io:2.22.0",
            "net.minidev:json-smart:2.6.0",
            "org.apache.commons:commons-lang3:3.20.0",
            "org.apache.logging.log4j:log4j-api:2.25.4",
            "org.apache.logging.log4j:log4j-core:2.25.4",
            "org.xmlunit:xmlunit-core:2.12.0",
            "org.xmlunit:xmlunit-legacy:2.12.0",
            "org.xmlunit:xmlunit-placeholders:2.12.0",
        )
    }
}

subprojects {
    // These are populated with dependencies by `buildSrc` scripts.
    tasks.register("format") {
        group = "Verification"
        description = "Formats all source files."
    }
    tasks.register("lint") {
        group = "Verification"
        description = "Verifies all source files are formatted."
    }
}

val coverageExecutionData =
    fileTree(rootDir) {
        include("x-twitter-scraper-java*/build/jacoco/test.exec")
    }
val allCoverageClasses =
    fileTree(rootDir) {
        include("x-twitter-scraper-java*/build/classes/java/main/**/*.class")
        include("x-twitter-scraper-java*/build/classes/kotlin/main/**/*.class")
    }
val generatedSourceMarker = "// File generated from our OpenAPI spec by Stainless."
val generatedSourceHeaderLineLimit = 12
val maintainedGeneratedSources =
    setOf(
        "x-twitter-scraper-java-core/src/main/kotlin/com/x_twitter_scraper/api/core/http/RetryingHttpClient.kt"
    )
val generatedCoverageExclusions =
    subprojects.associateWith { project ->
        listOf("src/main/java", "src/main/kotlin").flatMap { sourcePath ->
            val sourceRoot = project.file(sourcePath)
            if (!sourceRoot.isDirectory) {
                emptyList()
            } else {
                sourceRoot
                    .walkTopDown()
                    .filter { it.isFile && it.extension in setOf("java", "kt") }
                    .filter { source ->
                        source.useLines { lines ->
                            lines.take(generatedSourceHeaderLineLimit).any { it == generatedSourceMarker }
                        } &&
                            source.relativeTo(rootDir).invariantSeparatorsPath !in
                                maintainedGeneratedSources
                    }
                    .map { source ->
                        source
                            .relativeTo(sourceRoot)
                            .invariantSeparatorsPath
                            .substringBeforeLast('.') + "*"
                    }
                    .toList()
            }
        }
    }
val maintainedCoverageClasses =
    files(
        subprojects.flatMap { project ->
            val exclusions = generatedCoverageExclusions.getValue(project)
            listOf(
                project.fileTree(project.layout.buildDirectory.dir("classes/java/main")) {
                    exclude(exclusions)
                },
                project.fileTree(project.layout.buildDirectory.dir("classes/kotlin/main")) {
                    exclude(exclusions)
                },
            )
        }
    )
val coverageSources =
    files(
        subprojects.flatMap { project ->
            listOf(
                project.layout.projectDirectory.dir("src/main/java"),
                project.layout.projectDirectory.dir("src/main/kotlin"),
            )
        }
    )
val testTasks =
    subprojects
        .filterNot { it.name == "x-twitter-scraper-java-proguard-test" }
        .map { "${it.path}:test" }

val coverageReport =
    tasks.register<JacocoReport>("coverageReport") {
        group = "Verification"
        description = "Generates aggregate line and branch coverage."
        dependsOn(testTasks)
        executionData(coverageExecutionData)
        classDirectories.setFrom(maintainedCoverageClasses)
        sourceDirectories.setFrom(coverageSources)
        jacocoClasspath = configurations.named("jacocoAnt").get()

        reports {
            xml.required.set(true)
            xml.outputLocation.set(layout.buildDirectory.file("reports/jacoco/coverage/coverage.xml"))
            html.required.set(true)
            html.outputLocation.set(layout.buildDirectory.dir("reports/jacoco/coverage/html"))
            csv.required.set(false)
        }
    }

val coverageRawReport =
    tasks.register<JacocoReport>("coverageRawReport") {
        group = "Verification"
        description = "Reports raw coverage, including generated SDK sources."
        dependsOn(testTasks)
        executionData(coverageExecutionData)
        classDirectories.setFrom(allCoverageClasses)
        sourceDirectories.setFrom(coverageSources)
        jacocoClasspath = configurations.named("jacocoAnt").get()

        reports {
            xml.required.set(true)
            xml.outputLocation.set(
                layout.buildDirectory.file("reports/jacoco/coverage-raw/coverage.xml")
            )
            html.required.set(true)
            html.outputLocation.set(layout.buildDirectory.dir("reports/jacoco/coverage-raw/html"))
            csv.required.set(false)
        }
    }

val coverageVerify =
    tasks.register<JacocoCoverageVerification>("coverageVerify") {
        group = "Verification"
        description = "Enforces aggregate line and branch coverage."
        dependsOn(testTasks)
        executionData(coverageExecutionData)
        classDirectories.setFrom(maintainedCoverageClasses)
        sourceDirectories.setFrom(coverageSources)
        jacocoClasspath = configurations.named("jacocoAnt").get()

        violationRules {
            rule {
                limit {
                    counter = "LINE"
                    value = "COVEREDRATIO"
                    minimum = "0.90".toBigDecimal()
                }
                limit {
                    counter = "BRANCH"
                    value = "COVEREDRATIO"
                    minimum = "0.80".toBigDecimal()
                }
            }
        }
    }

tasks.register("coverage") {
    group = "Verification"
    description = "Generates raw coverage and verifies maintained-source coverage."
    dependsOn(coverageRawReport, coverageReport, coverageVerify)
}
