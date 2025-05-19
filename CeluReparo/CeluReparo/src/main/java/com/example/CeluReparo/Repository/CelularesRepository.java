package com.example.CeluReparo.Repository;

import com.example.CeluReparo.Model.Celulares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CelularesRepository extends JpaRepository<Celulares, Integer> {

    // Consulta nativa: Celulares en estado "NUEVO"
    @Query(value = "SELECT * FROM celulares WHERE estado = 'NUEVO'", nativeQuery = true)
    List<Celulares> findCelularesNuevos();

    // Consulta por marca
    List<Celulares> findByMarca(String marca);
}