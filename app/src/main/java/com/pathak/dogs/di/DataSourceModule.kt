package com.pathak.dogs.di

import com.pathak.dogs.data.local.BreedLocalDataSource
import com.pathak.dogs.data.local.BreedLocalDataSourceImpl
import com.pathak.dogs.data.remote.BreedRemoteDataSource
import com.pathak.dogs.data.remote.BreedRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: BreedLocalDataSourceImpl): BreedLocalDataSource

    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: BreedRemoteDataSourceImpl): BreedRemoteDataSource
}