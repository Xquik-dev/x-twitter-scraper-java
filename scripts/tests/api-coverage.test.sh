#!/usr/bin/env bash

# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

set -euo pipefail

# shellcheck source=scripts/tests/support.sh
source "$(dirname -- "${BASH_SOURCE[0]}")/support.sh"

readonly api_root="x-twitter-scraper-java-core/src/main/kotlin/com/x_twitter_scraper/api"
readonly tweet_service="$api_root/services/blocking/x/TweetServiceImpl.kt"
readonly unreadable_spec_line="Could not read the API spec from"
readonly unreadable_spec_next_step="Check network access, or set XQUIK_OPENAPI_SPEC to a local copy of https://xquik.com/openapi.json."
readonly missing_next_step="Add each operation above to the SDK, or list it in excluded-operations.json with a reason."
readonly exclusion_next_step="Fix excluded-operations.json as each line above says."

write_client_options() {
    write_file "$api_root/core/ClientOptions.kt" <<EOF
package com.x_twitter_scraper.api.core

class ClientOptions {
    companion object {

        const val PRODUCTION_URL = "$1"
    }
}
EOF
}

write_tweet_service() {
    write_file "$tweet_service" <<'EOF'
package com.x_twitter_scraper.api.services.blocking.x

class TweetServiceImpl {
    fun retrieve() {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl(clientOptions.baseUrl())
                .addPathSegments("x", "tweets", params._pathParam(0))
                .build()
                .prepare(clientOptions, params)
    }

    fun deleteNote() {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .baseUrl(clientOptions.baseUrl())
                .addPathSegments(
                    "x",
                    "community-notes",
                    "contributors",
                    params._pathParam(0),
                    "notes",
                    params._pathParam(1),
                )
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepare(clientOptions, params)
    }
}
EOF
}

write_spec() {
    write_file spec.json
}

covered_spec() {
    write_spec <<'EOF'
{
  "openapi": "3.1.0",
  "servers": [{"url": "https://xquik.com/api/v1"}],
  "paths": {
    "/x/tweets/{id}": {
      "parameters": [{"name": "id", "in": "path"}],
      "get": {"operationId": "getTweet"}
    },
    "/x/community-notes/contributors/{alias}/notes/{noteId}": {
      "delete": {"operationId": "deleteNote"}
    },
    "/ask": {
      "servers": [{"url": "https://xquik.com/"}],
      "get": {"operationId": "askDocs"},
      "post": {"operationId": "askDocsWithBody"}
    }
  }
}
EOF
}

exclude() {
    write_file excluded-operations.json
}

exclude_docs() {
    exclude <<'EOF'
[
  {
    "reason": "Searches the Xquik docs outside the SDK base URL.",
    "operations": ["GET /ask", "POST /ask"]
  }
]
EOF
}

prepare_coverage() {
    copy_file scripts/api-coverage
    copy_file scripts/lib/temp-paths.bash
    write_client_options "https://xquik.com/api/v1"
    write_tweet_service
    covered_spec
    exclude_docs
    run_env=("XQUIK_OPENAPI_SPEC=spec.json")
}

assert_fails_with() {
    assert_equal 1 "$run_status" "the exit code"
    assert_equal "" "$run_stdout" "stdout"
    assert_equal "$1" "$run_stderr" "stderr"
}

assert_passes_with() {
    assert_equal "" "$run_stderr" "stderr"
    assert_equal 0 "$run_status" "the exit code"
    assert_equal "$1" "$run_stdout" "stdout"
}

test_a_covered_spec_passes_and_counts_the_excluded_operations() {
    prepare_coverage

    run_in_repo scripts/api-coverage

    assert_passes_with "The SDK covers 2 of 4 API operations, and excluded-operations.json lists the other 2."
}

test_a_missing_operation_fails_with_its_line_and_the_next_step() {
    prepare_coverage
    write_spec <<'EOF'
{
  "servers": [{"url": "https://xquik.com/api/v1"}],
  "paths": {
    "/x/tweets/{id}": {"get": {"operationId": "getTweet"}},
    "/x/community-notes/contributors/{alias}/notes/{noteId}": {"delete": {}},
    "/x/trends/history": {"get": {"operationId": "getXTrendsHistory"}},
    "/x/trends/locations": {"get": {}},
    "/ask": {"servers": [{"url": "https://xquik.com"}], "get": {}, "post": {}}
  }
    assert_equal "" "$(temp_entries)" "the entries left in TMPDIR"
}
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "GET /api/v1/x/trends/history (getXTrendsHistory) is in the API but not in the SDK.
GET /api/v1/x/trends/locations is in the API but not in the SDK.
$missing_next_step"
}

