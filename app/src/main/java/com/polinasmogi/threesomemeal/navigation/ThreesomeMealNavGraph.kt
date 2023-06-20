package com.polinasmogi.threesomemeal.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.polinasmogi.threesomemeal.navigation.ThreesomeMealDestinations
import com.polinasmogi.threesomemeal.ui.recipesList.RecipesRoute
import com.polinasmogi.threesomemeal.ui.recipesList.RecipesViewModel

@Composable
fun ThreesomeMealNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = ThreesomeMealDestinations.RECIPES_ROUTE,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ThreesomeMealDestinations.RECIPES_ROUTE) {
            val recipesViewModel: RecipesViewModel = viewModel()
            RecipesRoute(
                recipesViewModel = recipesViewModel,
                onSelectRecipe = { recipesViewModel.selectRecipe(it) },
                onBackPressed = { recipesViewModel.onBackPressed() }
            )
        }
    }
}