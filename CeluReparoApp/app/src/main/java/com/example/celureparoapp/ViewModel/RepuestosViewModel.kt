package com.example.celureparoapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.celureparoapp.Model.Repuestos
import com.example.celureparoapp.repository.RepuestosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepuestosViewModel @Inject constructor(
    private val repository: RepuestosRepository
) : ViewModel() {
    private val _repuestos = MutableStateFlow<List<Repuestos>>(emptyList())
    val repuestos: StateFlow<List<Repuestos>> = _repuestos.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadRepuestos() = viewModelScope.launch {
        _isLoading.value = true
        try {
            _repuestos.value = repository.getAllRepuestos()
            _error.value = null
        } catch (e: Exception) {
            _error.value = "Error al cargar repuestos: ${e.message}"
        } finally {
            _isLoading.value = false
        }
    }

    fun clearError() {
        _error.value = null
    }
}