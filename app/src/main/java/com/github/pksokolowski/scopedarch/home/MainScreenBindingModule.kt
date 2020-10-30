package com.github.pksokolowski.scopedarch.home

import com.bluelinelabs.conductor.Controller
import com.github.pksokolowski.scopedarch.di.ControllerKey
import com.github.pksokolowski.scopedarch.trending.TrendingReposComponent
import com.github.pksokolowski.scopedarch.trending.TrendingReposController
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [TrendingReposComponent::class])
abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController::class)
    abstract fun bindTrendingReposInjector(builder: TrendingReposComponent.Builder): AndroidInjector.Factory<out Controller>
}
