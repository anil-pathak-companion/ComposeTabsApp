package com.pathak.dogs.ui.features.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.map.Mapper
import coil.request.ImageRequest
import coil.request.Options
import com.pathak.dogs.R
import com.pathak.dogs.data.model.Breed
import com.pathak.dogs.ui.common.FavouriteToggle
import com.pathak.dogs.ui.common.TextItem
import java.util.*

@Composable
fun Breeds(
    breeds: List<Breed>,
    onFavStatusChanged: (breedId: UUID, isFav: Boolean) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(breeds) { breed ->
            BreedCell(breedsDTO = breed, onFavStatusChanged = onFavStatusChanged)
        }
    }
}

@Composable
fun BreedCell(breedsDTO: Breed, onFavStatusChanged: (breedId: UUID, isFav: Boolean) -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.Transparent),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val url = breedsDTO.getImageUrl()
            val imageLoader = ImageLoader.Builder(LocalContext.current)
                .components {
                    add(ItemMapper())
                }
                .build()

            val painter = rememberAsyncImagePainter(
                model = ImageLoader.Builder(LocalContext.current)
                    .components {
                        ItemMapper()
                    }
                    .build()
            )

            if (painter.state is AsyncImagePainter.State.Success) {
                // This will be executed during the first composition if the image is in the memory cache.
            }
            Image(
                painter = painter,
                contentDescription = ""
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(url)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.dog_breed_placeholder),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .width(48.dp)
                    .height(48.dp),
                onSuccess = {
                    Log.d("BreedCell", "BreedCell: success")
                },
                onError = {
                    Log.d(
                        "BreedCell",
                        "BreedCell: ${it.result.throwable.printStackTrace()}  + url = $url"
                    )
                }
            )
            TextItem(
                text = breedsDTO.name,
                modifier = Modifier,
                textStyle = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.width(20.dp))
            TextItem(
                text = breedsDTO.subBreeds?.size.toString(),
                modifier = Modifier,
                textStyle = MaterialTheme.typography.headlineMedium,
            )
            Spacer(modifier = Modifier.width(20.dp))
            FavouriteToggle(isFav = false, onCheckedChange = { isFav ->
                onFavStatusChanged(UUID.randomUUID(), isFav)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BreedsCellPreview() {
    BreedCell(
        Breed(
            id = UUID.randomUUID(),
            name = "Golden",
            subBreeds = listOf("DOP", "Big dog"),
            isFav = false
        ),
        onFavStatusChanged = { uuid: UUID, b: Boolean -> })
}

class ItemMapper : Mapper<BreedImageResponse, String> {
    override fun map(data: BreedImageResponse, options: Options): String {
        val url = data.message
        Log.d("map", "map: url data $url")
        return url
    }
}

data class BreedImageResponse(val message: String)