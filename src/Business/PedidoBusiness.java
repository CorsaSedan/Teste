/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.PedidoDAO;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Ped_Prod;
import model.Pedido;

/**
 *
 * @author cristhian_anacleto
 */
public class PedidoBusiness {

    public static Pedido findById(int id) {
        return PedidoDAO.findById(id);
    }

    public static List<Pedido> findAll() {
        return PedidoDAO.findAll();
    }

    public static List<Pedido> findByClienteId(int id) {
        return PedidoDAO.findbyClienteId(id);
    }
    
    public static Pedido create(Pedido pedido) {
        return PedidoDAO.create(pedido);
    }

    public static void enable(Pedido pedido) {
        pedido.setStatus("ativado");
        PedidoDAO.update(pedido);
    }

    public static void disable(Pedido pedido) {
        pedido.setStatus("desativado");
        PedidoDAO.update(pedido);
    }

    public static double total(Pedido pedido) {
        double valor = 0;
        for (Ped_Prod findByPedido : Ped_ProdBusiness.findByPedido(pedido)) {
            valor += findByPedido.getPrecoTotal();
        }
        return valor;
    }

    public static List<Pedido> search(String search, String type) {
        List<Pedido> ls = new ArrayList();

        try {
            switch (type) {
                case "id":
                    Pedido pedido = findById(Integer.parseInt(search));
                    if (pedido != null) {
                        ls.add(findById(Integer.parseInt(search)));
                    }
                    break;
                case "nome do cliente":
                    String[] s = search.split("");
                    List<Pedido> pedidos = findAll();
                    for (Pedido pedidoz : pedidos) {
                        String[] nome = pedidoz.getCliente().getNome().split("");
                        int i;
                        for (i = 0; i < s.length; i++) {
                            if (!s[i].equalsIgnoreCase(nome[i])) {

                                break;
                            }
                        }
                        if (i == s.length) {
                            ls.add(pedidoz);
                        }
                    }
                    break;
                case "id do cliente":
                    ls = findByClienteId(Integer.parseInt(search));
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return ls;
    }
}
