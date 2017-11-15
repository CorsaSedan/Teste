/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Business.Ped_ProdBusiness;
import Business.PedidoBusiness;
import java.awt.event.KeyEvent;
import java.util.List;
import model.Ped_Prod;
import model.Pedido;
import tablemodel.GenericTableModel;
import tablemodel.PedidoTableModel;

/**
 *
 * @author cristhian_anacleto
 */
public class TelaPedido extends javax.swing.JInternalFrame {

    private GenericTableModel gtmPedido;
    private TelaPrincipal telaPrincipal;
    private List<Pedido> pedidosFiltered;
    private List<Pedido> pedidos = PedidoBusiness.findAll();
    
    /**
     * Creates new form TelaCliente
     */
    public TelaPedido(TelaPrincipal telaPrincipal) {
        initComponents();
        gtmPedido = new PedidoTableModel(Pedido.class, new String[]{"id", "cliente", "data do pedido", "status"});
        gtmPedido.setObjectList(pedidos);
        pedidosFiltered = pedidos;
        jTable1.setModel(gtmPedido);
        
        this.telaPrincipal = telaPrincipal;
    }

    public TelaPrincipal getTelaPrincipal() {
        return telaPrincipal;
    }
    
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox();
        txtBusca = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pedido");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnExcluir.setText("Desativar");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jButton2.setText("Novo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Nome do Cliente", "ID do Cliente" }));
        comboBox.setSelectedIndex(1);
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaKeyPressed(evt);
            }
        });

        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/magnifier.png"))); // NOI18N
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });
        btnBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscaKeyPressed(evt);
            }
        });

        btnVisualizar.setText("Visualizar");
        btnVisualizar.setEnabled(false);
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVisualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusca))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnVisualizar)
                    .addComponent(jButton2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void resetaTabela() {
        gtmPedido.setObjectList(pedidos);
    }
    
    public void atualizaTabela() {
        gtmPedido.setObjectList(pedidosFiltered);
    }
    
    public void buscar() {
        btnBuscaActionPerformed(null);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new NovoPedidoCliente(null, true, this).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        Pedido pedido = (Pedido) gtmPedido.getObjectList().get(jTable1.getSelectedRow());
        if (pedido.getStatus().equals("ativado")) {
            PedidoBusiness.disable(pedido);
        } else {
            PedidoBusiness.enable(pedido);
        }
        buscar();

        btnExcluir.setEnabled(false);
        btnVisualizar.setEnabled(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        Pedido pedido = (Pedido) gtmPedido.getObjectList().get(jTable1.getSelectedRow());
        if (pedido.getStatus().equals("desativado")) {
            btnExcluir.setText("Ativar");
        } else {
            btnExcluir.setText("Desativar");
        }
        
        btnVisualizar.setEnabled(true);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        // TODO add your handling code here:
        Pedido pedido = (Pedido) gtmPedido.getObjectList().get(jTable1.getSelectedRow());
        List<Ped_Prod> pedProds = Ped_ProdBusiness.findByPedido(pedido);
        
        new VisualizarPedido(null, true, pedido, pedProds).setVisible(true);
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        // TODO add your handling code here:
        jTable1.clearSelection();
        btnExcluir.setEnabled(false);
        btnVisualizar.setEnabled(false);
        
        String search = txtBusca.getText();
        String type;
        
        switch (comboBox.getSelectedIndex()) {
            case 0:
                type = "id";
                break;
            case 1:
                type = "nome do cliente";
                break;
            case 2:
                type = "id do cliente";
                break;
            default:
                throw new AssertionError();
        }
        
        pedidosFiltered = Pedido.filter(pedidos, type, search);
        atualizaTabela();
        
//        if (search.isEmpty()) {
//            atualizaTabela();
//        } else {
//            List<Pedido> result = PedidoBusiness.search(search, type);
//            gtmPedido.setObjectList(result);
//        }
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscaActionPerformed(null);
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void btnBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscaActionPerformed(null);
        }
    }//GEN-LAST:event_btnBuscaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox comboBox;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}