# Specify the entrypoint where ProGuard starts to determine what's reachable.
-keep class com.x_twitter_scraper.api.proguard.** { *; }

# For the testing framework.
-keep class org.junit.** { *; }

# Kotlin reflection loads runtime classes dynamically.
-keep class kotlin.** { *; }

# Many warnings don't apply for our testing purposes.
-dontnote
-dontwarn
