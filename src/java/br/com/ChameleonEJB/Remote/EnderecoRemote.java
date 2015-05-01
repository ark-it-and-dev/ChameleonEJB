/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.Cliente;
import br.com.ChameleonEJB.Model.Endereco;
import java.util.List;

/**
 *
 * @author Gustavo Assalin
 */
public interface EnderecoRemote {
    public Endereco save(Endereco endereco) throws Exception;
    public Endereco getById(Long id);
    public List<Endereco> all();
    public List<Endereco> allWhereCEPEquals(String cep);
    public List<Endereco> allWherePatioLike(String logradouro);
    public List<Cliente> allCostumersOrderById();
    public List<Cliente> allWhereCostumersId(Long id);
}
