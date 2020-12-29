package com.test.cleanarchitecturesample.presentation.main


import androidx.lifecycle.MutableLiveData
import com.test.cleanarchitecturesample.domain.PopularHeroViewState
import com.test.cleanarchitecturesample.framework.base.BaseViewModel
import com.test.cleanarchitecturesample.interactors.FetchHeros

class MainViewModel(val fetchHeros: FetchHeros):BaseViewModel()  {

    var viewState: MutableLiveData<PopularHeroViewState> = MutableLiveData()

    fun getHeroList(){
        addDisposable(fetchHeros.invoke()
            .subscribe({ movies ->
                viewState.value?.let {
                    val newState = this.viewState.value?.copy(showLoading = false, movies = movies)
                    this.viewState.value = newState
                    println("response success = ${newState?.movies}")
                }

            }, {
                viewState.value = viewState.value?.copy(showLoading = false)
                println("response failed =")
            }
            )
        )
    }
}