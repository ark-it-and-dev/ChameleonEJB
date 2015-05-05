package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Model.Cliente;
import br.com.ChameleonEJB.Remote.ClienteRemote;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ClienteDAO extends BaseDao<Cliente> implements ClienteRemote {

    private Query query;

    @Override
    public Cliente save(Cliente cliente) throws Exception {
        return save(cliente, cliente.getId());
    }

    @Override
    public Cliente getByEmail(String email) {
        query = entityManager.createNamedQuery("Cliente.getByEmail");
        query.setParameter(0, email);
        return (Cliente) query.getSingleResult();
    }
}
