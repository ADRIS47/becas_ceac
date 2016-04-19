/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import pojos.Becario;

/**
 *
 * @author JoelSaldana
 */
public class Consultas {
    
    /**
     * Obtiene la clave de acceso del usuario
     */
    public static String getClave = "SELECT id_usuario FROM beca_usuarios WHERE clave_acceso = ?";
    
    /**
     * Obtiene la categoria de sexos
     */
    public static String getSexo = "SELECT id_genero, nombre FROM beca_cat_sexo";
    
    /**
     * Obtiene la categoria de estados civiles
     */
    public static String getEstadoCivil = "SELECT id_estado_civil, nombre FROM beca_cat_estado_civil";
    
    /**
     * Obtiene la categoria de los programas
     */
    public static String getProgramas = "SELECT id_programa, nombre FROM beca_cat_programa";
    
    /**
     * Obtiene el catalogo de nivel de estudios
     */
    public static String getNIvelEstudios = "SELECT id_grado_escolar, nombre FROM beca_cat_grado_escolar";
    
    /**
     * Obtiene el parentezco de los becarios
     */
    public static String getParentesco = "SELECT id_parentesco, nombre FROM beca_cat_parentesco";
    
    /**
     * Obtiene el catalogo de universidades
     */
    public static String getUniversidades = "SELECT id_universidad, nombre FROM beca_cat_universidad ORDER BY nombre";
    
    /**
     * Obtiene el catalogo de campo de estudio
     */
    public static String getCampoEstudio = "SELECT id_campo_carrera, nombre, descripcion FROM beca_cat_campo ORDER BY nombre";
    
    /**
     * Obtiene las iniciales del programa seleccionado
     */
    public static String getInicialesPrograma = "SELECT iniciales FROM beca_cat_programa WHERE id_programa = ?";
    
    /**
     * Obtiene el contador de los programas
     */
    public static String getContadorFolio = "SELECT contador FROM beca_cat_programa WHERE id_programa = ?";
    
    /**
     * Obtiene el id de un becario a partir de su folio
     */
    public static String getIdBecarioPorFolio = "SELECT " + Becario.COL_ID + "FROM beca_becario WHERE " + Becario.COL_FOLIO + " = ?";
    
    
}
