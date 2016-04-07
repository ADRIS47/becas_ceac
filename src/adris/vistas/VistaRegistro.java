/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adris.vistas;

import principal.*;

/**
 *
 * @author sabagip
 */
public class VistaRegistro extends javax.swing.JPanel {

    PrincipalControlador controlador;
    /**
     * Creates new form VistaRegistro2
     */
    public VistaRegistro(PrincipalControlador controlador) {
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

        tbpBecados = new javax.swing.JTabbedPane();
        pnlDatosGenerales = new javax.swing.JPanel();
        pnlPrograma = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxPrograma = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEstatus = new javax.swing.JTextField();
        pnlDatos = new javax.swing.JPanel();
        txtFechaNacimiento = new javax.swing.JTextField();
        combobxSexoBecado = new javax.swing.JComboBox();
        combobxCivilBecado = new javax.swing.JComboBox();
        comboBxTrabajaBecado = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        pnlNombres = new javax.swing.JPanel();
        txtNombreBecado = new javax.swing.JTextField();
        txtApPaternoBecado = new javax.swing.JTextField();
        txtApMaternoBecado = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pnlTelefonosBecados = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTel1Becado = new javax.swing.JTextField();
        txtTel2Becado = new javax.swing.JTextField();
        txtTel3Becado = new javax.swing.JTextField();
        pnlCorreos = new javax.swing.JPanel();
        pnlCorreo1 = new javax.swing.JPanel();
        txtCorreoBecario = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        pnlCorreo2 = new javax.swing.JPanel();
        txtCorreoBecario2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        spnlParentesco = new javax.swing.JScrollPane();
        spnlHermanos = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblParentesco1 = new javax.swing.JLabel();
        txtNombreConyuge = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtApPaternoPariente = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtApMaternoPariente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTel3Becado1 = new javax.swing.JTextField();
        spnHijos = new javax.swing.JScrollPane();
        pnlbotones = new javax.swing.JPanel();
        lblAgregar = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(697, 584));

        tbpBecados.setMaximumSize(new java.awt.Dimension(743, 454));
        tbpBecados.setMinimumSize(new java.awt.Dimension(450, 274));
        tbpBecados.setPreferredSize(new java.awt.Dimension(743, 454));

        pnlDatosGenerales.setMaximumSize(new java.awt.Dimension(743, 548));
        pnlDatosGenerales.setPreferredSize(new java.awt.Dimension(743, 548));

        pnlPrograma.setPreferredSize(new java.awt.Dimension(707, 65));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Programa:");

        comboBoxPrograma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboBoxPrograma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Folio:");

        txtFolio.setEditable(false);
        txtFolio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFolio.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Estatus:");

        txtEstatus.setEditable(false);
        txtEstatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEstatus.setText("Becado");
        txtEstatus.setToolTipText("");

