/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Bean;

import br.com.ChameleonEJB.DAO.ClientePFDAO;
import br.com.ChameleonEJB.Model.ClientePF;
import br.com.ChameleonEJB.Remote.ClientePFRemote;
import javax.ejb.Stateless;

/**
 *
 * @author Gustavo Assalin
 */
@Stateless
public class ClientePFBean implements ClientePFRemote {

    @Override
    public ClientePF save(ClientePF clientePF) throws Exception {
        ClientePFDAO clientePFDAO = new ClientePFDAO();
        return clientePFDAO.save(clientePF);
    }

    @Override
    public ClientePF getById(Long id) {
        ClientePFDAO clientePFDAO = new ClientePFDAO();
        return clientePFDAO.getById(id);
    }
}
