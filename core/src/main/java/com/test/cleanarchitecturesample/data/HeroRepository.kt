package com.test.cleanarchitecturesample.data


class HeroRepository(private val dataSource: HeroDataSource) {
    fun getHeroList() = dataSource.getHeroList()
}