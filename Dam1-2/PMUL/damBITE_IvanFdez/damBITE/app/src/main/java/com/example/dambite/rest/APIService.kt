package com.example.dambite.rest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET
    fun getPlatosByName(@Url url: String): Call<ListaDePlatosResponse>

    @GET
    fun getPlatoById(@Url url: String): Call<ListaDePlatosResponse>
}