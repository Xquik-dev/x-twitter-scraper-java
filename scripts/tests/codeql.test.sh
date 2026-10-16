#!/usr/bin/env bash

# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

set -euo pipefail

# shellcheck source=scripts/tests/support.sh
source "$(dirname -- "${BASH_SOURCE[0]}")/support.sh"

prepare_codeql() {
    copy_file scripts/codeql
    copy_file scripts/lib/temp-paths.bash
    write_file example-core/src/main/kotlin/Client.kt <<'EOF'
class Client
EOF
    write_file example-core/src/main/java/Options.java <<'EOF'
class Options {}
EOF
    write_file example-core/src/test/kotlin/ClientTest.kt <<'EOF'
class ClientTest
EOF
    write_file .gitignore <<'EOF'
build/
EOF
    write_file example-core/build/classes/Stale.class <<'EOF'
Stale build output.
EOF
    fake codeql <<'EOF'
#!/bin/sh
if [ "$1 $2" = "version --format=terse" ]; then
    echo "${FAKE_CODEQL_VERSION:-2.27.2}"
    exit 0
fi
command="$1 $2"
database="$3"
shift 3
case "$command" in
    "pack install")
        echo "$database" >>"$FAKE_LOGS/codeql-pack-install"
        ;;
    "database create")
        for argument in "$@"; do
            case "$argument" in
                --source-root=*) source_root="${argument#--source-root=}" ;;
                --command=*) echo "${argument#--command=}" >>"$FAKE_LOGS/codeql-build" ;;
                --language=*) echo "${argument#--language=}" >>"$FAKE_LOGS/codeql-language" ;;
            esac
        done
        if [ -n "${FAKE_CODEQL_BUILD_FAILS:-}" ]; then
            mkdir -p "$database/cache"
            echo "Read-only cache." >"$database/cache/entry"
            chmod -R a-w "$database"
            echo "The traced build failed." >&2
            exit 2
        fi
        echo "$source_root" >"$FAKE_LOGS/codeql-source-root"
        (cd "$source_root" && find . -type f | LC_ALL=C sort) >"$FAKE_LOGS/codeql-copied-files"
        echo "Build output." >"$source_root/build-output.txt"
        mkdir -p "$database"
        (
            cd "$source_root" || exit 1
            if [ -n "${FAKE_CODEQL_SKIPS_KOTLIN:-}" ]; then
                find . -path '*/src/main/*' -name '*.java'
            else
                find . -path '*/src/main/*' \( -name '*.kt' -o -name '*.java' \)
            fi | zip -q "$database/src.zip" -@
        )
        ;;
    "database analyze")
        echo "$1" >>"$FAKE_LOGS/codeql-suite"
        echo "$2" >>"$FAKE_LOGS/codeql-comment-queries"
        report='{"runs":[{"tool":{"driver":{"name":"CodeQL","notifications":[{"id":"java/diagnostics/extraction-errors"},{"id":"java/diagnostics/extraction-warnings"}]}},"invocations":[{"toolExecutionNotifications":[],"executionSuccessful":true}],"results":[]}]}'
        [ -z "${FAKE_CODEQL_REPORT:-}" ] || report="$FAKE_CODEQL_REPORT"
        report="$(printf '%s' "$report" | sed "s|SOURCE|$(cat "$FAKE_LOGS/codeql-source-root")|g")"
        for argument in "$@"; do
            case "$argument" in
                --output=*) printf '%s' "$report" >"${argument#--output=}" ;;
            esac
        done
        ;;
esac
EOF
    commit_repo
    write_file notes-in-progress.txt <<'EOF'
A file that is new and not ignored.
EOF
}

test_codeql_scans_a_copy_and_leaves_the_working_tree_alone() {
    local tree_before
    prepare_codeql
    tree_before="$(sandbox_git status --porcelain)"

    run_in_repo scripts/codeql

    assert_equal "" "$run_stderr" "stderr"
    assert_equal 0 "$run_status" "the exit code"
    assert_ends_with "$run_stdout" "CodeQL scanned 2 of 2 Java and Kotlin source files and found no results." "stdout"
    assert_equal "java-kotlin" "$(log_of codeql-language)" "the scanned language"
    assert_equal "codeql/java-queries@1.11.12:codeql-suites/java-security-extended.qls" "$(log_of codeql-suite)" "the query suite"
    assert_equal "codeql/no-code-comments" "$(log_of codeql-pack-install)" "the installed comment queries"
    assert_equal "codeql/no-code-comments" "$(log_of codeql-comment-queries)" "the comment queries"
    assert_equal "./gradlew clean classes --no-daemon --no-build-cache --no-configuration-cache -Pkotlin.compiler.execution.strategy=in-process" \
        "$(log_of codeql-build)" "the traced build"
    assert_equal "./.gitignore
./example-core/src/main/java/Options.java
./example-core/src/main/kotlin/Client.kt
./example-core/src/test/kotlin/ClientTest.kt
./notes-in-progress.txt
./scripts/codeql" "$(log_of codeql-copied-files)" "the copied files"
    assert_not_contains "$(log_of codeql-source-root)" "$sandbox_repo" "the scanned folder"
    assert_equal "$tree_before" "$(sandbox_git status --porcelain)" "the working tree"
    assert_equal "" "$(ls "$sandbox/tmp")" "the temporary folder after the run"
}

