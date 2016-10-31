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
public class VistaPanelPrincipal extends javax.swing.JFrame {
    
    PrincipalControlador controlador;

    /**
     * Creates new form VistaPanelPrincipal
     */
    public VistaPanelPrincipal(PrincipalControlador controlador) {
        initComponents();
        this.controlador = controlador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollpnlOpciones = new javax.swing.JScrollPane();
        pnlOpciones = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBecarios = new javax.swing.JButton();
        btnKardex = new javax.swing.JButton();
        btnCobranza = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        btnBusqueda = new javax.swing.JButton();
        btnCatalogos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Control de Becas");
        setMinimumSize(new java.awt.Dimension(940, 558));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        ScrollpnlOpciones.setPreferredSize(new java.awt.Dimension(916, 584));

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2138, Short.MAX_VALUE)
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1701, Short.MAX_VALUE)
        );

        ScrollpnlOpciones.setViewportView(pnlOpciones);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SIBEC");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        btnBecarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBecarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/REGISTRO.png"))); // NOI18N
        btnBecarios.setToolTipText("REGISTRO DE BECARIO");
        btnBecarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBecarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBecariosActionPerformed(evt);
            }
        });

        btnKardex.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnKardex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/kardex.png"))); // NOI18N
        btnKardex.setToolTipText("REGISTRO DE KARDEX");
        btnKardex.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKardex.setMaximumSize(new java.awt.Dimension(29, 29));
        btnKardex.setMinimumSize(new java.awt.Dimension(29, 29));
        btnKardex.setPreferredSize(new java.awt.Dimension(29, 29));
        btnKardex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKardexActionPerformed(evt);
            }
        });

        btnCobranza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCobranza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cobranza.png"))); // NOI18N
        btnCobranza.setToolTipText("COBRANZA BECARIOS");
        btnCobranza.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCobranza.setMaximumSize(new java.awt.Dimension(29, 29));
        btnCobranza.setMinimumSize(new java.awt.Dimension(29, 29));
        btnCobranza.setPreferredSize(new java.awt.Dimension(29, 29));
        btnCobranza.setVerifyInputWhenFocusTarget(false);
        btnCobranza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobranzaActionPerformed(evt);
            }
        });

        btnReportes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.png"))); // NOI18N
        btnReportes.setToolTipText("REPORTES GENERALES");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busqueda.png"))); // NOI18N
        btnBusqueda.setToolTipText("BUSQUEDA DE BECARIOS");
        btnBusqueda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        btnCatalogos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCatalogos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/catalogo.png"))); // NOI18N
        btnCatalogos.setToolTipText("CATALOGOS DEL SISTEMA");
        btnCatalogos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCatalogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCatalogos, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(btnBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnCobranza, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKardex, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBecarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBecarios, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKardex, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCobranza, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCatalogos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ScrollpnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScrollpnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 1163, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.cerrarSesion();
    }//GEN-LAST:event_formWindowClosing

    private void btnBecariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBecariosActionPerformed
        controlador.creaVistaRegistro();
    }//GEN-LAST:event_btnBecariosActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        controlador.creaVistaBusqueda();
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnKardexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKardexActionPerformed
        controlador.creaVistaKardex();
    }//GEN-LAST:event_btnKardexActionPerformed

    private void btnCatalogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogosActionPerformed
        controlador.creaVistaCatalogos();
    }//GEN-LAST:event_btnCatalogosActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        controlador.creaVistaReportes();
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnCobranzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobranzaActionPerformed
        controlador.creaVistaCobranza();
    }//GEN-LAST:event_btnCobranzaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JScrollPane ScrollpnlOpciones;
    private javax.swing.JButton btnBecarios;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnCatalogos;
    private javax.swing.JButton btnCobranza;
    private javax.swing.JButton btnKardex;
    private javax.swing.JButton btnReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    protected javax.swing.JPanel pnlOpciones;
    // End of variables declaration//GEN-END:variables
}
