package com.example.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.*
import com.example.kursakademiaandroida.core.base.UiState
import com.example.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.example.kursakademiaandroida.features.episodes.domain.model.Episode
import com.example.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeViewModel(private val getEpisodesUseCase: GetEpisodesUseCase) : ViewModel() {

    private val _uiState by lazy { MutableLiveData<UiState>(UiState.Idle) }

    val uiState: LiveData<UiState> = _uiState

    private val _episodes by lazy {
        MutableLiveData<List<Episode>>()
            .also { getEpisodes(it) }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> by lazy {
        _episodes.map { episodes ->
            episodes.map { EpisodeDisplayable(it) }
        }
    }

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        setPendingState()
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { episodes ->
                episodeLiveData.value = episodes
            }
            result.onFailure {}

        }
    }

    private fun setIdleState() {
        _uiState.value = UiState.Idle
    }

    private fun setPendingState() {
        _uiState.value = UiState.Pending
    }
}
