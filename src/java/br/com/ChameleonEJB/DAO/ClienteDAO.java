package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Model.Cliente;
import br.com.ChameleonEJB.Remote.ClienteRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClienteDAO implements ClienteRemote {

    @Override
    public Cliente getByEmail(String email) {
        Cliente cliente = null;

        try {
            cliente = (Cliente) em.createNamedQuery("Cliente.getByEmail")
                    .setParameter("mail", email)
                    .getSingleResult();
        } catch (Exception e) {
        }
        return cliente;
    }

    @PersistenceContext(unitName = "ChameleonEJB_PU")
    protected EntityManager em;

    @Override
    public Cliente save(Long id) throws Exception {
        Cliente cliente = null;
        if (id == null) {
            em.persist(cliente);
        } else {
            if (!em.contains(cliente)) {
                if (getById(id) == null) {
                    throw new Exception("Erro ao atualizar os dados!");
                }
            }
            cliente = em.merge(cliente);
        }
        return cliente;
    }

    @Override
    public Cliente getById(Long id) {
        return em.find(Cliente.class, id);
    }
}
