/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import adris.vistas.*;

/**
 *
 * @author Adriana
 */
public class PnlParentesco extends javax.swing.JPanel {
    
    PrincipalControlador controlador;

    public void setControlador(PrincipalControlador controlador) {
        this.controlador = controlador;
    }
    /**
     * Creates new form pnlParentesco
     */
    public PnlParentesco() {
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

        jPanel1 = new javax.swing.JPanel();
        lblParentesco = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cmbParentesco = new javax.swing.JComboBox();
        txtApPaternoPariente = new javax.swing.JTextField();
        txtApMaternoPariente = new javax.swing.JTextField();
        lblParentesco1 = new javax.swing.JLabel();
        lblParentesco2 = new javax.swing.JLabel();
        lblParentesco3 = new javax.swing.JLabel();
        txtNombresPariente = new javax.swing.JTextField();
        cmbNivelEstudiosPariente = new javax.swing.JComboBox();
        cmbTrabajoActivoPariente = new javax.swing.JComboBox();
        lblAgregarPariente = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setLayout(new java.awt.GridLayout(4, 3));

        lblParentesco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco.setText("Parentesco");
        jPanel1.add(lblParentesco);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Ap Paterno");
        jPanel1.add(jLabel21);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Ap Materno");
        jPanel1.add(jLabel22);

        jPanel1.add(cmbParentesco);
        jPanel1.add(txtApPaternoPariente);
        jPanel1.add(txtApMaternoPariente);

        lblParentesco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco1.setText("Nombre(s)");
        jPanel1.add(lblParentesco1);

        lblParentesco2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco2.setText("Nivel de Estudios");
        jPanel1.add(lblParentesco2);

        lblParentesco3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco3.setText("Trabajo Activo");
        jPanel1.add(lblParentesco3);

        txtNombresPariente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresParienteActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombresPariente);

        jPanel1.add(cmbNivelEstudiosPariente);

        cmbTrabajoActivoPariente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Si", "No" }));
        jPanel1.add(cmbTrabajoActivoPariente);

        lblAgregarPariente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregarPariente.setText("Add");
        lblAgregarPariente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAgregarPariente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAgregarPariente, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Información de padres");
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombresParienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresParienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresParienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JComboBox cmbNivelEstudiosPariente;
    protected javax.swing.JComboBox cmbParentesco;
    protected javax.swing.JComboBox cmbTrabajoActivoPariente;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAgregarPariente;
    private javax.swing.JLabel lblParentesco;
    private javax.swing.JLabel lblParentesco1;
    private javax.swing.JLabel lblParentesco2;
    private javax.swing.JLabel lblParentesco3;
    protected javax.swing.JTextField txtApMaternoPariente;
    protected javax.swing.JTextField txtApPaternoPariente;
    private javax.swing.JTextField txtNombresPariente;
    // End of variables declaration//GEN-END:variables
}
