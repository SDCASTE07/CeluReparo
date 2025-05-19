package com.example.celureparoapp.ViewModel

class CelularesViewModel : ViewModel() {
    private val repository = CelularesRepository()
    private val _celulares = MutableLiveData<List<Celular>>()
    val celulares: LiveData<List<Celular>> = _celulares

    fun loadCelulares() {
        viewModelScope.launch {
            _celulares.value = repository.getCelulares().getOrElse { emptyList() }
        }
    }
}