package com.aristidevs.simpsonapp.ui.home


class SimpsonRepository constructor(private val retrofitService: SimpsonApiService) {


    fun getBuscarPersonajes(personajetexto: String){
           retrofitService.buscarPersonajes(personajetexto)
    }


}