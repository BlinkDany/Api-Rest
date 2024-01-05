package com.daniel.guiapractica4.Io

import com.daniel.guiapractica4.Modelo.Persona
import retrofit2.Call
import retrofit2.http.GET

interface ConsumirApi {

    @GET("persona")
    fun getTraer(): Call<Persona>
}