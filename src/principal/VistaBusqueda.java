/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javax.swing.JOptionPane;

/**
 *
 * @author sabagip
 */
public class VistaBusqueda extends javax.swing.JPanel {
    
    PrincipalControlador controlador;

    public void setControlador(PrincipalControlador controlador) {
        this.controlador = controlador;
    }

    /**
     * Creates new form VistaBuscar
     */
    public VistaBusqueda() {
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

        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        PnlBuscaPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PnlBuscaFolio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumFolio = new javax.swing.JTextField();
        btnBuscarPorFolio = new javax.swing.JButton();
        PnlBuscaProgramaEstatus = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbPrograma = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        CmbboxBuscaEstatus = new javax.swing.JComboBox();
        btnBuscarPorProgEstatus = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txtAPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAMaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscarPorNombre = new javax.swing.JButton();
        PnlBuscarFechas = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbSemestreRegistro = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cmbMesGraduacion = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cmbAnioRegistro = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cmbanioGraduacion = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        pnlEvaluado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultadoBusqueda = new javax.swing.JTable();
        btnCargarBecario = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(916, 584));
        setPreferredSize(new java.awt.Dimension(916, 584));

        jPanel4.setBackground(new java.awt.Color(0, 0, 255));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Criterios de búsqueda");
        jLabel6.setMaximumSize(new java.awt.Dimension(905, 28));
        jLabel6.setPreferredSize(new java.awt.Dimension(905, 28));
        jPanel4.add(jLabel6);

        add(jPanel4);

        PnlBuscaFolio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Número de Folio: ");

        txtNumFolio.setPreferredSize(new java.awt.Dimension(120, 27));

