/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.frontend.controllers;

import com.concesionario.backend.persistence.entities.Cliente;
import com.concesionario.backend.persistence.facade.ClienteFacadeLocal;
import com.concesionario.frontend.util.Managedbean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Persa
 */
@Named(value = "clienteManagedBean")
@RequestScoped
public class ClienteManagedBean implements Serializable, Managedbean <Cliente> {

    private Cliente cliente;
    @EJB
    private ClienteFacadeLocal clfl;
    
    public ClienteManagedBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }
    
    public void registrarCliente(){
        clfl.create(cliente);
    }
    
    public void modificarCliente(){
        clfl.edit(cliente);
    }
    
    public void eliminarCliente(Cliente c){
        clfl.remove(cliente);
    }
    
    public String actualizarCliente(Cliente cl){
        cliente = cl;
        return "";
    }
    
    public List<Cliente> listarCliente(){
        return clfl.findAll();
    }

    @Override
    public Cliente getObeject(Integer i) {
        return clfl.find(i);
    }
    

}
