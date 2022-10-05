package com.pathak.dogs.domain

import com.pathak.dogs.data.model.Breeds
import com.pathak.dogs.data.remote.repository.BreedsRepository
import javax.inject.Inject

class GetBreedsUseCase @Inject constructor(private val breedsRepository: BreedsRepository) {
    suspend operator fun invoke(): com.pathak.dogs.data.base.Result<Breeds> {
        return breedsRepository.getAllBreeds()
    }
}