// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

plugins {
    id("x-twitter-scraper.kotlin")
    id("x-twitter-scraper.publish")
}

val mockitoAgent = configurations.create("mockitoAgent")

configurations.all {
    resolutionStrategy {
        force("com.fasterxml.jackson.core:jackson-core:2.22.3")
        force("com.fasterxml.jackson.core:jackson-databind:2.22.3")
        force("com.fasterxml.jackson.core:jackson-annotations:2.22")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.22.3")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.22.3")
        force("com.fasterxml.jackson.module:jackson-module-kotlin:2.22.3")
    }
}

dependencies {
    mockitoAgent("org.mockito:mockito-core:5.24.0") {
        isTransitive = false
    }

    api("com.fasterxml.jackson.core:jackson-core:2.22.3")
    api("com.fasterxml.jackson.core:jackson-databind:2.22.3")
    api("com.google.errorprone:error_prone_annotations:2.50.0")

    implementation("com.fasterxml.jackson.core:jackson-annotations:2.22")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.22.3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.22.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.22.3")
    implementation(kotlin("reflect"))

    testImplementation(kotlin("test"))
    testImplementation(project(":x-twitter-scraper-java-client-okhttp"))
    testImplementation(enforcedPlatform("org.eclipse.jetty:jetty-bom:12.1.14"))
    testImplementation(enforcedPlatform("org.eclipse.jetty.ee10:jetty-ee10-bom:12.1.14"))
    testImplementation("org.wiremock:wiremock-jetty12:3.13.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("com.code-intelligence:jazzer-junit:0.30.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:6.1.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:6.1.3")
    testImplementation("org.junit.platform:junit-platform-launcher:6.1.3")
    testImplementation("org.junit-pioneer:junit-pioneer:2.3.0")
    testImplementation("org.mockito:mockito-core:5.24.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.24.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:6.4.0")
    testRuntimeOnly("org.slf4j:slf4j-nop:2.0.20")
}

tasks.withType<Test>().configureEach {
    jvmArgs("-javaagent:${mockitoAgent.asPath}")
}

// Jazzer replays its generated corpus, the ignored .cifuzz-corpus folder in the
// working directory, whenever a coverage agent runs, and JaCoCo is one. Outside a
// fuzz campaign the tests run in an empty folder, so every machine replays only
// the inputs committed under src/test/resources.
// https://github.com/CodeIntelligenceTesting/jazzer/blob/v0.30.0/src/main/java/com/code_intelligence/jazzer/junit/SeedArgumentsProvider.java#L63-L70
val fuzzing = providers.environmentVariable("JAZZER_FUZZ").map { it.isNotEmpty() }.orElse(false)
tasks.named<Test>("test") {
    inputs.property("jazzerFuzz", fuzzing)
    if (!fuzzing.get()) {
        val regressionDirectory = layout.buildDirectory.dir("regression-tests").get().asFile
        workingDir = regressionDirectory
        doFirst { regressionDirectory.mkdirs() }
    }
}
