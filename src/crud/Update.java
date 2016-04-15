/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

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
    
}
