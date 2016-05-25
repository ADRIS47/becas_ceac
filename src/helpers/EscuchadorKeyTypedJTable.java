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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sabagip
 */
public class EscuchadorKeyTypedJTable implements KeyListener{
    
    JTable tabla;
    DefaultTableModel tblModelo;
    LinkedHashMap<Integer, String> lstValores;
    String antiguoValor;

    public EscuchadorKeyTypedJTable(JTable tabla, LinkedHashMap<Integer, String> lstValores) {
        this.tabla = tabla;
        this.tblModelo = (DefaultTableModel) tabla.getModel();
        this.lstValores = lstValores;
    }
    
    

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("HOla");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("MUndo");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String campoNuevo = (String) tblModelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
        String campoViejo = (String) tblModelo.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn());
        campoViejo = campoViejo.substring(0, campoViejo.length() - 1);
        
        System.out.println("Campo viejo: " + campoViejo);
        System.out.println("Campo nuevo: " + campoNuevo);
    }
    
}
