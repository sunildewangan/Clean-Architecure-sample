package com.test.cleanarchitecturesample.framework.dagger.module

import com.test.cleanarchitecturesample.interactors.FetchHeros
import com.test.cleanarchitecturesample.presentation.main.MainMoviesVMFactory
import dagger.Module
import dagger.Provides

@Module
class MainHeroModule {
    @Provides
    fun providePopularMoviesVMFactory(useCase: FetchHeros)
            : MainMoviesVMFactory {
        return MainMoviesVMFactory(useCase)
    }
}