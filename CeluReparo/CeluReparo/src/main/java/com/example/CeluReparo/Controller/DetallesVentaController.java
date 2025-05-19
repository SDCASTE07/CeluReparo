package com.example.CeluReparo.Controller;

import com.example.CeluReparo.Model.DetallesVenta;
import com.example.CeluReparo.Service.DetallesVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detalles-venta")
public class DetallesVentaController {

    @Autowired
    private DetallesVentaService detallesVentaService;

    // Registrar un detalle de venta
    @PostMapping
    public ResponseEntity<DetallesVenta> createDetalle(@RequestBody DetallesVenta detalle) {
        return new ResponseEntity<>(detallesVentaService.save(detalle), HttpStatus.CREATED);
    }

    // Listar todos los detalles
    @GetMapping
    public ResponseEntity<List<DetallesVenta>> getAllDetalles() {
        return new ResponseEntity<>(detallesVentaService.getAllDetalles(), HttpStatus.OK);
    }

    // Buscar detalle por ID
    @GetMapping("/{id}")
    public ResponseEntity<DetallesVenta> getDetalleById(@PathVariable Long id) {
        return new ResponseEntity<>(detallesVentaService.getDetalleById(id).orElse(null), HttpStatus.OK);
    }
}
