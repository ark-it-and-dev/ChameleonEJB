package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Model.ClientePF;
import br.com.ChameleonEJB.Remote.ClientePFRemote;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ClientePFDAO extends BaseDao<ClientePF> implements ClientePFRemote {

    private Query query;

    public ClientePF save(ClientePF clientePF) throws Exception {
        return save(clientePF, clientePF.getId());
    }

    @Override
    public ClientePF getByEmail(String email) {
        query = entityManager.createNamedQuery("ClientePJ.getByEmail");
        query.setParameter(0, email);
        return (ClientePF) query.getSingleResult();
    }
}
