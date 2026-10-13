#!/usr/bin/env bash

# SPDX-FileCopyrightText: 2026 Xquik contributors
#
# SPDX-License-Identifier: Apache-2.0

# Runs bin/release-local in a throwaway repository whose origin is a local
# bare repository. Stubs stand in for the checks, Gradle and the signature
# check. Fake commands stand in for curl, the GitHub CLI, gpg and the macOS
# Keychain, so no test can reach Maven Central, GitHub or a real secret.

set -euo pipefail

# shellcheck source=scripts/tests/support.sh
source "$(dirname -- "${BASH_SOURCE[0]}")/support.sh"

# Values that only the fakes hold. A release must never print them or pass
# them as an argument.
readonly token_username="not-a-real-token-username"
readonly token_password="not-a-real-token-password"
readonly signing_passphrase="not-a-real-passphrase"
readonly signing_key="not-a-real-private-key"

readonly keychain_line="MAVEN_KEYCHAIN_SERVICE is unset or empty. Set it to the Keychain service that holds the Central Portal token, then run bin/release-local again."
readonly signing_line="MAVEN_SIGNING_KEYCHAIN_SERVICE is unset or empty. Set it to the Keychain service that holds the signing key passphrase, then run bin/release-local again."
readonly listing="==> Reading the Maven Central listing of com.xquik.api:x-twitter-scraper-java:9.9.9
Group         com.xquik.api
Artifact      x-twitter-scraper-java
Version       9.9.9
Name          Example SDK
Description   Search & export <tweets>.
URL           https://example.com/
License       Example License
License URL   https://example.com/license
Developers    Example Author <author@example.com>
SCM URL       https://example.com/source
SCM link      scm:git:https://example.com/source.git
com.xquik.api:x-twitter-scraper-java:9.9.9 uploads 5 files, each with checksums and an OpenPGP signature.
x-twitter-scraper-java-9.9.9-javadoc.jar holds 1 entry
x-twitter-scraper-java-9.9.9-sources.jar holds 1 entry
x-twitter-scraper-java-9.9.9.jar holds 2 entries
x-twitter-scraper-java-9.9.9.module
x-twitter-scraper-java-9.9.9.pom
Listed 1 module of com.xquik.api at 9.9.9."
readonly local_build="publishAllPublicationsToLocalFileSystemRepository -PpublishLocal --no-build-cache --no-configuration-cache --no-daemon"
readonly upload="publishAndReleaseToMavenCentral --no-build-cache --no-configuration-cache --no-daemon"
readonly release="release create v9.9.9 --repo Xquik-dev/x-twitter-scraper-java --title v9.9.9 --notes-file NOTES --verify-tag --latest"
readonly release_tags="refs/tags/v9.9.9
refs/tags/v9.9.9^{}"

# Writes the files that the Gradle stub publishes into the local repository.
write_maven_fixture() {
    local module_dir="$sandbox/maven-fixture/com/xquik/api/x-twitter-scraper-java/9.9.9"
    local name="x-twitter-scraper-java-9.9.9"
    mkdir -p "$module_dir" "$sandbox/jar/META-INF"
    cat >"$module_dir/$name.pom" <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.xquik.api</groupId>
  <artifactId>x-twitter-scraper-java</artifactId>
  <version>9.9.9</version>
  <name>Example SDK</name>
  ${FIXTURE_DESCRIPTION-<description>Search &amp; export &lt;tweets&gt;.</description>}
  <url>https://example.com/</url>
  <licenses>
    <license>
      <name>Example License</name>
      <url>https://example.com/license</url>
    </license>
  </licenses>
  <developers>
    <developer>
      <name>Example Author</name>
      <email>author@example.com</email>
    </developer>
  </developers>
  <scm>
    <connection>scm:git:https://example.com/source.git</connection>
    <url>https://example.com/source</url>
  </scm>
</project>
EOF
    echo '{}' >"$module_dir/$name.module"
    echo "not a real checksum" >"$module_dir/$name.pom.sha256"
    echo "not a real class" >"$sandbox/jar/Client.class"
    echo "A notice." >"$sandbox/jar/META-INF/LICENSE"
    (
        cd "$sandbox/jar"
        zip -q "$module_dir/$name.jar" Client.class META-INF/LICENSE
        zip -q "$module_dir/$name-sources.jar" META-INF/LICENSE
        zip -q "$module_dir/$name-javadoc.jar" META-INF/LICENSE
    )
}

