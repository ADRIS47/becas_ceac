/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import helpers.Helper;
import index.Index;
import java.awt.Cursor;
import javax.swing.JOptionPane;

/**
 *
 * @author sabagip
 */
public class LoginControlador {
    VistaLogin vista;
    LoginModelo modelo;
    Index principal;
    Helper helper = new Helper();

    public VistaLogin getVista() {
        return vista;
    }

    public void setVista(VistaLogin vista) {
        this.vista = vista;
    }

    public LoginModelo getModelo() {
        return modelo;
    }

    public void setModelo(LoginModelo modelo) {
        this.modelo = modelo;
    }

    public Index getPrincipal() {
        return principal;
    }

    public void setPrincipal(Index principal) {
        this.principal = principal;
    }
    
    public void iniciaLogin(){
        vista = new VistaLogin(this);
        modelo = new LoginModelo(this);
        principal = new Index();
        
        this.setVista(vista);
        this.setModelo(modelo);
        this.setPrincipal(principal);
        vista.setLocationRelativeTo(null);
        helper.cargaImagenLocal(vista.lblImagen, "/imagenes/llavelogin.jpg");
        vista.setVisible(true);
    }
    
    public void iniciarSesion(){
        
        helper.cursorEspera(vista);
        helper.validaRutaInicial();
        char[] charClave = vista.txtClave.getPassword();
        String clave = new String(charClave);
        if(!clave.isEmpty()){
            boolean response = modelo.iniciarSesion(clave);
            helper.cursorNormal(vista);
            if(response){            
                helper.cursorNormal(vista);
                vista.dispose();
                vista = null;
                modelo = null;
                principal.iniciaPantallaPrincipal();

            }
            else{
                helper.cursorNormal(vista);
                JOptionPane.showMessageDialog(vista, "Contraseña incorrecta");
                System.out.println("Contraseña incorrecta");
            }
        }
        else{
            helper.cursorNormal(vista);
            JOptionPane.showMessageDialog(vista, "Debes de ingresar la clave de acceso", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
