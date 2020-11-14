package com.github.pksokolowski.scopedarch.details

import com.github.pksokolowski.scopedarch.di.ScreenScope
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Named

@ScreenScope
@Subcomponent
interface DetailsComponent : AndroidInjector<DetailsController> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<DetailsController>() {
        @BindsInstance
        abstract fun bindSomething(@Named("something") something: String)

        override fun seedInstance(instance: DetailsController) {
            val something = instance.args.getString(DetailsController.KEY_SOMETHING)
            requireNotNull(something) { "Null parameter!" }
            bindSomething(something)
        }
    }
}