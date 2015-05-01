package br.com.ChameleonEJB.Bean;

import br.com.ChameleonEJB.DAO.ClientePJDAO;
import br.com.ChameleonEJB.Model.ClientePJ;
import javax.ejb.Stateless;

@Stateless
public class ClientePJBean extends ClientePJDAO {

    public ClientePJ save(ClientePJ clientePJ) throws Exception {
        return save(clientePJ);
    }

    public ClientePJ getById(Long id) {
        return getById(id);
    }
}
