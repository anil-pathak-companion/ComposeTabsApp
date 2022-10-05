package com.pathak.dogs.data.remote.repository

import com.pathak.dogs.data.model.Breeds
import com.pathak.dogs.data.remote.retrofit.DogBreedApiService
import javax.inject.Inject

class BreedsRepositoryImpl @Inject constructor(private val breedApiService: DogBreedApiService) :
    BreedsRepository {

    override suspend fun getAllBreeds(): com.pathak.dogs.data.base.Result<Breeds> = try {
        val response = breedApiService.getBreeds()
        com.pathak.dogs.data.base.Result.Success(response.breeds)
    } catch (e: Exception) {
        com.pathak.dogs.data.base.Result.Error(e)
    }
}