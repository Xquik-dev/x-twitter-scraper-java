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
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :x-twitter-scraper-java-example:run` to run `Main`
    // Use `./gradlew :x-twitter-scraper-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.x_twitter_scraper.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
