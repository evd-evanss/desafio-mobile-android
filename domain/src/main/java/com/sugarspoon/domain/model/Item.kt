package com.sugarspoon.domain.model

data class Item(
    val name: String,
    val resourceURI: String
)

val fakeItem = Item(
    name = "Homem de Ferro",
    resourceURI = ""
)