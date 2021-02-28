package com.sugarspoon.domain.model

data class Comics(
    val available: String,
    val collectionURI: String,
    val items: List<Item>,
    val returned: String
)

val fakeComics = Comics(
    available = "",
    collectionURI = "",
    items = listOf(fakeItem),
    returned = ""
)