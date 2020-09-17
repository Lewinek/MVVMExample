package com.example.kursakademiaandroida.features.location.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kursakademiaandroida.features.location.data.local.model.LocationCached

interface LocationDao {
    @Query("SELECT * from episodecached")
    suspend fun getLocations(): List<LocationCached>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(vararg episode: LocationCached)
}