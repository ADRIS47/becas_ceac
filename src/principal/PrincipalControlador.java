/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import crud.Conexion;
import helpers.EscuchadorCalculaBecaXSemestre;
import helpers.EscuchadorCalculaDescuentoSemestral;
import helpers.EscuchadorCmbBoxCambiado;
import helpers.EscuchadorValidaEntrada;
import helpers.Helper;
import helpers.Log;
import index.Index;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
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
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jtable.ModelDefault;
import jtable.ModelUniversidades;
import pojos.Aval;
import pojos.Becario;
import pojos.CatColumnasTabla;
import pojos.CatUniversidad;
import pojos.DatosEscolares;
import pojos.Direccion;
import pojos.Hermanos;
import pojos.Hijos;
import pojos.Kardex;
import pojos.Padres;
import pojos.Telefono;

/**
 *
 * @author sabagip
 */
public class PrincipalControlador {

    VistaPanelPrincipal vista;
    VistaRegistro vistaRegistro;
    VistaBusqueda vistaBusqueda;
    VistaKardex vistaKardex;
    VistaCatalogos vistaCatalogos;
    
    PnlPortada vistaPortada;
    VistaRegistroOpcionGuardar vistaOpcionGuardar;
    VistaRegistroOpcionActualizar vistaOpcionActualizar;

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
    protected File fileEstudioSocioeconomico;
    protected File fileCartaAsignacionBeca;
    protected File fileCartaAgradecimiento;

    Log log = new Log();
    Helper helper = new Helper();

    LinkedHashMap<Integer, String> catSexo = null;
    LinkedHashMap<Integer, String> catEstadoCivil = null;
    LinkedHashMap<Integer, String> catPrograma = null;
    LinkedHashMap<Integer, String> catParentesco = null;
    LinkedHashMap<Integer, String> catNivelEstudios = null;
    LinkedHashMap<Integer, String> catUniversidad = null;
    LinkedHashMap<Integer, String> catCampoEstudio = null;
    LinkedHashMap<Integer, String> catEstatus = null;
    LinkedHashMap<Integer, String> catBancos = null;
    LinkedHashMap<Integer, String> catTipoEscuela = null;
    LinkedHashMap<Integer, String> catTipoServicioSocial = null;
    LinkedHashMap<Integer, String> catLugarServicioSocial = null;
    LinkedHashMap<Integer, String> catCatalogos = null;
    LinkedHashMap<Integer, String> catMunicipios = null;
    
    /**
     * Se encarga de almacenar el catalogo original de la base de datos
     */
    LinkedHashMap<Integer, String> lstCatalogoOriginal = null;
    /**
     * Se encarga de almacenar una copia de la lista original y todos los cambios realizados por el usuario
     */
    LinkedHashMap<Integer, String> lstCatalogoCopia = null;
    /**
     * Se encarga de almacenar las busquedas realizadas por el usuario
     */
    LinkedHashMap<Integer, String> lstCatalogoCopiaEnBusquedas = null;
    /**
     * Se encarga de almacenar si una universidad es publica o privada
     */
    LinkedHashMap<Integer, Boolean> lstCatalogoTipoUniversidad = null;

    List<PnlHijos> lstVistaHijos = new ArrayList<>();
    List<PnlHermanos> lstVistaHermanos = new ArrayList<>();
    List<PnlParentesco> lstVistaParentesco = new ArrayList<>();
    List<PnlDireccion> lstVistaDireccion = new ArrayList<>();

    File[] lstFilesBoletas = new File[12];
    File[] lstFilesCartaServCom = new File[12];
    File[] lstFilesTransferencias = new File[24];
    
    /**
     * Bandera que indica si se inicia la vistaRegistro con los datos precargados o crea
     * una nueva pantalla sin datos
     * FALSE: Indica que se debe de cargar una vistaRegistro sin datos
     * TRUE: Indica que se debe de precargar la pantalla
     */
//    boolean cargaVistaRegistro = false;
    
    String numeroFolio = "";
    

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

    public void setVistaPortada(PnlPortada vistaPortada) {
        this.vistaPortada = vistaPortada;
    }

    public void setVistaBusqueda(VistaBusqueda vistaBusqueda) {
        this.vistaBusqueda = vistaBusqueda;
    }

    public void setVistaKardex(VistaKardex vistaKardex) {
        this.vistaKardex = vistaKardex;
    }

    public VistaCatalogos getVistaCatalogos() {
        return vistaCatalogos;
    }

    public void setVistaCatalogos(VistaCatalogos vistaCatalogos) {
        this.vistaCatalogos = vistaCatalogos;
    }

    public void iniciaPantallaPrincipal() {
        vista = new VistaPanelPrincipal(this);
        vistaPortada = new PnlPortada(this);
        modelo = new PrincipalModelo();
        controladorPrincipal = new Index();

        this.setVista(vista);
        this.setModelo(modelo);
        this.setVistaPortada(vistaPortada);

        creaVistaPortada();

        vista.setLocationRelativeTo(null);

        vista.setVisible(true);
    }

    private void creaVistaPortada() {
        creaPantalla(vistaPortada);
        vistaPortada.setVisible(true);
        helper.cargaImagenLocal(vistaPortada.lblPortada, "/imagenes/LOGO_con_letra.png");

    }

    /**
     * Crea una pantalla VistaRegistro en la pantalla principal con sus
     * respectivos datos
     */
    public void creaVistaRegistro() {
        helper.cursorEspera(vista);
        if(vistaKardex == null){
            if (vistaRegistro != null) {
                terminaVistaRegistro();
            }

            if (vistaRegistro == null) {
                vistaRegistro = new VistaRegistro(this);
                this.setVistaRegistro(vistaRegistro);
            }

            if (vistaKardex != null) {
                terminaVistaKardex();
            }

            vaciaLstFiles();

            List<LinkedHashMap<Integer, String>> lstCategorias = null;

            try {
                //Se muestran las pantallas dinamicas
                llenaPanelesVistaRegistro();
                //Se obtienen las categorias para llenar la pantalla
                lstCategorias = modelo.getCategoriasVistaRegistro();
                llenaCamposCategoriasVistaRegistro(lstCategorias, false);
            } catch (SQLException ex) {
                helper.cursorNormal(vista);
                Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(vista, "Error, consulta el registro de errores",
                        "Error", JOptionPane.ERROR_MESSAGE);
                log.crearLog(ex.getMessage());
                return;
            }

            addListenerTeclasVistaRegistro();

            helper.setAñoActualEnCombo(vistaRegistro.cmboxAnioInicioBeca);

            vistaOpcionGuardar = new VistaRegistroOpcionGuardar();
            vistaOpcionGuardar.setControlador(this);
            helper.agregaJPanel(vistaOpcionGuardar, vistaRegistro.pnlOpciones);
            vistaOpcionGuardar.setVisible(true);
            //addListenerArchivosAdjuntos();
            //Helper.getBecaSemestral(vistaRegistro.cmboxSemestresTotalesCarrera, vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.txtBecaAutorizada, vistaRegistro.txtBecaPorSemestre);
            //Helper.getFechaGraduacion(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca, vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion, vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera);

            helper.cursorNormal(vista);
            creaPantalla(vistaRegistro);
//            cargaVistaRegistro = true;
        }
        else{
            getInfoBecarioPorFolio(vistaKardex.txtFolio.getText());
            terminaVistaKardex();
//            cargaVistaRegistro = false;
        }
    }

    /**
     * Crea la pantalla de busqueda de becarios
     */
    protected void creaVistaBusqueda() {
        helper.cursorEspera(vista);
        if (vistaBusqueda != null) {
            terminaVistaBusqueda();
        }

        if (vistaKardex != null) {
            terminaVistaKardex();
        }

        vistaBusqueda = new VistaBusqueda();
        this.setVistaBusqueda(vistaBusqueda);
        vistaBusqueda.setControlador(this);

        List<LinkedHashMap<Integer, String>> lstCategorias = null;

        try {
            //Se obtienen las categorias para llenar la pantalla
            lstCategorias = modelo.getCategoriasVistaRegistro();
            llenaCamposCategoriasVistaBusqueda(lstCategorias);
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(vista, "Error, consulta el registro de errores",
                    "Error", JOptionPane.ERROR_MESSAGE);
            log.crearLog(ex.getMessage());
            return;
        }

        helper.cursorNormal(vista);
        creaPantalla(vistaBusqueda);

        helper.setAñoActualEnCombo(vistaBusqueda.cmbAnioRegistro);
        helper.setAñoActualEnCombo(vistaBusqueda.cmbanioGraduacion);
    }
    
    /**
     * Crea la pantalla vistaKardex
     */
    protected void creaVistaKardex() {
        
        helper.cursorEspera(vista);
        if (vistaKardex != null) {
            terminaVistaKardex();
        }

        vistaKardex = new VistaKardex();
        this.setVistaKardex(vistaKardex);
        vistaKardex.setControlador(this);

        //Si no se ha abierto la pantalla vistaRegistro
        if (vistaRegistro == null) {
            JOptionPane.showMessageDialog(vistaKardex, "Debes de seleccionar un becario");
            creaVistaBusqueda();
        } else if (vistaRegistro.txtFolio.getText().equals("")) {
            JOptionPane.showMessageDialog(vistaKardex, "Debes de seleccionar un becario");
            creaVistaBusqueda();
        } //Si ya existe un becario en vistaRegistro
        else {

            //Se asignan los listeners al panel pnlKardex
            recorreJPanel(vistaKardex.PnlKardex, 3);
            recorreJPanel(vistaKardex.PnlKardex, 6);
            //Se asignan los listeners al panel pnlInformacionBancaria
            recorreJPanel(vistaKardex.pnlInformacionBancaria, 4);
            //Se validan los semestres que deben de habilitarse

            llenaCamposVistaKardex(vistaRegistro.txtFolio.getText());
            creaPantalla(vistaKardex);

        }
        helper.cursorNormal(vista);
    }
    
    /**
     * Crea la vista de los catalogos
     */
    protected void creaVistaCatalogos() {
        helper.cursorEspera(vista);
        if (vistaCatalogos != null) {
            terminaVistaCatalogos();
        }
        
        if(lstCatalogoOriginal != null){
            lstCatalogoOriginal.clear();
            lstCatalogoOriginal = null;
        }
        
        if(lstCatalogoCopia != null){
            lstCatalogoCopia.clear();
            lstCatalogoCopia = null;
        }
        
        if(lstCatalogoCopiaEnBusquedas != null){
            lstCatalogoCopiaEnBusquedas.clear();
            lstCatalogoCopiaEnBusquedas = null;
        }
        
        if(lstCatalogoTipoUniversidad != null){
            lstCatalogoTipoUniversidad.clear();
            lstCatalogoTipoUniversidad = null;
        }
        
        
        //vaciaLstFiles();
        vistaCatalogos = new VistaCatalogos();
        this.setVistaCatalogos(vistaCatalogos);
        vistaCatalogos.setControlador(this);
        
        lstCatalogoOriginal = new LinkedHashMap<>();
        lstCatalogoCopia = new LinkedHashMap<>();
        lstCatalogoCopiaEnBusquedas = new LinkedHashMap<>();
        lstCatalogoTipoUniversidad = new LinkedHashMap<>();

        creaPantalla(vistaCatalogos);
        
        llenaCamposVistaCatalogos();
        
//        vistaCatalogos.TxtFldDescripcionCatalogo.addKeyListener(
//                new EscuchadorBuscaCatalogo(vistaCatalogos.TxtFldDescripcionCatalogo, 
//                            catDatosCatalogos, vistaCatalogos.TblDescripcionCatalogo));
        helper.cursorNormal(vista);
    }

