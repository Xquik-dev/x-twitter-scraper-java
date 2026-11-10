# Changelog

## 0.11.0 (2026-11-04)

[Full changelog from v0.10.3 to v0.11.0](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.10.3...v0.11.0)

### Breaking changes

* `UserRetrieveInsightsResponse.Insights.Sample.builder()` requires `read`, which the API always sends. Code that builds it by hand must set it. `posts` counts the posts the averages used, so it can be lower than `read`.
* `ExtractionJob.builder()` requires `url`, which the API always sends. Code that builds the job by hand must set it.
* `CreditTopupBalanceResponse.builder()` requires `chargedCurrency` and `chargedMinorUnits`, which the API always sends. Code that builds the response by hand must set both.
* `AccountBulkRetryParams._body()` returns `AccountBulkRetryParams.Body` instead of `Optional<Map<String, JsonValue>>`, and bulk retry always sends a JSON body, which is `{}` when no account is named. Code that calls `_body()` must change, and compiled callers must rebuild.
* `MediaUploadParams`, `ProfileUpdateAvatarParams` and `ProfileUpdateBannerParams` take exactly 1 of `url` or `file`, so their `url()` getters return `Optional<String>`. Builders that set `url` keep working.
* `UserRetrieveInsightsResponse.Insights.builder()` requires `medianViews`, which the API always sends. Code that builds it by hand must set it.
* `TweetSearchParams.q()` returns `Optional<String>`, and `TweetSearchParams.builder()` no longer requires `q`, since the API can build the search from `fromUser`, `keywords` or another field. Code that reads `q()` must change. A search with no query field still answers `missing_query`.
* Media uploads now reject `isLongVideo` without a file.
* `x().accounts().reauth` returns the same 3 answers as `create`, so `AccountReauthResponse` is now that union. A sign-in still running or waiting on an email code no longer reads as an active account, so check which variant the answer is before you read `xUsername()`.

### Security

* Update jackson-core & jackson-databind from 2.22.1 to 2.22.3, which fixes 7 advisories, 5 high & 2 moderate.
* The jackson-core fixes are GHSA-7hhh-6rmp-j9qf & GHSA-p6pp-m3f8-5c89.
* The jackson-databind fixes are GHSA-cxp5-3px4-pw24, GHSA-q4xh-88c3-wmh7, GHSA-wv8q-qhhj-9h54, GHSA-gx83-3vf8-gh7j & GHSA-wjgm-6hv5-3cvf.
* The SDK's own JSON handling does not use the affected features. Your application gets the same Jackson version through the SDK, so update if it parses untrusted JSON with Jackson.

### Features

