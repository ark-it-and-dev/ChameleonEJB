/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.Endereco;

/**
 *
 * @author Gustavo Assalin
 */
public interface EnderecoRemote {
    public Endereco save(Endereco endereco) throws Exception;
    public Endereco getById(Long id);
}
