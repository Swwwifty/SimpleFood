package ru.egordenis.simplefood.presentation.feature.recipe

import androidx.navigation.findNavController
import ru.egordenis.simplefood.R
import ru.egordenis.simplefood.presentation.common.BaseActivity

/**
 * Navigation router for recipe feature
 */
class RecipeRouter(private val view: BaseActivity) {

    /**
     * Open detail info for selected recipe with [id]
     */
    fun showRecipeDetail(id: Int) {
        val navController = view.findNavController(view.getNavControllerId())
        navController.navigate(R.id.navigate_to_recipe_detail_fragment)
    }

}