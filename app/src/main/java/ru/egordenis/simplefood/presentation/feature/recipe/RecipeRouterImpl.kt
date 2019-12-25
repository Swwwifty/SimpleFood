package ru.egordenis.simplefood.presentation.feature.recipe

import androidx.navigation.findNavController
import ru.egordenis.simplefood.R
import ru.egordenis.simplefood.presentation.common.BaseActivity

/**
 * Implementation of navigation router for recipe feature
 */
class RecipeRouterImpl(private val view: BaseActivity) : RecipeRouter {

    override fun showRecipeDetail(id: Int) {
        val navController = view.findNavController(view.getNavControllerId())
        navController.navigate(R.id.navigate_to_recipe_detail_fragment)
    }

}