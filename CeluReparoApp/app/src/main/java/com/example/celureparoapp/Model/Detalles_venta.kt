package com.example.celureparoapp.Model

data class Detalles_venta(
    val id: Int = 0,
    val venta_id: Int,
    val tipo_producto: String,
    val producto_id: Int,
    val cantidad: Int,
    val precio_unitario: Double,
    val subtotal: Double,
    val celular_id: Int,
    val repuesto_id: Int
)