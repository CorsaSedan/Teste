/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristhian_anacleto
 */

public class PedidoDAO {

    private static ConnectionManager mngr = ConnectionManager.getInstance();

    public static Pedido findById(int id) {
        String sql = "SELECT * FROM pedido WHERE id = ?";
        Pedido pedido = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setCliente(ClienteDAO.findById(rs.getInt("cliente_id")));
                pedido.setDataPedido(rs.getDate("data_pedido"));
                pedido.setFormaPagamento(rs.getInt("forma_pagamento"));
                pedido.setStatus(rs.getString("status"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return pedido;
    }

    public static List<Pedido> findAll() {
        String sql = "SELECT * FROM pedido";
        List<Pedido> pedidos = new ArrayList();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setCliente(ClienteDAO.findById(rs.getInt("cliente_id")));
                pedido.setDataPedido(rs.getDate("data_pedido"));
                pedido.setFormaPagamento(rs.getInt("forma_pagamento"));
                pedido.setStatus(rs.getString("status"));
                pedidos.add(pedido);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return pedidos;
    }
    public static List<Pedido> findbyClienteId(int id) {
        String sql = "SELECT * FROM pedido INNER JOIN cliente ON (cliente.id=cliente_id) WHERE cliente.id=?";
        List<Pedido> pedidos = new ArrayList();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setCliente(ClienteDAO.findById(rs.getInt("cliente_id")));
                pedido.setDataPedido(rs.getDate("data_pedido"));
                pedido.setFormaPagamento(rs.getInt("forma_pagamento"));
                pedido.setStatus(rs.getString("status"));
                pedidos.add(pedido);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return pedidos;
    }
    
    public static Pedido create (Pedido pedido){
        String sql = "INSERT INTO pedido (cliente_id, data_pedido, forma_pagamento, status) VALUES (?, ?, ?, 'ativado')";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setDate(2, pedido.getDataPedido());
            stmt.setInt(3, pedido.getFormaPagamento());

            stmt.executeUpdate();
            conn.commit();
            rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                pedido.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return pedido;
    }
    
    public static void update(Pedido pedido){
        String sql = "UPDATE pedido SET status=? WHERE id=?";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pedido.getStatus());
            stmt.setInt(2, pedido.getId());
            
            stmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt);
            JDBCUtil.close(conn);
        }
    }
    
    public static void delete(Pedido pedido) {
        delete(pedido.getId());
    }

    public static void delete(int id) {
        String sql = "DELETE FROM pedido WHERE id=?";
        
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
