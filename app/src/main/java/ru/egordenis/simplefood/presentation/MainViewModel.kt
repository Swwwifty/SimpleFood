package ru.egordenis.simplefood.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var selectedRecipe = MutableLiveData<Int>()

    fun select(id: Int) {
        selectedRecipe.setValue(id)
    }

    fun getSelected(): LiveData<Int> {
        return selectedRecipe
    }
}