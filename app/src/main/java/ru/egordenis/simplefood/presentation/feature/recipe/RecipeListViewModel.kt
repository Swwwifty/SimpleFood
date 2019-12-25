package ru.egordenis.simplefood.presentation.feature.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.egordenis.simplefood.domain.entity.RecipeEntity
import ru.egordenis.simplefood.domain.usecase.RecipeListInteractor

/**
 * ViewModel for RecipeListFragment
 */
class RecipeListViewModel(
    private val recipeListInteractor: RecipeListInteractor,
    private val router: RecipeRouter
) : ViewModel() {

    private val _recipeList: MutableLiveData<List<RecipeEntity>> by lazy {
        MutableLiveData<List<RecipeEntity>>().also {
            loadRecipeList()
        }
    }

    private val _spinner = MutableLiveData<Boolean>(false)

    private val _snackBar = MutableLiveData<String?>()

    private fun loadRecipeList() = launchDataLoad {
        val result = recipeListInteractor.getRecipeList()
        if (result.isSuccess) {
            _recipeList.value = result.getOrNull() ?: listOf()
        } else {
            _recipeList.value = listOf()
            _snackBar.value = "Unable to refresh recipe list"
        }
    }

    /**
     * Request list of the recipes
     */
    val recipeList: LiveData<List<RecipeEntity>>
        get() = _recipeList

    /**
     * Show a loading spinner if true
     */
    val spinner: LiveData<Boolean>
        get() = _spinner

    /**
     * Request a snackbar to display a string.
     */
    val snackbar: LiveData<String?>
        get() = _snackBar

    /**
     * Open detail info for selected recipe with [id]
     */
    fun showRecipeDetail(id: Int) {
        router.showRecipeDetail(id)
    }

    /**
     * Called immediately after the UI shows the snackbar.
     */
    fun onSnackbarShown() {
        _snackBar.value = null
    }

    /**
     * Helper function to call a data load function with a loading spinner, errors will trigger a
     * snackbar.
     *
     * @param block lambda to actually load data. It is called in the viewModelScope. Before calling the
     *              lambda the loading spinner will display, after completion or error the loading
     *              spinner will stop
     */
    private fun launchDataLoad(block: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                _spinner.value = true
                block()
            } catch (error: Throwable) {
                _snackBar.value = error.message
            } finally {
                _spinner.value = false
            }
        }
    }

}