        javax.swing.GroupLayout pnlProgramaLayout = new javax.swing.GroupLayout(pnlPrograma);
        pnlPrograma.setLayout(pnlProgramaLayout);
        pnlProgramaLayout.setHorizontalGroup(
            pnlProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProgramaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        pnlProgramaLayout.setVerticalGroup(
            pnlProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProgramaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFolio)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pnlDatosGenerales.add(pnlPrograma);

        pnlDatos.setMaximumSize(new java.awt.Dimension(660, 130));
        pnlDatos.setMinimumSize(new java.awt.Dimension(660, 130));
        pnlDatos.setPreferredSize(new java.awt.Dimension(707, 85));

        txtFechaNacimiento.setText("dd/mm/aaaa");
        txtFechaNacimiento.setToolTipText("");
        txtFechaNacimiento.setSelectionStart(0);

        comboBxTrabajaBecado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trabaja", "No trabaja" }));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Trabajo Activo");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Estado Civil");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Sexo");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Fecha Nacimiento");

        pnlNombres.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlNombres.add(txtNombreBecado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 211, -1));
        pnlNombres.add(txtApPaternoBecado, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 11, 191, -1));
        pnlNombres.add(txtApMaternoBecado, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 11, 191, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Nombre(s)");
        pnlNombres.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 37, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Ap Paterno");
        pnlNombres.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 37, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Ap Materno");
        pnlNombres.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 37, -1, -1));

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel25)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(combobxSexoBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobxCivilBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel24)))
                .addGap(58, 58, 58)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel23))
                    .addComponent(comboBxTrabajaBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addComponent(pnlNombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combobxCivilBecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobxSexoBecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBxTrabajaBecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDatosGenerales.add(pnlDatos);

        pnlTelefonosBecados.setPreferredSize(new java.awt.Dimension(707, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Telefono 1");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Telefono 2");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Telefono 3");

        txtTel1Becado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTel1BecadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTelefonosBecadosLayout = new javax.swing.GroupLayout(pnlTelefonosBecados);
        pnlTelefonosBecados.setLayout(pnlTelefonosBecadosLayout);
        pnlTelefonosBecadosLayout.setHorizontalGroup(
            pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelefonosBecadosLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtTel1Becado, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTel2Becado, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(76, 76, 76)
                .addGroup(pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtTel3Becado, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        pnlTelefonosBecadosLayout.setVerticalGroup(
            pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelefonosBecadosLayout.createSequentialGroup()
                .addGroup(pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTel1Becado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel2Becado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel3Becado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDatosGenerales.add(pnlTelefonosBecados);

        pnlCorreos.setPreferredSize(new java.awt.Dimension(707, 100));

        pnlCorreo1.setPreferredSize(new java.awt.Dimension(340, 50));
        pnlCorreo1.setVerifyInputWhenFocusTarget(false);

        txtCorreoBecario.setText("correo@dominio.com");
        txtCorreoBecario.setToolTipText("");
        txtCorreoBecario.setPreferredSize(new java.awt.Dimension(335, 27));
        txtCorreoBecario.setSelectionStart(0);
        pnlCorreo1.add(txtCorreoBecario);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Correo Electrónico");
        pnlCorreo1.add(jLabel29);

        pnlCorreo2.setPreferredSize(new java.awt.Dimension(340, 50));

        txtCorreoBecario2.setText("correo@dominio.com");
        txtCorreoBecario2.setToolTipText("");
        txtCorreoBecario2.setPreferredSize(new java.awt.Dimension(335, 27));
        txtCorreoBecario2.setSelectionStart(0);
        pnlCorreo2.add(txtCorreoBecario2);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Confirmar Correo Electrónico");
        pnlCorreo2.add(jLabel30);

        javax.swing.GroupLayout pnlCorreosLayout = new javax.swing.GroupLayout(pnlCorreos);
        pnlCorreos.setLayout(pnlCorreosLayout);
        pnlCorreosLayout.setHorizontalGroup(
            pnlCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCorreosLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(pnlCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pnlCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        pnlCorreosLayout.setVerticalGroup(
            pnlCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCorreosLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addGroup(pnlCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pnlDatosGenerales.add(pnlCorreos);

        pnlBotones.setPreferredSize(new java.awt.Dimension(400, 39));

        btnGuardar.setText("Guardar Datos");
        btnGuardar.setPreferredSize(new java.awt.Dimension(160, 29));
        pnlBotones.add(btnGuardar);

        pnlDatosGenerales.add(pnlBotones);

        tbpBecados.addTab("Datos Generales", pnlDatosGenerales);

        spnlParentesco.setBorder(null);
        spnlParentesco.setPreferredSize(new java.awt.Dimension(707, 65));

        spnlHermanos.setBorder(null);
        spnlHermanos.setPreferredSize(new java.awt.Dimension(707, 65));

        jPanel3.setPreferredSize(new java.awt.Dimension(707, 65));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombre completo del Conyuge");

        lblParentesco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco1.setText("Nombre(s)");

        txtNombreConyuge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreConyugeActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Ap Paterno");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Ap Materno");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Telefono");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblParentesco1)
                    .addComponent(txtNombreConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtApPaternoPariente, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApMaternoPariente, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel27)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTel3Becado1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(514, 514, 514))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblParentesco1)
                            .addComponent(jLabel28)
                            .addComponent(jLabel27)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApMaternoPariente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApPaternoPariente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel3Becado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        spnHijos.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre de los Hijos"));
        spnHijos.setPreferredSize(new java.awt.Dimension(707, 65));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(spnlParentesco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                        .addComponent(spnlHermanos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(spnHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spnlParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnlHermanos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spnHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        tbpBecados.addTab("Datos Familiares", jPanel1);

        lblAgregar.setText("Agregar");

        javax.swing.GroupLayout pnlbotonesLayout = new javax.swing.GroupLayout(pnlbotones);
        pnlbotones.setLayout(pnlbotonesLayout);
        pnlbotonesLayout.setHorizontalGroup(
            pnlbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(715, Short.MAX_VALUE))
        );
        pnlbotonesLayout.setVerticalGroup(
            pnlbotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlbotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tbpBecados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlbotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbpBecados, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTel1BecadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTel1BecadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTel1BecadoActionPerformed

    private void txtNombreConyugeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreConyugeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreConyugeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    protected javax.swing.JComboBox comboBoxPrograma;
    protected javax.swing.JComboBox comboBxTrabajaBecado;
    protected javax.swing.JComboBox combobxCivilBecado;
    protected javax.swing.JComboBox combobxSexoBecado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAgregar;
    private javax.swing.JLabel lblParentesco1;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCorreo1;
    private javax.swing.JPanel pnlCorreo2;
    private javax.swing.JPanel pnlCorreos;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlDatosGenerales;
    private javax.swing.JPanel pnlNombres;
    private javax.swing.JPanel pnlPrograma;
    private javax.swing.JPanel pnlTelefonosBecados;
    private javax.swing.JPanel pnlbotones;
    private javax.swing.JScrollPane spnHijos;
    private javax.swing.JScrollPane spnlHermanos;
    private javax.swing.JScrollPane spnlParentesco;
    private javax.swing.JTabbedPane tbpBecados;
    protected javax.swing.JTextField txtApMaternoBecado;
    protected javax.swing.JTextField txtApMaternoPariente;
    protected javax.swing.JTextField txtApPaternoBecado;
    protected javax.swing.JTextField txtApPaternoPariente;
    protected javax.swing.JTextField txtCorreoBecario;
    private javax.swing.JTextField txtCorreoBecario2;
    protected javax.swing.JTextField txtEstatus;
    protected javax.swing.JTextField txtFechaNacimiento;
    protected javax.swing.JTextField txtFolio;
    protected javax.swing.JTextField txtNombreBecado;
    private javax.swing.JTextField txtNombreConyuge;
    private javax.swing.JTextField txtTel1Becado;
    private javax.swing.JTextField txtTel2Becado;
    private javax.swing.JTextField txtTel3Becado;
    private javax.swing.JTextField txtTel3Becado1;
    // End of variables declaration//GEN-END:variables
}
