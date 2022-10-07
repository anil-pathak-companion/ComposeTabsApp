package com.pathak.dogs.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pathak.dogs.data.local.entites.BreedEntity
import java.util.*

@Dao
interface BreedDao {
    @Insert
    suspend fun insert(rate: BreedEntity)

    @Insert
    suspend fun insertAll(rate: List<BreedEntity>)

    @Query("Select * from breed")
    suspend fun getBreeds(): List<BreedEntity>

    @Query("Select * from breed where isFav=:isFav")
    suspend fun getFavBreeds(isFav: Boolean = true): List<BreedEntity>

    @Query("Update breed set isFav=:isFav where id=:id")
    suspend fun updateFavStatus(id: UUID, isFav: Boolean)

    @Query("Delete from breed")
    suspend fun deleteAllRates()
}