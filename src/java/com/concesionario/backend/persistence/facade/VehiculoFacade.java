/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.backend.persistence.facade;

import com.concesionario.backend.persistence.entities.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Persa
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "PlanMejoramientoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }

    @Override
    public List<Vehiculo> PrecioMayor(int precio) {
        return em.createNamedQuery("Vehiculo.consultaPrecio").setParameter("precio", precio).getResultList();
    }

    @Override
    public List<Vehiculo> marcaReciente(int anio) {
        return em.createNamedQuery("Vehiculo.consultaReciente").setParameter("anio", anio).getResultList();
    }

    @Override
    public List<Vehiculo> PrecioMenor(int precio) {
        return em.createNamedQuery("Vehiculo.consultaPrecioEc").setParameter("precio", precio).getResultList();
    }
    
}