* `UserRetrieveBatchTweetsParams.pageSize()` takes up to 300 posts per user.
* `monitors().upsertByUsername()` creates the monitor for an account, or updates it if it exists, so the same call twice still leaves 1 monitor. `created()` says which one ran.
* `MediaDownloadResponse.unprocessedTweetIds()` lists the posts Xquik had no time to read, at no charge. Send them again.
* `ExtractionRunParams` and `DrawRunParams` take `idempotencyKey`, which `extractions().run` and `draws().run` send as `Idempotency-Key`. An exact retry with the same key returns the first result and charges nothing.
* `Error` reads `requiredScope`, the scope an `insufficient_scope` answer needs, and `allowedFields` and `fieldErrors`, which name each unknown `fields` or `omit` entry of an `unknown_field` answer and the name it most likely meant.
* `x().tweets().search`, `x().users().retrieveTweets`, `retrieveReplies` and `retrieveMedia` take `topic` and `imageShows`, which keep only the posts about a topic or whose photos show what you ask for. The page returns `topicFilter` or `imageFilter` with the cutoff and counts, and each kept post returns `topicScore` or `imageScore`.
* `extractions().run` and `estimateCost` take `topic` and `imageShows`. `ExtractionJob` and the `job` of `extractions().retrieve` return `topicFilter` or `imageFilter`, and `x().media().download` takes `imageShows` and returns `imageFilter`.
* `client.x().tweets().bookmark()`, `client.x().users().block()` and `client.x().users().mute()` add the 6 new writes. Each takes `create` and `delete`, sends `account` in the body and `Idempotency-Key` and `Prefer` as headers, like `client.x().tweets().like()`.
* Every write response's `Action` adds `BOOKMARK`, `UNBOOKMARK`, `BLOCK`, `UNBLOCK`, `MUTE` and `UNMUTE`.
* Post monitors read `authorAffiliate`, the organization badge X shows beside the author, and `PostCreateParams` takes `isActive`, so a monitor can start paused.
* Event data reads `followKind`, which says why a removed account came back.
* Extraction results read `possiblySensitive`, `quotedPossiblySensitive`, `quotedMedia` and `quotedPost` with `outputPreset=flat`.
* Media download items read `posterUrl` and `qualities`, the cover image and the MP4 sizes X stores for a video.
* Article reads return `unknownCounts`, the counts X did not send, so each 0 means unknown.
* Extraction results return `isDeleted` on a post its author deleted after Xquik saw it.
* `UserRetrieveInsightsParams` and `UserRetrieveShadowbanParams` take `limit`, the recent posts to read.
* Extraction tool types gain `USER_AFFILIATES`.
* The 6 `x().analysis()` methods take `images` in `analysis`. The AI reads up to 4 images per post at no extra cost, and `false` keeps it to the text. `contextAvailability.media` adds `IMAGES`, for when the AI read them.
* `ExtractionJob`, the `job` of `extractions().retrieve` and the accepted `extractions().run` response read `url`, the job's dashboard page with every row as a file.
* `client.monitors().posts()` adds post monitors. It has `create`, `retrieve`, `update`, `list`, `delete` and `retrieveMetrics`.
* `client.x().sports()` adds NFL & college football reads. It has `listGames`, `retrieveScoreboard`, `retrieveBoxScore`, `retrievePlays`, `retrieveAudience`, `retrieveRoster`, `retrievePlayerProps` and `listPosts`.
* `client.activity()` adds the activity log. `list` returns the account's activity rows, and `retrieve` returns the full record of 1 activity.
* `client.x().users()` adds `retrieveShadowban`, which checks 1 account for a search ban, a search suggestion ban and reply deboosting.
* `ShadowbanReport` reads `checkedAt`, `overall` and the `replyLock`, `timeline`, `engagement`, `sensitive` and `withheld` checks.
* `client.x().users()` adds `retrieveFollowerAudit`, which reads an account's newest followers and returns a `FollowerAudit`. It gives each follower a `FollowerClass` from its public profile, and adds coverage, a quality grade, signal counts, arrival bands, join cohorts, languages, places and top followers.
* Events read `postId`, `postUrl`, `authorId` and `authorUsername` on post events, and the `post` monitor type.
* `EventListParams` filters by `postMonitorId`, and event data reads `metric`, `previousText` and `versionId`.
* `EventType` adds the 10 post event types, such as `POST_REPLY_NEW`. Account and keyword monitors reject them.
* Posts, embedded posts and event posts read `liveEventContext` and `unknownFields`, reaction contexts read `reactedToPost`, and media reads `editedWithNativeEditor`.
* Profile and Space affiliation labels read `auxiliaryLabels`.
* Post monitors read `authorAvatarUrl`, `authorVerified`, `media` and `baseline`.
* Sports teams read `recentGames`, and a player's X user reads `protected_`, `superFollowEligible` and `labelType`.
* Top-ups and subscriptions take a `currency` from the new `Currency` model, and top-ups take `returnPath`. Their checkouts read `chargedCurrency`, and top-ups read `chargedMinorUnits`.
* `EventStreamParams` takes `include` and `lookBack`.
* `AccountUpdateLocaleParams.Locale` adds `JA`, `KO` and `ZH`.
* Media downloads read `items`, reply pages read `unreachedReplies`, and extraction results read `verifiedType`.
* Every request sends `X-Xquik-SDK: java` beside the platform headers it already sends.
* Communities add the analytics read with `retrieveAnalytics`.
* Posts, embedded posts and event posts return `softIntervention`, the label X shows under a post whose reach it limits.
* Posts and embedded posts name the counts X did not send in `unknownCounts`.
* Bulk retry can target specific accounts with `accountIds`.
* Embedded parent, quoted and retweeted posts carry every tweet field and the author.
* `UserProfile.IdentityVerification` gains optional `overrideVerifiedYear` for the verification start year X displays on profiles and user objects in tweets.
* `client.x().tweets()` gains `listTop`, `embed`, `getHiddenReplies`, `getInsights`, `getRetweeterIds`, `checkRepost`, `getSubtitles`, `translate` and `resolveLinks`. Each has typed params and a typed response from the current API spec.
* `client.x().users()` gains `retrieveBatchTweets`, `retrieveAffiliates`, `retrieveArticles`, `retrieveFollowerIds`, `retrieveFollowingIds`, `retrieveHighlights`, `retrieveInsights`, `retrieveListMemberships`, `retrieveLists`, `retrieveLive`, `retrieveSimilar`, `retrieveSubscriptions` and `translateBio`.
* `client.x().communities()` gains `find`, `listPopular`, `listSuggested`, `listTopics`, `searchMembers` and the `media().list` subresource. The shared `Community`, `CommunityPage` and `CommunityTopic` models describe their results.
* `client.x().lists()` gains `retrieve` and `retrieveSearch`, and `client.x().dm()` gains `deleteMessage`.
* `client.x()` gains `autocompleteSearch`, `getHashflags`, `searchPlaces`, `getTrendLocations`, `getTrendsHistory` and `getNewsStoryVersions`.
* `client.x().getTrends()` takes `at`, `country`, `location`, `fields` and `omit`, and its response gains `capturedAt`, `location` and `requestedAt`.
* `client.x()` gains `jobs()` with `retrieve`, `listLocations` and `search`, and `spaces()` with `retrieve`, `retrieveReplay` and `search`.
* `client.x()` gains `broadcasts()` with `retrieve`, and `communityNotes()` with `retrieveContributor`, `listContributorNotes` and `listContributorDeletedNotes`.
* `client.x()` gains the `analysis()` subresource with `sentiment`, `viralScore`, `brand`, `news`, `marketSignals` and `classify`.
* `client.events()` gains `stream`, which reads the server-sent event stream as `Event` values. The sync client returns a `StreamResponse` and the async client an `AsyncStreamResponse`. Keep-alive comments never reach the caller.
* `client.webhooks()` gains `createTelegramLink` and `client.extractions()` gains `cancel`.
* `ClientOptions` and the OkHttp client builders gain `streamHandlerExecutor`, which runs async stream callbacks.
* `UserProfile`, `SearchTweet`, `TweetMedia`, `EmbeddedTweet`, `ContentDisclosure`, `PaginatedTweets`, `PaginatedUsers`, `TweetDetail` and `TweetAuthor` gain every field the API spec lists. New fields are optional in the builders.
* 32 reads, such as `client.x().tweets().retrieve` and `client.x().users().retrieveFollowers`, take `fields` and `omit` and their other missing query params. Their responses gain the fields the spec lists.
* The remaining request and response models gain the fields and enum values in the API spec. New fields are optional in builders. List reads gain pagination params and metadata, and upload requests gain file fields.
* The 19 write methods, such as `client.x().tweets().create`, take `prefer`. They send it as the `Prefer` header. `wait=<seconds>` asks for the answer within that many seconds, up to 85. A write still running then answers 202 with its status link.
* Error codes gain the 59 codes the API added, such as `PRICE_CHANGED` and `X_COMMUNITY_CREATION_CLOSED`. X takes no new Communities, so `client.x().communities().create` fails. It answers `x_community_creation_closed` and charges nothing.
* `ExtractionExportResultsParams` takes `compare` & `change` to keep only the rows that differ from another run.
* Exports also filter accounts by `hasWebsite`, `location`, `joinedSince` & `joinedUntil`. `hideInactive` & `hideFake` drop inactive & fake-looking accounts.
* `TweetSearchParams`, `ExtractionRunParams` & `ExtractionEstimateCostParams` take `textOnlyTerms`. It keeps posts whose text, link, card or quote holds 1 of the terms.
* User insights return `medianViews`. Radar item metadata returns `sentiment` & `windows`.
* `x().accountConnectionLinks().create` makes a link to a page Xquik hosts, where a person connects an X account with no Xquik signup. `retrieve` reads the link and its status, and `delete` revokes it. Treat `url()` as a secret, since it holds the token.
* `AccountCreateParams` and `AccountReauthParams` take `connectionAttemptId`, an ID you generate to read the attempt's status even if the response never reaches you. A finished attempt returns `accountId()`.
* `TweetCreateParams` takes `mediaIds`, the IDs that `x().media().upload` returns. Send `media` or `mediaIds`, not both.
* `Error` codes add `X_ACCOUNT_CONNECT_PERMISSION_REQUIRED`, `X_ACCOUNT_MISMATCH` and `MEDIA_NOT_UPLOADED`.

