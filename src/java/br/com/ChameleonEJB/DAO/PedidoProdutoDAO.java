package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Model.PedidoProduto;
import br.com.ChameleonEJB.Model.PedidoProdutoId;
import br.com.ChameleonEJB.Remote.PedidoProdutoRemote;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class PedidoProdutoDAO extends BaseDao<PedidoProduto> implements PedidoProdutoRemote {

    private Query query;

    @Override
    public int getQuantity(Long idPedido, Long idProduto) {
        query = entityManager.createNamedQuery("PedidoProduto.getQuantity");
        query.setParameter(0, idPedido);
        query.setParameter(1, idProduto);
        return (int) query.getSingleResult();
    }

    @Override
    public PedidoProduto save(PedidoProduto p) throws Exception {
        if (p.getId() == null) {
            add(p);
        } else {
            if (!entityManager.contains(p)) {
                if (getById(p.getId()) == null) {
                    throw new Exception("Erro ao atualizar os dados!");
                }
            }
            p = (PedidoProduto) update(p);
        }
        return p;
    }

    @Override
    public PedidoProduto getById(PedidoProdutoId id) {
        return entityManager.find(PedidoProduto.class, id);
    }
}
