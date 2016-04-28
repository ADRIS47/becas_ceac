/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *
 * @author sergio
 */
public class EscuchadorCalculaDescuentoSemestral implements KeyListener{
    
    JCheckBox chkPlatica1; 
    JCheckBox chkPlatica2; 
    JTextField txtPromedio; 
    JTextField txtDescuento;

    public EscuchadorCalculaDescuentoSemestral(JCheckBox chkPlatica1, JCheckBox chkPlatica2, JTextField txtPromedio, JTextField txtDescuento) {
        this.chkPlatica1 = chkPlatica1;
        this.chkPlatica2 = chkPlatica2;
        this.txtPromedio = txtPromedio;
        this.txtDescuento = txtDescuento;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Helper.getDescuentoSemestral(chkPlatica1, chkPlatica2, txtPromedio, txtDescuento);
    }
    
}
