/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ChameleonEJB.WebService;

import br.com.ChameleonEJB.DAO.PedidoDAO;
import br.com.ChameleonEJB.Model.Pedido;
import br.com.ChameleonEJB.Model.Produto;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David
 */
@WebService(serviceName = "PedidoWS")
@Stateless()
public class PedidoWS {
    @EJB
    private PedidoDAO pedidoDAO;
    private String retorno;
    
    @PersistenceContext(unitName = "ChameleonEJB_PU")

    @WebMethod(operationName = "allOrders")
    public String allOrders() {
        retorno = "";
        
        try {
            List<Pedido> listaPedidos = pedidoDAO.all();
            retorno += "\n-----Pedidos------";
            for (Pedido pedido : listaPedidos) {
                retorno += "\nID Pedido: " + pedido.getPedido().getId();
                retorno += "\nID Cliente: " + pedido.getPedido().getCliente().getId;
                retorno += "\nStatus: " + pedido.getPedido().getStatus();
                retorno += "\n-----Produtos------";
                for (Produto produto : pedido.getListaPedidoProduto()) {
                    retorno += "\nNome do Produto: " + produto.getNome();
                }
                retorno += "\n---------------";
                retorno += "\nValor Total: R$" + pedido.getPedido().getValorTotal();
                retorno += "\n\n\n";
            }
            retorno += "\n---------------";
        } catch (Exception ex) {
            ex.printStackTrace(); //Erro ao converter as datas.
        }
        return retorno;
    }
    
    @WebMethod(operationName = "allOrdersOrderedByPriceDesc")
    public String allOrdersOrderedByPriceDesc() {
        retorno = "";

        try {
            List<Pedido> listaPedidos = pedidoDAO.allOrderByPriceDesc();
            retorno += "\n-----Pedidos------";
            for (Pedido pedido : listaPedidos) {
                retorno += "\nID Pedido: " + pedido.getPedido().getId();
                retorno += "\nID Cliente: " + pedido.getPedido().getCliente().getId;
                retorno += "\nStatus: " + pedido.getPedido().getStatus();
                retorno += "\n-----Produtos------";
                for (Produto produto : pedido.getListaPedidoProduto()) {
                    retorno += "\nNome do Produto: " + produto.getNome();
                }
                retorno += "\n---------------";
                retorno += "\nValor Total: R$" + pedido.getPedido().getValorTotal();
                retorno += "\n\n\n";
            }
            retorno += "\n---------------";
        } catch (Exception ex) {
            ex.printStackTrace(); //Erro ao converter as datas.
        }
        return retorno;
    }
    
    @WebMethod(operationName = "allOrdersOrderedByPrice")
    public String allOrdersOrderedByPrice() {
        retorno = "";

        try {
            List<Pedido> listaPedidos = pedidoDAO.allOrderByPrice();
            retorno += "\n-----Pedidos------";
            for (Pedido pedido : listaPedidos) {
                retorno += "\nID Pedido: " + pedido.getPedido().getId();
                retorno += "\nID Cliente: " + pedido.getPedido().getCliente().getId;
                retorno += "\nStatus: " + pedido.getPedido().getStatus();
                retorno += "\n-----Produtos------";
                for (Produto produto : pedido.getListaPedidoProduto()) {
                    retorno += "\nNome do Produto: " + produto.getNome();
                }
                retorno += "\n---------------";
                retorno += "\nValor Total: R$" + pedido.getPedido().getValorTotal();
                retorno += "\n\n\n";
            }
            retorno += "\n---------------";
        } catch (Exception ex) {
            ex.printStackTrace(); //Erro ao converter as datas.
        }
        return retorno;
    }
    
    @WebMethod(operationName = "allOrdersWherePriceEquals")
    public String allOrdersWherePriceEquals(@WebParam(name = "valor") BigDecimal valor) {
        retorno = "";

        try {
            List<Pedido> listaPedidos = pedidoDAO.allWherePriceEquals(valor);
            retorno += "\n-----Pedidos------";
            for (Pedido pedido : listaPedidos) {
                retorno += "\nID Pedido: " + pedido.getPedido().getId();
                retorno += "\nID Cliente: " + pedido.getPedido().getCliente().getId;
                retorno += "\nStatus: " + pedido.getPedido().getStatus();
                retorno += "\n-----Produtos------";
                for (Produto produto : pedido.getListaPedidoProduto()) {
                    retorno += "\nNome do Produto: " + produto.getNome();
                }
                retorno += "\n---------------";
                retorno += "\nValor Total: R$" + pedido.getPedido().getValorTotal();
                retorno += "\n\n\n";
            }
            retorno += "\n---------------";
        } catch (Exception ex) {
            ex.printStackTrace(); //Erro ao converter as datas.
        }
        return retorno;
    }
    
    @WebMethod(operationName = "allOrdersWherePriceBetween")
    public String allOrdersWherePriceBetween(@WebParam(name = "valorInicio") BigDecimal valorInicio, @WebParam(name = "valorFim") BigDecimal valorFim) {
        retorno = "";

        try {
            List<Pedido> listaPedidos = pedidoDAO.allWherePriceEquals(valorInicio, valorFim);
            retorno += "\n-----Pedidos------";
            for (Pedido pedido : listaPedidos) {
                retorno += "\nID Pedido: " + pedido.getPedido().getId();
                retorno += "\nID Cliente: " + pedido.getPedido().getCliente().getId;
                retorno += "\nStatus: " + pedido.getPedido().getStatus();
                retorno += "\n-----Produtos------";
                for (Produto produto : pedido.getListaPedidoProduto()) {
                    retorno += "\nNome do Produto: " + produto.getNome();
                }
                retorno += "\n---------------";
                retorno += "\nValor Total: R$" + pedido.getPedido().getValorTotal();
                retorno += "\n\n\n";
            }
            retorno += "\n---------------";
        } catch (Exception ex) {
            ex.printStackTrace(); //Erro ao converter as datas.
        }
        return retorno;
    }
}
