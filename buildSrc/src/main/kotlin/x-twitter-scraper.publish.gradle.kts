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
        description.set("Look up any tweet, user, or trend on X. Search tweets, check follower\nrelationships, download media, and monitor accounts in real time. 32 pay-per-use\nread endpoints work without a subscription — just pay per call. Write endpoints\n(post, like, retweet, follow, DM) and automation endpoints (bulk extractions,\ngiveaway draws, monitors, webhooks) require an API key or OAuth 2.1 bearer\ntoken.")
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
