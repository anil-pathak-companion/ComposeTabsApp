package com.pathak.dogs.ui.features.home

import com.pathak.dogs.data.base.ScreenState
import com.pathak.dogs.data.model.BreedsDTO

data class HomeScreenState(
    val screenState: ScreenState = ScreenState.Loading,
    val breeds: List<BreedsDTO>? = null,
    val error: String? = null
) {
    companion object {
        val Empty = HomeScreenState()
    }
}