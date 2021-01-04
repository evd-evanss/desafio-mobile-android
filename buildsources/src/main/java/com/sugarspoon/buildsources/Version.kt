package com.sugarspoon.buildsources

object Version {

    //region App
    private const val MAJOR = 1
    private const val MINOR = 0
    private const val PATCH = 0
    private const val HOTFIX = 0

    const val versionName = "$MAJOR.$MINOR.$PATCH"
    const val versionCode = MAJOR * 10000000 + MINOR * 100000 + PATCH * 100 + HOTFIX

    const val minSdk = 21
    const val targetSdk = 30
    const val compileSdk = 30
    const val buildTools = "30.0.1"
    const val kotlin = "1.4.10"
    const val gradle = "4.1.1"
    const val googleServices = "4.3.3"
    const val jvmTarget = "1.8"
    //endregion

    //region AndroidX
    const val core = "1.3.1"
    const val multidex = "2.0.1"
    const val material = "1.0.0"
    const val appCompat = "1.2.0"
    const val cardView = "1.0.0"
    const val recyclerView = "1.2.0-alpha05"
    const val constraintLayout = "2.0.1"
    const val biometric = "1.0.1"
    const val lifecycle = "2.2.0"
    const val viewModel = "2.2.0"
    const val liveData = "2.2.0"
    const val navigation = "2.2.2"
    //endregion

    //region Firebase
    const val classpathAppDistribution = "1.4.1"
    const val classpathCrashlytics = "2.2.0"
    const val firebaseCore = "17.4.2"
    const val firebaseMessaging = "20.2.0"
    const val firebaseAnalytics = "17.4.2"
    const val crashlytics = "17.2.1"
    //endregion

    //region External
    const val anko = "0.10.8"
    const val rxAndroid = "2.1.1"
    const val rxJava = "2.2.16"
    const val retrofit = "2.3.0"
    const val gsonConverter = "2.8.1"
    const val loggingInterceptor = "3.9.1"
    const val rxJavaAdapter = "2.3.0"
    const val glide = "4.11.0"
    const val dagger = "2.25.4"
    const val ktlint = "0.36.0"
    const val chuck = "1.1.0"
    const val leakCanary = "2.4"
    //endregion

    //region Tests
    const val junit = "4.13"
    const val mockitoInline = "3.3.3"
    const val mockitoKotlin = "2.2.0"
    const val archTesting = "2.1.0"

    const val junitAndroid = "1.1.1"
    const val espresso = "3.2.0"
    const val test = "1.2.0"
    const val testJunit = "1.1.1"
    const val multidexInstrumentation = "2.0.0"
    //endregion
}
