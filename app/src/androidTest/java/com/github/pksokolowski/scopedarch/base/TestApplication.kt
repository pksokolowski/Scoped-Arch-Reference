package com.github.pksokolowski.scopedarch.base

import androidx.test.InstrumentationRegistry

class TestApplication : App() {


    override fun initComponent() =
        DaggerTestAppComponent.builder()
            .testAppModule(TestAppModule(this))
            .build()

    fun getComponent(): TestAppComponent? {
        return (InstrumentationRegistry.getTargetContext()
            .getApplicationContext() as TestApplication).getComponent() as TestAppComponent?
    }
}