package com.sugarspoon.domain.model

data class Series(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: String
)

val fakeSeries = Series(
    available = "",
    collectionURI = "",
    items = listOf(),
    returned = ""
)