/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedHashMap;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author sabagip
 */
public class EscuchadorBuscaCatalogo implements KeyListener{
    
    JTextField txtBuscador;
    LinkedHashMap<Integer, String> catDatosCatalogos;
    JTable tblTabla;

    public EscuchadorBuscaCatalogo(JTextField txtBuscador, LinkedHashMap<Integer, String> catDatosCatalogos, JTable tblTabla) {
        this.txtBuscador = txtBuscador;
        this.catDatosCatalogos = catDatosCatalogos;
        this.tblTabla = tblTabla;
    }
    
    

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Entrada");
        //Helper.getDatosCatalogos(txtBuscador.getText(), catDatosCatalogos, tblTabla);
    }
    
}
