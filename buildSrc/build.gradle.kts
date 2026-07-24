import org.jetbrains.kotlin.gradle.dsl.JvmTarget

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

dependencies {
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:2.2.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.0")
    implementation("com.vanniktech:gradle-maven-publish-plugin:0.37.0")
}
