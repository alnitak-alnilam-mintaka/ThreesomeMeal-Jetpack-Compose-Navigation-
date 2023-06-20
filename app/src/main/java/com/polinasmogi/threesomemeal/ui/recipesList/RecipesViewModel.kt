package com.polinasmogi.threesomemeal.ui.recipesList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.polinasmogi.threesomemeal.data.Recipe
import kotlinx.coroutines.flow.*

class RecipesViewModel: ViewModel() {

    private val database = Firebase.database.reference

    private val viewModelState = MutableStateFlow(RecipesViewModelState(loading = true))

    val uiState = viewModelState
        .map(RecipesViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        database.child("recipes").get().addOnSuccessListener {
            val recipes = arrayListOf<Recipe>()

            it.children.forEach { snapshot ->
                val recipe = snapshot.getValue(Recipe::class.java)
                if (recipe != null) {
                    recipes.add(recipe)
                }
            }

            viewModelState.update { state ->
                state.copy(
                    loading = false,
                    recipes = recipes
                )
            }
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
    }

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
    val loading: Boolean = false,
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
            loading -> RecipeUiState.Loading
            selectedRecipe != null -> RecipeUiState.RecipeInfo(recipe = selectedRecipe)
            recipes.isNullOrEmpty() -> RecipeUiState.NoRecipes(errorMessage = errorMessage)
            else -> RecipeUiState.RecipeList(recipes = recipes)
        }
}

sealed interface RecipeUiState {

    object Loading : RecipeUiState

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