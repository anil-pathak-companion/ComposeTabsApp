package com.pathak.dogs.ui.features.breedDetails

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pathak.dogs.ui.common.AppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BreedDetails(breedId: String, navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            AppBar(title = "DogBreed")
        },
        scaffoldState = scaffoldState,
        content = {
            BreedDetails(
                breedId = breedId,
                navController = navController,
                viewModel = hiltViewModel()
            )
        }
    )
}

@Composable
fun BreedDetails(breedId: String, navController: NavController, viewModel: BreedDetailViewModel) {

}