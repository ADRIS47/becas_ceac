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
public class CatColumnasTabla {
    
    String nombreColumnaId;
    String nombreColumnaNombre;
    int tipoEscuela;

    public String getNombreColumnaId() {
        return nombreColumnaId;
    }

    public void setNombreColumnaId(String field) {
        this.nombreColumnaId = field;
    }

    public int getTipoEscuela() {
        return tipoEscuela;
    }

    public void setTipoEscuela(int tipoEscuela) {
        this.tipoEscuela = tipoEscuela;
    }

    public String getNombreColumnaNombre() {
        return nombreColumnaNombre;
    }

    public void setNombreColumnaNombre(String nombreColumnaNombre) {
        this.nombreColumnaNombre = nombreColumnaNombre;
    }
    
    
    
    public static final String COL_FIELD = "field";
    
}
