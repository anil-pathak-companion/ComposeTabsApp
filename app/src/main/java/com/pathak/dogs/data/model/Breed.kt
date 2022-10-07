package com.pathak.dogs.data.model

import java.util.*

data class Breed(
    val id: UUID,
    val name: String,
    val isFav: Boolean,
    val subBreeds: List<String>? = null
) {
    fun getImageUrl() =
        "https://dog.ceo/api/breed/${name}/images/random"
}