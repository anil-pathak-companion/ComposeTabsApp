package com.pathak.dogs.di

import android.content.Context
import androidx.room.Room
import com.pathak.dogs.data.local.BreedDatabase
import com.pathak.dogs.data.local.dao.BreedDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): BreedDatabase {
        return Room.databaseBuilder(
            context,
            BreedDatabase::class.java,
            "breeds"
        ).build()
    }

    @Singleton
    @Provides
    fun provideRateDao(database: BreedDatabase): BreedDao {
        return database.breedDao()
    }
}