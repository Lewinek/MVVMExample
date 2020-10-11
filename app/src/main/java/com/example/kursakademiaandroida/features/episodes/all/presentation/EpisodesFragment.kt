package com.example.kursakademiaandroida.features.episodes.all.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodesFragment : BaseFragment<EpisodesViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodesViewModel by viewModel()
    private val adapter: EpisodeAdapter by inject()
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
        episodes_progress_bar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        episodes_progress_bar.visibility = View.VISIBLE
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            adapter.setEpisodes(it)
        }
    }

    private fun initRecycler() {
        adapter.onEpisodeClickListener = { viewModel.onEpisodeClick(it) }
        episodes_recycler_view.adapter = adapter
        episodes_recycler_view.addItemDecoration(dividerItemDecoration)
    }
}