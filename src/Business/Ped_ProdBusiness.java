/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DAO.Ped_ProdDAO;
import java.util.List;
import model.Ped_Prod;
import model.Pedido;
import model.Produto;

/**
 *
 * @author cristhian_anacleto
 */
public class Ped_ProdBusiness {
    
    public static Ped_Prod findById (int id) {
        return Ped_ProdDAO.findById(id);
    }
    
    public static List<Ped_Prod> findAll () {
        return Ped_ProdDAO.findAll();
    }
    
    public static List<Ped_Prod> findByPedido(Pedido pedido) {
        return Ped_ProdDAO.findByPedido(pedido);
    }
    
    public static void create (Ped_Prod ped_prod) {
        Ped_ProdDAO.create(ped_prod);
    }
    
    public static void create (List<Ped_Prod> pedProd) {
        for (Ped_Prod pedProd1 : pedProd) {
            create(pedProd1);
        }
    }
    
    public static List<Ped_Prod> adcPedido (List<Ped_Prod> pedProd, Pedido pedido) {
        for (int i = 0; i < pedProd.size(); i++) {
            pedProd.get(i).setPedido(pedido);
        }
        return pedProd;
    }
    
    public static void ajustarEstoque(List<Ped_Prod> pedProd) {
        for (Ped_Prod pedProd1 : pedProd) {
            Produto produto = ProdutoBusiness.findById(pedProd1.getProduto().getId());
            produto.setQuantidade(produto.getQuantidade() - pedProd1.getQuantidadeItem());
            ProdutoBusiness.update(produto);
        }
    }
}
