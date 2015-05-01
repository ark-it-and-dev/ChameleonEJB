package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Model.Cliente;
import br.com.ChameleonEJB.Model.Endereco;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Gustavo Assalin
 */
public class EnderecoDAO extends MasterDAO {

    private Query query;

    public EnderecoDAO() {
        entityManager = getEntityManager();
    }

    public Endereco save(Endereco endereco) throws Exception {
        if (endereco.getId() == null) {
            entityManager.persist(endereco);
        } else {
            if (!entityManager.contains(endereco)) {
                if (entityManager.find(Endereco.class, endereco.getId()) == null) {
                    throw new Exception("Erro ao atualizar os dados do endereço!");
                }
            }
            endereco = entityManager.merge(endereco);
        }

        return endereco;
    }

    public Endereco getById(Long id) {
        return entityManager.find(Endereco.class, id);
    }

    public List<Endereco> all() {
        query = entityManager.createNamedQuery("Endereco.All");
        return query.getResultList();
    }

    public List<Endereco> allWhereCEPEquals(String cep) {
        query = entityManager.createNamedQuery("Endereco.AllWhereCEPEquals");
        query.setParameter(0, cep);
        return query.getResultList();
    }

    public List<Endereco> allWherePatioLike(String logradouro) {
        query = entityManager.createNamedQuery("Endereco.AllWherePatioLike");
        query.setParameter(0, logradouro);
        return query.getResultList();
    }

    public List<Cliente> allCostumersOrderById() {
        query = entityManager.createNamedQuery("Endereco.AllCostumersOrderById");
        return query.getResultList();
    }

    public List<Cliente> allWhereCostumersId(Long id) {
        query = entityManager.createNamedQuery("Endereco.AllWhereCostumersId");
        query.setParameter(0, id);
        return query.getResultList();
    }
}
