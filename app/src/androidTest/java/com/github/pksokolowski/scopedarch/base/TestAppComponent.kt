package com.github.pksokolowski.scopedarch.base

import com.github.pksokolowski.scopedarch.di.PerApp
import com.github.pksokolowski.scopedarch.ui.TestNavigationModule
import dagger.Component

@PerApp
@Component(
    modules = [
        TestAppModule::class,
        TestActivityBindingModule::class,
        TestNavigationModule::class
    ]
)
interface TestAppComponent : AppComponent {

    // create inject methods per test here, like:
    //  open fun inject(trendingReposControllerTest: SomeThingTest?)
}