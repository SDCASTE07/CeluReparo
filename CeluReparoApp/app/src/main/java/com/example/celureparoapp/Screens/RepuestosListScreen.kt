package com.example.celureparoapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.celureparoapp.viewmodels.RepuestosViewModel
import kotlinx.coroutines.launch

@Composable
fun RepuestosListScreen(
    viewModel: RepuestosViewModel = hiltViewModel()
) {
    // Estados observables
    val repuestos by viewModel.repuestos.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()

    // Snackbar para mostrar errores
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    // Manejo de errores
    LaunchedEffect(error) {
        error?.let { err ->
            scope.launch {
                snackbarHostState.showSnackbar(
                    message = err,
                    duration = SnackbarDuration.Short
                )
                viewModel.clearError()
            }
        }
    }

    // Carga inicial
    LaunchedEffect(Unit) {
        viewModel.loadRepuestos()
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("Lista de Repuestos") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when {
                isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
                repuestos.isEmpty() -> {
                    Text(
                        "No hay repuestos disponibles",
                        color = Color.Gray,
                        fontSize = 18.sp
                    )
                }
                else -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(repuestos) { repuesto ->
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = repuesto.nombre,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Stock: ${repuesto.cantidadDisponible}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = if (repuesto.cantidadDisponible > 0) Color.Unspecified else Color.Red
                                )
                                Text(
                                    text = "Precio: $${repuesto.precio}",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}