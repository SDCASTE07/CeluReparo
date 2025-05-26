package com.example.celureparoapp.Interfaces

import com.example.celureparoapp.Model.*
import okhttp3.OkHttpClient
import retrofit2.http.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

interface ApiService {
    // Endpoint para filtrar Personas por rol
    @GET("api/personas/tecnicos")
    suspend fun getTecnicos(): List<Personas>


    // Endpoint para actualizar estado de Soporte
    @PUT("api/soportes/{id}/estado")
    suspend fun updateEstadoSoporte(
        @Path("id") id: Long,
        @Body estado: Map<String, String>
    ): Soportes
    /* ==================== ENDPOINTS PARA CELULARES ==================== */
    @GET("api/celulares")
    suspend fun getAllCelulares(): List<Celulares>

    @GET("api/celulares/{id}")
    suspend fun getCelularById(@Path("id") id: Int): Celulares

    @POST("api/celulares")
    suspend fun createCelular(@Body celular: Celulares): Celulares

    @PUT("api/celulares/{id}")
    suspend fun updateCelular(
        @Path("id") id: Int,
        @Body celular: Celulares
    ): Celulares

    @DELETE("api/celulares/{id}")
    suspend fun deleteCelular(@Path("id") id: Int)

    /* ==================== ENDPOINTS PARA PERSONAS ==================== */
    @GET("api/personas")
    suspend fun getAllPersonas(): List<Personas>

    @GET("api/personas/{id}")
    suspend fun getPersonaById(@Path("id") id: Int): Personas

    @POST("api/personas")
    suspend fun createPersona(@Body persona: Personas): Personas

    @PUT("api/personas/{id}")
    suspend fun updatePersona(
        @Path("id") id: Int,
        @Body persona: Personas
    ): Personas

    @DELETE("api/personas/{id}")
    suspend fun deletePersona(@Path("id") id: Int)

    /* ==================== ENDPOINTS PARA VENTAS ==================== */
    @GET("api/ventas")
    suspend fun getAllVentas(): List<Ventas>

    @GET("api/ventas/{id}")
    suspend fun getVentaById(@Path("id") id: Int): Ventas

    @POST("api/ventas")
    suspend fun createVenta(@Body venta: Ventas): Ventas

    /* ==================== ENDPOINTS PARA REPUESTOS ==================== */
    @GET("api/repuestos")
    suspend fun getAllRepuestos(): List<Repuestos>

    @GET("api/repuestos/{id}")
    suspend fun getRepuestoById(@Path("id") id: Int): Repuestos

    @POST("api/repuestos")
    suspend fun createRepuesto(@Body repuesto: Repuestos): Repuestos

    @PUT("api/repuestos/{id}")
    suspend fun updateRepuesto(
        @Path("id") id: Long,
        @Body repuesto: Repuestos
    ): Repuestos

    /* ==================== ENDPOINTS PARA SOPORTES ==================== */
    @GET("api/soportes")
    suspend fun getAllSoportes(): List<Soportes>

    @POST("api/soportes")
    suspend fun createSoporte(@Body soporte: Soportes): Soportes
    // En tu interfaz ApiService, añade este método
    @GET("api/soportes/estado/{estado}")
    suspend fun getSoportesPorEstado(@Path("estado") estado: String): List<Soportes>
}

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8081" // URL para emulador Android

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build()
            )
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}