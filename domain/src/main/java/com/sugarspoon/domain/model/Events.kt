package com.sugarspoon.domain.model

data class Events(
    val available: String,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: String
)

val fakeEvents = Events(
    available = "",
    collectionURI = "",
    items = listOf(),
    returned = ""
)