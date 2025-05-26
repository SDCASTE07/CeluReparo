package com.example.celureparoapp.ViewModelodel

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
class CelularDetailViewModel @Inject constructor(
    private val repository: CelularesRepository
) : ViewModel() {
    private val _celular = MutableStateFlow<Celulares?>(null)
    val celular: StateFlow<Celulares?> = _celular.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadCelular(id: Int) = viewModelScope.launch {
        _isLoading.value = true
        try {
            _celular.value = repository.getCelularById(id)
            _error.value = null
        } catch (e: Exception) {
            _error.value = "Error al cargar celular: ${e.message}"
        } finally {
            _isLoading.value = false
        }
    }

    fun updateCelular(celular: Celulares) = viewModelScope.launch {
        _isLoading.value = true
        try {
            val success = repository.updateCelular(celular)
            if (success) {
                _celular.value = celular
                _error.value = null
            } else {
                _error.value = "Error al actualizar el celular"
            }
        } catch (e: Exception) {
            _error.value = "Error al actualizar: ${e.message}"
        } finally {
            _isLoading.value = false
        }
    }
}