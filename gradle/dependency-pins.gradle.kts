// SPDX-FileCopyrightText: 2026 Xquik contributors
// SPDX-License-Identifier: Apache-2.0

configurations.configureEach {
    resolutionStrategy.force(
        "com.fasterxml.jackson.core:jackson-annotations:2.22",
        "com.fasterxml.jackson.core:jackson-core:2.22.3",
        "com.fasterxml.jackson.core:jackson-databind:2.22.3",
        "com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.22.3",
        "com.fasterxml.jackson.module:jackson-module-kotlin:2.22.3",
        "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.22.3",
        "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.22.3",
        "com.github.jknack:handlebars:4.5.5",
        "com.google.guava:guava:33.7.2-jre",
        "com.jayway.jsonpath:json-path:3.0.0",
        "commons-fileupload:commons-fileupload:1.6.0",
        "commons-io:commons-io:2.22.0",
        "net.minidev:json-smart:2.6.0",
        "org.apache.commons:commons-lang3:3.21.0",
        "org.apache.logging.log4j:log4j-api:2.26.1",
        "org.apache.logging.log4j:log4j-core:2.26.1",
        "org.apache.httpcomponents.client5:httpclient5:5.6.4",
        "org.apache.httpcomponents.core5:httpcore5:5.4.4",
        "org.apache.httpcomponents.core5:httpcore5-h2:5.4.4",
        "org.jsoup:jsoup:1.23.2",
        "org.xmlunit:xmlunit-core:2.14.0",
        "org.xmlunit:xmlunit-legacy:2.14.0",
        "org.xmlunit:xmlunit-placeholders:2.14.0",
    )
}
