package com.pathak.dogs.ui.features.home

import com.pathak.dogs.data.base.ScreenState
import com.pathak.dogs.data.model.Breeds

data class HomeScreenState(
    val screenState: ScreenState = ScreenState.Loading,
    val breeds: Breeds? = null,
    val error: String? = null
) {
    companion object {
        val Empty = HomeScreenState()
    }
}