package com.github.pksokolowski.scopedarch.base

import android.app.Application
import com.github.pksokolowski.scopedarch.di.ActivityInjector
import javax.inject.Inject

class App: Application() {

    @Inject
    lateinit var activityInjector: ActivityInjector

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        val component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        component.inject(this)
    }
}