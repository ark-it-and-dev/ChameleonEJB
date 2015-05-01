/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Enum.StatusProduto;
import br.com.ChameleonEJB.Model.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Gustavo Assalin
 */
@Remote
public interface ProdutoRemote {
    public Produto save(Produto produto) throws Exception;
    public Produto getById(Long id);
    public void remove(Long id);
    public void changeStatus(Long id, StatusProduto statusProduto);
    public List<Produto> allOrderByPriceDesc();
    public List<Produto> allOrderByPrice();
    public List<Produto> allWhereStatusD();
    public List<Produto> allWhereStatusI();
    public List<Produto> allWherePriceEquals(BigDecimal valor);
    public List<Produto> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim);
}
