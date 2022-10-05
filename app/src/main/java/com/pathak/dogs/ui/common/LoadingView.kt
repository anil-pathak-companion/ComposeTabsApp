package com.pathak.dogs.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.pathak.dogs.ui.theme.Purple80

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Purple80, modifier = Modifier.testTag("ProgressBar"))
    }
}

@Preview
@Composable
fun LoaderPreview() {
    LoadingView(modifier = Modifier.fillMaxSize())
}