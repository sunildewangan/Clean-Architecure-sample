package com.test.cleanarchitecturesample.framework

import android.app.Application
import com.test.cleanarchitecturesample.data.HeroRepository
import com.test.cleanarchitecturesample.framework.dagger.DaggerMainComponent
import com.test.cleanarchitecturesample.framework.dagger.MainComponent
import com.test.cleanarchitecturesample.framework.dagger.module.AppModule
import com.test.cleanarchitecturesample.framework.dagger.module.NetworkModule
import com.test.cleanarchitecturesample.interactors.FetchHeros

class MyApplication: Application() {
    lateinit var mainComponent: MainComponent
    override fun onCreate() {
        super.onCreate()
        initDependencies()
    }

    private fun initDependencies() {
        mainComponent = DaggerMainComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule("https://simplifiedcoding.net/demos/"))
            .build()
    }
}