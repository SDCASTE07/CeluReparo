package com.example.celureparoapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.celureparoapp.viewmodels.VentasViewModel

@Composable
fun VentasListScreen(
    viewModel: VentasViewModel = hiltViewModel()
) {
    // Corrección 1: Usar collectAsStateWithLifecycle para mejor manejo del ciclo de vida
    val ventas by viewModel.ventas.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()

    // Corrección 2: Manejo de estados (loading/error)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Text(text = error!!, color = Color.Red, fontSize = 16.sp)
        } else {
            // Corrección 3: Usar el parámetro correcto 'venta' en lugar de 'ventas'
            LazyColumn {
                items(ventas) { venta ->
                    Text("Venta ID: ${venta.id}") // Corregido: usar 'venta' en lugar de 'ventas'
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadVentas()
    }
}