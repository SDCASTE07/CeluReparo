// Archivo: viewmodels/CelularesViewModel.kt
package com.example.celureparoapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.celureparoapp.Model.Celulares
import com.example.celureparoapp.Repository.CelularesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CelularesViewModel @Inject constructor(
    private val repository: CelularesRepository
) : ViewModel() {

    // Estados para manejar la UI
    private val _celularesState = MutableStateFlow<List<Celulares>>(emptyList())
    val celularesState: StateFlow<List<Celulares>> = _celularesState.asStateFlow()

    private val _loadingState = MutableStateFlow(false)
    val loadingState: StateFlow<Boolean> = _loadingState.asStateFlow()

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> = _errorState.asStateFlow()

    // Cargar todos los celulares
    fun loadCelulares() {
        viewModelScope.launch {
            _loadingState.value = true
            try {
                val celulares = repository.getAllCelulares()
                _celularesState.value = Celulares
                _errorState.value = null
            } catch (e: Exception) {
                _errorState.value = "Error al cargar: ${e.message}"
            } finally {
                _loadingState.value = false
            }
        }
    }

    // Crear un nuevo celular
    fun createCelular(celular: Celulares) {
        viewModelScope.launch {
            _loadingState.value = true
            try {
                repository.createCelular(celular)
                loadCelulares() // Recargar la lista
            } catch (e: Exception) {
                _errorState.value = "Error al crear: ${e.message}"
            } finally {
                _loadingState.value = false
            }
        }
    }
}