# OpenSSF Best Practices Evidence

This register tracks the Gold assessment for this repository.

The official entry is [bestpractices.dev project 13735][badge].

Assessment date: 2026-07-24.

## Eligibility

This active, public Java SDK qualifies for the OpenSSF Best Practices badge.

## Verified Technical Controls

| Area | Evidence |
| --- | --- |
| License | Apache-2.0 and REUSE 3.3 metadata |
| Contribution process | DCO sign-off and independent review rules |
| Governance | Public roles, decisions, releases, and continuity policy |
| Security reporting | Private reporting, response targets, boundaries, and threat model |
| Runtime compatibility | Java 8 bytecode with JDK 26 tests |
| Functional tests | 1,418 tests across 329 suites with no skips |
| Line coverage | `./scripts/coverage` enforces 90% |
| Branch coverage | `./scripts/coverage` enforces 80% |
| Static analysis | Compiler checks, formatting checks, and CodeQL |
| Dynamic analysis | Jazzer fuzzes untrusted retry headers for 30 seconds |
| Dependency integrity | Lockfiles and SHA-256 verification metadata |
| Dependency review | Dependabot, OSV Scanner, and an explicit license policy |
| Licensing gate | Pinned REUSE action checks every repository file |
| Reproducibility | 2 isolated builds produce 15 byte-identical Maven artifacts |
| Release integrity | Maven Central provides OpenPGP signatures for all 15 artifacts |
| CI | Pull requests and pushes run pinned, least-privilege workflows |
| Two-factor authentication | The Xquik-dev organization requires 2FA |

The maintained-source gate covers 1,198 of 1,319 executable lines (90.83%).

It covers 424 of 520 branches, or 81.54%.

The raw report covers 104,652 of 110,632 generated-inclusive lines (94.59%) and 27,560 of 30,010 branches (91.84%).

Exclusions use the repository-owned, provider-neutral generated-source header prefix.

Maintained runtime exceptions remain inside the enforced coverage gate.

Generated service tests use a loopback transport.

They exercise route construction, request serialization, and response handling.

Model tests validate generated parsing and builder behavior.

The default transport rejects redirects that could forward credentials.

Retry delays reject invalid values and cap server-provided delays.

The locked dependency scan reports zero known vulnerabilities.

The license report covers 100 resolved runtime and test components.

Jazzer completed 3,544,654 retry-header iterations during this assessment.

Maven Central published `v0.10.2` from the exact release tag.

All 15 public files verify with this OpenPGP fingerprint:

`6965 E561 C0AC EE32 060A B961 D203 7E41 57E6 2A59`

The root JAR SHA-256 is:

`7c0ba8741e41eae3c13f5d47e91e100668862b1ae03f57832bfa513e9e5b2393`

## Outstanding Gold Blockers

Human and organizational evidence remains incomplete.

Do not claim Gold while any mandatory criterion remains unmet.

| Gold Requirement | Current Evidence | Required Action |
| --- | --- | --- |
| Access continuity | Public evidence does not prove 2 release-capable maintainers | Grant and verify another maintainer's access |
| Bus factor | Git history shows one significant contributor | Add another significant contributor |
| Unassociated contributors | Fewer than 2 qualifying contributors are independent | Accept qualifying external contributions |
| Independent review | History does not prove 50% qualifying review coverage | Require and record independent reviews |
| Human security review | No completed review exists within 5 years | Commission and publish a scoped review |
| Generated code coverage | Gold does not explicitly exempt generated code | Confirm applicability or raise generated-inclusive coverage |

Gold eligibility still requires review by a different human.

## Maintenance

Run these evidence commands before releases:

```sh
./scripts/lint
./scripts/test
./scripts/coverage
./scripts/audit
reuse lint
./scripts/check-reproducible
```

Reassess the register before every major release.

Update bestpractices.dev only with public evidence.

[badge]: https://www.bestpractices.dev/projects/13735

Xquik is an independent third-party service. Not affiliated with X Corp. "Twitter" and "X" are trademarks of X Corp.
