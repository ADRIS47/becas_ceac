/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author sergio
 */
public class PojoReporteIndividualMuchosDatos {
    
    String semestre;
    boolean pago1;
    boolean pago2;
    float promedio;
    int horasServicio;
    String tipoServicio;
    int descuento;
    double ajusteBecaSemestral;

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public boolean getPago1() {
        return pago1;
    }

    public void setPago1(boolean pago) {
        this.pago1 = pago;
    }

    public boolean getPago2() {
        return pago2;
    }

    public void setPago2(boolean pago2) {
        this.pago2 = pago2;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public int getHorasServicio() {
        return horasServicio;
    }

    public void setHorasServicio(int horasServicio) {
        this.horasServicio = horasServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public double getAjusteBecaSemestral() {
        return ajusteBecaSemestral;
    }

    public void setAjusteBecaSemestral(double ajusteBecaSemestral) {
        this.ajusteBecaSemestral = ajusteBecaSemestral;
    }
    
}
