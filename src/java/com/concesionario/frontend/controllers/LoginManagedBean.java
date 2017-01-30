/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controllers;

import com.concesionario.backend.persistence.entities.Concesionario;
import com.concesionario.backend.persistence.facade.ClienteFacadeLocal;
import com.concesionario.backend.persistence.facade.ConcesionarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Persa
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    private Concesionario concesionario;
    @EJB
    private ConcesionarioFacadeLocal cofl;
    
    public LoginManagedBean() {
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }
    
    @PostConstruct
    public void init(){
        concesionario = new Concesionario();
    }
    
    public String iniciarSesion(Concesionario co){
        String redi = null;
        try {
            if(cofl.iniciarSesion(concesionario)!=null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("concesionario", concesionario);
                redi = "/pages/inicio?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso ", "Credenciales incorrectas."));
            }
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!" ));
        }
        return redi;
    }
    
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
