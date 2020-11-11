package com.github.pksokolowski.scopedarch.base

import android.app.Activity
import com.github.pksokolowski.scopedarch.home.TestMainActivityComponent
import com.github.pksokolowski.scopedarch.di.ActivityKey
import com.github.pksokolowski.scopedarch.home.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [
TestMainActivityComponent::class
])
abstract class TestActivityBindingModule{

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun provideMainActivityInjector(builder: TestMainActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}