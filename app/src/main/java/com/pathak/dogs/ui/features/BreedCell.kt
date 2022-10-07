package com.pathak.dogs.ui.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pathak.dogs.data.model.BreedsDTO
import com.pathak.dogs.ui.common.FavouriteToggle
import java.util.*


@Composable
fun Breeds(
    breeds: List<BreedsDTO>,
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
fun BreedCell(breedsDTO: BreedsDTO, onFavStatusChanged: (breedId: UUID, isFav: Boolean) -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.Transparent),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextItem(
                text = breedsDTO.breedName,
                modifier = Modifier,
                textStyle = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.width(20.dp))
            TextItem(
                text = breedsDTO.subBreeds.size.toString(),
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

@Composable
fun TextItem(text: String, modifier: Modifier, textStyle: TextStyle, color: Color = Color.Black) {
    Text(
        text = text,
        color = color,
        maxLines = 1,
        style = textStyle,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun BreedsCellPreview() {
    BreedCell(
        BreedsDTO(breedName = "Golden", subBreeds = listOf("DOP", "Big dog")),
        onFavStatusChanged = { uuid: UUID, b: Boolean -> })
}