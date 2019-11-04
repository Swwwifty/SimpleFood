package ru.egordenis.simplefood.presentation.feature.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.egordenis.simplefood.R
import ru.egordenis.simplefood.presentation.MainViewModel
import ru.egordenis.simplefood.presentation.common.BaseFragment

/**
 * Fragment for show the list of recipes
 */
class RecipeListFragment : BaseFragment() {

    val mainViewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_recipe_list, container, false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.select(1)
    }

}