# Builds a repository on main that matches its origin, with stand-ins for
# every step that would leave the machine.
prepare_release() {
    copy_file bin/release-local
    copy_file scripts/maven-listing
    stub bin/check-local <<'EOF'
#!/bin/sh
# Stands in for bin/check-local.
echo "ran" >>"$FAKE_LOGS/check-local"
EOF
    stub scripts/audit <<'EOF'
#!/bin/sh
# Stands in for scripts/audit.
echo "ran" >>"$FAKE_LOGS/audit"
EOF
    stub bin/verify-release-signature <<'EOF'
#!/bin/sh
# Stands in for the signature check. It fails when FAKE_SIGNATURE_FAILS is set.
echo "$*" >>"$FAKE_LOGS/verify-release-signature"
[ -z "${FAKE_SIGNATURE_FAILS:-}" ]
EOF
    stub gradlew <<'EOF'
#!/bin/sh
# Stands in for Gradle. It records its arguments. The local build copies the
# fixture files into the local repository. The upload records the secrets it
# finds in the environment, as the Maven publish plugin reads them.
echo "$*" >>"$FAKE_LOGS/gradlew"
case "$1" in
    publishAllPublicationsToLocalFileSystemRepository)
        mkdir -p build/local-maven-repo
        cp -R "$FAKE_MAVEN_FIXTURE/." build/local-maven-repo/
        ;;
    publishAndReleaseToMavenCentral)
        {
            echo "mavenCentralUsername=${ORG_GRADLE_PROJECT_mavenCentralUsername:-unset}"
            echo "mavenCentralPassword=${ORG_GRADLE_PROJECT_mavenCentralPassword:-unset}"
            echo "signingInMemoryKey=${ORG_GRADLE_PROJECT_signingInMemoryKey:-unset}"
            echo "signingInMemoryKeyPassword=${ORG_GRADLE_PROJECT_signingInMemoryKeyPassword:-unset}"
        } >>"$FAKE_LOGS/gradlew-secrets"
        ;;
esac
EOF
    write_file build.gradle.kts <<'EOF'
allprojects {
    group = "com.xquik.api"
    version = "9.9.9" // x-release-please-version
}
EOF
    write_file .release-please-manifest.json <<'EOF'
{
  ".": "9.9.9"
}
EOF
    write_file CHANGELOG.md <<'EOF'
# Changelog

## 9.9.9 (2026-01-01)

* Add the first note.

## [9.9.8](https://example.com/compare/v9.9.7...v9.9.8) (2025-12-01)

* Older note.
EOF
    write_file .gitignore <<'EOF'
build/
EOF
    fake curl <<'EOF'
#!/bin/sh
# Stands in for curl. It answers the Maven Central lookup with the HTTP
# status that FAKE_CENTRAL_STATUS names.
for argument in "$@"; do url="$argument"; done
echo "$url" >>"$FAKE_LOGS/curl"
printf '%s' "${FAKE_CENTRAL_STATUS:-404}"
EOF
    fake security <<EOF
#!/bin/sh
# Stands in for the macOS Keychain. It holds the token under the service
# "example-token" and the passphrase under the service "example-signing".
echo "\$*" >>"\$FAKE_LOGS/security"
case "\$*" in
    "find-generic-password -s example-token") echo '    "acct"<blob>="$token_username"' ;;
    "find-generic-password -s example-token -w") echo "$token_password" ;;
    "find-generic-password -s example-signing") echo '    "acct"<blob>="release"' ;;
    "find-generic-password -s example-signing -w") echo "$signing_passphrase" ;;
    *) exit 44 ;;
esac
EOF
    fake gpg <<EOF
