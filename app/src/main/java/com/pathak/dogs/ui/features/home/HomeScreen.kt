package com.pathak.dogs.ui.features.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.pathak.dogs.data.base.ScreenState
import com.pathak.dogs.ui.common.AppBar
import com.pathak.dogs.ui.common.LoadingView

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            AppBar(title = "DogBreed")
        },
        scaffoldState = scaffoldState,
        content = {
            HomeScreen(viewModel = hiltViewModel())
        }
    )
}

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val state by viewModel.uiState.collectAsState()

    when (state.screenState) {
        is ScreenState.Success -> {

        }
        is ScreenState.Error -> {

        }
        is ScreenState.Loading -> {
            LoadingView()
        }
    }
}