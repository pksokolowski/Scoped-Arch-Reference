package com.github.pksokolowski.scopedarch.ui

import dagger.Binds
import dagger.Module

@Module
abstract class NavigationModule {
    @Binds
    abstract fun provideScreenNavigation(defaultScreenNavigator: DefaultScreenNavigator): ScreenNavigator
}