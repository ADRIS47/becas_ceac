/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

import login.LoginControlador;
import principal.PrincipalControlador;

/**
 *
 * @author sabagip
 */
public class Index {
    
    public static void main(String[] args) {
        LoginControlador controlador = new LoginControlador();
        controlador.iniciaLogin();
    }

    public void iniciaPantallaLogin() {
        LoginControlador controlador = new LoginControlador();
        controlador.iniciaLogin();
    }

    public void iniciaPantallaPrincipal() {
        PrincipalControlador controlador = new PrincipalControlador();
        controlador.iniciaPantallaPrincipal();
    }
    
    
    //public static String RUTA_BASE = System.getProperty("user.home");
    /**
     * Indica la ruta del servidor donde se alojan los archivos
     */
    public static String RUTA_BASE = "";
    /**
     * Indica la ruta general del sistema, abarca desde la ruta base hasta SIBEC/BECARIOS/
     */
    public static String RUTA_SISTEMA = "";
    /**
     * Indica el separador de archivos del sistema operativo
     */
    public static String SEPARADOR = "";
    
    /**
     * Indica la ruta final donde se alojará el sistema
     */
    public static String RUTA_FINAL = "";
}
