/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concesionario.backend.persistence.facade;

import com.concesionario.backend.persistence.entities.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Persa
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "PlanMejoramientoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public Cliente iniciarSesion(Cliente cl) throws Exception{
        Cliente cliente = null;
        TypedQuery<Cliente> query;
        try{
            query = em.createQuery("FROM Cliente c WHERE c.correo = ?1 and c.password = ?2", Cliente.class );
            query.setParameter(1, cl.getCorreo());
            query.setParameter(2, cl.getPassword());
            if(!query.getResultList().isEmpty()){
                cliente = query.getResultList().get(0);
            }
        }catch(Exception e){
            throw e;
        }
        return cliente;
    }
}
