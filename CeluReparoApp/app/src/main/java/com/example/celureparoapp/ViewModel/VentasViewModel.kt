// Archivo: viewmodels/CelularesViewModel.kt
package com.example.celureparoapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.celureparoapp.Model.Ventas
import com.example.celureparoapp.repository.VentasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
// VentasViewModel.kt
@HiltViewModel
class VentasViewModel @Inject constructor(
    private val repository: VentasRepository
) : ViewModel() {
    private val _ventas = MutableStateFlow<List<Ventas>>(emptyList())
    val ventas = _ventas.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    fun loadVentas() = viewModelScope.launch {
        _isLoading.value = true
        try {
            _ventas.value = repository.getAllVentas()
            _error.value = null
        } catch (e: Exception) {
            _error.value = "Error al cargar ventas: ${e.message}"
        } finally {
            _isLoading.value = false
        }
    }
}
