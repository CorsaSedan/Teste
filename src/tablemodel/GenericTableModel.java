package tablemodel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class GenericTableModel<T> extends AbstractTableModel {

    protected List objectList = new ArrayList();
    protected Class objectClass;
    protected String[] columns; 
    
    public List getObjectList() {
        return objectList;
    }
    
    public void setObjectList(List objectList) {
        this.objectList = objectList;
        fireTableDataChanged();
    }

    public GenericTableModel(Class clazz) {
        objectClass = clazz;
        columns = new String[objectClass.getDeclaredFields().length];
        for (int i = 0; i < objectClass.getDeclaredFields().length; i++) {
            columns[i] = objectClass.getDeclaredFields()[i].getName();
        }
    }
    
    public GenericTableModel(Class clazz, String[] columns) {
        this(clazz);
        this.columns = columns;
    }
    
    public GenericTableModel(List objectList) {
        this(objectList.get(0).getClass());
        this.objectList = objectList;
    }

    public GenericTableModel(List objectList, String[] columns) {
        this(objectList);
        this.columns = columns;
    }

    @Override
    public int getRowCount() {
        return objectList.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    public void add(T t) {
        objectList.add(t);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void remove(T t) {
        objectList.remove(t);
        fireTableDataChanged();
    }

    public void remove(int rowIndex) {
        objectList.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void remove(int[] rowsIndexes) {
        for (int i = 0; i < rowsIndexes.length; i++) {
            remove(rowsIndexes[i] - i);
        }
    }
    
    public void add(int index, T t){
        objectList.add(index,t);
        fireTableRowsInserted(index, index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            String methodName = "get" + getColumnName(columnIndex).substring(0, 1).toUpperCase() + getColumnName(columnIndex).substring(1);
            return objectClass.getMethod(methodName).invoke(objectList.get(rowIndex));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
