package com.example.CeluReparo.Model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "soportes")
public class Soportes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Personas cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Personas tecnico;

    @ManyToOne
    @JoinColumn(name = "celular_id", nullable = false)
    private Celulares celular;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "fecha_solicitud")
    private Date fechaSolicitud = new Date();

    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;

    private double costo;

    // Relaciones
    @OneToMany(mappedBy = "soporte", cascade = CascadeType.ALL)
    private List<HistorialSoporte> historiales;

    @OneToMany(mappedBy = "soporte")
    private List<RepuestoSoporte> repuestosUtilizados;

    // Enumerado
    public enum Estado {
        PENDIENTE, EN_PROCESO, FINALIZADO
    }

    // Constructor
    public Soportes() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Personas getCliente() { return cliente; }
    public void setCliente(Personas cliente) { this.cliente = cliente; }
    public Personas getTecnico() { return tecnico; }
    public void setTecnico(Personas tecnico) { this.tecnico = tecnico; }
    public Celulares getCelular() { return celular; }
    public void setCelular(Celulares celular) { this.celular = celular; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public Date getFechaSolicitud() { return fechaSolicitud; }
    public void setFechaSolicitud(Date fechaSolicitud) { this.fechaSolicitud = fechaSolicitud; }
    public Date getFechaFinalizacion() { return fechaFinalizacion; }
    public void setFechaFinalizacion(Date fechaFinalizacion) { this.fechaFinalizacion = fechaFinalizacion; }
    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
    public List<HistorialSoporte> getHistoriales() { return historiales; }
    public void setHistoriales(List<HistorialSoporte> historiales) { this.historiales = historiales; }
    public List<RepuestoSoporte> getRepuestosUtilizados() { return repuestosUtilizados; }
    public void setRepuestosUtilizados(List<RepuestoSoporte> repuestosUtilizados) { this.repuestosUtilizados = repuestosUtilizados; }
}