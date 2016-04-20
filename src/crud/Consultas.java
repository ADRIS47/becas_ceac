/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import pojos.Aval;
import pojos.Becario;
import pojos.CatCampo;
import pojos.CatEstadoCivil;
import pojos.CatEstatus;
import pojos.CatGradoEscolar;
import pojos.CatParentesco;
import pojos.CatPrograma;
import pojos.CatSexo;
import pojos.CatUniversidad;
import pojos.DatosEscolares;
import pojos.Direccion;
import pojos.Hermanos;
import pojos.Hijos;
import pojos.Padres;
import pojos.Referencia;
import pojos.Telefono;

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
    public static String getIdBecarioPorFolio = "SELECT " + Becario.COL_ID + " FROM beca_becario WHERE " + Becario.COL_FOLIO + " = ?";
    
    /**
     * Obtiene las direcciones que tiene registradas un becario
     */
    public static String getDireccionesBecario = "SELECT COUNT(*), " + Direccion.COL_ID + " FROM beca_direccion WHERE " + Direccion.COL_ID_BECARIO + " = ?" ;
    
    /**
     * Obtiene los telefonos que tiene registrado un becario
     */
    public static String getTelefonosBecario = "SELECT COUNT(*), " + Telefono.COL_ID + " FROM beca_telefono WHERE " + Telefono.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los papás que tiene registrados un becario
     */
    public static String getPapasBecario = "SELECT COUNT(*), " + Padres.COL_ID + " FROM beca_padres WHERE " + Padres.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los hermanos que tiene registrado un becario
     */
    public static String getHermanosBecario = "SELECT COUNT(*), " + Hermanos.COL_ID + " FROM beca_hermano WHERE " + Hermanos.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los hijos que tiene registrado un becario
     */
    public static String getHijosBecario = "SELECT COUNT(*), " + Hijos.COL_ID + " FROM beca_hijo WHERE " + Hijos.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los datos escolares que tiene registrado un becario
     */
    public static String getDatosEscolaresBecario = "SELECT COUNT(*), " + DatosEscolares.COL_ID + " FROM beca_datos_escolarews WHERE " + DatosEscolares.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los datos de un becario por número de folio
     */
    public static String getBecarioPorFolio = "SELECT "
            + "becario." + Becario.COL_NOMBRE +  ", becario." + Becario.COL_APATERNO +  ", "
            + "becario." + Becario.COL_AMATERNO +  ", becario." + Becario.COL_FECHA_NAC +  ", "
            + "becario." + Becario.COL_SEXO +  ", becario." + Becario.COL_ESTADO_CIVIL +  ", "
            + "becario." + Becario.COL_TRABAJA +  ", becario." + Becario.COL_FOLIO +  ", "
            + "becario." + Becario.COL_PROGRAMA +  ", becario." + Becario.COL_ESTATUS +  ", "
            + "becario." + Becario.COL_TIPO_ESTATUS +  ", becario." + Becario.COL_FOTO +  ", "
            + "becario." + Becario.COL_EMAIL +  ", becario." + Becario.COL_PRIMERO_CON_BECA +  ", "
            + "becario." + Becario.COL_NOMBRE_CONYUGE +  ", becario." + Becario.COL_APATERNO_CONYUGE +  ", "
            + "becario." + Becario.COL_AMATERNO_CONYUGE +  ", becario." + Becario.COL_TELEFONO_CONYUGE +  ", "
            + "becario." + Becario.COL_OBSERVACIONES +  ", becario." + Becario.COL_ACTA_NAC +  ", "
            + "becario." + Becario.COL_SOLICITUD_BECA +  ", becario." + Becario.COL_ENSAYO +  ", "
            + "becario." + Becario.COL_BOLETA_INICIO_BECA +  ", becario." + Becario.COL_CONTRATO_BECA +  ", "
            + "becario." + Becario.COL_IDENTIFICACION +  ", programa." + CatPrograma.COL_NOMBRE + ", "
            + "estatus." + CatEstatus.COL_NOMBRE + ", edo_civil." + CatEstadoCivil.COL_NOMBRE + ", "
            + "sexo." + CatSexo.COL_NOMBRE + ", hijo." + Hijos.COL_NOMBRE + ", "
            + "hijo." + Hijos.COL_APATERNO + ", " + "hijo." + Hijos.COL_AMATERNO + ", "
            + "hijo." + Hijos.COL_FECHA_NAC + ", referencia." + Referencia.COL_NOMBRE + ", "
            + "referencia. " + Referencia.COL_APATERNO + ", " + "referencia. " + Referencia.COL_AMATERNO + ", "
            + "referencia. " + Referencia.COL_OCUPACION + ", "+ "telefono. " + Telefono.COL_TELEFONO + ", "
            + "aval." + Aval.COL_APATERNO + ", " + "aval." + Aval.COL_AMATERNO + ", " 
            + "aval." + Aval.COL_NOMBRE + ", aval." + Aval.COL_CALLE + ", "
            + "aval." + Aval.COL_NUM_EXT + ", aval." + Aval.COL_NUM_INT + ", "
            + "aval." + Aval.COL_COLONIA + ", aval." + Aval.COL_IDENTIFICACION + ", "
            + "datEscolar." + DatosEscolares.COL_ESCUELA_PROCEDENCIA + ", datEscolar." + DatosEscolares.COL_NOMBRE_CARRERA + ", "
            + "datEscolar." + DatosEscolares.COL_MES_INICIO_BECA + ", datEscolar." + DatosEscolares.COL_ANIO_INICIO_BECA + ", "
            + "datEscolar." + DatosEscolares.COL_MES_GRADUACION + ", datEscolar." + DatosEscolares.COL_ANIO_GRADUACION + ", "
            + "datEscolar." + DatosEscolares.COL_SEMESTRES_TOTALES_BECA + ", datEscolar." + DatosEscolares.COL_SEMESTRE_INICIO_BECA + ", "
            + "datEscolar." + DatosEscolares.COL_COSTO_CARRERA + ", datEscolar." + DatosEscolares.COL_BECA_TOTAL + ", "
            + "datEscolar." + DatosEscolares.COL_BECA_SEMESTRAL + ", datEscolar." + DatosEscolares.COL_CONDICIONADO + ", "
            + "padre." + Padres.COL_NOMBRE + ", padre." + Padres.COL_APATERNO + ", "
            + "padre." + Padres.COL_AMATERNO + ", padre." + Padres.COL_TELEFONO + ", "
            + "padre." + Padres.COL_ID_GRADO_ESCOLAR + ", padre." + Padres.COL_TRABAJA + ", "
            + "padre." + Padres.COL_ID_PARENTESCO + ", parentesco." + CatParentesco.COL_NOMBRE + ", "
            + "grado_escolar." + CatGradoEscolar.COL_NOMBRE + ", hermano." + Hermanos.COL_NOMBRE + ", "
            + "hermano." + Hermanos.COL_APATERNO + ", hermano." + Hermanos.COL_AMATERNO + ", "
            + "hermano." + Hermanos.COL_ID_GRADO_ESCOLAR + " "
            
            + "FROM beca_becario AS becario "
            + "JOIN beca_direccion direccion ON  becario.id_becario = direccion.id_becario "
            + "JOIN beca_cat_programa AS programa ON  becario.id_programa = programa.id_programa "
            + "JOIN beca_cat_estatus AS estatus ON  becario.id_estatus = estatus.id_estatus "
            + "JOIN beca_cat_estado_civil AS edo_civil ON  becario.id_estado_civil = edo_civil.id_estado_civil "
            + "JOIN beca_cat_sexo AS sexo ON  becario.sexo = sexo.id_genero "
            + "JOIN beca_hijo AS hijo ON  becario.id_becario = hijo.id_becario "
            + "JOIN beca_referencia AS referencia ON  becario.id_becario = referencia.id_becario "
            + "JOIN beca_telefono AS telefono ON  becario.id_becario = telefono.id_becario "
            + "JOIN beca_aval AS aval ON  becario.id_becario = aval.id_becario "
            + "JOIN beca_datos_escolares AS datEscolar ON  becario.id_becario = datEscolar.id_becario "
            + "JOIN beca_cat_campo AS campo ON  datEscolar.id_campo_carrera = campo.id_campo_carrera "
            + "JOIN beca_cat_universidad AS universidad ON  becario.id_universidad = universidad.id_universidad "
            + "JOIN beca_padres AS padre ON  becario.id_becario = padre.id_becario "
            + "JOIN beca_cat_parentesco AS parentesco ON  padre.id_parentesco = parentesco.id_parentesco "
            + "JOIN beca_cat_grado_escolar AS grado_escolar ON  parentesco.id_grado_escolar = grado_escolar.id_grado_escolar "
            + "JOIN beca_hermano AS hermano ON  becario.id_becario = hermano.id_becario "
            + "WHERE becario.id_becario = ?";
    
    
}
