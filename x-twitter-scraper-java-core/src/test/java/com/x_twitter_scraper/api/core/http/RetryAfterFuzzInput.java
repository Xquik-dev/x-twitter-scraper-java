// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core.http;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;

final class RetryAfterFuzzInput {

    private RetryAfterFuzzInput() {}

    static String consume(FuzzedDataProvider data) {
        return data.consumeRemainingAsString();
    }
}
