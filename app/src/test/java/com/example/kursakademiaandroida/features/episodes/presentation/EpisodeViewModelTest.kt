package com.example.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.kursakademiaandroida.core.base.UiState
import com.example.kursakademiaandroida.core.exception.ErrorMapper
import com.example.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.example.kursakademiaandroida.features.episodes.domain.model.Episode
import com.example.kursakademiaandroida.mock.mock
import com.example.kursakademiaandroida.utils.ViewModelTest
import com.example.kursakademiaandroida.utils.getOrAwaitValue
import com.example.kursakademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.`should be`
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class EpisodeViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episodes live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN episodes live data is observed THEN invoke use case to get episodes`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        verify { useCase(viewModel.viewModelScope, Unit, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN episodes live data is observed THEN set idle state AND set result in live data`() {
        val episodes = listOf(Episode.mock(), Episode.mock(), Episode.mock())
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.success(episodes))
            }
        }
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.episodes.getOrAwaitValue().forEachIndexed { index, episodeDisplayable ->
            val episode = episodes[index]
            episodeDisplayable.name `should be` episode.name
            episodeDisplayable.airDate `should be` episode.airDate
            episodeDisplayable.code `should be` episode.code
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN episode live data is observed THEN set idle state AND set error message in live data`() {
        val throwable = Throwable("Ops... something went wrong")
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val viewModel = EpisodeViewModel(useCase, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}
