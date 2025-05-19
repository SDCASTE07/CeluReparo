package com.example.CeluReparo.Service;

import com.example.CeluReparo.Model.Ventas;
import com.example.CeluReparo.Repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    // Guardar o actualizar una venta
    @Transactional
    public Ventas saveOrUpdate(Ventas venta) {
        // Lógica para calcular total (si es necesario)
        return ventasRepository.save(venta);
    }

    // Obtener todas las ventas
    public List<Ventas> getAllVentas() {
        return ventasRepository.findAll();
    }

    // Buscar por ID
    public Optional<Ventas> getVentaById(Long id) {
        return ventasRepository.findById(id);
    }

    // Eliminar una venta
    public void deleteVenta(Long id) {
        ventasRepository.deleteById(id);
    }

    // Ventas en un rango de fechas (consulta nativa)
    public List<Ventas> getVentasPorFecha(String fechaInicio, String fechaFin) {
        return ventasRepository.findVentasPorFecha(fechaInicio, fechaFin);
    }

    // Ventas de un cliente
    public List<Ventas> getVentasByClienteId(Integer clienteId) {
        return ventasRepository.findByClienteId(clienteId);
    }
}