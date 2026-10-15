#!/usr/bin/env bash

# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

set -euo pipefail

# shellcheck source=scripts/tests/support.sh
source "$(dirname -- "${BASH_SOURCE[0]}")/support.sh"

readonly runtime_package="com.example:shipped"
readonly development_package="com.example:build-tool"
readonly advisory="GHSA-aaaa-bbbb-cccc"

day_from_today() {
    jq -nr --argjson days "$1" 'now + $days * 86400 | strftime("%Y-%m-%d")'
}

prepare_audit() {
    copy_file scripts/audit
    stub gradlew <<'EOF'
#!/bin/sh
echo "$*" >>"$FAKE_LOGS/gradlew"
[ -z "${FAKE_LICENSE_FAILS:-}" ]
EOF
    write_file x-twitter-scraper-java-core/gradle.lockfile <<EOF
$runtime_package:1.0.0=compileClasspath,runtimeClasspath,testRuntimeClasspath
$development_package:2.0.0=dokkaHtmlGeneratorRuntimeResolver~internal
empty=
EOF
    write_file x-twitter-scraper-java/gradle.lockfile <<'EOF'
empty=
EOF
    write_file x-twitter-scraper-java-client-okhttp/gradle.lockfile <<'EOF'
empty=
EOF
    write_file audit-exceptions.json <<'EOF'
[]
EOF
    cat >"$sandbox/osv-scanner" <<'EOF'
#!/bin/sh
echo "$*" >>"$FAKE_LOGS/osv-scanner"
if [ -n "${FAKE_OSV_EXIT:-}" ]; then
    echo "The scan broke." >&2
    exit "$FAKE_OSV_EXIT"
fi
if [ -z "${FAKE_OSV_PACKAGE:-}" ]; then
    echo '{"results":[]}'
    exit 0
fi
jq -n \
    --arg name "$FAKE_OSV_PACKAGE" \
    --arg version "$FAKE_OSV_VERSION" \
    --arg advisory "$FAKE_OSV_ADVISORY" \
    --arg severity "$FAKE_OSV_SEVERITY" \
    --arg fixed "${FAKE_OSV_FIXED:-}" '
    {results: [{
        source: {path: "x-twitter-scraper-java-core/gradle.lockfile", type: "lockfile"},
        packages: [{
            package: {name: $name, version: $version, ecosystem: "Maven"},
            groups: [{ids: [$advisory], aliases: ["CVE-2026-00001", $advisory], max_severity: $severity}],
            vulnerabilities: [{
                id: $advisory,
                aliases: ["CVE-2026-00001"],
                affected: [{
                    package: {ecosystem: "Maven", name: $name},
                    ranges: [{
                        type: "ECOSYSTEM",
                        events: ([{introduced: "0"}] + (if $fixed == "" then [] else [{fixed: $fixed}] end))
                    }]
                }]
            }]
        }]
    }]}'
exit 1
EOF
    chmod 755 "$sandbox/osv-scanner"
    run_env=("OSV_SCANNER_BIN=$sandbox/osv-scanner")
    sandbox_git init --quiet --initial-branch=main
}

report_finding() {
    run_env+=(
        "FAKE_OSV_PACKAGE=$1"
        "FAKE_OSV_VERSION=$2"
        "FAKE_OSV_ADVISORY=$advisory"
        "FAKE_OSV_SEVERITY=$3"
        "FAKE_OSV_FIXED=$4"
    )
}

list_exception() {
    write_file audit-exceptions.json <<EOF
[
  {
    "advisory": "$advisory",
    "path": "dokkaHtmlGeneratorRuntimeResolver~internal > $1",
    "reason": "build-time only",
    "recheck": "$2"
  }
]
EOF
}

assert_blocked() {
    assert_equal 1 "$run_status" "the exit code"
    assert_equal "$1" "$run_stdout" "stdout"
    assert_equal "The audit blocked 1 findings. Upgrade the packages above." "$run_stderr" "stderr"
}