#!/bin/sh
# Stands in for gpg. It holds 1 signing key. An export records the
# passphrase it reads from standard input and prints the key.
echo "\$*" >>"\$FAKE_LOGS/gpg"
case "\$*" in
    *--export-secret-keys*)
        cat >>"\$FAKE_LOGS/gpg-stdin"
        echo >>"\$FAKE_LOGS/gpg-stdin"
        echo "$signing_key"
        ;;
esac
EOF
    fake gh <<'EOF'
#!/bin/sh
# Stands in for the GitHub CLI. It is signed in. It records each release
# call and keeps a copy of the notes.
[ "$1" = "release" ] || exit 0
line=""
previous=""
for argument in "$@"; do
    if [ "$previous" = "--notes-file" ]; then
        cp "$argument" "$FAKE_LOGS/notes"
        argument="NOTES"
    fi
    line="$line $argument"
    previous="$argument"
done
echo "${line# }" >>"$FAKE_LOGS/gh"
EOF
    write_maven_fixture
    run_env=("FAKE_MAVEN_FIXTURE=$sandbox/maven-fixture")
    commit_repo
    add_origin
}

origin_tags() {
    sandbox_git ls-remote --tags origin | sed 's/^[^[:space:]]*[[:space:]]*//'
}

assert_nothing_released() {
    assert_equal "" "$(origin_tags)" "the tags on origin"
    assert_not_contains "$(log_of gradlew)" "publishAndReleaseToMavenCentral" "the Gradle calls"
    assert_equal "" "$(log_of gh)" "the GitHub release calls"
}

# Fails when a secret shows in the output or in an argument of any command.
assert_no_secret_leaked() {
    local secret
    for secret in "$token_username" "$token_password" "$signing_passphrase" "$signing_key"; do
        assert_not_contains "$run_stdout$run_stderr" "$secret" "the output"
        assert_not_contains "$(log_of gradlew)$(log_of gpg)$(log_of security)$(log_of gh)$(log_of curl)" \
            "$secret" "the arguments of a command"
    done
}

release_stops_without_a_variable() {
    prepare_release
    run_env+=("$@")

    run_in_repo bin/release-local

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "" "$run_stdout" "stdout"
    assert_equal "" "$(log_of check-local)" "the check runs"
    assert_equal "" "$(log_of security)" "the Keychain calls"
    assert_nothing_released
}

test_a_release_stops_at_once_with_1_line_when_the_token_variable_is_unset() {
    release_stops_without_a_variable "MAVEN_SIGNING_KEYCHAIN_SERVICE=example-signing"
    assert_equal "$keychain_line" "$run_stderr" "stderr"
}

test_a_release_stops_at_once_with_1_line_when_the_token_variable_is_empty() {
    release_stops_without_a_variable "MAVEN_KEYCHAIN_SERVICE=" "MAVEN_SIGNING_KEYCHAIN_SERVICE=example-signing"
    assert_equal "$keychain_line" "$run_stderr" "stderr"
}

test_a_release_stops_at_once_with_1_line_when_the_signing_variable_is_unset() {
    release_stops_without_a_variable "MAVEN_KEYCHAIN_SERVICE=example-token"
    assert_equal "$signing_line" "$run_stderr" "stderr"
}

test_a_release_stops_at_once_with_1_line_when_the_signing_variable_is_empty() {
    release_stops_without_a_variable "MAVEN_KEYCHAIN_SERVICE=example-token" "MAVEN_SIGNING_KEYCHAIN_SERVICE="
    assert_equal "$signing_line" "$run_stderr" "stderr"
}

