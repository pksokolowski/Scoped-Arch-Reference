package com.github.pksokolowski.scopedarch.home

import com.github.pksokolowski.scopedarch.di.ActivityScope
import com.github.pksokolowski.scopedarch.home.MainActivity
import com.github.pksokolowski.scopedarch.ui.NavigationModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(
    modules = [
        MainScreenBindingModule::class,
        NavigationModule::class
    ]
)
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {
        override fun seedInstance(instance: MainActivity?) {}
    }

}