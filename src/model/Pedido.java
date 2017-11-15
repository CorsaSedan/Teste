/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cristhian_anacleto
 */
public class Pedido {

    private int id;
    private Date dataPedido;
    private Cliente cliente;
    private int formaPagamento;
    private String status;

    public Pedido() {
    }

    public Pedido(int id, Date dataPedido, Cliente cliente, int formaPagamento, String status) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static List<Pedido> filter(List<Pedido> list, String type, String search) {
        List<Pedido> filtered = new ArrayList();
        switch (type) {
            case "id":
                for (Pedido list1 : list) {
                    if ((list1.getId() + "").contains(search)) {
                        filtered.add(list1);
                    }
                }
                break;
            case "nome do cliente":
                for (Pedido list1 : list) {
                    if (list1.getCliente().getNome().contains(search)) {
                        filtered.add(list1);
                    }
                }
                break;
            case "id do cliente":
                for (Pedido list1 : list) {
                    if ((list1.getCliente().getId() + "").contains(search)) {
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
