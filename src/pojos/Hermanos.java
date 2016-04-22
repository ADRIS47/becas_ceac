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
public class Hermanos {
    
    long id;
    String nombre;
    String APaterno;
    String AMaterno;
    int gradoEscolar;
    long idBecario;
    String comentario;

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

    public int getGradoEscolar() {
        return gradoEscolar;
    }

    public void setGradoEscolar(int gradoEscolar) {
        this.gradoEscolar = gradoEscolar;
    }

    public long getIdBecario() {
        return idBecario;
    }

    public void setIdBecario(long idBecario) {
        this.idBecario = idBecario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public static final String COL_ID = "id_hermano";
    public static final String COL_NOMBRE = "nombre";
    public static final String COL_APATERNO = "ap_paterno";
    public static final String COL_AMATERNO = "ap_materno";
    public static final String COL_ID_GRADO_ESCOLAR = "id_grado_escolar";
    public static final String COL_ID_BECARIO = "id_becario";
    public static final String COL_COMENTARIOS = "comentario";
    
}
