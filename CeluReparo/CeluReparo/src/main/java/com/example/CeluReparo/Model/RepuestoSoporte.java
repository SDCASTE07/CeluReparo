package com.example.CeluReparo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "repuestos_soporte")
public class RepuestoSoporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "soporte_id", nullable = false)
    private Soportes soporte;  // Relación con el soporte técnico

    @ManyToOne
    @JoinColumn(name = "repuesto_id", nullable = false)
    private Repuestos repuesto;  // Relación con el repuesto utilizado

    private int cantidad;  // Cantidad del repuesto usada en el soporte

    // Constructor
    public RepuestoSoporte() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Soportes getSoporte() { return soporte; }
    public void setSoporte(Soportes soporte) { this.soporte = soporte; }
    public Repuestos getRepuesto() { return repuesto; }
    public void setRepuesto(Repuestos repuesto) { this.repuesto = repuesto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
