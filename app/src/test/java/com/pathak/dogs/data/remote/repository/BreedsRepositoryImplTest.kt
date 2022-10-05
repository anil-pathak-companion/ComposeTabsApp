package com.pathak.dogs.data.remote.repository

import com.pathak.dogs.data.base.Result
import com.pathak.dogs.data.model.Breeds
import com.pathak.dogs.data.model.DogBreedsResponse
import com.pathak.dogs.data.remote.retrofit.DogBreedApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock


internal class BreedsRepositoryTest {

    val dogBreedService = mock<DogBreedApiService> {
        onBlocking { getBreeds() } doReturn getBreedsResponse()
    }
    val breedsRepo: BreedsRepository = BreedsRepositoryImpl(dogBreedService)

    @Test
    fun `getAllBreeds Return List of Breeds`() = runTest {
        val response = breedsRepo.getAllBreeds()
        Assert.assertEquals(Result.Success(getBreedsResponse().breeds), response)
        if (response is Result.Success) {
            Assert.assertEquals(
                response.data.affenpinscher,
                getBreedsResponse().breeds.affenpinscher
            )
        }
    }

    private fun getBreedsResponse() = DogBreedsResponse(breeds = Breeds())
}