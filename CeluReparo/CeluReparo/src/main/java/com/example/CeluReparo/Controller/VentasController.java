package com.example.CeluReparo.Controller;

import com.example.CeluReparo.Model.Ventas;
import com.example.CeluReparo.Service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    // Registrar una venta
    @PostMapping
    public ResponseEntity<Ventas> createVenta(@RequestBody Ventas venta) {
        return new ResponseEntity<>(ventasService.saveOrUpdate(venta), HttpStatus.CREATED);
    }

    // Listar todas las ventas
    @GetMapping
    public ResponseEntity<List<Ventas>> getAllVentas() {
        return new ResponseEntity<>(ventasService.getAllVentas(), HttpStatus.OK);
    }

    // Buscar venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Ventas> getVentaById(@PathVariable Long id) {
        Optional<Ventas> venta = ventasService.getVentaById(id);
        return venta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        ventasService.deleteVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Consulta nativa: Ventas por rango de fechas
    @GetMapping("/fechas")
    public ResponseEntity<List<Ventas>> getVentasPorFecha(
            @RequestParam String fechaInicio,
            @RequestParam String fechaFin
    ) {
        return new ResponseEntity<>(ventasService.getVentasPorFecha(fechaInicio, fechaFin), HttpStatus.OK);
    }
}
