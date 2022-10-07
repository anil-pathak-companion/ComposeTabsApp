package com.pathak.dogs.data.repository

import com.pathak.dogs.data.model.Breed

interface BreedsRepository {

    suspend fun getAllBreeds(): com.pathak.dogs.data.base.Result<List<Breed>>

    suspend fun getBreedImage(name: String): com.pathak.dogs.data.base.Result<String>
}