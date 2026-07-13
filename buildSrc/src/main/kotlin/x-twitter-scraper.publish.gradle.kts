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
        description.set("Look up any tweet, user, or trend on X. Search tweets, check follower\nrelationships, download media, and monitor accounts in real time. 32 pay-per-use\nread endpoints work without a subscription - just pay per call. Write endpoints\n(post, like, retweet, follow, DM) and automation endpoints (bulk extractions,\ngiveaway draws, monitors, webhooks) require an API key or OAuth 2.1 bearer\ntoken.\n\n## Official SDKs\n\nAll SDKs are auto-generated from this OpenAPI spec via Stainless and stay in\nsync release-by-release. Pick your language:\n\n- TypeScript / Node.js: `npm i x-twitter-scraper` -\n  [Xquik-dev/x-twitter-scraper-typescript](https://github.com/Xquik-dev/x-twitter-scraper-typescript)\n\n- Python: `pip install x-twitter-scraper` -\n  [Xquik-dev/x-twitter-scraper-python](https://github.com/Xquik-dev/x-twitter-scraper-python)\n\n- Go: `go get github.com/Xquik-dev/x-twitter-scraper-go` -\n  [Xquik-dev/x-twitter-scraper-go](https://github.com/Xquik-dev/x-twitter-scraper-go)\n\n- Ruby: `gem install x-twitter-scraper` -\n  [Xquik-dev/x-twitter-scraper-ruby](https://github.com/Xquik-dev/x-twitter-scraper-ruby)\n\n- Java (Maven Central) -\n  [Xquik-dev/x-twitter-scraper-java](https://github.com/Xquik-dev/x-twitter-scraper-java)\n\n- Kotlin (Maven Central) -\n  [Xquik-dev/x-twitter-scraper-kotlin](https://github.com/Xquik-dev/x-twitter-scraper-kotlin)\n\n- C# / .NET: `dotnet add package XTwitterScraper` -\n  [Xquik-dev/x-twitter-scraper-csharp](https://github.com/Xquik-dev/x-twitter-scraper-csharp)\n\n- PHP: `composer require xquik/x-twitter-scraper` -\n  [Xquik-dev/x-twitter-scraper-php](https://github.com/Xquik-dev/x-twitter-scraper-php)\n\n- CLI: `npm i -g x-twitter-scraper-cli` -\n  [Xquik-dev/x-twitter-scraper-cli](https://github.com/Xquik-dev/x-twitter-scraper-cli)\n\n- Terraform Provider (Terraform Registry) -\n  [Xquik-dev/terraform-provider-x-twitter-scraper](https://github.com/Xquik-dev/terraform-provider-x-twitter-scraper)\n\nOpenClaw plugin: [Xquik-dev/tweetclaw](https://github.com/Xquik-dev/tweetclaw)\n(`claw install tweetclaw`).")
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
