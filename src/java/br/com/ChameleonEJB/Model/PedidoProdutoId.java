package br.com.ChameleonEJB.Model;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class PedidoProdutoId implements Serializable {

    private static final long serialVersionUID = -1039527049368802485L;

    private Long idPedido;
    private Long idProduto;

    public PedidoProdutoId() {
    }

    public PedidoProdutoId(Long idPedido, Long idProduto) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }
}
