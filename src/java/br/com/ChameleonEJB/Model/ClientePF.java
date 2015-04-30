/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.Model;

import br.com.ChameleonEJB.Enum.SexoClientePF;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gustavo Assalin
 */
//@NamedQueries({
//    @NamedQuery(name = "", query = "")
//})
@Entity
@SequenceGenerator(
        name = "CLIPF_SEQ",
        sequenceName = "ARKCLIENTEPF_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Table(name = "ArkClientePF")
public class ClientePF implements Serializable {
    private static final long serialVersionUID = -7385857933604370621L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIPF_SEQ")
    private Long id;
    @Column(nullable = false, length = 14)
    private String cpf;
    @Column(nullable = false, length = 9)
    @Enumerated(EnumType.STRING)
    private SexoClientePF sexo;
    @OneToOne(cascade = CascadeType.ALL)
    private Cliente Cliente;

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

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }
}
