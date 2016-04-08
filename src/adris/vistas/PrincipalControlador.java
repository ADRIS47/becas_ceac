/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adris.vistas;

import helpers.Log;
import index.Index;
import java.awt.Component;
import java.sql.SQLException;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import principal.*;

/**
 *
 * @author sabagip
 */
public class PrincipalControlador {
    
    VistaPanelPrincipal vista;
    VistaRegistro vistaRegistro;
    PnlHermanos vistaHermanos;
    PnlHijos vistaHijos;
    PnlParentesco vistaParentesco;
    PrincipalModelo modelo;
    Index controladorPrincipal;
    PnlDireccion vistaDireccion;
    Log log = new Log();
    
    
    TreeMap<Integer, String> catSexo = null;
    TreeMap<Integer, String> catEstadoCivil = null;
    TreeMap<Integer, String> catPrograma = null;
    TreeMap<Integer, String> catParentesco = null;
    TreeMap<Integer, String> catNivelEstudios = null;
    
    public static void main(String[] args) {
        PrincipalControlador Controlador=new PrincipalControlador();
        Controlador.iniciaPantallaPrincipal();
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

    public void setVistaHermanos(PnlHermanos vistaHermanos) {
        this.vistaHermanos = vistaHermanos;
    }

    public void setVistaHijos(PnlHijos vistaHijos) {
        this.vistaHijos = vistaHijos;
    }

    public void setVistaParentesco(PnlParentesco vistaParentesco) {
        this.vistaParentesco = vistaParentesco;
    }

    public void setVistaDireccion(PnlDireccion vistaDireccion) {
        this.vistaDireccion = vistaDireccion;
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
        
        
        //catPrograma = lstCategorias.get(2);
        for (Integer key : catSexo.keySet()) {
            vistaRegistro.combobxSexoBecado.addItem(catSexo.get(key));
        }
        //Se llena el combo box de Estado civil
        for (Integer key : catEstadoCivil.keySet()) {
            vistaRegistro.combobxCivilBecado.addItem(catEstadoCivil.get(key));
        }
        //Se llena el combo box de Programas
        for (Integer key : catPrograma.keySet()) {
            vistaRegistro.comboBoxPrograma.addItem(catPrograma.get(key));
        }
        //Se llena el combo box de Nivel de estudios
        for (Integer key : catNivelEstudios.keySet()) {
//            vistaParentesco.cmbNivelEstudiosPariente.addItem(catNivelEstudios.get(key));
//            vistaHermanos.cmbNivelEstudiosHermano.addItem(catNivelEstudios.get(key));
        }
        //Se llena el combo box de Parentesco
        for (Integer key : catParentesco.keySet()) {
//            vistaParentesco.cmbParentesco.addItem(catParentesco.get(key));
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
        vistaParentesco = new PnlParentesco();
        vistaHermanos = new PnlHermanos();
        vistaHijos = new PnlHijos();
        vistaDireccion = new PnlDireccion();
        
//        vistaParentesco.setControlador(this);
//        vistaHermanos.setControlador(this);
//        vistaHijos.setControlador(this);
//        vistaDireccion.setControlador(this);
//        
        this.setVistaHermanos(vistaHermanos);
        this.setVistaHijos(vistaHijos);
        this.setVistaParentesco(vistaParentesco);
        this.setVistaDireccion(vistaDireccion);
        
        vistaRegistro.spnlParentesco.setViewportView(vistaParentesco);
        vistaRegistro.spnlHermanos.setViewportView(vistaHermanos);
        vistaRegistro.spnlHijos.setViewportView(vistaHijos);
        vistaRegistro.spnlDirecciones.setViewportView(vistaDireccion);
        
        vistaParentesco.setVisible(true);
        vistaHermanos.setVisible(true);
        vistaHijos.setVisible(true);
        
    }
    
}
