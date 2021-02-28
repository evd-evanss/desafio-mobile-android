package com.sugarspoon.desafioserasa.app.features.characters

import com.sugarspoon.desafioserasa.app.base.BaseViewModel
import com.sugarspoon.desafioserasa.data.usecase.UseCaseCharacters
import com.sugarspoon.desafioserasa.utils.extensions.singleSubscribe
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val useCaseCharacters: UseCaseCharacters
) : BaseViewModel<CharactersIntent, CharactersState>() {

    var limit = LIMIT_DEFAULT

    override fun handle(intent: CharactersIntent) {
        when (intent) {
            is CharactersIntent.LoadData -> loadData()
            is CharactersIntent.LoadVerticalAdapter -> loadVerticalAdapter()
        }
    }

    private fun loadData() = compositeDisposable.add(
        useCaseCharacters.getCharacters(OFF_SET_CAROUSEL, LIMIT_DEFAULT).singleSubscribe(
            onLoading = {
                _state.value = CharactersState.Loading(isLoading = it)
            },
            onSuccess = {
                _state.value = CharactersState.LoadCarousel(it)
                handle(CharactersIntent.LoadVerticalAdapter)
            },
            onError = {
                _state.value = CharactersState.Error(message = it.message ?: "")
            }
        )
    )

    private fun loadVerticalAdapter() {
        compositeDisposable.add(
            useCaseCharacters.getCharacters(OFF_SET_DEFAULT, limit).singleSubscribe(
                onLoading = {
                    _state.value = CharactersState.Loading(isLoading = it)
                },
                onSuccess = {
                    updateOffSet()
                    _state.value = it?.let { it1 -> CharactersState.LoadVerticalAdapter(it1) }
                },
                onError = {
                    _state.value = CharactersState.Error(message = it.message ?: "")
                }
            )
        )
    }

    private fun updateOffSet() {
        limit += SUM_FACTOR
        if(limit == (OFF_SET_LIMIT -1)) {
            limit ++
        }
        if(limit > OFF_SET_LIMIT) {
            limit = OFF_SET_DEFAULT
        }
    }

    companion object {
        private const val OFF_SET_CAROUSEL = 0
        private const val OFF_SET_LIMIT = 100
        private const val OFF_SET_DEFAULT = 5
        private const val LIMIT_DEFAULT = 5
        private const val SUM_FACTOR = 2
    }
}