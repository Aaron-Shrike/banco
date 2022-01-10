/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa_logica;

import java.util.Date;

/**
 *
 * @author Sh
 */
public class Cuenta {
    private String numeroCuenta;
    private Date fechaApertura;
    private double montoInicial;
    private Moneda tipoMoneda;
    private Estado tipoEstado;
    private String dniCliente;

    public Cuenta() {
        numeroCuenta = "";
        fechaApertura = null;
        montoInicial = 0.0;
        tipoMoneda = null;
        tipoEstado =Estado.ABIERTA ;
        dniCliente = "";
    }

    public Cuenta(String numeroCuenta, Date fechaApertura, double montoInicial, Moneda tipoMoneda, Estado tipoEstado, String dniCliente) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.montoInicial = montoInicial;
        this.tipoMoneda = tipoMoneda;
        this.tipoEstado = tipoEstado;
        this.dniCliente = dniCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public Moneda getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(Moneda tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public Estado getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(Estado tipoEstado) {
        this.tipoEstado = tipoEstado;
    }
    
    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }
    
}
