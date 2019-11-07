package ru.egordenis.simplefood.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import ru.egordenis.simplefood.presentation.common.BaseActivity
import ru.egordenis.simplefood.presentation.feature.recipe.RecipeListViewModel
import ru.egordenis.simplefood.presentation.feature.recipe.RecipeRouter

/**
 * Module for DI in recipe feature
 */
val recipeModule = module {

    factory { (view: BaseActivity) -> RecipeRouter(view) }

    viewModel { (view: BaseActivity) -> RecipeListViewModel(get { parametersOf(view) }) }

}