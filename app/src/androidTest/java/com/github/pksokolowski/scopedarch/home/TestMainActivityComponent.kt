package com.github.pksokolowski.scopedarch.home

import com.github.pksokolowski.scopedarch.di.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(
    modules = [
        TestScreenBindingModule::class
    ]
)
interface TestMainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {
        override fun seedInstance(instance: MainActivity?) {}
    }
}