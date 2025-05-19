package com.example.CeluReparo.Service;

import com.example.CeluReparo.Model.DetallesVenta;
import com.example.CeluReparo.Repository.DetallesVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetallesVentaService {

    @Autowired
    private DetallesVentaRepository detallesVentaRepository;

    // Guardar un detalle de venta
    public DetallesVenta save(DetallesVenta detalle) {
        return detallesVentaRepository.save(detalle);
    }

    // Obtener todos los detalles
    public List<DetallesVenta> getAllDetalles() {
        return detallesVentaRepository.findAll();
    }

    // Buscar por ID
    public Optional<DetallesVenta> getDetalleById(Long id) {
        return detallesVentaRepository.findById(id);
    }
}
