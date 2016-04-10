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
public class Telefono {
    
    long id;
    String telefono;
    long idBecario;
    long idAval;
    long id_referencia;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public long getIdBecario() {
        return idBecario;
    }

    public void setIdBecario(long idBecario) {
        this.idBecario = idBecario;
    }

    public long getIdAval() {
        return idAval;
    }

    public void setIdAval(long idAval) {
        this.idAval = idAval;
    }

    public long getId_referencia() {
        return id_referencia;
    }

    public void setId_referencia(long id_referencia) {
        this.id_referencia = id_referencia;
    }
    
    public final static String COL_ID = "id_telefono";
    public final static String COL_TELEFONO = "telefono";
    public final static String COL_ID_BECARIO = "id_becario";
    public final static String COL_ID_AVAL = "id_aval";
    public final static String COL_ID_REFERENCIA = "id_referencia";
    
}
