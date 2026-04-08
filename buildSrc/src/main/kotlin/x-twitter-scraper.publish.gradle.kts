import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

publishing {
  repositories {
      if (project.hasProperty("publishLocal")) {
          maven {
              name = "LocalFileSystem"
              url = uri("${rootProject.layout.buildDirectory.get()}/local-maven-repo")
          }
      }
  }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

extra["signingInMemoryKey"] = System.getenv("GPG_SIGNING_KEY")
extra["signingInMemoryKeyId"] = System.getenv("GPG_SIGNING_KEY_ID")
extra["signingInMemoryKeyPassword"] = System.getenv("GPG_SIGNING_PASSWORD")

configure<MavenPublishBaseExtension> {
    if (!project.hasProperty("publishLocal")) {
        signAllPublications()
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    }

    coordinates(project.group.toString(), project.name, project.version.toString())
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaJavadoc"),
            sourcesJar = true,
        )
    )

    pom {
        name.set("Xquik API")
        description.set("Xquik is an all-in-one X (Twitter) automation API with 40+ endpoints for\nreading, writing, and monitoring X data. **Read endpoints** let you look up\ntweets, search tweets, fetch user profiles, list followers & following, browse\ntimelines, bookmarks, notifications, communities, lists, trending topics, and\ndownload media. **Write endpoints** let you post tweets, reply, like, unlike,\nretweet, unretweet, follow, unfollow, send DMs, upload media, update profiles,\nand manage communities. **Automation endpoints** power bulk data extractions (20\ntool types), giveaway draws from tweet replies, real-time account monitoring\nwith webhooks & Telegram integrations, tweet composition with AI, and writing\nstyle analysis. Authenticate with an API key or OAuth 2.1 bearer token.\nPay-per-use endpoints are also available without an account.")
        url.set("https://xquik.com")

        licenses {
            license {
                name.set("Apache-2.0")
            }
        }

        developers {
            developer {
                name.set("X Twitter Scraper")
                email.set("support@xquik.com")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/stainless-sdks/x-twitter-scraper-java.git")
            developerConnection.set("scm:git:git://github.com/stainless-sdks/x-twitter-scraper-java.git")
            url.set("https://github.com/stainless-sdks/x-twitter-scraper-java")
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
