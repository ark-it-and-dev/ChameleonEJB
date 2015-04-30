/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.ClientePF;
import javax.ejb.Remote;

/**
 *
 * @author Gustavo Assalin
 */
@Remote
public interface ClientePFRemote {
    public ClientePF save(ClientePF clientePF) throws Exception;
    public ClientePF getById(Long id);
}
