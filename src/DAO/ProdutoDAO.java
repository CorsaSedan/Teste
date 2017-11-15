/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristhian_anacleto
 */

public class ProdutoDAO {

    private static ConnectionManager mngr = ConnectionManager.getInstance();

    public static Produto findById(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        Produto produto = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoReferencia(rs.getDouble("preco_referencia"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setStatus(rs.getString("status"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return produto;
    }

    public static List<Produto> findAll() {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoReferencia(rs.getDouble("preco_referencia"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setStatus(rs.getString("status"));
                produtos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return produtos;
    }
    
    public static List<Produto> findActive() {
        String sql = "SELECT * FROM produto WHERE status='ativado'";
        List<Produto> produtos = new ArrayList();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPrecoReferencia(rs.getDouble("preco_referencia"));
                produto.setQuantidade(rs.getDouble("quantidade"));
                produto.setStatus(rs.getString("status"));
                produtos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }

        return produtos;
    }
    
    public static void update(Produto produto){
        String sql = "UPDATE produto SET nome=?, preco_referencia=?, quantidade=?, status=? WHERE id=?";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoReferencia());
            stmt.setDouble(3, produto.getQuantidade());
            stmt.setString(4, produto.getStatus());
            stmt.setInt(5, produto.getId());
            
            stmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt);
            JDBCUtil.close(conn);
        }
    }
    
    public static void create (Produto produto){
        String sql = "INSERT INTO produto (nome, preco_referencia, quantidade, status) VALUES (?, ?, ?, 'ativado')";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = mngr.getConnection();
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPrecoReferencia());
            stmt.setDouble(3, produto.getQuantidade());

            stmt.executeUpdate();
            conn.commit();
            rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                produto.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
    }
    
    public static void delete(Produto produto) {
        delete(produto.getId());
    }

    public static void delete(int id) {
        String sql = "DELETE FROM produto WHERE id=?";
        
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
