package com.polinasmogi.threesomemeal.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.polinasmogi.threesomemeal.data.Recipe
import com.polinasmogi.threesomemeal.data.SampleData
import com.polinasmogi.threesomemeal.ui.theme.ThreesomeMealTheme
import com.polinasmogi.threesomemeal.ui.theme.raspberryGlace

@Composable
fun RecipeCard(recipe: Recipe, onClick: ((recipe: Recipe) -> Unit)?) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = Color.Transparent,
        modifier = Modifier
            .padding(top = 12.dp, start = 16.dp, end = 16.dp, bottom = 0.dp)
            .background(color = raspberryGlace, shape = RoundedCornerShape(32.dp))
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(32.dp))
            .clickable { onClick?.invoke(recipe) }

    ) {
        Column {
            Text(
                text = recipe.name,
                modifier = Modifier.padding(top = 28.dp, start = 20.dp),
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
            Text(
                text = "${recipe.tags[0]} • ${recipe.tags[1]}",
                modifier = Modifier.padding(start = 20.dp),
                style = MaterialTheme.typography.labelMedium,
                color = Color.White
            )
            AsyncImage(
                model = recipe.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(all = 12.dp)
                    .clip(shape = RoundedCornerShape(20.dp))
                    .height(138.dp)
            )
        }
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
fun DefaultPreview() {
    ThreesomeMealTheme {
        Surface {
            RecipeCard(recipe = SampleData.martini, null)
        }
    }
}