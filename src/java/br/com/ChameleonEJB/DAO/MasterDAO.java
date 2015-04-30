/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gustavo Assalin
 */
public class MasterDAO {
    @PersistenceContext(unitName = "ChameleonEJB_PU")
    protected EntityManager entityManager;

    protected EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        
        try {
            factory = Persistence.createEntityManagerFactory("ChameleonEJB_PU");
            entityManager = factory.createEntityManager();
        } finally {
            factory.close();
        }
        return entityManager;
    }
    
    protected void activate(Long id) {
    }
    
    protected void desactivate(Long id) {
    }
}
