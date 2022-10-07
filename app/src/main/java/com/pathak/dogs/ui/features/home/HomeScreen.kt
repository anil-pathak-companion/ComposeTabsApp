package com.pathak.dogs.ui.features.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pathak.dogs.data.base.ScreenState
import com.pathak.dogs.ui.common.AppBar
import com.pathak.dogs.ui.common.LoadingView
import com.pathak.dogs.ui.features.Breeds

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
            Log.d("HomeScreen", "HomeScreen: ${state.breeds?.size.toString()}")
            state.breeds?.let { breeds ->
                Breeds(breeds = breeds) { uuid, fav ->

                }
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