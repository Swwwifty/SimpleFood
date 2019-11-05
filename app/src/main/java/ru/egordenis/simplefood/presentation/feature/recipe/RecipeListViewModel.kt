package ru.egordenis.simplefood.presentation.feature.recipe

import androidx.lifecycle.ViewModel

/**
 * ViewModel for RecipeListFragment
 */
class RecipeListViewModel(private val navigator: RecipeRouter) : ViewModel() {

    /**
     * Open detail info for selected recipe with [id]
     */
    fun showRecipeDetail(id: Int) {
        navigator.showRecipeDetail(id)
    }

}