readonly audit_start="==> Checking audit-exceptions.json
==> Checking dependency licenses
==> Auditing locked dependencies"

runtime_finding_blocks() {
    prepare_audit
    list_exception "$runtime_package" "$(day_from_today 10)"
    report_finding "$runtime_package" 1.0.0 "$1" ""

    run_in_repo scripts/audit

    assert_blocked "$audit_start
$runtime_package 1.0.0 (CVE-2026-00001,$advisory) blocks because a published module ships it at runtime. Upgrade it."
}

test_a_low_finding_in_a_shipped_dependency_blocks_even_when_listed_and_unfixable() {
    runtime_finding_blocks 2.1
}

test_a_moderate_finding_in_a_shipped_dependency_blocks_even_when_listed_and_unfixable() {
    runtime_finding_blocks 5.3
}

test_a_critical_finding_in_a_shipped_dependency_blocks_even_when_listed_and_unfixable() {
    runtime_finding_blocks 9.8
}

development_finding_with_a_fix_blocks() {
    prepare_audit
    list_exception "$development_package" "$(day_from_today 10)"
    report_finding "$development_package" 2.0.0 "$1" 2.0.1

    run_in_repo scripts/audit

    assert_blocked "$audit_start
$development_package 2.0.0 (CVE-2026-00001,$advisory) blocks because a fixed version exists. Upgrade it."
}

test_a_low_development_finding_with_a_fix_blocks_even_when_listed() {
    development_finding_with_a_fix_blocks 2.1
}

test_a_high_development_finding_with_a_fix_blocks_even_when_listed() {
    development_finding_with_a_fix_blocks 8.7
}

test_an_unfixable_development_finding_blocks_when_no_exception_lists_it() {
    prepare_audit
    report_finding "$development_package" 2.0.0 2.1 ""

    run_in_repo scripts/audit

    assert_blocked "$audit_start
$development_package 2.0.0 (CVE-2026-00001,$advisory) blocks because audit-exceptions.json does not list it."
}

test_an_exception_for_another_package_excuses_nothing() {
    prepare_audit
    list_exception "com.example:other" "$(day_from_today 10)"
    report_finding "$development_package" 2.0.0 2.1 ""

    run_in_repo scripts/audit

    assert_blocked "$audit_start
$development_package 2.0.0 (CVE-2026-00001,$advisory) blocks because audit-exceptions.json does not list it."
}

test_a_listed_unfixable_development_finding_passes_until_its_recheck_date() {
    local recheck
    prepare_audit
    recheck="$(day_from_today 10)"
    list_exception "$development_package" "$recheck"
    report_finding "$development_package" 2.0.0 9.8 ""

    run_in_repo scripts/audit

    assert_equal "" "$run_stderr" "stderr"
    assert_equal 0 "$run_status" "the exit code"
    assert_equal "$audit_start
$development_package 2.0.0 (CVE-2026-00001,$advisory) passes until $recheck. It has no fix and no published module ships it.
Dependency licenses and vulnerabilities passed policy." "$run_stdout" "stdout"
}

test_a_listed_development_finding_blocks_again_on_its_recheck_date() {
    local recheck
    prepare_audit
    recheck="$(day_from_today 0)"
    list_exception "$development_package" "$recheck"
    report_finding "$development_package" 2.0.0 2.1 ""

    run_in_repo scripts/audit

    assert_blocked "$audit_start
$development_package 2.0.0 (CVE-2026-00001,$advisory) blocks because its recheck date $recheck has come. Review it again."
}

test_an_exception_with_a_recheck_date_more_than_30_days_out_stops_the_audit() {
    prepare_audit
    list_exception "$development_package" "$(day_from_today 32)"
    report_finding "$development_package" 2.0.0 2.1 ""

    run_in_repo scripts/audit

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "audit-exceptions.json is invalid. Each entry needs an advisory, a path, an allowed reason and a recheck date no later than $(day_from_today 30)." \
        "$run_stderr" "stderr"
    assert_equal "" "$(log_of osv-scanner)" "the scanner calls"
}

