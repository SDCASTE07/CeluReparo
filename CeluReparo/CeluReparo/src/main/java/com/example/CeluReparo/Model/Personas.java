package com.example.CeluReparo.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "personas")
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "num_documento", unique = true)
    private String numDocumento;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "apellido_1")
    private String apellido1;

    @Column(name = "apellido_2")
    private String apellido2;

    private String telefono;
    private String email;
    private String direccion;

    @Enumerated(EnumType.STRING)
    private Rol rol; // CLIENTE, TECNICO, VENDEDOR

    // Relaciones
    @OneToMany(mappedBy = "cliente")
    private List<Ventas> ventas;

    @OneToMany(mappedBy = "tecnico")
    private List<Soportes> soportesAsignados;

    // Enumerado
    public enum Rol { CLIENTE, TECNICO, VENDEDOR }

    // Constructor
    public Personas() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    public String getNumDocumento() { return numDocumento; }
    public void setNumDocumento(String numDocumento) { this.numDocumento = numDocumento; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido1() { return apellido1; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }
    public String getApellido2() { return apellido2; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
    public List<Ventas> getVentas() { return ventas; }
    public void setVentas(List<Ventas> ventas) { this.ventas = ventas; }
    public List<Soportes> getSoportesAsignados() { return soportesAsignados; }
    public void setSoportesAsignados(List<Soportes> soportesAsignados) { this.soportesAsignados = soportesAsignados; }
}