        btnBuscarPorFolio.setText("Buscar");
        btnBuscarPorFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorFolioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlBuscaFolioLayout = new javax.swing.GroupLayout(PnlBuscaFolio);
        PnlBuscaFolio.setLayout(PnlBuscaFolioLayout);
        PnlBuscaFolioLayout.setHorizontalGroup(
            PnlBuscaFolioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlBuscaFolioLayout.createSequentialGroup()
                .addGroup(PnlBuscaFolioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlBuscaFolioLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PnlBuscaFolioLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnBuscarPorFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        PnlBuscaFolioLayout.setVerticalGroup(
            PnlBuscaFolioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlBuscaFolioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PnlBuscaFolioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarPorFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        PnlBuscaProgramaEstatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlBuscaProgramaEstatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Programa: ");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PnlBuscaProgramaEstatus.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 66, 27));

        cmbPrograma.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        PnlBuscaProgramaEstatus.add(cmbPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Estatus :");
        PnlBuscaProgramaEstatus.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 66, 27));

        CmbboxBuscaEstatus.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        PnlBuscaProgramaEstatus.add(CmbboxBuscaEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 150, -1));

        btnBuscarPorProgEstatus.setText("Buscar");
        btnBuscarPorProgEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorProgEstatusActionPerformed(evt);
            }
        });
        PnlBuscaProgramaEstatus.add(btnBuscarPorProgEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 89, 27));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAPaterno.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtAPaterno.setPreferredSize(new java.awt.Dimension(120, 27));
        jPanel6.add(txtAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 26, 140, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Paterno");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, -1, 20));

        txtAMaterno.setPreferredSize(new java.awt.Dimension(120, 27));
        jPanel6.add(txtAMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 24, 140, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Materno");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 43, -1, 20));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtNombre.setPreferredSize(new java.awt.Dimension(120, 27));
        jPanel6.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 320, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre ");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        btnBuscarPorNombre.setText("Buscar");
        btnBuscarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorNombreActionPerformed(evt);
            }
        });
        jPanel6.add(btnBuscarPorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 90, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(PnlBuscaFolio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(PnlBuscaProgramaEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PnlBuscaProgramaEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnlBuscaFolio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        PnlBuscarFechas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PnlBuscarFechas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("Semestre Registro:");
        PnlBuscarFechas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, 19));

        cmbSemestreRegistro.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmbSemestreRegistro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        PnlBuscarFechas.add(cmbSemestreRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 116, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setText("Semestre Graduación:");
        PnlBuscarFechas.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        cmbMesGraduacion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmbMesGraduacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        PnlBuscarFechas.add(cmbMesGraduacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 117, 20));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PnlBuscarFechas.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel11.setText("Año:");
        PnlBuscarFechas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        cmbAnioRegistro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));
        PnlBuscarFechas.add(cmbAnioRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 110, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setText("Año:");
        PnlBuscarFechas.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, -1, -1));

        cmbanioGraduacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));
        PnlBuscarFechas.add(cmbanioGraduacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 117, 20));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado de la búsqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(928, 197));

        pnlEvaluado.setLayout(new javax.swing.BoxLayout(pnlEvaluado, javax.swing.BoxLayout.LINE_AXIS));

        tblResultadoBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ap. Paterno", "Ap. Materno", "Nombre(s)", "Folio", "Carrera", "Universidad", "Beca Total", "Beca Semestral", "Fecha Inicio", "Fecha Graduación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblResultadoBusqueda.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblResultadoBusqueda);
        if (tblResultadoBusqueda.getColumnModel().getColumnCount() > 0) {
            tblResultadoBusqueda.getColumnModel().getColumn(0).setMinWidth(100);
            tblResultadoBusqueda.getColumnModel().getColumn(0).setPreferredWidth(120);
            tblResultadoBusqueda.getColumnModel().getColumn(0).setMaxWidth(150);
            tblResultadoBusqueda.getColumnModel().getColumn(1).setMinWidth(100);
            tblResultadoBusqueda.getColumnModel().getColumn(1).setPreferredWidth(120);
            tblResultadoBusqueda.getColumnModel().getColumn(1).setMaxWidth(150);
            tblResultadoBusqueda.getColumnModel().getColumn(2).setMinWidth(100);
            tblResultadoBusqueda.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblResultadoBusqueda.getColumnModel().getColumn(2).setMaxWidth(150);
            tblResultadoBusqueda.getColumnModel().getColumn(3).setMinWidth(100);
            tblResultadoBusqueda.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblResultadoBusqueda.getColumnModel().getColumn(3).setMaxWidth(150);
            tblResultadoBusqueda.getColumnModel().getColumn(4).setMinWidth(150);
            tblResultadoBusqueda.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblResultadoBusqueda.getColumnModel().getColumn(4).setMaxWidth(200);
            tblResultadoBusqueda.getColumnModel().getColumn(5).setMinWidth(150);
            tblResultadoBusqueda.getColumnModel().getColumn(5).setPreferredWidth(200);
            tblResultadoBusqueda.getColumnModel().getColumn(5).setMaxWidth(250);
            tblResultadoBusqueda.getColumnModel().getColumn(6).setMinWidth(100);
            tblResultadoBusqueda.getColumnModel().getColumn(6).setPreferredWidth(120);
            tblResultadoBusqueda.getColumnModel().getColumn(6).setMaxWidth(150);
            tblResultadoBusqueda.getColumnModel().getColumn(7).setMinWidth(100);
            tblResultadoBusqueda.getColumnModel().getColumn(7).setPreferredWidth(120);
            tblResultadoBusqueda.getColumnModel().getColumn(7).setMaxWidth(150);
            tblResultadoBusqueda.getColumnModel().getColumn(8).setMinWidth(150);
            tblResultadoBusqueda.getColumnModel().getColumn(8).setPreferredWidth(170);
            tblResultadoBusqueda.getColumnModel().getColumn(8).setMaxWidth(200);
            tblResultadoBusqueda.getColumnModel().getColumn(9).setMinWidth(150);
            tblResultadoBusqueda.getColumnModel().getColumn(9).setPreferredWidth(170);
            tblResultadoBusqueda.getColumnModel().getColumn(9).setMaxWidth(200);
        }

        pnlEvaluado.add(jScrollPane1);

        btnCargarBecario.setText("Cargar Becario");
        btnCargarBecario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarBecarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCargarBecario)
                .addGap(377, 377, 377))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlEvaluado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addComponent(btnCargarBecario)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlEvaluado, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PnlBuscaPrincipalLayout = new javax.swing.GroupLayout(PnlBuscaPrincipal);
        PnlBuscaPrincipal.setLayout(PnlBuscaPrincipalLayout);
        PnlBuscaPrincipalLayout.setHorizontalGroup(
            PnlBuscaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlBuscaPrincipalLayout.createSequentialGroup()
                .addGroup(PnlBuscaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnlBuscarFechas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlBuscaPrincipalLayout.setVerticalGroup(
            PnlBuscaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlBuscaPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlBuscarFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(PnlBuscaPrincipal);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuscarPorFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorFolioActionPerformed
        if(txtNumFolio.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Debes de ingresar un número de folio", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            controlador.getInfoBecarioPorFolio(txtNumFolio.getText());
        }
    }//GEN-LAST:event_btnBuscarPorFolioActionPerformed

    private void btnBuscarPorProgEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorProgEstatusActionPerformed
        controlador.getInfoBecarioPorProgramaEstatus(cmbPrograma.getSelectedItem().toString(), CmbboxBuscaEstatus.getSelectedItem().toString());
    }//GEN-LAST:event_btnBuscarPorProgEstatusActionPerformed

    private void btnBuscarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorNombreActionPerformed
        controlador.getInfoBecarioPorNombre(txtNombre.getText(), txtAPaterno.getText(), txtAMaterno.getText());
    }//GEN-LAST:event_btnBuscarPorNombreActionPerformed

    private void btnCargarBecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarBecarioActionPerformed
        controlador.getInfoBecarioPorTablaBusqueda();
    }//GEN-LAST:event_btnCargarBecarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JComboBox CmbboxBuscaEstatus;
    protected javax.swing.JPanel PnlBuscaFolio;
    private javax.swing.JPanel PnlBuscaPrincipal;
    private javax.swing.JPanel PnlBuscaProgramaEstatus;
    private javax.swing.JPanel PnlBuscarFechas;
    protected javax.swing.JButton btnBuscarPorFolio;
    protected javax.swing.JButton btnBuscarPorNombre;
    protected javax.swing.JButton btnBuscarPorProgEstatus;
    private javax.swing.JButton btnCargarBecario;
    protected javax.swing.JComboBox cmbAnioRegistro;
    protected javax.swing.JComboBox cmbMesGraduacion;
    protected javax.swing.JComboBox cmbPrograma;
    protected javax.swing.JComboBox cmbSemestreRegistro;
    protected javax.swing.JComboBox cmbanioGraduacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlEvaluado;
    protected javax.swing.JTable tblResultadoBusqueda;
    protected javax.swing.JTextField txtAMaterno;
    protected javax.swing.JTextField txtAPaterno;
    protected javax.swing.JTextField txtNombre;
    protected javax.swing.JTextField txtNumFolio;
    // End of variables declaration//GEN-END:variables
}