test_a_codeql_result_fails_the_run_and_is_printed() {
    prepare_codeql
    run_env+=('FAKE_CODEQL_REPORT={"runs":[{"tool":{"driver":{"notifications":[{"id":"java/diagnostics/extraction-errors"},{"id":"java/diagnostics/extraction-warnings"}]}},"invocations":[{"toolExecutionNotifications":[],"executionSuccessful":true}],"results":[{"ruleId":"java/sql-injection","message":{"text":"A query depends on a user-provided value."},"locations":[{"physicalLocation":{"artifactLocation":{"uri":"example-core/src/main/kotlin/Client.kt"},"region":{"startLine":12}}}]}]}]}')

    run_in_repo scripts/codeql

    assert_equal 1 "$run_status" "the exit code"
    assert_ends_with "$run_stdout" "java/sql-injection at example-core/src/main/kotlin/Client.kt:12. A query depends on a user-provided value." "stdout"
    assert_equal "CodeQL found the results above. Fix each one." "$run_stderr" "stderr"
}

test_a_file_that_codeql_could_not_read_fails_the_run_and_is_named() {
    prepare_codeql
    run_env+=('FAKE_CODEQL_REPORT={"runs":[{"tool":{"driver":{"notifications":[{"id":"java/diagnostics/extraction-errors"},{"id":"java/diagnostics/extraction-warnings"}]}},"invocations":[{"toolExecutionNotifications":[{"message":{"text":"Extraction incomplete in file: SOURCE/example-core/src/main/kotlin/Client.kt"},"level":"error","descriptor":{"id":"java/diagnostics/extraction-errors"}}],"executionSuccessful":true}],"results":[]}]}')

    run_in_repo scripts/codeql

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "Extraction incomplete in file: example-core/src/main/kotlin/Client.kt
CodeQL could not read the Java or Kotlin code named above, so the scan is incomplete. Fix that code so it compiles, then rerun." \
        "$run_stderr" "stderr"
}

test_a_scan_without_the_extraction_diagnostics_fails_the_run() {
    prepare_codeql
    run_env+=('FAKE_CODEQL_REPORT={"runs":[{"tool":{"driver":{"notifications":[{"id":"java/diagnostics/successfully-extracted-files"}]}},"invocations":[{"toolExecutionNotifications":[],"executionSuccessful":true}],"results":[]}]}')

    run_in_repo scripts/codeql

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "The CodeQL scan lacks java/diagnostics/extraction-errors and java/diagnostics/extraction-warnings, so it cannot show that it read every file. Make the suite in scripts/codeql run each missing diagnostic query." \
        "$run_stderr" "stderr"
}

test_a_codeql_cli_at_another_version_stops_the_run() {
    prepare_codeql
    run_env+=("FAKE_CODEQL_VERSION=2.28.0")

    run_in_repo scripts/codeql

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "CodeQL 2.28.0 found, but this check pins 2.27.2. Install CodeQL 2.27.2 from https://github.com/github/codeql-cli-binaries/releases/tag/v2.27.2, then rerun." \
        "$run_stderr" "stderr"
    assert_equal "" "$(log_of codeql-source-root)" "the scanned folder"
}

test_a_build_that_compiles_no_kotlin_file_fails_the_run() {
    prepare_codeql
    run_env+=("FAKE_CODEQL_SKIPS_KOTLIN=1")

    run_in_repo scripts/codeql

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "CodeQL scanned 1 of 2 Java and Kotlin source files. Fix the build above so it compiles every file." \
        "$run_stderr" "stderr"
    assert_equal "" "$(log_of codeql-suite)" "the query runs"
}

test_a_failing_traced_build_fails_the_run() {
    prepare_codeql
    run_env+=("FAKE_CODEQL_BUILD_FAILS=1")

    run_in_repo scripts/codeql

    assert_equal 2 "$run_status" "the exit code"
    assert_equal "The traced build failed." "$run_stderr" "stderr"
    assert_equal "" "$(log_of codeql-suite)" "the query runs"
    assert_equal "" "$(temp_entries)" "the entries left in TMPDIR"
}

run_tests
