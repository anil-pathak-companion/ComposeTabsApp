package com.pathak.dogs.data.local

import com.pathak.dogs.data.local.dao.BreedDao
import com.pathak.dogs.data.local.entites.BreedEntity
import com.pathak.dogs.data.model.Breed
import javax.inject.Inject

class BreedLocalDataSourceImpl @Inject constructor(private val breedDao: BreedDao) :
    BreedLocalDataSource {
    override suspend fun getAllBreeds(): List<Breed> {
        val breeds = breedDao.getBreeds().map { it.toDomain() }
        return breeds
    }

    override suspend fun updateFavState(breedsDTO: Breed) {
        breedDao.updateFavStatus(breedsDTO.id, breedsDTO.isFav)
    }

    override suspend fun insertAllBreeds(breed: List<BreedEntity>) {
        breedDao.insertAll(breed)
    }
}