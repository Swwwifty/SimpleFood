package ru.egordenis.simplefood.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import ru.egordenis.simplefood.data.repository.RecipeRepositoryImpl
import ru.egordenis.simplefood.domain.repository.RecipeRepository
import ru.egordenis.simplefood.domain.usecase.RecipeListInteractor
import ru.egordenis.simplefood.domain.usecase.RecipeListInteractorImpl
import ru.egordenis.simplefood.presentation.common.BaseActivity
import ru.egordenis.simplefood.presentation.feature.recipe.RecipeListViewModel
import ru.egordenis.simplefood.presentation.feature.recipe.RecipeRouter
import ru.egordenis.simplefood.presentation.feature.recipe.RecipeRouterImpl

/**
 * Module for DI in recipe feature
 */
val recipeModule = module {

    factory<RecipeRouter> { (view: BaseActivity) -> RecipeRouterImpl(view) }

    viewModel { (view: BaseActivity) -> RecipeListViewModel(get(), get { parametersOf(view) }) }

    factory<RecipeListInteractor> { RecipeListInteractorImpl(get()) }

}

val recipeDataModule = module {

    single<RecipeRepository> { RecipeRepositoryImpl() }

}