    /**
     * Crea una pantalla dentro del panel pnlOpciones
     *
     * @param pantalla Pantalla a agregar en el panel opciones
     */
    private void creaPantalla(Component pantalla) {
        //vista.pnlOpciones.removeAll();
        //vista.pnlOpciones.add(pantalla, BorderLayout.CENTER);
        vista.ScrollpnlOpciones.setViewportView(pantalla);
        pantalla.setVisible(true);
        vista.ScrollpnlOpciones.updateUI();
        vista.ScrollpnlOpciones.validate();
        vista.repaint();
        
        vista.setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    /**
     * Llena con los datos de las categorias la pantalla VistaRegistro, en caso
     * de que sea la adicion de un registro NO se carga la categoria Estatus, si
     * es un caso de cargar mediante busqueda SI se carga la categoria Estatus
     *
     * @param lstCategorias
     * @param bandera True.- Indica que se carga la categoria Estatus, False.-
     * Indica que no se carga la categoria estatus
     */
    private void llenaCamposCategoriasVistaRegistro(List<LinkedHashMap<Integer, String>> lstCategorias, boolean bandera) {
        //Se separan las categorias
        catSexo = lstCategorias.get(0);
        catEstadoCivil = lstCategorias.get(1);
        catPrograma = lstCategorias.get(2);
        catNivelEstudios = lstCategorias.get(3);
        catParentesco = lstCategorias.get(4);
        catUniversidad = lstCategorias.get(5);
        catCampoEstudio = lstCategorias.get(6);
        catEstatus = lstCategorias.get(7);
        catBancos = lstCategorias.get(8);
        catTipoEscuela = lstCategorias.get(9);
        catTipoServicioSocial = lstCategorias.get(10);
        catLugarServicioSocial = lstCategorias.get(11);
        catCatalogos = lstCategorias.get(12);
        catMunicipios = lstCategorias.get(13);

        llenaComboCategorias(vistaRegistro.combobxCivilBecado, catEstadoCivil);
        llenaComboCategorias(vistaRegistro.comboBoxPrograma, catPrograma);
        llenaComboCategorias(vistaRegistro.combobxSexoBecado, catSexo);
        llenaComboCategorias(lstVistaParentesco.get(0).cmbNivelEstudiosPariente, catNivelEstudios);
        llenaComboCategorias(lstVistaParentesco.get(1).cmbNivelEstudiosPariente, catNivelEstudios);
        llenaComboCategorias(lstVistaHermanos.get(0).cmbNivelEstudiosHermano, catNivelEstudios);
        llenaComboCategorias(lstVistaParentesco.get(0).cmbParentesco, catParentesco);
        llenaComboCategorias(lstVistaParentesco.get(1).cmbParentesco, catParentesco);
        llenaComboCategorias(vistaRegistro.cmboxEscuelaUniversitaria, catUniversidad);
        llenaComboCategorias(vistaRegistro.cmboxCampoEscuela, catCampoEstudio);
        llenaComboCategorias(vistaRegistro.cmbTipoEscuela, catTipoEscuela);
        
        lstVistaParentesco.get(1).cmbParentesco.setSelectedIndex(1);

        if (bandera) {
            vistaRegistro.cmbEstatus.removeAllItems();
            llenaComboCategorias(vistaRegistro.cmbEstatus, catEstatus);
        }

    }

    /**
     * Llena los catalogos de la VistaBusqueda
     *
     * @param lstCategorias
     */
    private void llenaCamposCategoriasVistaBusqueda(List<LinkedHashMap<Integer, String>> lstCategorias) {
        //Se separan las categorias
        catSexo = lstCategorias.get(0);
        catEstadoCivil = lstCategorias.get(1);
        catPrograma = lstCategorias.get(2);
        catNivelEstudios = lstCategorias.get(3);
        catParentesco = lstCategorias.get(4);
        catUniversidad = lstCategorias.get(5);
        catCampoEstudio = lstCategorias.get(6);
        catEstatus = lstCategorias.get(7);
        catBancos = lstCategorias.get(8);
        
        catPrograma.put(10000, "Todos");

        llenaComboCategorias(vistaBusqueda.cmbPrograma, catPrograma);
        llenaComboCategorias(vistaBusqueda.CmbboxBuscaEstatus, catEstatus);
        
        catPrograma.remove(10000);
    }

    /**
     * Llena los catalogos de la VistaKardex
     */
    private void llenaCamposCategoriasVistaKardex() {
        
        llenaComboCategorias(vistaKardex.cmbNombreBanco, catBancos);
    }

    /**
     * Llena el combo box indicado con el listado que se le manda
     */
    private void llenaComboCategorias(JComboBox combo, LinkedHashMap<Integer, String> lstCategoria) {
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
        if (response == JOptionPane.YES_OPTION) {
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

    private void terminaVistaRegistro() {
        vistaRegistro.removeAll();
        vaciaLstVistas();
//        folio = "";
//        cargaVistaRegistro = false;
        vistaRegistro = null;
    }

    private void terminaVistaBusqueda() {
        vistaBusqueda.removeAll();
        vaciaLstVistas();
        vistaBusqueda = null;
    }

    private void terminaVistaKardex() {
        vistaKardex.removeAll();
        //vaciaLstVistas();
        vistaKardex = null;
    }
    
    private void terminaVistaCatalogos() {
        vistaCatalogos.removeAll();
        vaciaLstVistas();
        vistaCatalogos = null;
    }

    /**
     * Muestra las pantallas dinamicas de VistaRegistro
     */
    private void llenaPanelesVistaRegistro() {
        PnlParentesco vistaParentesco = new PnlParentesco();
        PnlParentesco vistaParentesco2 = new PnlParentesco();
        PnlHermanos vistaHermanos = new PnlHermanos();
        PnlHijos vistaHijos = new PnlHijos();
        PnlDireccion vistaDireccion = new PnlDireccion();
        //vistaOpcionGuardar = new VistaRegistroOpcionGuardar();

        vistaParentesco.setControlador(this);
        vistaHermanos.setControlador(this);
        vistaHijos.setControlador(this);
        vistaDireccion.setControlador(this);
        //vistaOpcionGuardar.setControlador(this);

        helper.agregaJPanel(vistaParentesco, vistaRegistro.pnlParentesco);
        helper.agregaJPanel(vistaParentesco2, vistaRegistro.pnlParentesco);
        helper.agregaJPanel(vistaHermanos, vistaRegistro.pnlHermanos);
        helper.agregaJPanel(vistaHijos, vistaRegistro.pnlHijos);
        helper.agregaJPanel(vistaDireccion, vistaRegistro.pnlDirecciones);
        //helper.agregaJPanel(vistaOpcionGuardar, vistaRegistro.pnlOpciones);

        lstVistaParentesco.add(vistaParentesco);
        lstVistaParentesco.add(vistaParentesco2);
        lstVistaHermanos.add(vistaHermanos);
        lstVistaHijos.add(vistaHijos);
        lstVistaDireccion.add(vistaDireccion);

//        vistaParentesco.lblBorrarPariente.setVisible(false);
//        vistaParentesco2.lblBorrarPariente.setVisible(false);
//        vistaParentesco.lblAgregarPariente.setVisible(false);
//        vistaParentesco2.lblAgregarPariente.setVisible(false);
        vistaHermanos.lblBorrarHermano.setVisible(false);
        vistaHijos.lblBorrarHijos.setVisible(false);
        vistaDireccion.lblBorrarDireccion.setVisible(false);

        vistaParentesco.setVisible(true);
        vistaParentesco2.setVisible(true);
        vistaHermanos.setVisible(true);
        vistaHijos.setVisible(true);
        vistaDireccion.setVisible(true);
        //vistaOpcionGuardar.setVisible(true);

    }

    /**
     * Elige la fotografía del becario a partir de un JFILECHooser
     */
    protected void cargaFotografia() {
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("PNG, JPG, JPEG", "jpg", "png", "jpeg");
        selector.setFileFilter(filtro);
        int select = selector.showOpenDialog(vista);

        if (select == JFileChooser.APPROVE_OPTION) {
            fileFoto = selector.getSelectedFile();
            helper.cargaImagenExterna(vistaRegistro.lblFotografia, fileFoto.toPath());
        }
    }

    /**
     * Elige el documento del becario a partir de un JFILECHooser
     * @param archivo
     * @param lblEstatus
     * @return 
     */
    protected File cargaDocumento(File archivo, JLabel lblEstatus) {
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("PDF", "pdf");
        selector.setFileFilter(filtro);
        int select = selector.showOpenDialog(vista);

        if (select == JFileChooser.APPROVE_OPTION) {
            archivo = selector.getSelectedFile();
            String nombreArchivo = archivo.getName();
            String extension = nombreArchivo.substring(nombreArchivo.length() - 3, nombreArchivo.length());
            if (!extension.equals("pdf")
                    && !extension.equals("PDF")) {
                JOptionPane.showMessageDialog(vista, "Debes de seleccionar archivos con la extension PDF", "Error", JOptionPane.ERROR_MESSAGE);
                lblEstatus.setText("ERROR");
                archivo = null;
            } else {
                //JOptionPane.showMessageDialog(vista, "Debes de seleccionar archivos con la extension PDF", "Error", JOptionPane.ERROR_MESSAGE);
                lblEstatus.setText("¡OK!");
            }
        }

        return archivo;
    }

    /**
     * Carga los archivos de las boletas y las agrega a la lista de boletas
     * (lstFilesBoletas)
     *
     * @param semestre Número de semestre que se va a agregar
     * @param lblEstatus Etiqueta de estatus a cambiar
     * @param codigo 1.- Carga las boletas.
     * 2.- Carga las cartas del servicio comunitario
     * 3.- Carga los comprobantes de las transferencias
     */
    protected void cargaBoletaOCartaServComTransferencia(int semestre, JLabel lblEstatus, int codigo) {
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("PDF", "pdf");
        selector.setFileFilter(filtro);
        int select = selector.showOpenDialog(vista);
        File archivo = null;
        switch(codigo){
            case 1:
                if (select == JFileChooser.APPROVE_OPTION) {
                    archivo = selector.getSelectedFile();
                    String nombreArchivo = archivo.getName();
                    String extension = nombreArchivo.substring(nombreArchivo.length() - 3, nombreArchivo.length());
                    if (!extension.equals("pdf")
                            && !extension.equals("PDF")) {
                        JOptionPane.showMessageDialog(vista, "Debes de seleccionar archivos con la extension PDF", "Error", JOptionPane.ERROR_MESSAGE);
                        lblEstatus.setText("ERROR");
                        archivo = null;
                    } else {
                        //JOptionPane.showMessageDialog(vista, "Debes de seleccionar archivos con la extension PDF", "Error", JOptionPane.ERROR_MESSAGE);
                        lstFilesBoletas[semestre] = archivo;
                        lblEstatus.setText("¡OK!");
                    }
                }
                
                break;
                
            case 2:
                if (select == JFileChooser.APPROVE_OPTION) {
                    archivo = selector.getSelectedFile();
                    String nombreArchivo = archivo.getName();
                    String extension = nombreArchivo.substring(nombreArchivo.length() - 3, nombreArchivo.length());
                    if (!extension.equals("pdf")
                            && !extension.equals("PDF")) {
                        JOptionPane.showMessageDialog(vista, "Debes de seleccionar archivos con la extension PDF", "Error", JOptionPane.ERROR_MESSAGE);
                        lblEstatus.setText("ERROR");
                        archivo = null;
                    } else {
                        //JOptionPane.showMessageDialog(vista, "Debes de seleccionar archivos con la extension PDF", "Error", JOptionPane.ERROR_MESSAGE);
                        lstFilesCartaServCom[semestre] = archivo;
                        lblEstatus.setText("¡OK!");
                    }
                }
                
                break;
                
            case 3:
                if (select == JFileChooser.APPROVE_OPTION) {
                    archivo = selector.getSelectedFile();
                    String nombreArchivo = archivo.getName();
                    String extension = nombreArchivo.substring(nombreArchivo.length() - 3, nombreArchivo.length());
                    if (!extension.equals("pdf")
                            && !extension.equals("PDF")) {
                        JOptionPane.showMessageDialog(vista, "Debes de seleccionar archivos con la extension PDF", "Error", JOptionPane.ERROR_MESSAGE);
                        lblEstatus.setText("ERROR");
                        archivo = null;
                    } else {
                        //JOptionPane.showMessageDialog(vista, "Debes de seleccionar archivos con la extension PDF", "Error", JOptionPane.ERROR_MESSAGE);
                        lstFilesTransferencias[semestre] = archivo;
                        lblEstatus.setText("¡OK!");
                    }
                }
                break;
        }
    }

    /**
     * Borra el documento seleccionado
     *
     * @param archivo
     * @param lblEstatus
     * @return
     */
    protected File borraDocumento(File archivo, JLabel lblEstatus) {
        archivo = null;
        lblEstatus.setText("Eliminado");
        return archivo;
    }
    
    /**
     * Borra de memoria una boleta o una carta de servicio social
     * @param semestre
     * @param etiqueta
     * @param codigo 1.- Carga las boletas.
     * 2.- Carga las cartas del servicio comunitario
     */
    protected void borraBoletaOrCartaServComTransferencia(int semestre, JLabel etiqueta, int codigo){
        
        switch(codigo){
            case 1:
                lstFilesBoletas[semestre] = null;
                etiqueta.setText("¡Borrado!");
                break;
                
            case 2:
                lstFilesCartaServCom[semestre] = null;
                etiqueta.setText("¡Borrado!");
                break;
                
            case 3:
                lstFilesTransferencias[semestre] = null;
                etiqueta.setText("¡Borrado!");
        }
    }

    /**
     * Agrega un componente a su respectivo JPanel
     *
     * @param componente JPanel que se quiere agregar
     */
    protected void agregaJPanel(JComponent componente) {
        if (componente instanceof PnlParentesco) {
            PnlParentesco pnlParentesco = new PnlParentesco();
            pnlParentesco.setControlador(this);

            lstVistaParentesco.add(pnlParentesco);
//            pnlParentesco.lblAgregarPariente.setVisible(false);
            llenaComboCategorias(pnlParentesco.cmbNivelEstudiosPariente, catNivelEstudios);
            llenaComboCategorias(pnlParentesco.cmbParentesco, catParentesco);
//            lstVistaParentesco.get(0).lblAgregarPariente.setVisible(false);
            helper.agregaJPanel(pnlParentesco, vistaRegistro.pnlParentesco);
        }

        if (componente instanceof PnlDireccion) {
            PnlDireccion pnlDireccion = new PnlDireccion();
            pnlDireccion.setControlador(this);
            pnlDireccion.lblAgregarDireccion.setVisible(false);
            lstVistaDireccion.add(pnlDireccion);
            lstVistaDireccion.get(0).lblAgregarDireccion.setVisible(false);
            System.out.println("Esto es de dirección");
            helper.agregaJPanel(pnlDireccion, vistaRegistro.pnlDirecciones);
        }

        if (componente instanceof PnlHermanos) {
            PnlHermanos pnlHermanos = new PnlHermanos();
            pnlHermanos.setControlador(this);
            lstVistaHermanos.add(pnlHermanos);
            llenaComboCategorias(pnlHermanos.cmbNivelEstudiosHermano, catNivelEstudios);

            System.out.println("Esto es de Hermanos");
            helper.agregaJPanel(pnlHermanos, vistaRegistro.pnlHermanos);
        }

        if (componente instanceof PnlHijos) {
            PnlHijos pnlHijos = new PnlHijos();
            pnlHijos.setControlador(this);
            lstVistaHijos.add(pnlHijos);
            System.out.println("Esto es de Hijos");
            helper.agregaJPanel(pnlHijos, vistaRegistro.pnlHijos);
        }

        if (componente instanceof VistaRegistroOpcionActualizar) {
            vistaRegistro.pnlOpciones.removeAll();
            vistaOpcionActualizar = new VistaRegistroOpcionActualizar();
            vistaOpcionActualizar.setControlador(this);
            vistaRegistro.pnlOpciones.add(vistaOpcionActualizar, BorderLayout.CENTER);
            vistaOpcionActualizar.setVisible(true);
            vistaRegistro.updateUI();
        }

        addListenerTeclasVistaRegistro();
        vistaRegistro.repaint();
        vista.repaint();
    }

    /**
     * Elimina el ultimo jpanel agregado
     *
     * @param componente Componente a eliminar
     */
    protected void borraJpanel(JComponent componente) {
        if (componente instanceof PnlParentesco) {
            int tamanio = lstVistaParentesco.size();
            helper.borraJpanel(lstVistaParentesco.get(lstVistaParentesco.size() - 1), vistaRegistro.pnlParentesco);
            lstVistaParentesco.remove(lstVistaParentesco.size() - 1);
//            lstVistaParentesco.get(lstVistaParentesco.size() - 1).lblAgregarPariente.setVisible(true);
//            System.out.println("Esto es de dirección");
//            if (tamanio == 1) {
//                lstVistaParentesco.get(0).lblBorrarPariente.setVisible(false);
//            }
        }

        if (componente instanceof PnlDireccion) {
            int tamanio = lstVistaDireccion.size();
            helper.borraJpanel(lstVistaDireccion.get(tamanio - 1), vistaRegistro.pnlDirecciones);
            lstVistaDireccion.remove(tamanio - 1);
            lstVistaDireccion.get(lstVistaDireccion.size() - 1).lblAgregarDireccion.setVisible(true);
            System.out.println("Esto es de dirección");
            if (tamanio == 1) {
                lstVistaDireccion.get(0).lblBorrarDireccion.setVisible(false);
            }
        }
        if (componente instanceof PnlHermanos) {
            int tamanio = lstVistaHermanos.size();
            helper.borraJpanel(lstVistaHermanos.get(lstVistaHermanos.size() - 1), vistaRegistro.pnlHermanos);
            lstVistaHermanos.remove(tamanio - 1);
            lstVistaHermanos.get(lstVistaHermanos.size() - 1).lblAgregarHermano.setVisible(true);
            System.out.println("Esto es de dirección");
            if (tamanio == 1) {
                lstVistaHermanos.get(tamanio - 1).lblBorrarHermano.setVisible(false);
            }
        }

        if (componente instanceof PnlHijos) {
            int tamanio = lstVistaHijos.size();
            helper.borraJpanel(lstVistaHijos.get(tamanio - 1), vistaRegistro.pnlHijos);
            lstVistaHijos.remove(tamanio - 1);
            lstVistaHijos.get(lstVistaHijos.size() - 1).lblAgregarHijos.setVisible(true);
            System.out.println("Esto es de dirección");
            if (tamanio == 1) {
                lstVistaHijos.get(0).lblBorrarHijos.setVisible(false);
            }
        }

        if (componente instanceof VistaRegistroOpcionGuardar) {
        }

        addListenerTeclasVistaRegistro();
        vistaRegistro.repaint();
        vista.repaint();
    }

    /**
     * Comienza la insersión del becario, en caso de que falten datos generales
     * de llenar se guarda como pendiente
     */
    protected void insertaNuevoBecario() {

        boolean vacio = validaCamposVacios();

        // Si hay campos vacios en el formulario se pregunta si se quiere guardar el becario y llenarlo después
        if (vacio) {
            int i = JOptionPane.showConfirmDialog(vistaRegistro, "¿Desea guardar y continuar después?", "Alerta, Campos Vacios", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (i == JOptionPane.OK_OPTION) {
                //Se valida que los correos electronicos sean iguales
                boolean email = helper.validaEmail(vistaRegistro.txtCorreoBecario.getText(),
                        vistaRegistro.txtCorreoBecario2.getText());
                
                boolean fecha = helper.validaFechaNacimiento(vistaRegistro.txtFechaNacimiento, vista);

                //Si los email son iguales se procede a tomar los valores e insertarlos
                if (email && fecha) {
                //if (email) {
                    insertBecario(true);
                } else if (email == false) {
                    JOptionPane.showMessageDialog(vistaRegistro, "Correos electrónicos diferentes",
                            "Verifica los correos electrónicos", JOptionPane.WARNING_MESSAGE);
                    vistaRegistro.txtCorreoBecario.setBackground(Color.ORANGE);
                    vistaRegistro.txtCorreoBecario2.setBackground(Color.ORANGE);
                }

            }
        } //Si el formulario fue llenado en su totalidad...
        else {
            //Se valida que los correos electronicos sean iguales
            boolean email = helper.validaEmail(vistaRegistro.txtCorreoBecario.getText(),
                    vistaRegistro.txtCorreoBecario2.getText());
            boolean fecha = helper.validaFechaNacimiento(vistaRegistro.txtFechaNacimiento, vista);
            //Si los email son iguales se procede a tomar los valores e insertarlos
            if (email && fecha) {
            //if (email) {
                int i = JOptionPane.showConfirmDialog(vistaRegistro, "¿Está seguro de asignar al becario en el programa " + vistaRegistro.comboBoxPrograma.getSelectedItem(), "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(i == JOptionPane.OK_OPTION)
                    insertBecario(false);
            } else if (email == false) {
                JOptionPane.showMessageDialog(vistaRegistro, "Correos electrónicos diferentes",
                        "Verifica los correos electrónicos", JOptionPane.WARNING_MESSAGE);
                vistaRegistro.txtCorreoBecario.setBackground(Color.ORANGE);
                vistaRegistro.txtCorreoBecario2.setBackground(Color.ORANGE);
            }

        }

    }

    /**
     * Inserta el becario en la base de datos
     *
     * @param bandera True si es un becario borrador, False si es un becario
     * completo
     */
    private void insertBecario(boolean bandera) {

        //Se crean las variables donde se alojaran los archivos adjuntos
//        File fileFotoDest;
//        File fileActaNacimientoDest;
//        File fileBoleta_calificaciones_inicialDest;
//        File fileCarta_solicitudDest;
//        File fileEnsayoDest;
//        File fileIneBecarioDest;
//        File fileIneAvalDest;
//        File fileContratoDest;
//        File filePagareDest;

        Conexion conn = new Conexion();
        Connection conexion = conn.estableceConexion();
        if (conexion == null) {
            JOptionPane.showMessageDialog(vista, "No se puede conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            log.crearLog(new SQLException("No se pudo conectar a la base de datos").getMessage());
            return;
        }

        //Se obtienen los valores del nuevo becario
        Becario becario = getDatosBecarioDeFormulario(conexion, true);
        if (becario == null) {
            return;
        }

        List<Direccion> lstDireccionesBecario = getDireccionBecarioDeFormulario(becario.getId());
        List<Telefono> lstTelefonosBecario = getTelefonoBecarioDeFormulario(becario.getId());
        List<Padres> lstPadresBecario = getPadresBecarioDeFormulario(becario.getId());
        List<Hermanos> lstHermanos = getHermanosDeFormulario(becario.getId());
        List<Hijos> lstHijos = getHijosDeFormulario(becario.getId());
        DatosEscolares lstDatosEscolares = getDatosEscolaresDeFormulario(becario.getId());
        Aval lstAval = getAvalDeFormulario(becario.getId(), becario.getFolio());

        //Se inicia la transacción para la inserción del becario
        try {
            conexion.setAutoCommit(false);

            long idBecario = modelo.insertBecario(bandera, conexion, becario);
            //Si no se pudo insertar el becario
            if (idBecario == 0) {
                throw new SQLException();
            }
            //Se insertan las direcciones
            boolean direccion = modelo.insertDireccionBecario(conexion, idBecario, lstDireccionesBecario);
            if (direccion == false) {
                throw new SQLException();
            }
            //Se insertan los telefonos
            boolean telefono = modelo.insertTelefonoBecario(conexion, idBecario, lstTelefonosBecario);
            if (telefono == false) {
                throw new SQLException();
            }
            //Se insertan los padres
            boolean papas = modelo.insertPapasBecario(conexion, idBecario, lstPadresBecario);
            if (papas == false) {
                throw new SQLException();
            }
            //Se insertan los hermanos
            boolean hermanos = modelo.insertHermanosBecario(conexion, idBecario, lstHermanos);
            if (hermanos == false) {
                throw new SQLException();
            }
            //Se insertan los hijos
            boolean hijos = modelo.insertHijosBecario(conexion, idBecario, lstHijos);
            if (hijos == false) {
                throw new SQLException();
            }

            //Se insertan los datos escolares
            boolean datosEscolares = modelo.insertDatosEscolaresBecario(conexion, idBecario, lstDatosEscolares);
            if (datosEscolares == false) {
                throw new SQLException();
            }

            //Se insertan los datos del aval
            boolean aval = modelo.insertAval(conexion, idBecario, lstAval);
            if (aval == false) {
                throw new SQLException();
            }

            //Se aumenta el contador del folio
            boolean contador = modelo.updateContadorPrograma(conexion, becario.getInicialesFolio());
            if (contador == false) {
                throw new SQLException();
            }
            conexion.commit();
            numeroFolio = becario.getFolio();
            JOptionPane.showMessageDialog(vista, "Becario registrado correctamente \n"
                    + "Número de folio: " + becario.getFolio(), "Éxito", JOptionPane.INFORMATION_MESSAGE);

            VistaRegistroOpcionActualizar opcion = new VistaRegistroOpcionActualizar();
            agregaJPanel(opcion);
            vistaRegistro.comboBoxPrograma.setEnabled(false);
            vistaRegistro.cmbEstatus.setEnabled(false);
            vistaRegistro.txtFolio.setText(becario.getFolio());

            vistaRegistro.tbpBecados.setSelectedIndex(0);
        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                log.crearLog(ex.getMessage());
                Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(vista, "Error al guardar al becario", "Error de inserción", JOptionPane.ERROR_MESSAGE);
            log.crearLog(e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                log.crearLog(ex.getMessage());
                Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Actualiza la informacion del becario en cuestión
     */
    protected void UpdateBecario() {
        helper.cursorEspera(vista);
        boolean vacio = validaCamposVacios();

        // Si hay campos vacios en el formulario se pregunta si se quiere guardar el becario y llenarlo después
        if (vacio) {
            int i = JOptionPane.showConfirmDialog(vistaRegistro, "¿Desea guardar y continuar después?", "Alerta, Campos Vacios", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (i == JOptionPane.OK_OPTION) {
                //Se valida que los correos electronicos sean iguales
                boolean email = helper.validaEmail(vistaRegistro.txtCorreoBecario.getText(),
                        vistaRegistro.txtCorreoBecario2.getText());
                boolean fecha = helper.validaFechaNacimiento(vistaRegistro.txtFechaNacimiento, vista);

                //Si los email son iguales se procede a tomar los valores e insertarlos
                if (email && fecha) {
                //if (email) {
                    updateBecario();
                } else if (email == false) {
                    helper.cursorNormal(vista);
                    JOptionPane.showMessageDialog(vistaRegistro, "Correos electrónicos diferentes",
                            "Verifica los correos electrónicos", JOptionPane.WARNING_MESSAGE);
                }

            }
        } //Si el formulario fue llenado en su totalidad...
        else {
            //Se valida que los correos electronicos sean iguales
            boolean email = helper.validaEmail(vistaRegistro.txtCorreoBecario.getText(),
                    vistaRegistro.txtCorreoBecario2.getText());
            boolean fecha = helper.validaFechaNacimiento(vistaRegistro.txtFechaNacimiento, vista);
            //Si los email son iguales se procede a tomar los valores e insertarlos
            if (fecha) {
                if (email) 
                    updateBecario();
                else
                    JOptionPane.showMessageDialog(vistaRegistro, "Correos electrónicos diferentes",
                            "Verifica los correos electrónicos", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        helper.cursorNormal(vista);
    }

    /**
     * Actualiza los datos de la vista registro del becario
     *
     */
    private void updateBecario() {
        Conexion conn = new Conexion();
        Connection conexion = conn.estableceConexion();

        if (conexion == null) {
            JOptionPane.showMessageDialog(vista, "No se puede conectar a la base de datos, Intentalo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            log.crearLog(new SQLException("No se pudo conectar a la base de datos").getMessage());
            return;
        }

        Becario becario = getDatosBecarioDeFormulario(conexion, false);

        List<Direccion> lstDireccionesBecario = getDireccionBecarioDeFormulario(becario.getId());
        List<Telefono> lstTelefonosBecario = getTelefonoBecarioDeFormulario(becario.getId());
        List<Padres> lstPadresBecario = getPadresBecarioDeFormulario(becario.getId());
        List<Hermanos> lstHermanos = getHermanosDeFormulario(becario.getId());
        List<Hijos> lstHijos = getHijosDeFormulario(becario.getId());
        DatosEscolares lstDatosEscolares = getDatosEscolaresDeFormulario(becario.getId());
        Aval lstAval = getAvalDeFormulario(becario.getId(), becario.getFolio());

        //Se inicia la transacción para la inserción del becario
        try {
            conexion.setAutoCommit(false);

            boolean idBecario = modelo.updateBecario(conexion, becario);
            //Si no se pudo actualizar el becario
            if (idBecario == false) {
                throw new SQLException("Error al actualizar los datos del becario");
            }
            //Se actualizan las direcciones
            boolean direccion = modelo.updateDireccionBecario(conexion, becario.getId(), lstDireccionesBecario);
            if (direccion == false) {
                throw new SQLException("Error al actualizar las direcciones del becario");
            }
            //Se actualizan los telefonos
            boolean telefono = modelo.updateTelefonoBecario(conexion, becario.getId(), lstTelefonosBecario);
            if (telefono == false) {
                throw new SQLException();
            }
            //Se actualizan los padres
            boolean papas = modelo.updatePapasBecario(conexion, becario.getId(), lstPadresBecario);
            if (papas == false) {
                throw new SQLException();
            }
            //Se actualizan los hermanos
            boolean hermanos = modelo.updateHermanosBecario(conexion, becario.getId(), lstHermanos);
            if (hermanos == false) {
                throw new SQLException();
            }
            //Se actualizan los hijos
            boolean hijos = modelo.updateHijosBecario(conexion, becario.getId(), lstHijos);
            if (hijos == false) {
                throw new SQLException();
            }

            //Se actualizan los datos escolares
            boolean datosEscolares = modelo.updateDatosEscolares(conexion, becario.getId(), lstDatosEscolares);
            if (datosEscolares == false) {
                throw new SQLException();
            }

            //Se actualizan los datos del aval
            boolean aval = modelo.updateAval(conexion, becario.getId(), lstAval);
            if (aval == false) {
                throw new SQLException();
            }

            conexion.commit();
            JOptionPane.showMessageDialog(vista, "Becario actualizado correctamente \n", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                log.crearLog(ex.getMessage());
                Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(vista, "Error al guardar al becario", "Error de inserción", JOptionPane.ERROR_MESSAGE);
            log.crearLog(e.getMessage());
        } finally {
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
     *
     * @param conexion Conexion a la base de datos
     * @param updateOrInsert True para Inserts, False para Updates
     * @return Un becario con sus propiedades
     */
    private Becario getDatosBecarioDeFormulario(Connection conexion, boolean updateOrInsert) {
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
        if (updateOrInsert) {
            becario.setFolio(modelo.creaFolio(conexion, becario));
        } else {
            becario.setFolio(vistaRegistro.txtFolio.getText());
        }
        //Se obtiene el estatus del becario
        int estatus = vistaRegistro.cmbEstatus.getSelectedIndex();
        if (estatus == 0) //estatus becario
        {
            becario.setIdEstatus(1);
        } else //Estatus exalumno
        {
            becario.setIdEstatus(3);
        }
        //Se obtiene el estado civil
        String edoCiv = getSeleccionCmbBox(vistaRegistro.combobxCivilBecado);
        becario.setIdEstadoCivil(getIdCmbBox(edoCiv, catEstadoCivil));
        //Se obtiene si trabaja o no
        becario.setTrabaja(vistaRegistro.comboBxTrabajaBecado.getSelectedIndex());
        String sexo = (String) vistaRegistro.combobxSexoBecado.getSelectedItem();
        //Se obtiene el id del sexo
        becario.setIdSexo(getIdCmbBox(sexo, catSexo));
        //Se obtiene el nombreTabla del becario
        becario.setNombre(vistaRegistro.txtNombreBecado.getText());
        //Se obtiene el ap paterno del becario
        becario.setApPaterno(vistaRegistro.txtApPaternoBecado.getText());
        //Se obtiene el ap materno del becario
        becario.setApMaterno(vistaRegistro.txtApMaternoBecado.getText());
        //Se obtiene la fecha de nacimiento del becario
        if (vistaRegistro.txtFechaNacimiento.getText().length() > 0) {
            long fecha = getFecha(vistaRegistro.txtFechaNacimiento.getText());
            becario.setFecha_nac(new Date(fecha));
        }
        
        //java.util.Date fechaNac = helper.getFechaDateChooser(vistaRegistro.txtFechaNacimiento);
//        if(fechaNac == null)
//            return null;
//        becario.setFecha_nac(helper.convertUtilDateToSqlDate(fechaNac));
        
        //Se obtiene los datos del conyuge
        becario.setNombreConyuge(vistaRegistro.txtNombreConyuge.getText());
        becario.setApPaternoConyuge(vistaRegistro.txtApPaternoConyuge.getText());
        becario.setApMaternoConyuge(vistaRegistro.txtApMaternoConyuge.getText());
        becario.setOcupacionConyuge(vistaRegistro.txtOcupacionConyuge.getText());
        becario.setTelefonoConyuge(vistaRegistro.txtTelefonoConyuge.getText());
        //Se obtiene si es el primero con beca
        becario.setPrimeroConBeca(vistaRegistro.cmboxCarreraSiNo.getSelectedIndex());
        //Se obtiene el correo electronico
        becario.setEmail(vistaRegistro.txtCorreoBecario.getText());
        //Se obtienen los comentarios
        becario.setObservaciones(vistaRegistro.txtAreaObservaciones.getText());

        //Se obtiene el id del becario en caso de que sea una actualización o eliminación
        if (updateOrInsert == false) {
            becario.setId(modelo.getIdBecarioPorFolio(conexion, becario.getFolio()));
            //Se verifica
            if (becario.getId() == 0) {
                JOptionPane.showMessageDialog(vista, "Error al obtener el identificador del becario, intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        //Se carga la foto
        if (fileFoto != null) {
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "foto-", fileFoto);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar la foto", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                becario.setFoto(becario.getFolio() + Index.SEPARADOR + path.getFileName().toString());
            }
        }

        //Se carga el acta de nacimiento
        if (fileActaNacimiento != null) {
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "acta_nacimiento-", fileActaNacimiento);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar el acta de nacimiento", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                becario.setActaNacimiento(becario.getFolio() + Index.SEPARADOR + path.getFileName().toString());
            }
        }

        //Se carga la boleta de calificaciones inicial
        if (fileBoleta_calificaciones_inicial != null) {
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "boleta_inicial-", fileBoleta_calificaciones_inicial);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar la boleta", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                becario.setBoletaInicioBeca(becario.getFolio() + Index.SEPARADOR + path.getFileName().toString());
            }
        }

        //Se carga la carta solicitud de beca
        if (fileCarta_solicitud != null) {
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "carta_solicitud-", fileCarta_solicitud);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar la solicitud de la beca", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                becario.setSolicitudBeca(becario.getFolio() + Index.SEPARADOR + path.getFileName().toString());
            }
        }

        //Se carga el contrato
        if (fileContrato != null) {
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "contrato-", fileContrato);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar el contrato", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                becario.setContatoBeca(becario.getFolio() + Index.SEPARADOR + path.getFileName().toString());
            }
        }

        //Se carga el ensayo
        if (fileEnsayo != null) {
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "ensayo-", fileEnsayo);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar el ensayo", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                becario.setEnsayo(becario.getFolio() + Index.SEPARADOR + path.getFileName().toString());
            }
        }

        //Se carga la identificacion del becario
        if (fileIneBecario != null) {
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "ine_becario-", fileIneBecario);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar la identificacion del becario", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                becario.setIdentificacion(becario.getFolio() + Index.SEPARADOR + path.getFileName().toString());
            }
        }

        //Se carga el pagare del becario
        if (filePagare != null) {
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "pagare-", filePagare);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar el pagaré", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                becario.setPagare(becario.getFolio() + Index.SEPARADOR + path.getFileName().toString());
            }
        }

        //Se carga el estudio socioeconomico del becario
        if (fileEstudioSocioeconomico != null) {
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "est_socioeco-", filePagare);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar el estudio socieconómico", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                becario.setEstudioSocioEconomico(becario.getFolio() + Index.SEPARADOR + path.getFileName().toString());
            }
        }

        //Se carga la carta de asignacion de beca del becario
        if (fileCartaAsignacionBeca != null) {
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "asig_beca-", fileCartaAsignacionBeca);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar la carta de asignación de beca", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                becario.setCartaAsignacionBeca(becario.getFolio() + Index.SEPARADOR + path.getFileName().toString());
            }
        }
        
        //Se carga la carta de agradecimiento de beca del becario
        if (fileCartaAgradecimiento != null) {
            Path path = helper.CopiaArchivoADestino(becario.getFolio(), "agradecimiento-", fileCartaAgradecimiento);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar la carta de asignación de beca", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                becario.setCartaAgradecimiento(becario.getFolio() + Index.SEPARADOR + path.getFileName().toString());
            }
        }

