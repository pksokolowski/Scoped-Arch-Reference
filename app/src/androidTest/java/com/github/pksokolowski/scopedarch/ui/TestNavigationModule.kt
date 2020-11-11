package com.github.pksokolowski.scopedarch.ui

import dagger.Binds
import dagger.Module

@Module
abstract class TestNavigationModule {
    @Binds
    abstract fun provideScreenNavigation(navigator: TestNavigator): ScreenNavigator
}