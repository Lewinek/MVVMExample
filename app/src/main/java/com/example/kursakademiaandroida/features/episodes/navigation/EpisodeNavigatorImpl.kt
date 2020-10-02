package com.example.kursakademiaandroida.features.episodes.navigation

import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.navigation.FragmentNavigator
import com.example.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.kursakademiaandroida.features.episodes.details.EpisodeDetailsFragment

class EpisodeNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : EpisodeNavigator {

    override fun openEpisodeDetailsScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_episodes_screen_to_episode_details_screen,
            EpisodeDetailsFragment.EPISODE_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}