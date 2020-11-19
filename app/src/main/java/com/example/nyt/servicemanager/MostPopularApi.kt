package com.example.nyt.servicemanager

import com.example.nyt.data.MostPopular
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MostPopularApi {

    @GET("/svc/mostpopular/v2/viewed/7.json")
    fun getPopularItems(
        @Query("api-key") key: String
    ): Single<Response<MostPopular>>

}
