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
import com.example.celureparoapp.viewmodels.CelularesViewModel

@Composable
fun CelularesListScreen(
    onNavigateToDetail: (Int) -> Unit,
    onNavigateToVentas: () -> Unit,
    onNavigateToRepuestos: () -> Unit,
    viewModel: CelularesViewModel = hiltViewModel()
) {
    val celulares by viewModel.celularesState.collectAsState()
    val isLoading by viewModel.loadingState.collectAsState()
    val error by viewModel.errorState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCelulares()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Celulares") },
                actions = {
                    IconButton(onClick = onNavigateToVentas) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Ventas")
                    }
                    IconButton(onClick = onNavigateToRepuestos) {
                        Icon(Icons.Default.Build, contentDescription = "Repuestos")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO: Navegar a creación de celular */ },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when {
                isLoading -> FullScreenLoading()
                error != null -> ErrorMessage(error = error!!, onRetry = { viewModel.loadCelulares() })
                celulares.isEmpty() -> EmptyState(message = "No hay celulares registrados")
                else -> CelularesListContent(celulares = celulares, onItemClick = onNavigateToDetail)
            }
        }
    }
}

@Composable
private fun CelularesListContent(
    celulares: List<Celulares>,
    onItemClick: (Int) -> Unit
) {
    LazyColumn {
        items(celulares) { celular ->
            CelularListItem(
                celular = celular,
                onClick = { onItemClick(celular.id) }
            )
        }
    }
}

@Composable
private fun CelularListItem(
    celular: Celulares,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "${celular.marca} ${celular.modelo}",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = celular.estado,
                    style = MaterialTheme.typography.bodyMedium,
                    color = when (celular.estado) {
                        "NUEVO" -> Color.Green
                        "USADO" -> Color.Yellow
                        "REPARADO" -> Color.Blue
                        else -> Color.Gray
                    }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "$${celular.precio}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}