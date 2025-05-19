package com.example.CeluReparo.Controller;

import com.example.CeluReparo.Model.RepuestoSoporte;
import com.example.CeluReparo.Service.RepuestoSoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/repuestos-soporte")
public class RepuestoSoporteController {

    @Autowired
    private RepuestoSoporteService repuestoSoporteService;

    // Registrar repuesto usado en soporte
    @PostMapping
    public ResponseEntity<RepuestoSoporte> createRepuestoSoporte(@RequestBody RepuestoSoporte repuestoSoporte) {
        return new ResponseEntity<>(repuestoSoporteService.save(repuestoSoporte), HttpStatus.CREATED);
    }

    // Obtener repuestos por soporte
    @GetMapping("/soporte/{soporteId}")
    public ResponseEntity<List<RepuestoSoporte>> getRepuestosBySoporteId(@PathVariable Long soporteId) {
        return new ResponseEntity<>(repuestoSoporteService.getRepuestosBySoporteId(soporteId), HttpStatus.OK);
    }
}
