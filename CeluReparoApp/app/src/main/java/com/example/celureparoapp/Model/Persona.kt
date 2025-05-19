package com.example.celureparoapp.Model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Persona(
    val id: Int,
    @Json(name = "tipo_documento") val tipoDocumento: String,
    @Json(name = "num_documento") val numeroDocumento: String, // Mejor naming
    val nombre: String,
    @Json(name = "edad_1") val edad1: String,  // Nombre más descriptivo
    @Json(name = "edad_2") val edad2: String,
    val telefono: String,
    val email: String,
    val direccion: String, // Mantener en español correcto
    val rol: String
)