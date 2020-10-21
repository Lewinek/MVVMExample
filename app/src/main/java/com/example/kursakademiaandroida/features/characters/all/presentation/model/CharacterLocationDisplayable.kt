package com.example.kursakademiaandroida.features.characters.all.presentation.model

import android.os.Parcelable
import com.example.kursakademiaandroida.features.characters.domain.model.CharacterLocation
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterLocationDisplayable(
    val name: String,
    val url: String
) : Parcelable {

    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )

    companion object
}