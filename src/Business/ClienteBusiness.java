/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author cristhian_anacleto
 */
public class ClienteBusiness {

    public static Cliente findById(int id) {
        return ClienteDAO.findById(id);
    }

    public static List<Cliente> findAll() {
        return ClienteDAO.findAll();
    }

    public static List<Cliente> findActive() {
        return ClienteDAO.findActive();
    }

    public static void update(Cliente cliente) {
        ClienteDAO.update(cliente);
    }

    public static void create(Cliente cliente) {
        ClienteDAO.create(cliente);
    }

    public static void activate(Cliente cliente) {
        cliente.setStatus("ativado");
        update(cliente);
    }

    public static void disable(Cliente cliente) {
        cliente.setStatus("desativado");
        update(cliente);
    }

    /**
     * 
     * @param search elemento buscado na lista
     * @param type tipo de busca: por id ou por nome
     * @param lista a lista na qual o elemento será buscado
     * @return Objetos que contenham o elemento buscado
     */
    public static List<Cliente> search(String search, String type, List<Cliente> lista) {
        List<Cliente> ls = new ArrayList();

        try {
            switch (type) {
                case "id":
                    for (Cliente cliente : lista) {
                        if (cliente.getId() == Integer.parseInt(search)) {
                            ls.add(cliente);
                        }
                    }
                    break;
                case "nome":
                    String[] s = search.split("");
                    for (Cliente clientez : lista) {
                        String[] nome = clientez.getNome().split("");
                        int i;
                        for (i = 0; i < s.length; i++) {
                            if (!s[i].equalsIgnoreCase(nome[i])) {
                                break;
                            }
                        }
                        if (i == s.length) {
                            ls.add(clientez);
                        }
                    }
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
