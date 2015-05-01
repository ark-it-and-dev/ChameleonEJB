package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Enum.StatusPedido;
import br.com.ChameleonEJB.Model.Pedido;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Gustavo Assalin
 */
public class PedidoDAO extends MasterDAO {

    private Query query;
    
    public PedidoDAO() {
        entityManager = getEntityManager();
    }

    public Pedido save(Pedido pedido) throws Exception {
        if(pedido.getId() == null) {
            entityManager.persist(pedido);
        } else {
            if(!entityManager.contains(pedido)) {
                if(entityManager.find(Pedido.class, pedido.getId()) == null) {
                    throw new Exception("Erro ao atualizar os dados do pedido!");
                }
            }
            pedido = entityManager.merge(pedido);
        }
        
        return pedido;
    }
    
    public Pedido getById(Long id) {
        return entityManager.find(Pedido.class, id);
    }
    
    public Pedido getByName(String nome) {
        return null;
    }
    
    @Override
    public void activate(Long id) {
        changeStatus(id, StatusPedido.N); //Novo
    }
    
    @Override
    public void desactivate(Long id) {
        changeStatus(id, StatusPedido.C); //Cancelado
    }
    
    public void send(Long id) {
        changeStatus(id, StatusPedido.E); //Enviado Para Cliente
    }
    
    public void receive(Long id) {
        changeStatus(id, StatusPedido.R); //Receber Pedido(CLIENTE)
    }
    
    public void wait(Long id) {
        changeStatus(id, StatusPedido.A); //Aguardar Confirmacao de Pagamento
    }
    
    private void changeStatus(Long id, StatusPedido statusPedido) {
        Pedido pedido = getById(id);
        pedido.setStatusPedido(statusPedido);
        try {
            save(pedido);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Pedido> all() {
        query = entityManager.createNamedQuery("Pedido.All");
        return query.getResultList();
    }
    
    public List<Pedido> allOrderByQuantidadeDesc() {
        query = entityManager.createNamedQuery("Pedido.OrderByQuantidadeDesc");
        return query.getResultList();
    }
    
    public List<Pedido> allOrderByQuantidade() {
        query = entityManager.createNamedQuery("Pedido.OrderByQuantidade");
        return query.getResultList();
    }
    
    public List<Pedido> allOrderByValorDesc() {
        query = entityManager.createNamedQuery("Pedido.OrderByValorDesc");
        return query.getResultList();
    }
    
    public List<Pedido> allOrderByValor() {
        query = entityManager.createNamedQuery("Pedido.OrderByValorDesc");
        return query.getResultList();
    }
    
    public List<Pedido> allWherePriceEquals(BigDecimal valor) {
        query = entityManager.createNamedQuery("Pedido.AllWherePriceEquals");
        query.setParameter(0, valor);
        
        return query.getResultList();
    }
    
    public List<Pedido> allWherePriceBetween(BigDecimal valorInicio, BigDecimal valorFim) {
        query = entityManager.createNamedQuery("Pedido.AllWherePriceBetween");
        query.setParameter(0, valorInicio);
        query.setParameter(1, valorFim);
        
        return query.getResultList();
    }
    
    public Pedido pedidoWhereIdEquals(Long id) {
        query = entityManager.createNamedQuery("Pedido.PedidoWhereIdEquals");
        query.setParameter(0, id);
        
        return (Pedido)query.getSingleResult();
    }
}
