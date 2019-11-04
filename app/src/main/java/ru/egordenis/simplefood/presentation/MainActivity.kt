package ru.egordenis.simplefood.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import ru.egordenis.simplefood.R

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private val navController by lazy {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showDetailRecipe()
    }

    private fun showDetailRecipe() {
        viewModel.getSelected().observe(this, Observer<Int> {
            navController.navigate(R.id.navigate_to_recipe_detail_fragment)
        })
    }

}
