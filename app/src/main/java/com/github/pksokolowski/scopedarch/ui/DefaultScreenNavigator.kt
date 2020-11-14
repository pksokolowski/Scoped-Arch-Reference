package com.github.pksokolowski.scopedarch.ui

import android.transition.Fade
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import com.github.pksokolowski.scopedarch.details.DetailsComponent
import com.github.pksokolowski.scopedarch.details.DetailsController
import com.github.pksokolowski.scopedarch.di.ActivityScope
import java.lang.NullPointerException
import javax.inject.Inject

@ActivityScope
class DefaultScreenNavigator @Inject constructor() : ScreenNavigator {
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
        router?.let {
            it.pushController(
                RouterTransaction.with(DetailsController.newInstance(something))
                    .pushChangeHandler(FadeChangeHandler())
                    .popChangeHandler(FadeChangeHandler())
            )

        }
    }

    override fun clear() {
        router = null
    }
}