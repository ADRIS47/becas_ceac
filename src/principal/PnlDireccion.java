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
public class PnlDireccion extends javax.swing.JPanel {

    PrincipalControlador controlador;

    public void setControlador(PrincipalControlador controlador) {
        this.controlador = controlador;
    }
    
    
    /**
     * Creates new form pnlDireccion
     */
    public PnlDireccion() {
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

        jTextField5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCalleBecado = new javax.swing.JTextField();
        txtNumBecado = new javax.swing.JTextField();
        txtNumIntBecado = new javax.swing.JTextField();
        txtCPBecado = new javax.swing.JTextField();
        txtColoniaBecado = new javax.swing.JTextField();
        cmbCiudadBecado = new javax.swing.JComboBox<>();
        lblAgregarDireccion = new javax.swing.JLabel();
        lblBorrarDireccion = new javax.swing.JLabel();

        jTextField5.setText("jTextField1");

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(707, 55));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(707, 55));

        jPanel1.setLayout(new java.awt.GridLayout(2, 6));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setText("Calle");
        jPanel1.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setText("Numero");
        jPanel1.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("Int");
        jPanel1.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("C.P.");
        jPanel1.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("Colonia");
        jPanel1.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setText("Ciudad");
        jPanel1.add(jLabel6);

        txtCalleBecado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtCalleBecado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalleBecadoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCalleBecado);

        txtNumBecado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtNumBecado.setPreferredSize(new java.awt.Dimension(5, 13));
        txtNumBecado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumBecadoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumBecado);

        txtNumIntBecado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtNumIntBecado.setName("txtColonia"); // NOI18N
        jPanel1.add(txtNumIntBecado);

        txtCPBecado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel1.add(txtCPBecado);

        txtColoniaBecado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtColoniaBecado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColoniaBecadoActionPerformed(evt);
            }
        });
        jPanel1.add(txtColoniaBecado);

        cmbCiudadBecado.setMaximumSize(new java.awt.Dimension(40, 27));
        jPanel1.add(cmbCiudadBecado);

        lblAgregarDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregarDireccion.setText("Add");
        lblAgregarDireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAgregarDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarDireccionMouseClicked(evt);
            }
        });

        lblBorrarDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBorrarDireccion.setText("Delete");
        lblBorrarDireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBorrarDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBorrarDireccionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgregarDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBorrarDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblAgregarDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBorrarDireccion)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCalleBecadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalleBecadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalleBecadoActionPerformed

    private void txtNumBecadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumBecadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumBecadoActionPerformed

    private void txtColoniaBecadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColoniaBecadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColoniaBecadoActionPerformed

    private void lblAgregarDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarDireccionMouseClicked
       controlador.agregaJPanel(this);
    }//GEN-LAST:event_lblAgregarDireccionMouseClicked

    private void lblBorrarDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrarDireccionMouseClicked
        controlador.borraJpanel(this);
    }//GEN-LAST:event_lblBorrarDireccionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JComboBox<String> cmbCiudadBecado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField5;
    protected javax.swing.JLabel lblAgregarDireccion;
    protected javax.swing.JLabel lblBorrarDireccion;
    protected javax.swing.JTextField txtCPBecado;
    protected javax.swing.JTextField txtCalleBecado;
    protected javax.swing.JTextField txtColoniaBecado;
    protected javax.swing.JTextField txtNumBecado;
    protected javax.swing.JTextField txtNumIntBecado;
    // End of variables declaration//GEN-END:variables
}
