package com.example.kursakademiaandroida.features.location.domain

import com.example.kursakademiaandroida.features.location.domain.model.Location

interface LocationRepository {
    suspend fun getLocation(): List<Location>
}