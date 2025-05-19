package com.example.CeluReparo.Service;

import com.example.CeluReparo.Model.HistorialSoporte;
import com.example.CeluReparo.Repository.HistorialSoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HistorialSoporteService {

    @Autowired
    private HistorialSoporteRepository historialSoporteRepository;

    // Guardar un registro de historial
    public HistorialSoporte save(HistorialSoporte historial) {
        return historialSoporteRepository.save(historial);
    }

    // Obtener historial por ID de soporte
    public List<HistorialSoporte> getHistorialBySoporteId(Long soporteId) {
        return historialSoporteRepository.findHistorialBySoporteId(soporteId);
    }
}
