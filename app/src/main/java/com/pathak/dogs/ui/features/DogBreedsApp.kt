package com.pathak.dogs.ui.features

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pathak.dogs.data.model.Breed
import com.pathak.dogs.ui.features.NavGraph.BreedDetail
import com.pathak.dogs.ui.features.NavGraph.Home
import com.pathak.dogs.ui.features.breedDetails.BreedDetails
import com.pathak.dogs.ui.features.home.HomeScreen

@Composable
fun DogBreedsApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable(Home) {
            HomeScreen(navController)
        }
        composable("$BreedDetail?breed={breed}", arguments = listOf(
            navArgument("breed") {
                type = BreedType()
            }
        )) {
            (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.arguments?.getParcelable("breed", Breed::class.java)
            } else {
                it.arguments?.getParcelable("breed")
            })?.let { breed ->
                BreedDetails(
                    breed = breed
                )
            }
        }
    }
}