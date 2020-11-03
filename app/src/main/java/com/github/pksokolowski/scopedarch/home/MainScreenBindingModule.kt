package com.github.pksokolowski.scopedarch.home

import com.bluelinelabs.conductor.Controller
import com.github.pksokolowski.scopedarch.di.ControllerKey
import com.github.pksokolowski.scopedarch.main.MainFeatureComponent
import com.github.pksokolowski.scopedarch.main.MainFeatureController
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainFeatureComponent::class])
abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(MainFeatureController::class)
    abstract fun bindMainFeatureInjector(builder: MainFeatureComponent.Builder): AndroidInjector.Factory<out Controller>
}
