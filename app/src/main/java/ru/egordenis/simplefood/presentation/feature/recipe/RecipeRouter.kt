package ru.egordenis.simplefood.presentation.feature.recipe

/**
 * Navigation router interface for recipe feature
 */
interface RecipeRouter {

    /**
     * Open detail info for selected recipe with [id]
     */
    fun showRecipeDetail(id: Int)

}