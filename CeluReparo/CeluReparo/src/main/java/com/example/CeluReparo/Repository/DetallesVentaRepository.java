package com.example.CeluReparo.Repository;

import com.example.CeluReparo.Model.DetallesVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesVentaRepository extends JpaRepository<DetallesVenta, Long> {
    // Métodos básicos ya heredados (save, findAll, etc.)
}
