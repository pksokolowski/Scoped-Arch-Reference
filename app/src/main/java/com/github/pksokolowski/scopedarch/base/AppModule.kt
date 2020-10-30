package com.github.pksokolowski.scopedarch.base

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @Provides
    fun getApplication() = application
}