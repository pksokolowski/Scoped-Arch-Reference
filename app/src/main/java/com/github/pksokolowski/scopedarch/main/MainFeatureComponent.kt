package com.github.pksokolowski.scopedarch.main

import com.github.pksokolowski.scopedarch.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ScreenScope
@Subcomponent
interface MainFeatureComponent : AndroidInjector<MainFeatureController> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainFeatureController>(){
        override fun seedInstance(instance: MainFeatureController?) {}
    }

}