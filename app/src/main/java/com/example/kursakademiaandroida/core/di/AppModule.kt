package com.example.kursakademiaandroida.core.di

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val NUMBER_OF_COLUMNS = 2

val appModule = module {

    factory {
        LinearLayoutManager(androidContext())
    }

    factory {
        GridLayoutManager(androidContext(), NUMBER_OF_COLUMNS)
    }

    factory {
        DividerItemDecoration(androidContext(), LinearLayoutManager.HORIZONTAL)
    }
}