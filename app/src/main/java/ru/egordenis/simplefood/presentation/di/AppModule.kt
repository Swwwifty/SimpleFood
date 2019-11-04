package ru.egordenis.simplefood.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.egordenis.simplefood.presentation.MainViewModel

val appModule = module {

    viewModel { MainViewModel() }

}