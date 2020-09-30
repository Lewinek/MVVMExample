package com.example.kursakademiaandroida.features.episodes.navigation

import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.navigation.FragmentNavigator

class EpisodeNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : EpisodeNavigator {

    override fun openEpisodeDetailsScreen() {
        fragmentNavigator.navigateTo(R.id.action_navigate_from_episodes_screen_to_episode_details_screen)
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}