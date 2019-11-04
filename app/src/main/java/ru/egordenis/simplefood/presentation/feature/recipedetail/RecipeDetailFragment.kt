package ru.egordenis.simplefood.presentation.feature.recipedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.egordenis.simplefood.R
import ru.egordenis.simplefood.presentation.common.BaseFragment

/**
 * Fragment for show detail info for the recipe
 */
class RecipeDetailFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_recipe_detail, container, false
    )

}