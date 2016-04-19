/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author sabagip
 */
public class Log {
    
    FileWriter archivo; //nuestro archivo log

     public void crearLog(String operacion) {
        try{
        //Pregunta el archivo existe, caso contrario crea uno con el nombre log.txt
        if (new File("log.txt").exists()==false){archivo=new FileWriter(new File("log.txt"),false);}
             archivo = new FileWriter(new File("log.txt"), true);
             Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar el paquete calendar    
             //Empieza a escribir en el archivo
             archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                  +"/"+String.valueOf(fechaActual.get(Calendar.MONTH)+1)
                  +"/"+String.valueOf(fechaActual.get(Calendar.YEAR))
                  +";"+String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                  +":"+String.valueOf(fechaActual.get(Calendar.MINUTE))
                  +":"+String.valueOf(fechaActual.get(Calendar.SECOND)))+";" + operacion +"\r\n");
             archivo.close(); //Se cierra el archivo
        }
        catch(IOException e){
            this.crearLog(e.getMessage());
        }
     }//Fin del metodo crearLog
     
     /**
     * Muestra los errores generados por la excepcion en consola
     *
     * @param e Excepcion generada para mostrar sus errores
     */
    public void muestraErrores(SQLException e) {
        try{
            //Pregunta el archivo existe, caso contrario crea uno con el nombre log.txt
            if (new File("log.txt").exists()==false){archivo=new FileWriter(new File("log.txt"),false);}
            archivo = new FileWriter(new File("log.txt"), true);
            Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar el paquete calendar    
                while (e != null) {
                    System.err.println("SQLError: " + e.getSQLState());
                    System.err.println("ERROR: Code" + e.getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    
                    archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                    +"/"+String.valueOf(fechaActual.get(Calendar.MONTH)+1)
                    +"/"+String.valueOf(fechaActual.get(Calendar.YEAR))
                    +";"+String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                    +":"+String.valueOf(fechaActual.get(Calendar.MINUTE))
                    +":"+String.valueOf(fechaActual.get(Calendar.SECOND)))+";" + "SQLError: " + e.getSQLState() +"\r\n");
                    
                    archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                    +"/"+String.valueOf(fechaActual.get(Calendar.MONTH)+1)
                    +"/"+String.valueOf(fechaActual.get(Calendar.YEAR))
                    +";"+String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                    +":"+String.valueOf(fechaActual.get(Calendar.MINUTE))
                    +":"+String.valueOf(fechaActual.get(Calendar.SECOND)))+";" + "ERROR: Code" + e.getErrorCode() +"\r\n");
                    
                    archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                    +"/"+String.valueOf(fechaActual.get(Calendar.MONTH)+1)
                    +"/"+String.valueOf(fechaActual.get(Calendar.YEAR))
                    +";"+String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                    +":"+String.valueOf(fechaActual.get(Calendar.MINUTE))
                    +":"+String.valueOf(fechaActual.get(Calendar.SECOND)))+";" + "Message: " + e.getMessage() +"\r\n");
                    
                    Throwable t = e.getCause();
                    while (t != null) {
                        System.err.println("Cause: " + t);
                        archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                        +"/"+String.valueOf(fechaActual.get(Calendar.MONTH)+1)
                        +"/"+String.valueOf(fechaActual.get(Calendar.YEAR))
                        +";"+String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                        +":"+String.valueOf(fechaActual.get(Calendar.MINUTE))
                        +":"+String.valueOf(fechaActual.get(Calendar.SECOND)))+";" + "Cause: " + t +"\r\n");
                        t = t.getCause();
                    }

                    e = e.getNextException();
                }
        }
        catch(IOException ex){
            
        }
    }
    
}
