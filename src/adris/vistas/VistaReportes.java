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
public class VistaReportes extends javax.swing.JPanel {
    
    PrincipalControlador controlador;

    public void setControlador(PrincipalControlador controlador) {
        this.controlador = controlador;
    }
    
    /**
     * Creates new form VistaReportes
     */
    public VistaReportes() {
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
        jPnlReporteSeleccion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoReporte = new javax.swing.JComboBox();
        PnlFechasRegistro = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbMesReg = new javax.swing.JComboBox();
        cmbMesReg2 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cmbAnioReg = new javax.swing.JComboBox();
        cmbanioReg2 = new javax.swing.JComboBox();
        PnlFechasGraducion = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbMesRep3 = new javax.swing.JComboBox();
        cmbMesRep4 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cmbAnioRep2 = new javax.swing.JComboBox();
        cmbanioRep3 = new javax.swing.JComboBox();
        PnlFechasGraducion1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cmbProgramaInicial = new javax.swing.JComboBox();
        cmbProgramaFinal = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cmbEstatus = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        PnlBotonesReporte = new javax.swing.JPanel();
        btnEjectuaReporte = new javax.swing.JButton();
        BtSalir = new javax.swing.JButton();
        btnLimpiarFiltros = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbPrograma = new javax.swing.JComboBox();
        txtFolioInicial = new javax.swing.JTextField();
        txtFolioFinal = new javax.swing.JTextField();

        jPanel4.setBackground(new java.awt.Color(0, 0, 255));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Criterios de Reportes");
        jLabel6.setMaximumSize(new java.awt.Dimension(905, 28));
        jLabel6.setPreferredSize(new java.awt.Dimension(905, 28));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPnlReporteSeleccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Reporte:");

        javax.swing.GroupLayout jPnlReporteSeleccionLayout = new javax.swing.GroupLayout(jPnlReporteSeleccion);
        jPnlReporteSeleccion.setLayout(jPnlReporteSeleccionLayout);
        jPnlReporteSeleccionLayout.setHorizontalGroup(
            jPnlReporteSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnlReporteSeleccionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbTipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPnlReporteSeleccionLayout.setVerticalGroup(
            jPnlReporteSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlReporteSeleccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlReporteSeleccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PnlFechasRegistro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Mes de Registro:");

        cmbMesReg.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmbMesReg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        cmbMesReg2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmbMesReg2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("al");

        cmbAnioReg.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmbAnioReg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));

        cmbanioReg2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmbanioReg2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));

        javax.swing.GroupLayout PnlFechasRegistroLayout = new javax.swing.GroupLayout(PnlFechasRegistro);
        PnlFechasRegistro.setLayout(PnlFechasRegistroLayout);
        PnlFechasRegistroLayout.setHorizontalGroup(
            PnlFechasRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFechasRegistroLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(38, 38, 38)
                .addComponent(cmbMesReg, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(cmbAnioReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel11)
                .addGap(54, 54, 54)
                .addComponent(cmbMesReg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(cmbanioReg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        PnlFechasRegistroLayout.setVerticalGroup(
            PnlFechasRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFechasRegistroLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(PnlFechasRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnlFechasRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbMesReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbAnioReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(cmbMesReg2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbanioReg2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        PnlFechasGraducion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Mes de Graduación:");

        cmbMesRep3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmbMesRep3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        cmbMesRep4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmbMesRep4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("al");

        cmbAnioRep2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmbAnioRep2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));

        cmbanioRep3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cmbanioRep3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));

        javax.swing.GroupLayout PnlFechasGraducionLayout = new javax.swing.GroupLayout(PnlFechasGraducion);
        PnlFechasGraducion.setLayout(PnlFechasGraducionLayout);
        PnlFechasGraducionLayout.setHorizontalGroup(
            PnlFechasGraducionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFechasGraducionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(29, 29, 29)
                .addComponent(cmbMesRep3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(cmbAnioRep2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel12)
                .addGap(53, 53, 53)
                .addComponent(cmbMesRep4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(cmbanioRep3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlFechasGraducionLayout.setVerticalGroup(
            PnlFechasGraducionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFechasGraducionLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(PnlFechasGraducionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMesRep3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAnioRep2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cmbMesRep4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbanioRep3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        PnlFechasGraducion1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Programa inical:");

        cmbProgramaInicial.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        cmbProgramaFinal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("y");

        cmbEstatus.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Estatus:");

        javax.swing.GroupLayout PnlFechasGraducion1Layout = new javax.swing.GroupLayout(PnlFechasGraducion1);
        PnlFechasGraducion1.setLayout(PnlFechasGraducion1Layout);
        PnlFechasGraducion1Layout.setHorizontalGroup(
            PnlFechasGraducion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFechasGraducion1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(cmbProgramaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbProgramaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(cmbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        PnlFechasGraducion1Layout.setVerticalGroup(
            PnlFechasGraducion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlFechasGraducion1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(PnlFechasGraducion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProgramaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cmbProgramaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(cmbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnEjectuaReporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEjectuaReporte.setText("Ejecuta Reporte");
        btnEjectuaReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjectuaReporteActionPerformed(evt);
            }
        });

        BtSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtSalir.setText("Salir");
        BtSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalirActionPerformed(evt);
            }
        });

        btnLimpiarFiltros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpiarFiltros.setText("Limpiar Filtros");
        btnLimpiarFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarFiltrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlBotonesReporteLayout = new javax.swing.GroupLayout(PnlBotonesReporte);
        PnlBotonesReporte.setLayout(PnlBotonesReporteLayout);
        PnlBotonesReporteLayout.setHorizontalGroup(
            PnlBotonesReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlBotonesReporteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnEjectuaReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnLimpiarFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(BtSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        PnlBotonesReporteLayout.setVerticalGroup(
            PnlBotonesReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlBotonesReporteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PnlBotonesReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEjectuaReporte)
                    .addComponent(BtSalir)
                    .addComponent(btnLimpiarFiltros))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Folio Inicial:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Programa:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Folio Final:");

        cmbPrograma.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtFolioInicial.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtFolioFinal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtFolioFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFolioFinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(cmbPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFolioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtFolioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFolioInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFolioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jPnlReporteSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PnlFechasGraducion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PnlFechasRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PnlFechasGraducion1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(PnlBotonesReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPnlReporteSeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PnlFechasRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PnlFechasGraducion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PnlFechasGraducion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PnlBotonesReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEjectuaReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjectuaReporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEjectuaReporteActionPerformed

    private void BtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtSalirActionPerformed

    private void btnLimpiarFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarFiltrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarFiltrosActionPerformed

    private void txtFolioFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFolioFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFolioFinalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtSalir;
    private javax.swing.JPanel PnlBotonesReporte;
    private javax.swing.JPanel PnlFechasGraducion;
    private javax.swing.JPanel PnlFechasGraducion1;
    private javax.swing.JPanel PnlFechasRegistro;
    private javax.swing.JButton btnEjectuaReporte;
    private javax.swing.JButton btnLimpiarFiltros;
    protected javax.swing.JComboBox cmbAnioReg;
    protected javax.swing.JComboBox cmbAnioRep2;
    protected javax.swing.JComboBox cmbEstatus;
    protected javax.swing.JComboBox cmbMesReg;
    protected javax.swing.JComboBox cmbMesReg2;
    protected javax.swing.JComboBox cmbMesRep3;
    protected javax.swing.JComboBox cmbMesRep4;
    protected javax.swing.JComboBox cmbPrograma;
    protected javax.swing.JComboBox cmbProgramaFinal;
    protected javax.swing.JComboBox cmbProgramaInicial;
    protected javax.swing.JComboBox cmbTipoReporte;
    protected javax.swing.JComboBox cmbanioReg2;
    protected javax.swing.JComboBox cmbanioRep3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPnlReporteSeleccion;
    protected javax.swing.JTextField txtFolioFinal;
    protected javax.swing.JTextField txtFolioInicial;
    // End of variables declaration//GEN-END:variables
}