        return becario;
    }

    /**
     * Obtiene la(s) direccion(es) del nuevo becario
     *
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
            if (panel.txtCPBecado.getText().length() > 0) {
                direccion.setCodigoPostal(Integer.parseInt(panel.txtCPBecado.getText()));
            }
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
     *
     * @param idBecario Id del becario con el que se relaciona los telefonos
     * @return Lista de Telefonos del becario
     */
    private List<Telefono> getTelefonoBecarioDeFormulario(long idBecario) {
        List<Telefono> lstTelefono = new ArrayList<>();
        if (!vistaRegistro.txtTel1Becado.getText().equals("")) {
            Telefono telefono = new Telefono();
            //Se agrega el becario
            telefono.setIdBecario(idBecario);
            //Se agrega el primer teléfono
            telefono.setTelefono(vistaRegistro.txtTel1Becado.getText());
            //Se agrega a la lista el teléfono
            lstTelefono.add(telefono);
        }
        if (!vistaRegistro.txtTel2Becado.getText().equals("")) {
            Telefono telefono = new Telefono();
            //Se agrega el becario
            telefono.setIdBecario(idBecario);
            //Se agrega el primer teléfono
            telefono.setTelefono(vistaRegistro.txtTel2Becado.getText());
            //Se agrega a la lista el teléfono
            lstTelefono.add(telefono);
        }
        if (!vistaRegistro.txtTel3Becado.getText().equals("")) {
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
     *
     * @param idBecario Id del becario
     * @return Lista con los datos de los padres
     */
    private List<Padres> getPadresBecarioDeFormulario(long idBecario) {
        List<Padres> lstResult = new ArrayList<>();
        for (PnlParentesco panel : lstVistaParentesco) {
            Padres padre = new Padres();
            //Se obtiene el nombreTabla del hijo
            padre.setNombre(panel.txtNombresPariente.getText());
            //Se obtiene el apellido paterno del hijo
            padre.setaPaterno(panel.txtApPaternoPariente.getText());
            //Se obtiene el apellido materno de la madre
            padre.setaMaterno(panel.txtApMaternoPariente.getText());
            //Se obtiene el grado de estudio
            String grado = (String) panel.cmbNivelEstudiosPariente.getSelectedItem();
            //Se asigna el grado de estudio
            padre.setGradoEscolar(getIdCmbBox(grado, catNivelEstudios));
            //Se obtiene si trabaja 
            padre.setTrabaja(panel.cmbTrabajoActivoPariente.getSelectedIndex());
            //Se obtiene el becario
            padre.setIdBecario(idBecario);
            //Se obtiene si es hijo o madre
            String parentesco = (String) panel.cmbParentesco.getSelectedItem();
            //Se asigna el parentesco
            padre.setParenteco(getIdCmbBox(parentesco, catParentesco));
            //Se asigna la ocupacion
            padre.setOcupacion(panel.txtOcupacion.getText());
            //Se asigna el telefono
            padre.setTelefono(panel.TxtTelPariente.getText());

            lstResult.add(padre);
        }

        return lstResult;
    }

    /**
     * Obtiene los datos del(los) hijo(s) del becario
     *
     * @param idBecario Id del becario
     * @return LIsta con los datos de los hermanos
     */
    private List<Hermanos> getHermanosDeFormulario(long idBecario) {
        List<Hermanos> lstResult = new ArrayList<>();

        for (PnlHermanos panel : lstVistaHermanos) {
            Hermanos hermano = new Hermanos();
            //Se obtiene el nombreTabla del hijo
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
            //Se obtienen los comentarios
            hermano.setComentario(panel.txtAreaComentario.getText());
            //Se agregra a la lista el hijo
            lstResult.add(hermano);
        }

        return lstResult;
    }

    /**
     * Obtiene los datos del(los) hijo(s) del becario
     *
     * @param idBecario Id del becario
     * @return Lista con los datos de los hijos
     */
    private List<Hijos> getHijosDeFormulario(long idBecario) {
        List<Hijos> lstResult = new ArrayList<>();

        for (PnlHijos panel : lstVistaHijos) {
            Hijos hijo = new Hijos();
            //Se obtiene el nombreTabla del hijo
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
     *
     * @param idBecario
     * @return
     */
    private DatosEscolares getDatosEscolaresDeFormulario(long idBecario) {
        DatosEscolares datos = new DatosEscolares();
        //Se obtiene el nombreTabla de la carrera
        datos.setNombreCarrera(vistaRegistro.txtNombreCarrera.getText());
        //Se obtiene el campo de la carrera
        String campo = (String) vistaRegistro.cmboxCampoEscuela.getSelectedItem();
        //Se obtiene el campo de estudio de la carrera
        datos.setIdCampoCarrera(getIdCmbBox(campo, catCampoEstudio));
        //Se obtiene la universidad de estudio
        String universidad = (String) vistaRegistro.cmboxEscuelaUniversitaria.getSelectedItem();
        //Se asigna la universidad
        datos.setIdUniversidad(getIdCmbBox(universidad, catUniversidad));

        //Se obtiene si la universidad es publica o privada
        String tipoEscuela = (String) vistaRegistro.cmbTipoEscuela.getSelectedItem();

        datos.setIdTipoEscuela(getIdCmbBox(tipoEscuela, catTipoEscuela));
        //Se obtiene el nombreTabla de la preparatoria
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
        if (vistaRegistro.txtBecaAutorizada.getText().length() > 0) {
            String dato = vistaRegistro.txtBecaAutorizada.getText().replace(",", "");
            dato = dato.replace(".", "");
            datos.setBecaTotal(Integer.parseInt(dato));
        }
        //Se obtiene el idEscuela semestral de la beca
        if (vistaRegistro.txtBecaPorSemestre.getText().length() > 0) {
            String dato = vistaRegistro.txtBecaPorSemestre.getText().replace(",", "");
            dato = dato.replace(".", "");
            datos.setBecaSemestral(Integer.parseInt(dato));
        }
        //Se obtiene el costo de la carrera
        if (vistaRegistro.txtCostoCarrera.getText().length() > 0) {
            String dato = vistaRegistro.txtCostoCarrera.getText().replace(",", "");
            dato = dato.replace(".", "");
            datos.setCostoCarrera(Integer.parseInt(dato));
        }
        return datos;
    }

    /**
     * Obtiene los datos del aval del formulario de registro
     *
     * @param id ID del becario
     * @return Objeto Aval
     */
    private Aval getAvalDeFormulario(long id, String folio) {
        Aval aval = new Aval();

        //Se carga el acta de nacimiento
        if (fileIneAval != null) {
            Path path = helper.CopiaArchivoADestino(folio, "ine_aval-", fileActaNacimiento);
            aval.setIdBecario(id);
            if (path == null) {
                JOptionPane.showMessageDialog(vista, "Error al copiar la identificacion del aval", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                aval.setIdentificacion(path.toString());
            }
        }

        return aval;
    }

    /**
     * Obtiene la seleccion de un combo box
     *
     * @param combo Combo box que se evaluará
     * @return Selección
     */
    private String getSeleccionCmbBox(JComboBox combo) {
        String seleccion = (String) combo.getSelectedItem();

        return seleccion;
    }

    /**
     * Obtiene el id de la seleccion del usuario en un combo box
     *
     * @param cadena Nombre de la seleccion del usuario
     * @param categorias Listado de categorias a comparar
     * @return Id de la seleccion del usuario
     * @throws NullPointerException En caso de que no se encuentre el id de la
     * selección
     */
    private int getIdCmbBox(String cadena, LinkedHashMap<Integer, String> categorias) throws NullPointerException {
        int idCategoria = 0;
        for (Integer key : categorias.keySet()) {
            if (cadena.equals(categorias.get(key))) {
                idCategoria = key;
            }
        }

        if (idCategoria == 0) {
            log.crearLog(new NullPointerException("Id no encontrado").getMessage());
        }
        return idCategoria;
    }

    /**
     * Obtiene el nombreTabla de un item de un combo box
     *
     * @param id
     * @param categorias
     * @return
     * @throws NullPointerException
     */
    private String getItemComboBox(int id, LinkedHashMap<Integer, String> categorias) throws NullPointerException {
        String seleccion = "";

        for (Integer key : categorias.keySet()) {
            if (id == key) {
                seleccion = categorias.get(key);
            }
        }

        if (seleccion.equals("")) {
            log.crearLog(new NullPointerException("Nombre de categoria no encontrado").getMessage());
        }
        return seleccion;

    }

    /**
     * Obtiene la fecha capturada y la convierte a a TIMESTAMP
     *
     * @param fecha
     * @return TIMESTAMP DE LA FECHA
     */
    private long getFecha(String fecha) {
        String[] fech = fecha.split("/");
        int anio = Integer.parseInt(fech[2]);
        int mes = Integer.parseInt(fech[1]);
        int dia = Integer.parseInt(fech[0]);
        Calendar calendario = new GregorianCalendar(anio, mes - 1, dia);
        long result = calendario.getTimeInMillis();

        return result;
    }

    /**
     * Recorre todos los componentes dentro de un JPanel
     *
     * @param clave 1: Valida si hay campos vacios, 2: Vacia los campos, 3:
     * Asigna listeners a los JTextField de pnlKardex de vistaKardex, 4: Asigna
     * listeners a los JtextField de pnlInformacionBancaria de VistaKardex, 5:
     * Deshabilita los componentes que contiene un jpanel. 6: Asigna listeners
     * para evaluar el descuento por semestre
     * @param panel Jpanel a recorrer
     * @return True si encontró campos vacios, false si no
     */
    private boolean recorreJPanel(JPanel panel, int clave) {
        Component[] componentes = panel.getComponents();
        boolean response = false;
        switch (clave) {
            case 1:
                for (Component componente : componentes) {
                    if (componente instanceof JPanel) {
                        response = recorreJPanel((JPanel) componente, 1);
                    }
                    if (componente instanceof JTextField) {
                        //Si el campo tiene un nombreTabla quiere decir que puede estar vacio
                        if (((JTextField) componente).getName() != null) {
                            continue;
                        }
                        if (((JTextField) componente).getText().equals("")) {
                            ((JTextField) componente).setBackground(Color.ORANGE);
                            response = true;
                        }
                    }
                }
                break;

            case 2:
                for (Component componente : componentes) {
                    if (componente instanceof JPanel) {
                        ((JPanel) componente).removeAll();
                    }
                }
                vaciaLstVistas();
                break;

            case 3:
                for (Component componente : componentes) {
                    if (componente instanceof JPanel) {
                        response = recorreJPanel((JPanel) componente, 3);
                    }
                    if (componente instanceof JTextField) {
//                        ((JTextField) componente).setBackground(Color.ORANGE);
//                        response = true;
                        JTextField txtCampo = ((JTextField) componente);
                        txtCampo.addKeyListener(new EscuchadorValidaEntrada(vistaKardex.PnlKardex, EscuchadorValidaEntrada.DECIMALES, txtCampo));
                    }
                }
                break;

            case 4:
                for (Component componente : componentes) {
                    if (componente instanceof JPanel) {
                        response = recorreJPanel((JPanel) componente, 4);
                    }
                    if (componente instanceof JTextField) {
                        JTextField txtCampo = ((JTextField) componente);
                        txtCampo.addKeyListener(new EscuchadorValidaEntrada(vistaKardex, EscuchadorValidaEntrada.NUMEROS, txtCampo));
                    }
                }
                break;

            case 6:
                int i = -1;
                for (Component componente : componentes) {
                    if (i == -1) {
                        i++;
                        continue;
                    }

                    if (componente instanceof JPanel) {
                        JPanel jPanel = ((JPanel) componente);

                        JCheckBox chkPlatica1 = (JCheckBox) jPanel.getComponent(5);
                        JCheckBox chkPlatica2 = (JCheckBox) jPanel.getComponent(6);
                        JTextField txtPromedio = (JTextField) jPanel.getComponent(9);
                        JTextField txtDescuento = (JTextField) jPanel.getComponent(10);

                        chkPlatica1.addItemListener(new EscuchadorCmbBoxCambiado(chkPlatica1, chkPlatica2,
                                txtPromedio, txtDescuento, EscuchadorCmbBoxCambiado.DESCUENTO_BECA));
                        chkPlatica2.addItemListener(new EscuchadorCmbBoxCambiado(chkPlatica1, chkPlatica2,
                                txtPromedio, txtDescuento, EscuchadorCmbBoxCambiado.DESCUENTO_BECA));
                        txtPromedio.addKeyListener(new EscuchadorCalculaDescuentoSemestral(chkPlatica1,
                                chkPlatica2, txtPromedio, txtDescuento));

                    }
                }
                break;
        }
        return response;
    }

    /**
     * Llena con la informacion del kardex del becario la tabla del kardex
     *
     * @param lstKardex
     * @param lstFechaSemestre Indica las fechas iniciales de cada semestre
     * @param semestresHabilitados
     */
    private void llenaPnlKardex(List<Kardex> lstKardex, List<Calendar> lstFechaSemestre) {

        Component[] componentes = vistaKardex.PnlKardex.getComponents();
        int i = -1;
        for (Component componente : componentes) {
            if (i == -1) {
                i++;
                continue;
            }
            if (componente instanceof JPanel) {

                JPanel panel = (JPanel) componente;

                JTextField txtSemestre = (JTextField) panel.getComponent(0);
                JCheckBox chkPago1 = (JCheckBox) panel.getComponent(1);
                JTextField txtHorasServicio = (JTextField) panel.getComponent(2);
                JComboBox<String> cmbTipoServicioSocial = (JComboBox<String>) panel.getComponent(3);
                JComboBox<String> cmbLugarServicioSocial = (JComboBox<String>) panel.getComponent(4);
                JCheckBox chkPlatica1 = (JCheckBox) panel.getComponent(5);
                JCheckBox chkPlatica2 = (JCheckBox) panel.getComponent(6);
                JCheckBox chkPago2 = (JCheckBox) panel.getComponent(7);
                JCheckBox chkPagoExtra = (JCheckBox) panel.getComponent(8);
                JTextField txtPromedio = (JTextField) panel.getComponent(9);
                JTextField txtDescuento = (JTextField) panel.getComponent(10);

                llenaComboCategorias(cmbTipoServicioSocial, catTipoServicioSocial);
                llenaComboCategorias(cmbLugarServicioSocial, catLugarServicioSocial);

                Calendar fecha = lstFechaSemestre.get(i);
                if (i < lstKardex.size()) {
                    Kardex kardex = lstKardex.get(i);

                    System.out.println("Fecha controlador: " + fecha.getTime());

                    chkPago1.setSelected(kardex.isPlatica1());
                    txtHorasServicio.setText(kardex.getHorasServicio() + "");
                    chkPlatica1.setSelected(kardex.isPlatica1());
                    chkPlatica2.setSelected(kardex.isPlatica2());
                    chkPago1.setSelected(kardex.isPago_inicio_semestre());
                    chkPago2.setSelected(kardex.isPago_fin_semestre());
                    chkPagoExtra.setSelected(kardex.isPago_extra());
                    txtPromedio.setText(kardex.getPromedio() + "");
                    txtDescuento.setText(kardex.getDescuento() + "%");

                    cmbTipoServicioSocial.setSelectedItem(getItemComboBox(kardex.getIdServicioComunitario(), catTipoServicioSocial));
                    cmbLugarServicioSocial.setSelectedItem(getItemComboBox(kardex.getLugarServicioComunitario(), catLugarServicioSocial));
                }
                txtSemestre.setText(fecha.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + "/" + fecha.get(Calendar.YEAR));

                if (i == lstFechaSemestre.size() - 1) {
                    break;
                }
                i++;
            }

        }
    }

    /**
     * Llena los paneles de las boletas y carga semestral con los datos del
     * becario
     *
     * @param lstKardex
     * @param lstFechaSemestre Indica las fechas iniciales de cada semestre
     * @param codigo 1.- Llena con la informacion de la pestaña de las boletas
     * 2.- Llena con la informacion de la pestaña de las cargas semestrales
     * 3.- LLena con la informacion a los primeros 10 transferencias de la pestaña adjuntar transferencias
     * 4.- LLena con la informacion a las restantes 10 transferencias de la pestaña adjuntar transferencias 
     */
    private void llenaPnlBoletaOCargaSemestral(List<Kardex> lstKardex, List<Calendar> lstFechaSemestre, int codigo) {
        JPanel pnlSemestres = null;
        JPanel pnlAcciones = null;
        int tamanio = lstFechaSemestre.size();
        Component[] componentes = null;
        int i = 0;
        int g = 0;
        switch (codigo) {
            case 1:
                pnlSemestres = vistaKardex.jpnlListaDocumentosBoleta;
                pnlAcciones = vistaKardex.jpnlAccionesDocumentosBoleta;

                if(lstKardex.isEmpty())
                    break;
                componentes = pnlAcciones.getComponents();
                i = 0;
                for (Component componente : componentes) {
                    if (componente instanceof JLabel) {
                        JLabel etiqueta = (JLabel) componente;
                        Kardex kardex = lstKardex.get(i);
                        etiqueta.setText(kardex.getBoleta());
                        i++;
                    }

                    if (i == tamanio - 1) {
                        break;
                    }
                }

                break;

            case 2:
                pnlSemestres = vistaKardex.jpnlListaDocumentosServicioComunitario;
                pnlAcciones = vistaKardex.jpnlAccionesDocumentosServicioComunitario;
                
                if(lstKardex.isEmpty())
                    break;

                componentes = pnlAcciones.getComponents();
                i = 0;
                for (Component componente : componentes) {
                    if (componente instanceof JLabel) {
                        JLabel etiqueta = (JLabel) componente;
                        Kardex kardex = lstKardex.get(i);
                        etiqueta.setText(kardex.getCarta_servicio_comunitario());
                        i++;
                    }
                    if (i == tamanio - 1) {
                        break;
                    }
                }
                break;
                
            case 3:
                pnlSemestres = vistaKardex.jpnlListaDocumentos4;
                pnlAcciones = vistaKardex.jpnlAccionesDocumentos2;
                if(lstKardex.isEmpty())
                    break;

                componentes = pnlAcciones.getComponents();
                i = 0;
                g = 0;
                for (Component componente : componentes) {
                    if (componente instanceof JLabel) {
                        
                        JLabel txtSemestre = (JLabel) componente;
                        Kardex kardex = lstKardex.get(g);
                        if(i % 2 == 0)
                            txtSemestre.setText(kardex.getTransferencia1());
                        else{
                            txtSemestre.setText(kardex.getTransferencia2());
                            g++;
                        }
                            
                        i++;
                    }
                    if (i == (tamanio * 2) - 1) {
                        break;
                    }
                }
                break;
                
            case 4:
                pnlSemestres = vistaKardex.jpnlListaDocumentos5;
                pnlAcciones = vistaKardex.jpnlAccionesDocumentos3;
                if(lstKardex.isEmpty())
                    break;

                componentes = pnlAcciones.getComponents();
                i = 0;
                g = 5;
                for (Component componente : componentes) {
                    if (componente instanceof JLabel) {
                        
                        JLabel txtSemestre = (JLabel) componente;
                        Kardex kardex = lstKardex.get(g);
                        if(i % 2 == 0)
                            txtSemestre.setText(kardex.getTransferencia1());
                        else{
                            txtSemestre.setText(kardex.getTransferencia2());
                            g++;
                        }
                        
                        i++; 
                        
                    }
                    if (i == (tamanio * 2)- 1) {
                        break;
                    }
                }
                break;

        }
        //Se agregan los semestres de las boletas y cartas de servicio comunitario
        if(codigo == 1 || codigo == 2){
            //Se procede a llenar los semestres
            componentes = pnlSemestres.getComponents();
            i = 0;
            for (Component componente : componentes) {
                JTextField txtSemestre = (JTextField) componente;
                Calendar calendario = lstFechaSemestre.get(i);

                txtSemestre.setText(calendario.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + "/" + calendario.get(Calendar.YEAR));

                if (i == tamanio - 1) {
                    break;
                }
                i++;
            }
        }
        //Se llenan los primeros 5 semestres de las transferencias bancarias
        else if(codigo == 3){
            //Se procede a llenar los semestres
            componentes = pnlSemestres.getComponents();
            i = 0;
            boolean bandera = false;
            for (Component componente : componentes) {
                int semestre = i/2;
                JTextField txtSemestre = (JTextField) componente;
                Calendar calendario = lstFechaSemestre.get(semestre);
                if(bandera == false){
                    txtSemestre.setText("Transf 1 " + calendario.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + "/" + calendario.get(Calendar.YEAR));
                    bandera =true;
                }
                else{
                    txtSemestre.setText("Transf 2 " + calendario.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + "/" + calendario.get(Calendar.YEAR));
                    bandera = false;
                }
                if (i == (tamanio * 2) - 1) {
                    break;
                }
                i++;
            }
        }
        else if(codigo == 4){
            //Se procede a llenar los semestres
            componentes = pnlSemestres.getComponents();
            i = 10;
            boolean bandera = false;
            for (Component componente : componentes) {
                int semestre = (i/2) - 1;
                JTextField txtSemestre = (JTextField) componente;
                Calendar calendario = lstFechaSemestre.get(semestre + 1);
                if(bandera == false){
                    txtSemestre.setText("Transf 1 " + calendario.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + "/" + calendario.get(Calendar.YEAR));
                    bandera =true;
                }
                else{
                    txtSemestre.setText("Transf 2 " + calendario.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + "/" + calendario.get(Calendar.YEAR));
                    bandera = false;
                }
                if (i == (tamanio * 2 ) - 1) {
                    break;
                }
                i++;
            }
        }
    }

    /**
     * Deshabilita los componentes de los jpanel de la vistaKardex
     *
     * @param pnlPanel
     * @param semestresHabilitados
     * @param contador
     * @param codigo 1.- Deshabilita los componentes del pnlKardex 
     * 2.- Deshabilita los componentes de la pestaña de boletas y carga semestral en
     * el apartado de semestres 
     * 3.- Deshabilita los componentes de la pestaña de
     * boletas y carga semestral en el apartado de acciones y estatus.
     * 4.- Deshabilita los componentes de la pestaña de transferencias en el apartado
     * Carga semestral
     */
    private void deshabilitaSemestresKardex(JPanel pnlPanel, int semestresHabilitados,
            int contador, int codigo) {
        Component[] componentes = pnlPanel.getComponents();

        switch (codigo) {
            //Desabilita los componentes del pnlKardex
            case 1:
                for (Component componente : componentes) {

                    if (componente instanceof JPanel && contador > semestresHabilitados) {
                        contador++;
                        deshabilitaSemestresKardex((JPanel) componente, semestresHabilitados, contador, 1);
                    } else if (componente instanceof JPanel && contador <= semestresHabilitados) {
                        contador++;
                        //deshabilitaSemestresKardex((JPanel) componente, semestresHabilitados, contador);
                    }

                    if (contador > semestresHabilitados) {
//                        Color color = new Color(255, 0,0);
//                        componente.setBackground(color);
                        componente.setVisible(false);
                    }

                }
                break;

            case 2:
                for (Component componente : componentes) {

                    if (componente instanceof JTextField && contador <= semestresHabilitados) {
                        contador++;
                    }

                    if (contador > semestresHabilitados) {
//                        Color color = new Color(255, 0,0);
//                        componente.setBackground(color);
                        if (componente instanceof JTextField) {
                            componente.setVisible(false);
                        }
                    }

                }
                break;
            case 3:
                for (Component componente : componentes) {

                    if ((componente instanceof JButton || componente instanceof JLabel) && contador <= semestresHabilitados) {
                        contador++;
                    }

                    if (contador > semestresHabilitados) {
//                        Color color = new Color(255, 0,0);
//                        componente.setBackground(color);
                        if (componente instanceof JButton || componente instanceof JLabel) {
                            componente.setVisible(false);
                        }
                    }

                }
                break;
                
            case 4:
                int i = 0;
                for (Component componente : componentes) {
                    i = contador / 2;
                    if ((componente instanceof JButton || componente instanceof JLabel) && i <= semestresHabilitados) {
                        contador++;
                    }

                    if (i > semestresHabilitados) {
//                        Color color = new Color(255, 0,0);
//                        componente.setBackground(color);
                        if (componente instanceof JButton || componente instanceof JLabel) {
                            componente.setVisible(false);
                        }
                    }

                }
                break;
        }

    }

    /**
     * Valida que los campos de datos generales, Direccion, Padres, Información
     * escolar, Manejo de beca no estén vacios
     *
     * @return True si hay campos vacios, False si no
     */
    private boolean validaCamposVacios() {
        boolean response = false;

        //Si se encuentran campos vacios
        if (recorreJPanel(vistaRegistro.pnlDatosGenerales, 1)
                || recorreJPanel(vistaRegistro.pnlParentesco, 1)
                || recorreJPanel(vistaRegistro.pnlInformacionEscolar, 1)
                || recorreJPanel(vistaRegistro.pnlManejoBeca, 1)
                || recorreJPanel(vistaRegistro.pnlDirecciones, 1)
                || recorreJPanel(vistaRegistro.pnlCorreos, 1)) {

            response = true;
        }

        return response;
    }

    private void limpiaPantallaRegistro() {

        //Si se encuentran campos vacios
        recorreJPanel(vistaRegistro.pnlDatosGenerales, 2);
        recorreJPanel(vistaRegistro.pnlParentesco, 2);
        recorreJPanel(vistaRegistro.pnlInformacionEscolar, 2);
        recorreJPanel(vistaRegistro.pnlManejoBeca, 2);
        recorreJPanel(vistaRegistro.pnlDirecciones, 2);
        recorreJPanel(vistaRegistro.pnlCorreos, 2);
    }

    private void vaciaLstVistas() {
        lstVistaHijos.removeAll(lstVistaHijos);
        lstVistaHermanos.removeAll(lstVistaHermanos);
        lstVistaParentesco.removeAll(lstVistaParentesco);
        lstVistaDireccion.removeAll(lstVistaDireccion);
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
        vistaRegistro.txtOcupacionConyuge.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, vistaRegistro.txtOcupacionConyuge));

        //Datos Escolares 
        vistaRegistro.txtNombreCarrera.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, vistaRegistro.txtNombreCarrera));
        vistaRegistro.txtEscuelaProcedencia.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, vistaRegistro.txtEscuelaProcedencia));
        vistaRegistro.txtCostoCarrera.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.DINERO, vistaRegistro.txtCostoCarrera));
        vistaRegistro.txtBecaAutorizada.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.DINERO, vistaRegistro.txtBecaAutorizada));

        //Datos que calculan la beca total semestral
        vistaRegistro.txtBecaAutorizada.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.DINERO, vistaRegistro.txtBecaAutorizada));
        vistaRegistro.txtCostoCarrera.addKeyListener(new EscuchadorValidaEntrada(vistaRegistro, EscuchadorValidaEntrada.DINERO, vistaRegistro.txtCostoCarrera));

        //Datos que calculan la beca total semestral
        vistaRegistro.txtBecaAutorizada.addKeyListener(new EscuchadorCalculaBecaXSemestre(
                vistaRegistro.txtBecaAutorizada, vistaRegistro.cmboxSemestreInicioBeca,
                vistaRegistro.cmboxSemestresTotalesCarrera, vistaRegistro.cmboxAnioInicioBeca,
                vistaRegistro.txtBecaPorSemestre, vistaRegistro.txtCostoCarrera));

        vistaRegistro.cmboxSemestreInicioBeca.addItemListener(new EscuchadorCmbBoxCambiado(
                vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca,
                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion,
                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera,
                vistaRegistro.txtBecaAutorizada, vistaRegistro.txtBecaPorSemestre, vistaRegistro.txtCostoCarrera,
                vistaRegistro, EscuchadorCmbBoxCambiado.BECA_SEMESTRAL));

