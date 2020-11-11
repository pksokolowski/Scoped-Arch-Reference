package com.github.pksokolowski.scopedarch.base

import android.app.Application
import com.github.pksokolowski.scopedarch.repository.FakeContentRepository
import com.github.pksokolowski.scopedarch.repository.IFakeContentRepository
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @Provides
    fun getApplication() = application

    @Provides
    fun getContentRepository(): IFakeContentRepository = FakeContentRepository()
}