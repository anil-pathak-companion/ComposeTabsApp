package com.pathak.dogs.data.local.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pathak.dogs.data.model.Breed
import java.util.*

@Entity(tableName = "breed")
data class BreedEntity(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val breedName: String,
    val subBreed: List<String> = listOf(),
    var isFav: Boolean = false
) {
    fun toDomain(): Breed {
        return Breed(id = id, name = breedName, isFav = isFav, subBreeds = subBreed)
    }
}