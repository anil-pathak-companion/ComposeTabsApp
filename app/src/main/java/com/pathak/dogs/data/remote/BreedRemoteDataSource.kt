package com.pathak.dogs.data.remote

import com.pathak.dogs.data.model.BreedsDTO

interface BreedRemoteDataSource {
    suspend fun getBreeds(): List<BreedsDTO>
    suspend fun getBreedImage(breedName: String): String
}