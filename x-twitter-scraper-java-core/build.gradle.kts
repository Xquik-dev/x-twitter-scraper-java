plugins {
    id("x-twitter-scraper.kotlin")
    id("x-twitter-scraper.publish")
}

val mockitoAgent = configurations.create("mockitoAgent")

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
    mockitoAgent("org.mockito:mockito-core:5.23.0") {
        isTransitive = false
    }

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
    testImplementation(enforcedPlatform("org.eclipse.jetty:jetty-bom:12.0.37"))
    testImplementation(enforcedPlatform("org.eclipse.jetty.ee10:jetty-ee10-bom:12.0.37"))
    testImplementation("org.wiremock:wiremock-jetty12:3.13.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("com.code-intelligence:jazzer-junit:0.30.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.14.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.14.3")
    testImplementation("org.junit.platform:junit-platform-launcher:1.14.3")
    testImplementation("org.junit-pioneer:junit-pioneer:1.9.1")
    testImplementation("org.mockito:mockito-core:5.23.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.23.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    testRuntimeOnly("org.slf4j:slf4j-nop:2.0.17")
}

tasks.withType<Test>().configureEach {
    jvmArgs("-javaagent:${mockitoAgent.asPath}")
}
