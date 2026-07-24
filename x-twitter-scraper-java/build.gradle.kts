// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

plugins {
    id("x-twitter-scraper.kotlin")
    id("x-twitter-scraper.publish")
}

dependencies {
    api(project(":x-twitter-scraper-java-client-okhttp"))
}
