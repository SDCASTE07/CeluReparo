package com.example.CeluReparo.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "celulares")
public class Celulares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private int precio;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro = LocalDate.now();

    // Relación con DetallesVenta
    @OneToMany(mappedBy = "celular", cascade = CascadeType.ALL)
    private List<DetallesVenta> detallesVenta;

    // Enumerado
    public enum Estado {
        NUEVO, USADO, REPARADO
    }

    // Constructor
    public Celulares() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public List<DetallesVenta> getDetallesVenta() { return detallesVenta; }
    public void setDetallesVenta(List<DetallesVenta> detallesVenta) { this.detallesVenta = detallesVenta; }
}
