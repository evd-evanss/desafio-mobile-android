package com.sugarspoon.desafioserasa.data.usecase

import com.sugarspoon.data.repository.MarvelRepository
import javax.inject.Inject

class UseCaseCharacters @Inject constructor(
    private val marvelRepository: MarvelRepository
) {

    fun getCharacters(
        offSet: Int,
        limit: Int
    ) = marvelRepository.getCharacters(offSet, limit)
}