package br.com.ChameleonEJB.Model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PedidoProduto implements Serializable {

    private static final long serialVersionUID = 638029348368802485L;

    @EmbeddedId
    private PedidoProduto id;
    @JoinColumn(name = "idPedido", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido pedido;
    @JoinColumn(name = "idProduto", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public PedidoProduto getId() {
        return id;
    }

    public void setId(PedidoProduto id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public PedidoProduto() {
    }

}
