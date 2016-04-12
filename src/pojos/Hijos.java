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
public class Hijos {
    
    long id;
    String nombre;
    String APaterno;
    String AMaterno;
    Date fechaNac;
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

    public String getAPaterno() {
        return APaterno;
    }

    public void setAPaterno(String APaterno) {
        this.APaterno = APaterno;
    }

    public String getAMaterno() {
        return AMaterno;
    }

    public void setAMaterno(String AMaterno) {
        this.AMaterno = AMaterno;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public long getIdBecario() {
        return idBecario;
    }

    public void setIdBecario(long idBecario) {
        this.idBecario = idBecario;
    }
    
    public static final String COL_ID = "id_hijo";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_APATERNO = "ap_paterno";
    public static final String COL_AMATERNO = "ap_materno";
    public static final String COL_FECHA_NAC = "fecha_nacimiento";
    public static final String COL_ID_BECARIO = "id_becario";
    
}
