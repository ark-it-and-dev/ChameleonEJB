package br.com.ChameleonEJB.Model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Cliente {

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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ClienteEndereco",
            joinColumns = {
                @JoinColumn(name = "Cliente_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "Endereco_id")}
    )
    private List<Endereco> listaEndereco;

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

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }
}
