package ru.egordenis.simplefood.presentation.feature.recipe.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.egordenis.simplefood.R
import ru.egordenis.simplefood.presentation.common.BaseFragment
import ru.egordenis.simplefood.presentation.feature.recipe.RecipeListViewModel

/**
 * Fragment for show the list of recipes
 */
class RecipeListFragment : BaseFragment() {

    private val viewModel: RecipeListViewModel by viewModel { parametersOf(this.activity) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_recipe_list, container, false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showRecipeDetail(id)
    }

}