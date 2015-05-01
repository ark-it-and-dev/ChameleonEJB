/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Enum.StatusProduto;
import br.com.ChameleonEJB.Model.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Gustavo Assalin
 */
public class ProdutoDAO extends MasterDAO {
    
    private Query query;
    
    public ProdutoDAO() {
        entityManager = getEntityManager();
    }
    
    public Produto save(Produto produto) throws Exception {
        if(produto.getId() == null) {
            entityManager.persist(produto);
        } else {
            if(!entityManager.contains(produto)) {
                if(entityManager.find(Produto.class, produto.getId()) == null) {
                    throw new Exception("Erro ao atualizar os dados do produto!");
                }
            }
            produto = entityManager.merge(produto);
        }
        
        return produto;
    }
    
    public Produto getById(Long id) {
        return entityManager.find(Produto.class, id);
    }
    
    @Override
    public void activate(Long id) {
        changeStatus(id, StatusProduto.D);
    }
    
    @Override
    public void desactivate(Long id) {
        changeStatus(id, StatusProduto.I);
    }
    
    public void changeStatus(Long id, StatusProduto statusProduto) {
        Produto p = getById(id);
        p.setStatus(statusProduto);
        try {
            save(p);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Produto> allOrderByPrecoDesc() {
        query = entityManager.createNamedQuery("Produto.OrderByPrecoDesc");
        return query.getResultList();
    }
    
    public List<Produto> allOrderByPreco() {
        query = entityManager.createNamedQuery("Produto.OrderByPreco");
        return query.getResultList();
    }
    
    public List<Produto> allWhereStatusD() {
        query = entityManager.createNamedQuery("Produto.WhereStatusD");
        return query.getResultList();
    }
    
    public List<Produto> allWhereStatusI() {
        query = entityManager.createNamedQuery("Produto.WhereStatusI");
        return query.getResultList();
    }
    
    public List<Produto> allWherePriceEquals(BigDecimal valor) {
        query = entityManager.createNamedQuery("Produto.AllWherePriceEquals");
        query.setParameter(0, valor);
        
        return query.getResultList();
    }
    
    public List<Produto> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim) {
        query = entityManager.createNamedQuery("Produto.AllWherePriceBetween");
        query.setParameter(0, valorInicio);
        query.setParameter(1, valorFim);
        
        return query.getResultList();
    }
}
