package com.sugarspoon.domain.model

data class Stories(
    val available: String,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: String
)

val fakeStories = Stories(
    available = "",
    collectionURI = "",
    items = listOf(),
    returned = ""
)