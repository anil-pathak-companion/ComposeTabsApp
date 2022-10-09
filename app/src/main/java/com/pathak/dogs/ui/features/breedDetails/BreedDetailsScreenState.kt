package com.pathak.dogs.ui.features.breedDetails

import com.pathak.dogs.data.base.ScreenState
import com.pathak.dogs.data.model.Breed

data class BreedDetailsScreenState(
    val screenState: ScreenState = ScreenState.Loading,
    val breeds: Breed? = null,
    val error: String? = null
) {
    companion object {
        val Empty = BreedDetailsScreenState()
    }
}