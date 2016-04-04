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
        pnlDatos = new javax.swing.JPanel();
        txtFechaNacimiento = new javax.swing.JTextField();
        combobxSexoBecado = new javax.swing.JComboBox();
        combobxCivilBecado = new javax.swing.JComboBox();
        comboBxTrabajaBecado = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        pnlCorreos = new javax.swing.JPanel();
        pnlCorreo1 = new javax.swing.JPanel();
        txtCorreoBecario = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        pnlCorreo2 = new javax.swing.JPanel();
        txtCorreoBecario2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        pnlDatosFamiliares = new javax.swing.JTabbedPane();
        pnlDatosEscolares = new javax.swing.JTabbedPane();
        pnlDatosdeCobranza = new javax.swing.JTabbedPane();

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

        txtFolio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFolio.setText("Folio");
        txtFolio.setToolTipText("");
        txtFolio.setSelectionStart(0);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Estatus:");

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

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Nombre(s)");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Ap Paterno");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Ap Materno");

        javax.swing.GroupLayout pnlNombresLayout = new javax.swing.GroupLayout(pnlNombres);
        pnlNombres.setLayout(pnlNombresLayout);
        pnlNombresLayout.setHorizontalGroup(
            pnlNombresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNombresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txtApPaternoBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(txtApMaternoBecado, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNombresLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(159, 159, 159)
                .addComponent(jLabel22)
                .addGap(66, 66, 66))
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
        );

        pnlDatosGenerales.add(pnlNombres);

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
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
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
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pnlDatosGenerales.add(pnlDatos);

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
            .addGap(0, 100, Short.MAX_VALUE)
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

        btnRegistrar.setText("Registrar Becario");
        btnRegistrar.setPreferredSize(new java.awt.Dimension(160, 29));
        pnlBotones.add(btnRegistrar);

        pnlDatosGenerales.add(pnlBotones);

        tbpBecados.addTab("Datos Generales", pnlDatosGenerales);
        tbpBecados.addTab("Datos Familiares", pnlDatosFamiliares);
        tbpBecados.addTab("Datos Escolares", pnlDatosEscolares);
        tbpBecados.addTab("Datos de Cobranza", pnlDatosdeCobranza);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpBecados, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpBecados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegistrar;
    protected javax.swing.JComboBox comboBoxPrograma;
    protected javax.swing.JComboBox comboBxTrabajaBecado;
    protected javax.swing.JComboBox combobxCivilBecado;
    protected javax.swing.JComboBox combobxSexoBecado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCorreo1;
    private javax.swing.JPanel pnlCorreo2;
    private javax.swing.JPanel pnlCorreos;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JTabbedPane pnlDatosEscolares;
    private javax.swing.JTabbedPane pnlDatosFamiliares;
    private javax.swing.JPanel pnlDatosGenerales;
    private javax.swing.JTabbedPane pnlDatosdeCobranza;
    private javax.swing.JPanel pnlNombres;
    private javax.swing.JPanel pnlPrograma;
    private javax.swing.JTabbedPane tbpBecados;
    protected javax.swing.JTextField txtApMaternoBecado;
    protected javax.swing.JTextField txtApPaternoBecado;
    protected javax.swing.JTextField txtCorreoBecario;
    private javax.swing.JTextField txtCorreoBecario2;
    protected javax.swing.JTextField txtEstatus;
    protected javax.swing.JTextField txtFechaNacimiento;
    protected javax.swing.JTextField txtFolio;
    protected javax.swing.JTextField txtNombreBecado;
    // End of variables declaration//GEN-END:variables
}
