package com.polinasmogi.threesomemeal.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.polinasmogi.threesomemeal.data.Recipe
import com.polinasmogi.threesomemeal.ui.shapes.TitleBackgroundShape
import com.polinasmogi.threesomemeal.ui.theme.harp
import com.polinasmogi.threesomemeal.ui.theme.saffronMango

@Composable
fun Recipes(
    recipes: List<Recipe>,
    onSelectRecipe: (Recipe) -> Unit
) {
    Column(
        modifier = Modifier
            .background(harp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = "ThreesomeMeal",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .wrapContentWidth()
                .background(color = saffronMango, shape = TitleBackgroundShape)
                .padding(
                    top = 18.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 18.dp
                )
        )
        LazyColumn {
            items(recipes) {recipe ->
                RecipeCard(recipe = recipe, onSelectRecipe)
            }
        }
    }
}