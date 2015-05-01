package br.com.ChameleonEJB.Model;

import br.com.ChameleonEJB.Enum.StatusProduto;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Gustavo Assalin
 */
@NamedQueries({
    @NamedQuery(name = "Produto.All", query = "SELECT p FROM ArkProduto p"),
    @NamedQuery(name = "Produto.AllOrderByPrecoDesc", query = "SELECT p FROM ArkProduto p ORDER BY p.preco DESC"),
    @NamedQuery(name = "Produto.AllOrderByPreco", query = "SELECT p FROM ArkProduto p ORDER BY p.preco"),
    @NamedQuery(name = "Produto.AllWhereStatusD", query = "SELECT p FROM ArkProduto p WHERE p.status = 'D'"),
    @NamedQuery(name = "Produto.AllWhereStatusI", query = "SELECT p FROM ArkProduto p WHERE p.status = 'I'"),
    @NamedQuery(name = "Produto.AllWherePriceEquals", query = "SELECT p FROM ArkProduto p WHERE p.preco = :valor"),
    @NamedQuery(name = "Produto.AllWherePriceBetween", query = "SELECT p FROM ArkProduto p WHERE p.preco > :valorInicio AND p.preco < :valorFim"),
})
@Entity
@SequenceGenerator(
        name = "PRODUTO_SEQ",
        sequenceName = "ARKPRODUTO_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "ArkProduto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 6342446145368898389L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
    private Long id;
    @Column(nullable = false, length = 20)
    private String nome;
    @Column(nullable = false)
    private Long quantidade;
    @Column(nullable = false)
    private BigDecimal preco;
    @Column(length = 250)
    private String descricao;
    @Column(nullable = false, length = 20)
    private String marca;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusProduto status;
    @ManyToOne
    private Pedido pedido;

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public StatusProduto getStatus() {
        return status;
    }

    public void setStatus(StatusProduto status) {
        this.status = status;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
