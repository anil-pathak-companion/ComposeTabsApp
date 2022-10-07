package com.pathak.dogs.data.local.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "breed")
data class BreedEntity(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val breedName: String,
    val parentBreed: UUID? = null,
    var isFav: Boolean = false
)