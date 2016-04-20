/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author sabagip
 */
public class Referencia {
    
    long id;
    String apPaterno;
    String apMaterno;
    String nombre;
    String ocupacion;
    long idBecario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public long getIdBecario() {
        return idBecario;
    }

    public void setIdBecario(long idBecario) {
        this.idBecario = idBecario;
    }
    
    public final static String COL_ID = "id_referencia";
    public final static String COL_APATERNO = "ap_paterno";
    public final static String COL_AMATERNO = "ap_materno";
    public final static String COL_NOMBRE = "nombre";
    public final static String COL_OCUPACION = "ocupacion";
    public final static String COL_ID_BECARIO = "id_becario";
    
}
