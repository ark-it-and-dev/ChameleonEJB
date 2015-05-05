package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.PedidoProduto;
import br.com.ChameleonEJB.Model.PedidoProdutoId;
import javax.ejb.Remote;

@Remote
public interface PedidoProdutoRemote {

    public int getQuantity(Long idPedido, Long idProduto);

    public PedidoProduto getById(PedidoProdutoId id);

    public PedidoProduto save(PedidoProduto p) throws Exception;

}
