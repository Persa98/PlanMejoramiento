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
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author Persa
 */
@Named(value = "vehiculoManagedBean")
@RequestScoped
public class VehiculoManagedBean implements Serializable, Managedbean<Vehiculo> {

    private Vehiculo veh;
    @EJB 
    private VehiculoFacadeLocal  vhfl;
    
    public VehiculoManagedBean() {
    }

    @PostConstruct
    public void init(){
        veh = new Vehiculo();
    }
    
    public Vehiculo getVeh() {
        return veh;
    }

    public void setVeh(Vehiculo veh) {
        this.veh = veh;
    }
    
    public void registrarVehiculo(){
        vhfl.create(veh);
    }
    
    public void eliminarVehiculo(Vehiculo vi){
        vhfl.remove(vi);
    }
    
    public String actualizarVehiculo(Vehiculo va){
        veh = va;
        return "/pages/vehiculo";
    }
    
    public void modificarVehiclo(){
        vhfl.edit(veh);
    }
    
    public List<Vehiculo> listarVehiculo(){
        return vhfl.findAll();
    }
    
    @Override
    public Vehiculo getObeject(Integer i) {
       return vhfl.find(i);
    }
    
  
    public Vehiculo masReciente(){
        int m = 0;
        try{
            
            for(Vehiculo v: listarVehiculo()){
                if(v.getAnio()> m){
                    m = v.getAnio();
                    veh = v;
                }
            }
        }catch(Exception e){    
        } 
        return  veh;
    }
    
}