test_a_dry_run_needs_no_keychain_variable_prints_the_listing_and_releases_nothing() {
    prepare_release

    run_in_repo bin/release-local --dry-run

    assert_equal "" "$run_stderr" "stderr"
    assert_equal 0 "$run_status" "the exit code"
    assert_ends_with "$run_stdout" "==> Building the Maven artifacts for com.xquik.api 9.9.9
$listing
Dry run finished. Nothing was published, tagged or released." "stdout"
    assert_contains "$run_stdout" "Maven Central does not have com.xquik.api 9.9.9 yet. A release uploads it." "stdout"
    assert_equal "ran" "$(log_of check-local)" "the check runs"
    assert_equal "ran" "$(log_of audit)" "the audit runs"
    assert_equal "$local_build" "$(log_of gradlew)" "the Gradle calls"
    assert_equal "" "$(log_of security)" "the Keychain calls"
    assert_equal "" "$(log_of gpg)" "the gpg calls"
    assert_equal "" "$(log_of verify-release-signature)" "the signature checks"
    assert_nothing_released
}

test_a_release_uploads_with_secrets_in_the_environment_then_verifies_tags_and_releases() {
    prepare_release
    run_env+=("MAVEN_KEYCHAIN_SERVICE=example-token" "MAVEN_SIGNING_KEYCHAIN_SERVICE=example-signing")

    run_in_repo bin/release-local

    assert_equal 0 "$run_status" "the exit code"
    assert_contains "$run_stdout" "$listing" "stdout"
    assert_ends_with "$run_stdout" "Released com.xquik.api 9.9.9 to Maven Central and GitHub." "stdout"
    assert_equal "ran" "$(log_of check-local)" "the check runs"
    assert_equal "ran" "$(log_of audit)" "the audit runs"
    assert_equal "$local_build
$upload" "$(log_of gradlew)" "the Gradle calls"
    assert_equal "mavenCentralUsername=$token_username
mavenCentralPassword=$token_password
signingInMemoryKey=$signing_key
signingInMemoryKeyPassword=$signing_passphrase" "$(log_of gradlew-secrets)" "the secrets in the Gradle environment"
    assert_equal "$signing_passphrase" "$(log_of gpg-stdin)" "the passphrase on the standard input of gpg"
    assert_no_secret_leaked
    assert_equal "https://repo.maven.apache.org/maven2/com/xquik/api/x-twitter-scraper-java/9.9.9/x-twitter-scraper-java-9.9.9.pom" \
        "$(log_of curl)" "the Maven Central lookup"
    assert_equal "v9.9.9" "$(log_of verify-release-signature)" "the signature checks"
    assert_equal "$release_tags" "$(origin_tags)" "the tags on origin"
    assert_equal "$release" "$(log_of gh)" "the GitHub release calls"
    assert_equal "
* Add the first note." "$(log_of notes)" "the release notes"
}

test_a_release_skips_the_upload_when_maven_central_already_has_the_version() {
    prepare_release
    run_env+=(
        "MAVEN_KEYCHAIN_SERVICE=example-token"
        "MAVEN_SIGNING_KEYCHAIN_SERVICE=example-signing"
        "FAKE_CENTRAL_STATUS=200"
    )

    run_in_repo bin/release-local

    assert_equal 0 "$run_status" "the exit code"
    assert_contains "$run_stdout" "==> Skipping the upload because Maven Central already has com.xquik.api 9.9.9" "stdout"
    assert_equal "$local_build" "$(log_of gradlew)" "the Gradle calls"
    assert_equal "" "$(log_of security)" "the Keychain calls"
    assert_equal "v9.9.9" "$(log_of verify-release-signature)" "the signature checks"
    assert_equal "$release_tags" "$(origin_tags)" "the tags on origin"
    assert_equal "$release" "$(log_of gh)" "the GitHub release calls"
}

test_a_release_stops_before_the_checks_when_the_keychain_lacks_the_named_item() {
    prepare_release
    run_env+=("MAVEN_KEYCHAIN_SERVICE=another-service" "MAVEN_SIGNING_KEYCHAIN_SERVICE=example-signing")

    run_in_repo bin/release-local

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "The Keychain has no item under the service that MAVEN_KEYCHAIN_SERVICE names. Add the Central Portal token with security add-generic-password -s \"\$MAVEN_KEYCHAIN_SERVICE\" -a <token username> -w, then rerun." \
        "$run_stderr" "stderr"
    assert_equal "" "$(log_of check-local)" "the check runs"
    assert_nothing_released
}

