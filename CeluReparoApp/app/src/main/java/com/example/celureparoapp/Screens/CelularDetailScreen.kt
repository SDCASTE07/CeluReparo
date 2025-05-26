package com.example.celureparoapp.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.celureparoapp.Model.Celulares
import com.example.celureparoapp.ViewModel.CelularDetailViewModel
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CelularDetailScreen(
    celularId: Int,
    onBack: () -> Unit,
    onEditSuccess: () -> Unit,
    viewModel: CelularDetailViewModel = hiltViewModel()
) {
    // Estado del celular
    val celularState by viewModel.celular.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    // Cargar datos al iniciar
    LaunchedEffect(celularId) {
        viewModel.loadCelular(celularId)
    }

    // Manejar estado de edición
    var isEditing by remember { mutableStateOf(false) }
    var editedCelular by remember {
        mutableStateOf(
            Celulares(
                id = 0,
                marca = "",
                modelo = "",
                estado = "",
                precio = 0.0,
                fecha_registro = Date()
            )
        )
    }

    // Actualizar editedCelular cuando cambia el estado
    LaunchedEffect(celularState) {
        celularState?.let { editedCelular = it }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del Celular") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
                actions = {
                    IconButton(onClick = { isEditing = !isEditing }) {
                        Icon(Icons.Default.Edit, contentDescription = "Editar")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when {
                isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                error != null -> {
                    Text(
                        text = error!!,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                celularState == null -> {
                    Text(
                        text = "Celular no encontrado",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                else -> {
                    if (isEditing) {
                        EditCelularForm(
                            celular = editedCelular,
                            onCelularChange = { editedCelular = it },
                            onSave = {
                                viewModel.updateCelular(editedCelular)
                                isEditing = false
                                onEditSuccess()
                            },
                            onCancel = { isEditing = false }
                        )
                    } else {
                        CelularDetailContent(
                            celular = celularState!!,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun CelularDetailContent(
    celular: Celulares,
    modifier: Modifier = Modifier
) {
    val dateFormat = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "${celular.marca} ${celular.modelo}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        DetailItem("Estado", celular.estado)
        DetailItem("Precio", "$${celular.precio}")
        DetailItem("Fecha Registro", dateFormat.format(celular.fecha_registro))

        // Agregar más detalles según sea necesario
    }
}

@Composable
private fun DetailItem(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = Color.Gray
        )
        Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun EditCelularForm(
    celular: Celulares,
    onCelularChange: (Celulares) -> Unit,
    onSave: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = celular.estado,
            onValueChange = { onCelularChange(celular.copy(estado = it)) },
            label = { Text("Estado") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = celular.marca,
            onValueChange = { onCelularChange(celular.copy(marca = it)) },
            label = { Text("Marca") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = celular.modelo,
            onValueChange = { onCelularChange(celular.copy(modelo = it)) },
            label = { Text("Modelo") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = celular.precio.toString(),
            onValueChange = { onCelularChange(celular.copy(precio = it.toDoubleOrNull() ?: 0.0)) },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = onCancel) {
                Text("Cancelar")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = onSave) {
                Text("Guardar")
            }
        }
    }
}