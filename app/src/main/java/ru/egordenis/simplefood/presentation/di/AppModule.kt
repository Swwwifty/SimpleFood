package ru.egordenis.simplefood.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import ru.egordenis.simplefood.presentation.common.BaseFragment
import ru.egordenis.simplefood.presentation.feature.recipe.RecipeListViewModel
import ru.egordenis.simplefood.presentation.feature.recipe.RecipeRouter

val appModule = module {

    factory { (view: BaseFragment) -> RecipeRouter(view) }

    viewModel { (view: BaseFragment) -> RecipeListViewModel(get { parametersOf(view) }) }

}