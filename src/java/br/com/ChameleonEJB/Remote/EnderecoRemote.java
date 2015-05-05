package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.Endereco;
import java.util.List;

public interface EnderecoRemote {

    public Endereco save(Endereco e) throws Exception;

    public List<Endereco> all();

    public List<Endereco> allWhereCEPEquals(String cep);

    public List<Endereco> allWherePatioLike(String logradouro);
}
