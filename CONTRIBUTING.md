# Contributing

Read [GOVERNANCE.md](GOVERNANCE.md) before proposing major changes.

Follow the shared [Xquik contribution policy][contribution-policy].

## Set up

Install JDK 26, JDK 25, the CodeQL CLI, `uv`, `shellcheck`, `jq`, `curl`, `perl`, `tar`, `unzip`, `zip`, and `xmllint`.

On macOS, run `brew install jq shellcheck uv` and `brew install --cask codeql`.

Use JDK 26 as `JAVA_HOME`.

Expose JDK 25 to the compatibility tests.

```sh
export SHRINKER_JAVA_HOME="/path/to/jdk-25"
```

The Gradle wrapper resolves locked, checksum-verified dependencies.

Never commit credentials or runtime environment files.

## Generated code

Most SDK files come from the public OpenAPI contract.

Preserve generated method names and response contracts.

Avoid generated-file changes when a generator fix exists.

Protect maintained runtime changes with focused regression tests.

## First contributions

Browse issues labeled [`good first issue`][good-first-issues].

Maintainers use that label for bounded documentation and test changes.

Comment on an issue before starting substantial work.

Ask for scope details when acceptance criteria are unclear.

## Verify changes

Run focused tests while editing.

Run every gate before requesting review.

```sh
bin/check-local
```

It checks the tools and both JDKs first.
Then it runs lint, shellcheck, the script tests, REUSE, build, tests, coverage, 30 seconds of Jazzer fuzzing, the dependency audit, the reproducible artifact check, and CodeQL security-extended queries.
It stops at the first failure and says what to fix.
REUSE 6.2.0 runs through `uvx` on every run.
CodeQL and REUSE are required, and any finding fails the run.
CodeQL traces a Gradle build of a copy of the source files, so your working tree and its checksum metadata stay unchanged.
The run fails when a check changed or added files in a clean working tree.

The dependency audit checks licenses, then scans every lockfile with OSV Scanner.
It downloads a checksum-verified OSV Scanner unless `OSV_SCANNER_BIN` names one.
It fails on any finding in a dependency that a published module ships at runtime.
It also fails on a development-only finding unless `audit-exceptions.json` lists it and no fix exists.
Severity never excuses a finding.
Each entry names the advisory, the package path, the reason, and a recheck date at most 30 days out.
A listed finding blocks again on its recheck date, and as soon as a fixed version exists.

```json
[
  {
    "advisory": "GHSA-xxxx-xxxx-xxxx",
    "path": "kotlinBouncyCastleConfiguration > org.example:library",
    "reason": "build-time only",
    "recheck": "2026-11-12"
  }
]
```

The last `path` element must match the vulnerable `group:artifact`.
The reason is `build-time only` or `peer dependency provided by the host`.

The script tests in `scripts/tests` run each script in a throwaway folder with fake commands.
Run them alone with `./scripts/test-scripts`.

With push access, `bin/check-local` posts the `xquik-local-checks` commit status for a clean, pushed `HEAD`.
The status lists only the checks that ran, and it reports success only after every check passed.
Pass `--no-status` to skip the status.

Run a single gate with its script in `scripts/`.

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

## Report security issues

Never disclose suspected vulnerabilities in public issues.

Follow [SECURITY.md](SECURITY.md) for private reporting.

## Releases

Maintainers release from a maintained macOS machine with `bin/release-local` after the release commit reaches `main`.

GitHub Actions does not publish packages.

The script refuses unless `main` is clean and matches `origin/main`.
It reads the version from `build.gradle.kts` and refuses when its `v*` tag already exists.
It runs `bin/check-local` and the dependency audit, then builds the Maven artifacts.
It signs and uploads them to Maven Central, or skips the upload when Maven Central already has that version.
It verifies the published signature, then pushes the tag.
Last, it creates the GitHub release from the matching CHANGELOG section.

Run `bin/release-local --dry-run` first.
It runs every check, builds the artifacts, and prints the coordinates, the POM listing fields, and the files of each module.
It uploads, tags, and releases nothing.

The Central Portal token and the signing key passphrase come from 2 macOS Keychain items.
Set `MAVEN_KEYCHAIN_SERVICE` on the release machine to the service name of the token item.
Its account holds the token username, and its password holds the token password.
Set `MAVEN_SIGNING_KEYCHAIN_SERVICE` to the service name of the passphrase item.
The signing key stays in the local GPG keyring.
A release stops at once when either variable is unset or empty.
A dry run needs neither.
Each secret reaches Gradle and gpg through the environment or standard input, never as an argument.

[contribution-policy]: https://github.com/Xquik-dev/.github/blob/main/CONTRIBUTING.md
[good-first-issues]: https://github.com/Xquik-dev/x-twitter-scraper-java/labels/good%20first%20issue
[review-policy]: https://github.com/Xquik-dev/.github/blob/main/REVIEWING.md

Xquik is an independent third-party service. Not affiliated with X Corp. "Twitter" and "X" are trademarks of X Corp.
