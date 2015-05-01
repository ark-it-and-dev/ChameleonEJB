package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Enum.StatusProduto;
import br.com.ChameleonEJB.Model.ClientePJ;
import br.com.ChameleonEJB.Remote.ClientePJRemote;
import javax.persistence.Query;

public class ClientePJDAO extends BaseDao<ClientePJ> implements ClientePJRemote {

    private Query query;

    public ClientePJ save(ClientePJ clientePJ) throws Exception {
        return save(clientePJ, clientePJ.getId());
    }

    @Override
    public ClientePJ getByEmail(String email) {
        query = entityManager.createNamedQuery("ClientePJ.getByEmail");
        query.setParameter(0, email);
        return (ClientePJ) query.getSingleResult();
    }

}
