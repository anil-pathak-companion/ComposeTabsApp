package com.pathak.dogs.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow

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