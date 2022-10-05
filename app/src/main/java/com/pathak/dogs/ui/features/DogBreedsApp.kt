package com.pathak.dogs.ui.features

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pathak.dogs.ui.features.NavGraph.Home
import com.pathak.dogs.ui.features.home.HomeScreen

@Composable
fun DogBreedsApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable(Home) {
            HomeScreen()
        }
    }
}