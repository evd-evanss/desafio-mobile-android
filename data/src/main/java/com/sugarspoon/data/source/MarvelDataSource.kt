package com.sugarspoon.data.source

import com.sugarspoon.data.model.response.CharactersResponse
import kotlinx.coroutines.flow.Flow

interface MarvelDataSource {

    suspend fun getCharacters(): Flow<CharactersResponse>
}