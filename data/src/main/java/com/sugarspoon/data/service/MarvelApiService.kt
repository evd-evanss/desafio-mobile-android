package com.sugarspoon.data.service

import com.sugarspoon.domain.response.CharactersResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {

    @GET("characters")
    fun getCharacters(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Single<CharactersResponse>
}