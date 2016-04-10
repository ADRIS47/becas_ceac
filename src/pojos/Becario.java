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
public class Becario {
    
    long id;
    String nombre;
    String apPaterno;
    String apMaterno;
    Date fecha_nac;
    int idSexo;
    int idEstadoCivil;
    int trabaja;
    String folio;
    int idPrograma;
    int idEstatus;
    int idTipoEstatus;
    String foto;
    String email;
    int primeroConBeca;
    String nombreConyuge;
    String apPaternoConyuge;
    String apMaternoConyuge;
    String observaciones;
    String actaNacimiento;
    String solicitudBeca;
    String ensayo;
    String boletaInicioBeca;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public int getTrabaja() {
        return trabaja;
    }

    public void setTrabaja(int trabaja) {
        this.trabaja = trabaja;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public int getIdTipoEstatus() {
        return idTipoEstatus;
    }

    public void setIdTipoEstatus(int idTipoEstatus) {
        this.idTipoEstatus = idTipoEstatus;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrimeroConBeca() {
        return primeroConBeca;
    }

    public void setPrimeroConBeca(int primeroConBeca) {
        this.primeroConBeca = primeroConBeca;
    }

    public String getNombreConyuge() {
        return nombreConyuge;
    }

    public void setNombreConyuge(String nombreConyuge) {
        this.nombreConyuge = nombreConyuge;
    }

    public String getApPaternoConyuge() {
        return apPaternoConyuge;
    }

    public void setApPaternoConyuge(String apPaternoConyuge) {
        this.apPaternoConyuge = apPaternoConyuge;
    }

    public String getApMaternoConyuge() {
        return apMaternoConyuge;
    }

    public void setApMaternoConyuge(String apMaternoConyuge) {
        this.apMaternoConyuge = apMaternoConyuge;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getActaNacimiento() {
        return actaNacimiento;
    }

    public void setActaNacimiento(String actaNacimiento) {
        this.actaNacimiento = actaNacimiento;
    }

    public String getSolicitudBeca() {
        return solicitudBeca;
    }

    public void setSolicitudBeca(String solicitudBeca) {
        this.solicitudBeca = solicitudBeca;
    }

    public String getEnsayo() {
        return ensayo;
    }

    public void setEnsayo(String ensayo) {
        this.ensayo = ensayo;
    }

    public String getBoletaInicioBeca() {
        return boletaInicioBeca;
    }

    public void setBoletaInicioBeca(String boletaInicioBeca) {
        this.boletaInicioBeca = boletaInicioBeca;
    }
    
    public final static String COL_ID = "id_becario";
    public final static String COL_NOMBRE = "nombre(s)";
    public final static String COL_APATERNO = "ap_paterno";
    public final static String COL_AMATERNO = "ap_materno";
    public final static String COL_FECHA_NAC = "fecha_nacimiento";
    public final static String COL_SEXO = "sexo";
    public final static String COL_ESTADO_CIVIL = "id_estado_civil";
    public final static String COL_TRABAJA = "trabaja";
    public final static String COL_FOLIO = "folio";
    public final static String COL_PROGRAMA = "id_programa";
    public final static String COL_ESTATUS = "id_estatus";
    public final static String COL_TIPO_ESTATUS = "id_tipo_estatus";
    public final static String COL_FOTO = "foto";
    public final static String COL_EMAIL = "email";
    public final static String COL_PRIMERO_CON_BECA = "primero_con_beca";
    public final static String COL_NOMBRE_CONYUGE = "nombre_conyuge";
    public final static String COL_APATERNO_CONYUGE = "ap_paterno_conyuge";
    public final static String COL_AMATERNO_CONYUGE = "ap_materno_conyuge";
    public final static String COL_TELEFONO_CONYUGE = "telefono_conyuge";
    public final static String COL_OBSERVACIONES = "observaciones";
    public final static String COL_ACTA_NAC = "acta_nacimiento";
    public final static String COL_SOLICITUD_BECA = "solicitud_beca";
    public final static String COL_ENSAYO = "ensayo";
    public final static String COL_BOLETA_INICIO_BECA = "boleta_inicio_beca";
}
