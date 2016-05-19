/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtable;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sabagip
 */
public class ModelUniversidades extends DefaultTableModel {
    
    public ModelUniversidades(Object[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }
    
    @Override
    public Class getColumnClass(int columna){
      if (columna == 0) return String.class;
      if (columna == 1) return Boolean.class;
      return Object.class;
    }
    
    
}
