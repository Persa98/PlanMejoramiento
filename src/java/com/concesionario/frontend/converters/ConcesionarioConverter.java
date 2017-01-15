/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.converters;

import com.concesionario.backend.persistence.entities.Concesionario;
import com.concesionario.frontend.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Persa
 */
@FacesConverter(forClass = Concesionario.class)
public class ConcesionarioConverter extends AbstractConverter{

    public ConcesionarioConverter() {
        this.nombreMB = "concesionarioManagedBean";
    }
    
    
}
