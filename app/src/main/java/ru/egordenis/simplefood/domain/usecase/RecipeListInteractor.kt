package ru.egordenis.simplefood.domain.usecase

import ru.egordenis.simplefood.domain.entity.RecipeEntity

/**
 * Use case interface for recipe list
 */
interface RecipeListInteractor {

    /**
     * Get recipe list. Returns result with list of the recipes or result with error
     */
    suspend fun getRecipeList(): Result<List<RecipeEntity>>

}