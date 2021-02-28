package com.sugarspoon.domain.model

data class Thumbnail(
    val extension: String,
    val path: String
)

val fakeThumbnail = Thumbnail(
    extension = "",
    path = ""
)

fun Thumbnail.toPath() = "${path.replace("http", "https")}.$extension"