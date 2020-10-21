package com.example.kursakademiaandroida.features.episodes.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import com.example.kursakademiaandroida.BR
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import com.example.kursakademiaandroida.databinding.FragmentEpisodeBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodesFragment : BaseFragment<EpisodesViewModel, FragmentEpisodeBinding>(BR.viewModel,
    R.layout.fragment_episode) {

    override val viewModel: EpisodesViewModel by viewModel()
    private val episodeAdapter: EpisodeAdapter by inject()
    private val dividerItemDecoration: DividerItemDecoration by inject()

    override fun initViews(binding: FragmentEpisodeBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentEpisodeBinding) {
        with(binding.episodesRecyclerView) {
            episodeAdapter.onEpisodeClickListener = { viewModel.onEpisodeClick(it) }
            adapter = episodeAdapter
            addItemDecoration(dividerItemDecoration)
        }
    }
}