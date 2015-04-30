/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Model.ClientePJ;

/**
 *
 * @author Gustavo Assalin
 */
public class ClientePJDAO extends MasterDAO {
    
    public ClientePJDAO() {
        entityManager = getEntityManager();
    }
    
    public ClientePJ save(ClientePJ clientePJ) throws Exception {
        if(clientePJ.getId() == null) {
            entityManager.persist(clientePJ);
        } else {
            if(!entityManager.contains(clientePJ)) {
                if(entityManager.find(ClientePJ.class, clientePJ.getId()) == null) {
                    throw new Exception("Erro ao atualizar os dados do cliente pj");
                }
            }
            clientePJ = entityManager.merge(clientePJ);
        }
        
        return clientePJ;
    }
    
    public ClientePJ getById(Long id) {
        return entityManager.find(ClientePJ.class, id);
    }
}
