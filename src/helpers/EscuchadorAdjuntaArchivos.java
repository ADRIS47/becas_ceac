/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sergio
 */
public class EscuchadorAdjuntaArchivos implements ActionListener{
    JPanel vista;
    JButton boton;
    int codigo;
    JLabel etiqueta;
    File archivo;
    public final static int ADD_FOTO = 1;
    public final static int ADD_DOCUMENTO_PDF = 2;
    public final static int DELETE_DOCUMENTO_PDF = 3;
    private JLabel lblEstatus;
    private JLabel lblFotgrafia;
    
    
    /**
     * Se utiliza para la carga de imagenes
     * @param vista
     * @param boton
     * @param codigo
     * @param lblFotgrafia
     * @param archivo 
     * @param lblEstatus 
     */
    public EscuchadorAdjuntaArchivos(JPanel vista, JButton boton, int codigo, JLabel lblFotgrafia, File archivo, JLabel lblEstatus) {
        this.vista = vista;
        this.boton = boton;
        this.codigo = codigo;
        this.lblFotgrafia = lblFotgrafia;
        this.archivo = archivo;
        this.lblEstatus = lblEstatus;
    }
    
    /**
     * Se utiliza para la carga de documentos
     * @param vista
     * @param boton
     * @param codigo
     * @param archivo 
     * @param lblEstatus 
     */
    public EscuchadorAdjuntaArchivos(JPanel vista, JButton boton, int codigo, File archivo, JLabel lblEstatus) {
        this.vista = vista;
        this.boton = boton;
        this.codigo = codigo;
        this.archivo = archivo;
        this.lblEstatus = lblEstatus;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int select;
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro;
        Helper helper = new Helper();
        String nombreArchivo;
        switch(codigo){
            case EscuchadorAdjuntaArchivos.ADD_FOTO:
                //selector = new JFileChooser();
                filtro = new FileNameExtensionFilter("PNG, JPG, JPEG", "jpg","png","jpeg");
                selector.setFileFilter(filtro);
                select = selector.showOpenDialog(vista);

                if(select == JFileChooser.APPROVE_OPTION){
                    archivo = selector.getSelectedFile();
                    helper.cargaImagenExterna(etiqueta, archivo.toPath());
                }
                break;
                
            case EscuchadorAdjuntaArchivos.ADD_DOCUMENTO_PDF:
                //selector = new JFileChooser();
                filtro = new FileNameExtensionFilter("PDF", "pdf");
                selector.setFileFilter(filtro);
                select = selector.showOpenDialog(vista);

                if(select == JFileChooser.APPROVE_OPTION){
                    archivo = selector.getSelectedFile();
                    nombreArchivo = archivo.getName();
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
                break;
                
            case EscuchadorAdjuntaArchivos.DELETE_DOCUMENTO_PDF:
                archivo =null;
                lblEstatus.setText("Eliminado");
                break;
        }
        
        
    }
    
}
