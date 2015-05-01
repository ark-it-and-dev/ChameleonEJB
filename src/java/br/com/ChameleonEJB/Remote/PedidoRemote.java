package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.Pedido;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Gustavo Assalin
 */
@Remote
public interface PedidoRemote {
    public Pedido save(Pedido pedido) throws Exception;
    public Pedido getById(Long id);
    public void remove(Long id);
    public List<Pedido> all();
    public List<Pedido> allOrderByQuantityDesc();
    public List<Pedido> allOrderByQuantity();
    public List<Pedido> allOrderByPriceDesc();
    public List<Pedido> allOrderByPrice();
    public List<Pedido> allWherePriceEquals(BigDecimal valor);
    public List<Pedido> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim);
    public Pedido pedidoWhereIdEquals(Long id);
}
