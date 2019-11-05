package ru.egordenis.simplefood.presentation.feature.recipe

import androidx.lifecycle.ViewModel

class RecipeListViewModel(private val navigator: RecipeRouter) : ViewModel() {

    fun showRecipeDetail(id: Int) {
        navigator.showRecipeDetail(id)
    }

}