### Bug fixes

* `TicketCreateParams` and `TicketReplyParams` throw from `build()` when `body` is blank and no attachment is set, with the same "At least one of `body` or `attachments` must be set" error. The API rejects such a ticket or reply with a 400.
* Ticket creation sends default attachment streams as `application/octet-stream` with a neutral filename so the server can detect their type.
* Media, avatar and banner uploads detect supported image formats and MP4 brands from stream headers and preserve every byte. Other `ftyp` brands use `application/octet-stream` with the filename `upload`.
* Follower, following and verified follower response unions select the coverage variant when the response contains `diagnostic`.
* `XAccount` and `XAccountDetail` drop a timestamp field the API stopped returning.
* Reading the generic types of a raw response's class no longer throws `TypeNotPresentException`.

### Documentation

* The README title is now "X API & Twitter API Java SDK by Xquik".
* The README says near the top what Xquik is, how it bills and that it is not affiliated with X Corp.
* Doc comments use the current price. An active monitor costs 30 credits per hour.

### Chores

* The check and release scripts remove their temp dirs on every exit, including a failed step, a signal and read-only build caches.
* `bin/check-local` now fails when the API has an operation that the SDK neither sends nor lists in `excluded-operations.json`. CONTRIBUTING.md explains the check.
* The dependency audit now works in a Git worktree under `.claude/worktrees`.
* `scripts/api-fields` checks request and response fields against the API spec. `accepted-field-differences.json` records the differences kept for caller compatibility.
* The prefix of the idempotency key that the client can generate is now `xquik-java-retry-`. The client never sends that key by default, so no request changes.
* The SDK now depends on kotlin-stdlib 2.3.21, the latest patch of the 2.3 line, instead of 2.3.20.

