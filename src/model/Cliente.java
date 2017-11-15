/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristhian_anacleto
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String status;

    public Cliente() {
    }

    public Cliente(int id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public static List<Cliente> filter(List<Cliente> list, String type, String search) {
        List<Cliente> filtered = new ArrayList();
        switch (type) {
            case "id":
                for (Cliente list1 : list) {
                    if ((list1.getId()+"").contains(search)) {
                        filtered.add(list1);
                    }
                }
                break;
            case "nome":
                for (Cliente list1 : list) {
                    if (list1.getNome().contains(search)) {
                        filtered.add(list1);
                    }
                }
                break;
            default:
                throw new AssertionError();
        }
        return filtered;
    } 
    
}
