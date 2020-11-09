package com.example.kursakademiaandroida.features.characters.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import com.example.kursakademiaandroida.BR
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import com.example.kursakademiaandroida.databinding.FragmentCharacterBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharactersFragment : BaseFragment<CharactersViewModel, FragmentCharacterBinding>(BR.viewModel,
    R.layout.fragment_character) {

    override val viewModel: CharactersViewModel by viewModel()
    private val characterAdapter: CharacterAdapter by inject()
    private val dividerItemDecoration: DividerItemDecoration by inject()

    override fun initViews(binding: FragmentCharacterBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: FragmentCharacterBinding) {
        with(binding.charactersRecyclerView) {
            characterAdapter.onCharacterClickListener = { viewModel.onCharacterClick(it) }
            adapter = characterAdapter
            addItemDecoration(dividerItemDecoration)
        }
    }
}