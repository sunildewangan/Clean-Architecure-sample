package com.test.cleanarchitecturesample.domain

data class PopularHeroViewState(val showLoading: Boolean = true,
                                val movies: List<HerosModel>? = null)

