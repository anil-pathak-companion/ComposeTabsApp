package com.pathak.dogs.data.remote.repository

import com.pathak.dogs.data.model.BreedsDTO

interface BreedsRepository {

    suspend fun getAllBreeds(): com.pathak.dogs.data.base.Result<List<BreedsDTO>>
}