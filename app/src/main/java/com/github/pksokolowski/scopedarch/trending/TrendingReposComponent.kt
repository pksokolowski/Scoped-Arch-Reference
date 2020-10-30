package com.github.pksokolowski.scopedarch.trending

import com.github.pksokolowski.scopedarch.di.ScreenScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ScreenScope
@Subcomponent
interface TrendingReposComponent : AndroidInjector<TrendingReposController> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TrendingReposController>(){
        override fun seedInstance(instance: TrendingReposController?) {}
    }

}