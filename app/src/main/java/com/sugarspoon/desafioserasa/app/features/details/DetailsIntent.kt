package com.sugarspoon.desafioserasa.app.features.details

import com.sugarspoon.domain.model.Result

sealed class DetailsIntent {
    data class InitUi(val character: Result?) : DetailsIntent()
    data class EvaluateDescription(val description: String) : DetailsIntent()
}
