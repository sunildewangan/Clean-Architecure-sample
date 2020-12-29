package com.test.cleanarchitecturesample.interactors

import com.test.cleanarchitecturesample.data.HeroRepository
import com.test.cleanarchitecturesample.domain.HerosModel

class FetchHeros(private val heroRepository: HeroRepository) {

    operator fun invoke() = heroRepository.getHeroList()
}