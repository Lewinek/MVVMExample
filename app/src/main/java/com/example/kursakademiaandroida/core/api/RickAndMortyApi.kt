package com.example.kursakademiaandroida.core.api

import com.example.kursakademiaandroida.core.api.model.CharactersResponse
import com.example.kursakademiaandroida.core.api.model.EpisodesResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episodes")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("character")
    suspend fun getCharacters(): CharactersResponse
}