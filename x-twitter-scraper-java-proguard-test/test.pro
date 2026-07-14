# Specify the entrypoint where ProGuard starts to determine what's reachable.
-keep class com.xquik.consumer.proguard.ProGuardCompatibilityTest {
    public static void main(java.lang.String[]);
}

# MethodHandle.invokeExact is signature-polymorphic, so no concrete descriptor exists in the JDK.
-dontwarn java.lang.invoke.MethodHandle

# Kotlin maps these JVM built-ins to java.util.concurrent.atomic classes at compile time.
-dontwarn kotlin.concurrent.atomics.AtomicArray
-dontwarn kotlin.concurrent.atomics.AtomicBoolean
-dontwarn kotlin.concurrent.atomics.AtomicInt
-dontwarn kotlin.concurrent.atomics.AtomicIntArray
-dontwarn kotlin.concurrent.atomics.AtomicLong
-dontwarn kotlin.concurrent.atomics.AtomicLongArray
-dontwarn kotlin.concurrent.atomics.AtomicReference

# These Kotlin compiler-only markers have no runtime class on the JVM.
-dontwarn kotlin.jvm.internal.EnhancedNullability
-dontwarn kotlin.reflect.jvm.internal.impl.types.model.AnnotationMarker

# OkHttp detects these optional TLS providers before loading their implementations.
-dontwarn org.bouncycastle.jsse.BCSSLParameters
-dontwarn org.bouncycastle.jsse.BCSSLSocket
-dontwarn org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
-dontwarn org.openjsse.javax.net.ssl.SSLParameters
-dontwarn org.openjsse.javax.net.ssl.SSLSocket
-dontwarn org.openjsse.net.ssl.OpenJSSE
