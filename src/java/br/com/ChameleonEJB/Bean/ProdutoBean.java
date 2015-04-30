/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Bean;

import br.com.ChameleonEJB.DAO.ProdutoDAO;
import br.com.ChameleonEJB.Enum.StatusProduto;
import br.com.ChameleonEJB.Model.Produto;
import br.com.ChameleonEJB.Remote.ProdutoRemote;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Gustavo Assalin
 */
@Stateless
public class ProdutoBean implements ProdutoRemote {

    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    
    @Override
    public Produto save(Produto produto) throws Exception {
        return produtoDAO.save(produto);
    }

    @Override
    public Produto getById(Long id) {
        return produtoDAO.getById(id);
    }

    @Override
    public void remove(Long id) {
        produtoDAO.desactivate(id);
    }
    
    @Override
    public void alterarStatus(Long id, StatusProduto statusProduto) {
        produtoDAO.changeStatus(id, statusProduto);
    }
    
    @Override
    public List<Produto> allOrderByPrecoDesc() {
        return produtoDAO.allOrderByPrecoDesc();
    }
    
    @Override
    public List<Produto> allOrderByPreco() {
        return produtoDAO.allOrderByPreco();
    }
    
    @Override
    public List<Produto> allWhereStatusD() {
        return produtoDAO.allWhereStatusD();
    }
    
    @Override
    public List<Produto> allWhereStatusI() {
        return produtoDAO.allWhereStatusI();
    }
}
