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
public class CatPrograma {
    
    int id;
    String nombre;
    String descripcion; 
    long contador;
    String iniciales;

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

    public long getContador() {
        return contador;
    }

    public void setContador(long contador) {
        this.contador = contador;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }
    
    
    
    public static String COL_ID = "id_programa";
    public static String COL_NOMBRE = "nombre";
    public static String COL_DESCRIPCION = "descripcion";
    public static String COL_CONTADOR = "contador";
    public static String COL_INICIALES = "iniciales";
    
}
