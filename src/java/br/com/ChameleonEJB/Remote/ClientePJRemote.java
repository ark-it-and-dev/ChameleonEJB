/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.ClientePJ;
import javax.ejb.Remote;

/**
 *
 * @author Gustavo Assalin
 */
@Remote
public interface ClientePJRemote {
    public ClientePJ save(ClientePJ clientePJ) throws Exception;
    public ClientePJ getById(Long id);
}
