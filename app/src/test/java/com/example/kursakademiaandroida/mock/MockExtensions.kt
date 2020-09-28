package com.example.kursakademiaandroida.mock

import com.example.kursakademiaandroida.core.api.model.*
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterLocationCached
import com.example.kursakademiaandroida.features.characters.data.local.model.OriginCached
import com.example.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.example.kursakademiaandroida.features.episodes.domain.model.Episode
import com.example.kursakademiaandroida.features.location.data.local.model.LocationCached
import com.example.kursakademiaandroida.features.location.domain.model.Location
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

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 2,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character typ",
    gender = "character gender",
    origin = OriginRemote.mock(),
    characterLocation = CharacterLocationRemote.mock(),
    image = "character image",
    episodes = emptyList(),
    url = "character url",
    created = "example data"
)

@TestOnly
fun OriginRemote.Companion.mock() = OriginRemote(
    name = "origin name",
    url = "origin url"
)

@TestOnly
fun CharacterLocationRemote.Companion.mock() = CharacterLocationRemote(
    name = "origin name",
    url = "origin url"
)

@TestOnly
fun CharactersResponse.Companion.mock() = CharactersResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 2,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character typ",
    gender = "character gender",
    origin = OriginCached.mock(),
    characterLocation = CharacterLocationCached.mock(),
    image = "character image",
    episodes = emptyList(),
    url = "character url"
)

@TestOnly
fun OriginCached.Companion.mock() = OriginCached(
    name = "origin name",
    url = "origin url"
)

@TestOnly
fun CharacterLocationCached.Companion.mock() = CharacterLocationCached(
    name = "origin name",
    url = "origin url"
)


@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 3,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url",
    created = "example data"
)

@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 3,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun Location.Companion.mock() = Location(
    id = 3,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 2,
    name = "episode name",
    airDate = "episode airDate",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)


