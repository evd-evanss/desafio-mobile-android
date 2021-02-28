package com.sugarspoon.desafioandroid.features.details

import com.sugarspoon.domain.model.Result

sealed class DetailsState {
    data class LoadUi(val result: Result) : DetailsState()
    object LoadPlaceHolderDescription : DetailsState()
}
