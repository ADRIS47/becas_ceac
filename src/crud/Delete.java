/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import pojos.CatColumnasTabla;
import pojos.Hermanos;

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
     * @param bandera FALSE.- Indica que NO SE han filtrado el catalogo
     * TRUE.- Indica que si se ha filtrado el catalogo
     * @return 
     */
    public static String deletetRegistroCatalogo(String nombreTabla, 
                    CatColumnasTabla nombreColumnas, int idRegistro, boolean bandera) {
        String query;
//        if(bandera == false)
//            query = "DELETE FROM " + nombreTabla + " WHERE " + nombreColumnas.getNombreColumnaId() + " > " + idRegistro;
//        else
            query = "DELETE FROM " + nombreTabla + " WHERE " + nombreColumnas.getNombreColumnaId() + " = " + idRegistro;
        
        System.out.println(query);
        return query;
    }
    
    public static String DELETE_HERMANO_BECARIO = "DELETE FROM beca_hermano WHERE " + Hermanos.COL_ID + " = ?";   
}
