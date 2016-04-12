/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import helpers.Helper;
import helpers.Log;
import index.Index;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import pojos.Becario;
import pojos.Direccion;
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
    
    File foto;
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
        
//        this.setVistaHermanos(vistaHermanos);
//        this.setVistaHijos(vistaHijos);
//        this.setVistaParentesco(vistaParentesco);
//        this.setVistaDireccion(vistaDireccion);
        
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
            foto = selector.getSelectedFile();
            helper.cargaImagenExterna(vistaRegistro.lblFotografia, foto.toPath());
        }
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
        
        vistaRegistro.repaint();
        vista.repaint();
        
    }

    /**
     * Comienza la insersión del becario, en caso de que falten datos generales de llenar se guarda como pendiente
     */
    protected void insertaNuevoBecario() {
        
        boolean vacio = validaCamposVacios();
//       Becario becario = getDatosBecarioDeFormulario();
//       List<Direccion> lstDireccionesBecario = getDireccionBecarioDeFormulario(becario.getId());
//       List<Telefono> lstTelefonosBecario = getTelefonoBecarioDeFormulario(becario.getId());
//        vistaRegistro.repaint();
//        vista.repaint();
    }

    private Becario getDatosBecarioDeFormulario() {
        Becario becario = new Becario();
        
        //Se obtiene el id del programa seleccionado
        String prog = getSeleccionCmbBox(vistaRegistro.comboBoxPrograma);
        becario.setIdPrograma(getIdCmbBox(prog, catPrograma));
        //Se obtiene las iniciales del folio
        String inicioFolio = modelo.getClavePrograma(getIdCmbBox(prog, catPrograma));
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
        //Se obtiene el id del sexo
        becario.setIdSexo(vistaRegistro.combobxSexoBecado.getSelectedIndex());
        //Se obtiene el nombre del becario
        becario.setNombre(vistaRegistro.txtNombreBecado.getText());
        //Se obtiene el ap paterno del becario
        becario.setApPaterno(vistaRegistro.txtApPaternoBecado.getText());
        //Se obtiene el ap materno del becario
        becario.setApMaterno(vistaRegistro.txtApMaternoBecado.getText());
        //Se obtiene la fecha de nacimiento del becario
        long fecha = getFecha(vistaRegistro.txtFechaNacimiento.getText());
        becario.setFecha_nac(new Date(fecha));
        //Se obtiene los datos del conyuge
        becario.setNombreConyuge(vistaRegistro.txtNombreConyuge.getText());
        becario.setApPaternoConyuge(vistaRegistro.txtApPaternoConyuge.getText());
        becario.setApMaternoConyuge(vistaRegistro.txtApMaternoConyuge.getText());
        //Se obtiene si es el primero con beca
        becario.setPrimeroConBeca(vistaRegistro.cmboxCarreraSiNo.getSelectedIndex());
        return becario;
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
     * Obtiene la(s) direccion(es) del nuevo becario
     * @return Lista de Direcciones del becario
     */
    private List<Direccion> getDireccionBecarioDeFormulario(long idBecario) {
        List<Direccion> lstDirecciones = new ArrayList<>();
        
        for (PnlDireccion panel : lstVistaDireccion) {
                Direccion direccion = new Direccion();
                direccion.setCalle(panel.txtCalleBecado.getText());
                direccion.setNumExt(panel.txtNumBecado.getText());
                direccion.setNumInt(panel.txtIntBecado.getText());
                direccion.setCodigoPostal(panel.txtCpBecado.getText());
                direccion.setColonia(panel.txtNumIntBecado.getText());
                direccion.setCiudad(panel.txtCiudadBecado.getText());
                direccion.setIdBecario(idBecario);
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
            telefono.setIdBecario(idBecario);
            telefono.setTelefono(vistaRegistro.txtTel1Becado.getText());
            lstTelefono.add(telefono);
        }
        if(!vistaRegistro.txtTel2Becado.getText().equals("")){
            Telefono telefono = new Telefono();
            telefono.setIdBecario(idBecario);
            telefono.setTelefono(vistaRegistro.txtTel2Becado.getText());
            lstTelefono.add(telefono);
        }
        if(!vistaRegistro.txtTel3Becado.getText().equals("")){
            Telefono telefono = new Telefono();
            telefono.setIdBecario(idBecario);
            telefono.setTelefono(vistaRegistro.txtTel3Becado.getText());
            lstTelefono.add(telefono);
        }
        
        return lstTelefono;
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
        recorreJPanel(vistaRegistro.pnlDatosGenerales, 1);
        recorreJPanel(vistaRegistro.pnlParentesco, 1);
        recorreJPanel(vistaRegistro.pnlInformacionEscolar, 1);
        recorreJPanel(vistaRegistro.pnlManejoBeca, 1);
        recorreJPanel(vistaRegistro.pnlDirecciones, 1);
        recorreJPanel(vistaRegistro.pnlCorreos, 1);
        
        return response;
    }
}
