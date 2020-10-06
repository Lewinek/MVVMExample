package com.example.kursakademiaandroida.features.location.di

import com.example.kursakademiaandroida.features.location.all.presentation.LocationFragment
import com.example.kursakademiaandroida.features.location.all.presentation.LocationViewModel
import com.example.kursakademiaandroida.features.location.data.repository.LocationRepositoryImpl
import com.example.kursakademiaandroida.features.location.domain.GetLocationsUseCase
import com.example.kursakademiaandroida.features.location.domain.LocationRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationViewModel(get(), get()) }
    factory { LocationFragment() }
}