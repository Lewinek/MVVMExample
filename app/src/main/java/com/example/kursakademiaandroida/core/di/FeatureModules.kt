package com.example.kursakademiaandroida.core.di

import com.example.kursakademiaandroida.features.episodes.di.episodeModule
import org.koin.core.module.Module


var featureModules = listOf<Module>(
    episodeModule
)