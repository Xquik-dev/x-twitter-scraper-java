#!/usr/bin/env bash

# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

set -euo pipefail

# shellcheck source=scripts/tests/support.sh
source "$(dirname -- "${BASH_SOURCE[0]}")/support.sh"

readonly check_order="api-coverage
lint
shellcheck
test-scripts
uvx
build
test
coverage
fuzz
audit
check-reproducible
codeql"
readonly passed_line="Passed API coverage, lint, shellcheck, script tests, REUSE, build, 12 tests, coverage, fuzzing, audit, reproducible artifacts and CodeQL."

prepare_checks() {
    local name
    copy_file bin/check-local
    for name in api-coverage lint test-scripts build coverage fuzz audit check-reproducible codeql; do
        stub "scripts/$name" <<EOF
#!/usr/bin/env bash
echo "$name" >>"\$FAKE_LOGS/order"
[[ "\${FAKE_FAILING_CHECK:-}" != "$name" ]]
EOF
    done
    stub scripts/test <<'EOF'
#!/usr/bin/env bash
echo "test" >>"$FAKE_LOGS/order"
echo "Verified 12 tests across 3 suites with 0 failures, 0 errors and 0 skipped."
[[ "${FAKE_FAILING_CHECK:-}" != "test" ]]
EOF
    fake shellcheck <<'EOF'
#!/bin/sh
echo "shellcheck" >>"$FAKE_LOGS/order"
echo "$*" >>"$FAKE_LOGS/shellcheck"
EOF
    fake uvx <<'EOF'
#!/bin/sh
echo "uvx" >>"$FAKE_LOGS/order"
echo "$*" >>"$FAKE_LOGS/uvx"
EOF
    fake codeql <<'EOF'
#!/bin/sh
exit 0
EOF
    fake java <<'EOF'
#!/bin/sh
echo "openjdk version \"${FAKE_JAVA_VERSION:-26.0.1}\" 2026-04-21" >&2
EOF
    fake gh <<'EOF'
#!/bin/sh
case "$*" in
    "api repos/Xquik-dev/x-twitter-scraper-java/commits/"*)
        [ -z "${FAKE_GH_UNKNOWN_COMMIT:-}" ]
        exit $?
        ;;
