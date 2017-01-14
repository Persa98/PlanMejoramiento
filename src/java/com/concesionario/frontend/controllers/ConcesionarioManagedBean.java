/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Persa
 */
@Named(value = "concesionarioManagedBean")
@SessionScoped
public class ConcesionarioManagedBean implements Serializable {

    /**
     * Creates a new instance of ConcesionarioManagedBean
     */
    public ConcesionarioManagedBean() {
    }
    
}
