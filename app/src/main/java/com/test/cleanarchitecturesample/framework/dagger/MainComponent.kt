package com.test.cleanarchitecturesample.framework.dagger

import com.test.cleanarchitecturesample.MainActivity
import com.test.cleanarchitecturesample.framework.dagger.module.AppModule
import com.test.cleanarchitecturesample.framework.dagger.module.NetworkModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


const val SCHEDULER_MAIN_THREAD = "mainThread"
const val SCHEDULER_IO = "io"


@Singleton
@Component(modules = [
    (AppModule::class),
    (NetworkModule::class)
    ,(AndroidSupportInjectionModule::class)])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}