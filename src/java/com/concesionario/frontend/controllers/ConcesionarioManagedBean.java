/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controllers;

import com.concesionario.backend.persistence.entities.Concesionario;
import com.concesionario.backend.persistence.facade.ConcesionarioFacadeLocal;
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
@Named(value = "concesionarioManagedBean")
@SessionScoped
public class ConcesionarioManagedBean implements Serializable, Managedbean <Concesionario> {

    private Concesionario conces;
    @EJB
    private ConcesionarioFacadeLocal cofl;
    
    public ConcesionarioManagedBean() {
    }

    public Concesionario getConces() {
        return conces;
    }

    public void setConces(Concesionario conces) {
        this.conces = conces;
    }
    
    @PostConstruct
    public void init(){
        conces = new Concesionario();
    }
    
    public void registrarConcesionario(){
        cofl.create(conces);
    }
    
    public void modificarConcesionario(){
        cofl.edit(conces);
    }
    
    public void eliminarConcesionario(Concesionario c){
        cofl.remove(conces);
    }
    
    public List<Concesionario> listarConcesionario(){
        return cofl.findAll();
    }
    
    public String actualizarConcesionario(Concesionario co){
        conces = co;
        return "/pages/editar";
    }

    @Override
    public Concesionario getObeject(Integer i) {
        return cofl.find(i);
    }
    
}
