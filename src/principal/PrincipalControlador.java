/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import crud.Conexion;
import helpers.EscuchadorCalculaBecaXSemestre;
import helpers.EscuchadorCmbBoxCambiado;
import helpers.EscuchadorValidaEntrada;
import helpers.Helper;
import helpers.Log;
import index.Index;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import pojos.Aval;
import pojos.Becario;
import pojos.DatosEscolares;
import pojos.Direccion;
import pojos.Hermanos;
import pojos.Hijos;
import pojos.Padres;
import pojos.Telefono;

/**
 *
 * @author sabagip
 */
public class PrincipalControlador {
    
    VistaPanelPrincipal vista;
    VistaRegistro vistaRegistro;
//    PnlHermanos vistaHermanos;
//    PnlHijos vistaHijos;
//    PnlParentesco vistaParentesco;
//    PnlDireccion vistaDireccion;
    PrincipalModelo modelo;
    Index controladorPrincipal;
    
    protected File fileFoto = null;
    protected File fileActaNacimiento;
    protected File fileBoleta_calificaciones_inicial;
    protected File fileCarta_solicitud;
    protected File fileEnsayo;
    protected File fileIneBecario;
    protected File fileIneAval;
    protected File fileContrato;
    protected File filePagare;
    
    Log log = new Log();
    Helper helper = new Helper();
    
    LinkedHashMap<Integer, String> catSexo = null;
    LinkedHashMap<Integer, String> catEstadoCivil = null;
    LinkedHashMap<Integer, String> catPrograma = null;
    LinkedHashMap<Integer, String> catParentesco = null;
    LinkedHashMap<Integer, String> catNivelEstudios = null;
    LinkedHashMap<Integer, String> catUniversidad = null;
    LinkedHashMap<Integer, String> catCampoEstudio = null;
    
    List<PnlHijos> lstVistaHijos = new ArrayList<>();
    List<PnlHermanos> lstVistaHermanos = new ArrayList<>();
    List<PnlParentesco> lstVistaParentesco = new ArrayList<>();
    List<PnlDireccion> lstVistaDireccion = new ArrayList<>();
    
    public static void main(String[] args) {
        PrincipalControlador prueba = new PrincipalControlador();
        prueba.iniciaPantallaPrincipal();
    }

    public void setVista(VistaPanelPrincipal vista) {
        this.vista = vista;
    }

    public void setModelo(PrincipalModelo modelo) {
        this.modelo = modelo;
    }

    public void setVistaRegistro(VistaRegistro vistaRegistro) {
        this.vistaRegistro = vistaRegistro;
    }
    
    
    
    public void iniciaPantallaPrincipal(){
        vista = new VistaPanelPrincipal(this);
        modelo = new PrincipalModelo();
        controladorPrincipal = new Index();
        
        this.setVista(vista);
        this.setModelo(modelo);
        
        vista.setVisible(true);
    }
    
