/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

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
        txtNombresPariente = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtApPaternoPariente = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtApMaternoPariente = new javax.swing.JTextField();
        lblParentesco5 = new javax.swing.JLabel();
        cmbNivelEstudiosHermano = new javax.swing.JComboBox();
        lblAgregarParentesco = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(680, 80));

        jPanel1.setLayout(new java.awt.GridLayout(2, 4, 10, 0));

        lblParentesco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco1.setText("Nombre(s)");
        jPanel1.add(lblParentesco1);
        jPanel1.add(txtNombresPariente);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Ap Paterno");
        jPanel1.add(jLabel21);
        jPanel1.add(txtApPaternoPariente);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Ap Materno");
        jPanel1.add(jLabel22);
        jPanel1.add(txtApMaternoPariente);

        lblParentesco5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco5.setText("Nivel de Estudios");
        jPanel1.add(lblParentesco5);

        jPanel1.add(cmbNivelEstudiosHermano);

        lblAgregarParentesco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregarParentesco.setText("Add");
        lblAgregarParentesco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAgregarParentesco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarParentescoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAgregarParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgregarParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblAgregarParentescoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarParentescoMouseClicked
        controlador.agregaJPanel(this);
    }//GEN-LAST:event_lblAgregarParentescoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox cmbNivelEstudiosHermano;
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
