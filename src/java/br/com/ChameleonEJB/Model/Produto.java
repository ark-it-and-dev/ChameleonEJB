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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo Assalin
 */
//Diz que a classe eh uma entidade
@NamedQueries({
    @NamedQuery(name = "Produto.OrderByPrecoDesc", query = "SELECT p FROM ArkProduto p ORDER BY p.preco DESC"),
    @NamedQuery(name = "Produto.OrderByPreco", query = "SELECT p FROM ArkProduto p ORDER BY p.preco"),
    @NamedQuery(name = "Produto.WhereStatusD", query = "SELECT p FROM ArkProduto p WHERE p.status = 'D'"),
    @NamedQuery(name = "Produto.WhereStatusI", query = "SELECT p FROM ArkProduto p WHERE p.status = 'I'")
})
@Entity
@SequenceGenerator(
        name = "PROD_SEQ",
        sequenceName = "ARKPRODUTO_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "ArkProduto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 6342446145368898389L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROD_SEQ")
    private Long id;
    @Column(nullable = false, length = 20)
    private String nome;
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

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
