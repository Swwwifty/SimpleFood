package ru.egordenis.simplefood.data.repository

import kotlinx.coroutines.delay
import ru.egordenis.simplefood.domain.entity.RecipeEntity
import ru.egordenis.simplefood.domain.repository.RecipeRepository

/**
 * Remote recipe repository implementation
 */
class RecipeRepositoryImpl : RecipeRepository {

    override suspend fun getRecipeList(): Result<List<RecipeEntity>> {
        delay(5000)
        //return Result.success(listOf(RecipeEntity(1, "test")))
        return Result.failure(Exception())
    }

}