package com.github.pksokolowski.scopedarch.base

import android.app.Application
import com.github.pksokolowski.scopedarch.di.ActivityInjector
import javax.inject.Inject

open class App : Application() {

    @Inject
    lateinit var activityInjector: ActivityInjector

    protected lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        val component = initComponent()
        component.inject(this)
    }

    protected open fun initComponent() =
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

}