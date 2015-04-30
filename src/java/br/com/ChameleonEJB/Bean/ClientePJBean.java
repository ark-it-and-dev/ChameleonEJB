/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Bean;

import br.com.ChameleonEJB.DAO.ClientePJDAO;
import br.com.ChameleonEJB.Model.ClientePJ;
import br.com.ChameleonEJB.Remote.ClientePJRemote;
import javax.ejb.Stateless;

/**
 *
 * @author Gustavo Assalin
 */
@Stateless
public class ClientePJBean implements ClientePJRemote {
    
    @Override
    public ClientePJ save(ClientePJ clientePJ) throws Exception {
        ClientePJDAO clientePJDAO = new ClientePJDAO();
        return clientePJDAO.save(clientePJ);
    }

    @Override
    public ClientePJ getById(Long id) {
        ClientePJDAO clientePJDAO = new ClientePJDAO();
        return clientePJDAO.getById(id);
    }
}
