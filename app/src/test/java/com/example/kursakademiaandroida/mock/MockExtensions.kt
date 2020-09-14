package com.example.kursakademiaandroida.mock

import com.example.kursakademiaandroida.core.api.model.EpisodeRemote
import com.example.kursakademiaandroida.core.api.model.EpisodesResponse
import com.example.kursakademiaandroida.core.api.model.ResponseInfo
import com.example.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 2,
    name = "episode name",
    airDate = "episode airDate",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "example data"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 2,
    name = "episode name",
    airDate = "episode airDate",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)