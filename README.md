# X (Twitter) Scraper Java SDK: Tweet Search, Timelines, Followers & Posting

[![OpenSSF Best Practices](https://www.bestpractices.dev/projects/13735/badge)](https://www.bestpractices.dev/projects/13735)

Use Xquik's typed Java client for X data and confirmed actions.

[API reference](https://docs.xquik.com/api-reference/overview) ·
[Authentication](https://xquik.com/auth.md) ·
[Javadocs](https://javadoc.io/doc/com.xquik.api/x-twitter-scraper-java)

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.xquik.api/x-twitter-scraper-java)](https://central.sonatype.com/artifact/com.xquik.api/x-twitter-scraper-java/0.5.1)
[![Javadocs](https://javadoc.io/badge2/com.xquik.api/x-twitter-scraper-java/0.5.1/javadoc.svg)](https://javadoc.io/doc/com.xquik.api/x-twitter-scraper-java/0.5.1)

<!-- x-release-please-end -->

## Common X Data Tasks

Use the linked Javadocs for typed method names.

| Customer Question | REST Route | Workflow Note |
| --- | --- | --- |
| How do I search tweets? | `GET /x/tweets/search` | Use keyword or advanced operator queries. |
| How do I read a profile timeline? | `GET /x/users/{id}/tweets` | Paginate bounded results. |
| How do I scrape followers? | `GET /x/users/{id}/followers` | Use an extraction for complete datasets. |
| How do I scrape following accounts? | `GET /x/users/{id}/following` | Use an extraction for complete datasets. |
| How do I read my home timeline? | `GET /x/timeline` | Approve this private read. |
| How do I monitor an account? | `POST /monitors` | Deliver events through HMAC webhooks. |
| How do I post or reply? | `POST /x/tweets` | Confirm the account and payload. |

## Install

<!-- x-release-please-start-version -->

Gradle:

```kotlin
implementation("com.xquik.api:x-twitter-scraper-java:0.5.1")
```

Maven:

```xml
<dependency>
  <groupId>com.xquik.api</groupId>
  <artifactId>x-twitter-scraper-java</artifactId>
  <version>0.5.1</version>
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

## License

[Apache License 2.0](LICENSE)

Xquik is an independent third-party service. Not affiliated with X Corp. "Twitter" and "X" are trademarks of X Corp.
