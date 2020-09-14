package com.example.kursakademiaandroida.features.characters.data.local.model

import com.example.kursakademiaandroida.features.characters.domain.model.CharacterLocation

data class CharacterLocationCached(
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )

    companion object

    fun toCharacterLocation() = CharacterLocation(
        name = name,
        url = url
    )
}