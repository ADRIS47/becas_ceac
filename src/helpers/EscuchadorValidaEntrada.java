/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sergio
 */
public class EscuchadorValidaEntrada implements KeyListener {

    JPanel vista;
    public final static int LETRAS = 1;
    public final static int NUMEROS = 2;
    public final static int EMAIL = 3;
    public final static int LETRAS_Y_NUMEROS = 4;
    public final static int TELEFONO = 5;
    public final static int LETRAS_NUMEROS_ESPACIO = 6;
    public final static int FECHA_NACIMIENTO = 7;
    public final static int DINERO = 8;
    public final static int CODIGO_POSTAL = 9;
    int codigo;
    JTextField txtCampo;

    /**
     *
     * @param vista Pantalla donde se agregara el escuchador
     * @param codigo Clave que determina que se evaluara
     * @param txtCampo Campo de texto a evaluar
     */
    public EscuchadorValidaEntrada(JPanel vista, int codigo, JTextField txtCampo) {
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
        
        switch(codigo){
            case EscuchadorValidaEntrada.LETRAS:
                evaluaLetras();
                break;
                
            case EscuchadorValidaEntrada.LETRAS_Y_NUMEROS:
                evaluaNumerosYLetras();
                break;
                
            case EscuchadorValidaEntrada.NUMEROS:
                evaluaNumeros();
                break;
                
            case EscuchadorValidaEntrada.EMAIL:
                
                break;
                
            case EscuchadorValidaEntrada.TELEFONO:
                evaluaTelefono();
                break;
                
            case EscuchadorValidaEntrada.LETRAS_NUMEROS_ESPACIO:
                evaluaLetrasNumerosEspacios();
                break;
            
            case EscuchadorValidaEntrada.FECHA_NACIMIENTO:
                evaluaFechaNacimiento();
                break;
                
            case EscuchadorValidaEntrada.DINERO:
                evaluaDinero();
                break;
                
            case EscuchadorValidaEntrada.CODIGO_POSTAL:
                evaluaCodigoPostal();
                break;
        }
    }
    
    
    private void evaluaNumeros(){
        String str = txtCampo.getText();
        char[] fuente = str.toCharArray();
        char[] resultado = new char[fuente.length];
        int j = 0;
        boolean error = false;

        for (int i = 0; i < fuente.length; i++) {

            if ((fuente[i] >= '0' && fuente[i] <= '9')) {
                str = str.replace(",", "");
                resultado[j++] = fuente[i];
            } 
            else{
                error = true;
                java.awt.Toolkit.getDefaultToolkit().beep();
            }

            if (error) {
                txtCampo.setText("");
                txtCampo.setText(new String(resultado, 0, j));
            }
        }
    }
    
    private void evaluaDinero(){
        String str = txtCampo.getText();
        str = str.replace(",", "");
        str = str.replace(".", "");
        char[] fuente = str.toCharArray();
        char[] resultado = new char[fuente.length];
        int j = 0;
        boolean error = false;
                
        for (int i = 0; i < fuente.length; i++) {

            if (fuente[i] >= '0' && fuente[i] <= '9' || fuente[i] == ',') {
                
                resultado[j++] = fuente[i];
                DecimalFormat formato = new DecimalFormat("###,###,###.##");
                System.out.println(formato.format(Long.parseLong(str)));
                txtCampo.setText(formato.format(Long.parseLong(str)));
            } 
            else{
                error = true;
                java.awt.Toolkit.getDefaultToolkit().beep();
            }

            if (error) {
                txtCampo.setText("");
                txtCampo.setText(new String(resultado, 0, j));
            }
        }
    }
    
    private void evaluaLetras(){
        String str = txtCampo.getText();
        char[] fuente = str.toCharArray();
        char[] resultado = new char[fuente.length];
        int j = 0;
        boolean error = false;

        for (int i = 0; i < fuente.length; i++) {

            if ((fuente[i] >= 'a' && fuente[i] <= 'z') || (fuente[i] >= 'A' && fuente[i] <= 'Z')) {
                resultado[j++] = fuente[i];
            } 
            else{
                error = true;
                java.awt.Toolkit.getDefaultToolkit().beep();
            }

            if (error) {
                txtCampo.setText("");
                txtCampo.setText(new String(resultado, 0, j));
            }
        }
    }
    
    private void evaluaTelefono(){
        String str = txtCampo.getText();
        char[] fuente = str.toCharArray();
        char[] resultado = new char[fuente.length];
        int j = 0;
        boolean error = false;

        for (int i = 0; i < fuente.length; i++) {

            if ((fuente[i] >= '0' && fuente[i] <= '9')) {
                resultado[j++] = fuente[i];
            } 
            else{
                error = true;
                java.awt.Toolkit.getDefaultToolkit().beep();
            }

            if (error) {
                txtCampo.setText("");
                txtCampo.setText(new String(resultado, 0, j));
            }
            
            if(i == 10){
                txtCampo.setText(new String(resultado, 0, 10));
            }
        }
    }
    
    private void evaluaNumerosYLetras(){
        String str = txtCampo.getText();
        char[] fuente = str.toCharArray();
        char[] resultado = new char[fuente.length];
        int j = 0;
        boolean error = false;

        for (int i = 0; i < fuente.length; i++) {

            if ((fuente[i] >= 'a' && fuente[i] <= 'z') || 
                    (fuente[i] >= 'A' && fuente[i] <= 'Z') ||
                    (fuente[i] >= '0' && fuente[i] <= '9')) {
                resultado[j++] = fuente[i];
            } 
            else{
                error = true;
                java.awt.Toolkit.getDefaultToolkit().beep();
            }

            if (error) {
                txtCampo.setText("");
                txtCampo.setText(new String(resultado, 0, j));
            }
        }
    }

