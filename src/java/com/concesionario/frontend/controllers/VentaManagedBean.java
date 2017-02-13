/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controllers;

import com.concesionario.backend.persistence.entities.Venta;
import com.concesionario.backend.persistence.facade.VentaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Persa
 */
@Named(value = "ventaManagedBean")
@RequestScoped
public class VentaManagedBean implements Serializable {

    private Venta venta;
    @EJB
    private VentaFacadeLocal vefl;

    public VentaManagedBean() {
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @PostConstruct
    public void init() {
        venta = new Venta();
    }

    public void registrarVenta() {
        venta.setFecha(new Date());
        vefl.create(venta);
    }

    public List<Venta> listarVenta() {
        return vefl.findAll();
    }

    public String masVendido() {
        String v = null;
        String a = null;
        try {
            for (Venta m : listarVenta()) {
                v = v + " " + m.getIdVehiculo().getMarca();
            }
            a = masRepetida(v);
            return a;
        } catch (Exception e) {
            return a;
        }
    }

    public String masRepetida(String vehiculos) {
        String palabras[] = vehiculos.split(" ");
        String palabrasA[] = vehiculos.split(" ");

        int cantidad = palabras.length;
        String resultado = "";
        int contadorMasRespe = 0;

        for (int i = 0; i < cantidad; i++) {
            int contador = 0;
            String palabra = palabras[i];

            for (int j = 0; j < cantidad; j++) {
                if (palabra.equalsIgnoreCase(palabrasA[j])) {
                    contador++;
                    palabras[j] = "";
                }
            }
            if ((contador > 1) && (contador > contadorMasRespe)) {
                resultado = palabra;
                contadorMasRespe = contador;
                System.out.print(palabras[i]);
            } else if ((contador > 1) && (contador == contadorMasRespe)) {
                resultado += " " + palabra;
            }
        }
        if (resultado == "") {
            resultado = " Solo se encuantre una venta ";
        }
        return resultado;
    }
}