//        vistaRegistro.cmboxSemestresTotalesCarrera.addItemListener(new EscuchadorCmbBoxCambiado(
//                    vistaRegistro.cmboxSemestresTotalesCarrera, vistaRegistro.cmboxMesInicioBeca,
//                    vistaRegistro.cmboxAnioInicioBeca, vistaRegistro.txtBecaAutorizada,
//                    vistaRegistro.txtBecaPorSemestre, EscuchadorCmbBoxCambiado.BECA_SEMESTRAL));
        vistaRegistro.cmboxSemestresTotalesCarrera.addItemListener(new EscuchadorCmbBoxCambiado(
                vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca,
                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion,
                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera,
                vistaRegistro.txtBecaAutorizada, vistaRegistro.txtBecaPorSemestre, vistaRegistro.txtCostoCarrera,
                vistaRegistro, EscuchadorCmbBoxCambiado.BECA_SEMESTRAL));

        //Datos hijos
        for (PnlHijos lstVistaHijo : lstVistaHijos) {
            lstVistaHijo.txtApPaternoHijo.addKeyListener(new EscuchadorValidaEntrada(lstVistaHijo, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaHijo.txtApPaternoHijo));
            lstVistaHijo.txtApMaternoHijo.addKeyListener(new EscuchadorValidaEntrada(lstVistaHijo, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaHijo.txtApMaternoHijo));
            lstVistaHijo.txtNombreHIjo.addKeyListener(new EscuchadorValidaEntrada(lstVistaHijo, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstVistaHijo.txtNombreHIjo));
        }

        //Datos direccion
        for (PnlDireccion lstVistaDireccion : lstVistaDireccion) {
            lstVistaDireccion.txtCPBecado.addKeyListener(new EscuchadorValidaEntrada(lstVistaDireccion, EscuchadorValidaEntrada.CODIGO_POSTAL, lstVistaDireccion.txtCPBecado));
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
            lstParentesco.txtOcupacion.addKeyListener(new EscuchadorValidaEntrada(lstParentesco, EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO, lstParentesco.txtOcupacion));
            lstParentesco.TxtTelPariente.addKeyListener(new EscuchadorValidaEntrada(lstParentesco, EscuchadorValidaEntrada.TELEFONO, lstParentesco.TxtTelPariente));
        }

        //Datos de fechas de inicio de carrera y graduacion
        vistaRegistro.cmboxSemestresTotalesCarrera.addItemListener(new EscuchadorCmbBoxCambiado(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca,
                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion,
                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera,
                vistaRegistro.txtBecaAutorizada, vistaRegistro.txtBecaPorSemestre,
                vistaRegistro.txtCostoCarrera, vistaRegistro, EscuchadorCmbBoxCambiado.FECHA_GRADUACION));

        vistaRegistro.cmboxMesInicioBeca.addItemListener(new EscuchadorCmbBoxCambiado(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca,
                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion,
                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera,
                vistaRegistro.txtBecaAutorizada, vistaRegistro.txtBecaPorSemestre,
                vistaRegistro.txtCostoCarrera, vistaRegistro, EscuchadorCmbBoxCambiado.FECHA_GRADUACION));

        vistaRegistro.cmboxAnioInicioBeca.addItemListener(new EscuchadorCmbBoxCambiado(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca,
                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion,
                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera,
                vistaRegistro.txtBecaAutorizada, vistaRegistro.txtBecaPorSemestre,
                vistaRegistro.txtCostoCarrera, vistaRegistro, EscuchadorCmbBoxCambiado.FECHA_GRADUACION));

