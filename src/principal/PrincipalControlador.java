/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.BorderLayout;

/**
 *
 * @author sabagip
 */
public class PrincipalControlador {
    
    VistaPanelPrincipal vista;
    VistaRegistro vistaRegistro;
    PrincipalModelo modelo;

    public void setVista(VistaPanelPrincipal vista) {
        this.vista = vista;
    }

    public void setModelo(PrincipalModelo modelo) {
        this.modelo = modelo;
    }
    
    public void iniciaPantallaPrincipal(){
        vista = new VistaPanelPrincipal(this);
        modelo = new PrincipalModelo();
        
        this.setVista(vista);
        this.setModelo(modelo);
        
        vista.setVisible(true);
    }
    
    public void creaVistaRegistro(){
        vistaRegistro = new VistaRegistro(this);
        vista.pnlOpciones.add(vistaRegistro, BorderLayout.CENTER);
        vistaRegistro.setVisible(true);
        vista.pnlOpciones.updateUI();
        vista.pnlOpciones.validate();
        vista.repaint();
        
        
    }
    
}
