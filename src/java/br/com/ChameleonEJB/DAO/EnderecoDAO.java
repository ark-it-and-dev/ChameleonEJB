/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Model.Endereco;

/**
 *
 * @author Gustavo Assalin
 */
public class EnderecoDAO extends MasterDAO {

    public EnderecoDAO() {
        entityManager = getEntityManager();
    }
    
    public Endereco save(Endereco endereco) throws Exception {
        if(endereco.getId() == null) {
            entityManager.persist(endereco);
        } else {
            if(!entityManager.contains(endereco)) {
                if(entityManager.find(Endereco.class, endereco.getId()) == null) {
                    throw new Exception("Erro ao atualizar os dados do endereço!");
                }
            }
            endereco = entityManager.merge(endereco);
        }
        
        return endereco;
    }
    
    public Endereco getById(Long id) {
        return entityManager.find(Endereco.class, id);
    }
}
