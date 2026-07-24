# X (Twitter) Scraper Java SDK: Tweet Search, Timelines, Followers & Posting

[![CI](https://github.com/Xquik-dev/x-twitter-scraper-java/actions/workflows/ci.yml/badge.svg)](https://github.com/Xquik-dev/x-twitter-scraper-java/actions/workflows/ci.yml)
[![OpenSSF Best Practices](https://www.bestpractices.dev/projects/13735/badge)](https://www.bestpractices.dev/projects/13735)

Use Xquik's typed Java client for X data and confirmed actions.

It supports tweet search, timeline extraction, follower exports, monitoring, and posting.

Use it as a typed X API or Twitter API alternative.

[API reference](https://docs.xquik.com/api-reference/overview) ·
[Authentication](https://xquik.com/auth.md) ·
[Javadocs](https://javadoc.io/doc/com.xquik.api/x-twitter-scraper-java)

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.xquik.api/x-twitter-scraper-java)](https://central.sonatype.com/artifact/com.xquik.api/x-twitter-scraper-java/0.5.2)
[![Javadocs](https://javadoc.io/badge2/com.xquik.api/x-twitter-scraper-java/0.5.2/javadoc.svg)](https://javadoc.io/doc/com.xquik.api/x-twitter-scraper-java/0.5.2)

<!-- x-release-please-end -->

## Common X Data Tasks

These questions map customer language to exact routes and Java services.

| Customer Question | REST Route | Java Service |
| --- | --- | --- |
| How do I search tweets without the X API? | `GET /x/tweets/search` | `client.x().tweets()` |
| How do I retrieve tweets, threads, replies, or quotes? | `GET /x/tweets/{id}`, `GET /x/tweets/{id}/thread` | `client.x().tweets()` |
| How do I search X or Twitter users? | `GET /x/users/search` | `client.x().users()` |
| How do I scrape an X profile timeline? | `GET /x/users/{id}/tweets` | `client.x().users()` |
| How do I export X followers? | `GET /x/users/{id}/followers` | `client.x().users()` |
| How do I export X following accounts? | `GET /x/users/{id}/following` | `client.x().users()` |
| How do I collect verified followers? | `GET /x/users/{id}/verified-followers` | `client.x().users()` |
| How do I collect mentions, likes, replies, or media? | `GET /x/users/{id}/mentions`, `GET /x/users/{id}/likes` | `client.x().users()` |
| How do I extract my X home timeline? | `GET /x/timeline` | `client.x()` |
| How do I extract list tweets, members, or followers? | `GET /x/lists/{id}/tweets`, `GET /x/lists/{id}/members` | `client.x().lists()` |
| How do I search communities and collect their tweets? | `GET /x/communities/search`, `GET /x/communities/{id}/tweets` | `client.x().communities()` |
| How do I read bookmarks and bookmark folders? | `GET /x/bookmarks`, `GET /x/bookmarks/folders` | `client.x().bookmarks()` |
| How do I read notifications or direct messages? | `GET /x/notifications`, `GET /x/dm/{userId}/history` | `client.x()`, `client.x().dm()` |
| How do I discover X trends? | `GET /x/trends` | `client.x().getTrends()` |
| How do I export large X datasets? | `POST /extractions` | `client.extractions()` |
| How do I monitor tweet keywords or accounts? | `POST /monitors/keywords`, `POST /monitors` | `client.monitors()` |
| How do I receive signed event deliveries? | `POST /webhooks` | `client.webhooks()` |
| How do I post, like, retweet, or follow? | `POST /x/tweets`, `POST /x/users/{id}/follow` | `client.x().tweets()`, `client.x().users()` |
| How do I send media or update a profile? | `POST /x/media`, `PATCH /x/profile` | `client.x().media()`, `client.x().profile()` |
| How do I manage connected X accounts? | `GET /x/accounts`, `POST /x/accounts` | `client.x().accounts()` |

Use [Javadocs](https://javadoc.io/doc/com.xquik.api/x-twitter-scraper-java) for typed methods.

Use [API reference](https://docs.xquik.com/api-reference/overview) for request contracts.

## Install

<!-- x-release-please-start-version -->

Gradle:

```kotlin
implementation("com.xquik.api:x-twitter-scraper-java:0.5.2")
```

Maven:

```xml
<dependency>
  <groupId>com.xquik.api</groupId>
  <artifactId>x-twitter-scraper-java</artifactId>
  <version>0.5.2</version>
</dependency>
```

<!-- x-release-please-end -->

## Authenticate

Create an API key in the Xquik dashboard. Then set:

```bash
export X_TWITTER_SCRAPER_API_KEY="your-api-key"
```

OAuth users can set `X_TWITTER_SCRAPER_BEARER_TOKEN` instead.

Create 1 client and reuse it:

```java
import com.x_twitter_scraper.api.client.XTwitterScraperClient;
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient;

XTwitterScraperClient client = XTwitterScraperOkHttpClient.fromEnv();
```

You can also pass credentials directly:

```java
XTwitterScraperClient client = XTwitterScraperOkHttpClient.builder()
    .apiKey("your-api-key")
    .build();
```

Supported client settings:

| Setting | System Property | Environment Variable | Default |
| --- | --- | --- | --- |
| API key | `xtwitterscraper.apiKey` | `X_TWITTER_SCRAPER_API_KEY` | None |
| OAuth token | `xtwitterscraper.bearerToken` | `X_TWITTER_SCRAPER_BEARER_TOKEN` | None |
| Base URL | `xtwitterscraper.baseUrl` | `X_TWITTER_SCRAPER_BASE_URL` | `https://xquik.com/api/v1` |

System properties override environment variables.

## Search Posts

```java
import com.x_twitter_scraper.api.models.PaginatedTweets;
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams;

TweetSearchParams params = TweetSearchParams.builder()
    .q("from:elonmusk")
    .limit(10L)
    .build();

PaginatedTweets result = client.x().tweets().search(params);
```

Close the client when your application stops:

```java
client.close();
```

## Use Async Calls

Call `async()` to receive `CompletableFuture` results:

```java
import java.util.concurrent.CompletableFuture;

CompletableFuture<PaginatedTweets> result =
    client.async().x().tweets().search(params);
```

## Configure Retries

The client retries eligible failures twice by default.

```java
XTwitterScraperClient client = XTwitterScraperOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

Xquik may still return a successful HTTP response with a structured API error.
Handle the documented error code from the response body.

## Read Raw Responses

Use `withRawResponse()` when you need headers or status codes:

```java
import com.x_twitter_scraper.api.core.http.HttpResponseFor;
import com.x_twitter_scraper.api.models.account.AccountRetrieveResponse;

HttpResponseFor<AccountRetrieveResponse> response =
    client.account().withRawResponse().retrieve();

int status = response.statusCode();
AccountRetrieveResponse account = response.parse();
```

Binary endpoints return `HttpResponse`. Close each response after reading it.

## Support

- API questions: [docs.xquik.com](https://docs.xquik.com)
- Security reports: [SECURITY.md](SECURITY.md)
- SDK defects: [GitHub Issues](https://github.com/Xquik-dev/x-twitter-scraper-java/issues)
- Contributions: [CONTRIBUTING.md](CONTRIBUTING.md)
- Governance: [GOVERNANCE.md](GOVERNANCE.md)
- OpenSSF evidence: [OPENSSF.md](OPENSSF.md)

## License

[Apache License 2.0](LICENSE)

Xquik is an independent third-party service. Not affiliated with X Corp. "Twitter" and "X" are trademarks of X Corp.
