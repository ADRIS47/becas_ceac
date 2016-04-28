/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sabagip
 */
public class EscuchadorCmbBoxCambiado implements ItemListener{
    
    //Variables para el calculo de la fecha de graduacion y la beca semestral
    JComboBox<?> cmbBoxMesInicioBeca;
    JComboBox<?> cmbBoxAnioInicioBeca;
    JComboBox<?> cmbBoxMesGraduacion;
    JComboBox<?> cmbBoxAnioGraduacion;
    JComboBox<?> cmbBoxSemestreInicioBeca;
    JComboBox<?> cmbBoxTotalSemestres;
    JTextField txtBecaAutorizada; 
    JTextField txtBecaSemestral;
    JTextField txtCostoCarrera;
    JPanel panel;
    
    
    //Variables para el calculo del descuento acumulado
    JCheckBox chkPlatica1; 
    JCheckBox chkPlatica2; 
    JTextField txtPromedio; 
    JTextField txtDescuento;
    
    int codigo;
    
    public final static int FECHA_GRADUACION = 1;
    public final static int BECA_SEMESTRAL = 2;
    public final static int DESCUENTO_BECA = 3;
    
    /**
     * Se utiliza cuando se va a calcular la fecha de graduacion y la beca semestral
     * @param cmbBoxMesInicioBeca
     * @param cmbBoxAnioInicioBeca
     * @param cmbBoxMesGraduacion
     * @param cmbBoxAnioGraduacion
     * @param cmbBoxSemestreInicioBeca
     * @param cmbBoxTotalSemestres
     * @param txtBecaAutorizada
     * @param txtBecaPorSemestre
     * @param txtCostoCarrera
     * @param panel
     * @param codigo 
     */
    public EscuchadorCmbBoxCambiado(JComboBox<?> cmbBoxMesInicioBeca, 
            JComboBox<?> cmbBoxAnioInicioBeca, JComboBox<?> cmbBoxMesGraduacion, 
            JComboBox<?> cmbBoxAnioGraduacion, JComboBox<?> cmbBoxSemestreInicioBeca, 
            JComboBox<?> cmbBoxTotalSemestres, JTextField txtBecaAutorizada,
            JTextField txtBecaPorSemestre, JTextField txtCostoCarrera, JPanel panel, int codigo) {
        this.cmbBoxMesInicioBeca = cmbBoxMesInicioBeca;
        this.cmbBoxAnioInicioBeca = cmbBoxAnioInicioBeca;
        this.cmbBoxMesGraduacion = cmbBoxMesGraduacion;
        this.cmbBoxAnioGraduacion = cmbBoxAnioGraduacion;
        this.cmbBoxSemestreInicioBeca = cmbBoxSemestreInicioBeca;
        this.cmbBoxTotalSemestres = cmbBoxTotalSemestres;
        this.txtBecaAutorizada = txtBecaAutorizada;
        this.txtBecaSemestral = txtBecaPorSemestre;
        this.txtCostoCarrera = txtCostoCarrera;
        this.panel = panel;
        this.codigo = codigo;
    }

    /**
     * Se utiliza cuando se va a calcular el descuento del kardex
     * @param chkPlatica1
     * @param chkPlatica2
     * @param txtPromedio
     * @param txtDescuento
     * @param codigo
     */
    public EscuchadorCmbBoxCambiado(JCheckBox chkPlatica1, JCheckBox chkPlatica2, 
            JTextField txtPromedio, JTextField txtDescuento, int codigo) {
        this.chkPlatica1 = chkPlatica1;
        this.chkPlatica2 = chkPlatica2;
        this.txtPromedio = txtPromedio;
        this.txtDescuento = txtDescuento;
        this.codigo = codigo;
    }
    
    
    
    
    

    /**
     * Se utiliza cuando se va a agregar el escuchador de calcular beca semestral
     * @param cmbSemestresTotales
     * @param cmbBoxSemestreInicioBeca
     * @param cmbBoxAnioInicioBeca
     * @param txtBecaAutorizada
     * @param txtBecaSemestral
     * @param codigo 
     */
//    public EscuchadorCmbBoxCambiado(JComboBox<?> cmbSemestresTotales, JComboBox<?> cmbBoxSemestreInicioBeca, 
//            JComboBox<?> cmbBoxAnioInicioBeca, JTextField txtBecaAutorizada, 
//            JTextField txtBecaSemestral, int codigo) {
//        this.cmbBoxTotalSemestres = cmbSemestresTotales;
//        this.cmbBoxSemestreInicioBeca = cmbBoxSemestreInicioBeca;
//        this.cmbBoxAnioInicioBeca = cmbBoxAnioInicioBeca;
//        this.txtBecaAutorizada = txtBecaAutorizada;
//        this.txtBecaSemestral = txtBecaSemestral;
//        this.codigo = codigo;
//    }
//    
    

    
    
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        switch(codigo){
            case EscuchadorCmbBoxCambiado.FECHA_GRADUACION:
                Helper.getFechaGraduacion(cmbBoxMesInicioBeca, cmbBoxAnioInicioBeca, 
                                            cmbBoxMesGraduacion, cmbBoxAnioGraduacion,
                                            cmbBoxSemestreInicioBeca, cmbBoxTotalSemestres);
                break;
            case EscuchadorCmbBoxCambiado.BECA_SEMESTRAL:
                Helper.getBecaSemestral(cmbBoxTotalSemestres, cmbBoxSemestreInicioBeca,
                        cmbBoxAnioInicioBeca, txtBecaAutorizada, txtBecaSemestral, txtCostoCarrera);
                break;
                
            case EscuchadorCmbBoxCambiado.DESCUENTO_BECA:
                Helper.getDescuentoSemestral(chkPlatica1, chkPlatica2, txtPromedio, txtDescuento);
                break;
        }
        
        
    }
    
}
