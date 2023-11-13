package com.aristidevs.simpsonapp.ui.home

import com.google.gson.annotations.SerializedName

data class Personaje( @SerializedName("docs") val personajes:List<detallePersonajes>)

data class detallePersonajes(
    @SerializedName("Nombre") val nombre :String,
    @SerializedName("Imagen") val imagen :String,
    @SerializedName("Historia") val historia :String,
    @SerializedName("Estado") val estado :String,
    @SerializedName("Ocupacion") val ocupacion: String,
    @SerializedName("Genero") val genero : String,
)