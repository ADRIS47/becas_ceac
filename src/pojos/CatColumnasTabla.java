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
    String nombreColumnaTipoEscuela;

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

    public String getNombreColumnaTipoEscuela() {
        return nombreColumnaTipoEscuela;
    }

    public void setNombreColumnaTipoEscuela(String nombreColumnaTipoEscuela) {
        this.nombreColumnaTipoEscuela = nombreColumnaTipoEscuela;
    }
    
    
    
    public static final String COL_FIELD = "field";
    
}
