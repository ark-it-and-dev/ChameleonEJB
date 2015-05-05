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

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

}
