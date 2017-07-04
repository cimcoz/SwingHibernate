/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingdemo.framework;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import org.hibernate.Session;
import swingdemo.model.Cliente;
import swingdemo.model.Tipo;

/**
 *
 * @author marcelo
 */
public final class ClienteTableModel extends EntityTableModel<Cliente>{
    
    
    List<Tipo> tipos;
    Session session;
    Cliente clienteSelected;
    JTable parent;
    private DefaultComboBoxModel<Tipo> comboBoxModel;
    
    public ClienteTableModel(JTable parent, Class<Cliente> entityClass, Collection<Cliente> rows , Session session) {
        super(Cliente.class, rows);
        this.session = session;
        this.parent = parent;
        initTable();
    }
    
    private void initTable() {
        
        addColumn("id", "id");
        addColumn("Esta Activo?", "activo");
        addColumn("nombre", "nombre");
        addColumn("apellido", "apellido");
        addColumn("tipo", "tipo");
        
        parent.setModel(this);
        tipos = session.createCriteria(Tipo.class).list();
        TableColumn columnaTipo = parent.getColumnModel().getColumn(4);
        //Convirtiendo la lista en array
        comboBoxModel = new DefaultComboBoxModel<Tipo>(tipos.toArray(new Tipo[tipos.size()]));
        
        JComboBox tipo = new JComboBox(comboBoxModel);
        columnaTipo.setCellEditor(new DefaultCellEditor(tipo));
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       return columnIndex > 0; 
    }
    
    

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        clienteSelected = getItem(rowIndex);
        
        if (clienteSelected == null) {return ;}
        if (columnIndex == 1) {
            clienteSelected.setActivo((Boolean)aValue);
        }
        if (columnIndex == 2) {
            clienteSelected.setNombre((String)aValue);
        }
        if (columnIndex == 3) {
            clienteSelected.setApellido((String)aValue);
        }
        if (columnIndex == 4) {
            clienteSelected.setTipo((Tipo)aValue);
        }
        //Para escuchar en el controller y poder guardar en la base de datos
        //No pasar aqui el objeto session
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    
    public void addRow(Cliente c) {
        getRows().add(c);
    }
    
    
}
