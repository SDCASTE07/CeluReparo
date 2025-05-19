package com.example.CeluReparo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalles_venta")
public class DetallesVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venta_id", nullable = false)
    private Ventas venta;

    @Column(name = "tipo_producto")
    private String tipoProducto; // "CELULAR" o "REPUESTO"

    @Column(name = "producto_id")
    private Long productoId;

    private int cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    private double subtotal;

    // Relaciones opcionales
    @ManyToOne
    @JoinColumn(name = "celular_id")
    private Celulares celular;

    @ManyToOne
    @JoinColumn(name = "repuesto_id")
    private Repuestos repuesto;

    // Constructor
    public DetallesVenta() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Ventas getVenta() { return venta; }
    public void setVenta(Ventas venta) { this.venta = venta; }
    public String getTipoProducto() { return tipoProducto; }
    public void setTipoProducto(String tipoProducto) { this.tipoProducto = tipoProducto; }
    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public Celulares getCelular() { return celular; }
    public void setCelular(Celulares celular) { this.celular = celular; }
    public Repuestos getRepuesto() { return repuesto; }
    public void setRepuesto(Repuestos repuesto) { this.repuesto = repuesto; }
}