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
public class Aval {
    
    long id;
    String nombre;
    String aPaterno;
    String aMaterno;
    String calle;
    String numExt;
    String numInt;
    String colonia;
    String identificacion;
    long idBecario;

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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumExt() {
        return numExt;
    }

    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    public String getNumInt() {
        return numInt;
    }

    public void setNumInt(String numInt) {
        this.numInt = numInt;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public long getIdBecario() {
        return idBecario;
    }

    public void setIdBecario(long idBecario) {
        this.idBecario = idBecario;
    }
    
    public static final String COL_ID = "id_aval";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_APATERNO = "ap_materno";
    public static final String COL_AMATERNO = "ap_materno";
    public static final String COL_CALLE = "calle";
    public static final String COL_NUM_EXT = "num_exterior";
    public static final String COL_NUM_INT = "num_interior";
    public static final String COL_COLONIA = "colonia";
    public static final String COL_ID_BECARIO = "id_becario";
    public static final String COL_IDENTIFICACION = "identificacion";
    
}
