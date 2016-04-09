/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import helpers.Helper;
import helpers.Log;
import index.Index;
import java.awt.Component;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    
    TreeMap<Integer, String> catSexo = null;
    TreeMap<Integer, String> catEstadoCivil = null;
    TreeMap<Integer, String> catPrograma = null;
    TreeMap<Integer, String> catParentesco = null;
    TreeMap<Integer, String> catNivelEstudios = null;
    
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
//
//    public void setVistaHermanos(PnlHermanos vistaHermanos) {
//        this.vistaHermanos = vistaHermanos;
//    }
//
//    public void setVistaHijos(PnlHijos vistaHijos) {
//        this.vistaHijos = vistaHijos;
//    }
//
//    public void setVistaParentesco(PnlParentesco vistaParentesco) {
//        this.vistaParentesco = vistaParentesco;
//    }
//
//    public void setVistaDireccion(PnlDireccion vistaDireccion) {
//        this.vistaDireccion = vistaDireccion;
//    }
    
    
    
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
        List<TreeMap<Integer, String>> lstCategorias = null;
                
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
        vista.pnlOpciones.setViewportView(pantalla);
        pantalla.setVisible(true);
        vista.pnlOpciones.updateUI();
        vista.pnlOpciones.validate();
        vista.repaint();
    }
    
    /**
     * Llena con los datos de las categorias la pantalla VistaRegistro
     * @param lstCategorias 
     */
    private void llenaCamposVistaRegistro(List<TreeMap<Integer, String>> lstCategorias){
        //Se separan las categorias
        catSexo = lstCategorias.get(0);
        catEstadoCivil = lstCategorias.get(1);
        catPrograma = lstCategorias.get(2);
        catNivelEstudios = lstCategorias.get(3);
        catParentesco = lstCategorias.get(4);
        
        llenaComboCategorias(vistaRegistro.combobxCivilBecado, catEstadoCivil);
        llenaComboCategorias(vistaRegistro.comboBoxPrograma, catPrograma);
        llenaComboCategorias(lstVistaParentesco.get(0).cmbNivelEstudiosPariente, catNivelEstudios);
        llenaComboCategorias(lstVistaHermanos.get(0).cmbNivelEstudiosHermano, catNivelEstudios);
        llenaComboCategorias(lstVistaParentesco.get(0).cmbNivelEstudiosPariente, catNivelEstudios);
        llenaComboCategorias(lstVistaParentesco.get(0).cmbParentesco, catParentesco);
        
    }
    
    /**
     * Llena el combo box indicado
     */
    private void llenaComboCategorias(JComboBox combo, TreeMap<Integer, String> lstCategoria){
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
    
}
