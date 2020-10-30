package com.github.pksokolowski.scopedarch.base

import android.content.Context
import com.bluelinelabs.conductor.Controller
import com.github.pksokolowski.scopedarch.di.inject

abstract class BaseController : Controller() {

    private var injected: Boolean = false

    override fun onContextAvailable(context: Context) {
        // prevents injecting the same thing multiple times, would not hurt, but wasteful
        if(!injected){
            inject(this)
            injected = true
        }
        super.onContextAvailable(context)
    }
}