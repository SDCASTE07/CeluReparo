package com.example.CeluReparo.Repository;

import com.example.CeluReparo.Model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {

    // Consulta nativa: Ventas en un rango de fechas
    @Query(value = "SELECT * FROM ventas WHERE fecha_venta BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
    List<Ventas> findVentasPorFecha(String fechaInicio, String fechaFin);

    // Ventas de un cliente específico
    List<Ventas> findByClienteId(Integer clienteId);
}