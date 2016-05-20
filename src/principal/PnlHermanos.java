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
        lblAgregarHermano = new javax.swing.JLabel();
        lblBorrarHermano = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaComentario = new javax.swing.JTextPane();
        jLabel23 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(680, 80));

        jPanel1.setLayout(new java.awt.GridLayout(2, 4, 10, 0));

        lblParentesco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblParentesco1.setText("Nombre(s)");
        jPanel1.add(lblParentesco1);
        jPanel1.add(txtNombresPariente);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Ap Paterno");
        jPanel1.add(jLabel21);
        jPanel1.add(txtApPaternoPariente);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Ap Materno");
        jPanel1.add(jLabel22);
        jPanel1.add(txtApMaternoPariente);

        lblParentesco5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblParentesco5.setText("Nivel de Estudios");
        jPanel1.add(lblParentesco5);

        jPanel1.add(cmbNivelEstudiosHermano);

        lblAgregarHermano.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAgregarHermano.setText("Add");
        lblAgregarHermano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAgregarHermano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAgregarHermanoMouseClicked(evt);
            }
        });

        lblBorrarHermano.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBorrarHermano.setText("Delete");
        lblBorrarHermano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBorrarHermano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBorrarHermanoMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(txtAreaComentario);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Comentario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgregarHermano, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBorrarHermano, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAgregarHermano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBorrarHermano)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblAgregarHermanoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAgregarHermanoMouseClicked
        controlador.agregaJPanel(this);
    }//GEN-LAST:event_lblAgregarHermanoMouseClicked

    private void lblBorrarHermanoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBorrarHermanoMouseClicked
        controlador.borraJpanel(this);
    }//GEN-LAST:event_lblBorrarHermanoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JComboBox cmbNivelEstudiosHermano;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JLabel lblAgregarHermano;
    protected javax.swing.JLabel lblBorrarHermano;
    private javax.swing.JLabel lblParentesco1;
    private javax.swing.JLabel lblParentesco5;
    protected javax.swing.JTextField txtApMaternoPariente;
    protected javax.swing.JTextField txtApPaternoPariente;
    protected javax.swing.JTextPane txtAreaComentario;
    protected javax.swing.JTextField txtNombresPariente;
    // End of variables declaration//GEN-END:variables
}
