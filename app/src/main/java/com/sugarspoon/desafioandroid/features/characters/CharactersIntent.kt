package com.sugarspoon.desafioandroid.features.characters

import com.sugarspoon.domain.model.Result

sealed class CharactersIntent {
    data class OpenDetails(val character: Result) : CharactersIntent()
    object LoadData : CharactersIntent()
    object LoadVerticalAdapter : CharactersIntent()
}
