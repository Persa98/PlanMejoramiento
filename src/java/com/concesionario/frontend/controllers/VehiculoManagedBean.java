/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controllers;

import com.concesionario.backend.persistence.entities.Vehiculo;
import com.concesionario.backend.persistence.facade.VehiculoFacadeLocal;
import com.concesionario.frontend.util.Managedbean;
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
public class VehiculoManagedBean implements Serializable, Managedbean <Vehiculo> {

    private Vehiculo vehiculo; 
    @EJB 
    private VehiculoFacadeLocal  vhfc;
    public VehiculoManagedBean() {
    }

    public Vehiculo getVehi() {
        return vehiculo;
    }

    public void setVehi(Vehiculo vehi) {
        this.vehiculo = vehi;
    }
    
    @PostConstruct
    public void init(){
        vehiculo = new Vehiculo();
    }
    
    public void registrarVehiculo(){
        vhfc.create(vehiculo);
    }
    
    public void eliminarVehiculo(Vehiculo vi){
        vhfc.remove(vi);
    }
    
    public String actualizarVehiculo(Vehiculo va){
        vehiculo = va;
        return "";
    }
    
    public void modificarVehiclo(){
        vhfc.edit(vehiculo);
    }
    
    public List<Vehiculo> listarVehiculo(){
        return vhfc.findAll();
    }
    
    @Override
    public Vehiculo getObeject(Integer i) {
       return vhfc.find(i);
    }
}

