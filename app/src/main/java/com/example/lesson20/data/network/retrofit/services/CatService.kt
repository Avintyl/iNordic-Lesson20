package com.example.lesson20.data.network.retrofit.services

import com.example.lesson20.data.network.retrofit.models.Cat
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CatService {

    @GET(value = "images/search")
    fun getCat(): Single<List<Cat>>
}