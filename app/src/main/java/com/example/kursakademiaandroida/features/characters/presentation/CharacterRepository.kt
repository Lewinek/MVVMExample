package com.example.kursakademiaandroida.features.characters.presentation

import com.example.kursakademiaandroida.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}