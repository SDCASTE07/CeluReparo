package com.example.CeluReparo.Repository;

import com.example.CeluReparo.Model.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonasRepository extends JpaRepository<Personas, Integer> {

    // Consulta nativa: Obtener técnicos disponibles
    @Query(value = "SELECT * FROM personas WHERE rol = 'TECNICO'", nativeQuery = true)
    List<Personas> findTecnicosDisponibles();

    // Consulta nativa: Buscar por número de documento
    @Query(value = "SELECT * FROM personas WHERE num_documento = :numDocumento", nativeQuery = true)
    Personas findByNumDocumento(String numDocumento);
}