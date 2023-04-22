package com.polinasmogi.threesomemeal.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.polinasmogi.threesomemeal.data.Recipe

@Composable
fun Recipes(
    recipes: List<Recipe>,
    onSelectRecipe: (Recipe) -> Unit
) {
    LazyColumn {
        items(recipes) {recipe ->
            RecipeCard(recipe = recipe, onSelectRecipe)
        }
    }
}