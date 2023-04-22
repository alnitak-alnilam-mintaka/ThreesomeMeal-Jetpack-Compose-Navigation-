package com.polinasmogi.threesomemeal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.polinasmogi.threesomemeal.ui.ThreesomeMealApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThreesomeMealApp()
//            ThreesomeMealTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = background
//                ) {
//                    RecipesSearchView()
//                }
//            }
        }
    }
}

