package com.pathak.dogs.ui.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppBar(
    title: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = typography.titleLarge,
                color = Color.White
            )
        },
        modifier = modifier,
        backgroundColor = Color.Blue
    )
}

@Preview
@Composable
fun AppBarPreview() {
    AppBar(title = "DogBreed")
}