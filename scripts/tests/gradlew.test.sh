#!/usr/bin/env bash

# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

set -euo pipefail

# shellcheck source=scripts/tests/support.sh
source "$(dirname -- "${BASH_SOURCE[0]}")/support.sh"

readonly url="https://services.gradle.org/distributions/gradle-9.9.9-bin.zip"

sha256_of() {
    if command -v sha256sum >/dev/null 2>&1; then
        sha256sum "$1" | awk '{print $1}'
    else
        shasum -a 256 "$1" | awk '{print $1}'
    fi
}

prepare_wrapper() {
    local pinned="$1"
    copy_file gradlew
    mkdir -p "$sandbox/fixture/gradle-9.9.9/bin"
    cat >"$sandbox/fixture/gradle-9.9.9/bin/gradle" <<'EOF_FAKE'
#!/bin/sh
echo "Gradle 9.9.9 ran with $*"
EOF_FAKE
    chmod 755 "$sandbox/fixture/gradle-9.9.9/bin/gradle"
    (cd -- "$sandbox/fixture" && zip -qr "$sandbox/gradle-9.9.9-bin.zip" gradle-9.9.9)
    archive_sha256="$(sha256_of "$sandbox/gradle-9.9.9-bin.zip")"
    if [[ "$pinned" == "archive" ]]; then
        pinned="distributionSha256Sum=$archive_sha256"
    fi
    write_file gradle/wrapper/gradle-wrapper.properties <<EOF
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
$pinned
distributionUrl=https\\://services.gradle.org/distributions/gradle-9.9.9-bin.zip
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
EOF
    fake curl <<'EOF_FAKE'
#!/bin/sh
previous=""
for argument in "$@"; do
    case "$argument" in https://*) url="$argument" ;; esac
    [ "$previous" = "--output" ] && output="$argument"
    previous="$argument"
done
echo "$url" >>"$FAKE_LOGS/curl"
[ -z "${FAKE_DOWNLOAD_FAILS:-}" ] || exit 22
cp "$FAKE_ARCHIVE" "$output"
EOF_FAKE
    run_env=("FAKE_ARCHIVE=$sandbox/gradle-9.9.9-bin.zip")
}

installed_root() {
    echo "$sandbox/home/.gradle/wrapper/dists/gradle-9.9.9-bin/$1"
}

test_the_first_run_installs_the_pinned_distribution_and_runs_it() {
    prepare_wrapper archive

    run_in_repo ./gradlew build --offline

    assert_equal "" "$run_stderr" "stderr"
    assert_equal 0 "$run_status" "the exit code"
    assert_equal "Gradle 9.9.9 ran with build --offline" "$run_stdout" "stdout"
    assert_equal "$url" "$(log_of curl)" "the downloads"
    assert_equal "gradle-9.9.9" "$(ls -A "$(installed_root "$archive_sha256")")" "the install folder"
}

test_a_later_run_reuses_the_install_without_downloading() {
    prepare_wrapper archive
    run_in_repo ./gradlew help

    run_in_repo ./gradlew test

    assert_equal 0 "$run_status" "the exit code"
    assert_equal "Gradle 9.9.9 ran with test" "$run_stdout" "stdout"
    assert_equal "$url" "$(log_of curl)" "the downloads"
}

test_an_archive_with_another_checksum_is_refused_and_not_installed() {
    local pinned="0000000000000000000000000000000000000000000000000000000000000000"
    prepare_wrapper "distributionSha256Sum=$pinned"

    run_in_repo ./gradlew build

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "" "$run_stdout" "stdout"
    assert_equal "$url has SHA-256 $archive_sha256, not the pinned $pinned. Nothing was installed." \
        "$run_stderr" "stderr"
    assert_equal "" "$(ls -A "$(installed_root "$pinned")")" "the install folder"

    run_in_repo ./gradlew build

    assert_equal 1 "$run_status" "the exit code of the second run"
    assert_equal "$url
$url" "$(log_of curl)" "the downloads"
}

test_a_failed_download_installs_nothing() {
    prepare_wrapper archive
    run_env+=("FAKE_DOWNLOAD_FAILS=1")

    run_in_repo ./gradlew build

    assert_equal 22 "$run_status" "the exit code"
    assert_equal "" "$run_stdout" "stdout"
    assert_equal "" "$(ls -A "$(installed_root "$archive_sha256")")" "the install folder"
}

test_properties_without_a_checksum_are_refused_before_any_download() {
    prepare_wrapper ""

    run_in_repo ./gradlew build

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "$(cd -- "$sandbox_repo" && pwd -P)/gradle/wrapper/gradle-wrapper.properties must set distributionUrl and distributionSha256Sum." \
        "$run_stderr" "stderr"
    assert_equal "" "$(log_of curl)" "the downloads"
}

run_tests
