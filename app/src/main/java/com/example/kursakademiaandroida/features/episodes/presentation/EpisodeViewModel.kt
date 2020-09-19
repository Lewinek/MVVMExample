package com.example.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.example.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeViewModel(private val getEpisodesUseCase: GetEpisodesUseCase) : ViewModel() {

    val episodes by lazy {
        MutableLiveData<List<EpisodeDisplayable>>()
            .also { }
    }

    fun getEpisodes(episodeLiveData: MutableLiveData<List<EpisodeDisplayable>>) {
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            result.onSuccess { episodes ->
                episodeLiveData.value = episodes.map { EpisodeDisplayable(it) }
            }
            result.onFailure {}

        }
    }
}
