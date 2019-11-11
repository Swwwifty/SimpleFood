package ru.egordenis.simplefood.presentation.feature.recipe

/**
 * Interface of navigation router for recipe feature
 */
interface RecipeRouter {

    /**
     * Open detail info for selected recipe with [id]
     */
    fun showRecipeDetail(id: Int)

}