package com.example.kursakademiaandroida.features.episodes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodeFragment : Fragment() {

    private val viewModel: EpisodeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeEpisodes()
        observeUiState()
        observeMessage()
    }

    private fun observeMessage() {
        viewModel.message.observe(this) {
            showToast(it)
        }
    }

    private fun showToast(it: String?) {
        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
    }

    private fun observeUiState() {
        viewModel.uiState.observe(this) {
            when (it) {
                UiState.Idle -> onIdleState()
                UiState.Pending -> onPendingState()
            }
        }
    }

    private fun onIdleState() {
        //handle idle state
    }

    private fun onPendingState() {
        //handle pending state
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            //code to display episodes
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_episode, container, false)
    }

}