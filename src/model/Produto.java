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
public class Produto {

    private int id;
    private String nome;
    private double quantidade;
    private double precoReferencia;
    private String status;

    public Produto() {
    }

    public Produto(int id, String nome, double quantidade, double precoReferencia, String status) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoReferencia = precoReferencia;
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

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoReferencia() {
        return precoReferencia;
    }

    public void setPrecoReferencia(double precoReferencia) {
        this.precoReferencia = precoReferencia;
    }

    public static List<Produto> filter(List<Produto> list, String type, String search) {
        List<Produto> filtered = new ArrayList();
        switch (type) {
            case "id":
                for (Produto list1 : list) {
                    if ((list1.getId() + "").contains(search)) {
                        filtered.add(list1);
                    }
                }
                break;
            case "nome":
                for (Produto list1 : list) {
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
