package br.com.ChameleonEJB.Bean;

import br.com.ChameleonEJB.DAO.PedidoDAO;
import br.com.ChameleonEJB.Model.Pedido;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PedidoBean extends PedidoDAO {

    public Pedido save(Pedido pedido) throws Exception {
        return save(pedido);
    }

    public Pedido getById(Long id) {
        return getById(id);
    }

    public void remove(Long id) {
        desactivate(id);
    }

    public List<Pedido> allOrderByQuantityDesc() {
        return allOrderByQuantityDesc();
    }

    public List<Pedido> allOrderByQuantity() {
        return allOrderByQuantity();
    }

    public List<Pedido> allOrderByPriceDesc() {
        return allOrderByPriceDesc();
    }

    public List<Pedido> allOrderByPrice() {
        return allOrderByPrice();
    }

    public List<Pedido> all() {
        return all();
    }

    public List<Pedido> allWherePriceEquals(BigDecimal valor) {
        return allWherePriceEquals(valor);
    }

    public List<Pedido> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim) {
        return allWherePriceBetween(valorInicio, valorFim);
    }
}
