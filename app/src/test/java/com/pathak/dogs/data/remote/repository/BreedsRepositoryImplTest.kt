package com.pathak.dogs.data.remote.repository

import com.pathak.dogs.data.base.Result
import com.pathak.dogs.data.model.DogBreedsResponse
import com.pathak.dogs.data.remote.retrofit.DogBreedApiService
import com.pathak.dogs.data.repository.BreedsRepository
import com.pathak.dogs.data.repository.BreedsRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock


internal class BreedsRepositoryTest {

    private val dogBreedService = mock<DogBreedApiService> {
        onBlocking { getBreeds() } doReturn getBreedsResponse()
    }
    private val breedsRepo: BreedsRepository = BreedsRepositoryImpl(dogBreedService)

    @Test
    fun `getAllBreeds Return List of Breeds`() = runTest {
        val response = breedsRepo.getAllBreeds()
        Assert.assertEquals(Result.Success(getBreedsResponse().getBreeds()), response)
        if (response is Result.Success) {
            Assert.assertEquals(
                response.data.first().breedName,
                getBreedsResponse().getBreeds().first().breedName
            )
        }
    }

    private fun getBreedsResponse() =
        DogBreedsResponse(
            breedsMap = mapOf(
                Pair("Tyler", listOf("Golden", "Big")),
                Pair("Tyler2", listOf("Golden", "Big")),
                Pair("Tyler3", listOf("Golden", "Big"))
            )
        )
}