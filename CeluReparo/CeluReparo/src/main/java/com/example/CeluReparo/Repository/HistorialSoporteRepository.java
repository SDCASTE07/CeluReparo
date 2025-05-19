package com.example.CeluReparo.Repository;

import com.example.CeluReparo.Model.HistorialSoporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HistorialSoporteRepository extends JpaRepository<HistorialSoporte, Long> {

    // Consulta nativa: Historial de un soporte específico
    @Query(value = "SELECT * FROM historial_soporte WHERE soporte_id = :soporteId", nativeQuery = true)
    List<HistorialSoporte> findHistorialBySoporteId(Long soporteId);
}
