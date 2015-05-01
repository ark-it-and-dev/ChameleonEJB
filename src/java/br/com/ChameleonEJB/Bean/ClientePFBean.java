package br.com.ChameleonEJB.Bean;

import br.com.ChameleonEJB.DAO.ClientePFDAO;
import br.com.ChameleonEJB.Model.ClientePF;
import javax.ejb.Stateless;

@Stateless
public class ClientePFBean extends ClientePFDAO {

    public ClientePF save(ClientePF clientePF) throws Exception {
        return save(clientePF);
    }

    public ClientePF getById(Long id) {
        return getById(id);
    }
}
