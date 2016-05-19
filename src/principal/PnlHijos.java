/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import adris.vistas.*;
import principal.*;

/**
 *
 * @author Adriana
 */
public class PnlHijos extends javax.swing.JPanel {
    
    PrincipalControlador controlador;

    public void setControlador(PrincipalControlador controlador) {
        this.controlador = controlador;
    }

    /**
     * Creates new form pnlHijos
     */
    public PnlHijos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAgregarHijos = new javax.swing.JLabel();
        lblBorrarHijos = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblParentesco1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNombreHIjo = new javax.swing.JTextField();
        txtApPaternoHijo = new javax.swing.JTextField();
        txtApMaternoHijo = new javax.swing.JTextField();
        cmbEdadHijo = new javax.swing.JComboBox();

        setMinimumSize(new java.awt.Dimension(460, 46));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(999, 60));

        lblAgregarHijos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregarHijos.setText("Add");
        lblAgregarHijos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAgregarHijos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarHijosMouseClicked(evt);
            }
        });

        lblBorrarHijos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBorrarHijos.setText("Delete");
        lblBorrarHijos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBorrarHijos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBorrarHijosMouseClicked(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(0, 77));
        jPanel1.setLayout(new java.awt.GridLayout(2, 4));

        lblParentesco1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblParentesco1.setText("Nombre(s)");
        jPanel1.add(lblParentesco1);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel21.setText("Ap Paterno");
        jPanel1.add(jLabel21);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel22.setText("Ap Materno");
        jPanel1.add(jLabel22);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel23.setText("Edad");
        jPanel1.add(jLabel23);

        txtNombreHIjo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtNombreHIjo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreHIjoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreHIjo);

        txtApPaternoHijo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel1.add(txtApPaternoHijo);

        txtApMaternoHijo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel1.add(txtApMaternoHijo);

        cmbEdadHijo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmbEdadHijo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100" }));
        jPanel1.add(cmbEdadHijo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBorrarHijos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAgregarHijos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAgregarHijos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBorrarHijos))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreHIjoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreHIjoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreHIjoActionPerformed

    private void lblAgregarHijosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarHijosMouseClicked
        controlador.agregaJPanel(this);
    }//GEN-LAST:event_lblAgregarHijosMouseClicked

    private void lblBorrarHijosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrarHijosMouseClicked
        controlador.borraJpanel(this);
    }//GEN-LAST:event_lblBorrarHijosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JComboBox cmbEdadHijo;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    protected javax.swing.JLabel lblAgregarHijos;
    protected javax.swing.JLabel lblBorrarHijos;
    private javax.swing.JLabel lblParentesco1;
    protected javax.swing.JTextField txtApMaternoHijo;
    protected javax.swing.JTextField txtApPaternoHijo;
    protected javax.swing.JTextField txtNombreHIjo;
    // End of variables declaration//GEN-END:variables
}
