package ru.egordenis.simplefood.domain.repository

import ru.egordenis.simplefood.domain.entity.RecipeEntity

/**
 * Repository for recipes
 */
interface RecipeRepository {

    /**
     * Get recipe list from server. Returns result with list of the recipes from remote server or result with error
     */
    suspend fun getRecipeList(): Result<List<RecipeEntity>>

}