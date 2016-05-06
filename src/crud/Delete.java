/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import pojos.CatColumnasTabla;

/**
 *
 * @author sabagip
 */
public class Delete {

    /**
     * Crea el query de eliminacion de un registro de una tabla
     * @param nombreTabla
     * @param nombreColumnas
     * @param idRegistro
     * @param datoNuevo
     * @return 
     */
    public static String deletetRegistroCatalogo(String nombreTabla, CatColumnasTabla nombreColumnas, int idRegistro) {        
        String query = "DELETE FROM " + nombreTabla + " WHERE " + nombreColumnas.getNombreColumnaId() + " >= " + idRegistro;
        
        return query;
    }
    
}
