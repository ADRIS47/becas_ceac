/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import pojos.Becario;
import pojos.Direccion;

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
                    + Becario.COL_BOLETA_INICIO_BECA + ", " + Becario.COL_PENDIENTE + ") "
            + "VALUES (?,?,?,?,?,"
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
    
}
