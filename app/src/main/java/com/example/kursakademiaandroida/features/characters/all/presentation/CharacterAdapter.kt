package com.example.kursakademiaandroida.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters = mutableListOf<CharacterDisplayable>()
    lateinit var onCharacterClickListener: (CharacterDisplayable) -> Unit

    fun setCharacters(_characters: List<CharacterDisplayable>) {
        if (characters.isNotEmpty()) characters.clear()
        characters.addAll(_characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_episode, parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character, onCharacterClickListener)
    }

    override fun getItemCount(): Int = characters.size

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            character: CharacterDisplayable,
            onCharacterClickListener: (CharacterDisplayable) -> Unit
        ) {
            with(itemView) {
                setOnClickListener { onCharacterClickListener.invoke(character) }
                item_character_name.text = character.name
            }
        }
    }
}