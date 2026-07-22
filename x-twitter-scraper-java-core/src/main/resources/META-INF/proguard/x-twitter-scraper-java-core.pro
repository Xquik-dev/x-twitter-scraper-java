# Jackson uses reflection and depends heavily on runtime attributes.
-keepattributes Exceptions,InnerClasses,EnclosingMethod,Signature,Deprecated,*Annotation*

# R8 keeps attributes only on matched items. This rule permits every code transformation.
-keep,allowshrinking,allowoptimization,allowobfuscation class com.x_twitter_scraper.api.** { *; }

# Jackson reads generic type information from concrete TypeReference subclasses at runtime.
-keep,allowobfuscation class com.fasterxml.jackson.core.type.TypeReference
-keep,allowobfuscation class * extends com.fasterxml.jackson.core.type.TypeReference

# Jackson uses Kotlin reflection utilities, which themselves use reflection to access things.
-keep class kotlin.reflect.** { *; }
-keep class kotlin.Metadata { *; }

# Jackson uses reflection to access enum members (e.g. via `java.lang.Class.getEnumConstants()`).
-keepclassmembers class com.fasterxml.jackson.** extends java.lang.Enum {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Jackson resolves annotation types and members at runtime.
-keep @interface com.fasterxml.jackson.annotation.** {
    *;
}

# Jackson resolves this custom annotation and its value filter at runtime.
-keep @interface com.x_twitter_scraper.api.core.ExcludeMissing
-keep class com.x_twitter_scraper.api.core.JsonField$IsMissing { *; }
-keep class com.x_twitter_scraper.api.core.JsonMissing { *; }
-keepclassmembers class com.x_twitter_scraper.api.** {
    @com.x_twitter_scraper.api.core.ExcludeMissing *;
}

# Jackson uses reflection to access our class serializers and deserializers.
-keep @com.fasterxml.jackson.databind.annotation.JsonSerialize class com.x_twitter_scraper.api.** { *; }
-keep @com.fasterxml.jackson.databind.annotation.JsonDeserialize class com.x_twitter_scraper.api.** { *; }

# Jackson uses reflection to serialize and deserialize our classes based on their constructors and annotated members.
-keepclassmembers class com.x_twitter_scraper.api.** {
    <init>(...);
    @com.fasterxml.jackson.annotation.* *;
}
