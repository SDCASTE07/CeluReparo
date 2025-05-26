package com.example.celureparoapp.Model

import java.util.Date

data class Celulares(
    val id: Int = 0,
    val marca: String,
    val modelo: String,
    val estado: String,
    val precio: Double,
    val fecha_registro: Date


)