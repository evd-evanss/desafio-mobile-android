package com.sugarspoon.desafioserasa.app.features.details

import com.sugarspoon.desafioserasa.app.base.BaseViewModel
import com.sugarspoon.domain.model.Result
import javax.inject.Inject

class DetailsViewModel @Inject constructor() : BaseViewModel<DetailsIntent, DetailsState>() {

    override fun handle(intent: DetailsIntent) {
        when (intent) {
            is DetailsIntent.InitUi -> handleArgs(intent.character)
            is DetailsIntent.EvaluateDescription -> evaluateDescription(intent.description)
        }
    }

    private fun handleArgs(character: Result?) = character?.run {
        _state.value = DetailsState.LoadUi(result = this)
    }

    private fun evaluateDescription(description: String) {
        if(description.isEmpty()) {
            _state.value = DetailsState.LoadPlaceHolderDescription
        } else {
            _state.value = null
        }
    }
}