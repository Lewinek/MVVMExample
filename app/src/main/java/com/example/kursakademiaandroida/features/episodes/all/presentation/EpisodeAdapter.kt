package com.example.kursakademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import kotlinx.android.synthetic.main.item_episode.view.*

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private val episodes = mutableListOf<EpisodeDisplayable>()
    lateinit var onEpisodeClickListener: (EpisodeDisplayable) -> Unit

    fun setEpisodes(_episodes: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) episodes.clear()
        episodes.addAll(_episodes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_episode, parent, false))
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode, onEpisodeClickListener)
    }

    override fun getItemCount(): Int = episodes.size

    class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            episode: EpisodeDisplayable,
            onEpisodeClickListener: (EpisodeDisplayable) -> Unit
        ) {
            with(itemView) {
                setOnClickListener { onEpisodeClickListener.invoke(episode) }
                item_episode_name.text = episode.name
            }
        }
    }
}