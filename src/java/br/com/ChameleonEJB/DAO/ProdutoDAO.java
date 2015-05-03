package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Enum.StatusProduto;
import br.com.ChameleonEJB.Model.Produto;
import br.com.ChameleonEJB.Remote.ProdutoRemote;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ProdutoDAO extends BaseDao<Produto> implements ProdutoRemote {

    private Query query;

    public Produto save(Produto produto) throws Exception {
        return save(produto, produto.getId());
    }

    public void activate(Long id) {
        changeStatus(id, StatusProduto.D);
    }

    public void desactivate(Long id) {
        changeStatus(id, StatusProduto.I);
    }

    private void changeStatus(Long id, StatusProduto statusProduto) {
        Produto p = getById(id);
        p.setStatus(statusProduto);
        try {
            save(p);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Override
    public List<Produto> allOrderByPriceDesc() {
        query = entityManager.createNamedQuery("Produto.OrderByPriceDesc");
        return query.getResultList();
    }

    @Override
    public List<Produto> allOrderByPrice() {
        query = entityManager.createNamedQuery("Produto.OrderByPrice");
        return query.getResultList();
    }

    @Override
    public List<Produto> allWhereStatusD() {
        query = entityManager.createNamedQuery("Produto.WhereStatusEquals");
        query.setParameter(0, "D");
        return query.getResultList();
    }

    @Override
    public List<Produto> allWhereStatusI() {
        query = entityManager.createNamedQuery("Produto.WhereStatusEquals");
        query.setParameter(0, "I");
        return query.getResultList();
    }

    @Override
    public List<Produto> allWherePriceEquals(BigDecimal valor) {
        query = entityManager.createNamedQuery("Produto.AllWherePriceEquals");
        query.setParameter(0, valor);
        return query.getResultList();
    }

    @Override
    public List<Produto> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim) {
        query = entityManager.createNamedQuery("Produto.AllWherePriceBetween");
        query.setParameter(0, valorInicio);
        query.setParameter(1, valorFim);
        return query.getResultList();
    }
}
