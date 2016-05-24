/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import pojos.Aval;
import pojos.Becario;
import pojos.CatColumnasTabla;
import pojos.DatosEscolares;
import pojos.Direccion;
import pojos.Hermanos;
import pojos.Hijos;
import pojos.Kardex;
import pojos.Padres;
import pojos.Telefono;

/**
 *
 * @author sabagip
 */
public class Insert {
    public static String insertBecarioBorrador = "INSERT INTO beca_becario "
            + "(" + Becario.COL_NOMBRE + ", " + Becario.COL_APATERNO + ", "
                    + Becario.COL_AMATERNO + ", "   + Becario.COL_FECHA_NAC + ", "
                    + Becario.COL_SEXO + ", " + Becario.COL_ESTADO_CIVIL + ", "
                    + Becario.COL_TRABAJA +", " + Becario.COL_FOTO + ", "
                    + Becario.COL_EMAIL + ", " + Becario.COL_PRIMERO_CON_BECA + ", "
                    + Becario.COL_NOMBRE_CONYUGE + ", " + Becario.COL_APATERNO_CONYUGE + ", "
                    + Becario.COL_AMATERNO_CONYUGE + ", " + Becario.COL_TELEFONO_CONYUGE + ", "
                    + Becario.COL_OBSERVACIONES + ", " + Becario.COL_ACTA_NAC + ", "
                    + Becario.COL_SOLICITUD_BECA + ", " + Becario.COL_ENSAYO + ", "
                    + Becario.COL_BOLETA_INICIO_BECA + ", " + Becario.COL_PENDIENTE + ","
                    + Becario.COL_CONTRATO_BECA + ", " + Becario.COL_IDENTIFICACION + ","
                    + Becario.COL_FOLIO + ", " + Becario.COL_ESTATUS + ","
                    + Becario.COL_PAGARE + ", "  + Becario.COL_OCUPACION_CONYUGE + ","
                    + Becario.COL_PROGRAMA + "," + Becario.COL_ESTUDIO_SOCIOECONOMICO + ", "
                    + Becario.COL_CARTA_ASIGNACION_BECA + ", " + Becario.COL_CARTA_AGRADECIMIENTO + ") "
            + "VALUES (?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?)";
    
    /**
     * Inserta la direccion del becario
     */
    public static String insertDireccionBecario = "INSERT INTO beca_direccion "
            + "( " + Direccion.COL_CALLE + ", " + Direccion.COL_NUM_EXT + ", "
                + Direccion.COL_NUM_INT + ", " + Direccion.COL_COLONIA + ", "
                + Direccion.COL_CODIGO_POSTAL + ", " + Direccion.COL_CIUDAD + ", "
                + Direccion.COL_ID_BECARIO + " ) "
            + "VALUES (?,?,?,?,?,?,?)";
    
    /**
     * Inserta telefono de un becario
     */
    public static String insertTelefonoBecario = "INSERT INTO beca_telefono "
            + "( " + Telefono.COL_TELEFONO + ", " + Telefono.COL_ID_BECARIO + " ) "
            + "VALUES (?,?)";
    
    /**
     * Inserta los padres del becario
     */
    public static String insertPadresBecario = "INSERT INTO beca_padres "
            + "(" + Padres.COL_NOMBRE + ",  " + Padres.COL_APATERNO + ", "
            + Padres.COL_AMATERNO + ",  " + Padres.COL_TELEFONO + ", "
            + Padres.COL_ID_GRADO_ESCOLAR + ",  " + Padres.COL_TRABAJA + ", "
            + Padres.COL_ID_BECARIO + ",  " + Padres.COL_ID_PARENTESCO + ", "
            + Padres.COL_OCUPACION + ") " 
            + "VALUES (?,?,?,?,"
                        + "?,?,?,?,?)";
    
    
    
    /**
     * Esto es una prueba de actuializacion
     */
    
    /**
     * Inserta el hermano del becario
     */
    public static String insertHermanoBecario = "INSERT INTO beca_hermano "
            + "(" + Hermanos.COL_NOMBRE + ",  " + Hermanos.COL_APATERNO + ", "
            + Hermanos.COL_AMATERNO + ",  " + Hermanos.COL_ID_GRADO_ESCOLAR + ", "
            + Hermanos.COL_ID_BECARIO + ", "  + Hermanos.COL_COMENTARIOS + ") "
            + "VALUES (?,?,?,?,?,?)";
    
    /**
     * Inserta un hijo del becario
     */
    public static String insertHijoBecario = "INSERT INTO beca_hijo "
            + "(" + Hijos.COL_NOMBRE + ",  " + Hijos.COL_APATERNO + ", "
            + Hijos.COL_AMATERNO + ",  " + Hijos.COL_FECHA_NAC + ", "
            + Hijos.COL_ID_BECARIO + ") "
            + "VALUES (?,?,?,?,?)";
    
