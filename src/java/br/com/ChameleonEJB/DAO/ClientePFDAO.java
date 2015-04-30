/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Model.ClientePF;

/**
 *
 * @author Gustavo Assalin
 */
public class ClientePFDAO extends MasterDAO {

    public ClientePFDAO() {
        entityManager = getEntityManager();
    }
    
    public ClientePF save(ClientePF clientePF) throws Exception {
        if(clientePF.getId() == null) {
            entityManager.persist(clientePF);
        } else {
            if(!entityManager.contains(clientePF)) {
                if(entityManager.find(ClientePF.class, clientePF.getId()) == null) {
                    throw new Exception("Erro ao atualizar os dados do cliente pf!");
                }
            }
            clientePF = entityManager.merge(clientePF);
        }
        
        return clientePF;
    }
    
    public ClientePF getById(Long id) {
        return entityManager.find(ClientePF.class, id);
    }
}
