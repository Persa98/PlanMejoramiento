/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.converters;

import com.concesionario.backend.persistence.entities.Cliente;
import com.concesionario.frontend.util.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Persa
 */
@FacesConverter(forClass = Cliente.class)
public class ClienteConverter extends AbstractConverter{
    
    public ClienteConverter(){
        this.nombreMB = "clienteManagedBean";
    }
}
