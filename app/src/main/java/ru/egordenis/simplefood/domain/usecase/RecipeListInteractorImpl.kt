package ru.egordenis.simplefood.domain.usecase

import ru.egordenis.simplefood.domain.entity.RecipeEntity
import ru.egordenis.simplefood.domain.repository.RecipeRepository

/**
 * Use case implementation for recipe list
 */
class RecipeListInteractorImpl(private val recipeRepository: RecipeRepository) :
    RecipeListInteractor {

    override suspend fun getRecipeList(): Result<List<RecipeEntity>> {
        return recipeRepository.getRecipeList()
    }

}