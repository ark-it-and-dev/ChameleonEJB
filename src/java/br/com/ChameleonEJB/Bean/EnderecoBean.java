/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Bean;

import br.com.ChameleonEJB.DAO.EnderecoDAO;
import br.com.ChameleonEJB.Model.Cliente;
import br.com.ChameleonEJB.Model.Endereco;
import br.com.ChameleonEJB.Remote.EnderecoRemote;
import java.util.List;

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

    @Override
    public List<Endereco> all() {
        return enderecoDAO.all();
    }
    
    @Override
    public List<Endereco> allWhereCEPEquals(String cep) {
        return enderecoDAO.allWhereCEPEquals(cep);
    }

    @Override
    public List<Endereco> allWherePatioLike(String logradouro) {
        return enderecoDAO.allWherePatioLike(logradouro);
    }

    @Override
    public List<Cliente> allCostumersOrderById() {
        return enderecoDAO.allCostumersOrderById();
    }
}
