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
    String telefonoConyuge;
    String ocupacionConyuge;
    String observaciones;
    String actaNacimiento;
    String solicitudBeca;
    String ensayo;
    String boletaInicioBeca;
    String inicialesFolio;
    String contatoBeca;
    String identificacion;
    String pagare;
    boolean pendiente;
    String estudioSocioEconomico;
    String cartaAsignacionBeca;
    String cartaAgradecimiento;
    String cuentaBancaria;
    int idBanco;
    String clabeInterbancaria;
    int activo;

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

    public String getTelefonoConyuge() {
        return telefonoConyuge;
    }

    public void setTelefonoConyuge(String telefonoConyuge) {
        this.telefonoConyuge = telefonoConyuge;
    }

    public String getOcupacionConyuge() {
        return ocupacionConyuge;
    }

    public void setOcupacionConyuge(String ocupacionConyuge) {
        this.ocupacionConyuge = ocupacionConyuge;
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

    public String getInicialesFolio() {
        return inicialesFolio;
    }

    public void setInicialesFolio(String inicialesFolio) {
        this.inicialesFolio = inicialesFolio;
    }

    public boolean isPendiente() {
        return pendiente;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }

    public String getContatoBeca() {
        return contatoBeca;
    }

    public void setContatoBeca(String contatoBeca) {
        this.contatoBeca = contatoBeca;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPagare() {
        return pagare;
    }

    public void setPagare(String pagare) {
        this.pagare = pagare;
    }

    public String getEstudioSocioEconomico() {
        return estudioSocioEconomico;
    }

    public void setEstudioSocioEconomico(String estudioSocioEconomico) {
        this.estudioSocioEconomico = estudioSocioEconomico;
    }

    public String getCartaAsignacionBeca() {
        return cartaAsignacionBeca;
    }

    public void setCartaAsignacionBeca(String cartaAsignacionBeca) {
        this.cartaAsignacionBeca = cartaAsignacionBeca;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public String getClabeInterbancaria() {
        return clabeInterbancaria;
    }

    public void setClabeInterbancaria(String clabeInterbancaria) {
        this.clabeInterbancaria = clabeInterbancaria;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getCartaAgradecimiento() {
        return cartaAgradecimiento;
    }

    public void setCartaAgradecimiento(String cartaAgradecimiento) {
        this.cartaAgradecimiento = cartaAgradecimiento;
    }   
    
    public final static String COL_ID = "id_becario";
    public final static String COL_NOMBRE = "nombre";
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
    public final static String COL_OCUPACION_CONYUGE = "ocupacion_conyuge";
    public final static String COL_OBSERVACIONES = "observaciones";
    public final static String COL_ACTA_NAC = "acta_nacimiento";
    public final static String COL_SOLICITUD_BECA = "solicitud_beca";
    public final static String COL_ENSAYO = "ensayo";
    public final static String COL_BOLETA_INICIO_BECA = "boleta_inicio_beca";
    public final static String COL_CONTRATO_BECA = "contrato_beca";
    public final static String COL_IDENTIFICACION = "identificacion";
    public final static String COL_PAGARE = "pagare";
    public final static String COL_PENDIENTE = "pendiente";
    public final static String COL_ESTUDIO_SOCIOECONOMICO = "estudio_socioeconomico";
    public final static String COL_CARTA_ASIGNACION_BECA = "carta_asignacion_beca";
    public final static String COL_CARTA_AGRADECIMIENTO = "carta_agradecimiento";
    public final static String COL_CUENTA_BANCO = "cuenta_bancaria";
    public final static String COL_ID_BANCO = "id_banco";
    public final static String COL_CLABE_INTERBANCARIA = "clabe_interbancaria";
    public final static String COL_ACTIVO = "activo";
}
