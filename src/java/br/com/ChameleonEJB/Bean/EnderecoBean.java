/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Bean;

import br.com.ChameleonEJB.DAO.EnderecoDAO;
import br.com.ChameleonEJB.Model.Endereco;
import br.com.ChameleonEJB.Remote.EnderecoRemote;

/**
 *
 * @author Gustavo Assalin
 */
public class EnderecoBean implements EnderecoRemote {

    private final EnderecoDAO enderecoDAO = new EnderecoDAO();
    
    @Override
    public Endereco save(Endereco endereco) throws Exception {
        return enderecoDAO.save(endereco);
    }

    @Override
    public Endereco getById(Long id) {
        return enderecoDAO.getById(id);
    }
    
}