esac
state=""
description=""
for argument in "$@"; do
    case "$argument" in
        repos/*) endpoint="$argument" ;;
        state=*) state="${argument#state=}" ;;
        description=*) description="${argument#description=}" ;;
    esac
done
echo "$endpoint $state $description" >>"$FAKE_LOGS/gh"
EOF
    mkdir -p "$sandbox/jdk25"
    echo 'JAVA_VERSION="25.0.1"' >"$sandbox/jdk25/release"
    run_env=("SHRINKER_JAVA_HOME=$sandbox/jdk25")
    commit_repo
}

test_a_passing_run_lists_the_checks_in_order_and_runs_reuse_through_uvx() {
    prepare_checks

    run_in_repo bin/check-local --no-status

    assert_equal "" "$run_stderr" "stderr"
    assert_equal 0 "$run_status" "the exit code"
    assert_ends_with "$run_stdout" "$passed_line" "stdout"
    assert_contains "$run_stdout" "Commit status not posted because --no-status was passed." "stdout"
    assert_equal "$check_order" "$(log_of order)" "the order of the checks"
    assert_equal "--from reuse==6.2.0 reuse lint" "$(log_of uvx)" "the uvx call"
    assert_equal "" "$(log_of gh)" "the posted statuses"
}

test_shellcheck_reads_every_bash_script_and_skips_other_files() {
    prepare_checks
    stub scripts/tests/sample.test.sh <<'EOF'
#!/usr/bin/env bash
exit 0
EOF
    write_file scripts/notes.txt <<'EOF'
Not a script.
EOF
    sandbox_git add --all
    sandbox_git commit --quiet --message "Add files"

    run_in_repo bin/check-local --no-status

    assert_equal 0 "$run_status" "the exit code"
    assert_equal "--external-sources bin/check-local scripts/api-coverage scripts/audit scripts/build scripts/check-reproducible scripts/codeql scripts/coverage scripts/fuzz scripts/lint scripts/test scripts/test-scripts scripts/tests/sample.test.sh" \
        "$(log_of shellcheck)" "the shellcheck call"
}

test_a_clean_pushed_head_gets_a_pending_status_then_a_success_status() {
    local head
    prepare_checks
    head="$(sandbox_git rev-parse HEAD)"

    run_in_repo bin/check-local

    assert_equal "" "$run_stderr" "stderr"
    assert_equal 0 "$run_status" "the exit code"
    assert_equal "repos/Xquik-dev/x-twitter-scraper-java/statuses/$head pending Local checks are running.
repos/Xquik-dev/x-twitter-scraper-java/statuses/$head success $passed_line" \
        "$(log_of gh)" "the posted statuses"
}

test_a_working_tree_with_changes_gets_no_status() {
    prepare_checks
    write_file untracked.txt <<'EOF'
A change.
EOF

    run_in_repo bin/check-local

    assert_equal 0 "$run_status" "the exit code"
    assert_contains "$run_stdout" "Commit status not posted because the working tree has changes." "stdout"
    assert_equal "" "$(log_of gh)" "the posted statuses"
}

test_a_commit_that_github_lacks_gets_no_status() {
    prepare_checks
    run_env+=("FAKE_GH_UNKNOWN_COMMIT=1")

    run_in_repo bin/check-local

    assert_equal 0 "$run_status" "the exit code"
    assert_contains "$run_stdout" "Commit status not posted because GitHub has no commit" "stdout"
    assert_equal "" "$(log_of gh)" "the posted statuses"
}

test_a_run_without_uv_stops_even_when_another_reuse_is_installed() {
    prepare_checks
    remove_tool uvx
    fake reuse <<'EOF'
#!/bin/sh
echo "reuse" >>"$FAKE_LOGS/order"
EOF

    run_in_repo bin/check-local --no-status

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "Check failed at Required tools. Install uv with brew install uv, then rerun." "$run_stderr" "stderr"
    assert_equal "" "$(log_of order)" "the checks that ran"
}

test_a_run_without_the_codeql_cli_stops_with_the_install_command() {
    prepare_checks
    remove_tool codeql

    run_in_repo bin/check-local --no-status

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "Check failed at Required tools. Install the CodeQL CLI with brew install --cask codeql, then rerun." \
        "$run_stderr" "stderr"
    assert_equal "" "$(log_of order)" "the checks that ran"
}

test_a_run_on_the_wrong_jdk_stops_before_any_check() {
    prepare_checks
    run_env+=("FAKE_JAVA_VERSION=21.0.4")

    run_in_repo bin/check-local --no-status

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "Check failed at JDK setup. Set JAVA_HOME to JDK 26 and SHRINKER_JAVA_HOME to JDK 25, then rerun." \
        "$run_stderr" "stderr"
    assert_equal "" "$(log_of order)" "the checks that ran"
}

test_an_api_coverage_failure_stops_the_run_before_the_slow_checks() {
    prepare_checks
    run_env+=("FAKE_FAILING_CHECK=api-coverage")

    run_in_repo bin/check-local --no-status

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "Check failed at API coverage. Fix the API coverage lines above, then rerun." "$run_stderr" "stderr"
    assert_equal "api-coverage" "$(log_of order)" "the checks that ran"
}

test_a_failing_check_stops_the_run_and_posts_a_failure_status_that_names_it() {
    local head
    prepare_checks
    head="$(sandbox_git rev-parse HEAD)"
    run_env+=("FAKE_FAILING_CHECK=test")

    run_in_repo bin/check-local

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "Check failed at Tests. Fix the failing or skipped tests above, then rerun." "$run_stderr" "stderr"
    assert_equal "api-coverage
lint
shellcheck
test-scripts
uvx
build
test" "$(log_of order)" "the checks that ran"
    assert_equal "repos/Xquik-dev/x-twitter-scraper-java/statuses/$head pending Local checks are running.
repos/Xquik-dev/x-twitter-scraper-java/statuses/$head failure Failed at Tests." \
        "$(log_of gh)" "the posted statuses"
}

test_a_codeql_failure_posts_a_failure_status_and_no_success() {
    local head
    prepare_checks
    head="$(sandbox_git rev-parse HEAD)"
    run_env+=("FAKE_FAILING_CHECK=codeql")

    run_in_repo bin/check-local

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "Check failed at CodeQL security-extended queries. Fix the CodeQL error or results above, then rerun." \
        "$run_stderr" "stderr"
    assert_equal "repos/Xquik-dev/x-twitter-scraper-java/statuses/$head pending Local checks are running.
repos/Xquik-dev/x-twitter-scraper-java/statuses/$head failure Failed at CodeQL security-extended queries." \
        "$(log_of gh)" "the posted statuses"
}

test_a_check_that_changes_the_tree_fails_the_run() {
    local head
    prepare_checks
    stub scripts/coverage <<'EOF'
#!/usr/bin/env bash
echo "coverage" >>"$FAKE_LOGS/order"
echo "left behind" >leftover.txt
EOF
    sandbox_git add --all
    sandbox_git commit --quiet --message "Use a check that changes the tree"
    head="$(sandbox_git rev-parse HEAD)"

    run_in_repo bin/check-local

    assert_equal 1 "$run_status" "the exit code"
    assert_contains "$run_stdout" "?? leftover.txt" "stdout"
    assert_equal "Check failed at Unchanged working tree. A check changed or added the files above. Fix that check so it leaves the tree alone, then rerun." \
        "$run_stderr" "stderr"
    assert_equal "repos/Xquik-dev/x-twitter-scraper-java/statuses/$head pending Local checks are running.
repos/Xquik-dev/x-twitter-scraper-java/statuses/$head failure Failed at Unchanged working tree." \
        "$(log_of gh)" "the posted statuses"
}

test_an_unknown_option_stops_with_the_usage_line() {
    prepare_checks

    run_in_repo bin/check-local --fast

    assert_equal 2 "$run_status" "the exit code"
    assert_equal "Unknown option --fast. Run bin/check-local or bin/check-local --no-status." "$run_stderr" "stderr"
    assert_equal "" "$(log_of order)" "the checks that ran"
}

run_tests
