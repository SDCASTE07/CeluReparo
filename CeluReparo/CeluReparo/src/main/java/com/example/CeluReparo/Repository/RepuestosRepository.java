package com.example.CeluReparo.Repository;

import com.example.CeluReparo.Model.Repuestos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RepuestosRepository extends JpaRepository<Repuestos, Long> {

    // Consulta nativa: Repuestos con stock mayor a X
    @Query(value = "SELECT * FROM repuestos WHERE cantidad_disponible > :stockMinimo", nativeQuery = true)
    List<Repuestos> findRepuestosConStock(int stockMinimo);

    // Buscar por nombre
    List<Repuestos> findByNombreContaining(String nombre);
}
