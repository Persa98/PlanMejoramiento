/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.util;

import com.concesionario.backend.persistence.entities.IEntitie;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Persa
 */
public abstract class AbstractConverter implements Converter{
    
    protected String noMB;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value){
        try{
            Integer i = Integer.valueOf(value);
            Managedbean d = (Managedbean) context.getApplication().getELResolver().getValue(context.getELContext(), null, noMB);
            return d.getObeject(i);
        } catch (NumberFormatException e){
            context.addMessage(null, new FacesMessage("Error al comvertir el objeto"));
            return null;
        }
    }
    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value){
        try{
            if (value instanceof IEntitie){
                IEntitie estil = (IEntitie) value;
                return estil.getId();
            }else{
                return null;
            }
        } catch (Exception e){
            return ""+e.getMessage();
        }
    }
}
