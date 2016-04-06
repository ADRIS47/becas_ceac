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
    
}
