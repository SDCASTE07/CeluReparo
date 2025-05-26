package com.example.celureparoapp.Repository

import com.example.celureparoapp.Model.Celulares
import com.example.celureparoapp.Interfaces.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CelularesRepository @Inject constructor(
    private val apiService: ApiService
) {
    // Obtener todos los celulares
    suspend fun getAllCelulares(): Result<List<Celulares>> {
        return try {
            Result.success(apiService.getAllCelulares())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Obtener celular por ID
    suspend fun getCelularById(id: Int): Result<Celulares> {
        return try {
            Result.success(apiService.getCelularById(id))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Crear nuevo celular
    suspend fun createCelular(celular: Celulares): Result<Celulares> {
        return try {
            Result.success(apiService.createCelular(celular))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Actualizar celular (versión unificada)
    suspend fun updateCelular(celular: Celulares): Result<Boolean> {
        return try {
            apiService.updateCelular(celular.id, celular)
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Eliminar celular (función adicional recomendada)
    suspend fun deleteCelular(id: Int): Result<Boolean> {
        return try {
            apiService.deleteCelular(id)
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}