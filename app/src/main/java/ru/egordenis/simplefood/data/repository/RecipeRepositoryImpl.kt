package ru.egordenis.simplefood.data.repository

import ru.egordenis.simplefood.domain.entity.RecipeEntity
import ru.egordenis.simplefood.domain.repository.RecipeRepository

/**
 * Remote recipe repository implementation
 */
class RecipeRepositoryImpl : RecipeRepository {

    override suspend fun getRecipeList(): Result<List<RecipeEntity>> {
        return Result.success(listOf(RecipeEntity(1, "test")))
    }

}