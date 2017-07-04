/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdemo.framework;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marcelo
 */
public class TotalesTableModel extends AbstractTableModel{
    
    String[] columnsNames = new String[]{"Total Items", "Total IVA", "Total General"};
    Totales totales = new Totales(); 
    
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnsNames[columnIndex];
    }
    
    
    public void setRows (Totales newValues){
        this.totales = newValues;
    }
    
    @Override
    public int getRowCount() {
        return 1;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
       return columnsNames.length;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {return totales.totalItems ;}
        if (columnIndex == 1) {return totales.totalIva ;}
        if (columnIndex == 2) {return totales.totalGeneral ;}
        return null;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        
        return Double.class;
    }
    
}
