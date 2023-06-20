package com.polinasmogi.threesomemeal.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.polinasmogi.threesomemeal.ui.ThreesomeMealNavGraph
import com.polinasmogi.threesomemeal.ui.theme.ThreesomeMealTheme

@Composable
fun ThreesomeMealApp() {
    ThreesomeMealTheme {
        val navController = rememberNavController()
        ThreesomeMealNavGraph(
            navController = navController,
        )
    }
}