/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

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
        pnlNombres = new javax.swing.JPanel();
        txtNombreBecado = new javax.swing.JTextField();
        txtApPaternoBecado = new javax.swing.JTextField();
        txtApMaternoBecado = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblFotografia = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        txtFechaNacimiento = new javax.swing.JTextField();
        combobxSexoBecado = new javax.swing.JComboBox();
        combobxCivilBecado = new javax.swing.JComboBox();
        comboBxTrabajaBecado = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnFotografia = new javax.swing.JButton();
        spnlDirecciones = new javax.swing.JScrollPane();
        pnlDirecciones = new javax.swing.JPanel();
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
        pnlDatosFamiliares = new javax.swing.JPanel();
        spnlParentesco = new javax.swing.JScrollPane();
        pnlParentesco = new javax.swing.JPanel();
        spnlHermanos = new javax.swing.JScrollPane();
        pnlHermanos = new javax.swing.JPanel();
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
        spnlHijos = new javax.swing.JScrollPane();
        pnlHijos = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(916, 584));

        tbpBecados.setMaximumSize(new java.awt.Dimension(743, 454));
        tbpBecados.setMinimumSize(new java.awt.Dimension(450, 274));
        tbpBecados.setPreferredSize(new java.awt.Dimension(697, 584));

        pnlDatosGenerales.setMaximumSize(new java.awt.Dimension(743, 548));
        pnlDatosGenerales.setPreferredSize(new java.awt.Dimension(743, 548));

        pnlPrograma.setPreferredSize(new java.awt.Dimension(707, 65));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Programa:");

        comboBoxPrograma.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Folio:");

        txtFolio.setEditable(false);
        txtFolio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFolio.setText("Folio");
        txtFolio.setToolTipText("");
        txtFolio.setSelectionStart(0);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Estatus:");

        txtEstatus.setEditable(false);
        txtEstatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEstatus.setText("Estatus");
        txtEstatus.setSelectionStart(0);

        javax.swing.GroupLayout pnlProgramaLayout = new javax.swing.GroupLayout(pnlPrograma);
        pnlPrograma.setLayout(pnlProgramaLayout);
        pnlProgramaLayout.setHorizontalGroup(
            pnlProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProgramaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        pnlNombres.setPreferredSize(new java.awt.Dimension(670, 72));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Nombre(s)");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Ap Paterno");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Ap Materno");

        lblFotografia.setBackground(new java.awt.Color(0, 255, 27));
        lblFotografia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlNombresLayout = new javax.swing.GroupLayout(pnlNombres);
        pnlNombres.setLayout(pnlNombresLayout);
        pnlNombresLayout.setHorizontalGroup(
            pnlNombresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNombresLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblFotografia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(pnlNombresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNombresLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel20)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel21))
                    .addGroup(pnlNombresLayout.createSequentialGroup()
                        .addComponent(txtNombreBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtApPaternoBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(pnlNombresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNombresLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel22))
                    .addComponent(txtApMaternoBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        pnlNombresLayout.setVerticalGroup(
            pnlNombresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNombresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNombresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApPaternoBecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreBecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApMaternoBecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNombresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblFotografia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlDatosGenerales.add(pnlNombres);

        pnlDatos.setMaximumSize(new java.awt.Dimension(660, 130));
        pnlDatos.setMinimumSize(new java.awt.Dimension(660, 45));
        pnlDatos.setPreferredSize(new java.awt.Dimension(707, 75));

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

        btnFotografia.setText("Insertar Imagen");
        btnFotografia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotografiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(btnFotografia)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combobxSexoBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel25)
                        .addGap(58, 58, 58)))
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combobxCivilBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel24)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBxTrabajaBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel23)))
                .addGap(31, 31, 31))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combobxCivilBecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobxSexoBecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBxTrabajaBecado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFotografia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel23))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pnlDatosGenerales.add(pnlDatos);

        spnlDirecciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Dirección"));
        spnlDirecciones.setPreferredSize(new java.awt.Dimension(707, 115));

        pnlDirecciones.setLayout(new javax.swing.BoxLayout(pnlDirecciones, javax.swing.BoxLayout.PAGE_AXIS));
        spnlDirecciones.setViewportView(pnlDirecciones);

        pnlDatosGenerales.add(spnlDirecciones);

        pnlTelefonosBecados.setPreferredSize(new java.awt.Dimension(707, 55));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Telefono 1");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Telefono 2");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Telefono 3");

        javax.swing.GroupLayout pnlTelefonosBecadosLayout = new javax.swing.GroupLayout(pnlTelefonosBecados);
        pnlTelefonosBecados.setLayout(pnlTelefonosBecadosLayout);
        pnlTelefonosBecadosLayout.setHorizontalGroup(
            pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelefonosBecadosLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTel1Becado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelefonosBecadosLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(20, 20, 20)))
                .addGap(62, 62, 62)
                .addGroup(pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTel2Becado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelefonosBecadosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)))
                .addGap(77, 77, 77)
                .addGroup(pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTel3Becado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTelefonosBecadosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(35, 35, 35)))
                .addGap(91, 91, 91))
        );
        pnlTelefonosBecadosLayout.setVerticalGroup(
            pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTelefonosBecadosLayout.createSequentialGroup()
                .addComponent(txtTel2Becado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlTelefonosBecadosLayout.createSequentialGroup()
                .addGroup(pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTel3Becado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel1Becado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTelefonosBecadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTelefonosBecadosLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlDatosGenerales.add(pnlTelefonosBecados);

        pnlCorreos.setPreferredSize(new java.awt.Dimension(707, 85));

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
            .addGap(0, 707, Short.MAX_VALUE)
            .addGroup(pnlCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCorreosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(pnlCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlCorreosLayout.setVerticalGroup(
            pnlCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
            .addGroup(pnlCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCorreosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnlCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlDatosGenerales.add(pnlCorreos);

        pnlBotones.setPreferredSize(new java.awt.Dimension(400, 39));

        btnGuardar.setText("Guardar Datos");
        btnGuardar.setPreferredSize(new java.awt.Dimension(160, 29));
        pnlBotones.add(btnGuardar);

        pnlDatosGenerales.add(pnlBotones);

        tbpBecados.addTab("Datos Generales", pnlDatosGenerales);

        spnlParentesco.setBorder(javax.swing.BorderFactory.createTitledBorder("Padres"));
        spnlParentesco.setPreferredSize(new java.awt.Dimension(707, 125));

        pnlParentesco.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlParentesco.setLayout(new javax.swing.BoxLayout(pnlParentesco, javax.swing.BoxLayout.PAGE_AXIS));
        spnlParentesco.setViewportView(pnlParentesco);

        pnlDatosFamiliares.add(spnlParentesco);

        spnlHermanos.setBorder(javax.swing.BorderFactory.createTitledBorder("Hermanos"));
        spnlHermanos.setPreferredSize(new java.awt.Dimension(707, 160));

        pnlHermanos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlHermanos.setLayout(new javax.swing.BoxLayout(pnlHermanos, javax.swing.BoxLayout.PAGE_AXIS));
        spnlHermanos.setViewportView(pnlHermanos);

        pnlDatosFamiliares.add(spnlHermanos);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setPreferredSize(new java.awt.Dimension(707, 80));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombre completo del Conyuge");

        lblParentesco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblParentesco1.setText("Nombre(s)");

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblParentesco1))
                            .addComponent(txtNombreConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApPaternoPariente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(txtApMaternoPariente, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(317, 317, 317)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtTel3Becado1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParentesco1)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApMaternoPariente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApPaternoPariente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel3Becado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlDatosFamiliares.add(jPanel3);

        spnlHijos.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre de los Hijos"));
        spnlHijos.setPreferredSize(new java.awt.Dimension(707, 150));

        pnlHijos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlHijos.setLayout(new javax.swing.BoxLayout(pnlHijos, javax.swing.BoxLayout.PAGE_AXIS));
        spnlHijos.setViewportView(pnlHijos);

        pnlDatosFamiliares.add(spnlHijos);

        tbpBecados.addTab("Datos Familiares", pnlDatosFamiliares);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpBecados, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpBecados, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFotografiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotografiaActionPerformed
        controlador.cargaFotografia();
    }//GEN-LAST:event_btnFotografiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFotografia;
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
    private javax.swing.JPanel jPanel3;
    protected javax.swing.JLabel lblFotografia;
    private javax.swing.JLabel lblParentesco1;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCorreo1;
    private javax.swing.JPanel pnlCorreo2;
    private javax.swing.JPanel pnlCorreos;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlDatosFamiliares;
    private javax.swing.JPanel pnlDatosGenerales;
    protected javax.swing.JPanel pnlDirecciones;
    protected javax.swing.JPanel pnlHermanos;
    protected javax.swing.JPanel pnlHijos;
    private javax.swing.JPanel pnlNombres;
    protected javax.swing.JPanel pnlParentesco;
    private javax.swing.JPanel pnlPrograma;
    private javax.swing.JPanel pnlTelefonosBecados;
    protected javax.swing.JScrollPane spnlDirecciones;
    protected javax.swing.JScrollPane spnlHermanos;
    protected javax.swing.JScrollPane spnlHijos;
    protected javax.swing.JScrollPane spnlParentesco;
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
    protected javax.swing.JTextField txtNombreConyuge;
    private javax.swing.JTextField txtTel1Becado;
    private javax.swing.JTextField txtTel2Becado;
    private javax.swing.JTextField txtTel3Becado;
    protected javax.swing.JTextField txtTel3Becado1;
    // End of variables declaration//GEN-END:variables
}
