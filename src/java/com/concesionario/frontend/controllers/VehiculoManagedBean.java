/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controllers;

import com.concesionario.backend.persistence.entities.Vehiculo;
import com.concesionario.backend.persistence.facade.VehiculoFacadeLocal;
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
@Named(value = "vehiculoManagedBean")
@SessionScoped
public class VehiculoManagedBean implements Serializable {

    /**
     * Creates a new instance of VehiculoManagedBean
     */
    private Vehiculo vehi; 
    @EJB 
    private VehiculoFacadeLocal  vhfc;
    public VehiculoManagedBean() {
    }

    public Vehiculo getVehi() {
        return vehi;
    }

    public void setVehi(Vehiculo vehi) {
        this.vehi = vehi;
    }
    
    @PostConstruct
    public void init(){
        vehi = new Vehiculo();
    }
    
    public void registrarVehiculo(){
        vhfc.create(vehi);
    }
    
    public void eliminarVehiculo(Vehiculo vi){
        vhfc.remove(vi);
    }
    
    public void actualizarVehiculo(Vehiculo va){
        vehi = vehi;
    }
    
    public void modificarVehiclo(){
        vhfc.edit(vehi);
    }
    
    public List<Vehiculo> listarVehiculo(){
        return vhfc.findAll();
    }
}

