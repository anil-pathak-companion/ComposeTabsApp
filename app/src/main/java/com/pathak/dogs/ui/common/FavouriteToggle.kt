package com.pathak.dogs.ui.common

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.unit.dp

/**
 * This file is created from reference of this answer:- https://www.geeksforgeeks.org/icon-toggle-button-in-android-using-jetpack-compose/
 *
 */
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun FavouriteToggle(isFav: Boolean, onCheckedChange: (Boolean) -> Unit) {
    val checkedState = remember { mutableStateOf(isFav) }
    IconToggleButton(
        // on below line we are
        // specifying default check state
        checked = checkedState.value,
        // on below line we are adding on check change
        onCheckedChange = {
            checkedState.value = !checkedState.value
            onCheckedChange(checkedState.value)
        },
        // on below line we are adding a padding
        modifier = Modifier.padding(10.dp)
    ) {
        // on below line we are creating a
        // variable for our transition
        val transition = updateTransition(checkedState)

        // on below line we are creating a variable for
        // color of our icon
        val tint by transition.animateColor(label = "iconColor") { isChecked ->
            // if toggle button is checked we are setting color as red.
            // in else condition we are setting color as black
            if (isChecked.value) Green else Black
        }

        // om below line we are specifying transition
        val size by transition.animateDp(
            label = "Size",
            targetValueByState = {
                30.dp
            }
        )


        // on below line we are creating icon for our toggle button.
        Icon(
            // on below line we are specifying icon for our image vector.
            imageVector = if (checkedState.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
            contentDescription = "Icon",
            // on below line we are specifying
            // tint for our icon.
            tint = tint,
            // on below line we are specifying
            // size for our icon.
            modifier = Modifier.size(size)
        )
    }
}