/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Gustavo Assalin
 */
@NamedQueries({
    @NamedQuery(name = "Pedido.OrderByQuantidadeDesc", query = ""),
    @NamedQuery(name = "Pedido.OrderByQuantidade", query = ""),
    @NamedQuery(name = "Pedido.OrderByValorDesc", query = ""),
    @NamedQuery(name = "Pedido.OrderByValor", query = "")
})
@Entity
/* Anotacao usada para mapear qual a sequence que vai gerar seu id(
 * passando nome pra ela(name)
 * nome da sequence definida no oracle(sequenceName)
 * valor de inicio(initialValue)
 * valor de incremento(allocationSize)
 * )
 */
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
    private int quantidade;
    @Column(nullable = false)
    private BigDecimal valorTotal;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "ArkPedidoProdido",
            joinColumns = {@JoinColumn(name = "idPedido")},
            inverseJoinColumns = {@JoinColumn(name = "idProduto")}
    )
    private List<Produto> listaProduto;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPedido statusPedido;

    public Long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
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

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
