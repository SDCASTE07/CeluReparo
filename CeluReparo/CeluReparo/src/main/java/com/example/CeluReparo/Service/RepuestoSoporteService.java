package com.example.CeluReparo.Service;

import com.example.CeluReparo.Model.RepuestoSoporte;
import com.example.CeluReparo.Repository.RepuestoSoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RepuestoSoporteService {

    @Autowired
    private RepuestoSoporteRepository repuestoSoporteRepository;

    // Registrar un repuesto usado en soporte
    public RepuestoSoporte save(RepuestoSoporte repuestoSoporte) {
        return repuestoSoporteRepository.save(repuestoSoporte);
    }

    // Obtener repuestos por soporte
    public List<RepuestoSoporte> getRepuestosBySoporteId(Long soporteId) {
        return repuestoSoporteRepository.findBySoporteId(soporteId);
    }
}