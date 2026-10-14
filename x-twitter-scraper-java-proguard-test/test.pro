-keep class com.xquik.consumer.proguard.ProGuardCompatibilityTest {
    public static void main(java.lang.String[]);
}

-dontwarn java.lang.invoke.MethodHandle

-dontwarn kotlin.concurrent.atomics.AtomicArray
-dontwarn kotlin.concurrent.atomics.AtomicBoolean
-dontwarn kotlin.concurrent.atomics.AtomicInt
-dontwarn kotlin.concurrent.atomics.AtomicIntArray
-dontwarn kotlin.concurrent.atomics.AtomicLong
-dontwarn kotlin.concurrent.atomics.AtomicLongArray
-dontwarn kotlin.concurrent.atomics.AtomicReference

-dontwarn kotlin.jvm.internal.EnhancedNullability
-dontwarn kotlin.reflect.jvm.internal.impl.types.model.AnnotationMarker

-dontwarn org.bouncycastle.jsse.BCSSLParameters
-dontwarn org.bouncycastle.jsse.BCSSLSocket
-dontwarn org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
-dontwarn org.openjsse.javax.net.ssl.SSLParameters
-dontwarn org.openjsse.javax.net.ssl.SSLSocket
-dontwarn org.openjsse.net.ssl.OpenJSSE
