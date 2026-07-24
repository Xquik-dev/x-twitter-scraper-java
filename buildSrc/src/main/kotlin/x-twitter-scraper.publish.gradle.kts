import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SourcesJar

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
        publishToMavenCentral()
    }

    coordinates(project.group.toString(), project.name, project.version.toString())
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaGeneratePublicationHtml"),
            sourcesJar = SourcesJar.Sources(),
        )
    )

    pom {
        name.set("Xquik Java SDK")
        description.set(
            "Java SDK for the Xquik REST API. Xquik is an independent third-party service. " +
                "Not affiliated with X Corp. \"Twitter\" and \"X\" are trademarks of X Corp."
        )
        url.set("https://xquik.com")

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                name.set("Xquik")
                email.set("support@xquik.com")
                organization.set("Xquik")
                organizationUrl.set("https://xquik.com")
            }
        }

        scm {
            connection.set("scm:git:https://github.com/Xquik-dev/x-twitter-scraper-java.git")
            developerConnection.set("scm:git:ssh://git@github.com/Xquik-dev/x-twitter-scraper-java.git")
            url.set("https://github.com/Xquik-dev/x-twitter-scraper-java")
        }
    }
}

tasks.matching { task -> task.name == "dokkaGeneratePublicationHtml" }.configureEach {
    doLast {
        fileTree(layout.buildDirectory.dir("dokka/html")) {
            include("**/*.html")
        }.forEach { htmlFile ->
            val original = htmlFile.readText()
            val normalized =
                original.replace(
                    Regex("""org\.jetbrains\.dokka\.pages\.commenttable@[0-9a-f]+"""),
                    "org.jetbrains.dokka.pages.commenttable",
                )
            if (normalized != original) {
                htmlFile.writeText(normalized)
            }
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
