package com.sugarspoon.desafioserasa.app.features.characters

import com.sugarspoon.domain.model.Result

sealed class CharactersIntent {
    data class OpenDetails(val character: Result) : CharactersIntent()
    object LoadData : CharactersIntent()
    object LoadVerticalAdapter : CharactersIntent()
}
