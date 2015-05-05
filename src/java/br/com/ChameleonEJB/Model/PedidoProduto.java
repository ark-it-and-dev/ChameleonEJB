package br.com.ChameleonEJB.Model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;

@NamedQueries({
    @NamedQuery(name = "PedidoProduto.Update", query = "SELECT p.quantidade FROM PedidoProduto p WHERE p.pedido.id = :idPedido AND p.produto.id = :idProduto"),
    @NamedQuery(name = "PedidoProduto.getQuantity", query = "SELECT p.quantidade FROM PedidoProduto p WHERE p.pedido.id = :idPedido AND p.produto.id = :idProduto")
})

@Entity
public class PedidoProduto implements Serializable {

    private static final long serialVersionUID = 638029348368802485L;

    @EmbeddedId
    private PedidoProdutoId id;
    @PrimaryKeyJoinColumn(name = "idPedido", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido pedido;
    @PrimaryKeyJoinColumn(name = "idProduto", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public PedidoProdutoId getId() {
        return id;
    }

    public void setId(PedidoProdutoId id) {
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

    public PedidoProduto(PedidoProdutoId id, Pedido pedido, Produto produto, int quantidade) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }
}
