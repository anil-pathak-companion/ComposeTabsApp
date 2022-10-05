package com.pathak.dogs.data.model


import com.google.gson.annotations.SerializedName

data class DogBreedsResponse(
    @SerializedName("breeds")
    val breeds: Breeds,
    @SerializedName("status")
    val status: String = ""
)