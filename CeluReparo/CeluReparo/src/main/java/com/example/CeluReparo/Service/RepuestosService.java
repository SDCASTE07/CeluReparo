package com.example.CeluReparo.Service;

import com.example.CeluReparo.Model.Repuestos;
import com.example.CeluReparo.Repository.RepuestosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RepuestosService {

    @Autowired
    private RepuestosRepository repuestosRepository;

    // Guardar o actualizar un repuesto
    public Repuestos saveOrUpdate(Repuestos repuesto) {
        return repuestosRepository.save(repuesto);
    }

    // Obtener todos los repuestos
    public List<Repuestos> getAllRepuestos() {
        return repuestosRepository.findAll();
    }

    // Buscar por ID
    public Optional<Repuestos> getRepuestoById(Long id) {
        return repuestosRepository.findById(id);
    }

    // Eliminar un repuesto
    public void deleteRepuesto(Long id) {
        repuestosRepository.deleteById(id);
    }

    // Repuestos con stock mayor a X (consulta nativa)
    public List<Repuestos> getRepuestosConStock(int stockMinimo) {
        return repuestosRepository.findRepuestosConStock(stockMinimo);
    }

    // Buscar por nombre
    public List<Repuestos> findByNombre(String nombre) {
        return repuestosRepository.findByNombreContaining(nombre);
    }
}