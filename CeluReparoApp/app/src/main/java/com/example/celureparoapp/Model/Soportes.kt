
package com.example.celureparoapp.Model

data class Soportes(
    val id: Int = 0,
    val costo: Double,
    val cliente_id: Int,
    val tecnico_id: Int,
    val celular_id: Int,
    val descripcion: String,
    val estado: String,
    val fecha_solicitud: Long,
    val fecha_finalizacion: Long,



    )