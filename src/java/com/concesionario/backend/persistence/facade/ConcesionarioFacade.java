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
import javax.persistence.TypedQuery;

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

    @Override
    public Concesionario iniciarSesion(Concesionario co) throws Exception {
        Concesionario concesionario = null;
        TypedQuery<Concesionario> query;
        try{
            query = em.createQuery("FROM Concesionario c WHERE c.correo = ?1 and c.contraseña = ?2", Concesionario.class);
            query.setParameter(1, co.getCorreo());
            query.setParameter(2, co.getContraseña());
            if(!query.getResultList().isEmpty()){
                concesionario = query.getResultList().get(0);
            }
        }catch (Exception e){
            throw e;
        }
        return concesionario;
    }
    
}
