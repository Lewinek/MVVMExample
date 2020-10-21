package com.example.kursakademiaandroida.features.characters.all.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_character.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharactersFragment : BaseFragment<CharactersViewModel>(R.layout.fragment_character) {

    override val viewModel: CharactersViewModel by viewModel()
    private val adapter: CharacterAdapter by inject()
    private val dividerItemDecoration: DividerItemDecoration by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleState() {
        super.onIdleState()
        characters_progress_bar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        characters_progress_bar.visibility = View.VISIBLE
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            adapter.setCharacters(it)
        }
    }

    private fun initRecycler() {
        adapter.onCharacterClickListener = { viewModel.onCharacterClick(it) }
        characters_recycler_view.adapter = adapter
        characters_recycler_view.addItemDecoration(dividerItemDecoration)
    }
}