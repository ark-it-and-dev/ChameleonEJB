package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ProdutoRemote {

    public Produto save(Produto p) throws Exception;

    public List<Produto> allOrderByPriceDesc();

    public List<Produto> allOrderByPrice();

    public List<Produto> allWhereStatusD();

    public List<Produto> allWhereStatusI();

    public List<Produto> allWherePriceEquals(BigDecimal valor);

    public List<Produto> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim);

    public void activate(Long id);

    public void desactivate(Long id);
}
