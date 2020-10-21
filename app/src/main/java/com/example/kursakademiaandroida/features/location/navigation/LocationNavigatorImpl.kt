package com.example.kursakademiaandroida.features.location.navigation

import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.navigation.FragmentNavigator
import com.example.kursakademiaandroida.features.location.all.presentation.model.LocationDisplayable
import com.example.kursakademiaandroida.features.location.details.LocationDetailsFragment

class LocationNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : LocationNavigator {
    override fun openLocationDetailsScreen(location: LocationDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_locations_screen_to_location_details_screen,
            LocationDetailsFragment.LOCATION_DETAILS_KEY to location
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}