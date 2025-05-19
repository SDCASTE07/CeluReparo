package com.example.CeluReparo.Repository;

import com.example.CeluReparo.Model.Soportes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SoportesRepository extends JpaRepository<Soportes, Long> {

    // Consulta nativa: Soportes por estado
    @Query(value = "SELECT * FROM soportes WHERE estado = :estado", nativeQuery = true)
    List<Soportes> findSoportesPorEstado(String estado);

    // Soportes asignados a un técnico
    List<Soportes> findByTecnicoId(Integer tecnicoId);
}