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
public class CatUniversidad {
    
    int id;
    String nombre;
    String descripcion;
    int id_tipo_escuela;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_tipo_escuela() {
        return id_tipo_escuela;
    }

    public void setId_tipo_escuela(int id_tipo_escuela) {
        this.id_tipo_escuela = id_tipo_escuela;
    }
    
    public final static String COL_ID = "id_universidad";
    public final static String COL_NOMBRE = "nombre";
    public final static String COL_DESCRIPCION = "descripcion";
    public final static String COL_ID_TIPO_ESCUELA = "id_tipo_escuela";
    
}
