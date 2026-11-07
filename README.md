# X API & Twitter API Java SDK by Xquik

Use this Twitter API Java SDK by Xquik to search tweets with typed builders.
Each call runs synchronously or returns a `CompletableFuture`.
Public reads need no X developer account.

Xquik is the world's fastest and cheapest X Twitter scraper service with the most complete X data.
Most other Apify Actors charge before filtering or deduplication.
Xquik charges only for delivered, unique, filter-matching results and never pads rows.
Xquik is independent and not affiliated with X Corp.

<!-- trust:win:start -->
The Xquik REST API read 45 tweets per second at $0.15 per 1,000 on 2026-10-15. The fastest of 4 rival Actors read 12.5 per second. The cheapest cost $0.173 per 1,000. [Compare each run](https://xquik.com/benchmarks#benchmark-x-tweet-scraper).
<!-- trust:win:end -->

## Install the Twitter API Java SDK

Add the Gradle dependency.

```kotlin
implementation("com.xquik.api:x-twitter-scraper-java:0.10.3")
```

Or add the Maven dependency.

```xml
<dependency>
  <groupId>com.xquik.api</groupId>
  <artifactId>x-twitter-scraper-java</artifactId>
  <version>0.10.3</version>
</dependency>
```

## Scrape tweets with the Twitter Java client

Set `X_TWITTER_SCRAPER_API_KEY`, then run this search.

```java
import com.x_twitter_scraper.api.client.XTwitterScraperClient;
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient;
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchParams;
import com.x_twitter_scraper.api.models.x.tweets.TweetSearchResponse;

XTwitterScraperClient client = XTwitterScraperOkHttpClient.fromEnv();

TweetSearchParams params = TweetSearchParams.builder()
    .q("from:elonmusk")
    .limit(10L)
    .build();

TweetSearchResponse result = client.x().tweets().search(params);
System.out.println(result);

client.close();
```

Next, read the [Java SDK guide](https://docs.xquik.com/sdks/java), [Javadocs](https://javadoc.io/doc/com.xquik.api/x-twitter-scraper-java-core/0.10.3) or [REST API reference](https://docs.xquik.com/api-reference/overview).

<!-- trust:start -->

## Benchmarks & usage

[![Twitter API package downloads](https://img.shields.io/endpoint?url=https%3A%2F%2Fxquik.com%2Fbadges%2Fdownloads.json)](https://xquik.com/benchmarks#downloads)
[![Twitter API p99 server read time](https://img.shields.io/endpoint?url=https%3A%2F%2Fxquik.com%2Fbadges%2Frest-p99.json)](https://xquik.com/benchmarks#speed)
[![OpenSSF Best Practices](https://www.bestpractices.dev/projects/13735/badge)](https://www.bestpractices.dev/projects/13735)

- 63,000+ downloads of Xquik's Twitter API packages on npm, PyPI, RubyGems, NuGet, Packagist & Terraform ([source](https://xquik.com/benchmarks#downloads)) <!-- trust:downloads 63178 -->
- 6.4 s p99 REST API server read time over 7 days, failed reads included ([source](https://xquik.com/benchmarks#speed)) <!-- trust:rest-p99 6317 -->
- This repo meets the OpenSSF Best Practices passing criteria ([source](https://www.bestpractices.dev/projects/13735)) <!-- trust:openssf-x-twitter-scraper-java 1 -->

Checked on 2026-11-07. See each number with its date & source on [xquik.com/benchmarks](https://xquik.com/benchmarks) or as [JSON](https://xquik.com/trust.json).

<!-- trust:end -->

## Authenticate

Create an API key in the Xquik dashboard. Then set it in your shell.
Read the [authentication guide](https://xquik.com/auth.md) for every option.

```bash
export X_TWITTER_SCRAPER_API_KEY="your-api-key"
```

OAuth users can set `X_TWITTER_SCRAPER_BEARER_TOKEN` instead.

Create 1 client and reuse it.

```java
import com.x_twitter_scraper.api.client.XTwitterScraperClient;
import com.x_twitter_scraper.api.client.okhttp.XTwitterScraperOkHttpClient;

XTwitterScraperClient client = XTwitterScraperOkHttpClient.fromEnv();
```

Pass credentials directly when needed.

```java
XTwitterScraperClient client = XTwitterScraperOkHttpClient.builder()
    .apiKey("your-api-key")
    .build();
```

The client reads these settings.

| Setting | System property | Environment variable | Default |
| --- | --- | --- | --- |
| API key | `xtwitterscraper.apiKey` | `X_TWITTER_SCRAPER_API_KEY` | None |
| OAuth token | `xtwitterscraper.bearerToken` | `X_TWITTER_SCRAPER_BEARER_TOKEN` | None |
| Base URL | `xtwitterscraper.baseUrl` | `X_TWITTER_SCRAPER_BASE_URL` | `https://xquik.com/api/v1` |

System properties override environment variables.

## Java client or REST

The typed Maven Central package calls the documented Xquik REST API.
It does not call or emulate the official X API.
Use this SDK for Java services with builders and typed models.
Use synchronous calls or `client.async()` for `CompletableFuture` pipelines.
Call REST directly when a Maven dependency does not fit.

## Common Twitter & X tasks

| Task | REST route | Java service |
| --- | --- | --- |
| Run an advanced Twitter search | `GET /x/tweets/search` | `client.x().tweets()` |
| Retrieve tweets, threads, replies, or quotes | `GET /x/tweets/{id}`, `GET /x/tweets/{id}/thread` | `client.x().tweets()` |
| Search X or Twitter users | `GET /x/users/search` | `client.x().users()` |
| Scrape an X profile timeline | `GET /x/users/{id}/tweets` | `client.x().users()` |
| Export X followers | `GET /x/users/{id}/followers` | `client.x().users()` |
| Export X following accounts | `GET /x/users/{id}/following` | `client.x().users()` |
| Collect verified followers | `GET /x/users/{id}/verified-followers` | `client.x().users()` |
| Collect mentions, likes, replies, or media | `GET /x/users/{id}/mentions`, `GET /x/users/{id}/likes` | `client.x().users()` |
| Extract an X home timeline | `GET /x/timeline` | `client.x()` |
| Extract list tweets, members, or followers | `GET /x/lists/{id}/tweets`, `GET /x/lists/{id}/members` | `client.x().lists()` |
| Search communities and collect their tweets | `GET /x/communities/search`, `GET /x/communities/{id}/tweets` | `client.x().communities()` |
| Read bookmarks and bookmark folders | `GET /x/bookmarks`, `GET /x/bookmarks/folders` | `client.x().bookmarks()` |
| Read notifications or direct messages | `GET /x/notifications`, `GET /x/dm/{userId}/history` | `client.x()`, `client.x().dm()` |
| Discover X trends | `GET /x/trends` | `client.x().getTrends()` |
| Export large X datasets | `POST /extractions` | `client.extractions()` |
| Monitor tweet keywords or accounts | `POST /monitors/keywords`, `POST /monitors` | `client.monitors()` |
| Receive signed event deliveries | `POST /webhooks` | `client.webhooks()` |
| Post, like, retweet, or follow | `POST /x/tweets`, `POST /x/users/{id}/follow` | `client.x().tweets()`, `client.x().users()` |
| Send media or update a profile | `POST /x/media`, `PATCH /x/profile` | `client.x().media()`, `client.x().profile()` |
| Manage connected X accounts | `GET /x/accounts`, `POST /x/accounts` | `client.x().accounts()` |

### Tasks that arrive with 0.11.0

These REST routes work today.
Their typed Java methods ship in 0.11.0, the next Maven Central release.

| Task | REST route | Java service |
| --- | --- | --- |
| Read tweet insights, translations, subtitles, or embed HTML | `GET /x/tweets/{id}/insights`, `GET /x/tweets/{id}/translation`, `GET /x/tweets/{id}/subtitles`, `GET /x/tweets/{id}/embed` | `client.x().tweets()` |
| List the top tweets on X | `GET /x/tweets/top` | `client.x().tweets()` |
| Export follower or following IDs without profiles | `GET /x/users/{id}/follower-ids`, `GET /x/users/{id}/following-ids` | `client.x().users()` |
| Read a user's lists, highlights, articles, or live status | `GET /x/users/{id}/lists`, `GET /x/users/{id}/highlights`, `GET /x/users/{id}/articles`, `GET /x/users/{id}/live` | `client.x().users()` |
| Read past trends or the places X offers trends for | `GET /x/trends/history`, `GET /x/trends/locations` | `client.x().getTrendsHistory()`, `client.x().getTrendLocations()` |
| Find popular or suggested communities | `GET /x/communities/popular`, `GET /x/communities/suggested` | `client.x().communities()` |
| Read community activity and growth | `GET /x/communities/{id}/analytics` | `client.x().communities().retrieveAnalytics()` |
| Track 1 post's replies, quotes, edits and hourly metrics | `POST /monitors/posts`, `GET /monitors/posts/{id}/metrics` | `client.monitors().posts()` |
| Stream monitor events as they happen | `GET /events/stream` | `client.events()` |
| Analyze the sentiment, viral score, or brand mentions of posts | `POST /x/analysis/sentiment`, `POST /x/analysis/brand` | `client.x().analysis()` |
| Search X job listings | `GET /x/jobs/search`, `GET /x/jobs/{id}` | `client.x().jobs()` |
| Read Spaces, replays, and live broadcasts | `GET /x/spaces/search`, `GET /x/spaces/{id}/replay`, `GET /x/broadcasts/{id}` | `client.x().spaces()`, `client.x().broadcasts()` |
| Read Community Notes contributors and their notes | `GET /x/community-notes/contributors/{alias}/notes` | `client.x().communityNotes()` |
| Read NFL & college football games, box scores, plays, audiences, rosters, player props and posts | `GET /x/sports/{league}/games`, `GET /x/sports/{league}/games/{id}/plays` | `client.x().sports()` |
| Read the account's activity log and each activity's full record | `GET /activity`, `GET /activity/{id}` | `client.activity()` |
| Check 1 account for a search ban, a suggestion ban and reply deboosting | `GET /x/users/{id}/shadowban` | `client.x().users().retrieveShadowban()` |

## Use async calls

Call `async()` to receive `CompletableFuture` results.

```java
import java.util.concurrent.CompletableFuture;

CompletableFuture<TweetSearchResponse> result =
    client.async().x().tweets().search(params);
```

## Stream events

`client.events().stream()` sends your monitor events as they happen.
This method ships in 0.11.0.
Close each stream when you finish.

```java
import com.x_twitter_scraper.api.core.http.StreamResponse;
import com.x_twitter_scraper.api.models.events.Event;

try (StreamResponse<Event> events = client.events().stream()) {
    events.stream().forEach(event -> System.out.println(event.type()));
}
```

The async client calls your handler on a background thread.

```java
client.async().events().stream()
    .subscribe(event -> System.out.println(event.type()))
    .onCompleteFuture()
    .join();
```

A stream lasts up to 30 minutes. Reconnect with the last event ID you got.

```java
import com.x_twitter_scraper.api.models.events.EventStreamParams;

EventStreamParams params = EventStreamParams.builder()
    .lastEventID(lastEvent.id())
    .build();

StreamResponse<Event> events = client.events().stream(params);
```

The stream first sends each event after that ID from the last 30 days.
The client's request timeout does not end a stream.
A stream fails after 1 minute without data.
The server sends a keep-alive comment every 15 seconds while idle.

## Configure retries

The client retries eligible failures 2 times by default.

```java
XTwitterScraperClient client = XTwitterScraperOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

## Read raw responses

Use `withRawResponse()` when you need headers or status codes.

```java
import com.x_twitter_scraper.api.core.http.HttpResponseFor;
import com.x_twitter_scraper.api.models.account.AccountRetrieveResponse;

HttpResponseFor<AccountRetrieveResponse> response =
    client.account().withRawResponse().retrieve();

int status = response.statusCode();
AccountRetrieveResponse account = response.parse();
```

Binary endpoints return `HttpResponse`. Close each response after reading it.

## Verify Maven signatures

Every Maven Central file has a detached OpenPGP signature. Run these commands to verify the artifact.

```sh
version=0.10.3
artifact="x-twitter-scraper-java-$version.jar"
base="https://repo.maven.apache.org/maven2/com/xquik/api/x-twitter-scraper-java/$version"
curl --fail --location --remote-name "$base/$artifact"
curl --fail --location --remote-name "$base/$artifact.asc"
gpg --keyserver hkps://keyserver.ubuntu.com --recv-keys 0xD2037E4157E62A59
gpg --verify "$artifact.asc" "$artifact"
```

Confirm the fingerprint `6965 E561 C0AC EE32 060A B961 D203 7E41 57E6 2A59`.

## Questions

### Do I need an X developer account?

No. Public reads need only an Xquik API key.
Private reads & X account actions need a connected X account.

### Is this the official X API?

No. Xquik runs its own REST API. This SDK calls that API, not the official X API.

## More Xquik tools

- [X (Twitter) scraper API & Twitter MCP server](https://github.com/Xquik-dev/x-twitter-scraper) with REST, MCP & Skill setup.
- Twitter API SDKs for [TypeScript](https://github.com/Xquik-dev/x-twitter-scraper-typescript), [Python](https://github.com/Xquik-dev/x-twitter-scraper-python), [Go](https://github.com/Xquik-dev/x-twitter-scraper-go) & [Ruby](https://github.com/Xquik-dev/x-twitter-scraper-ruby).
- More Twitter API SDKs for [Kotlin](https://github.com/Xquik-dev/x-twitter-scraper-kotlin), [C#](https://github.com/Xquik-dev/x-twitter-scraper-csharp) & [PHP](https://github.com/Xquik-dev/x-twitter-scraper-php).
- [Twitter CLI & X CLI](https://github.com/Xquik-dev/x-twitter-scraper-cli) for terminal workflows.
- [Twitter advanced search operators](https://github.com/Xquik-dev/x-twitter-advanced-search) with tested examples.
- Twitter agent plugins for [OpenClaw](https://github.com/Xquik-dev/tweetclaw) & [Hermes Agent](https://github.com/Xquik-dev/hermes-tweet).
- Twitter integrations for [n8n](https://github.com/Xquik-dev/n8n-nodes-xquik), [Prefect](https://github.com/Xquik-dev/prefect-xquik), [Haystack](https://github.com/Xquik-dev/xquik-haystack) & [Paperclip](https://github.com/Xquik-dev/paperclip-plugin-xquik).
- More Twitter integrations for [Terraform](https://github.com/Xquik-dev/terraform-provider-x-twitter-scraper), [Convex](https://github.com/Xquik-dev/xquik-convex), [Supabase](https://github.com/Xquik-dev/xquik-supabase) & [Strapi](https://github.com/Xquik-dev/strapi-plugin-xquik).
- Twitter MCP for [AI agents](https://github.com/Xquik-dev/xquik-mcp), [VS Code](https://github.com/Xquik-dev/xquik-vscode) & [Raycast](https://github.com/Xquik-dev/xquik-raycast).
- [Xquik X API & Twitter scraper](https://xquik.com), [Twitter API docs](https://docs.xquik.com/api-reference/overview) & [docs source](https://github.com/Xquik-dev/xquik-docs).

## Help & contributing

- Read the [Xquik docs](https://docs.xquik.com) for API questions.
- Report vulnerabilities through the [security policy](SECURITY.md).
- Report SDK defects in [GitHub Issues](https://github.com/Xquik-dev/x-twitter-scraper-java/issues).
- Read the [contribution guide](CONTRIBUTING.md) & [governance policy](GOVERNANCE.md).
- Read the [OpenSSF evidence](OPENSSF.md) & [citation metadata](CITATION.cff).
- Use this SDK under the [Apache License 2.0](LICENSE).

Xquik is an independent third-party service. Not affiliated with X Corp. "Twitter" and "X" are trademarks of X Corp.
