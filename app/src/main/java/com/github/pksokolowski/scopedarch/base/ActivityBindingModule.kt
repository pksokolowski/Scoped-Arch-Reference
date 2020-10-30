package com.github.pksokolowski.scopedarch.base

import android.app.Activity
import com.github.pksokolowski.scopedarch.home.MainActivity
import com.github.pksokolowski.scopedarch.home.MainActivityComponent
import com.github.pksokolowski.scopedarch.di.ActivityKey
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun provideMainActivityInjector(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}