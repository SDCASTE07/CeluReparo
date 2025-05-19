package com.example.CeluReparo.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "repuestos")
public class Repuestos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "cantidad_disponible")
    private int cantidadDisponible;

    private double precio;

    // Relaciones
    @OneToMany(mappedBy = "repuesto", cascade = CascadeType.ALL)
    private List<DetallesVenta> detallesVenta;

    @OneToMany(mappedBy = "repuesto")
    private List<RepuestoSoporte> repuestosSoporte;

    // Constructor
    public Repuestos() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public List<DetallesVenta> getDetallesVenta() { return detallesVenta; }
    public void setDetallesVenta(List<DetallesVenta> detallesVenta) { this.detallesVenta = detallesVenta; }
    public List<RepuestoSoporte> getRepuestosSoporte() { return repuestosSoporte; }
    public void setRepuestosSoporte(List<RepuestoSoporte> repuestosSoporte) { this.repuestosSoporte = repuestosSoporte; }
}