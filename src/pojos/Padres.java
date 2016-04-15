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
public class Padres {
    
    long id;
    String nombre;
    String aPaterno;
    String aMaterno;
    String telefono;
    int gradoEscolar;
    int trabaja;
    long idBecario;
    int parenteco;

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getGradoEscolar() {
        return gradoEscolar;
    }

    public void setGradoEscolar(int gradoEscolar) {
        this.gradoEscolar = gradoEscolar;
    }

    public int getTrabaja() {
        return trabaja;
    }

    public void setTrabaja(int trabaja) {
        this.trabaja = trabaja;
    }

    public long getIdBecario() {
        return idBecario;
    }

    public void setIdBecario(long idBecario) {
        this.idBecario = idBecario;
    }

    public int getParenteco() {
        return parenteco;
    }

    public void setParenteco(int parenteco) {
        this.parenteco = parenteco;
    }
    
    public final static String COL_ID = "id_padre";
    public final static String COL_NOMBRE = "nombre";
    public final static String COL_APATERNO = "ap_paterno";
    public final static String COL_AMATERNO = "ap_materno";
    public final static String COL_TELEFONO = "telefono";
    public final static String COL_ID_GRADO_ESCOLAR = "id_grado_escolar";
    public final static String COL_TRABAJA = "trabaja";
    public final static String COL_ID_BECARIO = "id_becario";
    public final static String COL_ID_PARENTESCO = "id_parentesco";
    
}
