package com.polinasmogi.threesomemeal.ui.recipesList

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.polinasmogi.threesomemeal.data.Recipe
import com.polinasmogi.threesomemeal.ui.shapes.TitleBackgroundShape
import com.polinasmogi.threesomemeal.ui.theme.appleGreen
import com.polinasmogi.threesomemeal.ui.theme.harp
import com.polinasmogi.threesomemeal.ui.theme.saffronMango

@Composable
fun Instructions(recipe: Recipe) {
    Column(
        modifier = Modifier
            .background(harp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = recipe.name,
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                top = 24.dp,
                start = 16.dp,
                end = 16.dp,
            )
        ) {
            AsyncImage(
                model = recipe.firstIngredient.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .height(90.dp)
                    .width(90.dp)
                    .border(width = 4.dp, color = appleGreen, shape = CircleShape)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = recipe.firstIngredient.name,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = "${recipe.firstIngredient.amount} " +
                            "${recipe.firstIngredient.unit}",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    top = 12.dp,
                    start = 16.dp,
                    end = 16.dp,
                )
                .align(Alignment.End)
        ) {
            Column(
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(
                    text = recipe.secondIngredient.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "${recipe.secondIngredient.amount} " +
                            "${recipe.secondIngredient.unit}",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
            AsyncImage(
                model = recipe.secondIngredient.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .height(90.dp)
                    .width(90.dp)
                    .border(width = 4.dp, color = appleGreen, shape = CircleShape)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(
                    top = 12.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 48.dp
                )
        ) {
            AsyncImage(
                model = recipe.thirdIngredient.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .height(90.dp)
                    .width(90.dp)
                    .border(width = 4.dp, color = appleGreen, shape = CircleShape)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = recipe.thirdIngredient.name,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = "${recipe.thirdIngredient.amount} " +
                            "${recipe.thirdIngredient.unit}",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}