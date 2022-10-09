package com.pathak.dogs.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Breed(
    val id: UUID,
    val name: String,
    val isFav: Boolean,
    val subBreeds: List<String>? = null
) : Parcelable {
    fun getImageUrl() =
        "https://dog.ceo/api/breed/${name}/images/random"
}