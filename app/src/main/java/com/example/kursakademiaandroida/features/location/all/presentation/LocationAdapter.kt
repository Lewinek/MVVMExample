package com.example.kursakademiaandroida.features.location.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.features.location.all.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.item_episode.view.*

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private val locations = mutableListOf<LocationDisplayable>()
    lateinit var onLocationClickListener: (LocationDisplayable) -> Unit

    fun setLocations(_locations: List<LocationDisplayable>) {
        if (locations.isNotEmpty()) locations.clear()
        locations.addAll(_locations)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_location, parent, false))
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location, onLocationClickListener)
    }

    override fun getItemCount(): Int = locations.size

    class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            location: LocationDisplayable,
            onLocationClickListener: (LocationDisplayable) -> Unit
        ) {
            with(itemView) {
                setOnClickListener { onLocationClickListener.invoke(location) }
                item_episode_name.text = location.name
            }
        }
    }
}