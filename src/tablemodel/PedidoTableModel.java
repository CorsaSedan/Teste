/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import model.Pedido;

/**
 *
 * @author cristhian_anacleto
 */
public class PedidoTableModel extends GenericTableModel{

    public PedidoTableModel(Class clazz) {
        super(clazz);
    }
    
    public PedidoTableModel(Class clazz, String[] columns) {
        super(clazz);
        this.columns = columns;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result;
        switch (getColumnName(columnIndex)) {
            case "data do pedido":
                result = ((Pedido)objectList.get(rowIndex)).getDataPedido();
                break;
            case "forma de pagamento":
                result = ((Pedido)objectList.get(rowIndex)).getFormaPagamento();
                break;
            default:
                result = super.getValueAt(rowIndex, columnIndex);
                break;
        }
        return result;
    }
}
