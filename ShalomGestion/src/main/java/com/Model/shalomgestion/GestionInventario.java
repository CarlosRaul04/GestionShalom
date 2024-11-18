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
    private int idProducto;
    private int idInventario;
    private int idDestino;
    private int cantidad;
    private String descripcion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalidaMaxima;
    private int tiempoExcedente;
    private String estado; 
    
      // Constructor completo
    public GestionInventario(int id, int idProducto, int idInventario, int idDestino, int cantidad, String descripcion, LocalDate fechaEntrada, LocalDate fechaSalidaMaxima, int tiempoExcedente, String estado) {
        this.id = id;
        this.idProducto = idProducto;
        this.idInventario = idInventario;
        this.idDestino = idDestino;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalidaMaxima = fechaSalidaMaxima;
        this.tiempoExcedente = tiempoExcedente;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
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
