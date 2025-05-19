package com.example.CeluReparo.Service;

import com.example.CeluReparo.Model.Personas;
import com.example.CeluReparo.Repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonasService {

    @Autowired
    private PersonasRepository personasRepository;

    // Guardar o actualizar una persona
    public Personas saveOrUpdate(Personas persona) {
        return personasRepository.save(persona);
    }

    // Obtener todas las personas
    public List<Personas> getAllPersonas() {
        return personasRepository.findAll();
    }

    // Buscar por ID
    public Optional<Personas> getPersonaById(Integer id) {
        return personasRepository.findById(id);
    }

    // Eliminar una persona
    public void deletePersona(Integer id) {
        personasRepository.deleteById(id);
    }

    // Obtener técnicos disponibles (consulta nativa)
    public List<Personas> getTecnicosDisponibles() {
        return personasRepository.findTecnicosDisponibles();
    }

    // Buscar por número de documento
    public Personas findByNumDocumento(String numDocumento) {
        return personasRepository.findByNumDocumento(numDocumento);
    }
}