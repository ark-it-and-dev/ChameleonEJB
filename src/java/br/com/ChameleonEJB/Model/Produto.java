package br.com.ChameleonEJB.Model;

import br.com.ChameleonEJB.Enum.StatusProduto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@NamedQueries({
    @NamedQuery(name = "Produto.All", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.AllOrderByPriceDesc", query = "SELECT p FROM Produto p ORDER BY p.preco DESC"),
    @NamedQuery(name = "Produto.AllOrderByPrice", query = "SELECT p FROM Produto p ORDER BY p.preco"),
    @NamedQuery(name = "Produto.AllWhereStatusEquals", query = "SELECT p FROM Produto p WHERE p.status = :status"),
    @NamedQuery(name = "Produto.AllWherePriceEquals", query = "SELECT p FROM Produto p WHERE p.preco = :valor"),
    @NamedQuery(name = "Produto.AllWherePriceBetween", query = "SELECT p FROM Produto p WHERE p.preco > :valorInicio AND p.preco < :valorFim")})

@SequenceGenerator(
        name = "PRODUTO_SEQ",
        sequenceName = "PRODUTO_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
    private long id;

    private String nome;

    private double preco;

    private String descricao;

    private String marca;

    @Enumerated(EnumType.STRING)
    private StatusProduto status;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PedidoProduto> listaPedidoProduto;

    public Produto() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
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

    public List<PedidoProduto> getListaPedidoProduto() {
        return listaPedidoProduto;
    }

    public void setListaPedidoProduto(List<PedidoProduto> listaPedidoProduto) {
        this.listaPedidoProduto = listaPedidoProduto;
    }
}
