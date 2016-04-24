/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import pojos.Aval;
import pojos.Becario;
import pojos.CatPrograma;
import pojos.DatosEscolares;
import pojos.Direccion;
import pojos.Hermanos;
import pojos.Hijos;
import pojos.Padres;
import pojos.Telefono;

/**
 *
 * @author sergio
 */
public class Update {

    /**
     * Aumenta el contador del programa
     */
    public static String updateContadorPrograma = "UPDATE beca_cat_programa "
            + "SET " + CatPrograma.COL_CONTADOR + " =  " + CatPrograma.COL_CONTADOR + " + 1 "
            + "WHERE iniciales = ?";
    
    /**
     * Actualiza un becario existente en base a su número de folio
     */
    public static String updateBecario = "UPDATE beca_becario "
            + "SET " + Becario.COL_NOMBRE + " = ?, " + Becario.COL_APATERNO + "= ?, "
            + Becario.COL_AMATERNO + " = ?, " + Becario.COL_FECHA_NAC + "= ?, "
            + Becario.COL_SEXO + " = ?, " + Becario.COL_ESTADO_CIVIL + "= ?, "
            + Becario.COL_TRABAJA + " = ?, " + Becario.COL_ESTATUS + "= ?, "
            + Becario.COL_FOTO + " = ?, " + Becario.COL_EMAIL + "= ?, "
            + Becario.COL_PRIMERO_CON_BECA + " = ?, " + Becario.COL_NOMBRE_CONYUGE + "= ?, "
            + Becario.COL_APATERNO_CONYUGE + " = ?, " + Becario.COL_AMATERNO_CONYUGE + "= ?, "
            + Becario.COL_TELEFONO_CONYUGE + " = ?, " + Becario.COL_OBSERVACIONES + "= ?, "
            + Becario.COL_ACTA_NAC + " = ?, " + Becario.COL_SOLICITUD_BECA + "= ?, "
            + Becario.COL_CONTRATO_BECA + " = ?, " + Becario.COL_IDENTIFICACION + "= ?, "
            + Becario.COL_FOLIO + " = ?, " + Becario.COL_OCUPACION_CONYUGE + " = ? "
            + "WHERE " + Becario.COL_FOLIO + " = ?";
    
    /**
     * Actualiza las direcciones del becario
     */
    public static String updateDireccionesBecario = "UPDATE beca_direccion "
            + "SET " + Direccion.COL_CALLE + " = ?, " + Direccion.COL_NUM_EXT + " = ?, "
            + Direccion.COL_NUM_INT + " = ?, " + Direccion.COL_COLONIA + " = ?, "
            + Direccion.COL_CODIGO_POSTAL + "= ?, " + Direccion.COL_CIUDAD + " = ? " 
            + "WHERE " + Direccion.COL_ID_BECARIO + " = ? AND " + Direccion.COL_ID + " = ?";
    
    /**
     * Actualiza los telefonos del becario
     */
    public static String updateTelefonosBecario = "UPDATE beca_telefono "
            + "SET " + Telefono.COL_TELEFONO + " = ? "
            + "WHERE " + Telefono.COL_ID_BECARIO + " = ? AND " + Telefono.COL_ID + " = ?"; 
    
    /**
     * Actualiza los padres del becario
     */
    public static String updatePapasBecario = "UPDATE beca_padres "
            + "SET " + Padres.COL_NOMBRE + " = ?, " + Padres.COL_APATERNO + " = ?, "
            + Padres.COL_AMATERNO + " = ?, " + Padres.COL_TELEFONO + " = ?, "
            + Padres.COL_ID_GRADO_ESCOLAR + " = ?, " + Padres.COL_TRABAJA + " = ?, "
            + Padres.COL_ID_PARENTESCO + " = ? " + Padres.COL_OCUPACION + " = ? "
            + "WHERE " + Padres.COL_ID_BECARIO + " = ? AND " + Padres.COL_ID + " = ?";
    
    /**
     * Actualiza los hermanos del becario
     */
    public static String updateHermanosBecario = "UPDATE beca_hermano "
            + "SET " + Hermanos.COL_NOMBRE + " = ?, " + Hermanos.COL_APATERNO + " = ?, "
            + Hermanos.COL_AMATERNO + " = ?, " + Hermanos.COL_ID_GRADO_ESCOLAR + " = ? "
            + "WHERE " + Hermanos.COL_ID_BECARIO + " = ? AND " + Hermanos.COL_ID + " = ?";
    
    /**
     * Actualiza los hijos del becario
     */
    public static String updateHijosBecario  = "UPDATE beca_hijo "
            + "SET " + Hijos.COL_NOMBRE + " = ?, " + Hijos.COL_APATERNO + " = ?, "
            + Hijos.COL_AMATERNO + " = ?, " + Hijos.COL_FECHA_NAC + " = ? "
            + "WHERE " + Hijos.COL_ID_BECARIO + " = ? AND " + Hijos.COL_ID + " = ?";
    
    /**
     * Actualiza los datos escolares del becario
     */
    public static String updateDatosEscolaresBecario = "UPDATE beca_datos_escolares "
            + "SET " + DatosEscolares.COL_ESCUELA_PROCEDENCIA + " = ?, " + DatosEscolares.COL_ID_UNIVERSIDAD + " = ?, "
            + DatosEscolares.COL_ID_CAMPO_CARRERA + " = ?, " + DatosEscolares.COL_NOMBRE_CARRERA + " = ?, "
            + DatosEscolares.COL_MES_INICIO_BECA + " = ?, " + DatosEscolares.COL_ANIO_INICIO_BECA + " = ?, "
            + DatosEscolares.COL_MES_GRADUACION + " = ?, " + DatosEscolares.COL_ANIO_GRADUACION + " = ?, "
            + DatosEscolares.COL_SEMESTRES_TOTALES_BECA + " = ?, " + DatosEscolares.COL_SEMESTRE_INICIO_BECA + " = ?, "
            + DatosEscolares.COL_COSTO_CARRERA + " = ?, " + DatosEscolares.COL_BECA_TOTAL + " = ?, "
            + DatosEscolares.COL_BECA_SEMESTRAL + " = ?, " + DatosEscolares.COL_CONDICIONADO + " = ? "
            + "WHERE " + Hijos.COL_ID_BECARIO + " = ?";
    
    /**
     * Actualiza el aval del becario
     */
    public static String updateAvalBecario = "UPDATE beca_aval "
            + "SET " + Aval.COL_APATERNO + " = ?, " + Aval.COL_AMATERNO + " = ?, "
            + Aval.COL_NOMBRE + " = ?, " + Aval.COL_CALLE + " = ?, "
            + Aval.COL_NUM_EXT + " = ?, " + Aval.COL_NUM_INT + " = ?, "
            + Aval.COL_COLONIA + " = ?, " + Aval.COL_IDENTIFICACION + " = ? "
            + "WHERE " + Aval.COL_ID_BECARIO + " = ? ";
    
}
