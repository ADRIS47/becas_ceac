/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import pojos.Aval;
import pojos.Becario;
import pojos.DatosEscolares;
import pojos.Direccion;
import pojos.Hermanos;
import pojos.Hijos;
import pojos.Padres;
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
    public static String getCatSexo = "SELECT id_genero, nombre FROM beca_cat_sexo";
    
    /**
     * Obtiene la categoria de estados civiles
     */
    public static String getCatEstadoCivil = "SELECT id_estado_civil, nombre FROM beca_cat_estado_civil";
    
    /**
     * Obtiene la categoria de los programas
     */
    public static String getCatProgramas = "SELECT id_programa, nombre FROM beca_cat_programa";
    
    /**
     * Obtiene el catalogo de nivel de estudios
     */
    public static String getCatNIvelEstudios = "SELECT id_grado_escolar, nombre FROM beca_cat_grado_escolar";
    
    /**
     * Obtiene el parentezco de los becarios
     */
    public static String getCatParentesco = "SELECT id_parentesco, nombre FROM beca_cat_parentesco";
    
    /**
     * Obtiene el catalogo de universidades
     */
    public static String getCatUniversidades = "SELECT id_universidad, nombre FROM beca_cat_universidad ORDER BY nombre";
    
    /**
     * Obtiene el catalogo de campo de estudio
     */
    public static String getCatCampoEstudio = "SELECT id_campo_carrera, nombre, descripcion FROM beca_cat_campo ORDER BY nombre";
    
    /**
     * Obtiene el catalogo de estatus
     */
    public static String getCatEstatus = "SELECT id_estatus, nombre, descripcion FROM beca_cat_estatus";
    
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
    public static String getDireccionesBecario = "SELECT "
            + "COUNT(*), " + Direccion.COL_ID + ", " + Direccion.COL_CALLE + ", "
            + Direccion.COL_NUM_EXT + ", " + Direccion.COL_NUM_INT + ", " 
            + Direccion.COL_CODIGO_POSTAL + ", " + Direccion.COL_COLONIA + ", " 
            + Direccion.COL_CIUDAD + " "
            + " FROM beca_direccion "
            + "WHERE " + Direccion.COL_ID_BECARIO + " = ?" ;
    
    /**
     * Obtiene las direcciones que tiene registradas un becario
     */
    public static String getDatosDireccionesBecario = "SELECT "
            + Direccion.COL_ID + ", " + Direccion.COL_CALLE + ", "
            + Direccion.COL_NUM_EXT + ", " + Direccion.COL_NUM_INT + ", " 
            + Direccion.COL_CODIGO_POSTAL + ", " + Direccion.COL_COLONIA + ", " 
            + Direccion.COL_CIUDAD + " "
            + " FROM beca_direccion "
            + "WHERE " + Direccion.COL_ID_BECARIO + " = ?" ;
    
    /**
     * Obtiene los telefonos que tiene registrado un becario
     */
    public static String getTelefonosBecario = "SELECT COUNT(*), " 
            + Telefono.COL_ID + ", " + Telefono.COL_TELEFONO + " "
            + "FROM beca_telefono "
            + "WHERE " + Telefono.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los telefonos que tiene registrado un becario
     */
    public static String getDatosTelefonosBecario = "SELECT " 
            + Telefono.COL_ID + ", " + Telefono.COL_TELEFONO + " "
            + "FROM beca_telefono "
            + "WHERE " + Telefono.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los papás que tiene registrados un becario
     */
    public static String getPapasBecario = "SELECT COUNT(*), " 
            + Padres.COL_ID + ", " + Padres.COL_NOMBRE + ", "
            + Padres.COL_APATERNO + ", " + Padres.COL_AMATERNO + ","
            + Padres.COL_ID_BECARIO + ", " + Padres.COL_ID_GRADO_ESCOLAR + ","
            + Padres.COL_ID_PARENTESCO + ", " + Padres.COL_TELEFONO + ","
            + Padres.COL_TRABAJA + ", " + Padres.COL_OCUPACION + " "
            + "FROM beca_padres "
            + "WHERE " + Padres.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los papás que tiene registrados un becario
     */
    public static String getDatosPapasBecario = "SELECT " 
            + Padres.COL_ID + ", " + Padres.COL_NOMBRE + ", "
            + Padres.COL_APATERNO + ", " + Padres.COL_AMATERNO + ","
            + Padres.COL_ID_BECARIO + ", " + Padres.COL_ID_GRADO_ESCOLAR + ","
            + Padres.COL_ID_PARENTESCO + ", " + Padres.COL_TELEFONO + ","
            + Padres.COL_TRABAJA + ", " + Padres.COL_OCUPACION + " "
            + "FROM beca_padres "
            + "WHERE " + Padres.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los hermanos que tiene registrado un becario
     */
    public static String getHermanosBecario = "SELECT COUNT(*), " 
            + Hermanos.COL_ID + ", " + Hermanos.COL_NOMBRE + ", "
            + Hermanos.COL_APATERNO + ", " + Hermanos.COL_AMATERNO + ", "
            + Hermanos.COL_ID_GRADO_ESCOLAR + " "
            + "FROM beca_hermano "
            + "WHERE " + Hermanos.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los hermanos que tiene registrado un becario
     */
    public static String getDatosHermanosBecario = "SELECT " 
            + Hermanos.COL_ID + ", " + Hermanos.COL_NOMBRE + ", "
            + Hermanos.COL_APATERNO + ", " + Hermanos.COL_AMATERNO + ", "
            + Hermanos.COL_ID_GRADO_ESCOLAR + ", " + Hermanos.COL_COMENTARIOS + " "
            + "FROM beca_hermano "
            + "WHERE " + Hermanos.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los hijos que tiene registrado un becario
     */
    public static String getHijosBecario = "SELECT COUNT(*), " 
            + Hijos.COL_ID + ", " + Hijos.COL_NOMBRE + ", "
            + Hijos.COL_APATERNO + ", " + Hijos.COL_AMATERNO + ", "
            + Hijos.COL_FECHA_NAC + ", " + Hijos.COL_ID_BECARIO + " "
            + "FROM beca_hijo "
            + "WHERE " + Hijos.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los hijos que tiene registrado un becario
     */
    public static String getDatosHijosBecario = "SELECT " 
            + Hijos.COL_ID + ", " + Hijos.COL_NOMBRE + ", "
            + Hijos.COL_APATERNO + ", " + Hijos.COL_AMATERNO + ", "
            + Hijos.COL_FECHA_NAC + ", " + Hijos.COL_ID_BECARIO + " "
            + "FROM beca_hijo "
            + "WHERE " + Hijos.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los datos escolares que tiene registrado un becario
     */
    public static String getDatosEscolaresBecario = "SELECT COUNT(*), " 
            + DatosEscolares.COL_ID + ", " + DatosEscolares.COL_ESCUELA_PROCEDENCIA + ", "
            + DatosEscolares.COL_ID_UNIVERSIDAD + ", " + DatosEscolares.COL_ID_CAMPO_CARRERA + ", "
            + DatosEscolares.COL_NOMBRE_CARRERA + ", " + DatosEscolares.COL_MES_INICIO_BECA + ", "
            + DatosEscolares.COL_ANIO_INICIO_BECA + ", " + DatosEscolares.COL_MES_GRADUACION + ", "
            + DatosEscolares.COL_ANIO_GRADUACION + ", " + DatosEscolares.COL_SEMESTRES_TOTALES_BECA + ", "
            + DatosEscolares.COL_SEMESTRE_INICIO_BECA + ", " + DatosEscolares.COL_COSTO_CARRERA + ", "
            + DatosEscolares.COL_BECA_TOTAL + ", " + DatosEscolares.COL_BECA_SEMESTRAL + ", "
            + DatosEscolares.COL_CONDICIONADO + ", " + DatosEscolares.COL_ID_BECARIO + " " 
            + "FROM beca_datos_escolares "
            + "WHERE " + DatosEscolares.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene los datos escolares que tiene registrado un becario
     */
    public static String getDatosDatosEscolaresBecario = "SELECT " 
            + DatosEscolares.COL_ID + ", " + DatosEscolares.COL_ESCUELA_PROCEDENCIA + ", "
            + DatosEscolares.COL_ID_UNIVERSIDAD + ", " + DatosEscolares.COL_ID_CAMPO_CARRERA + ", "
            + DatosEscolares.COL_NOMBRE_CARRERA + ", " + DatosEscolares.COL_MES_INICIO_BECA + ", "
            + DatosEscolares.COL_ANIO_INICIO_BECA + ", " + DatosEscolares.COL_MES_GRADUACION + ", "
            + DatosEscolares.COL_ANIO_GRADUACION + ", " + DatosEscolares.COL_SEMESTRES_TOTALES_BECA + ", "
            + DatosEscolares.COL_SEMESTRE_INICIO_BECA + ", " + DatosEscolares.COL_COSTO_CARRERA + ", "
            + DatosEscolares.COL_BECA_TOTAL + ", " + DatosEscolares.COL_BECA_SEMESTRAL + ", "
            + DatosEscolares.COL_CONDICIONADO + ", " + DatosEscolares.COL_ID_BECARIO + " " 
            + "FROM beca_datos_escolares "
            + "WHERE " + DatosEscolares.COL_ID_BECARIO + " = ?";
    
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
            + "becario." + Becario.COL_IDENTIFICACION + ", becario." + Becario.COL_ID + ", "
            + "becario." + Becario.COL_PAGARE + ", becario." + Becario.COL_OCUPACION_CONYUGE + " "
            + "FROM beca_becario AS becario "
            + "WHERE becario." + Becario.COL_FOLIO + " = ?";
    
    /**
     * Obtiene los datos de un becario por número de folio
     */
    public static String getBecarioPorProgramaEstatus = "SELECT "
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
            + "becario." + Becario.COL_IDENTIFICACION + ", becario." + Becario.COL_ID + ", "
            + "becario." + Becario.COL_PAGARE + ", becario." + Becario.COL_OCUPACION_CONYUGE + " "
