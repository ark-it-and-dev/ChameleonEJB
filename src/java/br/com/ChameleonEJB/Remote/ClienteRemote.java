package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.Cliente;
import javax.ejb.Remote;

@Remote
public interface ClienteRemote {

    public Cliente save(Cliente cliente) throws Exception;

    public Cliente getByEmail(String email);
}
