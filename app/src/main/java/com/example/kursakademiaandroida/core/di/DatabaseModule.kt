package com.example.kursakademiaandroida.core.di

import androidx.room.Room
import com.example.kursakademiaandroida.core.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "database")
    }

    single { get<AppDatabase>().episodeDao() }
}