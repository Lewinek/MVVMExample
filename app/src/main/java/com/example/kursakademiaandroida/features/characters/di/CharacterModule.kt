package com.example.kursakademiaandroida.features.characters.di

import com.example.kursakademiaandroida.features.characters.all.presentation.CharacterAdapter
import com.example.kursakademiaandroida.features.characters.all.presentation.CharactersFragment
import com.example.kursakademiaandroida.features.characters.all.presentation.CharactersViewModel
import com.example.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import com.example.kursakademiaandroida.features.characters.details.CharacterDetailsFragment
import com.example.kursakademiaandroida.features.characters.details.CharacterViewModel
import com.example.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.example.kursakademiaandroida.features.characters.domain.GetCharacterUseCase
import com.example.kursakademiaandroida.features.characters.navigation.CharacterNavigator
import com.example.kursakademiaandroida.features.characters.navigation.CharacterNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharacterUseCase(get()) }

    //presentation
    viewModel { CharactersViewModel(get(), get(), get()) }
    viewModel { CharacterViewModel() }
    factory { CharactersFragment() }
    factory { CharacterDetailsFragment() }
    factory { CharacterAdapter() }

    //navigation
    factory<CharacterNavigator> { CharacterNavigatorImpl(get()) }
}
