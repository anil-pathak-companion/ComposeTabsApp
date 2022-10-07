package com.pathak.dogs.di

import com.pathak.dogs.data.repository.BreedsRepository
import com.pathak.dogs.data.repository.BreedsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindBreedRepository(repository: BreedsRepositoryImpl): BreedsRepository
}