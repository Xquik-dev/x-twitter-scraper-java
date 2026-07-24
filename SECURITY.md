# Security Policy

## Supported Versions

| Version | Supported |
| --- | --- |
| Latest Maven Central release | Yes |
| Older releases | No |

Upgrade before reporting behavior already fixed in the latest release.

## Report a Vulnerability

Use [GitHub private vulnerability reporting][private-report].

Email [support@xquik.com](mailto:support@xquik.com) if GitHub is unavailable.

Do not open a public issue for suspected vulnerabilities.

Include affected versions, impact, reproduction steps, and suggested fixes.

Exclude secrets, personal data, and data from unrelated accounts.

## Response Process

We aim to acknowledge reports within 3 business days.

We aim to complete initial triage within 7 business days.

We provide updates at least every 14 days during active remediation.

Validated reports receive a severity assessment and disclosure plan.

Fix timing depends on severity, exploitability, and release safety.

## Scope

Security-sensitive areas include:

- API key and OAuth token handling
- Request construction, redirects, retries, and uploads
- Response parsing and error handling
- Generated and maintained runtime code
- Dependencies, build inputs, and published Maven artifacts
- CI, release metadata, and documentation examples

Service availability and upstream platform behavior remain outside this repository.

## Threat Model

Protected assets include credentials, response data, and package integrity.

Callers, local configuration, network services, and release systems cross trust boundaries.

The client assumes a trusted HTTPS base URL.

The client must not forward credentials through redirects.

Untrusted responses must not create unbounded retries or delays.

Release inputs must remain pinned, verified, and auditable.

## Disclosure and Releases

Coordinate public disclosure with the maintainers.

Maintainers may use a private advisory and request a CVE.

Validated fixes require tests, independent review, and a patched release.

The advisory or changelog records affected and fixed versions.

## Safe Harbor

We support good-faith research that follows this policy.

Avoid privacy violations, service disruption, and unauthorized persistence.

Use the minimum access needed to demonstrate the issue.

Report findings promptly and allow reasonable remediation time.

We will not pursue action for research following these conditions.

[private-report]: https://github.com/Xquik-dev/x-twitter-scraper-java/security/advisories/new

Xquik is an independent third-party service. Not affiliated with X Corp. "Twitter" and "X" are trademarks of X Corp.
