package br.com.ChameleonEJB.Model;

import br.com.ChameleonEJB.Enum.SexoClientePF;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
    @NamedQuery(name = "ClientePF.getByEmail", query = "SELECT c FROM ClientePF c WHERE c.email = :email")
})
@Entity
@SequenceGenerator(
        name = "CLIPF_SEQ",
        sequenceName = "ARKCLIENTEPF_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "ArkClientePF")
public class ClientePF extends Cliente implements Serializable {

    private static final long serialVersionUID = -7385857933604370621L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIPF_SEQ")
    private Long id;
    @Column(nullable = false, length = 14)
    private String cpf;
    @Column(nullable = false, length = 9)
    @Enumerated(EnumType.STRING)
    private SexoClientePF sexo;
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_NASCIMENTO", nullable = false)
    private Date nascimento;

    public Long getId() {
        return id;
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
}
