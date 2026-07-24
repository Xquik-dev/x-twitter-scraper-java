# Contributing

Thank you for improving the Xquik Java SDK.

Read [GOVERNANCE.md](GOVERNANCE.md) before proposing major changes.

Follow the shared [Xquik contribution policy][contribution-policy].

## Set Up

Install JDK 26, JDK 25, `curl`, `tar`, and `unzip`.

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
./scripts/lint
./scripts/test
./scripts/coverage
OSV_SCANNER_BIN=/path/to/osv-scanner ./scripts/audit
reuse lint
./scripts/check-reproducible
```

The audit script downloads a verified OSV Scanner when needed.

Maintained-source line coverage must remain at least 90%.

Maintained-source branch coverage must remain at least 80%.

The raw report keeps generated-source coverage visible.

Skipped tests are forbidden.

Add regression tests for every corrected defect.

Service tests accept literal loopback traffic only.

This guard prevents tests from mutating remote services.

## Submit Changes

Keep pull requests focused.

Explain user-visible behavior and public contract effects.

Link relevant issues and public API contracts.

Use clear Conventional Commit subjects when practical.

Sign every commit with the Developer Certificate of Origin:

```sh
git commit --signoff
```

Another human must review maintainer-authored, nontrivial changes.

Reviewers follow the shared [review policy][review-policy].

Address every review comment before merging.

## Report Security Issues

Never disclose suspected vulnerabilities in public issues.

Follow [SECURITY.md](SECURITY.md) for private reporting.

## Releases

Publish an immutable `v*` release after its commit reaches `main`.

Verify the tag, changelog, audit, licensing, and reproducible artifacts.

[contribution-policy]: https://github.com/Xquik-dev/.github/blob/main/CONTRIBUTING.md
[good-first-issues]: https://github.com/Xquik-dev/x-twitter-scraper-java/labels/good%20first%20issue
[review-policy]: https://github.com/Xquik-dev/.github/blob/main/REVIEWING.md

Xquik is an independent third-party service. Not affiliated with X Corp. "Twitter" and "X" are trademarks of X Corp.
