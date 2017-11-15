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
public class Ped_Prod {

    private int id;
    private Pedido pedido;
    private Produto produto;
    private double precoItem;
    private double quantidadeItem;

    public Ped_Prod() {
    }

    public Ped_Prod(int id, Pedido pedido, Produto produto, double precoItem, double quantidadeItem) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.precoItem = precoItem;
        this.quantidadeItem = quantidadeItem;
    }

    public double getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(double quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    public double getPrecoTotal() {
        return precoItem * quantidadeItem;
    }

    public static List<Ped_Prod> filter(List<Ped_Prod> list, String type, String search) {
        List<Ped_Prod> filtered = new ArrayList();
        switch (type) {
            case "id":
                for (Ped_Prod list1 : list) {
                    if ((list1.getProduto().getId() + "").contains(search)) {
                        filtered.add(list1);
                    }
                }
                break;
            case "nome":
                for (Ped_Prod list1 : list) {
                    if (list1.getProduto().getNome().contains(search)) {
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
