package com.pathak.dogs.domain

import com.pathak.dogs.data.base.Result
import com.pathak.dogs.data.model.Breed
import com.pathak.dogs.data.repository.BreedsRepository
import javax.inject.Inject

class GetBreedsDetailsUseCase @Inject constructor(private val breedsRepository: BreedsRepository) {
    suspend operator fun invoke(breedId: String): Result<Breed> {
        return breedsRepository.getBreedById(breedId = breedId)
    }
}