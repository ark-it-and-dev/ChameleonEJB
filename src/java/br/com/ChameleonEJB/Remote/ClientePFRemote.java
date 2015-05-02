package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.ClientePF;
import javax.ejb.Remote;

@Remote
public interface ClientePFRemote {

    public ClientePF getByEmail(String email);
}
