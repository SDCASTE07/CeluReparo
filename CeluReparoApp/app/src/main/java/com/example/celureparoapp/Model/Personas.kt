package com.example.celureparoapp.Model

data class Personas(
    val id: Int = 0,
    val tipo_documento: String,
    val num_documento: String,
    val nombre: String,
    val apellido_1: String,
    val apellido_2: String,
    val telefono: String,
    val email: String,
    val direccion: String,
    val rol: String
)