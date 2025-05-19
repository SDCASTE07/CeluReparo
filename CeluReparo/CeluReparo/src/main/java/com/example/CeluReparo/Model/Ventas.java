package com.example.CeluReparo.Model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_venta")
    private Date fechaVenta = new Date();

    @Column(name = "precio_venta_total")
    private double precioVentaTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Personas cliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Personas vendedor;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetallesVenta> detalles;

    // Constructor
    public Ventas() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Date getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(Date fechaVenta) { this.fechaVenta = fechaVenta; }
    public double getPrecioVentaTotal() { return precioVentaTotal; }
    public void setPrecioVentaTotal(double precioVentaTotal) { this.precioVentaTotal = precioVentaTotal; }
    public Personas getCliente() { return cliente; }
    public void setCliente(Personas cliente) { this.cliente = cliente; }
    public Personas getVendedor() { return vendedor; }
    public void setVendedor(Personas vendedor) { this.vendedor = vendedor; }
    public List<DetallesVenta> getDetalles() { return detalles; }
    public void setDetalles(List<DetallesVenta> detalles) { this.detalles = detalles; }
}
