package com.pathak.dogs.ui.features

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pathak.dogs.ui.features.NavGraph.BreedDetail
import com.pathak.dogs.ui.features.NavGraph.Home
import com.pathak.dogs.ui.features.NavGraphArguments.BreedId
import com.pathak.dogs.ui.features.breedDetails.BreedDetails
import com.pathak.dogs.ui.features.home.HomeScreen

@Composable
fun DogBreedsApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable(Home) {
            HomeScreen(navController)
        }
        composable("$BreedDetail{breedId}", arguments = listOf(
            navArgument(BreedId) {
                type = NavType.StringType
            }
        )) {
            BreedDetails(
                breedId = it.arguments?.getString(BreedId).toString(),
                navController = navController
            )
        }
    }
}