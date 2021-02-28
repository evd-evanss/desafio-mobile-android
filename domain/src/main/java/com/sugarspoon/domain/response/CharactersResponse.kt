package com.sugarspoon.domain.response

import com.sugarspoon.domain.model.Data

data class CharactersResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val data: Data,
    val etag: String,
    val status: String
)