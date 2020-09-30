package com.example.kursakademiaandroida.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = featureModules
    .plus(networkModule)
    .plus(databaseModule)
    .plus(appModule)
