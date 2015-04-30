/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Bean;

import br.com.ChameleonEJB.DAO.PedidoDAO;
import br.com.ChameleonEJB.Model.Pedido;
import br.com.ChameleonEJB.Remote.PedidoRemote;
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
    public List<Pedido> allOrderByQuantidadeDesc() {
        return pedidoDAO.allOrderByQuantidadeDesc();
    }
    
    @Override
    public List<Pedido> allOrderByQuantidade() {
        return pedidoDAO.allOrderByQuantidade();
    }
    
    @Override
    public List<Pedido> allOrderByValorDesc() {
        return pedidoDAO.allOrderByValorDesc();
    }
    
    @Override
    public List<Pedido> allOrderByValor() {
        return pedidoDAO.allOrderByValor();
    }
}
