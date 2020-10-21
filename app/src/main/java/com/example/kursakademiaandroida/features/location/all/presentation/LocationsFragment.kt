package com.example.kursakademiaandroida.features.location.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import com.example.kursakademiaandroida.BR
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import com.example.kursakademiaandroida.databinding.FragmentLocationBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationsFragment : BaseFragment<LocationsViewModel, FragmentLocationBinding>(BR.viewModel,
    R.layout.fragment_location) {

    override val viewModel: LocationsViewModel by viewModel()
    private val locationAdapter: LocationAdapter by inject()
    private val dividerItemDecoration: DividerItemDecoration by inject()

    override fun initViews(binding: FragmentLocationBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentLocationBinding) {
        with(binding.locationsRecyclerView) {
            locationAdapter.onLocationClickListener = { viewModel.onLocationClick(it) }
            adapter = locationAdapter
            addItemDecoration(dividerItemDecoration)
        }
    }
}