    /**
     * Inserta los datos escolares del becario
     */
    public static String insertDatosEscolares = "INSERT INTO beca_datos_escolares "
            + "(" + DatosEscolares.COL_ESCUELA_PROCEDENCIA + ", " + DatosEscolares.COL_ID_UNIVERSIDAD + ", "
            + DatosEscolares.COL_ID_CAMPO_CARRERA + ", " + DatosEscolares.COL_NOMBRE_CARRERA + ", "
            + DatosEscolares.COL_MES_INICIO_BECA + ", " + DatosEscolares.COL_ANIO_INICIO_BECA + ", "
            + DatosEscolares.COL_MES_GRADUACION + ", " + DatosEscolares.COL_ANIO_GRADUACION + ", "
            + DatosEscolares.COL_SEMESTRES_TOTALES_BECA + ", " + DatosEscolares.COL_SEMESTRE_INICIO_BECA + ", "
            + DatosEscolares.COL_COSTO_CARRERA + ", " + DatosEscolares.COL_BECA_TOTAL + ", "
            + DatosEscolares.COL_BECA_SEMESTRAL + ", " + DatosEscolares.COL_CONDICIONADO + ", "
            + DatosEscolares.COL_ID_BECARIO + ", " + DatosEscolares.COL_ID_TIPO_ESCUELA + ") "
            + "VALUES (?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?,?,?,?,?,"
                        + "?)";
    
    /**
     * Inserta el aval del becario
     */
    public static String insertAvalDeFormulario = "INSERT INTO beca_aval "
            + "(" + Aval.COL_IDENTIFICACION + ", " + Aval.COL_ID_BECARIO + ") "
            + "VALUES (?,?)";
    
    /**
     * Inserta el un semestre del kardex del becario
     */
    public static String insertKardexBecario = "INSERT INTO beca_kardex "
            + "(" + Kardex.COL_NUM_SEMESTRE + ", " + Kardex.COL_PAGO_INICIO_SEMESTRE + ", "
            + Kardex.COL_PAGO_FIN_SEMESTRE + ", " + Kardex.COL_PLATICA_1 + ", "
            + Kardex.COL_PLATICA_2 + ", " + Kardex.COL_PROMEDIO + ", "
            + Kardex.COL_DESCUENTO + ", " + Kardex.COL_ID_SERVICIO_COMUNITARIO + ", "
            + Kardex.COL_LUGAR_SERVICIO_COMUNITARIO + ", " + Kardex.COL_BOLETA + ", "
            + Kardex.COL_CARTA_SERVICIO_COMUNITARIO + ", " + Kardex.COL_PAGO_EXTRA + ", "
            + Kardex.COL_HORAS_SERVICIO + ", " + Kardex.COL_ID_BECARIO + ", "
            + Kardex.COL_TRANSFERENCIA_1 + ", " + Kardex.COL_TRANSFERENCIA_2 + ") "
            + "VALUES (" 
            + "?,?,?,?,?,"
            + "?,?,?,?,?,"
            + "?,?,?,?,?,"
            + "?)";

    /**
     * Inserta un registro dentro de una tabla por su nombre
     * @param nombreTabla
     * @param nombreColumnas
     * @param datoNuevo
     * @param idRegistro
     * @param tipoUniversidad
     * @return 
     */
    public static String insertRegistroCatalogo(String nombreTabla, CatColumnasTabla nombreColumnas, 
                        String datoNuevo, int idRegistro) {
        String query;
        
//        if(bandera == false)
//            query = "INSERT INTO  " + nombreTabla 
//                    + " (" + nombreColumnas.getNombreColumnaId() + ", " + nombreColumnas.getNombreColumnaNombre() + ") "
//                    + " VALUES (" + idRegistro + ", '" + datoNuevo + "')";
//        else
            query = "INSERT INTO  " + nombreTabla 
                    + " (" + nombreColumnas.getNombreColumnaNombre() + ") "
                    + " VALUES ('" + datoNuevo + "')";
        System.out.println("Query: " + query);
        
        return query;
    }
    
    /**
     * Inserta un registro dentro de la tabla beca_cat_universidad
     * @param nombreTabla
     * @param nombreColumnas
     * @param datoNuevo
     * @param idRegistro
     * @param bandera False, indica que la tabla NO FUE filtrada.
     * TRUE indica que la tabla SI FUE filtrada
     * @param tipoUniversidad
     * @return 
     */
    public static String insertRegistroCatalogo(String nombreTabla, CatColumnasTabla nombreColumnas, 
                        String datoNuevo, int idRegistro, boolean tipoUniversidad) {
        String query = "";
        
//        if(bandera == false)
//            query = "INSERT INTO  " + nombreTabla 
//                    + " (" + nombreColumnas.getNombreColumnaId() + ", " + nombreColumnas.getNombreColumnaNombre() + ", " 
//                            + nombreColumnas.getNombreColumnaTipoEscuela() + ") "
//                    + " VALUES (" + idRegistro + ", '" + datoNuevo + "', " + tipoUniversidad + ")";
//        else
            query = "INSERT INTO  " + nombreTabla 
                    + " (" + nombreColumnas.getNombreColumnaNombre() + ", "
                    + nombreColumnas.getNombreColumnaTipoEscuela() + ") "
                    + " VALUES ('" + datoNuevo + "', " + tipoUniversidad + ")";
        System.out.println("Query: " + query);
        
        return query;
    }
}
