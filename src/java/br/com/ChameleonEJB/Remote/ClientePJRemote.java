package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.ClientePJ;
import javax.ejb.Remote;

@Remote
public interface ClientePJRemote {

    public ClientePJ getByEmail(String email);
}
