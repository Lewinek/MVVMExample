package com.example.kursakademiaandroida.features.characters.presentation

import androidx.lifecycle.observe
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()

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
        viewModel.characters.observe(this) {
            //code to display episodes
        }
    }
}