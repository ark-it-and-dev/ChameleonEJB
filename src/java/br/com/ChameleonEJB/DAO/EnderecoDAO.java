package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Model.Endereco;
import br.com.ChameleonEJB.Remote.EnderecoRemote;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class EnderecoDAO extends BaseDao<Endereco> implements EnderecoRemote {

    private Query query;

    @Override
    public Endereco save(Endereco endereco) throws Exception {
        return save(endereco, endereco.getId());
    }

    @Override
    public List<Endereco> all() {
        query = entityManager.createNamedQuery("Endereco.All");
        return query.getResultList();
    }

    @Override
    public List<Endereco> allWhereCEPEquals(String cep) {
        query = entityManager.createNamedQuery("Endereco.AllWhereCEPEquals");
        query.setParameter(0, cep);
        return query.getResultList();
    }

    @Override
    public List<Endereco> allWherePatioLike(String logradouro) {
        query = entityManager.createNamedQuery("Endereco.AllWherePatioLike");
        query.setParameter(0, logradouro);
        return query.getResultList();
    }
}
