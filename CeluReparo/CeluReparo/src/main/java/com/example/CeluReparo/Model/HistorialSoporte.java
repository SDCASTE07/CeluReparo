package com.example.CeluReparo.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historial_soporte")
public class HistorialSoporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "soporte_id", nullable = false)
    private Soportes soporte;

    private String estado;
    private String observacion;

    @Column(name = "fecha_registro")
    private Date fechaRegistro = new Date();

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Personas tecnico;

    // Constructor
    public HistorialSoporte() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Soportes getSoporte() { return soporte; }
    public void setSoporte(Soportes soporte) { this.soporte = soporte; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public Personas getTecnico() { return tecnico; }
    public void setTecnico(Personas tecnico) { this.tecnico = tecnico; }
}