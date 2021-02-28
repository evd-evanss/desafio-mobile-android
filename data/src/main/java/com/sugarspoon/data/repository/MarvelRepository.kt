package com.sugarspoon.data.repository

import com.sugarspoon.data.service.MarvelApiService
import kotlinx.coroutines.flow.map
import retrofit2.Retrofit
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    retrofit: Retrofit.Builder
) {
    private val service: MarvelApiService =
        retrofit.build().create(MarvelApiService::class.java)

    fun getCharacters(offset: Int, limit: Int) =
        service.getCharacters(offset, limit).map {
            it.data.results
        }
}


