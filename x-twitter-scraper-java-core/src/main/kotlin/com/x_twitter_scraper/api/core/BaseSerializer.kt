// SPDX-FileCopyrightText: 2026 Xquik contributors
//
// SPDX-License-Identifier: Apache-2.0

package com.x_twitter_scraper.api.core

import com.fasterxml.jackson.databind.ser.std.StdSerializer
import kotlin.reflect.KClass

abstract class BaseSerializer<T : Any>(type: KClass<T>) : StdSerializer<T>(type.java)
