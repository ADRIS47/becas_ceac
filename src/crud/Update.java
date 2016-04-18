/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import pojos.Becario;
import pojos.CatPrograma;

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
            + "WHERE " + Becario.COL_FOLIO + " = ?";
    
}
