package com.sugarspoon.buildsources

object Dependency {

    object Plugin {
        const val ktlint = "com.pinterest:ktlint:${Version.ktlint}"
    }

    object Classpath {
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
        const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
        const val googleServices = "com.google.gms:google-services:${Version.googleServices}"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:${Version.classpathCrashlytics}"
        const val appDistribution = "com.google.firebase:firebase-appdistribution-gradle:${Version.classpathAppDistribution}"
        const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigation}"
    }

    object Module {
        const val data = ":data"
        const val designSystem = ":android-design-system"
    }

    object Core {
        const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
        const val multidex = "androidx.multidex:multidex:${Version.multidex}"
        const val core = "androidx.core:core-ktx:${Version.core}"
        const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.viewModel}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.liveData}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    }

    object UI {
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
        const val cardView = "androidx.cardview:cardview:${Version.cardView}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Version.recyclerView}"
        const val material = "com.google.android.material:material:${Version.material}"
    }

    object DI {
        const val dagger = "com.google.dagger:dagger:${Version.dagger}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    }

    object Firebase {
        const val firebaseCore = "com.google.firebase:firebase-core:${Version.firebaseCore}"
        const val firebaseMessaging = "com.google.firebase:firebase-messaging:${Version.firebaseMessaging}"
        const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx:${Version.firebaseAnalytics}"
        const val crashlytics = "com.google.firebase:firebase-crashlytics:${Version.crashlytics}"
    }

    object External {
        const val anko = "org.jetbrains.anko:anko:${Version.anko}"
        const val biometric = "androidx.biometric:biometric:${Version.biometric}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.gsonConverter}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.loggingInterceptor}"
        const val rxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Version.rxJavaAdapter}"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"
        const val rxJava = "io.reactivex.rxjava2:rxjava:${Version.rxJava}"
        const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
        const val chuck = "com.readystatesoftware.chuck:library:${Version.chuck}"
        const val chuckNoOp = "com.readystatesoftware.chuck:library-no-op:${Version.chuck}"
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.leakCanary}"
    }

    object Test {
        const val junit = "junit:junit:${Version.junit}"
        const val mockitoInline = "org.mockito:mockito-inline:${Version.mockitoInline}"
        const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Version.mockitoKotlin}"
        const val archTesting = "androidx.arch.core:core-testing:${Version.archTesting}"

        const val junitAndroid = "androidx.test.ext:junit:${Version.junitAndroid}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espresso}"
        const val espressoIntents = "androidx.test.espresso:espresso-intents:${Version.espresso}"
        const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Version.espresso}"
        const val testRules = "androidx.test:rules:${Version.test}"
        const val testRunner = "androidx.test:runner:${Version.test}"
        const val testJunit = "androidx.test.ext:junit:${Version.testJunit}"
        const val multidexInstrumentation = "androidx.multidex:multidex-instrumentation:${Version.multidexInstrumentation}"
    }
}
