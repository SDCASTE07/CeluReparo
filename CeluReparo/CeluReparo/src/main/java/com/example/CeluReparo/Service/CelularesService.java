package com.example.CeluReparo.Service;

import com.example.CeluReparo.Model.Celulares;
import com.example.CeluReparo.Repository.CelularesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CelularesService {

    @Autowired
    private CelularesRepository celularesRepository;

    // Guardar o actualizar un celular
    public Celulares saveOrUpdate(Celulares celular) {
        return celularesRepository.save(celular);
    }

    // Obtener todos los celulares
    public List<Celulares> getAllCelulares() {
        return celularesRepository.findAll();
    }

    // Buscar por ID
    public Optional<Celulares> getCelularById(int id) {
        return celularesRepository.findById(id);
    }

    // Eliminar un celular
    public void deleteCelular(int id) {
        celularesRepository.deleteById(id);
    }

    // Celulares en estado "NUEVO" (consulta nativa)
    public List<Celulares> getCelularesNuevos() {
        return celularesRepository.findCelularesNuevos();
    }

    // Buscar por marca
    public List<Celulares> findByMarca(String marca) {
        return celularesRepository.findByMarca(marca);
    }
}