/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Enum.StatusPedido;
import br.com.ChameleonEJB.Model.Pedido;
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
}
