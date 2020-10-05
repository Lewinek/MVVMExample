package com.example.kursakademiaandroida.features.episodes.all.presentation

import androidx.lifecycle.observe
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodesFragment : BaseFragment<EpisodesViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodesViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        //initialize all view-related classes
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
        //handle idle state here
    }

    override fun onPendingState() {
        super.onPendingState()
        //handle pending state here
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            //code to display episodes
        }
    }
}