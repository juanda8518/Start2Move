/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.ejb;

import com.davido.entities.DbbusStop;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author davidortega
 */
@Stateless
public class DbbusStopFacade extends AbstractFacade<DbbusStop> implements DbbusStopFacadeLocal {

    @PersistenceContext(unitName = "com.davido_Start2Move-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DbbusStopFacade() {
        super(DbbusStop.class);
    }
    
}
