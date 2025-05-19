package com.example.celureparoapp.Model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Celular(
    val id: Int,
    val marca: String,
    val modelo: String,
    val estado: String,
    val precio: Int,
    @Json(name = "fecha_registro") val fechaRegistro: String
)
