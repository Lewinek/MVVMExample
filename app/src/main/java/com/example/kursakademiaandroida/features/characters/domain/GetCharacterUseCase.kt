package com.example.kursakademiaandroida.features.characters.domain

import com.example.kursakademiaandroida.core.base.UseCase
import com.example.kursakademiaandroida.features.characters.domain.model.Character
import com.example.kursakademiaandroida.features.characters.presentation.CharacterRepository

class GetCharacterUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}