package com.github.pksokolowski.scopedarch.home

import com.bluelinelabs.conductor.Controller
import com.github.pksokolowski.scopedarch.R
import com.github.pksokolowski.scopedarch.base.BaseActivity
import com.github.pksokolowski.scopedarch.trending.TrendingReposController

class MainActivity : BaseActivity() {

    override val layoutRes: Int
        get() = R.layout.activity_main

    override val initialScreen: Controller
        get() = TrendingReposController()
}