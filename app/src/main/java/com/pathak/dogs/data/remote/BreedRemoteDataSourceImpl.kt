package com.pathak.dogs.data.remote

import com.pathak.dogs.data.model.BreedsDTO
import com.pathak.dogs.data.remote.retrofit.DogBreedApiService
import javax.inject.Inject

class BreedRemoteDataSourceImpl @Inject constructor(
    private val breedApiService: DogBreedApiService,
) : BreedRemoteDataSource {
    override suspend fun getBreeds(): List<BreedsDTO> {
        return breedApiService.getBreeds().getBreeds()
    }

    override suspend fun getBreedImage(breedName: String): String {
        return breedApiService.getBreedImage(breedName).url
    }
}