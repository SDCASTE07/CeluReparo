package com.example.celureparoapp.Repository

class CelularesRepository {
    private val service = ApiClient.celularesService

    suspend fun getCelulares(): Result<List<Celular>> {
        return try {
            val response = service.getCelulares()
            if (response.isSuccessful) {
                Result.success(response.body() ?: emptyList())
            } else {
                Result.failure(Exception("Error: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}