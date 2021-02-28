package com.sugarspoon.desafioserasa.utils

import retrofit2.Retrofit
import javax.inject.Inject

internal class RetrofitServiceFactory @Inject constructor(
    val retrofitBuilder: Retrofit.Builder
) {

    inline fun <reified Service> newInstance(): Service {
        return retrofitBuilder
            .build()
            .create(Service::class.java)
    }
}