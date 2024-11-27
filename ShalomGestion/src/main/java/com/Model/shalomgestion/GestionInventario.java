/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Model.shalomgestion;

import java.time.LocalDate;

/**
 *
 * @author Carlos
 */
public class GestionInventario {
    private int id;
    private Producto producto;
    private Inventario inventario;
    private Destino destino;
    private int cantidad;
    private String descripcion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalidaMaxima;
    private int tiempoExcedente;
    private String estado; 
    
      // Constructor completo
    public GestionInventario(int id, Producto producto, Inventario inventario, Destino destino, int cantidad, String descripcion, LocalDate fechaEntrada, LocalDate fechaSalidaMaxima, int tiempoExcedente, String estado) {
        this.id = id;
        this.producto = producto;
        this.inventario = inventario;
        this.destino = destino;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalidaMaxima = fechaSalidaMaxima;
        this.tiempoExcedente = tiempoExcedente;
        this.estado = estado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalidaMaxima() {
        return fechaSalidaMaxima;
    }

    public void setFechaSalidaMaxima(LocalDate fechaSalidaMaxima) {
        this.fechaSalidaMaxima = fechaSalidaMaxima;
    }

    public int getTiempoExcedente() {
        return tiempoExcedente;
    }

    public void setTiempoExcedente(int tiempoExcedente) {
        this.tiempoExcedente = tiempoExcedente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
