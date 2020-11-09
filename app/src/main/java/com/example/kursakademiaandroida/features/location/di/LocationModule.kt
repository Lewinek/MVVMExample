package com.example.kursakademiaandroida.features.location.di

import com.example.kursakademiaandroida.features.location.all.presentation.LocationAdapter
import com.example.kursakademiaandroida.features.location.all.presentation.LocationsFragment
import com.example.kursakademiaandroida.features.location.all.presentation.LocationsViewModel
import com.example.kursakademiaandroida.features.location.data.repository.LocationRepositoryImpl
import com.example.kursakademiaandroida.features.location.details.LocationDetailsFragment
import com.example.kursakademiaandroida.features.location.details.LocationViewModel
import com.example.kursakademiaandroida.features.location.domain.GetLocationsUseCase
import com.example.kursakademiaandroida.features.location.domain.LocationRepository
import com.example.kursakademiaandroida.features.location.navigation.LocationNavigator
import com.example.kursakademiaandroida.features.location.navigation.LocationNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationsViewModel(get(), get(), get()) }
    viewModel { LocationViewModel() }
    factory { LocationsFragment() }
    factory { LocationDetailsFragment() }
    factory { LocationAdapter() }

    //navigation
    factory<LocationNavigator> { LocationNavigatorImpl(get()) }
}