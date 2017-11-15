/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import model.Produto;

/**
 *
 * @author cristhian_anacleto
 */
public class ProdutoTableModel extends GenericTableModel {

    public ProdutoTableModel(Class clazz) {
        super(clazz);
    }
    
    public ProdutoTableModel(Class clazz, String[] columns) {
        this(clazz);
        this.columns = columns;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result;
        switch (getColumnName(columnIndex)) {
            case "preço":
                result = ((Produto)objectList.get(rowIndex)).getPrecoReferencia();
                break;
            default:
                result = super.getValueAt(rowIndex, columnIndex);
                break;
        }
        return result;
    }
}
