package com.example.kursakademiaandroida.features.location.navigation

import com.example.kursakademiaandroida.features.location.all.presentation.model.LocationDisplayable

interface LocationNavigator {
    fun openLocationDetailsScreen(location: LocationDisplayable)
    fun goBack()
}