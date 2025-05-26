// Crea un nuevo archivo ErrorHandler.kt en el paquete utils
package com.example.celureparoapp.utils

class ErrorHandler {
    fun handleException(e: Exception): Exception {
        // Aquí puedes personalizar el manejo de errores
        return when (e) {
            is java.net.ConnectException -> Exception("No se pudo conectar al servidor")
            is java.net.SocketTimeoutException -> Exception("Tiempo de espera agotado")
            else -> e
        }
    }
}