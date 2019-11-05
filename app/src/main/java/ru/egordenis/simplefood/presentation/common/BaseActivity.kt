package ru.egordenis.simplefood.presentation.common

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getNavControllerId(): Int

}