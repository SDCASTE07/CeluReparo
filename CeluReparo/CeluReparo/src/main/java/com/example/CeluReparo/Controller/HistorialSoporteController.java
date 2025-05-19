package com.example.CeluReparo.Controller;

import com.example.CeluReparo.Model.HistorialSoporte;
import com.example.CeluReparo.Service.HistorialSoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/historial-soporte")
public class HistorialSoporteController {

    @Autowired
    private HistorialSoporteService historialSoporteService;

    // Registrar un historial
    @PostMapping
    public ResponseEntity<HistorialSoporte> createHistorial(@RequestBody HistorialSoporte historial) {
        return new ResponseEntity<>(historialSoporteService.save(historial), HttpStatus.CREATED);
    }

    // Obtener historial por ID de soporte
    @GetMapping("/soporte/{soporteId}")
    public ResponseEntity<List<HistorialSoporte>> getHistorialBySoporteId(@PathVariable Long soporteId) {
        return new ResponseEntity<>(historialSoporteService.getHistorialBySoporteId(soporteId), HttpStatus.OK);
    }
}
