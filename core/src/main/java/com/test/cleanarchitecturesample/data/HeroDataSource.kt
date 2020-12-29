package com.test.cleanarchitecturesample.data

import com.test.cleanarchitecturesample.domain.HerosModel
import io.reactivex.Observable


interface HeroDataSource {
    fun getHeroList(): Observable<List<HerosModel>>
}