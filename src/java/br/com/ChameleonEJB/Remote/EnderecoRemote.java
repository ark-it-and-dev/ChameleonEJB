package br.com.ChameleonEJB.Remote;

import br.com.ChameleonEJB.Model.Cliente;
import br.com.ChameleonEJB.Model.Endereco;
import java.util.List;

public interface EnderecoRemote {

    public List<Endereco> all();

    public List<Endereco> allWhereCEPEquals(String cep);

    public List<Endereco> allWherePatioLike(String logradouro);

    public List<Cliente> allOrderByCostumerId();

    public List<Cliente> allWhereCostumersId(Long id);
}
