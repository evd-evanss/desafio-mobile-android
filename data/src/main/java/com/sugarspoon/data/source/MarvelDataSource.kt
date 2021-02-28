package com.sugarspoon.data.source

import com.sugarspoon.domain.model.Result
import io.reactivex.Single

interface MarvelDataSource {

    fun getCharacters(offset: Int, limit: Int): Single<List<Result>>
}