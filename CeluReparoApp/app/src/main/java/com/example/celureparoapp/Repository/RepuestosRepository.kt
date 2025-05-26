package com.example.celureparoapp.repository

import com.example.celureparoapp.Model.Repuestos
import com.example.celureparoapp.Interfaces.ApiService
import com.example.celureparoapp.Utils.Result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepuestosRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getAllRepuestos(): Result<List<Repuestos>> {
        return try {
            Result.Success(apiService.getAllRepuestos())
        } catch (e: Exception) {
            Result.Error(e.message ?: "Error desconocido al obtener repuestos")
        }
    }

    suspend fun createRepuesto(repuesto: Repuestos): Result<Repuestos> {
        return try {
            Result.Success(apiService.createRepuesto(repuesto))
        } catch (e: Exception) {
            Result.Error(e.message ?: "Error al crear repuesto")
        }
    }

    suspend fun updateRepuesto(id: Long, repuesto: Repuestos): Result<Repuestos> {
        return try {
            Result.Success(apiService.updateRepuesto(id, repuesto))
        } catch (e: Exception) {
            Result.Error(e.message ?: "Error al actualizar repuesto")
        }
    }
}