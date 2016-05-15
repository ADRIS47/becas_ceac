/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.event.ItemEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Adriana
 */
public class VistaCatalogos extends javax.swing.JPanel {
    
    PrincipalControlador controlador;
    DefaultTableModel tblModelo;
    TableColumnModel columnModel;
    JTable TblDescripcionCatalogo;
    

    public void setControlador(principal.PrincipalControlador controlador) {
        this.controlador = controlador;
    }

    /**
     * Creates new form VistaCatalogos
     */
    public VistaCatalogos() {
        this.tblModelo = new DefaultTableModel();
        tblModelo.addColumn("Nombre");
        tblModelo.addColumn("Tipo de Escuela");
        initComponents();
        
//        TblDescripcionCatalogo.setRowHeight(20);
//        TblDescripcionCatalogo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoCatalogo = new javax.swing.JComboBox();
        TxtFldDescripcionCatalogo = new javax.swing.JTextField();
        BtnAddDescripcionCatalogo = new javax.swing.JButton();
        BtnEliminarDescripcionCatalogo = new javax.swing.JButton();
        btnAgregarFila = new javax.swing.JButton();
        btnEliminarFila = new javax.swing.JButton();
        pnlTabla = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(916, 584));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("OPCIONES DE CATALOGOS DEL SISTEMA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Catálogo:");

        cmbTipoCatalogo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbTipoCatalogo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoCatalogoItemStateChanged(evt);
            }
        });

        TxtFldDescripcionCatalogo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtFldDescripcionCatalogoKeyTyped(evt);
            }
        });

        BtnAddDescripcionCatalogo.setText("Guardar");
        BtnAddDescripcionCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddDescripcionCatalogoActionPerformed(evt);
            }
        });

        BtnEliminarDescripcionCatalogo.setText("Eliminar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtFldDescripcionCatalogo)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTipoCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addComponent(BtnAddDescripcionCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnEliminarDescripcionCatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminarDescripcionCatalogo)
                    .addComponent(BtnAddDescripcionCatalogo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtFldDescripcionCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregarFila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/table_add.png"))); // NOI18N
        btnAgregarFila.setText("Agregar Fila");
        btnAgregarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFilaActionPerformed(evt);
            }
        });

        btnEliminarFila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/table_delete.png"))); // NOI18N
        btnEliminarFila.setText("Eliminar Fila");
        btnEliminarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFilaActionPerformed(evt);
            }
        });

        pnlTabla.setLayout(new javax.swing.BoxLayout(pnlTabla, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarFila)
                            .addComponent(btnEliminarFila)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnAgregarFila)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarFila))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAddDescripcionCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddDescripcionCatalogoActionPerformed
        controlador.crudCatalogo();
    }//GEN-LAST:event_BtnAddDescripcionCatalogoActionPerformed

    private void cmbTipoCatalogoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoCatalogoItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED)
            controlador.llenaCamposVistaCatalogos();
    }//GEN-LAST:event_cmbTipoCatalogoItemStateChanged

    private void btnAgregarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFilaActionPerformed
        controlador.agregarFilaTabla(TblDescripcionCatalogo);
    }//GEN-LAST:event_btnAgregarFilaActionPerformed

    private void btnEliminarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFilaActionPerformed
        controlador.eliminaFilaTabla(TblDescripcionCatalogo);
    }//GEN-LAST:event_btnEliminarFilaActionPerformed

    private void TxtFldDescripcionCatalogoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFldDescripcionCatalogoKeyTyped
        controlador.getDatosCatalogos();
    }//GEN-LAST:event_TxtFldDescripcionCatalogoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton BtnAddDescripcionCatalogo;
    protected javax.swing.JButton BtnEliminarDescripcionCatalogo;
    protected javax.swing.JTextField TxtFldDescripcionCatalogo;
    protected javax.swing.JButton btnAgregarFila;
    protected javax.swing.JButton btnEliminarFila;
    protected javax.swing.JComboBox cmbTipoCatalogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    protected javax.swing.JPanel pnlTabla;
    // End of variables declaration//GEN-END:variables
}