test_an_exclusion_the_api_no_longer_has_fails() {
    prepare_coverage
    exclude <<'EOF'
[
  {"reason": "Searches the Xquik docs.", "operations": ["GET /ask", "POST /ask", "GET /api/v1/old"]}
]
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "excluded-operations.json lists GET /api/v1/old, which the API no longer has. Remove it.
$exclusion_next_step"
}

test_an_exclusion_the_sdk_already_implements_fails() {
    prepare_coverage
    exclude <<'EOF'
[
  {"reason": "Searches the Xquik docs.", "operations": ["GET /ask", "POST /ask"]},
  {"reason": "Not ported yet.", "operations": ["GET /api/v1/x/tweets/{tweetId}"]}
]
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "excluded-operations.json lists GET /api/v1/x/tweets/{tweetId}, which the SDK already implements. Remove it.
$exclusion_next_step"
}

test_an_exclusion_file_that_is_not_json_fails() {
    prepare_coverage
    exclude <<'EOF'
[{"reason": "Broken", "operations": ["GET /ask"]
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "excluded-operations.json is not valid. The file is not valid JSON.
$exclusion_next_step"
}

test_a_missing_exclusion_file_fails() {
    prepare_coverage
    rm -- "$sandbox_repo/excluded-operations.json"

    run_in_repo scripts/api-coverage

    assert_fails_with "excluded-operations.json is not valid. The file does not exist.
$exclusion_next_step"
}

test_an_exclusion_file_with_broken_groups_names_each_problem() {
    prepare_coverage
    exclude <<'EOF'
[
  {"reason": " ", "operations": ["GET /ask"]},
  {"reason": "No operations.", "operations": []},
  {"reason": "Bad entries.", "operations": ["GET/x", 42], "note": "extra"},
  "loose text",
  {"reason": "Repeats.", "operations": ["POST /ask", "POST /ask"]}
]
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "excluded-operations.json is not valid. Group 1 needs a non-empty reason.
excluded-operations.json is not valid. Group 2 needs at least 1 operation.
excluded-operations.json is not valid. Group 3 has the unknown key note.
excluded-operations.json is not valid. Group 3 lists \"GET/x\", which is not an operation such as GET /api/v1/x/trends.
excluded-operations.json is not valid. Group 3 lists 42, which is not an operation such as GET /api/v1/x/trends.
excluded-operations.json is not valid. Group 4 must be an object with a reason and operations.
excluded-operations.json is not valid. POST /ask appears more than once.
$exclusion_next_step"
}

test_an_exclusion_file_that_is_not_an_array_fails() {
    prepare_coverage
    exclude <<'EOF'
{"reason": "Searches the Xquik docs.", "operations": ["GET /ask", "POST /ask"]}
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "excluded-operations.json is not valid. The file must hold a JSON array of groups.
$exclusion_next_step"
}

test_an_operation_listed_twice_with_other_parameter_names_fails() {
    prepare_coverage
    exclude <<'EOF'
[
  {"reason": "Searches the Xquik docs.", "operations": ["GET /ask", "POST /ask"]},
  {"reason": "Old.", "operations": ["GET /api/v1/x/users/{id}"]},
  {"reason": "Older.", "operations": ["GET /api/v1/x/users/{userId}"]}
]
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "excluded-operations.json is not valid. GET /api/v1/x/users/{id} appears more than once.
$exclusion_next_step"
}

test_a_missing_spec_file_fails_with_the_next_step() {
    prepare_coverage
    run_env=("XQUIK_OPENAPI_SPEC=missing.json")

    run_in_repo scripts/api-coverage

    assert_fails_with "$unreadable_spec_line missing.json. $unreadable_spec_next_step"
}

test_a_spec_that_is_not_json_fails_with_the_next_step() {
    prepare_coverage
    write_spec <<'EOF'
openapi: 3.1.0
paths: {}
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "$unreadable_spec_line spec.json. $unreadable_spec_next_step"
}

test_a_spec_without_paths_fails_with_the_next_step() {
    prepare_coverage
    write_spec <<'EOF'
{"openapi": "3.1.0"}
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "$unreadable_spec_line spec.json. $unreadable_spec_next_step"
}

test_an_unreachable_spec_url_fails_with_the_next_step() {
    prepare_coverage
    fake curl <<'EOF'
#!/bin/sh
echo "curl: (6) Could not resolve host" >&2
exit 6
EOF
    run_env=("XQUIK_OPENAPI_SPEC=https://spec.example.test/openapi.json")

    run_in_repo scripts/api-coverage

    assert_fails_with "$unreadable_spec_line https://spec.example.test/openapi.json. $unreadable_spec_next_step"
}

test_the_default_spec_is_the_public_xquik_spec() {
    prepare_coverage
    fake curl <<'EOF'
#!/bin/sh
output=""
while [ $# -gt 0 ]; do
    case "$1" in
        --output) output="$2"; shift ;;
        --) echo "$2" >>"$FAKE_LOGS/curl" ;;
    esac
    shift
done
cp spec.json "$output"
EOF
    run_env=()

    run_in_repo scripts/api-coverage

    assert_passes_with "The SDK covers 2 of 4 API operations, and excluded-operations.json lists the other 2."
    assert_equal "https://xquik.com/openapi.json" "$(log_of curl)" "the fetched spec"
}

test_path_parameter_names_do_not_matter() {
    prepare_coverage
    write_spec <<'EOF'
{
  "servers": [{"url": "https://xquik.com"}],
  "paths": {
    "/api/v1/x/tweets/{tweetId}": {"get": {}},
    "/api/v1/x/community-notes/contributors/{name}/notes/{id}": {"delete": {}},
    "/ask": {"get": {}, "post": {}}
  }
}
EOF

    run_in_repo scripts/api-coverage

    assert_passes_with "The SDK covers 2 of 4 API operations, and excluded-operations.json lists the other 2."
}

test_an_operation_server_wins_over_the_path_and_root_servers() {
    prepare_coverage
    write_spec <<'EOF'
{
  "servers": [{"url": "https://xquik.com/api/v2"}],
  "paths": {
    "/tweets/{id}": {
      "servers": [{"url": "https://xquik.com/api/v3"}],
      "get": {"servers": [{"url": "https://xquik.com/api/v1/x/"}]}
    },
    "/x/community-notes/contributors/{alias}/notes/{noteId}": {
      "servers": [{"url": "https://xquik.com/api/v1"}],
      "delete": {}
    },
    "/ask": {"servers": [{"url": "https://xquik.com"}], "get": {}, "post": {}}
  }
}
EOF

    run_in_repo scripts/api-coverage

    assert_passes_with "The SDK covers 2 of 4 API operations, and excluded-operations.json lists the other 2."
}

test_sdk_operations_that_the_spec_lacks_pass() {
    prepare_coverage
    write_spec <<'EOF'
{
  "servers": [{"url": "https://xquik.com/api/v1"}],
  "paths": {
    "/x/tweets/{id}": {"get": {}},
    "/ask": {"servers": [{"url": "https://xquik.com"}], "get": {}, "post": {}}
  }
}
EOF

    run_in_repo scripts/api-coverage

    assert_passes_with "The SDK covers 1 of 3 API operations, and excluded-operations.json lists the other 2."
}

test_the_base_path_comes_from_the_client_options_constant() {
    prepare_coverage
    write_client_options "https://xquik.com/api/v2/"

    run_in_repo scripts/api-coverage

    assert_fails_with "GET /api/v1/x/tweets/{id} (getTweet) is in the API but not in the SDK.
DELETE /api/v1/x/community-notes/contributors/{alias}/notes/{noteId} (deleteNote) is in the API but not in the SDK.
$missing_next_step"
}

test_a_missing_base_url_constant_fails_with_the_file() {
    prepare_coverage
    write_file "$api_root/core/ClientOptions.kt" <<'EOF'
package com.x_twitter_scraper.api.core

class ClientOptions {
    companion object {

        val PRODUCTION_URL = computeUrl()
    }
}
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "Could not read the default base URL from PRODUCTION_URL in $api_root/core/ClientOptions.kt. Keep it as 1 const val with a string literal."
}

test_path_segments_the_check_cannot_read_fail_with_the_file_and_line() {
    prepare_coverage
    write_file "$api_root/services/async/x/TweetServiceAsyncImpl.kt" <<'EOF'
class TweetServiceAsyncImpl {
    fun retrieve() {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl(clientOptions.baseUrl())
                .addPathSegments("x", segmentFor(params))
                .build()
    }

    fun list() {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl(clientOptions.baseUrl())
                .addPathSegments(
                    "x",
                    TWEETS,
                )
                .build()
    }
}
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "$api_root/services/async/x/TweetServiceAsyncImpl.kt:7 has path segments the check cannot read. Use string literals and params._pathParam(N) only.
$api_root/services/async/x/TweetServiceAsyncImpl.kt:16 has path segments the check cannot read. Use string literals and params._pathParam(N) only."
}

test_a_method_the_check_cannot_read_fails_with_the_file_and_line() {
    prepare_coverage
    write_file "$api_root/services/blocking/AccountServiceImpl.kt" <<'EOF'
class AccountServiceImpl {
    fun retrieve() {
        val request =
            HttpRequest.builder()
                .method(methodFor(params))
                .addPathSegments("account")
                .build()
    }

    fun update() {
        val request =
            HttpRequest.builder()
                .baseUrl(clientOptions.baseUrl())
                .addPathSegments("account")
                .build()
    }

    fun delete() {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .baseUrl(clientOptions.baseUrl())
                .build()
    }

    fun stray() {
        segments.addPathSegments("account")
    }
}
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "$api_root/services/blocking/AccountServiceImpl.kt:5 sets a request method the check cannot read. Write .method(HttpMethod.X) on its own line.
$api_root/services/blocking/AccountServiceImpl.kt:12 builds a request without a .method(HttpMethod.X) line the check can read.
$api_root/services/blocking/AccountServiceImpl.kt:20 builds a request without an .addPathSegments(...) call the check can read.
$api_root/services/blocking/AccountServiceImpl.kt:27 sets a request method or path outside an HttpRequest.builder() chain."
}

test_an_empty_exclusion_file_fails() {
    prepare_coverage
    : >"$sandbox_repo/excluded-operations.json"

    run_in_repo scripts/api-coverage

    assert_fails_with "excluded-operations.json is not valid. The file must hold exactly 1 JSON array of groups.
$exclusion_next_step"
}

test_an_exclusion_file_with_2_values_fails() {
    prepare_coverage
    exclude <<'EOF'
[{"reason": "Searches the Xquik docs.", "operations": ["GET /ask", "POST /ask"]}]
[]
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "excluded-operations.json is not valid. The file must hold exactly 1 JSON array of groups.
$exclusion_next_step"
}

test_a_relative_spec_path_is_read_from_the_folder_the_check_runs_in() {
    prepare_coverage
    mkdir -p "$sandbox_repo/specs"
    mv -- "$sandbox_repo/spec.json" "$sandbox_repo/specs/local.json"
    run_env=("XQUIK_OPENAPI_SPEC=local.json")

    run_in_repo bash -c 'cd specs && ../scripts/api-coverage'

    assert_passes_with "The SDK covers 2 of 4 API operations, and excluded-operations.json lists the other 2."
}

test_a_second_method_or_path_in_1_request_fails_with_the_file_and_line() {
    prepare_coverage
    write_file "$api_root/services/blocking/XServiceImpl.kt" <<'EOF'
class XServiceImpl {
    fun getTrends() {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .baseUrl(clientOptions.baseUrl())
                .addPathSegments("x", "trends")
                .addPathSegments("tweets", "top")
                .build()
    }

    fun getHashflags() {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .method(HttpMethod.POST)
                .addPathSegments("x", "hashflags")
                .build()
    }
}
EOF

    run_in_repo scripts/api-coverage

    assert_fails_with "$api_root/services/blocking/XServiceImpl.kt:8 adds path segments a second time in 1 HttpRequest.builder() chain.
$api_root/services/blocking/XServiceImpl.kt:16 sets a second request method in 1 HttpRequest.builder() chain."
}

run_tests
