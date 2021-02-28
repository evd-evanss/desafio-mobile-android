package com.sugarspoon.desafioandroid.di.modules

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import com.sugarspoon.desafioandroid.BuildConfig
import com.sugarspoon.desafioandroid.utils.extensions.hasNetwork
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    val timestamp = System.currentTimeMillis().toString()

    @Provides
    @Singleton
    fun retrofit(@ApplicationContext context: Context): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(providesOkHttpClient(context))
    }

    @Provides
    fun providesOkHttpClient(@ApplicationContext context: Context) = OkHttpClient.Builder()
        .cache(Cache(context.cacheDir, (5 * 1024 * 1024).toLong()))
        .addInterceptor { chain ->
            var request = chain.request()
            request = if (context.hasNetwork())
                request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
            else
                request.newBuilder().header(
                    "Cache-Control",
                    "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                ).build()
            chain.proceed(request)
        }.addInterceptor(ChuckInterceptor(context))
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
            val originalHttpUrl = chain.request().url
            val url = originalHttpUrl.newBuilder().addQueryParameter(
                "ts",
                timestamp
            ).addQueryParameter(
                "apikey",
                BuildConfig.PUBLIC_KEY
            ).addQueryParameter(
                "hash",
                getMd5()
            ).build()
            request.url(url)
            return@addInterceptor chain.proceed(request.build())
        }
        .build()

    private fun getMd5(): String {
        try {
            val md = MessageDigest.getInstance("MD5")
            val digestMD5 = md.digest(
                timestamp.toByteArray()
                        + BuildConfig.PRIVATE_KEY.toByteArray()
                        + BuildConfig.PUBLIC_KEY.toByteArray()
            )
            val value = BigInteger(1, digestMD5)
            var hashtext = value.toString(16)
            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }
            return hashtext
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }
}