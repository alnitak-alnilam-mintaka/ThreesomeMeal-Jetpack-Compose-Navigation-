package com.polinasmogi.threesomemeal.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polinasmogi.threesomemeal.data.Recipe
import com.polinasmogi.threesomemeal.data.SampleData
import kotlinx.coroutines.flow.*

class RecipesViewModel: ViewModel() {

    private val viewModelState = MutableStateFlow(RecipesViewModelState(recipes = SampleData.recipesData))

    val uiState = viewModelState
        .map(RecipesViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    fun selectRecipe(recipe: Recipe) {
        viewModelState.update {
            it.copy(
                selectedRecipe = recipe
            )
        }
    }

    fun onBackPressed() {
        viewModelState.update {
            it.copy(
                selectedRecipe = null
            )
        }
    }

}

private data class  RecipesViewModelState(
    val recipes: List<Recipe>? = null,
    val selectedRecipe: Recipe? = null,
    val errorMessage: String = ""
) {
    /**
     * Converts this [RecipesViewModelState] into a more strongly typed [RecipeUiState] for driving
     * the ui.
     */
    fun toUiState(): RecipeUiState =
        when {
            selectedRecipe != null -> RecipeUiState.RecipeInfo(recipe = selectedRecipe)
            recipes.isNullOrEmpty() -> RecipeUiState.NoRecipes(errorMessage = errorMessage)
            else -> RecipeUiState.RecipeList(recipes = recipes)
        }
}

sealed interface RecipeUiState {

    data class NoRecipes(
        val errorMessage: String
    ) : RecipeUiState

    data class RecipeList(
        val recipes: List<Recipe>
    ) : RecipeUiState

    data class RecipeInfo(
        val recipe: Recipe
    ) : RecipeUiState

}