package com.pathak.dogs.ui.features

import androidx.navigation.NavHostController

object NavGraph {
    const val Home = "home"
    const val BreedDetail = "breedDetail/"
    fun createNavLink(breedId: String) = BreedDetail + breedId
}

object NavGraphArguments {
    const val BreedId = "breedId"
}

class Action(navHostController: NavHostController)