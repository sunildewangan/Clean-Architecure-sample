package com.test.cleanarchitecturesample.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.cleanarchitecturesample.interactors.FetchHeros

class MainMoviesVMFactory(private val useCase: FetchHeros
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(useCase) as T
    }
}