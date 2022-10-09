package com.pathak.dogs.ui.features.breedDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pathak.dogs.data.base.ScreenState
import com.pathak.dogs.data.model.Breed
import com.pathak.dogs.ui.common.AppBar
import com.pathak.dogs.ui.common.LoadingView

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BreedDetails(breed: Breed) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            AppBar(title = breed.name)
        },
        scaffoldState = scaffoldState,
        content = {
            BreedDetails(
                breed = breed,
                viewModel = hiltViewModel()
            )
        }
    )
}

@Composable
fun BreedDetails(breed: Breed, viewModel: BreedDetailViewModel) {
    val state by viewModel.uiState.collectAsState()

    when (state.screenState) {
        is ScreenState.Success -> {
            state.breeds?.let { breeds ->
            } ?: run {
                LoadingView(modifier = Modifier.fillMaxSize())
            }
        }
        is ScreenState.Error -> {
            LoadingView(modifier = Modifier.fillMaxSize())
        }
        is ScreenState.Loading -> {
            LoadingView(modifier = Modifier.fillMaxSize())
        }
    }

}