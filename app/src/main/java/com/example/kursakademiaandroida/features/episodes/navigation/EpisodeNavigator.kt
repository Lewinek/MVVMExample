package com.example.kursakademiaandroida.features.episodes.navigation

import com.example.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

interface EpisodeNavigator {
    fun openEpisodeDetailsScreen(episode: EpisodeDisplayable)
    fun goBack()
}