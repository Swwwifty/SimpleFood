package ru.egordenis.simplefood.presentation.feature.recipe

import androidx.navigation.fragment.findNavController
import ru.egordenis.simplefood.R
import ru.egordenis.simplefood.presentation.common.BaseFragment

class RecipeRouter(private val view: BaseFragment) {

    fun showRecipeDetail(id: Int) {
        val navController = view.findNavController()
        navController.navigate(R.id.navigate_to_recipe_detail_fragment)
    }

}