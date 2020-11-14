package com.github.pksokolowski.scopedarch.ui

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.github.pksokolowski.scopedarch.di.PerApp
import javax.inject.Inject

@PerApp
class TestNavigator @Inject constructor() : ScreenNavigator {
    private var router: Router? = null


    override fun initWithRouter(router: Router, rootScreen: Controller) {
        this.router = router
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(rootScreen))
        }
    }

    override fun pop(): Boolean {
        val router = router ?: return false
        return router.handleBack()
    }

    override fun gotoDetails(something: String) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        router = null
    }
}