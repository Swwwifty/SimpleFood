package ru.egordenis.simplefood.presentation.common

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.egordenis.simplefood.presentation.di.recipeDataModule
import ru.egordenis.simplefood.presentation.di.recipeModule

/**
 * My application class
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(recipeModule, recipeDataModule))
        }
    }

}