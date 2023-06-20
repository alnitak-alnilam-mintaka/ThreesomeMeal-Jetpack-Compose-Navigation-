package com.polinasmogi.threesomemeal.ui.recipesList

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Loading() {
    Text(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        text = "Loading"
    )
}