// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

import com.github.jk1.license.filter.DependencyFilter
import com.github.jk1.license.filter.SpdxLicenseBundleNormalizer
import com.github.jk1.license.render.CsvReportRenderer
import com.github.jk1.license.render.InventoryHtmlReportRenderer
import com.github.jk1.license.render.ReportRenderer
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
    version = "0.10.4" // x-release-please-version

    dependencyLocking {
        lockAllConfigurations()
    }

    apply(from = rootProject.file("gradle/dependency-pins.gradle.kts"))
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

val coverageClasses = files(subprojects.flatMap { project ->
    listOf("java", "kotlin").map { language ->
        project.layout.buildDirectory.dir("classes/$language/main")
    }
})
val coverageSources = files(subprojects.flatMap { project ->
    listOf("java", "kotlin").map { language ->
        project.layout.projectDirectory.dir("src/main/$language")
    }
})
val coverageReport = tasks.register<JacocoReport>("coverageReport") {
    group = "Verification"
    description = "Reports instruction, branch, line & method coverage for all SDK classes."
    dependsOn(subprojects.map { "${it.path}:test" })
    executionData(fileTree(rootDir) { include("x-twitter-scraper-*/build/jacoco/test.exec") })
    classDirectories.setFrom(coverageClasses)
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
val coverageRawReport = tasks.register<Copy>("coverageRawReport") {
    dependsOn(coverageReport)
    from(coverageReport.flatMap { it.reports.xml.outputLocation })
    into(layout.buildDirectory.dir("reports/jacoco/coverage-raw"))
}
val coverageVerify = tasks.register<Exec>("coverageVerify") {
    group = "Verification"
    description = "Compares all native coverage counts with a fresh full-source parent."
    dependsOn(coverageReport)
    val parentReport = providers.gradleProperty("coverageParent")
    doFirst {
        val parent = parentReport.orNull
            ?: throw GradleException("Pass -PcoverageParent=/path/to/fresh-parent.xml.")
        commandLine("go", "run", "scripts/coverage-gate/main.go", parent,
            coverageReport.get().reports.xml.outputLocation.get().asFile.absolutePath)
    }
}
tasks.register("coverage") {
    group = "Verification"
    dependsOn(coverageRawReport, coverageVerify)
}
