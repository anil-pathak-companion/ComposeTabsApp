package com.pathak.dogs.data.remote.retrofit

import com.pathak.dogs.data.model.DogBreedsResponse
import retrofit2.http.GET

interface DogBreedApiService {

    @GET("api/breeds/list/all")
    suspend fun getBreeds() : DogBreedsResponse
}