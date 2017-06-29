/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmf.app.ui;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.hibernate.Session;
import swingdemo.framework.EntityTableModel;
import swingdemo.model.Cliente;
import swingdemo.model.Pedido;
import swingdemo.model.ProductoPedido;
import swingdemo.util.HibernateUtil;

/**
 *
 * @author marcelo
 */
public class GrillaClientes extends javax.swing.JFrame implements ListSelectionListener{

    /**
     * Creates new form GrillaClientes
     */
    EntityTableModel<Cliente> clienteTableModel;
    EntityTableModel<Pedido> pedidosTableModel;
    EntityTableModel<ProductoPedido> productoPedidosTableModel;
    
    List<Cliente> clientesList;
    List<Pedido> pedidosList;
    List<ProductoPedido> productoPedidosList;
    
    Cliente selectedCliente;
    Pedido selectedPedido;
    
    Session session;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    
    public GrillaClientes() {
        initComponents();
        //Iniciar Sesion;
        session = HibernateUtil.getSessionFactory().openSession();
        initList();
        initTable();
    }
    
    private void initTable() {
        clienteTableModel = new EntityTableModel<>(Cliente.class, new ArrayList<Cliente>());
        pedidosTableModel = new EntityTableModel<>(Pedido.class, new ArrayList<Pedido>());
        productoPedidosTableModel = new EntityTableModel<>(ProductoPedido.class, new ArrayList<ProductoPedido>());
        
        clienteTableModel.addColumn("id", "id");
        clienteTableModel.addColumn("Esta Activo?", "activo");
        clienteTableModel.addColumn("nombre", "nombre");
        clienteTableModel.addColumn("apellido", "apellido");
        clienteTableModel.addColumn("tipo", "tipo");
        clienteTableModel.setRows(clientesList);
        //Agregar columnas pedidos
        pedidosTableModel.addColumn("id", "id");
        pedidosTableModel.addColumn("nombre", "nombre");
        pedidosTableModel.setRows(pedidosList);
        
        //Agregar las columnas para Productos Pedidos
        productoPedidosTableModel.addColumn("Producto", "nombreProducto");
        productoPedidosTableModel.addColumn("Precio", "precio");
        productoPedidosTableModel.addColumn("I.V.A", "iva");
        productoPedidosTableModel.addColumn("Cantidad", "cantidad");
        productoPedidosTableModel.addColumn("Sub Total IVA", "subTotalIva");
        productoPedidosTableModel.addColumn("Sub Total", "subTotal");
        
        tablaClientes.setModel(clienteTableModel);
        tablaPedidos.setModel(pedidosTableModel);
        tablaProductoPedido.setModel(productoPedidosTableModel);
        
        
        tablaClientes.getSelectionModel().addListSelectionListener(this);
        tablaPedidos.getSelectionModel().addListSelectionListener(this);
        
    }
    
    private void initList() {
        clientesList =  session.createCriteria(Cliente.class).list();
        pedidosList = session.createCriteria(Pedido.class).list();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProductoPedido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbltotalIva = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaClientes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablaClientesPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );

        tab.addTab("tab1", jPanel1);

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaPedidos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );

        tab.addTab("tab2", jPanel2);

        tablaProductoPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaProductoPedido);

        jLabel1.setText("Total IVA [1]:");

        lbltotalIva.setText("0");

        jLabel2.setText("Sub Total[2]:");

        lblSubTotal.setText("0");

        jLabel3.setText("Total[3]:");

        lblTotal.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbltotalIva)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblSubTotal)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblTotal)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbltotalIva)
                    .addComponent(jLabel2)
                    .addComponent(lblSubTotal)
                    .addComponent(jLabel3)
                    .addComponent(lblTotal))
                .addContainerGap())
        );

        tab.addTab("tab3", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaClientesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablaClientesPropertyChange
        // TODO add your handling code here:
        if (evt.getPropertyName().equals("selectedIndex")) {
            
        }
        System.out.println("Propiedad cambiada:"+ evt.getPropertyName());
    }//GEN-LAST:event_tablaClientesPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GrillaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrillaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrillaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrillaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GrillaClientes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lbltotalIva;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTable tablaProductoPedido;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        System.out.println("valueChange1"+ e.getSource());
        System.out.println("valueChange2"+ tablaClientes);
        if (e.getSource().equals(tablaClientes.getSelectionModel()) ) {
            System.out.println("cambiando lo que muestra la otra tabla"+ e.getFirstIndex());
            if (tablaClientes.getSelectedRow() < 0) {return ;}
            selectedCliente = clienteTableModel.getItem(tablaClientes.getSelectedRow());
            //Se debe chequear que no sea null u otras cosas
            pedidosTableModel.setRows(selectedCliente.getPedidos());

            pedidosTableModel.fireTableDataChanged();
        }
        if (e.getSource().equals(tablaPedidos.getSelectionModel()) ) {
            if (tablaPedidos.getSelectedRow() < 0) {return ;}
            System.out.println("Cambio la tabla Pedidos");
            selectedPedido = pedidosTableModel.getItem(tablaPedidos.getSelectedRow());
            productoPedidosTableModel.setRows(selectedPedido.getProductoPedidos());
            productoPedidosTableModel.fireTableDataChanged();
            
            Double totalIva = 0.0;
            Double subTotal = 0.0;
            for(ProductoPedido pp : selectedPedido.getProductoPedidos()) {
                totalIva += pp.getSubTotalIva();
                subTotal += pp.getSubTotal();
            }
            
            
            lbltotalIva.setText(formatter.format(totalIva));
            lblSubTotal.setText(formatter.format(subTotal));
            lblTotal.setText(formatter.format(subTotal+totalIva));
        }
    }
}

