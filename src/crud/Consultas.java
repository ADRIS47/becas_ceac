/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import pojos.Aval;
import pojos.Becario;
import pojos.CatBanco;
import pojos.CatCampo;
import pojos.CatCategorias;
import pojos.CatColumnasTabla;
import pojos.CatEstadoCivil;
import pojos.CatEstatus;
import pojos.CatLugarServicioComunitario;
import pojos.CatMunicipios;
import pojos.CatPrograma;
import pojos.CatReporte;
import pojos.CatSexo;
import pojos.CatTipoEscuela;
import pojos.CatTipoServicioSocial;
import pojos.CatUniversidad;
import pojos.Cobranza;
import pojos.DatosEscolares;
import pojos.Direccion;
import pojos.Hermanos;
import pojos.Hijos;
import pojos.Kardex;
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
     * Obtiene la categorias de bancos
     */
    public static String getCatBancos = "SELECT " + CatBanco.COL_ID + ", " + CatBanco.COL_NOMBRE  + " FROM beca_cat_banco ORDER BY " + CatBanco.COL_NOMBRE;
    
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
     * Obtiene la lista de categorias de tipo escuela
     */
    public static String getCatTipoEscuela = "SELECT " + CatTipoEscuela.COL_ID + ", " + CatTipoEscuela.COL_NOMBRE + " FROM beca_tipo_escuela";
    
    /**
     * Obtiene la lista de las categorias
     */
    public static String getCatCatalogos = "SELECT " + CatCategorias.COL_ID + ", " + CatCategorias.COL_NOMBRE + " FROM beca_cat_catalogos";
    
    /**
     * Obtiene la lista de categorias de tipo de servicio social
     */
    public static String getCatTipoServicioSocial = "SELECT " + CatTipoServicioSocial.COL_ID + ", " 
                    + CatTipoServicioSocial.COL_NOMBRE + " FROM beca_cat_servicio_comunitario "
                    + "ORDER BY " + CatTipoServicioSocial.COL_NOMBRE;
    
    /**
     * Obtiene la lista de categorias de tipo de servicio comunitario
     */
    public static String getCatLugarServicioSocial = "SELECT " + CatLugarServicioComunitario.COL_ID + ", "
            + CatLugarServicioComunitario.COL_NOMBRE + " FROM beca_cat_lugar_servicio_comunitario "
            + "ORDER BY " + CatLugarServicioComunitario.COL_NOMBRE;
    
    /**
     * Obtiene todos los municipios del estado de chihuahua
     */
    public static String getCatMunicipios = "SELECT " + CatMunicipios.COL_ID + ", "
            + CatMunicipios.COL_NOMBRE + " FROM beca_cat_municipio";
    
    /**
     * Genera el query obtener los reportes
     */
    public static String getCatReportes = "SELECT " + CatReporte.COL_ID + ", " + CatReporte.COL_NOMBRE + " FROM beca_cat_reporte";
    
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
            + DatosEscolares.COL_CONDICIONADO + ", " + DatosEscolares.COL_ID_BECARIO + ", "
            + DatosEscolares.COL_ID_TIPO_ESCUELA + " " 
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
            + DatosEscolares.COL_CONDICIONADO + ", " + DatosEscolares.COL_ID_BECARIO + ", "
            + DatosEscolares.COL_ID_TIPO_ESCUELA + " " 
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
            + "becario." + Becario.COL_PAGARE + ", becario." + Becario.COL_OCUPACION_CONYUGE + ", "
            + "becario." + Becario.COL_ID_BANCO + ", becario." + Becario.COL_CUENTA_BANCO + ", "
            + "becario." + Becario.COL_CLABE_INTERBANCARIA + ", becario." + Becario.COL_ACTIVO + ", "
            + "becario." + Becario.COL_CARTA_ASIGNACION_BECA + ", becario." + Becario.COL_ESTUDIO_SOCIOECONOMICO + ", "
            + "becario." + Becario.COL_CARTA_AGRADECIMIENTO + ", becario." + Becario.COL_GRADUADO + " "
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
            + "becario." + Becario.COL_PAGARE + ", becario." + Becario.COL_OCUPACION_CONYUGE + ", "
            + "becario." + Becario.COL_ID_BANCO + ", becario." + Becario.COL_CUENTA_BANCO + ", "
            + "becario." + Becario.COL_CLABE_INTERBANCARIA + ", becario." + Becario.COL_ACTIVO + ", "
            + "becario." + Becario.COL_CARTA_ASIGNACION_BECA + ", becario." + Becario.COL_ESTUDIO_SOCIOECONOMICO + ", "
            + "becario." + Becario.COL_CARTA_AGRADECIMIENTO + ", becario." + Becario.COL_GRADUADO + " "
            + "FROM beca_becario AS becario "
            + "WHERE becario." + Becario.COL_PROGRAMA + " = ? AND " + Becario.COL_ESTATUS + " = ? "
            + "AND becario." + Becario.COL_ACTIVO + " = 1";
    
    /**
     * Obtiene los datos de un becario por número de folio
     */
    public static String getBecariosPorProgramaEstatus = "SELECT "
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
            + "becario." + Becario.COL_PAGARE + ", becario." + Becario.COL_OCUPACION_CONYUGE + ", "
            + "becario." + Becario.COL_ID_BANCO + ", becario." + Becario.COL_CUENTA_BANCO + ", "
            + "becario." + Becario.COL_CLABE_INTERBANCARIA + ", becario." + Becario.COL_ACTIVO + ", "
            + "becario." + Becario.COL_CARTA_ASIGNACION_BECA + ", becario." + Becario.COL_ESTUDIO_SOCIOECONOMICO + ", "
            + "becario." + Becario.COL_CARTA_AGRADECIMIENTO + ", becario." + Becario.COL_GRADUADO + " "
            + "FROM beca_becario AS becario "
            + "WHERE becario." + Becario.COL_ESTATUS + " = ? "
            + "AND becario." + Becario.COL_ACTIVO + " = 1";
    
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
            + "becario." + Becario.COL_PAGARE + ", becario." + Becario.COL_OCUPACION_CONYUGE + ", "
            + "becario." + Becario.COL_ID_BANCO + ", becario." + Becario.COL_CUENTA_BANCO + ", "
            + "becario." + Becario.COL_CLABE_INTERBANCARIA + ", becario." + Becario.COL_ACTIVO + ", "
            + "becario." + Becario.COL_CARTA_ASIGNACION_BECA + ", becario." + Becario.COL_ESTUDIO_SOCIOECONOMICO + ", "
            + "becario." + Becario.COL_CARTA_AGRADECIMIENTO + ", becario." + Becario.COL_GRADUADO + " "
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
    
    /**
     * Obtiene los kardex del becario
     */
    public static String getKardexBecario = "SELECT "
            + Kardex.COL_ID_KARDEX + ", " + Kardex.COL_NUM_SEMESTRE + ", "
            + Kardex.COL_PAGO_INICIO_SEMESTRE + ", " + Kardex.COL_PAGO_FIN_SEMESTRE + ", "
            + Kardex.COL_PLATICA_1 + ", " + Kardex.COL_PLATICA_2 + ", "
            + Kardex.COL_PROMEDIO + ", " + Kardex.COL_DESCUENTO + ", "
            + Kardex.COL_ID_SERVICIO_COMUNITARIO + ", " + Kardex.COL_LUGAR_SERVICIO_COMUNITARIO + ", "
            + Kardex.COL_BOLETA + ", " + Kardex.COL_CARTA_SERVICIO_COMUNITARIO + ", "
            + Kardex.COL_ID_BECARIO + ", " + Kardex.COL_PAGO_EXTRA + ", "
            + Kardex.COL_HORAS_SERVICIO + ", " + Kardex.COL_TRANSFERENCIA_1 + ", "
            + Kardex.COL_TRANSFERENCIA_2 + ", " + Kardex.COL_DEUDA + " "  
            + "FROM beca_kardex "
            + "WHERE " + Kardex.COL_ID_BECARIO + " = ?";
    
    /**
     * Obtiene la informacion bancaria del becario
     */
    public static String getInfoBancariaPorIdBecario = "SELECT " + Becario.COL_ID_BANCO + ", "
            + Becario.COL_CUENTA_BANCO + ", " + Becario.COL_CLABE_INTERBANCARIA + " "
            + "FROM beca_becario "
            + "WHERE " + Becario.COL_ID + " = ?";
    
    /**
     * Obtiene el total de kardex registrados que tiene el becario
     */
    public static String getTotalKardexPorSemestre = "SELECT COUNT(*) FROM beca_kardex WHERE id_becario = ?";    
    
    /**
     * Obtiene el nombre de un catalogo según su id
     */
    public static String getNombreCatalogo = "SELECT " + CatCategorias.COL_NOMBRE_TABLA + " FROM beca_cat_catalogos WHERE " + CatCategorias.COL_ID + " = ?";
    
    /**
     * Obtiene todos los datos de un catalogo por el nombre de la tabla
     */
    public static String getCatalogoPorNombreTabla = "SELECT * FROM "   ;
    
    /**
     * Obtiene el total de registros que contiene una tabla
     */
    public static String getTotalRegistrosPorNombreTabla = "SELECT COUNT(*) FROM ";
    
    /**
     * Obtiene el nombre de las columnas
     */
    public static String getNombreColumnasTabla = "SHOW COLUMNS FROM ";
    
    /**
     * Obtiene el estatus cancelado 
     */
    public static String getEstatusCancelado = "SELECT " + CatEstatus.COL_ID + " FROM beca_cat_estatus WHERE " + CatEstatus.COL_NOMBRE + " LIKE '%cancel%'";
    
    /**
     * Obtiene el tipo de escuela del catalogo beca_cat_universidad
     */
    public static String getTipoEscuela = "SELECT tipo." + CatTipoEscuela.COL_NOMBRE 
                + " FROM beca_cat_universidad AS uni JOIN beca_tipo_escuela AS tipo ON uni." 
                + CatUniversidad.COL_ID_TIPO_ESCUELA + " = tipo." + CatTipoEscuela.COL_ID + " "
            + "WHERE uni." + CatUniversidad.COL_ID + " = ?";
    
    
    public static String getTotalProgramas = "SELECT COUNT(*) FROM beca_cat_programa";

    /**
     * Genera el query necesario para obtener el ID mayor del catalogo
     */
    public static String getIdMayor = "SELECT ? AS maximo FROM ?";
    
    public static String getReporteIndividualDatosUnicos = "SELECT becario.id_becario AS id_becario, "
                                                            + "becario.folio AS folio, becario.ap_paterno AS aPaterno, "
                                                            + "becario.ap_materno AS aMaterno, \n" +
                                                            "becario.nombre AS nombre, \n" +
                                                            "programa.nombre AS programa, \n" +
                                                            "estatus.nombre AS estatus, \n" +
                                                            "uni.nombre AS universidad, \n" +
                                                            "escolar.nombre_carrera AS carrera, \n" +
                                                            "campo.nombre AS campo_carrera, \n" +
                                                            "becario.email AS email, \n" +
                                                            "escolar.fecha_inicio_beca AS inicio_beca, \n" +
                                                            "escolar.semestre_inicio_beca AS semestre_inicio_beca, \n" +
                                                            "escolar.fecha_fin_beca AS graduacion, \n" +
                                                            "escolar.beca_total AS beca_total, \n" +
                                                            "escolar.beca_semestral AS beca_semestral, \n" +
                                                            "(SELECT SUM(pago_extra) AS ajuste_beca_total FROM beca_kardex WHERE id_becario = becario.id_becario) AS ajuste_beca_total \n" +
                                                            "FROM beca_becario AS becario\n" +
                                                            "JOIN beca_cat_programa AS programa ON programa.id_programa = becario.id_programa \n" +
                                                            "JOIN beca_cat_estatus AS estatus ON estatus.id_estatus = becario.id_estatus \n" +
                                                            "JOIN beca_datos_escolares AS escolar ON escolar.id_becario = becario.id_becario \n" +
                                                            "JOIN beca_cat_universidad AS uni ON escolar.id_universidad = uni.id_universidad \n" +
                                                            "JOIN beca_cat_campo AS campo ON campo.id_campo_carrera = escolar.id_campo_carrera \n" +
                                                            "WHERE becario.folio = ?";
    
    public static String getReporteIndividualMuchosDatos = "SELECT\n" +
                    "     beca_becario.`id_becario` AS id_becario,\n" +
                    "     beca_datos_escolares.`id_becario` AS beca_datos_escolares_id_becario,\n" +
                    "     beca_kardex.`id_becario` AS beca_kardex_id_becario,\n" +
                    "     beca_kardex.`num_semestre` AS num_semestre,\n" +
                    "     beca_kardex.`pago_inicio_semestre` AS pago1,\n" +
                    "     beca_kardex.`pago_fin_semestre` AS pago2,\n" +
                    "     beca_kardex.`promedio` AS promedio,\n" +
                    "     beca_kardex.`descuento` AS descuento,\n" +
                    "     beca_kardex.`horas_servicio` AS horas_servicio,\n" +
                    "     beca_kardex.pago_extra AS ajuste_beca_semestral,\n" +
                    "     beca_kardex.deuda AS deuda, \n " +
                    "     beca_cat_servicio_comunitario.`nombre` AS nombre_servicio_comunitario,\n" +
                    "     beca_cat_servicio_comunitario.`id_servicio_comunitario` AS beca_cat_servicio_comunitario_id_servicio_comunitario\n" +
                    "FROM\n" +
                    "     `beca_becario` beca_becario INNER JOIN `beca_datos_escolares` beca_datos_escolares ON beca_becario.`id_becario` = beca_datos_escolares.`id_becario`\n" +
                    "     INNER JOIN `beca_kardex` beca_kardex ON beca_becario.`id_becario` = beca_kardex.`id_becario`\n" +
                    "     INNER JOIN `beca_cat_servicio_comunitario` beca_cat_servicio_comunitario ON beca_kardex.`id_servicio_comunitario` = beca_cat_servicio_comunitario.`id_servicio_comunitario` "
                    + "WHERE beca_becario.folio = ?";
    
    /**
     * Obtiene todos los becarios por su sexo
     */
    public static String getAllBecariosPorSexo = "SELECT " + Becario.COL_ID + ", " + 
                                                Becario.COL_SEXO + " " +
                                                "FROM beca_becario";
    /**
     * Obtiene todos los becarios que trabajan
     */
    public static String getAllBecariosTrabajan = "SELECT  becario." + Becario.COL_ID + " AS idBecario, becario." + 
                                                    Becario.COL_TRABAJA + " AS trabaja " + 
                                                    "FROM beca_becario AS becario" + 
                                                    " INNER JOIN beca_datos_escolares AS datos ON datos." + DatosEscolares.COL_ID_BECARIO + " = becario." + Becario.COL_ID  ;
    /**
     * Obtiene todos los becarios en ser primeros de ser becados
     */
    public static String getAllBecariosEnSerBecados = "SELECT becario." + Becario.COL_ID + " AS idBecario, becario." + 
                                                        Becario.COL_PRIMERO_CON_BECA + " AS primeroConBeca " + 
                                                        "FROM beca_becario AS becario " +
                                                        " INNER JOIN beca_datos_escolares AS datos ON datos." + DatosEscolares.COL_ID_BECARIO + " = becario." + Becario.COL_ID + " ";
    /**
     * Obtiene todos los becarios para general el reporte general
     */
    public static String getAllBecariosReporteGeneral = "SELECT becario." + Becario.COL_FOLIO + " AS folio, becario." + 
            Becario.COL_APATERNO + " AS aPaterno, becario." + Becario.COL_AMATERNO + " AS aMaterno, becario." + Becario.COL_NOMBRE + " AS nombre, becario." + 
            Becario.COL_PROGRAMA + ", becario." + Becario.COL_ESTATUS + ", programa." + CatPrograma.COL_ID + ", programa." + 
            CatPrograma.COL_NOMBRE + " AS nombrePrograma, estatus." + CatEstatus.COL_ID + ", estatus." + CatEstatus.COL_NOMBRE + " AS nombreEstatus, uni." + 
            DatosEscolares.COL_ID_UNIVERSIDAD + ", uni." + CatUniversidad.COL_NOMBRE + " AS nombreUniversidad, campo." + 
            DatosEscolares.COL_ID_CAMPO_CARRERA + ", campo." + CatCampo.COL_NOMBRE + " AS nombreCampo, datos." + 
            DatosEscolares.COL_BECA_TOTAL + " AS becaTotal, datos." + DatosEscolares.COL_BECA_SEMESTRAL + " AS becaSemestral, datos." + 
            DatosEscolares.COL_SEMESTRE_INICIO_BECA + " AS semestreInicioBeca, datos." + DatosEscolares.COL_FECHA_INICIO_BECA + " AS fechaInicioBeca, datos." +
            DatosEscolares.COL_FECHA_GRADUACION +  " AS fechaFinBeca, (" +
                "SELECT SUM(" + Kardex.COL_PAGO_EXTRA + ") AS ajusteBeca FROM beca_kardex WHERE " + Kardex.COL_ID_BECARIO + " = " +
                " becario." + Becario.COL_ID + ") AS ajusteBeca" +
            " FROM beca_cat_estatus AS estatus "
            + "INNER JOIN beca_becario AS becario ON estatus." + CatEstatus.COL_ID + " = becario." + Becario.COL_ESTATUS + 
            " INNER JOIN beca_cat_programa AS programa ON becario." + Becario.COL_PROGRAMA + " = programa." + CatPrograma.COL_ID + 
            " INNER JOIN beca_datos_escolares AS datos ON datos." + DatosEscolares.COL_ID_BECARIO + " = becario." + Becario.COL_ID + 
            " INNER JOIN beca_cat_universidad AS uni ON uni." + CatUniversidad.COL_ID + " = datos." + DatosEscolares.COL_ID_UNIVERSIDAD +
            " INNER JOIN beca_cat_campo AS campo ON campo." + CatCampo.COL_ID + " = datos." + DatosEscolares.COL_ID_CAMPO_CARRERA + " "; 
    
    /**
     * Obtiene al becario que se registro primero en toda la historia
     */
    public static String getFechaMenorDeIngreso = "SELECT MIN(" + DatosEscolares.COL_FECHA_INICIO_BECA + ") "
                            + "AS " + DatosEscolares.COL_FECHA_INICIO_BECA + " FROM beca_datos_escolares";
    
    /**
     * Obtiene al último becario que se va a graduar en la historia
     */
    public static String getFechaMayorDeGraduacion = "SELECT MAX(" + DatosEscolares.COL_FECHA_GRADUACION + ") "
                            + "AS " + DatosEscolares.COL_FECHA_GRADUACION + " FROM beca_datos_escolares";
    
    /**
     * Obtiene los datos para crear el reporte de Sexo
     */
    public static String getAllBecariosReporteSexo = "SELECT becario." + Becario.COL_FOLIO + " AS folio, becario." + 
                        Becario.COL_APATERNO + " AS aPaterno, becario." + Becario.COL_AMATERNO + " AS aMaterno, becario." + 
                        Becario.COL_NOMBRE + " AS nombre, sexo." + CatSexo.COL_NOMBRE + " AS nombreSexo, " +
                        CatSexo.COL_ID_GENERO + " AS idSexo " +
                        "FROM beca_becario AS becario " +
                        "INNER JOIN beca_cat_sexo AS sexo ON sexo." + CatSexo.COL_ID_GENERO + " = becario." + Becario.COL_SEXO + " " +
                        "INNER JOIN beca_datos_escolares AS datos ON datos." + DatosEscolares.COL_ID_BECARIO + " = becario." + Becario.COL_ID + " ";
    
    /**
     * SELECT civil.nombre

        FROM beca_becario AS becario

        JOIN beca_cat_estado_civil AS civil ON civil.id_estado_civil = becario.id_estado_civil;
     * Obtiene los datos para crear el reporte de Estados civiles
     */
    public static String getAllBecariosReporteEdoCivil = "SELECT civil." + CatEstadoCivil.COL_NOMBRE + " AS nombreEdoCivil " +
                            //"programa." + CatPrograma.COL_NOMBRE + " AS nombrePrograma " +
                            "FROM beca_becario AS becario " + 
                            "INNER JOIN beca_cat_estado_civil AS civil ON civil." + CatEstadoCivil.COL_ID_ESTADO_CIVIL + " = becario." + Becario.COL_ESTADO_CIVIL + " " +
                            //"INNER JOIN beca_cat_programa AS programa ON programa." + CatPrograma.COL_ID + " = becario." + Becario.COL_PROGRAMA + " " +
                            "INNER JOIN beca_datos_escolares AS datos ON datos." + DatosEscolares.COL_ID_BECARIO + " = becario." + Becario.COL_ID + " ";
    
    /**
     *  SELECT dat.id_campo_carrera, campo.nombre

FROM beca_datos_escolares AS dat

JOIN beca_cat_campo AS campo ON dat.id_campo_carrera = campo.id_campo_carrera
     */
    public static String getAllBecariosReporteCampoAplicacion = "SELECT campo." + CatCampo.COL_NOMBRE + " AS nombreCampoAplicacion " + 
                            "FROM beca_becario AS becario " + 
                            "INNER JOIN beca_datos_escolares AS datos ON becario. " + Becario.COL_ID + " = datos." + DatosEscolares.COL_ID_BECARIO + " " +
                            "INNER JOIN beca_cat_campo AS campo ON datos." + DatosEscolares.COL_ID_CAMPO_CARRERA + " = campo." + CatCampo.COL_ID + " ";
    
    /**
     * SELECT kardex.lugar_servicio_comunitario AS idServicioComunitario, com.nombre AS nombreServicioComunitario,
	SUM(kardex.horas_servicio) AS horas

FROM beca_kardex AS kardex

JOIN beca_cat_lugar_servicio_comunitario AS com ON kardex.lugar_servicio_comunitario = com.id_lugar_servicio_comunitario
GROUP BY com.nombre
     */
    public static String getAllBecariosServicioComunitario = "SELECT com." + CatLugarServicioComunitario.COL_NOMBRE + 
                            " AS nombreServicioComunitario, " +
                            "SUM(kardex." + Kardex.COL_HORAS_SERVICIO + ") AS horas " +
                            "FROM beca_becario AS becario " + 
                            "INNER JOIN beca_datos_escolares AS datos ON becario. " + Becario.COL_ID + " = datos." + DatosEscolares.COL_ID_BECARIO + " " +
                            "INNER JOIN beca_kardex AS kardex ON becario. " + Becario.COL_ID + " = kardex." + Kardex.COL_ID_BECARIO + " " +
                            "INNER JOIN beca_cat_lugar_servicio_comunitario AS com ON kardex." + Kardex.COL_LUGAR_SERVICIO_COMUNITARIO + " = com." + CatLugarServicioComunitario.COL_ID + " ";
    
    /**
     * Query que obtiene la información necesaria para generar el reporte de universidades publicas
     * SELECT datos.id_becario, datos.id_universidad, uni.id_tipo_escuela, esc.nombre

FROM beca_datos_escolares AS datos

JOIN beca_cat_universidad AS uni ON datos.id_universidad = uni.id_universidad

JOIN beca_tipo_escuela AS esc ON uni.id_tipo_escuela = esc.id_tipo_escuela
     */
    public static String getAllUniversidadesPublicas = "SELECT datos." + DatosEscolares.COL_ID_BECARIO + ", datos." + DatosEscolares.COL_ID_UNIVERSIDAD + ", " +
                                "esc." + CatUniversidad.COL_NOMBRE + " AS nombreUniversidad " +  
                                "FROM beca_datos_escolares AS datos " +
                                "INNER JOIN beca_cat_universidad AS uni ON datos." +  DatosEscolares.COL_ID_UNIVERSIDAD + " = uni." + CatUniversidad.COL_ID + " " +
                                "INNER JOIN beca_tipo_escuela AS esc ON uni." + CatUniversidad.COL_ID_TIPO_ESCUELA + " = esc." + CatTipoEscuela.COL_ID + " ";
    
    /**
     * Obtiene los abonos que ha realizado el becario
     */
    public static String getAbonosBecario = "SELECT " + Cobranza.COL_ID + ", " + Cobranza.COL_FECHA_PAGO + ", " + 
                                                Cobranza.COL_MONTO + ", " + Cobranza.COL_REFERENCIA + " " + 
                                                "FROM beca_pagos_becario " +
                                                "WHERE " + Cobranza.COL_ID_BECARIO + " = ?";
    
}