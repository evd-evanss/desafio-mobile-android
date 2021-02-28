package com.sugarspoon.desafioserasa.app.features.characters

import com.sugarspoon.domain.model.Result

sealed class CharactersState {
    data class Loading(val isLoading: Boolean) : CharactersState()
    data class Error(val message: String) : CharactersState()
    data class LoadCarousel(val items: List<Result>) : CharactersState()
    data class LoadVerticalAdapter(val items: List<Result>) : CharactersState()
}
