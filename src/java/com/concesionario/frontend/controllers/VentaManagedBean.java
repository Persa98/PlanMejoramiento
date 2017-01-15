/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controllers;

import com.concesionario.backend.persistence.entities.Venta;
import com.concesionario.backend.persistence.facade.VentaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Persa
 */
@Named(value = "ventaManagedBean")
@SessionScoped
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
    public void init(){
        venta = new Venta();
    }
    
    public void registrarVenta(){
        vefl.create(venta);
    }
    
    public List<Venta> listarVenta(){
        return vefl.findAll();
    }
}
