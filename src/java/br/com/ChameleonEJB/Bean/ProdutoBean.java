package br.com.ChameleonEJB.Bean;

import br.com.ChameleonEJB.DAO.ProdutoDAO;
import br.com.ChameleonEJB.Enum.StatusProduto;
import br.com.ChameleonEJB.Model.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class ProdutoBean extends ProdutoDAO {

    public Produto save(Produto produto) throws Exception {
        return save(produto);
    }

    public Produto getById(Long id) {
        return getById(id);
    }

    public void remove(Long id) {
        desactivate(id);
    }

    public void changeStatus(Long id, StatusProduto statusProduto) {
        changeStatus(id, statusProduto);
    }

    public List<Produto> allOrderByPriceDesc() {
        return allOrderByPriceDesc();
    }

    public List<Produto> allOrderByPrice() {
        return allOrderByPrice();
    }

    public List<Produto> allWhereStatusD() {
        return allWhereStatusD();
    }

    public List<Produto> allWhereStatusI() {
        return allWhereStatusI();
    }

    public List<Produto> allWherePriceEquals(BigDecimal valor) {
        return allWherePriceEquals(valor);
    }

    public List<Produto> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim) {
        return allWherePriceBetween(valorInicio, valorFim);
    }
}
