/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controllers;

import com.concesionario.backend.persistence.entities.Cliente;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Persa
 */
@Named(value = "seguridadController")
@ViewScoped
public class SeguridadController implements Serializable{
        
        public void verificarSesion() throws Exception{
            try{
                FacesContext context = FacesContext.getCurrentInstance();
                Cliente cl = (Cliente) context.getExternalContext().getSessionMap().get("cliente");
                if (cl == null){
                    context.getExternalContext().redirect("../permisos.xhtml");
                }
            }catch (Exception e){
                throw e;
            }
        }
    
    
}
