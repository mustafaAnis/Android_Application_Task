package com.example.androidapplicationtask

import retrofit2.Response
import retrofit2.http.GET

interface FlashesAPI {

    @GET("/oNduC1")
    suspend fun getFlashes() : Response<FlashesList>

}