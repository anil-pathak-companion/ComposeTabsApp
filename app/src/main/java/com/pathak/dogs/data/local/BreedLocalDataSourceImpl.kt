package com.pathak.dogs.data.local

import com.pathak.dogs.data.local.dao.BreedDao
import com.pathak.dogs.data.local.entites.BreedEntity
import com.pathak.dogs.data.model.Breed
import java.util.*
import javax.inject.Inject

class BreedLocalDataSourceImpl @Inject constructor(private val breedDao: BreedDao) :
    BreedLocalDataSource {
    override suspend fun getAllBreeds(): List<Breed> {
        return breedDao.getBreeds().map { it.toDomain() }
    }

    override suspend fun getBreedDetails(breedId: String): Breed? =
        breedDao.getBreedById(breedId = UUID.fromString(breedId))?.toDomain()

    override suspend fun updateFavState(breedId: String, isFav: Boolean) {
        breedDao.updateFavStatus(id = UUID.fromString(breedId), isFav = isFav)
    }

    override suspend fun insertAllBreeds(breed: List<BreedEntity>) {
        breedDao.insertAll(breed)
    }
}