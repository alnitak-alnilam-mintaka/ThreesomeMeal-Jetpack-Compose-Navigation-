package com.polinasmogi.threesomemeal.ui.recipesList

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.polinasmogi.threesomemeal.data.Recipe
import com.polinasmogi.threesomemeal.data.SampleData
import com.polinasmogi.threesomemeal.ui.shapes.SubtractShape
import com.polinasmogi.threesomemeal.ui.theme.*

@ExperimentalMaterial3Api
@Composable
fun RecipeDetails(recipe: Recipe) {
    BottomSheetScaffold(
        sheetContent = {
            Column {
                Text(
                    text = "Let's cook",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 20.dp)
                )
                LazyColumn(
                    userScrollEnabled = false,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 20.dp)
                ) {
                    items(recipe.instructions) { step ->
                        StepItem(step = step)
                    }
                }
            }
        },
        sheetShape = SubtractShape,
        sheetContainerColor = raspberryGlace,
        sheetPeekHeight = 120.dp
    ) {
        Instructions(recipe)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun Preview() {
    ThreesomeMealTheme {
        Surface {
            RecipeDetails(recipe = SampleData.martini)
        }
    }
}