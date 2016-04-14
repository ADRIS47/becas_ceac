/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sergio
 */
public class EscuchadorTelefono implements FocusListener{
    
    JTextField txtCampo;
    JPanel panel;

    public EscuchadorTelefono(JPanel panel, JTextField txtCampo) {
        this.txtCampo = txtCampo;
        this.panel = panel;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(txtCampo.getKeyListeners().length == 0){
            txtCampo.addKeyListener(new EscuchadorTeclas(panel, EscuchadorTeclas.NUMEROS, txtCampo));
        }
        
    }

    @Override
    public void focusLost(FocusEvent e) {
//        Pattern patron;
//        Matcher matcher;
//        patron = Pattern.compile("^[1-9]{10}$");
//                matcher = patron.matcher(txtCampo.getText());
//                if(!matcher.matches()){
//                    panel.getToolkit().beep();
//                    txtCampo.requestFocus();
//                    JOptionPane.showMessageDialog(panel, "Debes de ingresar un teléfono de 10 digitos", "Error", JOptionPane.ERROR_MESSAGE);
//                }
        if(txtCampo.getText().length() < 10 || txtCampo.getText().length() > 10){
             JOptionPane.showMessageDialog(panel, "Debes de ingresar un teléfono de 10 digitos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
