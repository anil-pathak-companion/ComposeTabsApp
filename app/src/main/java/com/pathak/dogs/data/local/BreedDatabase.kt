package com.pathak.dogs.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pathak.dogs.data.local.dao.BreedDao
import com.pathak.dogs.data.local.entites.BreedEntity

@Database(entities = [BreedEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class BreedDatabase : RoomDatabase() {

    abstract fun breedDao(): BreedDao

}