/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import Modelo.Clientes.Cliente;
import clases.otro;
import controlador.ClienteControlador;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian y Reyman
 */
public class ClienteBuscaView extends javax.swing.JDialog {

    private ClienteControlador clienteController;
    private ClientesView vista;

    public ClienteBuscaView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        // Crear la vista de ClientesView
        vista = new ClientesView(parent, modal);

        // Inicializar el controlador con la vista correcta
        clienteController = new ClienteControlador(vista);

        // Cargar los datos
        clienteController.readAll();

        // Copiar los datos de la tabla de ClientesView a esta tabla
        copiarDatosDeTabla(vista.getTblColaborador());
    }
    // Método para copiar los datos de una tabla a otra

    private Cliente clienteSeleccionado;

    public void setClienteSeleccionado(Cliente cliente) {
        this.clienteSeleccionado = cliente;
    }

    public Cliente getClienteSeleccionado() {
        return this.clienteSeleccionado;
    }

    private void copiarDatosDeTabla(JTable tablaOrigen) {
        DefaultTableModel modelOrigen = (DefaultTableModel) tablaOrigen.getModel();
        DefaultTableModel modelDestino = (DefaultTableModel) tblClient.getModel();

        // Limpiar la tabla destino
        modelDestino.setRowCount(0);

        // Copiar todas las filas
        for (int i = 0; i < modelOrigen.getRowCount(); i++) {
            Object[] fila = new Object[modelOrigen.getColumnCount()];
            for (int j = 0; j < modelOrigen.getColumnCount(); j++) {
                fila[j] = modelOrigen.getValueAt(i, j);
            }
            modelDestino.addRow(fila);
        }
    }

    public JTable getTblClient() {
        return tblClient;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClient = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBuscar.setText("Buscar:");

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        tblClient.setAutoCreateRowSorter(true);
        tblClient.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre Completo", "Dirección", "Teléfono", "Correo"
            }
        ));
        tblClient.getTableHeader().setReorderingAllowed(false);
        tblClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClientMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblClient);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(btnSeleccionar)
                .addGap(68, 68, 68))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
//        String query = txtBuscar.getText();
//        clienteController.searchClientes(query);

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int row = tblClient.getSelectedRow();
        if (row != -1) {
            // Obtener los datos de la fila seleccionada
            String cedula = tblClient.getValueAt(row, 0).toString();
            String nombreCompleto = tblClient.getValueAt(row, 1).toString();
            String direccion = tblClient.getValueAt(row, 2).toString(); // Obtén la dirección de la tabla
            String telefono = tblClient.getValueAt(row, 3).toString(); // Obtén el teléfono de la tabla

            // Crear un objeto Cliente con todos los datos
            clienteSeleccionado = new Cliente(cedula, nombreCompleto, direccion, telefono, "");

            // Cerrar la ventana
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente",
                    "Error", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void tblClientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientMousePressed
//        if (evt.getClickCount() == 1) {
//            int row = tblClient.getSelectedRow();  // Obtiene la fila seleccionada
//            txtCedula.setText(String.valueOf(tblClient.getValueAt(row, 0)));
//            txtNombreCompl.setText(String.valueOf(tblClient.getValueAt(row, 1)));
//            txtDireccion.setText(String.valueOf(tblClient.getValueAt(row, 2)));
//            txtTelefono.setText(String.valueOf(tblClient.getValueAt(row, 3)));
//            txtEmail.setText(String.valueOf(tblClient.getValueAt(row, 4)));
//
//        }
    }//GEN-LAST:event_tblClientMousePressed

   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteBuscaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteBuscaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteBuscaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteBuscaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClienteBuscaView dialog = new ClienteBuscaView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JTable tblClient;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
