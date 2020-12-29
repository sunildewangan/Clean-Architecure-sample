package com.test.cleanarchitecturesample.framework.api

import com.test.cleanarchitecturesample.domain.HerosModel
import retrofit2.http.GET

interface Api {
    @GET("marvel")
    fun getHeroes(): List<HerosModel>
}