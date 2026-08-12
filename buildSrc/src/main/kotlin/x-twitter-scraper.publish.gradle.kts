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
        description.set("Xquik is an independent third-party service. Not affiliated with X Corp.\n\"Twitter\" and \"X\" are trademarks of X Corp. Look up tweets, users, and X trends.\nSearch tweets, check follow relationships, download media, and monitor accounts.\n33 paid-read endpoints accept prepaid credits without a subscription. 7\nfixed-price lookups also accept direct MPP payments. Write and automation\nendpoints require an API key or OAuth 2.1 bearer token.\n\n## Client Libraries\n\nSee the current [SDK, CLI, and Terraform guides](https://docs.xquik.com/sdks)\nand [TweetClaw setup](https://docs.xquik.com/guides/tweetclaw).")
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
            connection.set("scm:git:git://github.com/Xquik-dev/x-twitter-scraper-java.git")
            developerConnection.set("scm:git:git://github.com/Xquik-dev/x-twitter-scraper-java.git")
            url.set("https://github.com/Xquik-dev/x-twitter-scraper-java")
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
