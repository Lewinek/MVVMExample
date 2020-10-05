package com.example.kursakademiaandroida.features.characters.di

import com.example.kursakademiaandroida.features.characters.all.presentation.CharactersFragment
import com.example.kursakademiaandroida.features.characters.all.presentation.CharactersViewModel
import com.example.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import com.example.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.example.kursakademiaandroida.features.characters.domain.GetCharacterUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharacterUseCase(get()) }

    //presentation
    viewModel { CharactersViewModel(get(), get(), get()) }
    factory { CharactersFragment() }
}