package com.pathak.dogs.data.local.dao

import androidx.room.*
import com.pathak.dogs.data.local.entites.BreedEntity
import java.util.*

@Dao
interface BreedDao {
    @Insert
    suspend fun insert(rate: BreedEntity)

    @Insert
    suspend fun insertAll(rate: List<BreedEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBreed(rate: BreedEntity)

    @Query("Select * from breed")
    suspend fun getBreeds(): List<BreedEntity>

    @Query("Select * from breed where parentBreed=:breedId")
    suspend fun getAllSubBreedsByBreedId(breedId: UUID): List<BreedEntity>

    @Query("Select * from breed where isFav=:isFav")
    suspend fun getFavBreeds(isFav: Boolean = true): List<BreedEntity>

    @Query("Delete from breed")
    suspend fun deleteAllRates()
}