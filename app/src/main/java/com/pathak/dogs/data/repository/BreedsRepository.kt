package com.pathak.dogs.data.repository

import com.pathak.dogs.data.base.Result
import com.pathak.dogs.data.model.Breed

interface BreedsRepository {

    suspend fun getAllBreeds(): Result<List<Breed>>

    suspend fun getBreedById(breedId: String): Result<Breed>

    suspend fun getBreedImage(name: String): Result<String>

    suspend fun updateFavStatusByBreedId(breedId: String, isFav: Boolean)
}