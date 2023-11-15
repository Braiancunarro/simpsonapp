package com.aristidevs.simpsonapp.ui.home

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpsonApiService {

    @GET("api/personajes/find/{query}")
     fun buscarPersonajes(@Path("query") query: String): Response<List<detallePersonajes>>

    companion object {
        var retrofitService: SimpsonApiService? = null
        fun getInstance() : SimpsonApiService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(SimpsonApiService::class.java)
            }
            return retrofitService!!
        }

    }
}