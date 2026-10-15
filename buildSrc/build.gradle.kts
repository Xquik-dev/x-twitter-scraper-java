// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

import org.jetbrains.kotlin.gradle.dsl.JvmTarget

buildscript {
    configurations.classpath {
        resolutionStrategy.force("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.21")
    }
}

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_25)
    }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencyLocking {
    lockAllConfigurations()
}

configurations.configureEach {
    resolutionStrategy.force(
        "com.fasterxml.jackson.core:jackson-annotations:2.22",
        "com.fasterxml.jackson.core:jackson-core:2.22.3",
        "com.fasterxml.jackson.core:jackson-databind:2.22.3",
        "com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.22.3",
        "com.fasterxml.jackson.module:jackson-module-kotlin:2.22.3",
        "com.github.jknack:handlebars:4.5.5",
        "com.google.guava:guava:33.7.2-jre",
        "com.jayway.jsonpath:json-path:3.0.0",
        "commons-fileupload:commons-fileupload:1.6.0",
        "commons-io:commons-io:2.22.0",
        "net.minidev:json-smart:2.6.0",
        "org.apache.commons:commons-lang3:3.21.0",
        "org.apache.logging.log4j:log4j-api:2.26.1",
        "org.apache.logging.log4j:log4j-core:2.26.1",
        "org.bouncycastle:bcpg-jdk18on:1.86",
        "org.bouncycastle:bcpkix-jdk18on:1.86",
        "org.bouncycastle:bcprov-jdk18on:1.86",
        "org.bouncycastle:bcutil-jdk18on:1.86",
        "org.freemarker:freemarker:2.3.35",
        "org.jsoup:jsoup:1.23.2",
        "org.xmlunit:xmlunit-core:2.14.0",
        "org.xmlunit:xmlunit-legacy:2.14.0",
        "org.xmlunit:xmlunit-placeholders:2.14.0",
    )
}

dependencies {
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:2.2.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.21")
    implementation("com.vanniktech:gradle-maven-publish-plugin:0.37.0")
}
