/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adris.vistas;

/**
 *
 * @author sabagip
 */
public class PnlPortada extends javax.swing.JPanel {
    
    PrincipalControlador controlador;

    public void setControlador(PrincipalControlador controlador) {
        this.controlador = controlador;
    }
    
    

    /**
     * Creates new form PnlPortada
     */
    public PnlPortada(PrincipalControlador controlador) {
        initComponents();
        this.setControlador(controlador);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPortada = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(916, 584));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 160));

        lblPortada.setMaximumSize(new java.awt.Dimension(300, 225));
        lblPortada.setPreferredSize(new java.awt.Dimension(481, 304));
        add(lblPortada);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel lblPortada;
    // End of variables declaration//GEN-END:variables
}
