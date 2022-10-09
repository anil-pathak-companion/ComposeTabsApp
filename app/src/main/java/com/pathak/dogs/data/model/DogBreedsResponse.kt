package com.pathak.dogs.data.model

import com.google.gson.annotations.SerializedName

data class DogBreedsResponse(
    @SerializedName("message")
    val breedsMap: Map<String, List<String>>
) {
    fun getBreeds(): List<BreedsDTO> =
        breedsMap.entries.map {
            BreedsDTO(breedName = it.key, subBreeds = it.value)
        }
}