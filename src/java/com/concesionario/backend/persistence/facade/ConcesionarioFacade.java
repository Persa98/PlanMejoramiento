/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.backend.persistence.facade;

import com.concesionario.backend.persistence.entities.Concesionario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Persa
 */
@Stateless
public class ConcesionarioFacade extends AbstractFacade<Concesionario> implements ConcesionarioFacadeLocal {

    @PersistenceContext(unitName = "PlanMejoramientoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConcesionarioFacade() {
        super(Concesionario.class);
    }
    
}
