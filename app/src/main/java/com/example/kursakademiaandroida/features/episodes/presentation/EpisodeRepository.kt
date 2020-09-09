package com.example.kursakademiaandroida.features.episodes.presentation

import com.example.kursakademiaandroida.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}