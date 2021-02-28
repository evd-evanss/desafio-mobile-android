package com.sugarspoon.desafioserasa.app.features.characters

sealed class CharactersIntent {
    object LoadData : CharactersIntent()
    object LoadVerticalAdapter : CharactersIntent()
}