test_an_exception_with_an_unknown_reason_stops_the_audit() {
    prepare_audit
    write_file audit-exceptions.json <<EOF
[{"advisory": "$advisory", "path": "$development_package", "reason": "low risk", "recheck": "$(day_from_today 10)"}]
EOF

    run_in_repo scripts/audit

    assert_equal 1 "$run_status" "the exit code"
    assert_contains "$run_stderr" "audit-exceptions.json is invalid." "stderr"
    assert_equal "" "$(log_of osv-scanner)" "the scanner calls"
}

test_a_report_without_findings_passes_with_an_empty_exceptions_list() {
    prepare_audit

    run_in_repo scripts/audit

    assert_equal "" "$run_stderr" "stderr"
    assert_equal 0 "$run_status" "the exit code"
    assert_equal "$audit_start
Dependency licenses and vulnerabilities passed policy." "$run_stdout" "stdout"
    assert_equal "scan source --no-ignore --format json --lockfile=x-twitter-scraper-java-client-okhttp/gradle.lockfile --lockfile=x-twitter-scraper-java-core/gradle.lockfile --lockfile=x-twitter-scraper-java/gradle.lockfile" \
        "$(log_of osv-scanner)" "the scanner call"
    assert_equal "checkLicense --no-parallel --no-configuration-cache --no-build-cache" "$(log_of gradlew)" "the Gradle call"
}

test_the_scan_reads_the_lockfiles_and_checksum_metadata_that_git_does_not_ignore() {
    prepare_audit
    write_file .gitignore <<'EOF'
.claude/worktrees/
build/
EOF
    write_file .claude/worktrees/other/x-twitter-scraper-java-core/gradle.lockfile <<'EOF'
empty=
EOF
    write_file x-twitter-scraper-java-core/build/tmp/gradle.lockfile <<'EOF'
empty=
EOF
    write_file buildSrc/gradle.lockfile <<'EOF'
empty=
EOF
    write_file gradle/verification-metadata.xml <<'EOF'
<verification-metadata/>
EOF

    run_in_repo scripts/audit

    assert_equal 0 "$run_status" "the exit code"
    assert_equal "scan source --no-ignore --format json --lockfile=buildSrc/gradle.lockfile --lockfile=gradle/verification-metadata.xml --lockfile=x-twitter-scraper-java-client-okhttp/gradle.lockfile --lockfile=x-twitter-scraper-java-core/gradle.lockfile --lockfile=x-twitter-scraper-java/gradle.lockfile" \
        "$(log_of osv-scanner)" "the scanner call"
}

test_a_checkout_without_lockfiles_stops_before_the_scan() {
    prepare_audit
    rm -- "$sandbox_repo"/x-twitter-scraper-java*/gradle.lockfile

    run_in_repo scripts/audit

    assert_equal 1 "$run_status" "the exit code"
    assert_ends_with "$run_stderr" "Found no gradle.lockfile to audit. Run the audit from a Git checkout of the repository." "stderr"
    assert_equal "" "$(log_of osv-scanner)" "the scanner calls"
}

test_a_scanner_error_blocks() {
    prepare_audit
    run_env+=("FAKE_OSV_EXIT=127")

    run_in_repo scripts/audit

    assert_equal 1 "$run_status" "the exit code"
    assert_ends_with "$run_stderr" "OSV Scanner failed with exit code 127. Fix the error above, then rerun." "stderr"
}

test_a_license_failure_blocks_before_the_scan() {
    prepare_audit
    run_env+=("FAKE_LICENSE_FAILS=1")

    run_in_repo scripts/audit

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "" "$(log_of osv-scanner)" "the scanner calls"
}

run_tests
