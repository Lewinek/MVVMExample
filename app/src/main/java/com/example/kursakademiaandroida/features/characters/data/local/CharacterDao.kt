package com.example.kursakademiaandroida.features.characters.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kursakademiaandroida.features.characters.data.local.model.CharacterCached

interface CharacterDao {

    @Query("SELECT * from charactercached")
    suspend fun getCharacters(): List<CharacterCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(vararg character: CharacterCached)
}