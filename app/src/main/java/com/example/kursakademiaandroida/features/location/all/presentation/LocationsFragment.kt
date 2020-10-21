package com.example.kursakademiaandroida.features.location.all.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_character.*
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsFragment : BaseFragment<LocationsViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationsViewModel by viewModel()
    private val adapter: LocationAdapter by inject()
    private val dividerItemDecoration: DividerItemDecoration by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
        characters_progress_bar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        characters_progress_bar.visibility = View.VISIBLE
    }

    private fun observeEpisodes() {
        viewModel.locations.observe(this) {
            adapter.setLocations(it)
        }
    }

    private fun initRecycler() {
        adapter.onLocationClickListener = { viewModel.onLocationClick(it) }
        locations_recycler_view.adapter = adapter
        locations_recycler_view.addItemDecoration(dividerItemDecoration)
    }
}