plugins {
    id("x-twitter-scraper.kotlin")
    id("x-twitter-scraper.publish")
}

configurations.all {
    resolutionStrategy {
        force("com.fasterxml.jackson.core:jackson-core:2.22.1")
        force("com.fasterxml.jackson.core:jackson-databind:2.22.1")
        force("com.fasterxml.jackson.core:jackson-annotations:2.22")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.22.1")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.22.1")
        force("com.fasterxml.jackson.module:jackson-module-kotlin:2.22.1")
    }
}

dependencies {
    api("com.fasterxml.jackson.core:jackson-core:2.22.1")
    api("com.fasterxml.jackson.core:jackson-databind:2.22.1")
    api("com.google.errorprone:error_prone_annotations:2.50.0")

    implementation("com.fasterxml.jackson.core:jackson-annotations:2.22")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.22.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.22.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.22.1")
    implementation(kotlin("reflect"))

    testImplementation(kotlin("test"))
    testImplementation(project(":x-twitter-scraper-java-client-okhttp"))
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.14.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.14.3")
    testImplementation("org.junit-pioneer:junit-pioneer:1.9.1")
    testImplementation("org.mockito:mockito-core:5.23.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.23.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
}
