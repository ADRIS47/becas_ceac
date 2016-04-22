/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adris.vistas;

import principal.*;

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
        lblParentesco1 = new javax.swing.JLabel();
        cmbParentesco = new javax.swing.JComboBox();
        txtApPaternoPariente = new javax.swing.JTextField();
        txtApMaternoPariente = new javax.swing.JTextField();
        txtNombresPariente = new javax.swing.JTextField();
        lblParentesco2 = new javax.swing.JLabel();
        lblParentesco3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbNivelEstudiosPariente = new javax.swing.JComboBox();
        cmbTrabajoActivoPariente = new javax.swing.JComboBox();
        TxtTelPariente = new javax.swing.JTextField();
        txtOcupacionPariente = new javax.swing.JTextField();
        lblAgregarPariente = new javax.swing.JLabel();

        jPanel1.setLayout(new java.awt.GridLayout(5, 3));

        lblParentesco.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblParentesco.setText("Parentesco");
        jPanel1.add(lblParentesco);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel21.setText("Ap Paterno");
        jPanel1.add(jLabel21);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel22.setText("Ap Materno");
        jPanel1.add(jLabel22);

        lblParentesco1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblParentesco1.setText("Nombre(s)");
        jPanel1.add(lblParentesco1);

        jPanel1.add(cmbParentesco);
        jPanel1.add(txtApPaternoPariente);

        txtApMaternoPariente.setName("txtApMaternoPariente"); // NOI18N
        jPanel1.add(txtApMaternoPariente);

        txtNombresPariente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresParienteActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombresPariente);

        lblParentesco2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblParentesco2.setText("Nivel de Estudios");
        jPanel1.add(lblParentesco2);

        lblParentesco3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblParentesco3.setText("Trabajo Activo");
        jPanel1.add(lblParentesco3);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setText("Telefono:");
        jPanel1.add(jLabel2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Ocupación: ");
        jPanel1.add(jLabel1);

        jPanel1.add(cmbNivelEstudiosPariente);

        cmbTrabajoActivoPariente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Si" }));
        jPanel1.add(cmbTrabajoActivoPariente);

        TxtTelPariente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTelParienteActionPerformed(evt);
            }
        });
        jPanel1.add(TxtTelPariente);
        jPanel1.add(txtOcupacionPariente);

        lblAgregarPariente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregarPariente.setText("Add");
        lblAgregarPariente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAgregarPariente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarParienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAgregarPariente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgregarPariente)
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Información de padres");
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombresParienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresParienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresParienteActionPerformed

    private void lblAgregarParienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarParienteMouseClicked
        controlador.agregaJPanel(this);
    }//GEN-LAST:event_lblAgregarParienteMouseClicked

    private void TxtTelParienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTelParienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTelParienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTextField TxtTelPariente;
    public javax.swing.JComboBox cmbNivelEstudiosPariente;
    public javax.swing.JComboBox cmbParentesco;
    public javax.swing.JComboBox cmbTrabajoActivoPariente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    protected javax.swing.JLabel lblAgregarPariente;
    private javax.swing.JLabel lblParentesco;
    private javax.swing.JLabel lblParentesco1;
    private javax.swing.JLabel lblParentesco2;
    private javax.swing.JLabel lblParentesco3;
    protected javax.swing.JTextField txtApMaternoPariente;
    protected javax.swing.JTextField txtApPaternoPariente;
    protected javax.swing.JTextField txtNombresPariente;
    private javax.swing.JTextField txtOcupacionPariente;
    // End of variables declaration//GEN-END:variables
}
