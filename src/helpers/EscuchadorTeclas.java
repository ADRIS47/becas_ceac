/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sergio
 */
public class EscuchadorTeclas implements KeyListener{
    JPanel vista;
    public final static int LETRAS = 1;
    public final static int NUMEROS = 2;
    public final static int EMAIL = 3;
    public final static int LETRAS_Y_NUMEROS = 4;
    public final static int TELEFONO = 5;
    int codigo;
    JTextField txtCampo;
    
    /**
     * 
     * @param vista Pantalla donde se agregara el escuchador
     * @param codigo Clave que determina que se evaluara
     * @param txtCampo Campo de texto a evaluar
     */
    public EscuchadorTeclas(JPanel vista, int codigo, JTextField txtCampo) {
        this.vista = vista;
        this.codigo = codigo;
        this.txtCampo = txtCampo;
    }
    
    

    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char c;
        Pattern patron = null;
        Matcher matcher;
        switch(codigo){
            //Solo Letras
            case 1:               
                /*patron = Pattern.compile("^[a-zA-Z_áéíóúñ\\s]*$");
                matcher = patron.matcher(txtCampo.getText());
                if(!matcher.matches()){
                    vista.getToolkit().beep();
                    e.consume();
                    JOptionPane.showMessageDialog(vista, "Solo debes de ingresar letras", "Error", JOptionPane.ERROR_MESSAGE);
                }*/     c = e.getKeyChar();
                if(!Character.isLetter(c)){
                    JOptionPane.showMessageDialog(vista, "Solo debes de ingresar letras", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
                
            //Solo numeros
            case 2:
                /*patron = Pattern.compile("[1-9]*$");
                matcher = patron.matcher(txtCampo.getText());
                if(!matcher.matches()){
                    vista.getToolkit().beep();
                    e.consume();
                    JOptionPane.showMessageDialog(vista, "Solo debes de ingresar Numeros", "Error", JOptionPane.ERROR_MESSAGE);
                }*/
                c = e.getKeyChar();
                int code = e.getKeyCode();
                int code2 = e.getExtendedKeyCode();
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER ){
                    break;
                }
                
                if(!Character.isDigit(c)){
                    e.consume();
                    JOptionPane.showMessageDialog(vista, "Solo debes de ingresar numeros", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                else if(Character.isDigit(c) && txtCampo.getText().length() > 9){
                    e.consume();
                }
                break;
            //Email
            case 3:
                patron = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$");
                matcher = patron.matcher(txtCampo.getText());
                if(!matcher.matches()){
                    vista.getToolkit().beep();
                    e.consume();
                    JOptionPane.showMessageDialog(vista, "Debes de ingresar un email", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            
            //LETRAS Y NUMEROS
            case 4:
                break;
                
            //Telefono
            case 5:    
//                if(txtCampo.getText().length() < 10){
//                    patron = Pattern.compile("\\d");
//                }
//                if(txtCampo.getText().length() == 10){
//                    patron = Pattern.compile("\\d{10}");
//                }
//                
//                matcher = patron.matcher(txtCampo.getText());
//                if(!matcher.matches()){
//                    vista.getToolkit().beep();
//                    e.consume();
//                    JOptionPane.showMessageDialog(vista, "Debes de ingresar un teléfono de 10 digitos", "Error", JOptionPane.ERROR_MESSAGE);
//                }
                
                c = e.getKeyChar();
                if(!Character.isDigit(c)){
                    JOptionPane.showMessageDialog(vista, "Solo debes de ingresar numeros", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
    }
    
}
