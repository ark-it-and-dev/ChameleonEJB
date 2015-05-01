package br.com.ChameleonEJB.Bean;

import br.com.ChameleonEJB.DAO.PedidoDAO;
import br.com.ChameleonEJB.Model.Pedido;
import br.com.ChameleonEJB.Remote.PedidoRemote;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Gustavo Assalin
 */
@Stateless
public class PedidoBean implements PedidoRemote {

    private final PedidoDAO pedidoDAO = new PedidoDAO();
    
    @Override
    public Pedido save(Pedido pedido) throws Exception {
        return pedidoDAO.save(pedido);
    }

    @Override
    public Pedido getById(Long id) {
        return pedidoDAO.getById(id);
    }

    @Override
    public void remove(Long id) {
        pedidoDAO.desactivate(id);
    }
    
    @Override
    public List<Pedido> allOrderByQuantityDesc() {
        return pedidoDAO.allOrderByQuantidadeDesc();
    }
    
    @Override
    public List<Pedido> allOrderByQuantity() {
        return pedidoDAO.allOrderByQuantidade();
    }
    
    @Override
    public List<Pedido> allOrderByPriceDesc() {
        return pedidoDAO.allOrderByValorDesc();
    }
    
    @Override
    public List<Pedido> allOrderByPrice() {
        return pedidoDAO.allOrderByValor();
    }

    @Override
    public List<Pedido> all() {
        return pedidoDAO.all();
    }

    @Override
    public List<Pedido> allWherePriceEquals(BigDecimal valor) {
        return pedidoDAO.allWherePriceEquals(valor);
    }

    @Override
    public List<Pedido> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim) {
        return pedidoDAO.allWherePriceBetween(valorInicio, valorFim);
    }

    @Override
    public Pedido pedidoWhereIdEquals(Long id) {
        return pedidoDAO.pedidoWhereIdEquals(id);
    }
}