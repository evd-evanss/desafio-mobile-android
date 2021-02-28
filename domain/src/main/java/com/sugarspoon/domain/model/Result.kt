package com.sugarspoon.domain.model

import java.io.Serializable

data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: String,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: Thumbnail,
    val urls: List<Url>
) : Serializable

val mockResult = Result(
    comics = fakeComics,
    description = "Homem de Ferro",
    events = fakeEvents,
    id = "",
    modified = "",
    name = "",
    resourceURI = "",
    series = fakeSeries,
    stories = fakeStories,
    thumbnail = fakeThumbnail,
    urls = listOf()
)