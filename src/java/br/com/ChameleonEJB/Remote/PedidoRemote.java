/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.Pedido;
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
    public List<Pedido> allOrderByQuantidadeDesc();
    public List<Pedido> allOrderByQuantidade();
    public List<Pedido> allOrderByValorDesc();
    public List<Pedido> allOrderByValor();
}
