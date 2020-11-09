package com.example.kursakademiaandroida.features.location.details

import com.example.kursakademiaandroida.BR
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import com.example.kursakademiaandroida.databinding.FragmentLocationDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationDetailsFragment :
    BaseFragment<LocationViewModel, FragmentLocationDetailsBinding>(BR.viewModel,
        R.layout.fragment_location_details) {

    override val viewModel: LocationViewModel by viewModel()

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }
}