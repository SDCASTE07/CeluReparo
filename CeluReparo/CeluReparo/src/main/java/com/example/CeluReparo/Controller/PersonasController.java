package com.example.CeluReparo.Controller;

import com.example.CeluReparo.Model.Personas;
import com.example.CeluReparo.Service.PersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class PersonasController {

    @Autowired
    private PersonasService personasService;

    // Crear una persona
    @PostMapping
    public ResponseEntity<Personas> createPersona(@RequestBody Personas persona) {
        return new ResponseEntity<>(personasService.saveOrUpdate(persona), HttpStatus.CREATED);
    }

    // Obtener todas las personas
    @GetMapping
    public ResponseEntity<List<Personas>> getAllPersonas() {
        return new ResponseEntity<>(personasService.getAllPersonas(), HttpStatus.OK);
    }

    // Obtener persona por ID
    @GetMapping("/{id}")
    public ResponseEntity<Personas> getPersonaById(@PathVariable Integer id) {
        Optional<Personas> persona = personasService.getPersonaById(id);
        return persona.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar persona
    @PutMapping("/{id}")
    public ResponseEntity<Personas> updatePersona(@PathVariable Integer id, @RequestBody Personas persona) {
        persona.setId(id);
        return new ResponseEntity<>(personasService.saveOrUpdate(persona), HttpStatus.OK);
    }

    // Eliminar persona
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Integer id) {
        personasService.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint personalizado: Obtener técnicos disponibles
    @GetMapping("/tecnicos")
    public ResponseEntity<List<Personas>> getTecnicosDisponibles() {
        return new ResponseEntity<>(personasService.getTecnicosDisponibles(), HttpStatus.OK);
    }
}