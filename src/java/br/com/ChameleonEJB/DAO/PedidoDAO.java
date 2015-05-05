package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Enum.StatusPedido;
import br.com.ChameleonEJB.Model.Pedido;
import br.com.ChameleonEJB.Remote.PedidoRemote;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class PedidoDAO extends BaseDao<Pedido> implements PedidoRemote {

    private Query query;

    @Override
    public Pedido save(Pedido pedido) throws Exception {
        return save(pedido, pedido.getId());
    }

    @Override
    public void activate(Long id) {
        changeStatus(id, StatusPedido.N); //Novo
    }

    @Override
    public void desactivate(Long id) {
        changeStatus(id, StatusPedido.C); //Cancelado
    }

    @Override
    public void send(Long id) {
        changeStatus(id, StatusPedido.E); //Enviado Para Cliente
    }

    @Override
    public void receive(Long id) {
        changeStatus(id, StatusPedido.R); //Receber Pedido(CLIENTE)
    }

    @Override
    public void wait(Long id) {
        changeStatus(id, StatusPedido.A); //Aguardar Confirmacao de Pagamento
    }

    private void changeStatus(Long id, StatusPedido statusPedido) {
        Pedido pedido = getById(id);
        pedido.setStatusPedido(statusPedido);
        try {
            save(pedido);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Override
    public List<Pedido> all() {
        query = entityManager.createNamedQuery("Pedido.All");
        return query.getResultList();
    }

    @Override
    public List<Pedido> allOrderByQuantityDesc() {
        query = entityManager.createNamedQuery("Pedido.OrderByQuantidadeDesc");
        return query.getResultList();
    }

    @Override
    public List<Pedido> allOrderByQuantity() {
        query = entityManager.createNamedQuery("Pedido.OrderByQuantidade");
        return query.getResultList();
    }

    @Override
    public List<Pedido> allOrderByPriceDesc() {
        query = entityManager.createNamedQuery("Pedido.OrderByPriceDesc");
        return query.getResultList();
    }

    @Override
    public List<Pedido> allOrderByPrice() {
        query = entityManager.createNamedQuery("Pedido.OrderByPriceDesc");
        return query.getResultList();
    }

    @Override
    public List<Pedido> allWherePriceEquals(BigDecimal valor) {
        query = entityManager.createNamedQuery("Pedido.AllWherePriceEquals");
        query.setParameter(0, valor);

        return query.getResultList();
    }

    @Override
    public List<Pedido> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim) {
        query = entityManager.createNamedQuery("Pedido.AllWherePriceBetween");
        query.setParameter(0, valorInicio);
        query.setParameter(1, valorFim);

        return query.getResultList();
    }
}
