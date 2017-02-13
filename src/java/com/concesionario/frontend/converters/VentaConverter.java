/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.converters;

import com.concesionario.backend.persistence.entities.Venta;
import com.concesionario.frontend.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Persa
 */
@FacesConverter(forClass = Venta.class)
public class VentaConverter extends AbstractConverter{
    
    public VentaConverter(){
        this.nombreMB = "ventaManagedBean";
    }
    
}
