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
public class PnlHermanos extends javax.swing.JPanel {
    
    PrincipalControlador controlador;

    public void setControlador(PrincipalControlador controlador) {
        this.controlador = controlador;
    }

    /**
     * Creates new form pnlHermanos
     */
    public PnlHermanos() {
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
        lblParentesco1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblParentesco5 = new javax.swing.JLabel();
        txtNombresPariente = new javax.swing.JTextField();
        txtApPaternoPariente = new javax.swing.JTextField();
        txtApMaternoPariente = new javax.swing.JTextField();
        cmbNivelEstudiosHermano = new javax.swing.JComboBox();
        lblAgregarParentesco = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(707, 68));

        jPanel1.setLayout(new java.awt.GridLayout(2, 4, 10, 0));

        lblParentesco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco1.setText("Nombre(s)");
        jPanel1.add(lblParentesco1);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Ap Paterno");
        jPanel1.add(jLabel21);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Ap Materno");
        jPanel1.add(jLabel22);

        lblParentesco5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco5.setText("Nivel de Estudios");
        jPanel1.add(lblParentesco5);
        jPanel1.add(txtNombresPariente);
        jPanel1.add(txtApPaternoPariente);
        jPanel1.add(txtApMaternoPariente);

        jPanel1.add(cmbNivelEstudiosHermano);

        lblAgregarParentesco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregarParentesco.setText("Add");
        lblAgregarParentesco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAgregarParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAgregarParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JComboBox cmbNivelEstudiosHermano;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAgregarParentesco;
    private javax.swing.JLabel lblParentesco1;
    private javax.swing.JLabel lblParentesco5;
    private javax.swing.JTextField txtApMaternoPariente;
    private javax.swing.JTextField txtApPaternoPariente;
    private javax.swing.JTextField txtNombresPariente;
    // End of variables declaration//GEN-END:variables
}
