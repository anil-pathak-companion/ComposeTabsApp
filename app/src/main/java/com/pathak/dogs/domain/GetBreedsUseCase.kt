package com.pathak.dogs.domain

import com.pathak.dogs.data.model.BreedsDTO
import com.pathak.dogs.data.remote.repository.BreedsRepository
import javax.inject.Inject

class GetBreedsUseCase @Inject constructor(private val breedsRepository: BreedsRepository) {
    suspend operator fun invoke(): com.pathak.dogs.data.base.Result<List<BreedsDTO>> {
        return breedsRepository.getAllBreeds()
    }
}