package com.pathak.dogs.data.model

import com.squareup.moshi.Json

data class DogBreedsResponse(
    @Json(name = "message")
    val breedsMap: Map<String, List<String>>
) {
    fun getBreeds(): List<BreedsDTO> =
        breedsMap.entries.map {
            BreedsDTO(breedName = it.key, subBreeds = it.value)
        }
}