package br.com.ChameleonEJB.WebService;


import br.com.ChameleonEJB.DAO.ClienteDAO;
import br.com.ChameleonEJB.Model.Cliente;
import br.com.ChameleonEJB.Model.Endereco;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

@WebService(serviceName = "ClienteWS")
@Stateless()
public class ClienteWS {
    @EJB
    private ClienteDAO clienteDAO;

    private String retorno;

    @PersistenceContext(unitName = "ChameleonEJB_PU")

    @WebMethod(operationName = "getConsumerByEmail")
    public String getConsumerByEmail(@WebParam(name = "email") String email) {
        retorno = "";

        try {
            Cliente cliente = clienteDAO.getByEmail(email);
            List<Endereco> listaEnderecos = cliente.getListaEndereco();
            retorno += "\n-----Cliente------";
            retorno += "\nID: " + cliente.getId();
            retorno += "\nNome: " + cliente.getNome();
            retorno += "\nEmail: " + cliente.getEmail();
//            retorno += "\nSenha: " + cliente.getSenha();
            retorno += "\nTelefone: " + cliente.getTelefone1() + "\n\t" + cliente.getTelefone2();
            retorno += "\n-----Endereços------";
            for (Endereco endereco : listaEnderecos) {
                retorno += "\nID Endereco: " + endereco.getId();
                retorno += "\nLogradouro: " + endereco.getLogradouro();
                retorno += "\n\n\n";
            }
            retorno += "\n---------------";
        } catch (Exception ex) {
            ex.printStackTrace(); //Erro ao converter as datas.
        }
        return retorno;
    }
}
