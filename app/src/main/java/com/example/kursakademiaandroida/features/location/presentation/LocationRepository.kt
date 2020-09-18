package com.example.kursakademiaandroida.features.location.presentation

import com.example.kursakademiaandroida.features.location.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}