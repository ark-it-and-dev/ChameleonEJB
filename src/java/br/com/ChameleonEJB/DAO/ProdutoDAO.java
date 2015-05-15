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

    @Override
    public Produto save(Produto produto) throws Exception {
        if (produto.getId() == null) {
            entityManager.persist(produto);
        } else {
            if (!entityManager.contains(produto)) {
                if (produto.getId() == null) {
                    throw new Exception("Erro ao atualizar os dados!");
                }
            }
            produto = (Produto) entityManager.merge(produto);
        }
        return produto;
    }

    @Override
    public void activate(Long id) {
        changeStatus(id, StatusProduto.D);
    }

    @Override
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
        query = entityManager.createNamedQuery("Produto.AllOrderByPriceDesc");
        return query.getResultList();
    }

    @Override
    public List<Produto> allOrderByPrice() {
        query = entityManager.createNamedQuery("Produto.AllOrderByPrice");
        return query.getResultList();
    }

    @Override
    public List<Produto> allWhereStatusD() {
        query = entityManager.createNamedQuery("Produto.AllWhereStatusEquals");
        query.setParameter(0, StatusProduto.D);
        return query.getResultList();
    }

    @Override
    public List<Produto> allWhereStatusI() {
        query = entityManager.createNamedQuery("Produto.AllWhereStatusEquals");
        query.setParameter(0, StatusProduto.I);
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

    @Override
    public List<Produto> all() {
        query = entityManager.createNamedQuery("Produto.All");
        return query.getResultList();
    }
}
