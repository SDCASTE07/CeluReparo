package com.example.CeluReparo.Controller;

import com.example.CeluReparo.Model.Repuestos;
import com.example.CeluReparo.Service.RepuestosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestosController {

    @Autowired
    private RepuestosService repuestosService;

    // Registrar un repuesto
    @PostMapping
    public ResponseEntity<Repuestos> createRepuesto(@RequestBody Repuestos repuesto) {
        return new ResponseEntity<>(repuestosService.saveOrUpdate(repuesto), HttpStatus.CREATED);
    }

    // Listar todos los repuestos
    @GetMapping
    public ResponseEntity<List<Repuestos>> getAllRepuestos() {
        return new ResponseEntity<>(repuestosService.getAllRepuestos(), HttpStatus.OK);
    }

    // Buscar repuesto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Repuestos> getRepuestoById(@PathVariable Long id) {
        Optional<Repuestos> repuesto = repuestosService.getRepuestoById(id);
        return repuesto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar repuesto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepuesto(@PathVariable Long id) {
        repuestosService.deleteRepuesto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Consulta nativa: Repuestos con stock mínimo
    @GetMapping("/stock/{stockMinimo}")
    public ResponseEntity<List<Repuestos>> getRepuestosConStock(@PathVariable int stockMinimo) {
        return new ResponseEntity<>(repuestosService.getRepuestosConStock(stockMinimo), HttpStatus.OK);
    }
}
