#!/usr/bin/env bash

# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

# Runs scripts/codeql in a throwaway repository. A fake stands in for the
# CodeQL CLI. Like the real traced build, it writes build output into the
# folder it scans and stores the source files it compiled in the database.

set -euo pipefail

# shellcheck source=scripts/tests/support.sh
source "$(dirname -- "${BASH_SOURCE[0]}")/support.sh"

prepare_codeql() {
    copy_file scripts/codeql
    write_file buildSrc/build.gradle.kts <<'EOF'
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.20-Beta2")
}
EOF
    write_file example-core/gradle.lockfile <<'EOF'
org.jetbrains.kotlin:kotlin-stdlib:2.4.20-Beta2=kotlinCompilerClasspath
EOF
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
# Stands in for the CodeQL CLI. "database create" records what it was asked
# to scan, leaves build output in the scanned folder and stores the main
# source files in the database. FAKE_CODEQL_SKIPS_KOTLIN leaves the Kotlin
# files out, and FAKE_CODEQL_BUILD_FAILS fails the traced build. "database
# analyze" writes the rows that FAKE_CODEQL_RESULTS holds.
command="$1 $2"
database="$3"
shift 3
case "$command" in
    "database create")
        for argument in "$@"; do
            case "$argument" in
                --source-root=*) source_root="${argument#--source-root=}" ;;
                --command=*) echo "${argument#--command=}" >>"$FAKE_LOGS/codeql-build" ;;
                --language=*) echo "${argument#--language=}" >>"$FAKE_LOGS/codeql-language" ;;
            esac
        done
        if [ -n "${FAKE_CODEQL_BUILD_FAILS:-}" ]; then
            echo "The traced build failed." >&2
            exit 2
        fi
        echo "$source_root" >"$FAKE_LOGS/codeql-source-root"
        cat "$source_root/buildSrc/build.gradle.kts" "$source_root"/*/gradle.lockfile >"$FAKE_LOGS/codeql-kotlin-pins"
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
        for argument in "$@"; do
            case "$argument" in
                --output=*) printf '%s' "${FAKE_CODEQL_RESULTS:-}" >"${argument#--output=}" ;;
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

test_codeql_scans_a_copy_with_stable_kotlin_and_leaves_the_working_tree_alone() {
    local tree_before
    prepare_codeql
    tree_before="$(sandbox_git status --porcelain)"

    run_in_repo scripts/codeql

    assert_equal "" "$run_stderr" "stderr"
    assert_equal 0 "$run_status" "the exit code"
    assert_ends_with "$run_stdout" "CodeQL scanned 2 of 2 Java and Kotlin source files and found no results." "stdout"
    assert_equal "java-kotlin" "$(log_of codeql-language)" "the scanned language"
    assert_equal "codeql/java-queries:codeql-suites/java-security-extended.qls" "$(log_of codeql-suite)" "the query suite"
    assert_equal "./gradlew clean classes --write-verification-metadata sha256 --no-daemon --no-build-cache --no-configuration-cache -Pkotlin.compiler.execution.strategy=in-process" \
        "$(log_of codeql-build)" "the traced build"
    assert_equal 'dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.10")
}
org.jetbrains.kotlin:kotlin-stdlib:2.4.10=kotlinCompilerClasspath' "$(log_of codeql-kotlin-pins)" "the Kotlin pins of the copy"
    assert_equal "./.gitignore
./buildSrc/build.gradle.kts
./example-core/gradle.lockfile
./example-core/src/main/java/Options.java
./example-core/src/main/kotlin/Client.kt
./example-core/src/test/kotlin/ClientTest.kt
./notes-in-progress.txt
./scripts/codeql" "$(log_of codeql-copied-files)" "the copied files"
    assert_not_contains "$(log_of codeql-source-root)" "$sandbox_repo" "the scanned folder"
    assert_equal "$tree_before" "$(sandbox_git status --porcelain)" "the working tree"
    assert_equal 'dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.20-Beta2")
}' "$(cat "$sandbox_repo/buildSrc/build.gradle.kts")" "the Kotlin pin of the working tree"
    assert_equal "" "$(ls "$sandbox/tmp")" "the temporary folder after the run"
}

test_a_codeql_result_fails_the_run_and_is_printed() {
    local result='"Query built from user-controlled sources","A query depends on a user-provided value.","error","/example-core/src/main/kotlin/Client.kt","1","1","1","12"'
    prepare_codeql
    run_env+=("FAKE_CODEQL_RESULTS=$result")

    run_in_repo scripts/codeql

    assert_equal 1 "$run_status" "the exit code"
    assert_ends_with "$run_stdout" "$result" "stdout"
    assert_equal "CodeQL found the results above. Fix each one." "$run_stderr" "stderr"
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
}

run_tests