## 0.10.3 (2026-08-21)

Full Changelog: [v0.10.2...v0.10.3](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.10.2...v0.10.3)

### Documentation

* tighten Java setup and API guidance

## 0.10.2 (2026-08-20)

Full Changelog: [v0.10.1...v0.10.2](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.10.1...v0.10.2)

### Documentation

* refine public Java SDK text ([84135cf](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/84135cffafb041380a56c23cfba830d8b9d504fd))

## 0.10.1 (2026-08-18)

Full Changelog: [v0.10.0...v0.10.1](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.10.0...v0.10.1)

### Build System

* update Gradle and patch SDK dependency vulnerabilities ([#52](https://github.com/Xquik-dev/x-twitter-scraper-java/issues/52)) ([861e280](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/861e28075f2b4ccda3f085e56ac3f36bbaac92b3))

## 0.10.0 (2026-08-12)

Full Changelog: [v0.8.4...v0.10.0](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.8.4...v0.10.0)

### Features

* add OpenSSF Gold quality gates ([f0fb44d](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/f0fb44d9b07c3c612ff9b005a694e6f838081f3a))
* **api:** align reply extraction contracts ([7702591](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/7702591c9b20cabdef63849eb98419cec0ef356a))
* **api:** api update ([e75a791](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/e75a7919e8ff8da00ddf41ae4111e0f560c6e54a))
* **api:** api update ([d9ec682](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/d9ec6821d543fce1a888f4d0582c3ec24f3c0564))
* **api:** api update ([aa06dd7](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/aa06dd748fa884ccfa058fe5ed576d97fae978ef))
* **api:** api update ([30c1879](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/30c1879055bd1a7fb925a8dc674fbbd932c29f9f))
* **api:** api update ([5e2cc73](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/5e2cc73283addfe9ac177efb47623c0f51dedf8e))
* **api:** api update ([6022295](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/6022295c6a25bd0b0797c85ae96304cc3eeb2103))
* **api:** api update ([d4c753a](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/d4c753ab0a9ee134dc567e576dac2892407e7e29))
* **api:** api update ([785b4f7](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/785b4f7e00571e41ccd6b1a53ffca6d75ab6f58f))
* **api:** api update ([a261d36](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/a261d36ba03b9eb2969ca9758694f969bf374ec7))
* **api:** sync public contracts ([ddda594](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/ddda594ba95292a599c2d3352e3130d63ddf6a74))


### Bug Fixes

* align SLF4J test provider ([e760ae0](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/e760ae0bc9ff0ecb402e6f989c319908d1282875))
* escape ampersand in OpenAPI summaries for C# XML docs ([fb78c9a](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/fb78c9aea1252be7535e3b5efcc5f916805831d4))
* **release:** allow Maven publication propagation ([efd0ddc](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/efd0ddc053c497054b01d765e7c1fbbddf5d6106))
* remove unused async lock helper ([bf2e7a9](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/bf2e7a9d5bbfd1b53ce9bf34386a6fe0194ba73c))
* trust verified Gradle metadata ([e0e3e87](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/e0e3e8783d7b3077af70647d8e5f67565da4bc3f))


### Chores

* add Context7 refresh workflow ([ce2a6d7](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/ce2a6d7bbf0b3818343823564632b9663deef0ef))
* add FUNDING.yml pointing to xquik.com ([b8a37d9](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/b8a37d9d5eff62c825d045e7549cbbd97b8e044a))
* **deps:** bump actions/setup-java from 5.6.0 to 5.7.0 ([#49](https://github.com/Xquik-dev/x-twitter-scraper-java/issues/49)) ([ca9c316](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/ca9c316f84afa298a5df6e5c06da2acf1da64541))
* **deps:** bump github/codeql-action/analyze from 4.37.1 to 4.37.2 ([#22](https://github.com/Xquik-dev/x-twitter-scraper-java/issues/22)) ([d307843](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/d3078435464e3144075d865d972e38d5bbd59482))
* **deps:** bump github/codeql-action/upload-sarif ([#23](https://github.com/Xquik-dev/x-twitter-scraper-java/issues/23)) ([977ccd8](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/977ccd80c70faa598845c08f1a776ea48d198a51))
* **deps:** bump github/codeql-action/upload-sarif from 4.37.2 to 4.37.6 ([#46](https://github.com/Xquik-dev/x-twitter-scraper-java/issues/46)) ([d1614e9](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/d1614e9d52d5fb6d78cbd7178ceaf7a54d924816))
* **deps:** bump org.apache.logging.log4j:log4j-api ([#20](https://github.com/Xquik-dev/x-twitter-scraper-java/issues/20)) ([13ec838](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/13ec8385e24b81e280f66f6897398b1385c8aec6))
* **internal:** codegen related update ([9ff57d2](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/9ff57d291ace852b3fcea07c5db1444dd7ec5115))
* merge main into release branch ([cb52b50](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/cb52b508a62ee885b19897c8b4661c6f0609601d))
* neutralize coverage source classification ([0089073](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/0089073842fc8fe912ae99232b163a3be11313de))
* preserve coverage gates with SPDX headers ([873219a](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/873219ac82c57fdceb4fef37c8393d447a03781f))
* quiet Gradle cache cleanup warnings ([6b77330](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/6b77330a7fdf7e9c8ea84dee354e57e613564be3))
* sync OpenAPI spec ([c225ad8](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/c225ad8eb377c71093ce3f9b5292257ce191ed3a))
* update Gradle actions for Node 24 ([9c8a3a0](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/9c8a3a0da540d688aac6f5d9b128962c1d222876))
* wire production_repo for all targets ([1a3de89](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/1a3de8994dc023e9602bc359a0f5067f03082e9a))


### Documentation

* add Contributor Covenant 2.1 Code of Conduct ([afb97b0](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/afb97b0d326a8ff3602f871cd12daa63c7a3d847))
* add DeepWiki badge ([3b366af](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/3b366af5ff33de6e029885af3c7fedbf7c0a6b9a))
* clarify repository discovery ([e6c115b](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/e6c115b50205ce8720f5d30c7cfdf48f780537b3))
* correct Java test evidence count ([6e6a171](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/6e6a171d428896d32833fa94e5860c68ad7e2739))
* map common X data tasks ([f3438ea](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/f3438ea480f091967958c158a10fc7722d6298fd))
* mark Maven publication pending ([2aad6f6](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/2aad6f6d7208d90eaffbb483677cd50a34f55559))

## [0.9.1](https://github.com/stainless-sdks/x-twitter-scraper-java/compare/v0.9.0...v0.9.1) (2026-08-11)

### Features

* **api:** api update ([e75a791](https://github.com/stainless-sdks/x-twitter-scraper-java/commit/e75a7919e8ff8da00ddf41ae4111e0f560c6e54a))
* **api:** clarify idempotent guest checkout replays ([60ae884](https://github.com/stainless-sdks/x-twitter-scraper-java/commit/60ae88467fd1d10f2c33a7f2a6575e3dd6087ff8))

## [0.9.0](https://github.com/stainless-sdks/x-twitter-scraper-java/compare/v0.8.4...v0.9.0) (2026-08-11)


### Features

* **api:** api update ([d9ec682](https://github.com/stainless-sdks/x-twitter-scraper-java/commit/d9ec6821d543fce1a888f4d0582c3ec24f3c0564))
* **api:** api update ([aa06dd7](https://github.com/stainless-sdks/x-twitter-scraper-java/commit/aa06dd748fa884ccfa058fe5ed576d97fae978ef))
* **api:** update generated API surface ([9aa7a46](https://github.com/stainless-sdks/x-twitter-scraper-java/commit/9aa7a469545701d567c0a74e5ad7eea123c333f1))

## 0.8.4 (2026-08-11)

Full Changelog: [v0.8.3...v0.8.4](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.8.3...v0.8.4)

### Chores

* **deps:** bump actions/setup-java from 5.6.0 to 5.7.0 ([#49](https://github.com/Xquik-dev/x-twitter-scraper-java/issues/49)) ([ca9c316](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/ca9c316f84afa298a5df6e5c06da2acf1da64541))

## 0.8.3 (2026-08-11)

Full Changelog: [v0.8.2...v0.8.3](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.8.2...v0.8.3)

### Chores

* **deps:** bump github/codeql-action/upload-sarif from 4.37.2 to 4.37.6 ([#46](https://github.com/Xquik-dev/x-twitter-scraper-java/issues/46)) ([d1614e9](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/d1614e9d52d5fb6d78cbd7178ceaf7a54d924816))

## 0.8.2 (2026-08-04)

Full Changelog: [v0.8.1...v0.8.2](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.8.1...v0.8.2)

### Chores

* **internal:** codegen related update ([e059530](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/e059530b59bae99005c4a1d13c600b0313cc6cf7))

## 0.8.1 (2026-07-31)

Full Changelog: [v0.8.0...v0.8.1](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.8.0...v0.8.1)

### Bug Fixes

* **release:** allow Maven publication propagation ([efd0ddc](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/efd0ddc053c497054b01d765e7c1fbbddf5d6106))

## 0.8.0 (2026-07-31)

Full Changelog: [v0.7.1...v0.8.0](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.7.1...v0.8.0)

### Features

* **api:** align reply extraction contracts ([7702591](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/7702591c9b20cabdef63849eb98419cec0ef356a))

## 0.7.1 (2026-07-30)

Full Changelog: [v0.7.0...v0.7.1](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.7.0...v0.7.1)

## 0.7.0 (2026-07-29)

Full Changelog: [v0.6.2...v0.7.0](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.6.2...v0.7.0)

### Features

* **api:** api update ([6279df5](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/6279df51bebd8d2b2896ed4139259a01ca8f03e7))
* **api:** api update ([5609e87](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/5609e87e446ee8de9026d6dc418de1bd9945e3e9))

## 0.6.2 (2026-07-28)

Full Changelog: [v0.6.1...v0.6.2](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.6.1...v0.6.2)

### Chores

* **deps:** bump github/codeql-action/analyze from 4.37.1 to 4.37.2 ([#22](https://github.com/Xquik-dev/x-twitter-scraper-java/issues/22)) ([d307843](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/d3078435464e3144075d865d972e38d5bbd59482))
* **deps:** bump github/codeql-action/upload-sarif ([#23](https://github.com/Xquik-dev/x-twitter-scraper-java/issues/23)) ([977ccd8](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/977ccd80c70faa598845c08f1a776ea48d198a51))
* **deps:** bump org.apache.logging.log4j:log4j-api ([#20](https://github.com/Xquik-dev/x-twitter-scraper-java/issues/20)) ([13ec838](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/13ec8385e24b81e280f66f6897398b1385c8aec6))

## 0.6.1 (2026-07-24)

Full Changelog: [v0.6.0...v0.6.1](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.6.0...v0.6.1)

## 0.6.0 (2026-07-24)

Full Changelog: [v0.5.2...v0.6.0](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.5.2...v0.6.0)

### Features

* add OpenSSF Gold quality gates ([f0fb44d](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/f0fb44d9b07c3c612ff9b005a694e6f838081f3a))


### Bug Fixes

* align SLF4J test provider ([e760ae0](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/e760ae0bc9ff0ecb402e6f989c319908d1282875))
* trust verified Gradle metadata ([e0e3e87](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/e0e3e8783d7b3077af70647d8e5f67565da4bc3f))


### Chores

* neutralize coverage source classification ([0089073](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/0089073842fc8fe912ae99232b163a3be11313de))
* preserve coverage gates with SPDX headers ([873219a](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/873219ac82c57fdceb4fef37c8393d447a03781f))


### Documentation

* clarify repository discovery ([e6c115b](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/e6c115b50205ce8720f5d30c7cfdf48f780537b3))
* correct Java test evidence count ([6e6a171](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/6e6a171d428896d32833fa94e5860c68ad7e2739))

## 0.5.2 (2026-07-23)

Full Changelog: [v0.5.1...v0.5.2](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.5.1...v0.5.2)

### Documentation

* map common X data tasks ([f3438ea](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/f3438ea480f091967958c158a10fc7722d6298fd))

## 0.5.1 (2026-07-22)

Full Changelog: [v0.5.0...v0.5.1](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.5.0...v0.5.1)

### Chores

* sync generated SDK contracts ([e422d45](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/e422d456b0a188d215c3b169ed7dd2223142ec4a))
* verify final public contract ([123a4d1](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/123a4d17b1d30dec47b0ce90cb46171008a66070))

## 0.5.0 (2026-07-22)

Full Changelog: [v0.4.1...v0.5.0](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.4.1...v0.5.0)

### Features

* **api:** api update ([4445a25](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/4445a2569d42f66ee6fc3787c5a32174ba38b73b))
* **api:** api update ([30c1879](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/30c1879055bd1a7fb925a8dc674fbbd932c29f9f))
* **api:** api update ([5e2cc73](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/5e2cc73283addfe9ac177efb47623c0f51dedf8e))
* **api:** api update ([6022295](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/6022295c6a25bd0b0797c85ae96304cc3eeb2103))
* **api:** api update ([d4c753a](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/d4c753ab0a9ee134dc567e576dac2892407e7e29))
* **api:** api update ([785b4f7](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/785b4f7e00571e41ccd6b1a53ffca6d75ab6f58f))
* **api:** api update ([a261d36](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/a261d36ba03b9eb2969ca9758694f969bf374ec7))
* **api:** propagate production write-action contract ([d2c5ea0](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/d2c5ea0b30154b5e24d3f287a3d447f3ea33516f))
* **stlc:** configurable CI runner and private-production-repo support in workflow templates ([6b33a54](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/6b33a54c675c33216fdd62decdf8e24ee706bef0))


### Bug Fixes

* escape ampersand in OpenAPI summaries for C# XML docs ([fb78c9a](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/fb78c9aea1252be7535e3b5efcc5f916805831d4))
* reconcile generated SDK with release hardening ([f611b3e](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/f611b3e8c77de6d781c9ff76acfa82e8917f9311))
* remove unused async lock helper ([bf2e7a9](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/bf2e7a9d5bbfd1b53ce9bf34386a6fe0194ba73c))


### Chores

* add Context7 refresh workflow ([ce2a6d7](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/ce2a6d7bbf0b3818343823564632b9663deef0ef))
* add FUNDING.yml pointing to xquik.com ([b8a37d9](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/b8a37d9d5eff62c825d045e7549cbbd97b8e044a))
* merge main into release branch ([cb52b50](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/cb52b508a62ee885b19897c8b4661c6f0609601d))
* quiet Gradle cache cleanup warnings ([6b77330](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/6b77330a7fdf7e9c8ea84dee354e57e613564be3))
* sync OpenAPI spec ([c225ad8](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/c225ad8eb377c71093ce3f9b5292257ce191ed3a))
* sync repo ([9a241d5](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/9a241d5c0f65850014832d38e8099cb870502aab))
* update Gradle actions for Node 24 ([9c8a3a0](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/9c8a3a0da540d688aac6f5d9b128962c1d222876))
* wire production_repo for all targets ([1a3de89](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/1a3de8994dc023e9602bc359a0f5067f03082e9a))


### Documentation

* add Contributor Covenant 2.1 Code of Conduct ([afb97b0](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/afb97b0d326a8ff3602f871cd12daa63c7a3d847))
* add DeepWiki badge ([3b366af](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/3b366af5ff33de6e029885af3c7fedbf7c0a6b9a))
* mark Maven publication pending ([2aad6f6](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/2aad6f6d7208d90eaffbb483677cd50a34f55559))

## 0.4.1 (2026-07-14)

Full Changelog: [v0.4.0...v0.4.1](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.4.0...v0.4.1)

### Chores

* align Maven coordinates with the Xquik namespace
* upgrade to Java 26, Gradle 9.6.1, Kotlin 2.4.0, and current stable dependencies
* harden CI and Maven Central publishing
* include Xquik non-affiliation in published POM metadata

## 0.4.0 (2026-04-25)

Full Changelog: [v0.3.0...v0.4.0](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.3.0...v0.4.0)

### Features

* **api:** api update ([30c1879](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/30c1879055bd1a7fb925a8dc674fbbd932c29f9f))
* **api:** api update ([5e2cc73](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/5e2cc73283addfe9ac177efb47623c0f51dedf8e))
* **api:** api update ([6022295](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/6022295c6a25bd0b0797c85ae96304cc3eeb2103))
* **api:** api update ([d4c753a](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/d4c753ab0a9ee134dc567e576dac2892407e7e29))


### Bug Fixes

* escape ampersand in OpenAPI summaries for C# XML docs ([fb78c9a](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/fb78c9aea1252be7535e3b5efcc5f916805831d4))


### Chores

* sync OpenAPI spec ([c225ad8](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/c225ad8eb377c71093ce3f9b5292257ce191ed3a))
* wire production_repo for all targets ([1a3de89](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/1a3de8994dc023e9602bc359a0f5067f03082e9a))


### Documentation

* add Contributor Covenant 2.1 Code of Conduct ([afb97b0](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/afb97b0d326a8ff3602f871cd12daa63c7a3d847))

## 0.3.0 (2026-04-08)

Full Changelog: [v0.2.0...v0.3.0](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.2.0...v0.3.0)

### Features

* **api:** api update ([c190c61](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/c190c61c7ec6d8edd03874f8bcaac3ca9bce5fae))
* **api:** api update ([d3ad9b3](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/d3ad9b3b176efa1edd42d9500965287b714acef5))
* **api:** api update ([91fe731](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/91fe7314ce8e6e9db863a4bc4863333ffb94fc5c))
* **api:** api update ([85f6788](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/85f67881300bb5cdb912fe7c59edcd0af640a14f))
* **api:** api update ([d4be9ff](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/d4be9ff16190320b7cdaffae495057ee2ceda50c))
* **api:** api update ([f8f5138](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/f8f51380d7cb3d07a0be410e69492edf9fba07cc))
* **api:** api update ([be5b4f9](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/be5b4f9f89ea2e7606d57cb7f0ea809c17c4096f))
* **api:** api update ([a4e0acd](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/a4e0acdd9e95507a2d69d05b50c5b8c114c7cd0b))


### Chores

* update SDK settings ([0a6a774](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/0a6a774604e8868c1a286b2235433829a46ebe92))

## 0.2.0 (2026-04-01)

Full Changelog: [v0.1.0...v0.2.0](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.1.0...v0.2.0)

### Features

* **api:** api update ([31b819a](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/31b819aeae39651f9f9204561f6be9719c7a8d6a))
* **api:** api update ([30ac688](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/30ac6883a272290b03f5baa499ae2b61ac168259))


### Chores

* update SDK settings ([e22bccf](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/e22bccf3d47dfd11929924969cb5438b131069f7))

## 0.1.0 (2026-03-30)

Full Changelog: [v0.0.1...v0.1.0](https://github.com/Xquik-dev/x-twitter-scraper-java/compare/v0.0.1...v0.1.0)

### Features

* **api:** api update ([785b4f7](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/785b4f7e00571e41ccd6b1a53ffca6d75ab6f58f))
* **api:** api update ([a261d36](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/a261d36ba03b9eb2969ca9758694f969bf374ec7))


### Chores

* update SDK settings ([cf5842e](https://github.com/Xquik-dev/x-twitter-scraper-java/commit/cf5842eb4de874399306e623d657ce2f5546e794))
