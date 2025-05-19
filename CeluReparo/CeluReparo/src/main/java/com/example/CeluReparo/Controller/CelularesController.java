package com.example.CeluReparo.Controller;

import com.example.CeluReparo.Model.Celulares;
import com.example.CeluReparo.Service.CelularesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/celulares")
public class CelularesController {

    @Autowired
    private CelularesService celularesService;

    // Registrar un celular
    @PostMapping
    public ResponseEntity<Celulares> createCelular(@RequestBody Celulares celular) {
        return new ResponseEntity<>(celularesService.saveOrUpdate(celular), HttpStatus.CREATED);
    }

    // Listar todos los celulares
    @GetMapping
    public ResponseEntity<List<Celulares>> getAllCelulares() {
        return new ResponseEntity<>(celularesService.getAllCelulares(), HttpStatus.OK);
    }

    // Buscar celular por ID
    @GetMapping("/{id}")
    public ResponseEntity<Celulares> getCelularById(@PathVariable int id) {
        Optional<Celulares> celular = celularesService.getCelularById(id);
        return celular.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar celular
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCelular(@PathVariable int id) {
        celularesService.deleteCelular(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Consulta nativa: Celulares nuevos
    @GetMapping("/nuevos")
    public ResponseEntity<List<Celulares>> getCelularesNuevos() {
        return new ResponseEntity<>(celularesService.getCelularesNuevos(), HttpStatus.OK);
    }
}