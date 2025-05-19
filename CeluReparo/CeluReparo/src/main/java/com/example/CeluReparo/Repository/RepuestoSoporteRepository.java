package com.example.CeluReparo.Repository;

import com.example.CeluReparo.Model.RepuestoSoporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepuestoSoporteRepository extends JpaRepository<RepuestoSoporte, Long> {

    // Repuestos utilizados en un soporte
    List<RepuestoSoporte> findBySoporteId(Long soporteId);
}