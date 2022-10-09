package com.pathak.dogs.ui.common

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import coil.map.Mapper
import coil.request.Options
import com.google.gson.annotations.SerializedName
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

class ItemMapper : Mapper<BreedImageResponse, String> {
    override fun map(response: BreedImageResponse, options: Options): String {
        val url = response.url
        Log.d("Url is", url)
        return url
    }
}

data class BreedImageResponse(@SerializedName("message") val url: String)