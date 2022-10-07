package com.pathak.dogs.data.model

import com.pathak.dogs.data.local.entites.BreedEntity


data class BreedsDTO(
    val breedName: String,
    val subBreeds: List<String>
) {
    fun toDomain(): BreedEntity = BreedEntity(breedName = breedName)
}