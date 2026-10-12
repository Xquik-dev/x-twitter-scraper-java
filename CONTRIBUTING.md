# Contributing

Read [GOVERNANCE.md](GOVERNANCE.md) before proposing major changes.

Follow the shared [Xquik contribution policy][contribution-policy].

## Set Up

Install JDK 26, JDK 25, `curl`, `tar`, `unzip`, and `shellcheck`.

Install `reuse` to run the licensing check.

Use JDK 26 as `JAVA_HOME`.

Expose JDK 25 to the compatibility tests:

```sh
export SHRINKER_JAVA_HOME="/path/to/jdk-25"
```

The Gradle wrapper resolves locked, checksum-verified dependencies.

Never commit credentials or runtime environment files.

## Generated Code

Most SDK files come from the public OpenAPI contract.

Preserve generated method names and response contracts.

Avoid generated-file changes when a generator fix exists.

Protect maintained runtime changes with focused regression tests.

## First Contributions

Browse issues labeled [`good first issue`][good-first-issues].

Maintainers use that label for bounded documentation and test changes.

Comment on an issue before starting substantial work.

Ask for scope details when acceptance criteria are unclear.

## Verify Changes

Run focused tests while editing.

Run every gate before requesting review:

```sh
bin/check-local
```

It runs these checks in order and stops at the first failure:

1. JDK setup
2. Java and Kotlin formatting (`./scripts/lint`)
3. ShellCheck on `bin/` and `scripts/`
4. REUSE licensing (`reuse lint`), skipped when `reuse` is not installed
5. Build (`./scripts/build`)
6. Tests without skips (`./scripts/test`)
7. Coverage (`./scripts/coverage`)
8. 30 seconds of Jazzer fuzzing on retry headers
9. Dependency licenses and vulnerabilities (`./scripts/audit`)
10. Reproducible Maven artifacts (`./scripts/check-reproducible`)

The failure line names the check and the next step.

It posts the result as the `xquik-local-checks` commit status on GitHub.

It posts only for a clean tree whose commit is already pushed.

Pass `--no-status` to skip the status.

The audit downloads a verified OSV Scanner unless `OSV_SCANNER_BIN` names one.

GitHub Actions does not run these checks. Run them before you push.

Maintained-source line coverage must remain at least 90%.

Maintained-source branch coverage must remain at least 80%.

The raw report keeps generated-source coverage visible.

Skipped tests are forbidden.

Add regression tests for every corrected defect.

Service tests accept literal loopback traffic only.

This guard prevents tests from mutating remote services.

## Submit changes

Use clear Conventional Commit subjects and sign commits with `git commit --signoff`.
Follow the shared [review policy][review-policy].

## Report Security Issues

Never disclose suspected vulnerabilities in public issues.

Follow [SECURITY.md](SECURITY.md) for private reporting.

## Releases

Maintainers release from a maintained macOS machine with `bin/release-local`.

GitHub Actions does not publish packages.

The script refuses unless `main` is clean and matches `origin/main`.

It refuses a version whose `v*` tag already exists.

It runs `bin/check-local` and the dependency audit, then builds the artifacts.

It signs and uploads them to Maven Central, unless Central already has that version.

It reads the Central token and signing passphrase from the macOS Keychain.

It verifies the published signature, then pushes the tag.

It creates the GitHub release from the version's `CHANGELOG.md` section.

[contribution-policy]: https://github.com/Xquik-dev/.github/blob/main/CONTRIBUTING.md
[good-first-issues]: https://github.com/Xquik-dev/x-twitter-scraper-java/labels/good%20first%20issue
[review-policy]: https://github.com/Xquik-dev/.github/blob/main/REVIEWING.md

Xquik is an independent third-party service. Not affiliated with X Corp. "Twitter" and "X" are trademarks of X Corp.