    /**
     * Crea una pantalla VistaRegistro en la pantalla principal con sus respectivos datos
     */
    public void creaVistaRegistro(){
        vistaRegistro = new VistaRegistro(this);
        this.setVistaRegistro(vistaRegistro);
        List<LinkedHashMap<Integer, String>> lstCategorias = null;
                
        try {
            //Se muestran las pantallas dinamicas
            llenaPanelesVistaRegistro();
            //Se obtienen las categorias para llenar la pantalla
            lstCategorias = modelo.getCategoriasVistaRegistro();
            llenaCamposVistaRegistro(lstCategorias);
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(vista, "Error, consulta el registro de errores", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            log.crearLog(ex.getMessage());
        }
        
        addListenerTeclasVistaRegistro();
        //addListenerArchivosAdjuntos();
        //Helper.getBecaSemestral(vistaRegistro.cmboxSemestresTotalesCarrera, vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.txtBecaAutorizada, vistaRegistro.txtBecaPorSemestre);
        //Helper.getFechaGraduacion(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca, vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion, vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera);
        
        creaPantalla(vistaRegistro);
    }
    
    /**
     * Crea una pantalla dentro del panel pnlOpciones
     * @param pantalla Pantalla a agregar en el panel opciones
     */
    private void creaPantalla(Component pantalla){
        //vista.pnlOpciones.removeAll();
        //vista.pnlOpciones.add(pantalla, BorderLayout.CENTER);
        vista.ScrollpnlOpciones.setViewportView(pantalla);
        pantalla.setVisible(true);
        vista.ScrollpnlOpciones.updateUI();
        vista.ScrollpnlOpciones.validate();
        vista.repaint();
    }
    
    /**
     * Llena con los datos de las categorias la pantalla VistaRegistro
     * @param lstCategorias 
     */
    private void llenaCamposVistaRegistro(List<LinkedHashMap<Integer, String>> lstCategorias){
        //Se separan las categorias
        catSexo = lstCategorias.get(0);
        catEstadoCivil = lstCategorias.get(1);
        catPrograma = lstCategorias.get(2);
        catNivelEstudios = lstCategorias.get(3);
        catParentesco = lstCategorias.get(4);
        catUniversidad = lstCategorias.get(5);
        catCampoEstudio = lstCategorias.get(6);
        
        llenaComboCategorias(vistaRegistro.combobxCivilBecado, catEstadoCivil);
        llenaComboCategorias(vistaRegistro.comboBoxPrograma, catPrograma);
        llenaComboCategorias(vistaRegistro.combobxSexoBecado, catSexo);
        llenaComboCategorias(lstVistaParentesco.get(0).cmbNivelEstudiosPariente, catNivelEstudios);
        llenaComboCategorias(lstVistaHermanos.get(0).cmbNivelEstudiosHermano, catNivelEstudios);
        llenaComboCategorias(lstVistaParentesco.get(0).cmbParentesco, catParentesco);
        llenaComboCategorias(vistaRegistro.cmboxEscuelaUniversitaria, catUniversidad);
        llenaComboCategorias(vistaRegistro.cmboxCampoEscuela, catCampoEstudio);
        
    }
    
    /**
     * Llena el combo box indicado con el listado que se le manda
     */
    private void llenaComboCategorias(JComboBox combo, LinkedHashMap<Integer, String> lstCategoria){
        //catPrograma = lstCategorias.get(2);
        for (Integer key : lstCategoria.keySet()) {
            combo.addItem(lstCategoria.get(key));
        }
    }

    /**
     * Cierra la sesión de trabajo e inicia la pantalla de login
     */
    void cerrarSesion() {
        int response = JOptionPane.showConfirmDialog(vista, "¿Deseas cerrar Sesión?");
        if(response == JOptionPane.YES_OPTION){
            terminarVista();
        }
    }

    /**
     * Inicia la pantalla login
     */
    private void terminarVista() {
        vista.dispose();
        vista = null;
        modelo = null;
        controladorPrincipal.iniciaPantallaLogin();
    }
    
    /**
     * Muestra las pantallas dinamicas de VistaRegistro
     */
    private void llenaPanelesVistaRegistro() {
        PnlParentesco vistaParentesco = new PnlParentesco();
        PnlHermanos vistaHermanos = new PnlHermanos();
        PnlHijos vistaHijos = new PnlHijos();
        PnlDireccion vistaDireccion = new PnlDireccion();
        
        vistaParentesco.setControlador(this);
        vistaHermanos.setControlador(this);
        vistaHijos.setControlador(this);
        vistaDireccion.setControlador(this);
        
        helper.agregaJPanel(vistaParentesco, vistaRegistro.pnlParentesco);
        helper.agregaJPanel(vistaHermanos, vistaRegistro.pnlHermanos);
        helper.agregaJPanel(vistaHijos, vistaRegistro.pnlHijos);
        helper.agregaJPanel(vistaDireccion, vistaRegistro.pnlDirecciones);
        
        lstVistaParentesco.add(vistaParentesco);
        lstVistaHermanos.add(vistaHermanos);
        lstVistaHijos.add(vistaHijos);
        lstVistaDireccion.add(vistaDireccion);
        
        vistaParentesco.setVisible(true);
        vistaHermanos.setVisible(true);
        vistaHijos.setVisible(true);
        vistaDireccion.setVisible(true);
        
    }

    /**
     * Carga la fotografía del becario
     */
    protected void cargaFotografia() {
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("PNG, JPG, JPEG", "jpg","png","jpeg");
        selector.setFileFilter(filtro);
        int select = selector.showOpenDialog(vista);
        
        if(select == JFileChooser.APPROVE_OPTION){
            fileFoto = selector.getSelectedFile();
            helper.cargaImagenExterna(vistaRegistro.lblFotografia, fileFoto.toPath());
        }
    }
    
    protected File cargaDocumento(File archivo, JLabel lblEstatus){
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("PDF", "pdf");
        selector.setFileFilter(filtro);
        int select = selector.showOpenDialog(vista);

        if(select == JFileChooser.APPROVE_OPTION){
            archivo = selector.getSelectedFile();
            String nombreArchivo = archivo.getName();
            String extension = nombreArchivo.substring(nombreArchivo.length()-3, nombreArchivo.length());
            if(!extension.equals("pdf") && 
                    !extension.equals("PDF")){
                JOptionPane.showMessageDialog(vista, "Debes de seleccionar archivos con la extension PDF", "Error", JOptionPane.ERROR_MESSAGE);
                lblEstatus.setText("ERROR");
                archivo = null;
            }
            else{
                //JOptionPane.showMessageDialog(vista, "Debes de seleccionar archivos con la extension PDF", "Error", JOptionPane.ERROR_MESSAGE);
                lblEstatus.setText("¡OK!");
            }
        }
        
        return archivo;
    }
    
    protected File borraDocumento(File archivo, JLabel lblEstatus){
        archivo =null;
        lblEstatus.setText("Eliminado");
        return archivo;
    }
    
    /**
     * Agrega un componente a su respectivo JPanel
     * @param componente JPanel que se quiere agregar
     */
    protected void agregaJPanel(JComponent componente) {
        if(componente instanceof PnlParentesco){
            PnlParentesco pnlParentesco = new PnlParentesco();
            pnlParentesco.setControlador(this);
            
            lstVistaParentesco.add(pnlParentesco);
            pnlParentesco.lblAgregarPariente.setVisible(false);
            llenaComboCategorias(pnlParentesco.cmbNivelEstudiosPariente, catNivelEstudios);
            llenaComboCategorias(pnlParentesco.cmbParentesco, catParentesco);
            lstVistaParentesco.get(0).lblAgregarPariente.setVisible(false);
            System.out.println("Esto es de parentesco");
            helper.agregaJPanel(pnlParentesco, vistaRegistro.pnlParentesco);
        }
        
        if(componente instanceof PnlDireccion){
            PnlDireccion pnlDireccion = new PnlDireccion();
            pnlDireccion.setControlador(this);
            pnlDireccion.lblAgregarDireccion.setVisible(false);
            lstVistaDireccion.add(pnlDireccion);
            lstVistaDireccion.get(0).lblAgregarDireccion.setVisible(false);
            System.out.println("Esto es de dirección");
            helper.agregaJPanel(pnlDireccion, vistaRegistro.pnlDirecciones);
        }
        
        if(componente instanceof PnlHermanos){
            PnlHermanos pnlHermanos = new PnlHermanos();
            pnlHermanos.setControlador(this);
            lstVistaHermanos.add(pnlHermanos);
            llenaComboCategorias(pnlHermanos.cmbNivelEstudiosHermano, catNivelEstudios);
            
            System.out.println("Esto es de Hermanos");
            helper.agregaJPanel(pnlHermanos, vistaRegistro.pnlHermanos);
        }
        
        if(componente instanceof PnlHijos){
            PnlHijos pnlHijos = new PnlHijos();
            pnlHijos.setControlador(this);
            lstVistaHijos.add(pnlHijos);
            System.out.println("Esto es de Hijos");
            helper.agregaJPanel(pnlHijos, vistaRegistro.pnlHijos);    
        }
        
        addListenerTeclasVistaRegistro();
        vistaRegistro.repaint();
        vista.repaint();
        
    }

    /**
     * Comienza la insersión del becario, en caso de que falten datos generales de llenar se guarda como pendiente
     */
    protected void insertaNuevoBecario() {
        
        boolean vacio = validaCamposVacios();
        
        // Si hay campos vacios en el formulario se pregunta si se quiere guardar el becario y llenarlo después
        if(vacio){
            int i = JOptionPane.showConfirmDialog(vistaRegistro, "¿Desea guardar y continuar después?", "Alerta, Campos Vacios", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(i == JOptionPane.OK_OPTION){
                //Se valida que los correos electronicos sean iguales
                boolean email = helper.validaEmail(vistaRegistro.txtCorreoBecario.getText(),
                                                    vistaRegistro.txtCorreoBecario2.getText());
                boolean fecha = helper.validaFechaNacimiento(vistaRegistro.txtFechaNacimiento, vistaRegistro);
                
                //Si los email son iguales se procede a tomar los valores e insertarlos
                if(email && fecha){
                    insertBecario(true);
                }
                else if(email == false)
                    JOptionPane.showMessageDialog(vistaRegistro, "Correos electrónicos diferentes", 
                                                                "Verifica los correos electrónicos", JOptionPane.WARNING_MESSAGE);
                
            }
        }
        //Si el formulario fue llenado en su totalidad...
        else{
            //Se valida que los correos electronicos sean iguales
            boolean email = helper.validaEmail(vistaRegistro.txtCorreoBecario.getText(),
                                                   vistaRegistro.txtCorreoBecario2.getText());
            //Si los email son iguales se procede a tomar los valores e insertarlos
            if(email)
                insertBecario(false);
        }

    }
    
    /**
     * Inserta el becario en la base de datos
     * @param bandera True si es un becario borrador, False si es un becario completo
     */
    private void insertBecario(boolean bandera){        
        
        //Se crean las variables donde se alojaran los archivos adjuntos
        File fileFotoDest;
        File fileActaNacimientoDest;
        File fileBoleta_calificaciones_inicialDest;
        File fileCarta_solicitudDest;
        File fileEnsayoDest;
        File fileIneBecarioDest;
        File fileIneAvalDest;
        File fileContratoDest;
        File filePagareDest;
        
        Conexion conn = new Conexion();
        Connection conexion = conn.estableceConexion();
        if(conexion == null){
            JOptionPane.showMessageDialog(vista, "No se puede conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            log.crearLog(new SQLException("No se pudo conectar a la base de datos").getMessage());
            return;
        }
        
        //Se obtienen los valores del nuevo becario
        Becario becario = getDatosBecarioDeFormulario(conexion);
        if(becario == null)
            return;
        
        List<Direccion> lstDireccionesBecario = getDireccionBecarioDeFormulario(becario.getId());
        List<Telefono> lstTelefonosBecario = getTelefonoBecarioDeFormulario(becario.getId());
        List<Padres> lstPadresBecario = getPadresBecarioDeFormulario(becario.getId());
        List<Hermanos> lstHermanos = getHermanosDeFormulario(becario.getId());
        List<Hijos> lstHijos = getHijosDeFormulario(becario.getId());
        DatosEscolares lstDatosEscolares = getDatosEscolaresDeFormulario(becario.getId());
        Aval lstAval = getAvalDeFormulario(becario.getId(), becario.getFolio());
        
        
        //Se inicia la transacción para la inserción del becario
        try{
            conexion.setAutoCommit(false);
            
            long idBecario = modelo.insertBecario(bandera, conexion, becario);
            //Si no se pudo insertar el becario
            if(idBecario == 0){
                throw new SQLException();
            }
            //Se insertan las direcciones
            boolean direccion = modelo.insertDireccionBecario(conexion, idBecario, lstDireccionesBecario);
            if(direccion == false){
                throw new SQLException();
            }
            //Se insertan los telefonos
            boolean telefono = modelo.insertTelefonoBecario(conexion, idBecario, lstTelefonosBecario);
            if(telefono == false){
                throw new SQLException();
            }
            //Se insertan los padres
            boolean papas = modelo.insertPapasBecario(conexion, idBecario, lstPadresBecario);
            if(papas == false){
                throw new SQLException();
            }
            //Se insertan los hermanos
            boolean hermanos = modelo.insertHermanosBecario(conexion, idBecario, lstHermanos);
            if(hermanos == false){
                throw new SQLException();
            }
            //Se insertan los hijos
            boolean hijos = modelo.insertHijosBecario(conexion, idBecario, lstHijos);
            if(hijos == false){
                throw new SQLException();
            }
            
            //Se insertan los datos escolares
            boolean datosEscolares = modelo.insertDatosEscolares(conexion, idBecario, lstDatosEscolares);
            if(datosEscolares == false){
                throw new SQLException();
            }
            
            //Se insertan los datos del aval
            boolean aval = modelo.insertAval(conexion, idBecario, lstAval);
            if(aval == false){
                throw new SQLException();
            }
            
            //Se aumenta el contador del folio
            boolean contador = modelo.updateContadorPrograma(conexion, becario.getInicialesFolio());
            if(contador == false){
                throw new SQLException();
            }
            conexion.commit();
            JOptionPane.showMessageDialog(vista, "Becario registrado correctamente \n"
                    + "Número de folio: " + becario.getFolio(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException e){
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                log.crearLog(ex.getMessage());
                Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(vista, "Error al guardar al becario", "Error de inserción", JOptionPane.ERROR_MESSAGE);
            log.crearLog(e.getMessage());
        }
        
        finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                log.crearLog(ex.getMessage());
                Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    /**
     * Obtiene los datos del becario del formulario de registro
     * @return Un becario con sus propiedades
     */
    private Becario getDatosBecarioDeFormulario(Connection conexion) {
        Becario becario = new Becario();
        
        //Se obtiene el id del programa seleccionado
        String prog = getSeleccionCmbBox(vistaRegistro.comboBoxPrograma);
        becario.setIdPrograma(getIdCmbBox(prog, catPrograma));
        //Se obtiene las iniciales del folio
        String inicioFolio = modelo.getClavePrograma(getIdCmbBox(prog, catPrograma));
        //Se asignan las iniciales del folio
        becario.setInicialesFolio(inicioFolio);
        //Se obtiene el folio
        //Se obtiene el folio
        becario.setFolio(modelo.creaFolio(conexion, becario));
        //Se obtiene el estatus del becario
        int estatus = vistaRegistro.cmbEstatus.getSelectedIndex();
        if(estatus == 0)
            //estatus becario
            becario.setIdEstatus(1);
        else
            //Estatus exalumno
            becario.setIdEstatus(3);
        //Se obtiene el estado civil
        String edoCiv = getSeleccionCmbBox(vistaRegistro.combobxCivilBecado);
        becario.setIdEstadoCivil(getIdCmbBox(edoCiv, catEstadoCivil));
        //Se obtiene si trabaja o no
        becario.setTrabaja(vistaRegistro.comboBxTrabajaBecado.getSelectedIndex());
        String sexo = (String) vistaRegistro.combobxSexoBecado.getSelectedItem();
        //Se obtiene el id del sexo
        becario.setIdSexo(getIdCmbBox(sexo, catSexo));
        //Se obtiene el nombre del becario
        becario.setNombre(vistaRegistro.txtNombreBecado.getText());
        //Se obtiene el ap paterno del becario
        becario.setApPaterno(vistaRegistro.txtApPaternoBecado.getText());
        //Se obtiene el ap materno del becario
        becario.setApMaterno(vistaRegistro.txtApMaternoBecado.getText());
        //Se obtiene la fecha de nacimiento del becario
        if(vistaRegistro.txtFechaNacimiento.getText().length() > 0){
            long fecha = getFecha(vistaRegistro.txtFechaNacimiento.getText());
            becario.setFecha_nac(new Date(fecha));
        }
        //Se obtiene los datos del conyuge
        becario.setNombreConyuge(vistaRegistro.txtNombreConyuge.getText());
        becario.setApPaternoConyuge(vistaRegistro.txtApPaternoConyuge.getText());
        becario.setApMaternoConyuge(vistaRegistro.txtApMaternoConyuge.getText());
        //Se obtiene si es el primero con beca
        becario.setPrimeroConBeca(vistaRegistro.cmboxCarreraSiNo.getSelectedIndex());
        //Se obtiene el correo electronico
        becario.setEmail(vistaRegistro.txtCorreoBecario.getText());
        //Se obtienen los comentarios
        becario.setObservaciones(vistaRegistro.txtAreaObservaciones.getText());
        
        //Se carga la foto
        if(fileFoto != null){
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "foto-", fileFoto);
            if(path == null){
                JOptionPane.showMessageDialog(vista, "Error al copiar la foto", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            else{
                becario.setFoto(path.toString());
            }
        }
        
        //Se carga el acta de nacimiento
        if(fileActaNacimiento != null){
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "acta_nacimiento-", fileActaNacimiento);
            if(path == null){
                JOptionPane.showMessageDialog(vista, "Error al copiar el acta de nacimiento", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            else{
                becario.setActaNacimiento(path.toString());
            }
        }
        
        //Se carga la boleta de calificaciones inicial
        if(fileBoleta_calificaciones_inicial != null){
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "boleta_inicial-", fileBoleta_calificaciones_inicial);
            if(path == null){
                JOptionPane.showMessageDialog(vista, "Error al copiar la bolea", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            else{
                becario.setBoletaInicioBeca(path.toString());
            }
        }
        
        //Se carga la carta solicitud de beca
        if(fileCarta_solicitud != null){
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "carta_solicitud-", fileCarta_solicitud);
            if(path == null){
                JOptionPane.showMessageDialog(vista, "Error al copiar la solicitud de la beca", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            else{
                becario.setSolicitudBeca(path.toString());
            }
        }
    
        //Se carga el contrato
        if(fileContrato != null){
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "contrato-", fileContrato);
            if(path == null){
                JOptionPane.showMessageDialog(vista, "Error al copiar el contrato", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            else{
                becario.setContatoBeca(path.toString());
            }
        }
        
        //Se carga el ensayo
        if(fileEnsayo != null){
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "ensayo-", fileEnsayo);
            if(path == null){
                JOptionPane.showMessageDialog(vista, "Error al copiar el ensayo", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            else{
                becario.setEnsayo(path.toString());
            }
        }
        
        //Se carga la identificacion del becario
        if(fileIneBecario != null){
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "ine_becario-", fileIneBecario);
            if(path == null){
                JOptionPane.showMessageDialog(vista, "Error al copiar la identificacion del becario", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            else{
                becario.setIdentificacion(path.toString());
            }
        }
        
        //Se carga el pagare del becario
        if(filePagare != null){
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "pagare-", filePagare);
            if(path == null){
                JOptionPane.showMessageDialog(vista, "Error al copiar el pagaré", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            else{
                becario.setFoto(path.toString());
            }
        }
        
        return becario;
    }
    
    /**
     * Obtiene la(s) direccion(es) del nuevo becario
     * @return Lista de Direcciones del becario
     */
    private List<Direccion> getDireccionBecarioDeFormulario(long idBecario) {
        List<Direccion> lstDirecciones = new ArrayList<>();
        
        for (PnlDireccion panel : lstVistaDireccion) {
                Direccion direccion = new Direccion();
                //Se obtiene la calle
                direccion.setCalle(panel.txtCalleBecado.getText());
                //Se obtiene el numero exterior
                direccion.setNumExt(panel.txtNumBecado.getText());
                //Se obtiene el numero interior
                direccion.setNumInt(panel.txtNumIntBecado.getText());
                //Se obtiene el codigo postal
                if(panel.txtCPBecado.getText().length() > 0)
                direccion.setCodigoPostal(Integer.parseInt(panel.txtCPBecado.getText()));
                //Se obtiene la colonia
                direccion.setColonia(panel.txtColoniaBecado.getText());
                //Se obtiene la ciudad
                direccion.setCiudad(panel.txtCiudadBecado.getText());
                //Se obtiene el becario
                direccion.setIdBecario(idBecario);
                //Se agrega la direccion a la lista
                lstDirecciones.add(direccion);
        }
        return lstDirecciones;
    }

    /**
     * OBtiene el(los) telefonos ingresados del nuevo becario
     * @param idBecario Id del becario con el que se relaciona los telefonos
     * @return Lista de Telefonos del becario
     */
    private List<Telefono> getTelefonoBecarioDeFormulario(long idBecario) {
        List<Telefono> lstTelefono = new ArrayList<>();
        if(!vistaRegistro.txtTel1Becado.getText().equals("")){
            Telefono telefono = new Telefono();
            //Se agrega el becario
            telefono.setIdBecario(idBecario);
            //Se agrega el primer teléfono
            telefono.setTelefono(vistaRegistro.txtTel1Becado.getText());
            //Se agrega a la lista el teléfono
            lstTelefono.add(telefono);
        }
        if(!vistaRegistro.txtTel2Becado.getText().equals("")){
            Telefono telefono = new Telefono();
            //Se agrega el becario
            telefono.setIdBecario(idBecario);
            //Se agrega el primer teléfono
            telefono.setTelefono(vistaRegistro.txtTel2Becado.getText());
            //Se agrega a la lista el teléfono
            lstTelefono.add(telefono);
        }
        if(!vistaRegistro.txtTel3Becado.getText().equals("")){
            Telefono telefono = new Telefono();
            //Se agrega el becario
            telefono.setIdBecario(idBecario);
            //Se agrega el primer teléfono
            telefono.setTelefono(vistaRegistro.txtTel3Becado.getText());
            //Se agrega a la lista el teléfono
            lstTelefono.add(telefono);
        }
        
        return lstTelefono;
    }
    
    /**
     * Obtiene los datos del(los) papá(ás) del becario
     * @param idBecario Id del becario
     * @return Lista con los datos de los padres
     */
    private List<Padres> getPadresBecarioDeFormulario(long idBecario) {
        List<Padres> lstResult = new ArrayList<>();
        for (PnlParentesco panel : lstVistaParentesco) {
            Padres padre = new Padres();
            //Se obtiene el nombre del padre
            padre.setNombre(panel.txtNombresPariente.getText());
            //Se obtiene el apellido paterno del padre
            padre.setaPaterno(panel.txtApPaternoPariente.getText());
            //Se obtiene el apellido materno de la madre
            padre.setaMaterno(panel.txtApMaternoPariente.getText());
            //Se obtiene si trabaja o no
            padre.setTrabaja(0);
            //Se obtiene el grado de estudio
            String grado = (String) panel.cmbNivelEstudiosPariente.getSelectedItem();
            //Se asigna el grado de estudio
            padre.setGradoEscolar(getIdCmbBox(grado, catNivelEstudios));
            //Se obtiene si trabaja 
            padre.setTrabaja(panel.cmbTrabajoActivoPariente.getSelectedIndex());
            //Se obtiene el becario
            padre.setIdBecario(idBecario);
            //Se obtiene si es padre o madre
            String parentesco = (String) panel.cmbParentesco.getSelectedItem();
            //Se asigna el parentesco
            padre.setParenteco(getIdCmbBox(parentesco, catParentesco));
            
            lstResult.add(padre);
        }
        
        return lstResult;
    }
    
    /**
     * Obtiene los datos del(los) hermano(s) del becario
     * @param idBecario Id del becario
     * @return LIsta con los datos de los hermanos
     */
    private List<Hermanos> getHermanosDeFormulario(long idBecario) {
        List<Hermanos> lstResult = new ArrayList<>();
        
        for (PnlHermanos panel : lstVistaHermanos) {
            Hermanos hermano = new Hermanos();
            //Se obtiene el nombre del hermano
            hermano.setNombre(panel.txtNombresPariente.getText());
            //Se obtiene el apellido paterno
            hermano.setAPaterno(panel.txtApPaternoPariente.getText());
            //Se obtiene el apellido materno 
            hermano.setAMaterno(panel.txtApMaternoPariente.getText());
            //Se obtiene el nivel de estudios
            String grado = (String) panel.cmbNivelEstudiosHermano.getSelectedItem();
            //Se asigna el nivel de estudios
            hermano.setGradoEscolar(getIdCmbBox(grado, catNivelEstudios));
            //Se obtiene el becario
            hermano.setIdBecario(idBecario);
            //Se agregra a la lista el hermano
            lstResult.add(hermano);
        }
        
        return lstResult;
    }
    
    /**
     * Obtiene los datos del(los) hermano(s) del becario
     * @param idBecario Id del becario
     * @return Lista con los datos de los hijos
     */
    private List<Hijos> getHijosDeFormulario(long idBecario) {
        List<Hijos> lstResult = new ArrayList<>();
        
        for (PnlHijos panel : lstVistaHijos) {
            Hijos hijo = new Hijos();
            //Se obtiene el nombre del hijo
            hijo.setNombre(panel.txtNombreHIjo.getText());
            //Se obtiene el apellido paterno
            hijo.setAPaterno(panel.txtApPaternoHijo.getText());
            //SE obtiene el apellido materno
            hijo.setAMaterno(panel.txtApMaternoHijo.getText());
            //Se obtiene la fecha de nacimiento
            //hijo.setFechaNac(null);
            //Se obtiene el becario
            hijo.setIdBecario(idBecario);
            //Se agrega el hijo a la lista
            lstResult.add(hijo);
        }
        
        return lstResult;
    }
    
    /**
     * Obtiene los datos escolares del becario
     * @param idBecario
     * @return 
     */
    private DatosEscolares getDatosEscolaresDeFormulario(long idBecario) {
        DatosEscolares datos = new DatosEscolares();
        //Se obtiene el nombre de la carrera
        datos.setNombreCarrera(vistaRegistro.txtNombreCarrera.getText());
        //Se obtiene el campo de la carrera
        String campo = (String) vistaRegistro.cmboxCampoEscuela.getSelectedItem();
        //Se obtiene el campo de estudio de la carrera
        datos.setIdCampoCarrera(getIdCmbBox(campo, catCampoEstudio));
        //Se obtiene la universidad de estudio
        String universidad = (String) vistaRegistro.cmboxEscuelaUniversitaria.getSelectedItem();
        //Se asigna la universidad
        datos.setIdUniversidad(getIdCmbBox(universidad, catUniversidad));
        

        //Se obtiene el nombre de la preparatoria
        datos.setEscuelaProcedencia(vistaRegistro.txtEscuelaProcedencia.getText());
        
        
        //Se obtiene el mes de inicio de la beca
        datos.setMesInicioBeca(vistaRegistro.cmboxMesInicioBeca.getSelectedIndex());
        //Se obtiene el año del inicio de la beca
        datos.setAnioInicioBeca(Integer.parseInt((String) vistaRegistro.cmboxAnioInicioBeca.getSelectedItem()));
        //Se obtiene el mes de graduacion
        datos.setMesGraduacion(vistaRegistro.cmboxMesGraduacion.getSelectedIndex() + 1);
        //Se obtiene el año de graduacion
        datos.setAnioGraduacion(Integer.parseInt((String) vistaRegistro.cmboxAnioGraduacion.getSelectedItem()));
        //Se obtiene el total de semestres de estudio
        datos.setSemestresTotalesCarrera(vistaRegistro.cmboxSemestresTotalesCarrera.getSelectedIndex() + 1);
        //Se obtiene el semestre de estudio del inicio de la beca
        datos.setSemestreInicioBeca(vistaRegistro.cmboxSemestreInicioBeca.getSelectedIndex() + 1);
        //Se obtiene el total de la beca
        if(vistaRegistro.txtBecaAutorizada.getText().length() > 0)
            datos.setBecaTotal(Float.parseFloat(vistaRegistro.txtBecaAutorizada.getText()));
        //Se obtiene el valor semestral de la beca
        if(vistaRegistro.txtBecaPorSemestre.getText().length() > 0)
            datos.setBecaSemestral(Float.parseFloat(vistaRegistro.txtBecaPorSemestre.getText()));
         //Se obtiene el costo de la carrera
        if(vistaRegistro.txtCostoCarrera.getText().length() > 0)
            datos.setBecaSemestral(Float.parseFloat(vistaRegistro.txtCostoCarrera.getText()));
        return datos;
    }
    
    /**
     * Obtiene los datos del aval del formulario de registro
     * @param id ID del becario
     * @return Objeto Aval
     */
    private Aval getAvalDeFormulario(long id, String folio) {
        Aval aval = new Aval();
        
        //Se carga el acta de nacimiento
        if(fileIneAval != null){
            Path path = helper.CopiaArchivoADestino(folio, "ine_aval-", fileActaNacimiento);
            aval.setIdBecario(id);
            if(path == null){
                JOptionPane.showMessageDialog(vista, "Error al copiar la identificacion del aval", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            else{
                aval.setIdentificacion(path.toString());
            }
        }
        
        
        return aval;
    }
    
    /**
     * Obtiene la seleccion de un combo box
     * @param combo Combo box que se evaluará
     * @return Selección
     */
    private String getSeleccionCmbBox(JComboBox combo){
        String seleccion = (String) combo.getSelectedItem();
        
        return seleccion;
    }

    /**
     * Obtiene el id de la seleccion del usuario en un combo box
     * @param cadena Nombre de la seleccion del usuario
     * @param categorias Listado de categorias a comparar
     * @return Id de la seleccion del usuario
     * @throws NullPointerException En caso de que no se encuentre el id de la selección
     */
    private int getIdCmbBox(String cadena, LinkedHashMap<Integer, String> categorias) throws NullPointerException {
        int idCategoria = 0;
        for (Integer key : categorias.keySet()) {
            if(cadena.equals(categorias.get(key))){
                idCategoria = key;
            }
        }
        
        if(idCategoria == 0){
            log.crearLog(new NullPointerException("Id no encontrado").getMessage());
        }
        return idCategoria;
    }

    /**
     * Obtiene la fecha capturada y la convierte a a TIMESTAMP
     * @param fecha
     * @return TIMESTAMP DE LA FECHA
     */
    private long getFecha(String fecha){
        String[] fech = fecha.split("/");
        int anio = Integer.parseInt(fech[2]); 
        int mes = Integer.parseInt(fech[1]); 
        int dia = Integer.parseInt(fech[0]); 
        Calendar calendario = new GregorianCalendar(anio, mes, dia);
        long result = calendario.getTimeInMillis();
        
        return result;
    }
    
    /**
     * Recorre todos los componentes dentro de un JPanel
     * @param clave 1: Valida si hay campos vacios
     * @param panel Jpanel a recorrer
     * @return True si encontró campos vacios, false si no
     */
    private boolean recorreJPanel(JPanel panel, int clave){
        Component[] componentes = panel.getComponents();
        boolean response = false;
        switch(clave){
            //Datos generales
            case 1:
                for (Component componente : componentes) {
                    if(componente instanceof JPanel){
                        response = recorreJPanel((JPanel)componente, 1);
                    }                    
                    if (componente instanceof JTextField) {
                        //Si el campo tiene un nombre quiere decir que puede estar vacio
                        if(((JTextField) componente).getName() != null){
                            continue;
                        }
                        if(((JTextField) componente).getText().equals("")){
                            ((JTextField) componente).setBackground(Color.ORANGE);
                            response = true;
                        }
                    }
                }   
                break;
        }
        return response;
    }

    /**
     * Valida que los campos de datos generales,  Direccion, Padres, Información escolar, Manejo de beca no estén vacios
     * @return True si hay campos vacios, False si no
     */
    private boolean validaCamposVacios() {
        boolean response = false;
        
        //Si se encuentran campos vacios
        if( recorreJPanel(vistaRegistro.pnlDatosGenerales, 1) || 
            recorreJPanel(vistaRegistro.pnlParentesco, 1) || 
            recorreJPanel(vistaRegistro.pnlInformacionEscolar, 1) || 
            recorreJPanel(vistaRegistro.pnlManejoBeca, 1) || 
            recorreJPanel(vistaRegistro.pnlDirecciones, 1) || 
            recorreJPanel(vistaRegistro.pnlCorreos, 1) ){
            
            response = true;
        }
        
        return response;
    }

    private void addListenerTeclasVistaRegistro() {
        //Nombres del becado y fecha de nacimiento
        vistaRegistro.txtNombreBecado.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, vistaRegistro.txtNombreBecado));
        vistaRegistro.txtApPaternoBecado.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, vistaRegistro.txtApPaternoBecado));
        vistaRegistro.txtApMaternoBecado.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, vistaRegistro.txtApPaternoBecado));
        vistaRegistro.txtFechaNacimiento.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.FECHA_NACIMIENTO, vistaRegistro.txtFechaNacimiento));
        
        //Telefonos del becado
        vistaRegistro.txtTel1Becado.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.TELEFONO, vistaRegistro.txtTel1Becado));
        vistaRegistro.txtTel2Becado.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.TELEFONO, vistaRegistro.txtTel2Becado));
        vistaRegistro.txtTel3Becado.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.TELEFONO, vistaRegistro.txtTel3Becado));
        
        //Datos del conyugue
        vistaRegistro.txtNombreConyuge.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, vistaRegistro.txtNombreConyuge));
        vistaRegistro.txtApPaternoBecado.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, vistaRegistro.txtApPaternoBecado));
        vistaRegistro.txtApMaternoBecado.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, vistaRegistro.txtApMaternoBecado));
        vistaRegistro.txtTelefonoConyuge.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.TELEFONO, vistaRegistro.txtTelefonoConyuge));
        
        //Datos Escolares 
        vistaRegistro.txtNombreCarrera.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, vistaRegistro.txtNombreCarrera));
        vistaRegistro.txtEscuelaProcedencia.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, vistaRegistro.txtEscuelaProcedencia));
        vistaRegistro.txtCostoCarrera.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.NUMEROS, vistaRegistro.txtCostoCarrera));
        vistaRegistro.txtBecaAutorizada.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.NUMEROS, vistaRegistro.txtBecaAutorizada));
        
        //Datos que calculan la beca total semestral
        vistaRegistro.txtBecaAutorizada.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.NUMEROS, vistaRegistro.txtBecaAutorizada));
        vistaRegistro.txtCostoCarrera.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.NUMEROS, vistaRegistro.txtCostoCarrera));
        vistaRegistro.txtBecaAutorizada.addKeyListener(new EscuchadorCalculaBecaXSemestre(vistaRegistro.txtBecaAutorizada, vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera, vistaRegistro.txtBecaPorSemestre));
        vistaRegistro.cmboxSemestreInicioBeca.addItemListener(new EscuchadorCmbBoxCambiado(vistaRegistro.cmboxSemestresTotalesCarrera, vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.txtBecaAutorizada, vistaRegistro.txtBecaPorSemestre, EscuchadorCmbBoxCambiado.BECA_SEMESTRAL));
        vistaRegistro.cmboxSemestresTotalesCarrera.addItemListener(new EscuchadorCmbBoxCambiado(vistaRegistro.cmboxSemestresTotalesCarrera, vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.txtBecaAutorizada, vistaRegistro.txtBecaPorSemestre, EscuchadorCmbBoxCambiado.BECA_SEMESTRAL));
        
        //Datos hijos
        for (PnlHijos lstVistaHijo : lstVistaHijos) {
            lstVistaHijo.txtApPaternoHijo.addKeyListener(new EscuchadorValidaEntrada(lstVistaHijo, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaHijo.txtApPaternoHijo));
            lstVistaHijo.txtApMaternoHijo.addKeyListener(new EscuchadorValidaEntrada(lstVistaHijo, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaHijo.txtApMaternoHijo));
            lstVistaHijo.txtNombreHIjo.addKeyListener(new EscuchadorValidaEntrada(lstVistaHijo, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaHijo.txtNombreHIjo));
        }
        
        //Datos direccion
        for (PnlDireccion lstVistaDireccion : lstVistaDireccion) {
            lstVistaDireccion.txtCPBecado.addKeyListener(new EscuchadorValidaEntrada(lstVistaDireccion, EscuchadorValidaEntrada.NUMEROS, lstVistaDireccion.txtCPBecado));
            lstVistaDireccion.txtCalleBecado.addKeyListener(new EscuchadorValidaEntrada(lstVistaDireccion, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaDireccion.txtCalleBecado));
            lstVistaDireccion.txtCiudadBecado.addKeyListener(new EscuchadorValidaEntrada(lstVistaDireccion, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaDireccion.txtCiudadBecado));
            lstVistaDireccion.txtColoniaBecado.addKeyListener(new EscuchadorValidaEntrada(lstVistaDireccion, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaDireccion.txtColoniaBecado));
            lstVistaDireccion.txtNumBecado.addKeyListener(new EscuchadorValidaEntrada(lstVistaDireccion, EscuchadorValidaEntrada.NUMEROS, lstVistaDireccion.txtNumBecado));
            lstVistaDireccion.txtNumIntBecado.addKeyListener(new EscuchadorValidaEntrada(lstVistaDireccion, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaDireccion.txtNumIntBecado));
        }
        
        //Datos Hermanos
        for (PnlHermanos lstVistaHermanos : lstVistaHermanos) {
            lstVistaHermanos.txtApMaternoPariente.addKeyListener(new EscuchadorValidaEntrada(lstVistaHermanos, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaHermanos.txtApMaternoPariente));
            lstVistaHermanos.txtApPaternoPariente.addKeyListener(new EscuchadorValidaEntrada(lstVistaHermanos, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaHermanos.txtApPaternoPariente));
            lstVistaHermanos.txtNombresPariente.addKeyListener(new EscuchadorValidaEntrada(lstVistaHermanos, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaHermanos.txtNombresPariente));
        }
        
        //Datos Padres
        for (PnlParentesco lstParentesco : lstVistaParentesco) {
            lstParentesco.txtApMaternoPariente.addKeyListener(new EscuchadorValidaEntrada(lstParentesco, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstParentesco.txtApMaternoPariente));
            lstParentesco.txtApPaternoPariente.addKeyListener(new EscuchadorValidaEntrada(lstParentesco, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstParentesco.txtApPaternoPariente));
            lstParentesco.txtNombresPariente.addKeyListener(new EscuchadorValidaEntrada(lstParentesco, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstParentesco.txtNombresPariente));
        }
        
        //Datos de fechas de inicio de carrera y graduacion
        vistaRegistro.cmboxSemestresTotalesCarrera.addItemListener(new 
        EscuchadorCmbBoxCambiado(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca, 
                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion, 
                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera, 
                vistaRegistro, EscuchadorCmbBoxCambiado.FECHA_GRADUACION));
        
        vistaRegistro.cmboxMesInicioBeca.addItemListener(new 
        EscuchadorCmbBoxCambiado(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca, 
                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion, 
                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera, 
                vistaRegistro, EscuchadorCmbBoxCambiado.FECHA_GRADUACION));
        
        vistaRegistro.cmboxAnioInicioBeca.addItemListener(new 
        EscuchadorCmbBoxCambiado(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca, 
                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion, 
                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera, 
                vistaRegistro, EscuchadorCmbBoxCambiado.FECHA_GRADUACION));
        
        vistaRegistro.cmboxMesGraduacion.addItemListener(new 
        EscuchadorCmbBoxCambiado(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca, 
                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion, 
                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera, 
                vistaRegistro, EscuchadorCmbBoxCambiado.FECHA_GRADUACION));
        
        vistaRegistro.cmboxAnioGraduacion.addItemListener(new 
        EscuchadorCmbBoxCambiado(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca, 
                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion, 
                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera, 
                vistaRegistro, EscuchadorCmbBoxCambiado.FECHA_GRADUACION));
        
        vistaRegistro.cmboxSemestreInicioBeca.addItemListener(new 
        EscuchadorCmbBoxCambiado(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca, 
                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion, 
                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera, 
                vistaRegistro, EscuchadorCmbBoxCambiado.FECHA_GRADUACION));
        
    }
}
