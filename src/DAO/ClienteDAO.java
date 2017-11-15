/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristhian_anacleto
 */

public class ClienteDAO {

    private static ConnectionManager mngr = ConnectionManager.getInstance();

    public static Cliente findById(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        Cliente cliente = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setStatus(rs.getString("status"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return cliente;
    }

    public static List<Cliente> findAll() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setStatus(rs.getString("status"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return clientes;
    }
    
    public static List<Cliente> findActive () {
        String sql = "SELECT * FROM cliente WHERE status='ativado'";
        List<Cliente> clientes = new ArrayList();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setStatus(rs.getString("status"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return clientes;
    }
    
    public static void update(Cliente cliente){
        String sql = "UPDATE cliente SET nome=?, status=? WHERE id=?";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getStatus());
            stmt.setInt(3, cliente.getId());
            
            stmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt);
            JDBCUtil.close(conn);
        }
    }
    
    public static void create (Cliente cliente){
        String sql = "INSERT INTO cliente (nome, status) VALUES (?, 'ativado')";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());

            stmt.executeUpdate();
            conn.commit();
            rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                cliente.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
    }
    
    public static void delete(Cliente cliente) {
        delete(cliente.getId());
    }

    public static void delete(int id) {
        String sql = "DELETE FROM cliente WHERE id=?";
        
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
