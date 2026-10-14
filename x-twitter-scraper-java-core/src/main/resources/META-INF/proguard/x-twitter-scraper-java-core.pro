-keepattributes Exceptions,InnerClasses,EnclosingMethod,Signature,Deprecated,*Annotation*

# R8 keeps attributes only on matched items.
# https://r8.googlesource.com/r8/+/refs/tags/9.1.31/compatibility-faq.md#r8-full-mode
-keep,allowshrinking,allowoptimization,allowobfuscation class com.x_twitter_scraper.api.** { *; }

-keep,allowobfuscation class com.fasterxml.jackson.core.type.TypeReference
-keep,allowobfuscation class * extends com.fasterxml.jackson.core.type.TypeReference

-keep class kotlin.reflect.** { *; }
-keep class kotlin.Metadata { *; }

-keepclassmembers class com.fasterxml.jackson.** extends java.lang.Enum {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep @interface com.fasterxml.jackson.annotation.** {
    *;
}

-keep @interface com.x_twitter_scraper.api.core.ExcludeMissing
-keep class com.x_twitter_scraper.api.core.JsonField$IsMissing { *; }
-keep class com.x_twitter_scraper.api.core.JsonMissing { *; }
-keepclassmembers class com.x_twitter_scraper.api.** {
    @com.x_twitter_scraper.api.core.ExcludeMissing *;
}

-keep @com.fasterxml.jackson.databind.annotation.JsonSerialize class com.x_twitter_scraper.api.** { *; }
-keep @com.fasterxml.jackson.databind.annotation.JsonDeserialize class com.x_twitter_scraper.api.** { *; }

-keepclassmembers class com.x_twitter_scraper.api.** {
    <init>(...);
    @com.fasterxml.jackson.annotation.* *;
}
