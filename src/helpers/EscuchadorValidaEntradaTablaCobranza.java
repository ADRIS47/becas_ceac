/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author sabagip
 */
public class EscuchadorValidaEntradaTablaCobranza implements TableModelListener{

    
    
    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE) {
            int columna = e.getColumn();
            
            if(columna == 0){
                Helper helper = new Helper();
                helper.validaFechaNacimiento(null, null);
            }
        }
    }
    
}
