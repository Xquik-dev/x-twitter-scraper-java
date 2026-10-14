// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

plugins {
    id("x-twitter-scraper.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":x-twitter-scraper-java-core"))
    implementation(project(":x-twitter-scraper-java-client-okhttp"))
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(9)
}

application {
    mainClass = "com.x_twitter_scraper.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
