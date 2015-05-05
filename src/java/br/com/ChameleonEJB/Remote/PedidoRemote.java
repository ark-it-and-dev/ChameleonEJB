package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.Pedido;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PedidoRemote {

    public Pedido save(Pedido p) throws Exception;

    public List<Pedido> all();

    public List<Pedido> allOrderByPriceDesc();

    public List<Pedido> allOrderByPrice();

    public List<Pedido> allWherePriceEquals(BigDecimal valor);

    public List<Pedido> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim);

    public void activate(Long id);

    public void desactivate(Long id);

    public void send(Long id);

    public void receive(Long id);

    public void wait(Long id);
}
