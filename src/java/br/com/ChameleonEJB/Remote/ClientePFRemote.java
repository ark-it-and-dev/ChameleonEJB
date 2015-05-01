package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.ClientePF;
import javax.ejb.Remote;

@Remote
public interface ClientePFRemote extends BaseRemote {

    public ClientePF getByEmail(String email);
}
