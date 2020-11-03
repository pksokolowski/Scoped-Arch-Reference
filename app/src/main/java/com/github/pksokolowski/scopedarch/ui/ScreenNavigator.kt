package com.github.pksokolowski.scopedarch.ui

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router

interface ScreenNavigator {
    fun initWithRouter(router: Router, rootScreen: Controller)
    fun pop(): Boolean
    fun clear()
}