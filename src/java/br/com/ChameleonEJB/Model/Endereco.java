package br.com.ChameleonEJB.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(name = "Endereco.All", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.AllWhereCEPEquals", query = "SELECT e FROM Endereco e WHERE e.cep = :cep"),
    @NamedQuery(name = "Endereco.AllWherePatioLike", query = "SELECT e FROM Endereco e WHERE e.logradouro LIKE :logradouro"),})
@Entity
@SequenceGenerator(
        name = "ENDERECO_SEQ",
        sequenceName = "ENDERECO_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Table
public class Endereco implements Serializable {

    private static final long serialVersionUID = 3627412169215683626L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    private Long id;
    @ManyToMany(
            mappedBy = "listaEndereco",
            cascade = CascadeType.PERSIST
    )
    private List<Cliente> listaCliente;
    @Column(nullable = false, length = 50)
    private String logradouro;
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false, length = 20)
    private String bairro;
    @Column(nullable = false, length = 50)
    private String cidade;
    @Column(nullable = false, length = 2)
    private String uf;
    @Column(nullable = false, length = 10)
    private String cep;
    @Column(length = 250)
    private String complemento;

    public Endereco() {
    }

    public Long getId() {
        return id;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
