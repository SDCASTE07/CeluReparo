// Archivo: screens/CelularesListScreen.kt
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.celureparoapp.ViewModel.VentasViewModel
@Composable
fun CrearVentaScreen(
    viewModel: VentasViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    var clienteSeleccionado by remember { mutableStateOf<Personas?>(null) }
    var productosSeleccionados by remember { mutableStateOf<List<DetallesVenta>>(emptyList()) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Nueva Venta") }) },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { viewModel.guardarVenta(clienteSeleccionado, productosSeleccionados) },
                icon = { Icon(Icons.Default.Save, "Guardar") },
                text = { Text("Finalizar Venta") }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            BuscadorClientes(onClienteSeleccionado = { clienteSeleccionado = it })
            ListaProductosDisponibles(
                productos = viewModel.productosDisponibles,
                onSeleccion = { productosSeleccionados = it }
            )
            ResumenVenta(total = productosSeleccionados.sumOf { it.subtotal })
        }
    }
}

@Composable
fun ResumenVenta(total: Double) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Resumen de Venta", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            Text("Total: $${String.format("%.2f", total)}",
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}