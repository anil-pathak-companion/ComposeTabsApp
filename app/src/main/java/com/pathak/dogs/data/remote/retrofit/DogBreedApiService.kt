package com.pathak.dogs.data.remote.retrofit

import com.pathak.dogs.data.model.DogBreedsResponse
import com.pathak.dogs.ui.common.BreedImageResponse
import retrofit2.http.GET

interface DogBreedApiService {

    @GET("api/breeds/list/all")
    suspend fun getBreeds(): DogBreedsResponse

    @GET("api/breed/hound/images/random")
    suspend fun getBreedImage(breedName: String): BreedImageResponse
}