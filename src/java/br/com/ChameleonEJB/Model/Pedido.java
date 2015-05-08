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
import javax.persistence.PrimaryKeyJoinColumn;

@NamedQueries({
    @NamedQuery(name = "Pedido.All", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.AllOrderByPriceDesc", query = "SELECT p FROM Pedido p ORDER BY p.valorTotal DESC"),
    @NamedQuery(name = "Pedido.AllOrderByPrice", query = "SELECT p FROM Pedido p ORDER BY p.valorTotal"),
    @NamedQuery(name = "Pedido.AllWherePriceEquals", query = "SELECT p FROM Pedido p WHERE p.valorTotal = :valor"),
    @NamedQuery(name = "Pedido.AllWherePriceBetween", query = "SELECT p FROM Pedido p WHERE p.valorTotal > :valorInicio AND p.valorTotal < :valorFim"),})
@Entity
@SequenceGenerator(
        name = "PEDIDO_SEQ",
        sequenceName = "PEDIDO_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Table
public class Pedido implements Serializable {

    private static final long serialVersionUID = -7763197826912604296L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEDIDO_SEQ")
    private Long id;
    @Column(nullable = false)
    private BigDecimal valorTotal;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PedidoProduto> listaPedidoProduto;
    @PrimaryKeyJoinColumn(name = "idCliente", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status;

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<PedidoProduto> getListaPedidoProduto() {
        return listaPedidoProduto;
    }

    public void setListaPedidoProduto(List<PedidoProduto> listaPedidoProduto) {
        this.listaPedidoProduto = listaPedidoProduto;
    }
}
