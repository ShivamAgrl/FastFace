/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ffast.ejb;

import com.ffast.data.Ffast;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shiagaga
 */
@Stateless(mappedName="ffastEE/ejb/ffast")
public class Fbean implements FbeanLocal{
   
        
    @PersistenceContext(unitName="FFastEE-ejbPU")
    private EntityManager manager;

    @Override
    public boolean addUser(Ffast f) {
             manager.persist(f);
             return true;    
    }

    @Override
    public boolean updateUser(Ffast f) {
         manager.merge(f);
            return true;
    }
}
