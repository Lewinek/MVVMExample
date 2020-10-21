package com.example.kursakademiaandroida.features.episodes.details

import com.example.kursakademiaandroida.BR
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import com.example.kursakademiaandroida.databinding.FragmentEpisodeDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodeDetailsFragment :
    BaseFragment<EpisodeViewModel, FragmentEpisodeDetailsBinding>(BR.viewModel,
        R.layout.fragment_episode_details) {

    override val viewModel: EpisodeViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }
}