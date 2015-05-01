package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.Pedido;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PedidoRemote {

    public List<Pedido> all();

    public List<Pedido> allOrderByQuantityDesc();

    public List<Pedido> allOrderByQuantity();

    public List<Pedido> allOrderByPriceDesc();

    public List<Pedido> allOrderByPrice();

    public List<Pedido> allWherePriceEquals(BigDecimal valor);

    public List<Pedido> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim);
}