//        vistaRegistro.cmboxSemestreInicioBeca.addItemListener(new 
//        EscuchadorCmbBoxCambiado(vistaRegistro.cmboxMesInicioBeca, vistaRegistro.cmboxAnioInicioBeca, 
//                vistaRegistro.cmboxMesGraduacion, vistaRegistro.cmboxAnioGraduacion,
//                vistaRegistro.cmboxSemestreInicioBeca, vistaRegistro.cmboxSemestresTotalesCarrera,
//                vistaRegistro.txtBecaAutorizada, vistaRegistro.txtBecaPorSemestre,
//                vistaRegistro.txtCostoCarrera, vistaRegistro, EscuchadorCmbBoxCambiado.FECHA_GRADUACION));
    }

    /**
     * Comienza con la busqueda de becarios por folio y crea la pantalla
     * VistaRegistro con la informacion recabada
     *
     * @param folio
     */
    protected void getInfoBecarioPorFolio(String folio) {
        
        helper.cursorEspera(vista);
        Conexion conn = new Conexion();
        Connection conexion = null;
        conexion = conn.estableceConexion();
        

        if (conexion == null) {
            helper.cursorNormal(vista);
            JOptionPane.showMessageDialog(vista, "No se pudo conectar a la base de datos. \n Intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Becario becario = modelo.getBecarioPorFolio(conexion, folio);
        if (becario == null) {
            helper.cursorNormal(vista);
            JOptionPane.showMessageDialog(vista, "No se encontraron Becarios", "No hay registros", JOptionPane.INFORMATION_MESSAGE);
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
            return;
        }
        
        if(becario.getActivo() == 0){
            JOptionPane.showMessageDialog(vista, "El becario que desea cargar está deshabilitado.\n Activelo para obtener su información", "", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        List<Direccion> lstDireccionesBecario = modelo.getDireccionesBecario(conexion, becario.getId());

        List<Telefono> lstTelefonosBecario = modelo.getTelefonosBecario(conexion, becario.getId());

        List<Padres> lstPadresBecario = modelo.getPadresBecario(conexion, becario.getId());

        List<Hermanos> lstHermanos = modelo.getHermanosBecario(conexion, becario.getId());

        List<Hijos> lstHijos = modelo.getHijosBecario(conexion, becario.getId());

        DatosEscolares lstDatosEscolares = modelo.getDatosEscolaresBecario(conexion, becario.getId());

        Aval lstAval = modelo.getAvalBecario(conexion, becario.getId());

        creaVistaRegistroConDatosBecario(becario, lstDireccionesBecario, lstTelefonosBecario, lstPadresBecario, lstHermanos,
                lstHijos, lstDatosEscolares, lstAval);

        try {
            conexion.close();
        } catch (SQLException ex) {
            log.muestraErrores(ex);
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        helper.cursorNormal(vista);

    }

    /**
     * Comienza la busqueda de becarios por programa y estatus
     *
     * @param programa
     * @param estatus
     */
    protected void getInfoBecarioPorProgramaEstatus(String programa, String estatus) {
        
        helper.cursorEspera(vista);
        Conexion conn = new Conexion();
        Connection conexion = null;
        conexion = conn.estableceConexion();
        List<Becario> lstBecario = new ArrayList<>();

        if (conexion == null) {
            helper.cursorNormal(vista);
            JOptionPane.showMessageDialog(vista, "No se pudo conectar a la base de datos. \n Intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idPrograma = getIdCmbBox(programa, catPrograma);
        int totalProgramas = modelo.getTotalProgramas(conexion);
        int idEstatus = getIdCmbBox(estatus, catEstatus);
        
        //Si se selecciono "TODOS"
        if(idPrograma == 0){
            lstBecario = modelo.getBecarioPorProgramaEstatus(conexion, 10000, idEstatus);
        }
        //Si no se busca por el id del programa
        else
            lstBecario = modelo.getBecarioPorProgramaEstatus(conexion, idPrograma, idEstatus);
        if (lstBecario.isEmpty()) {
            helper.cursorNormal(vista);
            JOptionPane.showMessageDialog(vista, "No se encontraron Becarios", "No hay registros", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        llenaTablaBusqueda(lstBecario, conexion);
        helper.cursorNormal(vista);
    }

    /**
     * Busca a los becarios por sus nombres y apellidos
     *
     * @param nombre
     * @param aPaterno
     * @param aMaterno
     */
    protected void getInfoBecarioPorNombre(String nombre, String aPaterno, String aMaterno) {
        helper.cursorEspera(vista);
        Conexion conn = new Conexion();
        Connection conexion = conn.estableceConexion();
        List<Becario> lstBecario = new ArrayList<>();
        if (conexion == null) {
            helper.cursorNormal(vista);
            JOptionPane.showMessageDialog(vistaBusqueda, "No se pudo conectar a la base de datos, intentalo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            log.muestraErrores(new SQLException("No se pudo conectar a la base de datos"));
            return;
        }

        lstBecario = modelo.getBecarioPorNombres(conexion, nombre, aPaterno, aMaterno);

        if (lstBecario.isEmpty()) {
            helper.cursorNormal(vista);
            JOptionPane.showMessageDialog(vista, "No se encontraron Becarios", "No hay registros", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        llenaTablaBusqueda(lstBecario, conexion);
        helper.cursorNormal(vista);
    }

    /**
     * Obtiene los datos del becario seleccionado en la tabla de la
     * vistaBusqueda
     */
    protected void getInfoBecarioPorTablaBusqueda() {
        DefaultTableModel modelo = (DefaultTableModel) vistaBusqueda.tblResultadoBusqueda.getModel();
        int row = vistaBusqueda.tblResultadoBusqueda.getSelectedRow();
        //Se obtiene el folio del becario seleccionado
        String folio = modelo.getValueAt(row, 3).toString();

        getInfoBecarioPorFolio(folio);
    }

    /**
     * Crea la pantalla VistaRegistro con la informacion de un becario
     * registrado
     *
     * @param becario
     * @param lstDireccionesBecario
     * @param lstTelefonosBecario
     * @param lstPadresBecario
     * @param lstHermanos
     * @param lstHijos
     * @param lstDatosEscolares
     * @param lstAval
     */
    private void creaVistaRegistroConDatosBecario(Becario becario, List<Direccion> lstDireccionesBecario,
            List<Telefono> lstTelefonosBecario, List<Padres> lstPadresBecario, List<Hermanos> lstHermanos,
            List<Hijos> lstHijos, DatosEscolares lstDatosEscolares, Aval lstAval) {

        if (vistaRegistro != null) {
            terminaVistaRegistro();
        }

        if (vistaRegistro == null) {
            vistaRegistro = new VistaRegistro(this);
        }

        vistaRegistro.pnlOpciones.removeAll();
        vistaOpcionActualizar = new VistaRegistroOpcionActualizar();
        vistaOpcionActualizar.setControlador(this);
        vistaOpcionActualizar.setVisible(true);
        vistaRegistro.pnlOpciones.add(vistaOpcionActualizar, BorderLayout.CENTER);

        vistaRegistro.updateUI();

        this.setVistaRegistro(vistaRegistro);
        List<LinkedHashMap<Integer, String>> lstCategorias = null;

        try {
            //Se muestran las pantallas dinamicas
            llenaPanelesVistaRegistro();
            //Se obtienen las categorias para llenar la pantalla
            lstCategorias = modelo.getCategoriasVistaRegistro();
            llenaCamposCategoriasVistaRegistro(lstCategorias, true);
            llenaCamposVistaRegistro(becario, lstDireccionesBecario, lstTelefonosBecario,
                    lstPadresBecario, lstHermanos, lstHijos, lstDatosEscolares, lstAval);
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

        vistaRegistro.comboBoxPrograma.setEnabled(false);
        vistaRegistro.cmbEstatus.setEnabled(false);
        creaPantalla(vistaRegistro);

        //
        if(becario.getFoto() != null){
            fileFoto = null;
            fileFoto = new File(Index.RUTA_FINAL + becario.getFoto());
            helper.cargaImagenExterna(vistaRegistro.lblFotografia, fileFoto.toPath());
        }
    }

    /**
     * Se encarga de poner la informacion del becario en todos los campos de la
     * pantalla VistaRegistro
     *
     * @param becario
     * @param lstDireccionesBecario
     * @param lstTelefonosBecario
     * @param lstPadresBecario
     * @param lstHermanos
     * @param lstHijos
     * @param lstDatosEscolares
     * @param lstAval
     */
    private void llenaCamposVistaRegistro(Becario becario, List<Direccion> lstDireccionesBecario,
            List<Telefono> lstTelefonosBecario, List<Padres> lstPadresBecario, List<Hermanos> lstHermanos,
            List<Hijos> lstHijos, DatosEscolares lstDatosEscolares, Aval lstAval) {

        //Llenado de datos generales
        String programa = getItemComboBox(becario.getIdPrograma(), catPrograma);
        vistaRegistro.comboBoxPrograma.setSelectedItem(programa);
        vistaRegistro.txtFolio.setText(becario.getFolio());
        vistaRegistro.cmbEstatus.setSelectedIndex(becario.getIdEstatus() - 1);
        vistaRegistro.txtNombreBecado.setText(becario.getNombre());
        vistaRegistro.txtApPaternoBecado.setText(becario.getApPaterno());
        vistaRegistro.txtApMaternoBecado.setText(becario.getApMaterno());
        if (becario.getFecha_nac() != null) {
            vistaRegistro.txtFechaNacimiento.setText(helper.formateaFechaBD(becario.getFecha_nac()));
        }
        
//        vistaRegistro.txtFechaNacimiento.setDate(becario.getFecha_nac());
        
        vistaRegistro.comboBxTrabajaBecado.setSelectedIndex(becario.getTrabaja());
        vistaRegistro.combobxSexoBecado.setSelectedIndex(becario.getIdSexo() - 1);
        vistaRegistro.combobxCivilBecado.setSelectedIndex(becario.getIdEstadoCivil() - 1);
        
        int contador = 0;
        for (Telefono telefono : lstTelefonosBecario) {
            switch (contador) {
                case 0:
                    vistaRegistro.txtTel1Becado.setText(telefono.getTelefono());
                    break;
                case 1:
                    vistaRegistro.txtTel2Becado.setText(telefono.getTelefono());
                    break;
                case 2:
                    vistaRegistro.txtTel3Becado.setText(telefono.getTelefono());
                    break;
            }
            contador++;
        }

        vistaRegistro.txtCorreoBecario.setText(becario.getEmail());
        vistaRegistro.txtCorreoBecario2.setText(becario.getEmail());

        //Llenado de direcciones
        //Se crean las vistas de direcciones necesarias para la insercion de los datos
        if (lstDireccionesBecario.size() > 1) {
            for (int i = 1; i <= lstDireccionesBecario.size() - 1; i++) {
                PnlDireccion pnlDireccion = new PnlDireccion();
                agregaJPanel(pnlDireccion);
            }
        }

        contador = 0;
        for (Direccion direccion : lstDireccionesBecario) {
            lstVistaDireccion.get(contador).txtCalleBecado.setText(direccion.getCalle());
            lstVistaDireccion.get(contador).txtNumBecado.setText(direccion.getNumExt());
            lstVistaDireccion.get(contador).txtNumIntBecado.setText(direccion.getNumInt());
            lstVistaDireccion.get(contador).txtCPBecado.setText(direccion.getCodigoPostal() + "");
            lstVistaDireccion.get(contador).txtColoniaBecado.setText(direccion.getColonia());
            lstVistaDireccion.get(contador).txtCiudadBecado.setText(direccion.getCiudad());
            contador++;
        }

        //Llenado de padres
        //Se crean las vistas de padres necesarias para la insercion de los datos
        if (lstPadresBecario.size() > 1) {
            for (int i = 1; i < lstPadresBecario.size() - 1; i++) {
                PnlParentesco pnlParentesco = new PnlParentesco();
                agregaJPanel(pnlParentesco);
            }
        }
        contador = 0;
        for (Padres padre : lstPadresBecario) {
            lstVistaParentesco.get(contador).txtApPaternoPariente.setText(padre.getaPaterno());
            lstVistaParentesco.get(contador).txtApMaternoPariente.setText(padre.getaMaterno());
            lstVistaParentesco.get(contador).txtNombresPariente.setText(padre.getNombre());
            lstVistaParentesco.get(contador).cmbNivelEstudiosPariente.setSelectedIndex(padre.getGradoEscolar() - 1);
            lstVistaParentesco.get(contador).cmbParentesco.setSelectedIndex(padre.getParenteco() - 1);
            lstVistaParentesco.get(contador).cmbTrabajoActivoPariente.setSelectedIndex(padre.getTrabaja());
            lstVistaParentesco.get(contador).txtOcupacion.setText(padre.getOcupacion());
            lstVistaParentesco.get(contador).TxtTelPariente.setText(padre.getTelefono());
            contador++;
        }

        //Llenado de hermanos
        //Se crean las vistas de hermanos necesarias para la insercion de los datos
        if (lstHermanos.size() > 1) {
            for (int i = 1; i <= lstHermanos.size() - 1; i++) {
                PnlHermanos pnlHermanos = new PnlHermanos();
                agregaJPanel(pnlHermanos);
            }
        }
        contador = 0;
        for (Hermanos hermano : lstHermanos) {
            lstVistaHermanos.get(contador).txtApPaternoPariente.setText(hermano.getAPaterno());
            lstVistaHermanos.get(contador).txtApMaternoPariente.setText(hermano.getAMaterno());
            lstVistaHermanos.get(contador).txtNombresPariente.setText(hermano.getNombre());
            lstVistaHermanos.get(contador).cmbNivelEstudiosHermano.setSelectedIndex(hermano.getGradoEscolar() - 1);
            lstVistaHermanos.get(contador).txtAreaComentario.setText(hermano.getComentario());
            contador++;
        }

        //Llenado del conyuge
        vistaRegistro.txtNombreConyuge.setText(becario.getNombreConyuge());
        vistaRegistro.txtApPaternoConyuge.setText(becario.getApPaternoConyuge());
        vistaRegistro.txtApMaternoConyuge.setText(becario.getApMaternoConyuge());
        vistaRegistro.txtTelefonoConyuge.setText(becario.getTelefonoConyuge());
        vistaRegistro.txtOcupacionConyuge.setText(becario.getOcupacionConyuge());

        //Llenado de hijos
        //Se crean las vistas de hermanos necesarias para la insercion de los datos
        if (lstHijos.size() > 1) {
            for (int i = 1; i <= lstHijos.size() - 1; i++) {
                PnlHijos pnlHijos = new PnlHijos();
                agregaJPanel(pnlHijos);
            }
        }
        contador = 0;
        for (Hijos hijo : lstHijos) {
            lstVistaHijos.get(contador).txtApPaternoHijo.setText(hijo.getAPaterno());
            lstVistaHijos.get(contador).txtApMaternoHijo.setText(hijo.getAMaterno());
            lstVistaHijos.get(contador).txtNombreHIjo.setText(hijo.getNombre());
            //lstVistaHijos.get(contador).cmbEdadHijo.setSelectedIndex(hijo.getFechaNac(). );
            contador++;
        }

        //Llenado de Datos escolares
        vistaRegistro.txtNombreCarrera.setText(lstDatosEscolares.getNombreCarrera());
        vistaRegistro.txtEscuelaProcedencia.setText(lstDatosEscolares.getEscuelaProcedencia());
        vistaRegistro.cmboxCarreraSiNo.setSelectedIndex(becario.getPrimeroConBeca());
        vistaRegistro.cmboxCampoEscuela.setSelectedItem(getItemComboBox(lstDatosEscolares.getIdCampoCarrera(), catCampoEstudio));
        vistaRegistro.cmboxMesInicioBeca.setSelectedIndex(lstDatosEscolares.getMesInicioBeca());
        vistaRegistro.cmboxAnioInicioBeca.setSelectedItem(lstDatosEscolares.getAnioInicioBeca() + "");
        vistaRegistro.cmboxMesGraduacion.setSelectedIndex(lstDatosEscolares.getMesGraduacion() - 1);
        vistaRegistro.cmboxAnioGraduacion.setSelectedItem(lstDatosEscolares.getAnioGraduacion() + "");
        String universidad = getItemComboBox(lstDatosEscolares.getIdUniversidad(), catUniversidad);
        vistaRegistro.cmboxEscuelaUniversitaria.setSelectedItem(universidad);
        vistaRegistro.cmboxSemestreInicioBeca.setSelectedIndex(lstDatosEscolares.getSemestreInicioBeca() - 1);
        vistaRegistro.cmboxSemestresTotalesCarrera.setSelectedIndex(lstDatosEscolares.getSemestresTotalesCarrera() - 1);
        vistaRegistro.txtCostoCarrera.setText(lstDatosEscolares.getCostoCarrera() + "");
        vistaRegistro.txtBecaAutorizada.setText(lstDatosEscolares.getBecaTotal() + "");
        vistaRegistro.txtBecaPorSemestre.setText(lstDatosEscolares.getBecaSemestral() + "");
        vistaRegistro.txtAreaObservaciones.setText(becario.getObservaciones());
        vistaRegistro.cmbTipoEscuela.setSelectedItem(getItemComboBox(lstDatosEscolares.getIdTipoEscuela(), catTipoEscuela));
        
        //Igualdad de archivos y Llenado de ArchivosAdjuntos        
        if (becario.getActaNacimiento() != null) {
            fileActaNacimiento = null;
            fileActaNacimiento = new File(Index.RUTA_FINAL + becario.getActaNacimiento());
            vistaRegistro.lblEstatusActa.setText(fileActaNacimiento.getName());
        }
        if (becario.getBoletaInicioBeca() != null) {
            fileBoleta_calificaciones_inicial = null;
            fileBoleta_calificaciones_inicial = new File(Index.RUTA_FINAL + becario.getBoletaInicioBeca());
            vistaRegistro.lblEstatusBoleta.setText(fileBoleta_calificaciones_inicial.getName());
        }
        if (becario.getSolicitudBeca() != null) {
            fileCarta_solicitud = null;
            fileCarta_solicitud = new File(Index.RUTA_FINAL + becario.getSolicitudBeca());
            vistaRegistro.lblEstatusCarta.setText(fileCarta_solicitud.getName());
        }
        if (becario.getContatoBeca() != null) {
            fileContrato = null;
            fileContrato = new File(Index.RUTA_FINAL + becario.getContatoBeca());
            vistaRegistro.lblEstatusContrato.setText(fileContrato.getName());
        }
        if (becario.getEnsayo() != null) {
            fileEnsayo = null;
            fileEnsayo = new File(Index.RUTA_FINAL + becario.getEnsayo());
            vistaRegistro.lblEstatusEnsayo.setText(fileEnsayo.getName());
        }
        if (lstAval.getIdentificacion() != null) {
            fileIneAval = null;
            fileIneAval = new File(Index.RUTA_FINAL + lstAval.getIdentificacion());
            vistaRegistro.lblEstatusINEAval.setText(fileIneAval.getName());
        }
        if (becario.getIdentificacion() != null) {
            fileIneBecario = null;
            fileIneBecario = new File(Index.RUTA_FINAL + becario.getIdentificacion());
            vistaRegistro.lblEstatusINEBecario.setText(fileIneBecario.getName());
        }
        if (becario.getPagare() != null) {
            filePagare = null;
            filePagare = new File(Index.RUTA_FINAL + becario.getPagare());
            vistaRegistro.lblEstatusPagare.setText(filePagare.getName());
        }

        if (becario.getEstudioSocioEconomico() != null) {
            fileEstudioSocioeconomico = null;
            fileEstudioSocioeconomico = new File(Index.RUTA_FINAL + becario.getEstudioSocioEconomico());
            vistaRegistro.lblEstatusEstudioSocioEconomico.setText(fileEstudioSocioeconomico.getName());
        }

        if (becario.getCartaAsignacionBeca() != null) {
            fileCartaAsignacionBeca = null;
            fileCartaAsignacionBeca = new File(Index.RUTA_FINAL + becario.getCartaAsignacionBeca());
            vistaRegistro.lblEstatusCartaAsignacionBeca.setText(fileCartaAsignacionBeca.getName());
        }
        
        //Se carga la carta de agradecimiento de beca del becario
        if (fileCartaAgradecimiento != null) {
            fileCartaAgradecimiento = null;
            fileCartaAgradecimiento = new File(Index.RUTA_FINAL + becario.getCartaAgradecimiento());
            //vistaRegistro.lblEstatusCartaAsignacionBeca.setText(fileCartaAgradecimiento.getName());
        }

    }

    /**
     * Llena la vista con la información del becario seleccionado
     *
     * @param folio
     */
    private void llenaCamposVistaKardex(String folio) {
        Conexion conn = new Conexion();
        Connection conexion = conn.estableceConexion();
        Becario becario = null;
        List<Kardex> lstKardex = null;
        DatosEscolares datosEscolares = null;

        if (conexion == null) {
            JOptionPane.showMessageDialog(vistaKardex, "No se pudo conectar a la base de datos");
            log.muestraErrores(new SQLException("No se pudo conectar a la base de datos"));
        }

        llenaComboCategorias(vistaKardex.cmbNombreBanco, catBancos);

        becario = modelo.getBecarioPorFolio(conexion, folio);
        lstKardex = modelo.getKardexPorIdBecario(conexion, becario.getId());
        
        addFilesKardex(lstKardex);
        datosEscolares = modelo.getDatosEscolaresBecario(conexion, becario.getId());

        //Se generan los semestres del becario a partir de su fecha de inicio de la beca
        List<Calendar> lstFechaSemestres = helper.getFechaSemestres(datosEscolares);

        //Se procede a llenar la informacion general del becario
        vistaKardex.txtNombreBecario.setText(becario.getApPaterno() + " " + becario.getApMaterno() + " " + becario.getNombre());
        vistaKardex.txtCondicion.setText(getItemComboBox(becario.getIdEstatus(), catEstatus));
        vistaKardex.txtFolio.setText(becario.getFolio());
        vistaKardex.txtPrograma.setText(getItemComboBox(becario.getIdPrograma(), catPrograma));
        vistaKardex.txtFechaGraduacion.setText(datosEscolares.getMesGraduacion() + "/" + datosEscolares.getAnioGraduacion());

        //Se procede a llenar la informacion bancaria del becario
        String banco = getItemComboBox(becario.getIdBanco(), catBancos);
        vistaKardex.cmbNombreBanco.setSelectedItem(banco);
        vistaKardex.TxtFldNoCuenta.setText(becario.getCuentaBancaria());
        vistaKardex.TxtFldClabeBanco.setText(becario.getClabeInterbancaria());
        
        int semestresHabilitados = 0;
        //Se toman los semestres activos del becario
        if(!getItemComboBox(becario.getIdPrograma(), catPrograma).contains("Empuje"))
            semestresHabilitados = helper.getTotalSemestresporHabilitarKardex(datosEscolares.getSemestreInicioBeca(),
                    datosEscolares.getSemestresTotalesCarrera());
        else
            semestresHabilitados = 3;
        //Se procede a deshabilitar los semestres que aun no tienen que llenarse
        deshabilitaSemestresKardex(vistaKardex.PnlKardex, semestresHabilitados, 0, 1);
        //Se llena el pnlKardex
        llenaPnlKardex(lstKardex, lstFechaSemestres);

        //Se procede a deshabilitar los semestres de la pestaña adjuntar boleta en el 
        //apartado de semestres y acciones
        deshabilitaSemestresKardex(vistaKardex.jpnlListaDocumentosBoleta, semestresHabilitados - 1, 0, 2);
        deshabilitaSemestresKardex(vistaKardex.jpnlAccionesDocumentosBoleta, (semestresHabilitados - 1) * 3, 0, 3);
        llenaPnlBoletaOCargaSemestral(lstKardex, lstFechaSemestres, 1);
        //Se procede a deshabilitar los semestres de la pastaña adjuntar carga semestral 
        //en el apartado de semestres y acciones
        deshabilitaSemestresKardex(vistaKardex.jpnlListaDocumentosServicioComunitario, semestresHabilitados - 1, 0, 2);
        deshabilitaSemestresKardex(vistaKardex.jpnlAccionesDocumentosServicioComunitario, (semestresHabilitados - 1) * 3, 0, 3);
        llenaPnlBoletaOCargaSemestral(lstKardex, lstFechaSemestres, 2);
        
        //Se procede a deshabilitar los semestres de la pestaña transferencias en el 
        //apartado carga semestral
        //Se deshabilitan los primeros 10 jtextField
        deshabilitaSemestresKardex(vistaKardex.jpnlListaDocumentos4, (semestresHabilitados - 1) * 2, 0, 2);
        //Se deshabilitan los primeros 30 botones y label
        deshabilitaSemestresKardex(vistaKardex.jpnlAccionesDocumentos2, (semestresHabilitados - 1) * 6, 0, 3);

        //Se deshabilitan los 10 jtextField restantes
        deshabilitaSemestresKardex(vistaKardex.jpnlListaDocumentos5, ((semestresHabilitados - 1) * 2) - 10, 0, 2);
        //Se deshabilitan los 30 botones y labels restantes
        deshabilitaSemestresKardex(vistaKardex.jpnlAccionesDocumentos3, ((semestresHabilitados - 1) * 6) - 30, 0, 3);
        
        //Se asignan las transacciones al arreglo lstFilesTransferencias
        addTransferenciasAArreglo(lstKardex);
        
        //Se llenan los primeros 10 jtextfield
        llenaPnlBoletaOCargaSemestral(lstKardex, lstFechaSemestres, 3);
        //Se llenan los jtextfield restantes
        if(semestresHabilitados - 1 > 4)
            llenaPnlBoletaOCargaSemestral(lstKardex, lstFechaSemestres, 4);
        
        //Se llenan las primeras 10 transferencias
        

        try {
            conexion.close();
        } catch (SQLException e) {
            log.muestraErrores(e);
        }
    }
    
    /**
     * Llena los combo box de la pantalla VistaCatalogos
     */
    protected void llenaCamposVistaCatalogos() {
                
        vistaCatalogos.TxtFldDescripcionCatalogo.setText("");
        //Si no se ha llenado la tabla
        helper.cursorEspera(vista);
        Conexion conn = new Conexion();
        Connection conexion = conn.estableceConexion();
        
        //Se borrar e inicializan todas las listas y catalogos
        if(catCatalogos == null){
            catCatalogos = modelo.getCatCategorias(conexion);
        }

        if(catTipoEscuela == null){
            catTipoEscuela = modelo.getCatTipoEscuela(conexion);
        }
        
        if(lstCatalogoCopia != null){
            lstCatalogoCopia.clear();
            lstCatalogoCopia = null;
        }
        
        if(lstCatalogoTipoUniversidad != null){
            lstCatalogoTipoUniversidad.clear();
            lstCatalogoTipoUniversidad = null;
        }
        
        if(lstCatalogoCopiaEnBusquedas != null){
            lstCatalogoCopiaEnBusquedas.clear();
            lstCatalogoCopiaEnBusquedas = null;
        }
        
        lstCatalogoCopia = new LinkedHashMap<>();
        lstCatalogoTipoUniversidad = new LinkedHashMap<>();
        lstCatalogoCopiaEnBusquedas = new LinkedHashMap<>();

        if(vistaCatalogos.cmbTipoCatalogo.getSelectedIndex() < 0)
            llenaComboCategorias(vistaCatalogos.cmbTipoCatalogo, catCatalogos);

        String seleccion = (String) vistaCatalogos.cmbTipoCatalogo.getSelectedItem();
        int idTabla = getIdCmbBox(seleccion, catCatalogos);
        String nombreTabla = modelo.getNombreTabla(conexion, idTabla);

        lstCatalogoOriginal = modelo.getDatosCatalogo(conexion, nombreTabla);
        //Se hace una copia del catalogo original
        for (Integer idCatalogo : lstCatalogoOriginal.keySet()) {
            lstCatalogoCopia.put(idCatalogo, lstCatalogoOriginal.get(idCatalogo));
        }
        
        if(!nombreTabla.contains("univer")){
            creaTablaCatalogos(true);
            llenaTablaCatalogos(lstCatalogoOriginal, vistaCatalogos.TblDescripcionCatalogo, true, conexion);
        }
        else{
            creaTablaCatalogos(false);
            llenaTablaCatalogos(lstCatalogoOriginal, vistaCatalogos.TblDescripcionCatalogo, false, conexion);
            //DefaultTableModel tblModel = (DefaultTableModel) vistaCatalogos.TblDescripcionCatalogo.getModel();
        }

        try{
            conexion.close();
        }
        catch(SQLException e){log.muestraErrores(e);}
            
        helper.cursorNormal(vista);
        
    }
    
    private void creaTablaCatalogos(boolean tblDefault){
        DefaultTableModel tblModelo;
        String[] columnas;
        
        vistaCatalogos.pnlTabla.removeAll();
        
        if(tblDefault){
            columnas = new String[]{"Nombre"};
            tblModelo = new ModelDefault(columnas, 0);
        }
        else{
            columnas = new String[]{"Nombre","Universidad Pública"};
            tblModelo = new ModelUniversidades(columnas, 0);
        }
        
        if(vistaCatalogos.TblDescripcionCatalogo != null){
            vistaCatalogos.TblDescripcionCatalogo.removeAll();
            vistaCatalogos.TblDescripcionCatalogo = null;
        }
            
        vistaCatalogos.TblDescripcionCatalogo = new JTable(tblModelo);
        
        JScrollPane scroll = new JScrollPane(vistaCatalogos.TblDescripcionCatalogo);
        vistaCatalogos.pnlTabla.add(scroll);
        vistaCatalogos.TblDescripcionCatalogo.setVisible(true);
        
        vistaCatalogos.pnlTabla.invalidate();
        vistaCatalogos.pnlTabla.validate();
        
    }
        
    /**
     * Se encarga de obtener la información necesaria de cada becario para
     * llenar la tabla de la vistaBusqueda.
     *
     * @param lstBecario lista de becarios encontrados
     */
    private void llenaTablaBusqueda(List<Becario> lstBecario, Connection conexion) {

        List<DatosEscolares> lstDatosEscolares = new ArrayList<>();
        List<CatUniversidad> lstCatUniversidad = new ArrayList<>();
        
        //Se obtiene el id del estatus cancelado
        int idCancelado = modelo.getEstatusCancelado(conexion);

        //Se obtiene la información restante para llenar la tabla de resultados
        for (Becario becario : lstBecario) {
            DatosEscolares datosEscolares = modelo.getDatosEscolaresBecario(conexion, becario.getId());
            lstDatosEscolares.add(datosEscolares);

            CatUniversidad universidadBecario = new CatUniversidad();
            universidadBecario.setId(datosEscolares.getIdUniversidad());
            universidadBecario.setNombre(getItemComboBox(universidadBecario.getId(), catUniversidad));
            lstCatUniversidad.add(universidadBecario);
        }

        DefaultTableModel modelo = (DefaultTableModel) vistaBusqueda.tblResultadoBusqueda.getModel();

        //Se borra la información de la tabla
        int rows = modelo.getRowCount();
        for (int i = 0; i < rows; i++) {
            modelo.removeRow(0);
        }
        //Se inserta la informacion en la tabla
        int i = 0;
        for (Becario becario : lstBecario) {
            modelo.addRow(new String[]{
                becario.getApPaterno(), becario.getApMaterno(), becario.getNombre(),
                becario.getFolio(), lstDatosEscolares.get(i).getNombreCarrera(),
                lstCatUniversidad.get(i).getNombre(), "$" + lstDatosEscolares.get(i).getBecaTotal(),
                "$" + lstDatosEscolares.get(i).getBecaSemestral(), "" + lstDatosEscolares.get(i).getMesInicioBeca()
                + "/" + lstDatosEscolares.get(i).getAnioInicioBeca(), lstDatosEscolares.get(i).getMesGraduacion()
                + "/" + lstDatosEscolares.get(i).getAnioGraduacion()
            });
//            if(becario.getIdEstatus() == idCancelado){
//                rows = tblModelo.getRowCount();
//                vistaBusqueda.tblResultadoBusqueda.getValueAt(rows, rows)
//            }

            i++;
        }

        vistaBusqueda.tblResultadoBusqueda.updateUI();

        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            log.muestraErrores(ex);
        }

    }
    
    /**
     * Agrega las filas correspondientes de una tabla a partir de un LinkedHashMap
     * @param nombreDatoCatalogos
     * @param tabla 
     * @param bandera TRUE.- Indica que se tiene  cargado el catalogo de las universidades
     * FALSE.- Indica que es cualquier otro catalogo
     * @param conexion
     */
    private void llenaTablaCatalogos(LinkedHashMap<Integer,String> nombreDatoCatalogos, 
                        JTable tabla, boolean bandera, Connection conexion){
        
        DefaultTableModel tblModelo = (DefaultTableModel) tabla.getModel();
        for (Integer key : nombreDatoCatalogos.keySet()) {
            tblModelo.addRow(new String[]{""});
        }
        int i = 0;
        //Se llenan los nombres de los catalogos
        if(bandera){
            for (Integer valor : nombreDatoCatalogos.keySet()){
                tblModelo.setValueAt(nombreDatoCatalogos.get(valor), i, 0);
                i++;
            }
        }
        else{ 
            i = 0;
            for (Integer idEscuela : nombreDatoCatalogos.keySet()){
                tblModelo.setValueAt(nombreDatoCatalogos.get(idEscuela), i, 0);
                String tipoEscuela = modelo.getIdTipoEscuela(conexion, idEscuela);
                Boolean publica = false;
                if(tipoEscuela.contains("blica"))
                    publica = true;
                
                lstCatalogoTipoUniversidad.put(idEscuela, publica);
                tblModelo.setValueAt(publica, i, 1);
                i++;
            }
        }
        tblModelo.addRow(new String[]{});
    }

    /**
     * Abre el archivo seleccionado
     *
     * @param clave del tipo de archivo a abrir
     */
    protected void abreArchivoAdjunto(int clave) {

        switch (clave) {
            case Helper.FILE_ACTA_NACIMIENTO:
                helper.abreArchivoAdjunto(fileActaNacimiento);
                break;
            case Helper.FILE_BOLETA_CALIFICACIONES_INICIAL:
                helper.abreArchivoAdjunto(fileBoleta_calificaciones_inicial);
                break;
            case Helper.FILE_CARTA_ASIGNACION_BECA:
                helper.abreArchivoAdjunto(fileCartaAsignacionBeca);
                break;
            case Helper.FILE_CARTA_SOLICITUD:
                helper.abreArchivoAdjunto(fileCarta_solicitud);
                break;
            case Helper.FILE_CONTRATO:
                helper.abreArchivoAdjunto(fileContrato);
                break;
            case Helper.FILE_ENSAYO:
                helper.abreArchivoAdjunto(fileEnsayo);
                break;
            case Helper.FILE_ESTUDIO_SOCIECONOMICO:
                helper.abreArchivoAdjunto(fileEstudioSocioeconomico);
                break;
            case Helper.FILE_INE_AVAL:
                helper.abreArchivoAdjunto(fileIneAval);
                break;
            case Helper.FILE_INE_BECARIO:
                helper.abreArchivoAdjunto(fileIneBecario);
                break;
            case Helper.FILE_PAGARE:
                helper.abreArchivoAdjunto(filePagare);
                break;
                
            case Helper.FILE_CARTA_AGRADECIMIENTO:
                helper.abreArchivoAdjunto(fileCartaAgradecimiento);
        }
    }
    
    /**
     * Abre los archivos boleta, carta de servicio comunitario o Transferencia bancaria
     * según sea el caso
     * @param tipoArchivo 1.- Boleta, 
     * 2.- Carta servicio comunitario.
     * 3.- Transferencia Bancaria
     * @param posicion Indica la posicion del arreglo de archivos
     */
    protected void abreBoletaCartaServComTransferencia(int tipoArchivo, int posicion){
        switch(tipoArchivo){
            case 1:
                if(lstFilesBoletas[posicion] == null)
                    JOptionPane.showMessageDialog(vistaKardex, "Debe de cargar Boleta", "Error", JOptionPane.ERROR_MESSAGE);
                else
                    helper.abreArchivoAdjunto(lstFilesBoletas[posicion]);
                break;
                
            case 2:
                if(lstFilesCartaServCom[posicion] == null)
                    JOptionPane.showMessageDialog(vistaKardex, "Debe de cargar Carta", "Error", JOptionPane.ERROR_MESSAGE);
                else
                    helper.abreArchivoAdjunto(lstFilesCartaServCom[posicion]);
                break;
                
            case 3:
                if(lstFilesTransferencias[posicion] == null)
                    JOptionPane.showMessageDialog(vistaKardex, "Debe de cargar la Transferencia", "Error", JOptionPane.ERROR_MESSAGE);
                else
                helper.abreArchivoAdjunto(lstFilesTransferencias[posicion]);
                break;
        }
    }

    /**
     * Toma la seleccion de la pestaña registro semestral de la pantalla
     * vistaKardex y lo guarda en la base de datos
     */
    protected void updateKardexBecario() {
        /*int seleccion = Integer.parseInt(vistaKardex.rbtnGroupKardex.getSelection().getActionCommand());
        JPanel panel = (JPanel) vistaKardex.PnlKardex.getComponent(seleccion);
        JTextField txtCampo = (JTextField) panel.getComponent(3);
        txtCampo.setText("Esto es una prueba");*/

        helper.cursorEspera(vista);
        Conexion conn = new Conexion();
        Connection conexion = conn.estableceConexion();
        boolean response = false;
        int semestres = 0;
        if (conexion == null) {
            helper.cursorNormal(vista);
            JOptionPane.showMessageDialog(vistaKardex, "No se pudo conectar a la base de datos, intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            log.muestraErrores(new SQLException("No se pudo conectar a la base de datos, intentelo de nuevo"));
            return;
        }
        try {
            conexion.setAutoCommit(false);
            //Se obtienen los datos del becario
            Becario becario = modelo.getBecarioPorFolio(conexion, vistaKardex.txtFolio.getText());
            //Se obienen los datos escolares del becario
            DatosEscolares datosEscolares = modelo.getDatosEscolaresBecario(conexion, becario.getId());
            //Se obtiene el id del banco al que se le pagará al becario
            int idBanco = getIdCmbBox((String) vistaKardex.cmbNombreBanco.getSelectedItem(), catBancos);

            //Se actualiza el becario con la informacion bancaria
            response = modelo.updateInfoBanco(conexion, becario.getId(), idBanco, vistaKardex.TxtFldNoCuenta.getText(),
                    vistaKardex.TxtFldClabeBanco.getText());

            //Se verifica que se actualizaron los datos bancarios
            if (response == false) {
                helper.cursorNormal(vista);
                JOptionPane.showMessageDialog(vistaKardex, "No se pudo actualizar el kardex del becario, intentelo más tarde", "Error", JOptionPane.ERROR_MESSAGE);
                conexion.rollback();
                return;
            }

            //se obtienen los datos de los semestres habilitados
            semestres = helper.getTotalSemestresporHabilitarKardex(datosEscolares.getSemestreInicioBeca(),
                    datosEscolares.getSemestresTotalesCarrera()) - 1;

            //Se obtiene la información del kardex del becario
            List<Kardex> lstKardex = getInfoKardex(semestres);
            //System.out.println("Tamanio: " + lstKardex.size());

            lstKardex = getDatosKardexBecario(lstKardex, semestres);
            
            //Se agregan los archivos a los kardex correspondientes
            lstKardex = helper.putArchivosKardexBecario(lstKardex, lstFilesBoletas, lstFilesCartaServCom, lstFilesTransferencias, becario);

            //Se procede a insertar o actualizar el kardex del becario
            response = modelo.insertOrUpdateKardexBecario(conexion, lstKardex, lstFilesBoletas, lstFilesCartaServCom, becario);
            //Se verifica que se actualizaron los datos bancarios
            if (response == false) {
                helper.cursorNormal(vista);
                JOptionPane.showMessageDialog(vistaKardex, "No se pudo actualizar el kardex del becario, intentelo más tarde", "Error", JOptionPane.ERROR_MESSAGE);
                conexion.rollback();
                return;
            }
            conexion.commit();
            helper.cursorNormal(vista);
            JOptionPane.showMessageDialog(vistaKardex, "¡Kardex actualizado!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            log.muestraErrores(e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                log.muestraErrores(e);
            }
        }

    }

    /**
     * Recorre todos los datos que estan en el kardex para luego insertarlos en
     * la base de datos
     *
     * @param semestresTotales Total de semestres de estudio del becario
     * @return Lista de kardex, cada elemento es un semestre
     */
    private List<Kardex> getInfoKardex(int semestresTotales) {
        List<Kardex> lstKardex = new ArrayList<>();
        Component[] componentes = vistaKardex.PnlKardex.getComponents();
        int i = -1;
        for (Component componente : componentes) {
            if (i == -1) {
                i++;
                continue;
            }
            if (componente instanceof JPanel) {
                JPanel panel = (JPanel) componente;

                JTextField txtSemestre = (JTextField) panel.getComponent(0);
                JCheckBox chkPago1 = (JCheckBox) panel.getComponent(1);
                JTextField txtHorasServicio = (JTextField) panel.getComponent(2);
                JComboBox cmbTipoServicioComunitario = (JComboBox) panel.getComponent(3);
                JComboBox cmbLugarServicioComunitario = (JComboBox) panel.getComponent(4);
                JCheckBox chkPlatica1 = (JCheckBox) panel.getComponent(5);
                JCheckBox chkPlatica2 = (JCheckBox) panel.getComponent(6);
                JCheckBox chkPago2 = (JCheckBox) panel.getComponent(7);
                JCheckBox chkPagoExtra = (JCheckBox) panel.getComponent(8);
                JTextField txtPromedio = (JTextField) panel.getComponent(9);
                JTextField txtDescuento = (JTextField) panel.getComponent(10);

                Kardex kardex = new Kardex();
                kardex.setPago_inicio_semestre(chkPago1.isSelected());
                if (!txtHorasServicio.getText().equals("")) {
                    kardex.setHorasServicio(Integer.parseInt(txtHorasServicio.getText()));
                }
                kardex.setPlatica1(chkPlatica1.isSelected());
                kardex.setPlatica2(chkPlatica2.isSelected());
                int idServicioComunitario = getIdCmbBox((String) cmbTipoServicioComunitario.getSelectedItem(), catTipoServicioSocial);
                kardex.setIdServicioComunitario(idServicioComunitario);
                int idLugarServicioComunitario = getIdCmbBox((String) cmbLugarServicioComunitario.getSelectedItem(), catLugarServicioSocial);
                kardex.setLugarServicioComunitario(idLugarServicioComunitario);
                kardex.setPago_fin_semestre(chkPago2.isSelected());
                kardex.setPago_extra(chkPagoExtra.isSelected());
                if (!txtPromedio.getText().equals("")) {
                    kardex.setPromedio(Float.parseFloat(txtPromedio.getText()));
                }
                if (!txtDescuento.getText().equals("")) {
                    String descuento = txtDescuento.getText().replace("%", "");
                    kardex.setDescuento(Integer.parseInt(descuento));
                }
                lstKardex.add(kardex);

                //Se verifica que no se exceda la obtencion de semestres
                if (i == semestresTotales - 1) {
                    break;
                }
                i++;
            }

        }
        return lstKardex;
    }

    /**
     * Toma los semestres a evaluar de la pantalla VistaKardex
     *
     * @param lstKardex Lista con toda la informacion de la pantalla
     * @param semestres
     * @return
     */
    private List<Kardex> getDatosKardexBecario(List<Kardex> lstKardex, int semestres) {
        List<Kardex> lstResult = new ArrayList<>();

        for (int i = 0; i < semestres; i++) {
            lstResult.add(lstKardex.get(i));
        }

        return lstResult;
    }

    /**
     * Iguala a null todos los archivos de boletas y cartas de servicio comunitario
     */
    private void vaciaLstFiles() {
        for (File boleta : lstFilesBoletas) {
            boleta = null;
        }
        for (File carta : lstFilesCartaServCom) {
            carta = null;
        }
        for (File transferencia : lstFilesTransferencias) {
            transferencia = null;
        }
        
        fileActaNacimiento = null;
        fileBoleta_calificaciones_inicial = null;
        fileCartaAsignacionBeca = null;
        fileCarta_solicitud = null;
        fileContrato = null;
        fileEnsayo = null;
        fileEstudioSocioeconomico = null;
        fileFoto = null;
        fileIneAval = null;
        fileIneBecario = null;
        filePagare = null;
        fileCartaAgradecimiento = null;
    
    }

    /**
     * Llena los arreglos que contienen los archivos del kardex, boletas, cartas servicio comunitario
     * @param lstKardexs
     */
    private void addFilesKardex(List<Kardex> lstKardexs) {
        int i = 0;
        for (Kardex kardex : lstKardexs) {
            if(kardex.getBoleta() != null)
                lstFilesBoletas[i] = new File(Index.RUTA_BASE + Index.RUTA_SISTEMA + kardex.getBoleta());
            
            if(kardex.getCarta_servicio_comunitario() != null)
                lstFilesCartaServCom[i] = new File(Index.RUTA_BASE + Index.RUTA_SISTEMA + kardex.getCarta_servicio_comunitario());
            
            i++;
        }
    }

    /**
     * Se encarga de llenar el arreglo que almacena todos los archivos
     * @param lstKardexs Lista de todos los kardex del becario
     */
    private void addTransferenciasAArreglo(List<Kardex> lstKardexs) {
        int i = 0;
        for (Kardex Kardex : lstKardexs) {
            for (int j = 0; j <= 1; j++) {
                if(j == 0){
                    if(Kardex.getTransferencia1() != null)
                        lstFilesTransferencias[i] = new File(Index.RUTA_BASE + Index.SEPARADOR + 
                            Index.RUTA_SISTEMA + Index.SEPARADOR + Kardex.getTransferencia1());
                }
                else{
                    if(Kardex.getTransferencia2() != null)
                        lstFilesTransferencias[i] = new File(Index.RUTA_BASE + Index.SEPARADOR + 
                            Index.RUTA_SISTEMA + Index.SEPARADOR + Kardex.getTransferencia2());
                }
                i++;
            }  
        }
    }

    /**
     * Agrega una fila a la tabla indicada
     * @param tabla Tabla a agregar la fila
     */
    protected void agregarFilaTabla(JTable tabla) {
        String texto = vistaCatalogos.TxtFldDescripcionCatalogo.getText();
        //Si no se ha el filtrado el catalogo
        if(texto.equals("")){
            helper.agregaFilaTabla(tabla);
        }
        else{
            //Se obtiene el id más alto que tiene el catalogo
            long idMayor = getIdMayorCatalogo();
            
            lstCatalogoCopia = helper.agregaFilaTabla(tabla, vistaCatalogos.TxtFldDescripcionCatalogo, 
                    texto, lstCatalogoCopia, idMayor);
        }
    }

    /**
     * Elimina una fila a la tabla indicada
     * @param tabla 
     */
    protected void eliminaFilaTabla(JTable tabla) {
        //Se verifica si ya se filtró la tabla
        //Si no se ha filtrado el catalogo
        //if(vistaCatalogos.TxtFldDescripcionCatalogo.getText().isEmpty()){
            helper.eliminaFilaTabla(tabla, lstCatalogoCopia);
        //}
        //Si se han filtrado los datos
//        else
//            helper.eliminaFilaTabla(tabla, catNuevosDatosCatalogos);
        
    }

    /**
     * Inserta, Actualiza o Elimina los datos de un catalogo
     */
    protected void crudCatalogo() {
        
        //Si existen filtraciones realizadas
        if(!vistaCatalogos.TxtFldDescripcionCatalogo.getText().equals("")){
            JOptionPane.showMessageDialog(vistaCatalogos, "No se puede borrar un registro con las filtraciones activas", "Error", JOptionPane.ERROR_MESSAGE);
            vistaCatalogos.TxtFldDescripcionCatalogo.requestFocus();
            vistaCatalogos.TxtFldDescripcionCatalogo.selectAll();
            return;
        }
        
        helper.cursorEspera(vista);
        Conexion conn = new Conexion();
        Connection conexion = conn.estableceConexion();
//        List<String> lstDatosTabla = new ArrayList<>();
//        List<Boolean> lstDatosTipoEscuela = new ArrayList<>();
//        DefaultTableModel tblModel = (DefaultTableModel) vistaCatalogos.TblDescripcionCatalogo.getModel();
        
        String seleccion = (String) vistaCatalogos.cmbTipoCatalogo.getSelectedItem();
        int idTabla = getIdCmbBox(seleccion, catCatalogos);
        String nombreTabla = modelo.getNombreTabla(conexion, idTabla);
        
//        int totalRegistros = modelo.getTotalRegistrosDeCatalogo(conexion, nombreTabla);
//        int totalFilas = tblModel.getRowCount();
//        System.out.println("Filas: " + totalFilas);
//        //Se valida que la última fila no esté vacía
//        if(tblModel.getValueAt(totalFilas - 1, 0) == null)
//            totalFilas -= 1;
//        
//        for (int i = 0; i < totalFilas; i++) {
//            lstDatosTabla.add((String) tblModel.getValueAt(i, 0));
//        }
//        
//        int columnas = tblModel.getColumnCount();
//        if(columnas == 2){
//            for (int i = 0; i < totalFilas; i++) {
//                lstDatosTipoEscuela.add((boolean) tblModel.getValueAt(i, 1));
//            }
//        }
        
        try {
            conexion.setAutoCommit(false);
            
            //Se obtienen los nombres de las columnas de la tabla a modificar
            CatColumnasTabla nombreColumnas = modelo.getNombreColumnasTabla(conexion, nombreTabla);

            //Si no se se han hecho filtraciones
            if (vistaCatalogos.TxtFldDescripcionCatalogo.getText().isEmpty()) {
                //Si existe la misma cantidad de registros en el catalogo origianal y en la copia, se actualizan los valores
                if (lstCatalogoOriginal.size() == lstCatalogoCopia.size()) {
                    int i = 0;
                    for (Integer idCatalogo : lstCatalogoCopia.keySet()) {
                        boolean response;
                        String datoNuevo = lstCatalogoCopia.get(idCatalogo);
//                        if(lstDatosTipoEscuela.isEmpty())
                            response = modelo.updateCatalogo(conexion, datoNuevo, idCatalogo, 
                                            nombreTabla, nombreColumnas);
//                        else
//                            response = modelo.updateCatalogo(conexion, dato, i + 1, 
//                                            nombreTabla, nombreColumnas, lstDatosTipoEscuela.get(i));
                        if (response == false) {
                            helper.cursorNormal(vista);
                            throw new SQLException("No se pudo actualiza el catalogo "
                                    + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        i++;
                    }
                } //Si existen más registros en la tabla de los que ya se tienen registrados en la base de datos
                else if (lstCatalogoCopia.size() > lstCatalogoOriginal.size()) {
                    int i = 0;
                    //Mientras se recorran los registros existentes solo se actualizan
                    for (Integer idCatalogo : lstCatalogoCopia.keySet()) {
                        String datoCatalogoOriginal = lstCatalogoOriginal.get(idCatalogo);
                        String datoNuevo = lstCatalogoCopia.get(idCatalogo);
                        //Se actualizan los registros que ya existen en la bd
                        if (datoCatalogoOriginal != null) {
                            boolean response;
//                            if(lstDatosTipoEscuela.isEmpty())
                                response = modelo.updateCatalogo(conexion, datoNuevo, idCatalogo, 
                                                nombreTabla, nombreColumnas);
//                            else
//                                response = modelo.updateCatalogo(conexion, dato, i + 1, 
//                                                nombreTabla, nombreColumnas, lstDatosTipoEscuela.get(i));
                            if (response == false) {
                                helper.cursorNormal(vista);
                                throw new SQLException("No se pudo actualiza el catalogo "
                                        + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            boolean response; 
                                if(nombreTabla.contains("univer"))
                                    response = modelo.insertRegistroCatalogo(conexion, datoNuevo, idCatalogo, nombreTabla, nombreColumnas, false, lstCatalogoTipoUniversidad.get(idCatalogo));
                                else
                                    response = modelo.insertRegistroCatalogo(conexion, datoNuevo, idCatalogo, nombreTabla, nombreColumnas, false);
                                    
                            if (response == false) {
                                helper.cursorNormal(vista);
                                throw new SQLException("No se pudo insertar el registro en el catalogo "
                                        + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        i++;
                    }
                } //Si existen menos registros en la tabla de los que ya se tienen registrados en la base de datos
                else if (lstCatalogoCopia.size() < lstCatalogoOriginal.size()) {
                    int i = 0;
                    //Mientras se recorran los registros existentes solo se actualizan
                    for (Integer idCatalogo : lstCatalogoOriginal.keySet()) {
                        String datoCatalogoCopia = lstCatalogoCopia.get(idCatalogo);
                        //Se actualizan los registros que ya existen en la bd
                        if (datoCatalogoCopia != null) {
                            boolean response;
                            if(nombreTabla.contains("univer"))
                                response = modelo.updateCatalogo(conexion, datoCatalogoCopia, idCatalogo, nombreTabla, nombreColumnas, lstCatalogoTipoUniversidad.get(idCatalogo));
                            else
                                response = modelo.updateCatalogo(conexion, datoCatalogoCopia, idCatalogo, nombreTabla, nombreColumnas);
                            
                            if (response == false) {
                                helper.cursorNormal(vista);
                                throw new SQLException("No se pudo actualiza el catalogo "
                                        + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            boolean response = modelo.deleteRegistroCatalogo(conexion, idCatalogo, nombreTabla, nombreColumnas, false);
                            if (response == false) {
                                helper.cursorNormal(vista);
                                throw new SQLException("No se pudo borrar el registro en el catalogo "
                                        + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        i++;
                    }
                    
                    
                }
            }
            
            /**
             * *****************************************************************************
             */
            //Si se han hecho filtraciones
//            else{
//                //Si existen los mismos registros en la tabla como en la lista de datos filtrados, solo se actualizan los registros
//                if (totalFilas == catNuevosDatosCatalogos.size()) {
//                    //Se buscan y se actualizan los datos de la tabla en el catalogo original
//                    for (Integer key : catNuevosDatosCatalogos.keySet()) {
//                        boolean encontrado = false;
//                        for (Integer key2 : catDatosCatalogos.keySet()) {
//                            //Si se encontró el key en el catalogo original
//                            if(Objects.equals(key2, key)){
//                                encontrado = true;
//                                boolean response = tblModelo.updateCatalogo(conexion, 
//                                                catNuevosDatosCatalogos.get(key), key, nombreTabla, nombreColumnas);
//                                if (response == false) {
//                                    helper.cursorNormal(vista);
//                                    throw new SQLException("No se pudo actualiza el catalogo "
//                                            + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
//                                }
//                                break;
//                            }
//                        }
//                        // Si no se encontró el key en el catalogo original
//                        if(encontrado == false){
//                            boolean response = tblModelo.deleteRegistroCatalogo(conexion, key, nombreTabla, nombreColumnas, true);
//                            if (response == false) {
//                                helper.cursorNormal(vista);
//                                throw new SQLException("No se pudo borrar el registro en el catalogo "
//                                        + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
//                            }
//                        }
//                    }
//                } 
//                //Si existen más registros en la tabla de los que ya se tienen en el catalogo de nuevos datos
//                else if (totalFilas > catNuevosDatosCatalogos.size()) {
//                    
//////                    Se actualizan los nuevos valores en caso de que haya filtraciones
////                    if(catNuevosDatosCatalogos != null){
////                        int cont = 0;
////                        for (Integer key : catNuevosDatosCatalogos.keySet()) {
////                            String nombreViejo = catNuevosDatosCatalogos.get(key);
////                            String nombreNuevo = lstDatosTabla.get(cont);
////                            if(!nombreViejo.equals(nombreNuevo)){
////                                catNuevosDatosCatalogos.replace(key, nombreViejo, nombreNuevo);
////                            }
////                            cont++;
////                        }
////                    }
////                  //Se buscan y se actualizan los datos de la tabla en el catalogo original
//                    for (Integer key : catNuevosDatosCatalogos.keySet()) {
//                        for (Integer key2 : catDatosCatalogos.keySet()) {
//                            if(Objects.equals(key, key2)){
//                                boolean response = tblModelo.updateCatalogo(conexion, catNuevosDatosCatalogos.get(key), key, nombreTabla, nombreColumnas);
//                                if (response == false) {
//                                    helper.cursorNormal(vista);
//                                    throw new SQLException("No se pudo actualiza el catalogo "
//                                            + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
//                                }
//                                break;
//                            }
//                        }
//                    }
//                    int tamanioNuevoCat = catNuevosDatosCatalogos.size();
//                    int tamanioTabla = tblModel.getRowCount();
//                    int diff = tamanioTabla - tamanioNuevoCat;
//                    int inicioInsercion = (tamanioTabla - diff) ;
//                    while(inicioInsercion < tamanioTabla){
//                        
//                        boolean response = tblModelo.insertRegistroCatalogo(conexion, 
//                                    lstDatosTabla.get(inicioInsercion), catDatosCatalogos.size() + 1, nombreTabla, nombreColumnas, false);
//                        
//                        if (response == false) {
//                            helper.cursorNormal(vista);
//                            throw new SQLException("No se pudo insertar el registro en el catalogo "
//                                    + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
//                        }
//                        catNuevosDatosCatalogos.put(catDatosCatalogos.size() + 1,  lstDatosTabla.get(inicioInsercion));
//                        catDatosCatalogos.put(catDatosCatalogos.size() + 1,  lstDatosTabla.get(inicioInsercion));
//                        
//                        inicioInsercion++;
//                    }                    
//                } 
//                //Si existen menos registros en la tabla de los que ya se tienen en los datos filtrados
//                else if(totalFilas < catNuevosDatosCatalogos.size()){
//                    //Se buscan y se actualizan los datos de la tabla en el catalogo original
//                    
//                    for (Integer key : catNuevosDatosCatalogos.keySet()) {
//                        boolean encontrado = false;
//                        for (String nombreCategoria: lstDatosTabla) {
//                            if(nombreCategoria.equals(catNuevosDatosCatalogos.get(key))){
//                                encontrado = true;
//                                boolean response = tblModelo.updateCatalogo(conexion, 
//                                                catNuevosDatosCatalogos.get(key), key, nombreTabla, nombreColumnas);
//                                if (response == false) {
//                                    helper.cursorNormal(vista);
//                                    throw new SQLException("No se pudo actualiza el catalogo "
//                                            + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
//                                }
//                                break;
//                            }
//                        }
//                        //Si no se encontró el key en el catalogo original
//                        if(encontrado == false){
//                            boolean response = tblModelo.deleteRegistroCatalogo(conexion, key, nombreTabla, nombreColumnas, true);
//                            if (response == false) {
//                                helper.cursorNormal(vista);
//                                throw new SQLException("No se pudo borrar el registro en el catalogo "
//                                        + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
//                            }
//                            catNuevosDatosCatalogos.remove(key);
//                        }
//                    }
//                    
//                }                
//                
//            }
     
            conexion.commit();
            helper.cursorNormal(vista);
            JOptionPane.showMessageDialog(vistaCatalogos, "Tabla " + nombreTabla + " actualizada");

        } catch (SQLException ex) {
            helper.cursorNormal(vista);
            JOptionPane.showMessageDialog(vistaCatalogos, "No se pudo actualiza el catalogo " 
                                + vistaCatalogos.cmbTipoCatalogo.getSelectedItem(), "Error", JOptionPane.ERROR_MESSAGE);
            log.muestraErrores(ex);
        }
        finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
        }
        //System.out.println("Filas: " + totalFilas);        
    }

    /**
     * Inhabilita al becario, osea, pone el campo activo del becario como false
     */
    protected void desactivaBecario() {
        
//        int response = JOptionPane.showConfirmDialog(vistaRegistro, 
//                "¿Seguro que desea desactivar al becario", "Desactivación de becario", JOptionPane.YES_NO_OPTION);
        Connection conexion = null;
        String[] opciones = new String[]{"Truncar al Becario", "Dar de baja al Becario", "Cancelar"};
        int response = JOptionPane.showOptionDialog(vistaRegistro, "¿Qué desea hacer?", 
                "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[0]);
        
        
        //Si se decidió truncar al becario
        if(response == 0){
            helper.cursorEspera(vista);
            Conexion conn = new Conexion();
            conexion = conn.estableceConexion();

            if(conexion == null){
                JOptionPane.showMessageDialog(vistaRegistro, "No se pudo conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                log.muestraErrores(new SQLException("No se pudo conectar a la base de datos"));
            }

            Becario becario = modelo.getBecarioPorFolio(conexion, vistaRegistro.txtFolio.getText());
            //boolean result = tblModelo.updateCampoActivoBecario(conexion, becario, false);
            boolean result = modelo.updateTruncaBecario(conexion, becario);
            
            helper.cursorNormal(vista);
            if(result)
                JOptionPane.showMessageDialog(vistaRegistro, "El becario con el folio " + becario.getFolio() + " ha sido truncado", "Exito", JOptionPane.DEFAULT_OPTION);
            else
                JOptionPane.showMessageDialog(vistaRegistro, "No se pudo deshabilitar al becario", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(response == 1){
            helper.cursorEspera(vista);
            Conexion conn = new Conexion();
            conexion = conn.estableceConexion();

            if(conexion == null){
                JOptionPane.showMessageDialog(vistaRegistro, "No se pudo conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                log.muestraErrores(new SQLException("No se pudo conectar a la base de datos"));
            }

            Becario becario = modelo.getBecarioPorFolio(conexion, vistaRegistro.txtFolio.getText());
            //boolean result = tblModelo.updateCampoActivoBecario(conexion, becario, false);
            boolean result = modelo.updateCampoActivoBecario(conexion, becario, false);
            
            helper.cursorNormal(vista);
            if(result)
                JOptionPane.showMessageDialog(vistaRegistro, "El becario con el folio " + becario.getFolio() + " ha sido inhabilitado", "Exito", JOptionPane.DEFAULT_OPTION);
            else
                JOptionPane.showMessageDialog(vistaRegistro, "No se pudo deshabilitar al becario", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if(conexion != null){
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    /**
//     * Se encarga de buscar la palabra ingresada por el usuario dentro del catalogo que se tiene activo
//     */
//    protected void getDatosCatalogos() {
//        if(catNuevosDatosCatalogos != null){
//            catNuevosDatosCatalogos.clear();
//            catNuevosDatosCatalogos = null;
//        }
//        catNuevosDatosCatalogos = Helper.getDatosCatalogos(vistaCatalogos.TxtFldDescripcionCatalogo.getText(), 
//                catDatosCatalogos, vistaCatalogos.TblDescripcionCatalogo, (String) vistaCatalogos.cmbTipoCatalogo.getSelectedItem());
//    }
    
    /**
     * Busca sobre una lista de categorías la palabra ingresada
     * @param texto Texto a buscar en la lista categorias
     * @param tblTabla
     * @param nombreTabla
     */
    public void getDatosCatalogos(String texto, 
                        JTable tblTabla, String nombreTabla) {
        
        Conexion conn = new Conexion();
        Connection conexion = conn.estableceConexion();
        
        if(conexion == null){
            JOptionPane.showMessageDialog(vista, "No se pudo conectar a la base de datos. \n Intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(lstCatalogoCopiaEnBusquedas != null){
            lstCatalogoCopiaEnBusquedas.clear();
            lstCatalogoCopiaEnBusquedas = null;
        }
        
        if(lstCatalogoTipoUniversidad != null){
            lstCatalogoTipoUniversidad.clear();
            lstCatalogoTipoUniversidad = null;
        }
        
        lstCatalogoCopiaEnBusquedas = new LinkedHashMap<>();
        lstCatalogoTipoUniversidad = new LinkedHashMap<>();
        
        DefaultTableModel tblModelo = (DefaultTableModel) tblTabla.getModel();
        int filas = tblModelo.getRowCount();
        
        for (int i = 0; i < filas; i++) {
            tblModelo.removeRow(0);
        }
        
        for (Integer key : lstCatalogoCopia.keySet()) {
            String datoCategoria = lstCatalogoCopia.get(key);
            
            int res = datoCategoria.toLowerCase().indexOf(texto.toLowerCase());
            if(res != -1)
                lstCatalogoCopiaEnBusquedas.put(key, datoCategoria);
        }
        
        if(tblModelo.getColumnCount() == 2)
            llenaTablaCatalogos(lstCatalogoCopiaEnBusquedas, tblTabla, false, conexion);
        else
            llenaTablaCatalogos(lstCatalogoCopiaEnBusquedas, tblTabla, true, conexion);
    }

    /**
     * Obtiene el id más alto que se tiene en el catalogo evaluado
     * @return 
     */
    private long getIdMayorCatalogo() {
        Conexion conn = new Conexion();
        Connection conexion = conn.estableceConexion();
        long idCatalogo = 0;
        if(conexion == null){
            JOptionPane.showMessageDialog(vistaCatalogos, "No se pudo conectar a la base de datos. \n Verifique su conexión, e intentlo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            return idCatalogo;
        }
        String seleccion = (String) vistaCatalogos.cmbTipoCatalogo.getSelectedItem();
        int idTabla = getIdCmbBox(seleccion, catCatalogos);
        String nombreTabla = modelo.getNombreTabla(conexion, idTabla);

        lstCatalogoOriginal = modelo.getDatosCatalogo(conexion, nombreTabla);
        //Se obtienen los nombres de las columnas de la tabla a modificar
        CatColumnasTabla nombreColumnas = modelo.getNombreColumnasTabla(conexion, nombreTabla);
        idCatalogo = modelo.getIdMayorCatalogo(conexion, nombreTabla, nombreColumnas);        
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
            log.muestraErrores(ex);
        }
        
        return idCatalogo;
    }
}
