package com.github.pksokolowski.scopedarch.base

import android.app.Application
import com.github.pksokolowski.scopedarch.repository.TestFakeContentRepository
import com.github.pksokolowski.scopedarch.repository.IFakeContentRepository
import dagger.Module
import dagger.Provides

@Module
class TestAppModule(private val application: Application) {

    @Provides
    fun getApplication() = application

    @Provides
    fun getContentRepository(): IFakeContentRepository = TestFakeContentRepository()
}