/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author sabagip
 */
public class EscuchadorCalculaBecaXSemestre implements KeyListener {
    
    JTextField txtBecaAutorizada, txtBecaSemestral;
    JComboBox<?> cmbSemestreInicioBeca, cmbSemestresTotales;

    /**
     * 
     * @param txtBecaAutorizada Campo de beca autorizada
     * @param cmbSemestreInicioBeca Campo del semestre que cursa el becario al solicitar la beca
     * @param cmbSemestresTotales
     * @param txtBecaSemestral Campo donde se pondrá el total de la beca semestral
     */
    public EscuchadorCalculaBecaXSemestre(JTextField txtBecaAutorizada, JComboBox<?> cmbSemestreInicioBeca,
            JComboBox<?> cmbSemestresTotales, JTextField txtBecaSemestral) {
        this.txtBecaAutorizada = txtBecaAutorizada;
        this.txtBecaSemestral = txtBecaSemestral;
        this.cmbSemestresTotales = cmbSemestresTotales;
        this.cmbSemestreInicioBeca = cmbSemestreInicioBeca;
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
        Helper.getBecaSemestral(cmbSemestresTotales, cmbSemestreInicioBeca, txtBecaAutorizada, txtBecaSemestral);
    }
    
}
