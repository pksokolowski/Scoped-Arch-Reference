package com.github.pksokolowski.scopedarch.base

import com.github.pksokolowski.scopedarch.di.PerApp
import com.github.pksokolowski.scopedarch.home.MainScreenBindingModule
import com.github.pksokolowski.scopedarch.trending.TrendingReposController
import dagger.Component

@PerApp
@Component(
    modules = [
        AppModule::class,
        ActivityBindingModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)
}