test_a_failed_signature_check_after_the_upload_stops_before_the_tag() {
    prepare_release
    run_env+=(
        "MAVEN_KEYCHAIN_SERVICE=example-token"
        "MAVEN_SIGNING_KEYCHAIN_SERVICE=example-signing"
        "FAKE_SIGNATURE_FAILS=1"
    )

    run_in_repo bin/release-local

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "The published signature did not verify. Do not tag this release." "$run_stderr" "stderr"
    assert_contains "$(log_of gradlew)" "$upload" "the Gradle calls"
    assert_equal "" "$(origin_tags)" "the tags on origin"
    assert_equal "" "$(log_of gh)" "the GitHub release calls"
    assert_no_secret_leaked
}

test_a_central_error_stops_the_release_before_the_checks() {
    prepare_release
    run_env+=(
        "MAVEN_KEYCHAIN_SERVICE=example-token"
        "MAVEN_SIGNING_KEYCHAIN_SERVICE=example-signing"
        "FAKE_CENTRAL_STATUS=503"
    )

    run_in_repo bin/release-local

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "Maven Central answered HTTP 503. Retry later." "$run_stderr" "stderr"
    assert_equal "" "$(log_of check-local)" "the check runs"
    assert_nothing_released
}

test_a_tag_that_origin_already_has_stops_the_run() {
    prepare_release
    sandbox_git tag --annotate v9.9.9 --message v9.9.9
    sandbox_git push --quiet origin refs/tags/v9.9.9
    sandbox_git tag --delete v9.9.9 >/dev/null

    run_in_repo bin/release-local --dry-run

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "Tag v9.9.9 already exists on origin. Bump the version, then rerun." "$run_stderr" "stderr"
    assert_equal "" "$(log_of check-local)" "the check runs"
}

test_a_working_tree_with_changes_stops_the_run() {
    prepare_release
    write_file untracked.txt <<'EOF'
A change.
EOF

    run_in_repo bin/release-local --dry-run

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "The working tree has changes. Commit or remove them, then rerun." "$run_stderr" "stderr"
    assert_equal "" "$(log_of check-local)" "the check runs"
}

test_a_branch_other_than_main_stops_the_run() {
    prepare_release
    sandbox_git switch --quiet --create topic

    run_in_repo bin/release-local --dry-run

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "The current branch is not main. Switch to main, then rerun." "$run_stderr" "stderr"
}

test_a_main_that_origin_lacks_stops_the_run() {
    prepare_release
    write_file extra.txt <<'EOF'
A commit that origin lacks.
EOF
    sandbox_git add --all
    sandbox_git commit --quiet --message "Add a file"

    run_in_repo bin/release-local --dry-run

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "main differs from origin/main. Pull or push main, then rerun." "$run_stderr" "stderr"
}

test_a_version_without_a_changelog_section_stops_the_run() {
    prepare_release
    write_file CHANGELOG.md <<'EOF'
# Changelog

## 9.9.8 (2025-12-01)

* Older note.
EOF
    sandbox_git add --all
    sandbox_git commit --quiet --message "Drop the changelog section"
    sandbox_git push --quiet origin main

    run_in_repo bin/release-local --dry-run

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "CHANGELOG.md has no section for 9.9.9. Add one, then rerun." "$run_stderr" "stderr"
}

test_a_pom_without_a_description_stops_the_run() {
    FIXTURE_DESCRIPTION="" prepare_release

    run_in_repo bin/release-local --dry-run

    assert_equal 1 "$run_status" "the exit code"
    assert_equal "x-twitter-scraper-java-9.9.9.pom has no description. Maven Central requires it. Set it in the publish plugin under buildSrc, then rerun." \
        "$run_stderr" "stderr"
    assert_not_contains "$run_stdout" "Dry run finished." "stdout"
}

test_an_unknown_option_stops_with_the_usage_line() {
    prepare_release

    run_in_repo bin/release-local --force

    assert_equal 2 "$run_status" "the exit code"
    assert_equal "Unknown option --force. Run bin/release-local or bin/release-local --dry-run." "$run_stderr" "stderr"
}

run_tests
