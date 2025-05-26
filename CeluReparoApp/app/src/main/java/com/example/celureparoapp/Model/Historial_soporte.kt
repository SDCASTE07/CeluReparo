package com.example.celureparoapp.Model

data class Historial_soporte(
    val id: Int = 0,
    val estado: String,
    val fecha_registro: Long,
    val observacion: String,
    val soporte_id: Int,
    val tecnico_id: Int
)