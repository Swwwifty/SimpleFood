package ru.egordenis.simplefood.presentation.feature.recipe.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_recipe_list.*
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
        subscribeToRecipeList()
        subscribeToSpinner()
        subscripeToSnackbar()
    }

    private fun subscribeToRecipeList() {
        viewModel.recipeList
            .observe(this, Observer { value ->
                if (value.isNotEmpty()) {
                    recipe_name.text = value[0].name
                } else {
                    recipe_name.text = ""
                }
            })
    }

    /**
     * Show the spinner when [RecipeListViewModel.spinner] is true
     */
    private fun subscribeToSpinner() {
        viewModel.spinner.observe(this, Observer { value ->
            value.let { show ->
                spinner.visibility = if (show) View.VISIBLE else View.GONE
            }
        })
    }

    /**
     * Show a snackbar whenever the [RecipeListViewModel.snackbar] is updated a non-null value
     */
    private fun subscripeToSnackbar() {
        viewModel.snackbar.observe(this, Observer { text ->
            text?.let {
                Snackbar.make(fragment_recipe_list, text, Snackbar.LENGTH_SHORT).show()
                viewModel.onSnackbarShown()
            }
        })
    }

}