package com.example.CeluReparo.Service;

import com.example.CeluReparo.Model.Soportes;
import com.example.CeluReparo.Repository.SoportesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SoportesService {

    @Autowired
    private SoportesRepository soportesRepository;

    // Guardar o actualizar un soporte
    public Soportes saveOrUpdate(Soportes soporte) {
        return soportesRepository.save(soporte);
    }

    // Obtener todos los soportes
    public List<Soportes> getAllSoportes() {
        return soportesRepository.findAll();
    }

    // Buscar por ID
    public Optional<Soportes> getSoporteById(Long id) {
        return soportesRepository.findById(id);
    }

    // Eliminar un soporte
    public void deleteSoporte(Long id) {
        soportesRepository.deleteById(id);
    }

    // Soportes por estado (consulta nativa)
    public List<Soportes> getSoportesPorEstado(String estado) {
        return soportesRepository.findSoportesPorEstado(estado);
    }

    // Soportes asignados a un técnico
    public List<Soportes> getSoportesByTecnicoId(Integer tecnicoId) {
        return soportesRepository.findByTecnicoId(tecnicoId);
    }
}