    private void evaluaLetrasNumerosEspacios() {
        String str = txtCampo.getText();
        char[] fuente = str.toCharArray();
        char[] resultado = new char[fuente.length];
        int j = 0;
        boolean error = false;

        for (int i = 0; i < fuente.length; i++) {

            if ((fuente[i] >= 'a' && fuente[i] <= 'z') || 
                    (fuente[i] >= 'A' && fuente[i] <= 'Z') ||
                    (fuente[i] >= '0' && fuente[i] <= '9') ||
                     fuente[i] == ' ') {
                resultado[j++] = fuente[i];
            } 
            else{
                error = true;
                java.awt.Toolkit.getDefaultToolkit().beep();
            }

            if (error) {
                txtCampo.setText("");
                txtCampo.setText(new String(resultado, 0, j));
            }
        }
    }
    
    private void evaluaFechaNacimiento(){
        String str = txtCampo.getText();
        char[] fuente = str.toCharArray();
        char[] resultado = new char[fuente.length];
        int j = 0;
        boolean error = false;

        for (int i = 0; i < fuente.length; i++) {

            if ((fuente[i] >= '0' && fuente[i] <= '9') ||
                     fuente[i] == '/') {
                resultado[j++] = fuente[i];
            } 
            else{
                error = true;
                java.awt.Toolkit.getDefaultToolkit().beep();
            }

            if (error) {
                txtCampo.setText("");
                txtCampo.setText(new String(resultado, 0, j));
            }
            
            if(i == 10){
                txtCampo.setText("");
                txtCampo.setText(new String(resultado, 0, 10));
            }
        }
    }
    
    private void evaluaCodigoPostal(){
        String str = txtCampo.getText();
        char[] fuente = str.toCharArray();
        char[] resultado = new char[fuente.length];
        int j = 0;
        boolean error = false;

        if(str.length() > 5){
            txtCampo.setText("");
            txtCampo.setText(str.substring(0, str.length() - 1));
        }
        else{
            for (int i = 0; i < fuente.length; i++) {

                if ((fuente[i] >= '0' && fuente[i] <= '9')) {
                    resultado[j++] = fuente[i];
                } 
                else{
                    error = true;
                    java.awt.Toolkit.getDefaultToolkit().beep();
                }

                if (error) {
                    txtCampo.setText("");
                    txtCampo.setText(new String(resultado, 0, j));
                }
            }
        }
    }
}

//char c;
//        Pattern patron = null;
//        Matcher matcher;
//        switch(codigo){
//            //Solo Letras
//            case 1:               
//                /*patron = Pattern.compile("^[a-zA-Z_áéíóúñ\\s]*$");
//                matcher = patron.matcher(txtCampo.getText());
//                if(!matcher.matches()){
//                    vista.getToolkit().beep();
//                    e.consume();
//                    JOptionPane.showMessageDialog(vista, "Solo debes de ingresar letras", "Error", JOptionPane.ERROR_MESSAGE);
//                }*/     
//                c = e.getKeyChar();
//                if(!Character.isLetter(c)){
//                    JOptionPane.showMessageDialog(vista, "Solo debes de ingresar letras", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//                break;
//                
//            //Solo numeros
//            case 2:
//                /*patron = Pattern.compile("[1-9]*$");
//                matcher = patron.matcher(txtCampo.getText());
//                if(!matcher.matches()){
//                    vista.getToolkit().beep();
//                    e.consume();
//                    JOptionPane.showMessageDialog(vista, "Solo debes de ingresar Numeros", "Error", JOptionPane.ERROR_MESSAGE);
//                }*/
//                c = e.getKeyChar();
//                int code = e.getKeyCode();
//                int code2 = e.getExtendedKeyCode();
//                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER ){
//                    break;
//                }
//                
//                if(!Character.isDigit(c)){
//                    e.consume();
//                    JOptionPane.showMessageDialog(vista, "Solo debes de ingresar numeros", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//                
//                else if(Character.isDigit(c) && txtCampo.getText().length() > 9){
//                    e.consume();
//                }
//                break;
//            //Email
//            case 3:
//                patron = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$");
//                matcher = patron.matcher(txtCampo.getText());
//                if(!matcher.matches()){
//                    vista.getToolkit().beep();
//                    e.consume();
//                    JOptionPane.showMessageDialog(vista, "Debes de ingresar un email", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//                break;
//            
//            //LETRAS Y NUMEROS
//            case 4:
//                
//                c = e.getKeyChar();
//                if(!Character.isLetterOrDigit(c)){
//                    JOptionPane.showMessageDialog(vista, "Solo debes de ingresar numeros y/o letras", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//                
//                if(txtCampo.getText().length() > 9){
//                    e.consume();
//                }
//                break;
//                
//            //Telefono
//            case 5:    
////                if(txtCampo.getText().length() < 10){
////                    patron = Pattern.compile("\\d");
////                }
////                if(txtCampo.getText().length() == 10){
////                    patron = Pattern.compile("\\d{10}");
////                }
////                
////                matcher = patron.matcher(txtCampo.getText());
////                if(!matcher.matches()){
////                    vista.getToolkit().beep();
////                    e.consume();
////                    JOptionPane.showMessageDialog(vista, "Debes de ingresar un teléfono de 10 digitos", "Error", JOptionPane.ERROR_MESSAGE);
////                }
//                
//                c = e.getKeyChar();
//                if(!Character.isDigit(c)){
//                    vista.getToolkit().beep();
//                    JOptionPane.showMessageDialog(vista, "Solo debes de ingresar numeros", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//                
//                if(txtCampo.getText().length() > 9){
//                    vista.getToolkit().beep();
//                    e.consume();
//                }
//                break;
//        }
