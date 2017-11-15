/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author cristhian_anacleto
 */
public class ProdutoBusiness {
    
    public static Produto findById (int id) {
        return ProdutoDAO.findById(id);
    }
    
    public static List<Produto> findAll () {
        return ProdutoDAO.findAll();
    }
    
    public static List<Produto> findActive () {
        return ProdutoDAO.findActive();
    }
    
    public static void update (Produto produto) {
        ProdutoDAO.update(produto);
    }
    
    public static void create (Produto produto) {
        ProdutoDAO.create(produto);
    }
    
    public static void activate (Produto produto) {
        produto.setStatus("ativado");
        update(produto);
    }
    
    public static void disable (Produto produto) {
        produto.setStatus("desativado");
        update(produto);
    }
    
    
    public static List<Produto> search(String search, String type) {
        List<Produto> ls = new ArrayList();

        try {
            switch (type) {
                case "id":
                    Produto produto = findById(Integer.parseInt(search));
                    if (produto != null) {
                        ls.add(findById(Integer.parseInt(search)));
                    }
                    break;
                case "nome":
                    String[] s = search.split("");
                    List<Produto> produtos = findAll();
                    for (Produto produtoz : produtos) {
                        String[] nome = produtoz.getNome().split("");
                        int i;
                        for (i = 0; i < s.length; i++) {
                            if (!s[i].equalsIgnoreCase(nome[i])) {
                                break;
                            }
                        }
                        if (i == s.length) {
                            ls.add(produtoz);
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
