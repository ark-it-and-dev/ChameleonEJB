package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.Cliente;
import javax.ejb.Remote;

@Remote
public interface ClienteRemote {

    public Cliente getByEmail(String email);

    public Cliente save(Long id) throws Exception;

    public Cliente getById(Long id);
}
