package com.polinasmogi.threesomemeal.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.polinasmogi.threesomemeal.R
import com.polinasmogi.threesomemeal.data.SampleData

@Composable
fun RecipesSearchView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_text_logo),
            modifier = Modifier.height(126.dp),
            contentDescription = null)
        var text by remember { mutableStateOf("") }
        TextField(
            textStyle = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(Color.White),
            value = text,
            onValueChange = { text = it }
        )
//        Recipes(recipes = SampleData.recipesData)
    }
}