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
        description.set("Xquik is an independent third-party service. Not affiliated with X Corp.\n\"Twitter\" and \"X\" are trademarks of X Corp. Look up tweets, users, and X trends.\nSearch tweets, check follow relationships, download media, and monitor accounts.\n33 paid-read endpoints accept prepaid credits without a subscription. 7\nfixed-price lookups also accept direct MPP payments. Write and automation\nendpoints require an API key or OAuth 2.1 bearer token.\n\n## Xquik SDKs\n\nStainless generates each SDK from this OpenAPI schema. Pick a language:\n\n- TypeScript / Node.js: `npm i x-twitter-scraper` -\n  [Xquik-dev/x-twitter-scraper-typescript](https://github.com/Xquik-dev/x-twitter-scraper-typescript)\n\n- Python: `pip install x-twitter-scraper` -\n  [Xquik-dev/x-twitter-scraper-python](https://github.com/Xquik-dev/x-twitter-scraper-python)\n\n- Go: `go get github.com/Xquik-dev/x-twitter-scraper-go` -\n  [Xquik-dev/x-twitter-scraper-go](https://github.com/Xquik-dev/x-twitter-scraper-go)\n\n- Ruby: `gem install x-twitter-scraper` -\n  [Xquik-dev/x-twitter-scraper-ruby](https://github.com/Xquik-dev/x-twitter-scraper-ruby)\n\n- Java (source build; Maven Central pending) -\n  [Xquik-dev/x-twitter-scraper-java](https://github.com/Xquik-dev/x-twitter-scraper-java)\n\n- Kotlin (source build; Maven Central pending) -\n  [Xquik-dev/x-twitter-scraper-kotlin](https://github.com/Xquik-dev/x-twitter-scraper-kotlin)\n\n- C# / .NET: `dotnet add package XTwitterScraper` -\n  [Xquik-dev/x-twitter-scraper-csharp](https://github.com/Xquik-dev/x-twitter-scraper-csharp)\n\n- PHP: `composer require xquik/x-twitter-scraper` -\n  [Xquik-dev/x-twitter-scraper-php](https://github.com/Xquik-dev/x-twitter-scraper-php)\n\n- CLI:\n  `go install github.com/Xquik-dev/x-twitter-scraper-cli/cmd/x-twitter-scraper@latest` -\n  [Xquik-dev/x-twitter-scraper-cli](https://github.com/Xquik-dev/x-twitter-scraper-cli)\n\n- Terraform Provider (Terraform Registry) -\n  [Xquik-dev/terraform-provider-x-twitter-scraper](https://github.com/Xquik-dev/terraform-provider-x-twitter-scraper)\n\nOpenClaw plugin: [Xquik-dev/tweetclaw](https://github.com/Xquik-dev/tweetclaw)\n(`openclaw plugins install clawhub:@xquik/tweetclaw`).")
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
