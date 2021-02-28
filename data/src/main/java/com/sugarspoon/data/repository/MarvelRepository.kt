package com.sugarspoon.data.repository

import com.sugarspoon.data.service.MarvelApiService
import com.sugarspoon.data.source.MarvelDataSource
import retrofit2.Retrofit
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    retrofit: Retrofit.Builder
): MarvelDataSource {
    private val service: MarvelApiService =
        retrofit.build().create(MarvelApiService::class.java)

    override fun getCharacters(offset: Int, limit: Int) = service.getCharacters(offset, limit).map {
            it.data.results
        }
}


