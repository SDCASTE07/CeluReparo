package com.example.celureparoapp.interfases

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CelularesService {
    @GET("api/celulares")
    suspend fun getCelulares(): Response<List<Celular>>

    @POST("api/celulares")
    suspend fun createCelular(@Body celular: Celular): Response<Celular>

    @DELETE("api/celulares/{id}")
    suspend fun deleteCelular(@Path("id") id: Int): Response<Void>
}