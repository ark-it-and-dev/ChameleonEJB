package br.com.ChameleonEJB.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.ChameleonEJB.Enum.StatusPedido;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Gustavo Assalin
 */
@NamedQueries({
    @NamedQuery(name = "Pedido.All", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.AllOrderByQuantityDesc", query = "SELECT p FROM Pedido p ORDER BY p.quantidade DESC"),
    @NamedQuery(name = "Pedido.AllOrderByQuantity", query = "SELECT p FROM Pedido p ORDER BY p.quantidade"),
    @NamedQuery(name = "Pedido.AllOrderByPriceDesc", query = "SELECT p FROM Pedido p ORDER BY p.valorTotal DESC"),
    @NamedQuery(name = "Pedido.AllOrderByPrice", query = "SELECT p FROM Pedido p ORDER BY p.valorTotal"),
    @NamedQuery(name = "Pedido.AllWherePriceEquals", query = "SELECT p FROM Pedido p WHERE p.valorTotal = :valor"),
    @NamedQuery(name = "Pedido.AllWherePriceBetween", query = "SELECT p FROM Pedido p WHERE p.valorTotal > :valorInicio AND p.valorTotal < :valorFim"),})
@Entity
@SequenceGenerator(
        name = "PED_SEQ",
        sequenceName = "ARKPEDIDO_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "ArkPedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = -7763197826912604296L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PED_SEQ")
    private Long id;
    @Column(nullable = false)
    private BigDecimal quantidade;
    @Column(nullable = false)
    private BigDecimal valorTotal;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "ArkPedidoProduto",
            joinColumns = {
                @JoinColumn(name = "idPedido")},
            inverseJoinColumns = {
                @JoinColumn(name = "idProduto")}
    )
    private List<Produto> listaProduto;
    @ManyToOne
    private Cliente cliente;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPedido statusPedido;

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
