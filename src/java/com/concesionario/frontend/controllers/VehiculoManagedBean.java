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

    private Vehiculo veh; 
    @EJB 
    private VehiculoFacadeLocal  vhfl;
    private int precio;
    private int precioe;
    private List<Vehiculo> reco;
    private int anio;
    
    public VehiculoManagedBean() {
    }

    public Vehiculo getVeh() {
        return veh;
    }

    public void setVeh(Vehiculo veh) {
        this.veh = veh;
    }

    public List<Vehiculo> getReco() {
        return reco;
    }

    public void setReco(List<Vehiculo> reco) {
        this.reco = reco;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    
    @PostConstruct
    public void init(){
        veh = new Vehiculo();
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
    
    public void consultarReciente(){
        reco = vhfl.marcaReciente(anio);
    }
    
    @Override
    public Vehiculo getObeject(Integer i) {
       return vhfl.find(i);
    }
    
    public void precioSuministrado(){
        reco = vhfl.PrecioMayor(precio);
    }
    
    public void precioEconomico(){
        reco = vhfl.PrecioMenor(precioe);
    }
    
    
}