//            + "uni." + CatUniversidad.COL_NOMBRE  + ", esc." + DatosEscolares.COL_BECA_TOTAL + ", "
//            + "esc." + DatosEscolares.COL_BECA_SEMESTRAL + ", esc." + DatosEscolares.COL_MES_INICIO_BECA + ", "
//            + "esc." + DatosEscolares.COL_ANIO_INICIO_BECA + ", esc." + DatosEscolares.COL_MES_GRADUACION + ", "
//            + "esc." + DatosEscolares.COL_ANIO_GRADUACION + " "
            + "FROM beca_becario AS becario "
            + "WHERE becario." + Becario.COL_PROGRAMA + " = ? AND " + Becario.COL_ESTATUS + " = ?";
    
    /**
     * Obtiene a los becarios a partir de su nombre y apellido
     */
    public static String getBecarioPorNombres = "SELECT "
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
            + "becario." + Becario.COL_IDENTIFICACION + ", becario." + Becario.COL_ID + ", "
            + "becario." + Becario.COL_PAGARE + ", becario." + Becario.COL_OCUPACION_CONYUGE + " "
            + "FROM beca_becario AS becario ";
//            + "WHERE becario." + Becario.COL_NOMBRE + " LIKE ? OR becario." + Becario.COL_APATERNO + " LIKE ? "
//            + "OR becario." + Becario.COL_AMATERNO + " LIKE ? "
//            + "ORDER BY " + Becario.COL_APATERNO + " AND " + Becario.COL_AMATERNO + " AND " + Becario.COL_NOMBRE;
    
    /**
     * Obtiene el aval del becario
     */
    public static String getDatosAvalBecario = "SELECT " 
            + Aval.COL_ID + ", " + Aval.COL_APATERNO + ", "
            + Aval.COL_AMATERNO + ", " + Aval.COL_NOMBRE + ", "
            + Aval.COL_CALLE + ", " + Aval.COL_NUM_EXT + ", "
            + Aval.COL_NUM_INT + ", " + Aval.COL_COLONIA + ", "
            + Aval.COL_ID_BECARIO + ", " + Aval.COL_IDENTIFICACION + " " 
            + "FROM beca_aval "
            + "WHERE " + Aval.COL_ID_BECARIO + " = ?";
    
    
}
