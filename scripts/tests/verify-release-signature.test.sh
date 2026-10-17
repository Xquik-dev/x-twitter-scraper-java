#!/usr/bin/env bash

# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

set -euo pipefail

# shellcheck source=scripts/tests/support.sh
source "$(dirname -- "${BASH_SOURCE[0]}")/support.sh"

readonly fingerprint="6965E561C0ACEE32060AB961D2037E4157E62A59"
readonly base_url="https://repo.maven.apache.org/maven2/com/xquik/api/x-twitter-scraper-java/9.9.9"

prepare_verification() {
    copy_file bin/verify-release-signature
    copy_file scripts/lib/temp-paths.bash
    fake curl <<'EOF_FAKE'
#!/bin/sh
previous=""
for argument in "$@"; do
    case "$argument" in https://*) url="$argument" ;; esac
    [ "$previous" = "--output" ] && output="$argument"
    previous="$argument"
done
echo "$url" >>"$FAKE_LOGS/curl"
[ -z "${FAKE_CENTRAL_MISSING:-}" ] || exit 22
echo "not a real artifact" >"$output"
EOF_FAKE
    fake gpg <<'EOF_FAKE'
#!/bin/sh
workspace="${GNUPGHOME%/gnupg}"
echo "$* with GNUPGHOME=${GNUPGHOME:-unset}" | sed "s#$workspace#WORKSPACE#g" >>"$FAKE_LOGS/gpg"
case "$*" in
    *--verify*) echo "[GNUPG:] VALIDSIG $FAKE_SIGNER 2026-01-01 1767225600 0 4 0 1 10 00 $FAKE_SIGNER" ;;
esac
EOF_FAKE
    fake sleep <<'EOF_FAKE'
#!/bin/sh
echo "$*" >>"$FAKE_LOGS/sleep"
EOF_FAKE
    run_env=("FAKE_SIGNER=$fingerprint")
}

test_a_signature_by_the_xquik_key_verifies_and_prints_the_digest() {
    local digest
    prepare_verification
    digest="$(echo "not a real artifact" | shasum -a 256 | awk '{print $1}')"

    run_in_repo bin/verify-release-signature v9.9.9

    assert_equal "" "$run_stderr" "stderr"
    assert_equal 0 "$run_status" "the exit code"
    assert_equal "Verified x-twitter-scraper-java-9.9.9.jar with fingerprint $fingerprint and SHA-256 $digest." \
        "$run_stdout" "stdout"
    assert_equal "$base_url/x-twitter-scraper-java-9.9.9.jar
$base_url/x-twitter-scraper-java-9.9.9.jar.asc" "$(log_of curl)" "the downloads"
    assert_equal "--batch --keyserver hkps://keyserver.ubuntu.com --recv-keys 0xD2037E4157E62A59 with GNUPGHOME=WORKSPACE/gnupg
--batch --status-fd 1 --verify WORKSPACE/x-twitter-scraper-java-9.9.9.jar.asc WORKSPACE/x-twitter-scraper-java-9.9.9.jar with GNUPGHOME=WORKSPACE/gnupg" \
        "$(log_of gpg)" "the gpg calls"
    assert_equal "" "$(log_of sleep)" "the waits"
}

test_a_signature_by_another_key_fails() {
    prepare_verification
    run_env=("FAKE_SIGNER=0000000000000000000000000000000000000000")

    run_in_repo bin/verify-release-signature v9.9.9

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "" "$run_stdout" "stdout"
    assert_equal "The Maven signature does not match the expected Xquik key." "$run_stderr" "stderr"
    assert_equal "" "$(temp_entries)" "the entries left in TMPDIR"
}

test_an_artifact_that_never_appears_fails_after_20_minutes_of_retries() {
    prepare_verification
    run_env+=("FAKE_CENTRAL_MISSING=1")

    run_in_repo bin/verify-release-signature v9.9.9

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "Maven Central did not publish x-twitter-scraper-java-9.9.9.jar within 20 minutes." "$run_stderr" "stderr"
    assert_equal 79 "$(log_of sleep | grep -c '^15$')" "the count of 15 second waits"
    assert_equal "" "$(log_of gpg)" "the gpg calls"
}

test_a_version_without_the_v_prefix_is_refused() {
    prepare_verification

    run_in_repo bin/verify-release-signature 9.9.9

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "Pass a valid v-prefixed release version." "$run_stderr" "stderr"
    assert_equal "" "$(log_of curl)" "the downloads"
}

test_a_failing_step_removes_its_read_only_temp_dir() {
    prepare_verification
    fake gpg < <(temp_step xquik-java-verify)

    run_in_repo bin/verify-release-signature v9.9.9

    assert_equal 37 "$run_status" "the exit code"
    assert_equal "" "$(temp_entries)" "the entries left in TMPDIR"
}

test_a_terminated_run_removes_its_read_only_temp_dir_and_exits_143() {
    prepare_verification
    fake gpg < <(temp_step xquik-java-verify)
    remove_tool sleep
    run_env+=("FAKE_TEMP_STEP_WAIT=1")

    signal_in_repo TERM bin/verify-release-signature v9.9.9

    assert_equal 143 "$run_status" "the exit code"
    assert_equal "" "$(temp_entries)" "the entries left in TMPDIR"
}

run_tests
