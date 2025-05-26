package com.example.celureparoapp.Model


import java.util.Date

data class Ventas(
    val id: Long = 0,
    val fecha_venta: Date,
    val precio_venta_total: Double,
    val cliente_id: Int,
    val vendedor_id: Int,
    val detalles: List<Detalles_venta> = emptyList()
)