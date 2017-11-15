/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import model.Ped_Prod;

/**
 *
 * @author cristhian_anacleto
 */
public class CarrinhoTableModel extends GenericTableModel{

    public CarrinhoTableModel(Class clazz) {
        super(clazz);
    }
    
    public CarrinhoTableModel(Class clazz, String[] columns) {
        super(clazz);
        this.columns = columns;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result;
        switch (getColumnName(columnIndex)) {
            case "produto":
                result = ((Ped_Prod)objectList.get(rowIndex)).getProduto().getNome();
                break;
            case "quantidade":
                result = ((Ped_Prod)objectList.get(rowIndex)).getQuantidadeItem();
                break;
            case "preço unitário":
                result = ((Ped_Prod)objectList.get(rowIndex)).getPrecoItem();
                break;
            case "valor total":
                result = ((Ped_Prod)objectList.get(rowIndex)).getPrecoTotal();
                break;
            default:
                result = super.getValueAt(rowIndex, columnIndex);
                break;
        }
        return result;
    }
}
