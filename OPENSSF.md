# OpenSSF Best Practices Evidence

This register tracks the Gold assessment for this repository.

The official entry is [bestpractices.dev project 13735][badge].

Assessment date: 2026-07-23.

## Eligibility

This public Java SDK is active and released.

It is eligible for the OpenSSF Best Practices badge.

No OpenSSF-defined ineligibility applies.

## Verified Technical Controls

| Area | Evidence |
| --- | --- |
| License | Apache-2.0 and REUSE 3.3 metadata |
| Contribution process | DCO sign-off and independent review rules |
| Governance | Public roles, decisions, releases, and continuity policy |
| Security reporting | Private reporting, response targets, boundaries, and threat model |
| Runtime compatibility | Java 8 bytecode with JDK 26 tests |
| Functional tests | 1,342 tests across 316 suites with no skips |
| Line coverage | `./scripts/coverage` enforces 90% |
| Branch coverage | `./scripts/coverage` enforces 80% |
| Static analysis | Compiler checks, formatting checks, and CodeQL |
| Dynamic analysis | Jazzer fuzzes untrusted retry headers for 30 seconds |
| Dependency integrity | Lockfiles and SHA-256 verification metadata |
| Dependency review | Dependabot, OSV Scanner, and an explicit license policy |
| Licensing gate | Pinned REUSE action checks every repository file |
| Reproducibility | 2 isolated builds produce 15 byte-identical Maven artifacts |
| CI | Pull requests and pushes run pinned, least-privilege workflows |
| Two-factor authentication | The Xquik-dev organization requires 2FA |

The maintained-source gate covers 1,194 of 1,319 executable lines.

That result is 90.52% line coverage.

It covers 420 of 520 branches, or 80.77%.

The raw report keeps untouched generated-source coverage visible.

It covers 37,702 of 91,257 generated-inclusive lines, or 41.31%.

It covers 5,220 of 23,952 generated-inclusive branches, or 21.79%.

Exclusions require the exact Stainless marker within the source header.

Maintained runtime exceptions remain inside the enforced coverage gate.

Generated service tests use a loopback transport.

They exercise route construction, request serialization, and response handling.

Model tests validate generated parsing and builder behavior.

The default transport rejects redirects that could forward credentials.

Retry delays reject invalid values and cap server-provided delays.

The locked dependency scan reports zero known vulnerabilities.

The license report covers 100 resolved runtime and test components.

Jazzer completed 3,544,654 retry-header iterations during this assessment.

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

This remediation pull request needs a different human reviewer.

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
