/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import adris.vistas.VistaRegistro;
import java.awt.Image;
import java.nio.file.Path;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author sabagip
 */
public class Helper {
    /**
     * Carga una imagen dentro de un label y la adapta al tamaño de la etiqueta
     * @param etiqueta Etiqueta donde se pondrá la imagen
     * @param ruta Ruta de la imagen que se pondrá en la etiqueta
     */
    public void cargaImagenLocal(JLabel etiqueta, String ruta){
        ImageIcon fot = new ImageIcon(getClass().getResource(ruta));
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(etiqueta.getWidth(), 
                etiqueta.getHeight(), Image.SCALE_DEFAULT));
        etiqueta.setIcon(icono);
    }
    
    public void cargaImagenExterna(JLabel etiqueta, Path path){
        ImageIcon fot = new ImageIcon(path.toString());
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(etiqueta.getWidth(), 
                etiqueta.getHeight(), Image.SCALE_DEFAULT));
        etiqueta.setIcon(icono);
    }

    /**
     * Agrega un JPanel a un JScrollPane 
     * @param componente Componente que se desea agregar al ScrollPane
     * @param spnlParentesco JScrollPane donde se agregará el componente
     */
    public void agregaJPanel(JComponent componente, JScrollPane spnlParentesco) {
        //spnlParentesco.setViewportView(componente);
        //spnlParentesco.getViewport().add(componente);
        spnlParentesco.getViewport().add(componente, -1);
        //spnlParentesco.validate();
    }
    
    /**
     * Agrega un JPanel a otro Jpanel 
     * @param componente Componente que se desea agregar al ScrollPane
     * @param spnlParentesco JScrollPane donde se agregará el componente
     */
    public void agregaJPanel(JComponent componente, JPanel panel) {
        panel.add(componente);
        //panel.validate();
    }
    
}
