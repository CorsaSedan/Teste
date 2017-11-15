/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Ped_Prod;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;

/**
 *
 * @author cristhian_anacleto
 */

public class Ped_ProdDAO {

    private static ConnectionManager mngr = ConnectionManager.getInstance();

    public static Ped_Prod findById(int id) {
        String sql = "SELECT * FROM ped_prod WHERE id = ?";
        Ped_Prod ped_prod = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                ped_prod = new Ped_Prod();
                ped_prod.setId(rs.getInt("id"));
                ped_prod.setPedido(PedidoDAO.findById(rs.getInt("pedido_id")));
                ped_prod.setProduto(ProdutoDAO.findById(rs.getInt("produto_id")));
                ped_prod.setPrecoItem(rs.getDouble("preco_item"));
                ped_prod.setQuantidadeItem(rs.getDouble("quantidade_item"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return ped_prod;
    }

    public static List<Ped_Prod> findAll() {
        String sql = "SELECT * FROM ped_prod";
        List<Ped_Prod> ped_prods = new ArrayList();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Ped_Prod ped_prod = new Ped_Prod();
                ped_prod.setId(rs.getInt("id"));
                ped_prod.setId(rs.getInt("id"));
                ped_prod.setPedido(PedidoDAO.findById(rs.getInt("pedido_id")));
                ped_prod.setProduto(ProdutoDAO.findById(rs.getInt("produto_id")));
                ped_prod.setPrecoItem(rs.getDouble("preco_item"));
                ped_prod.setQuantidadeItem(rs.getDouble("quantidade_item"));
                ped_prods.add(ped_prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return ped_prods;
    }
    
    public static List<Ped_Prod> findByPedido(Pedido pedido) {
        String sql = "SELECT * FROM ped_prod WHERE pedido_id= ?";
        List<Ped_Prod> ped_prods = new ArrayList();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pedido.getId());

            rs = stmt.executeQuery();
            while (rs.next()) {
                Ped_Prod ped_prod = new Ped_Prod();
                ped_prod.setId(rs.getInt("id"));
                ped_prod.setId(rs.getInt("id"));
                ped_prod.setPedido(PedidoDAO.findById(rs.getInt("pedido_id")));
                ped_prod.setProduto(ProdutoDAO.findById(rs.getInt("produto_id")));
                ped_prod.setPrecoItem(rs.getDouble("preco_item"));
                ped_prod.setQuantidadeItem(rs.getDouble("quantidade_item"));
                ped_prods.add(ped_prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return ped_prods;
    }
    
    public static void create (Ped_Prod ped_prod){
        String sql = "INSERT INTO ped_prod (pedido_id, produto_id, preco_item, quantidade_item) VALUES (?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, ped_prod.getPedido().getId());
            stmt.setInt(2, ped_prod.getProduto().getId());
            stmt.setDouble(3, ped_prod.getPrecoItem());
            stmt.setDouble(4, ped_prod.getQuantidadeItem());

            stmt.executeUpdate();
            conn.commit();
            rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                ped_prod.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
    }
    
    public static void delete(Ped_Prod ped_prod) {
        delete(ped_prod.getId());
    }

    public static void delete(int id) {
        String sql = "DELETE FROM ped_prod WHERE id=?";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt);
            JDBCUtil.close(conn);
        }
    }
    
}
