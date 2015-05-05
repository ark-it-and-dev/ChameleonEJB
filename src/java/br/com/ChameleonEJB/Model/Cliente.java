package br.com.ChameleonEJB.Model;

import br.com.ChameleonEJB.Enum.SexoClientePF;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
    @NamedQuery(name = "Cliente.getByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email")
})

@Entity
@SequenceGenerator(
        name = "CLI_SEQ",
        sequenceName = "ARKCLIENTE_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "ArkCliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 8054825981197088179L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLI_SEQ")
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 250)
    private String email;
    @Column(nullable = false, length = 25)
    private String senha;
    @Column(nullable = false, length = 15)
    private String telefone1;
    @Column(length = 15)
    private String telefone2;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ArkClienteEndereco",
            joinColumns = {
                @JoinColumn(name = "idCliente", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "idEndereco", referencedColumnName = "id")}
    )
    private List<Endereco> listaEndereco;

    //dados do cliente pf
    @Column(length = 14)
    private String cpf;
    @Column(length = 9)
    @Enumerated(EnumType.STRING)
    private SexoClientePF sexo;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_NASCIMENTO")
    private Date nascimento;

    //dados do cliente pj
    @Column(length = 18)
    private String cnpj;
    @Column(length = 250)
    private String razaoSocial;
    @Column(length = 15)
    private String inscEstadual;

    //Criação de um cliente PF
    public Cliente(Long id, String nome, String email, String senha, String telefone1, String cpf, SexoClientePF sexo, Date nascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone1 = telefone1;
        this.cpf = cpf;
        this.sexo = sexo;
        this.nascimento = nascimento;
    }

    //Criação de um cliente pj
    public Cliente(Long id, String nome, String email, String senha, String telefone1, String cnpj, String razaoSocial, String inscEstadual) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone1 = telefone1;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscEstadual = inscEstadual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public SexoClientePF getSexo() {
        return sexo;
    }

    public void setSexo(SexoClientePF sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

}
