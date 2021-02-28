package com.sugarspoon.desafioandroid.features.characters

import com.sugarspoon.desafioandroid.base.BaseViewModel
import com.sugarspoon.data.usecase.UseCaseCharacters
import com.sugarspoon.desafioandroid.utils.extensions.singleSubscribe
import com.sugarspoon.domain.model.Result
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val useCaseCharacters: UseCaseCharacters
) : BaseViewModel<CharactersIntent, CharactersState>() {

    private var limit = LIMIT_DEFAULT
    private var dataIsInitialized = false

    override fun handle(intent: CharactersIntent) {
        when (intent) {
            is CharactersIntent.LoadData -> loadData()
            is CharactersIntent.LoadVerticalAdapter -> loadVerticalAdapter()
            is CharactersIntent.OpenDetails -> openDetails(character = intent.character)
        }
    }

    private fun loadData() {
        compositeDisposable.add(
            useCaseCharacters.getCharacters(OFF_SET_CAROUSEL, LIMIT_DEFAULT).singleSubscribe(
                onLoading = {
                    _state.value = CharactersState.Loading(isLoading = it)
                },
                onSuccess = {
                    _state.value = CharactersState.LoadCarousel(it)
                    dataIsInitialized = true
                },
                onError = {
                    _state.value = CharactersState.Error(message = it.message ?: "")
                }
            )
        )
        if(!dataIsInitialized) {
            loadVerticalAdapter()
        }
    }

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

    private fun openDetails(character: Result) = _state.postValue(
        CharactersState.OpenDetails(
            character = character
        )
    )

    private fun updateOffSet() {
        limit += SUM_FACTOR
        if (limit == (OFF_SET_LIMIT - 1)) {
            limit++
        }
        if (limit > OFF_SET_LIMIT) {
            limit = OFF_SET_DEFAULT
        }
    }

    override fun onCleared() {
        super.onCleared()
        _state.value = null
        compositeDisposable.dispose()
    }

    companion object {
        private const val OFF_SET_CAROUSEL = 0
        private const val OFF_SET_LIMIT = 100
        private const val OFF_SET_DEFAULT = 5
        private const val LIMIT_DEFAULT = 5
        private const val SUM_FACTOR = 2
    }
}