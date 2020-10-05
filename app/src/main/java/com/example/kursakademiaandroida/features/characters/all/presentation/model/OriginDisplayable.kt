package com.example.kursakademiaandroida.features.characters.all.presentation.model

import com.example.kursakademiaandroida.features.characters.domain.model.Origin

data class OriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: Origin) : this(
        name = origin.name,
        url = origin.url
    )
}