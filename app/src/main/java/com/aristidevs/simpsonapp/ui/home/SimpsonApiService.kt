package com.aristidevs.simpsonapp.ui.home

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpsonApiService {

    @GET("api/personajes/find/{query}")
    fun buscarPersonajes(@Path("query") query: String): Call<List<Personaje>>
}