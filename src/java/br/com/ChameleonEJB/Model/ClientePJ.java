package br.com.ChameleonEJB.Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(name = "ClientePJ.getByEmail", query = "SELECT c FROM ArkClientePJ c WHERE c.email = :email")
})
@Entity
@SequenceGenerator(
        name = "CLIPJ_SEQ",
        sequenceName = "ARKCLIENTEPJ_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "ArkClientePJ")
public class ClientePJ implements Serializable {

    private static final long serialVersionUID = 8054825981197088179L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIPF_SEQ")
    private Long id;
    @Column(nullable = false, length = 18)
    private String cnpj;
    @Column(nullable = false, length = 250)
    private String razaoSocial;
    @Column(nullable = false, length = 15)
    private String inscEstadual;
    @OneToOne(cascade = CascadeType.ALL)
    private Cliente Cliente;

    public Long getId() {
        return id;
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

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }
}
