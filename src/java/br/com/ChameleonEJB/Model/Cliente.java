/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gustavo Assalin
 */
@Entity
@SequenceGenerator(
    name = "CLIENTE_SEQ",
    sequenceName = "ARKCLIENTE_SEQ",
    initialValue = 1,
    allocationSize = 1
)
@Table(name = "ArkCliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = -7292163756296624412L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 20)
    private String senha;
    @Column(nullable = false, length = 15)
    private String telefone1;
    @Column(length = 15)
    private String telefone2;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_NASCIMENTO", nullable = false)
    private Date nascimento;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ClienteEndereco",
            joinColumns = {@JoinColumn(name = "Cliente_id")},
            inverseJoinColumns = {@JoinColumn(name = "Endereco_id")}
    )
    private List<Endereco> listaEndereco;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }
}
