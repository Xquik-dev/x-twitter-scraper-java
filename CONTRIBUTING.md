# Contributing

Read [GOVERNANCE.md](GOVERNANCE.md) before proposing major changes.

Follow the shared [Xquik contribution policy][contribution-policy].

## Set up

Install JDK 26, JDK 25, the CodeQL CLI, `uv`, `shellcheck`, `jq`, `curl`, `tar`, `unzip`, `zip`, and `xmllint`.

On macOS, run `brew install jq shellcheck uv` and `brew install --cask codeql`.

Use JDK 26 as `JAVA_HOME`.

Expose JDK 25 to the compatibility tests.

```sh
export SHRINKER_JAVA_HOME="/path/to/jdk-25"
```

The Gradle wrapper resolves locked, checksum-verified dependencies.

After a dependency change, refresh the lockfiles and checksums.

```sh
./gradlew dependencies --write-locks --write-verification-metadata sha256
./gradlew help checkLicense publishAllPublicationsToLocalFileSystemRepository -PpublishLocal --write-verification-metadata sha256
```

Gradle only adds checksums. Delete the entries of replaced versions from `gradle/verification-metadata.xml` by hand.

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
Then it runs the API coverage check, lint, shellcheck, the script tests, REUSE, build, tests, coverage, 30 seconds of Jazzer fuzzing, the dependency audit, the reproducible artifact check, and CodeQL security-extended queries.
It stops at the first failure and says what to fix.
REUSE 6.2.0 runs through `uvx` on every run.
CodeQL and REUSE are required, and any finding fails the run.
A file that CodeQL reads only in part, or skips, fails it too.
CodeQL traces a Gradle build of a copy of the source files, so your working tree and its checksum metadata stay unchanged.
The run fails when a check changed or added files in a clean working tree.
The check and release scripts remove temporary paths on every exit, including failures and signals.
Reports needed by later steps stay under the Git common directory.

The dependency audit checks licenses, then scans every lockfile with OSV Scanner.
It passes the scanner each `gradle.lockfile` and `gradle/verification-metadata.xml` that Git does not ignore, so other worktrees under `.claude/worktrees` stay out.
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
The tests replay only fuzz inputs committed under `src/test/resources`, never the ignored `.cifuzz-corpus` folder, and never reuse a cached test result.
When fuzzing finds a failure, Jazzer saves the input in `RetryAfterFuzzTestInputs` next to the test. Commit it with the fix as a regression input.

Service tests accept literal loopback traffic only.

This guard prevents tests from mutating remote services.

## API coverage

`scripts/api-coverage` runs first in `bin/check-local`, so a release cannot ship an SDK that lags the API.
It compares the operations in the API spec with the requests the SDK sends.
It reads each request from the service `Impl` files, as the `HttpMethod` and the `addPathSegments` call of each `HttpRequest.builder()` chain.
It puts the path of `PRODUCTION_URL` in `ClientOptions.kt` before each SDK path.
An operation is its upper-case method and its absolute path, such as `GET /api/v1/x/trends/history`.
The absolute path joins the URL path of the operation's server with the spec path.
Path parameter names do not matter, so `{id}` and `{tweetId}` match.

The check fails when the API has an operation that the SDK neither sends nor excludes.
Add the operation to the SDK, or list it in `excluded-operations.json` with a reason.
It also fails when the file lists an operation that the API no longer has or that the SDK already sends.
Remove that entry.
SDK operations that the API lacks pass.

`excluded-operations.json` holds a JSON array of groups.
Each group has a non-empty `reason` and at least 1 operation.
An operation appears at most once in the file.

```json
[
  {
    "reason": "Searches the Xquik docs at https://xquik.com/ask, outside the SDK base URL https://xquik.com/api/v1.",
    "operations": ["GET /ask", "POST /ask"]
  }
]
```

The check reads the public spec at https://xquik.com/openapi.json.
Set `XQUIK_OPENAPI_SPEC` to a local JSON file or another URL to check against that copy.
A relative file path is read from the folder you run the check in.

```sh
XQUIK_OPENAPI_SPEC=openapi.json ./scripts/api-coverage
```

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
