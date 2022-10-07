package com.pathak.dogs.data.local

import com.pathak.dogs.data.local.entites.BreedEntity
import com.pathak.dogs.data.model.Breed

interface BreedLocalDataSource {
    suspend fun getAllBreeds(): List<Breed>
    suspend fun updateFavState(breedsDTO: Breed)
    suspend fun insertAllBreeds(breed: List<BreedEntity>)
}