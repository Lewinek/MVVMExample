package com.example.kursakademiaandroida.features.characters.presentation.model

import com.example.kursakademiaandroida.features.characters.domain.model.CharacterLocation

data class CharacterLocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )
}