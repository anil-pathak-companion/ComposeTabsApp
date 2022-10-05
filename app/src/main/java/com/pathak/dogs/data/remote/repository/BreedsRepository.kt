package com.pathak.dogs.data.remote.repository

import com.pathak.dogs.data.model.Breeds

interface BreedsRepository {

    suspend fun getAllBreeds(): com.pathak.dogs.data.base.Result<Breeds>
}