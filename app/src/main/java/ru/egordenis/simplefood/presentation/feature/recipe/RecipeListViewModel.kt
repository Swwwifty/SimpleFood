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

    private fun loadRecipeList() {
        viewModelScope.launch {
            val result = recipeListInteractor.getRecipeList()
            if (result.isSuccess) {
                _recipeList.value = result.getOrNull() ?: listOf()
            }
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

}