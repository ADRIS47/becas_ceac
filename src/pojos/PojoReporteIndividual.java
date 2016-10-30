/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.sql.Date;

/**
 *
 * @author sabagip
 */
public class PojoReporteIndividual {
    
    long idBecario;
    String folio;
    String aPaterno;
    String aMaterno;
    String nombre;
    String programa;
    String estatus;
    String escuela;
    String carrera;
    String campo;
    String email;
    Date fechaIngreso;
    int semestreIngreso;
    Date fechaGraduacion;
    float becaTotal;
    float becaSemestral;
    float saldoAcumulado;
    int servicioAcumulado;
    int descuentoAcumulado;
    double ajusteBecaTotal;

    public long getIdBecario() {
        return idBecario;
    }

    public void setIdBecario(long idBecario) {
        this.idBecario = idBecario;
    }
    
    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getSemestreIngreso() {
        return semestreIngreso;
    }

    public void setSemestreIngreso(int semestreIngreso) {
        this.semestreIngreso = semestreIngreso;
    }

    public Date getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(Date fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public float getBecaTotal() {
        return becaTotal;
    }

    public void setBecaTotal(float becaTotal) {
        this.becaTotal = becaTotal;
    }

    public float getBecaSemestral() {
        return becaSemestral;
    }

    public void setBecaSemestral(float becaSemestral) {
        this.becaSemestral = becaSemestral;
    }

    public float getSaldoAcumulado() {
        return saldoAcumulado;
    }

    public void setSaldoAcumulado(float saldoAcumulado) {
        this.saldoAcumulado = saldoAcumulado;
    }

    public int getServicioAcumulado() {
        return servicioAcumulado;
    }

    public void setServicioAcumulado(int servicioAcumulado) {
        this.servicioAcumulado = servicioAcumulado;
    }

    public int getDescuentoAcumulado() {
        return descuentoAcumulado;
    }

    public void setDescuentoAcumulado(int descuentoAcumulado) {
        this.descuentoAcumulado = descuentoAcumulado;
    }
    
    public double getAjusteBecaTotal() {
        return ajusteBecaTotal;
    }

    public void setAjusteBecaTotal(double ajusteBecaTotal) {
        this.ajusteBecaTotal = ajusteBecaTotal;
    }
}
