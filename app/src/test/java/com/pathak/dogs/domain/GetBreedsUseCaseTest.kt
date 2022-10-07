package com.pathak.dogs.domain

import com.pathak.dogs.data.base.Result
import com.pathak.dogs.data.model.DogBreedsResponse
import com.pathak.dogs.data.remote.repository.BreedsRepository
import com.pathak.dogs.data.remote.repository.BreedsRepositoryImpl
import com.pathak.dogs.data.remote.retrofit.DogBreedApiService
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

internal class GetBreedsUseCaseTest {

    private val dogBreedService = mock<DogBreedApiService> {
        onBlocking { getBreeds() } doReturn getBreedsResponse()
    }
    private val breedsRepo: BreedsRepository = BreedsRepositoryImpl(dogBreedService)
    private val getBreedUseCase = GetBreedsUseCase(breedsRepo)

    @Test
    fun `GetBreedUseCase returns correct result`() = runTest {
        val response = getBreedUseCase.invoke()
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