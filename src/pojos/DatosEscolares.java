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
public class DatosEscolares {
    
    long id;
    String escuelaProcedencia;
    int idUniversidad;
    int idCampoCarrera;
    String nombreCarrera;
    int mesInicioBeca;
    int anioInicioBeca;
    int mesGraduacion;
    int anioGraduacion;
    float costoCarrera;
    float becaTotal;
    float becaSemestral;
    int condicionado;
    long idBecario;
    int semestresTotalesCarrera;
    int semestreInicioBeca;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEscuelaProcedencia() {
        return escuelaProcedencia;
    }

    public void setEscuelaProcedencia(String escuelaProcedencia) {
        this.escuelaProcedencia = escuelaProcedencia;
    }

    public int getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(int idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public int getIdCampoCarrera() {
        return idCampoCarrera;
    }

    public void setIdCampoCarrera(int idCampoCarrera) {
        this.idCampoCarrera = idCampoCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getSemestreInicioBeca() {
        return mesInicioBeca;
    }

    public void setSemestreInicioBeca(int semestreInicioBeca) {
        this.mesInicioBeca = semestreInicioBeca;
    }

    public int getAnioInicioBeca() {
        return anioInicioBeca;
    }

    public void setAnioInicioBeca(int anioInicioBeca) {
        this.anioInicioBeca = anioInicioBeca;
    }

    public int getMesGraduacion() {
        return mesGraduacion;
    }

    public void setMesGraduacion(int mesGraduacion) {
        this.mesGraduacion = mesGraduacion;
    }

    public int getAnioGraduacion() {
        return anioGraduacion;
    }

    public void setAnioGraduacion(int anioGraduacion) {
        this.anioGraduacion = anioGraduacion;
    }

    public float getCostoCarrera() {
        return costoCarrera;
    }

    public void setCostoCarrera(float costoCarrera) {
        this.costoCarrera = costoCarrera;
    }

    public float getBecaTotal() {
        return becaTotal;
    }

    public void setBecaTotal(float becaTotal) {
        this.becaTotal = becaTotal;
    }

    public float getBecaSemestral() {
        return becaSemestral;
    }

    public void setBecaSemestral(float becaSemestral) {
        this.becaSemestral = becaSemestral;
    }

    public int getCondicionado() {
        return condicionado;
    }

    public void setCondicionado(int condicionado) {
        this.condicionado = condicionado;
    }

    public long getIdBecario() {
        return idBecario;
    }

    public void setIdBecario(long idBecario) {
        this.idBecario = idBecario;
    }

    public int getMesInicioBeca() {
        return mesInicioBeca;
    }

    public void setMesInicioBeca(int mesInicioBeca) {
        this.mesInicioBeca = mesInicioBeca;
    }

    public int getSemestresTotalesCarrera() {
        return semestresTotalesCarrera;
    }

    public void setSemestresTotalesCarrera(int semestresTotalesCarrera) {
        this.semestresTotalesCarrera = semestresTotalesCarrera;
    }
    
    
    
    
    public static final String COL_ID = "id_dato_escolar";
    public static final String COL_ESCUELA_PROCEDENCIA = "escuela_procedencia";
    public static final String COL_ID_UNIVERSIDAD = "id_universidad";
    public static final String COL_ID_CAMPO_CARRERA = "id_campo_carrera";
    public static final String COL_NOMBRE_CARRERA = "nombre_carrera";
    public static final String COL_MES_INICIO_BECA = "mes_inicio_beca";
    public static final String COL_ANIO_INICIO_BECA = "anio_inicio_beca";
    public static final String COL_MES_GRADUACION = "mes_graduacion";
    public static final String COL_ANIO_GRADUACION = "anio_graduacion";
    public static final String COL_COSTO_CARRERA = "costo_carrera";
    public static final String COL_BECA_TOTAL = "beca_total";
    public static final String COL_BECA_SEMESTRAL = "beca_semestral";
    public static final String COL_CONDICIONADO = "condicionado";
    public static final String COL_ID_BECARIO = "id_becario";
    public static final String COL_SEMESTRES_TOTALES_BECA = "semestres_totales_beca";
    public static final String COL_SEMESTRE_INICIO_BECA = "semestre_inicio_beca";
    
    
}
