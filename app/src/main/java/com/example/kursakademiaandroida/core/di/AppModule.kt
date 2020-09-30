package com.example.kursakademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.exception.ErrorMapper
import com.example.kursakademiaandroida.core.exception.ErrorMapperImpl
import com.example.kursakademiaandroida.core.exception.ErrorWrapper
import com.example.kursakademiaandroida.core.exception.ErrorWrapperImpl
import com.example.kursakademiaandroida.core.navigation.FragmentNavigator
import com.example.kursakademiaandroida.core.navigation.FragmentNavigatorImpl
import com.example.kursakademiaandroida.core.network.NetworkStateProvider
import com.example.kursakademiaandroida.core.network.NetworkStateProviderImpl
import com.example.kursakademiaandroida.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
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

    factory {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    factory<NetworkStateProvider> {
        NetworkStateProviderImpl(get())
    }

    factory<ErrorWrapper> {
        ErrorWrapperImpl()
    }

    factory<ErrorMapper> {
        ErrorMapperImpl(androidContext())
    }

    single(createdAtStart = true) { ActivityProvider(androidApplication()) }

    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment,
            homeDestinationRes = R.id.characters_screen
        )
    }
}