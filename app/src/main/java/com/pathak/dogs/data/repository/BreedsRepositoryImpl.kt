package com.pathak.dogs.data.repository

import com.pathak.dogs.data.base.Result
import com.pathak.dogs.data.local.BreedLocalDataSource
import com.pathak.dogs.data.model.Breed
import com.pathak.dogs.data.remote.BreedRemoteDataSource
import javax.inject.Inject

class BreedsRepositoryImpl @Inject constructor(
    private val remoteDataSource: BreedRemoteDataSource,
    private val localDataSource: BreedLocalDataSource
) : BreedsRepository {

    override suspend fun getAllBreeds(): Result<List<Breed>> = try {
        val response = remoteDataSource.getBreeds().map { it.toDomain() }
        localDataSource.insertAllBreeds(response)
        Result.Success(localDataSource.getAllBreeds())
    } catch (e: Exception) {
        Result.Error(e)
    }

    override suspend fun getBreedById(breedId: String): Result<Breed> = try {
        localDataSource.getBreedDetails(breedId = breedId)?.let { breed ->
            Result.Success(breed)
        } ?: Result.Error(java.lang.Exception())
    } catch (e: Exception) {
        Result.Error(e)
    }

    override suspend fun getBreedImage(name: String): Result<String> = try {
        val response = remoteDataSource.getBreedImage(breedName = name)
        Result.Success(response)
    } catch (e: Exception) {
        Result.Error(e)
    }

    override suspend fun updateFavStatusByBreedId(breedId: String, isFav: Boolean) {
        localDataSource.updateFavState(breedId = breedId, isFav = isFav)
    }
}