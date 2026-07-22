plugins {
    id("x-twitter-scraper.kotlin")
    id("x-twitter-scraper.publish")
}

dependencies {
    api(project(":x-twitter-scraper-java-client-okhttp"))
}
