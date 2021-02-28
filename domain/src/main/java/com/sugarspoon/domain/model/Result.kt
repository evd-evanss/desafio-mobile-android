package com.sugarspoon.domain.model

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
)

val mockResult = Result(
    comics = fakeComics,
    description = "",
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