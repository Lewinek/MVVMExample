package com.example.kursakademiaandroida.features.characters.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.kursakademiaandroida.core.base.BaseViewModel
import com.example.kursakademiaandroida.core.exception.ErrorMapper
import com.example.kursakademiaandroida.features.characters.domain.GetCharacterUseCase
import com.example.kursakademiaandroida.features.characters.domain.model.Character
import com.example.kursakademiaandroida.features.characters.presentation.model.CharacterDisplayable

class CharacterViewModel(
    private val getCharacterUseCase: GetCharacterUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also { getCharacters(it) }
    }

    val characters: LiveData<List<CharacterDisplayable>> by lazy {
        _characters.map { characters ->
            characters.map { CharacterDisplayable(it) }
        }
    }

    private fun getCharacters(characterLiveData: MutableLiveData<List<Character>>) {
        setPendingState()
        getCharacterUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { characterLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}