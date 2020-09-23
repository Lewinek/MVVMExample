package com.example.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.*
import com.example.kursakademiaandroida.core.base.UiState
import com.example.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.example.kursakademiaandroida.features.episodes.domain.model.Episode
import com.example.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable
import com.hadilq.liveevent.LiveEvent

class EpisodeViewModel(private val getEpisodesUseCase: GetEpisodesUseCase) : ViewModel() {

    private val _message by lazy { LiveEvent<String>() }

    val message: LiveEvent<String> by lazy { _message }

    private val _uiState by lazy { MutableLiveData<UiState>(UiState.Idle) }

    val uiState: LiveData<UiState> by lazy { _uiState }

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

            result.onFailure { throwable ->
                throwable.message
                    ?.let { showMessage(it) }
            }
        }
    }

    private fun showMessage(message: String) {
        _message.value = message
    }

    private fun setIdleState() {
        _uiState.value = UiState.Idle
    }

    private fun setPendingState() {
        _uiState.value = UiState.Pending
    }
}
