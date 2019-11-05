package ru.egordenis.simplefood.presentation

import android.os.Bundle
import ru.egordenis.simplefood.R
import ru.egordenis.simplefood.presentation.common.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun getNavControllerId(): Int = R.id.nav_host_fragment

}
