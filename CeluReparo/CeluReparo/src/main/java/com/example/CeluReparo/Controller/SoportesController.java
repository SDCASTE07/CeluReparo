package com.example.CeluReparo.Controller;

import com.example.CeluReparo.Model.Soportes;
import com.example.CeluReparo.Service.SoportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/soportes")
public class SoportesController {

    @Autowired
    private SoportesService soportesService;

    // Crear un soporte técnico
    @PostMapping
    public ResponseEntity<Soportes> createSoporte(@RequestBody Soportes soporte) {
        return new ResponseEntity<>(soportesService.saveOrUpdate(soporte), HttpStatus.CREATED);
    }

    // Listar todos los soportes
    @GetMapping
    public ResponseEntity<List<Soportes>> getAllSoportes() {
        return new ResponseEntity<>(soportesService.getAllSoportes(), HttpStatus.OK);
    }

    // Buscar soporte por ID
    @GetMapping("/{id}")
    public ResponseEntity<Soportes> getSoporteById(@PathVariable Long id) {
        Optional<Soportes> soporte = soportesService.getSoporteById(id);
        return soporte.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar soporte
    @PutMapping("/{id}")
    public ResponseEntity<Soportes> updateSoporte(@PathVariable Long id, @RequestBody Soportes soporte) {
        soporte.setId(id);
        return new ResponseEntity<>(soportesService.saveOrUpdate(soporte), HttpStatus.OK);
    }

    // Eliminar soporte
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoporte(@PathVariable Long id) {
        soportesService.deleteSoporte(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Consulta nativa: Soportes por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Soportes>> getSoportesPorEstado(@PathVariable String estado) {
        return new ResponseEntity<>(soportesService.getSoportesPorEstado(estado), HttpStatus.OK);
    }
}
