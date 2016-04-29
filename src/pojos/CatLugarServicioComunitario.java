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
public class CatLugarServicioComunitario {
    
    int id;
    String nombre;
    String descripcion;

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
    
    public static final String COL_ID = "id_lugar_servicio_comunitario";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_DESCRIPCION = "descripcion";
}
