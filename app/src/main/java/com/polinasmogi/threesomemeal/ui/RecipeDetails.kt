package com.polinasmogi.threesomemeal.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.polinasmogi.threesomemeal.data.Recipe
import com.polinasmogi.threesomemeal.data.SampleData
import com.polinasmogi.threesomemeal.ui.shapes.MithosisShape
import com.polinasmogi.threesomemeal.ui.theme.ThreesomeMealTheme
import com.polinasmogi.threesomemeal.ui.theme.pink

@Composable
fun RecipeDetails(recipe: Recipe) {
    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 18.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {
        val scrollState = rememberScrollState()
        LazyColumn(
            modifier = Modifier
                .background(shape = MithosisShape, color = pink)
        ) {
            item {
                Text(
                    text = recipe.name,
                    style = MaterialTheme.typography.titleLarge
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    AsyncImage(
                        model = recipe.firstIngredient.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .height(90.dp)
                            .width(90.dp)
                            .border(width = 4.dp, color = Color.White, shape = CircleShape)
                    )
                    Text(
                        text = "${recipe.firstIngredient.name}, " +
                                "${recipe.firstIngredient.amount} " +
                                "${recipe.firstIngredient.unit}",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(start = 16.dp),
                        color = Color.White
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 12.dp)
//                        .align(Alignment.End)
                ) {
                    Text(
                        text = "${recipe.secondIngredient.name}, " +
                                "${recipe.secondIngredient.amount} " +
                                "${recipe.secondIngredient.unit}",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(end = 16.dp),
                        color = Color.White
                    )
                    AsyncImage(
                        model = recipe.secondIngredient.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .height(90.dp)
                            .width(90.dp)
                            .border(width = 4.dp, color = Color.White, shape = CircleShape)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 12.dp, bottom = 48.dp)
                ) {
                    AsyncImage(
                        model = recipe.thirdIngredient.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .height(90.dp)
                            .width(90.dp)
                            .border(width = 4.dp, color = Color.White, shape = CircleShape)
                    )
                    Text(
                        text = "${recipe.thirdIngredient.name}, " +
                                "${recipe.thirdIngredient.amount} " +
                                "${recipe.thirdIngredient.unit}",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(start = 16.dp),
                        color = Color.White
                    )
                }

            }
            items(recipe.instructions) {step ->
                StepItem(step = step)
            }
//
//            LazyColumn(
//                userScrollEnabled = false
//            ) {
//
//            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    ThreesomeMealTheme {
        Surface {
            RecipeDetails(recipe = SampleData.potatoes)
        }
    }
}