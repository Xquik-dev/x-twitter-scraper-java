plugins {
    id("x-twitter-scraper.kotlin")
    id("x-twitter-scraper.publish")
}

dependencies {
    api(project(":x-twitter-scraper-java-core"))

    implementation("com.squareup.okhttp3:okhttp:5.4.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.4.0")

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation(enforcedPlatform("org.eclipse.jetty:jetty-bom:12.0.37"))
    testImplementation(enforcedPlatform("org.eclipse.jetty.ee10:jetty-ee10-bom:12.0.37"))
    testImplementation("org.wiremock:wiremock-jetty12:3.13.2")
}
