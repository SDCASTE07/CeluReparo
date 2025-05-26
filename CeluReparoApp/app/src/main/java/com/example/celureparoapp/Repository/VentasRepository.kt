package com.example.celureparoapp.repository

import com.example.celureparoapp.Model.Ventas
import com.example.celureparoapp.Interfaces.ApiService
import javax.inject.Inject
import javax.inject.Singleton

// VentasRepository.kt
@Singleton
class VentasRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getAllVentas(): List<Ventas> {
        return apiService.getAllVentas()
    }
}