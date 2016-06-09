/*
* To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sergio
 */
public class Conexion {
    private Connection conexion = null;
    public Connection estableceConexion(){        
        if(!isConnected())
            return null;
        
        if (conexion != null)
            return conexion;
        
        //String url = "jdbc:mysql://10.18.222.203:3306/becas_chihuahua?zeroDateTimeBehavior=convertToNull";
        String url = "jdbc:mysql://localhost:3306/becas_chihuahua?zeroDateTimeBehavior=convertToNull";
//        String url = "jdbc:mysql://192.168.1.77:3306/becas_chihuahua?zeroDateTimeBehavior=convertToNull";
//        String url = "jdbc:mysql://db4free.net:3306/becas_chihuahua?zeroDateTimeBehavior=convertToNull";
        
        //Tiempo que tardara el driver en conectarse a la BD
        try{
            DriverManager.setLoginTimeout(5);
//            conexion = DriverManager.getConnection(url, "becas_root", "HLSyznYWS6");
//            conexion = DriverManager.getConnection(url, "root", "k010683.");
            conexion = DriverManager.getConnection(url, "root", "xxx.1234");
            //conexion = DriverManager.getConnection(url, "root", "");
//            conexion = DriverManager.getConnection(url, "root", "HsSLgx0kYCA");
            if (conexion !=null){
                System.out.println("Conexión a base de datos … Ok");
            }
        } catch (SQLException e) {
            System.out.println("Error conexion: " + e.getMessage());
        }
        
        return conexion;
    }
    
    public void cierraConexion(){
        try{
            conexion.close();
        }
        catch(Exception e){
            System.out.println("Problema para cerrar la Conexión a la base de datos ");
        }
        }

    private boolean isConnected(){
        boolean conectado = false;
        try{
            Socket socket = new Socket("www.google.com", 80);
            if(socket.isConnected())
                conectado = true;
        }
        catch(Exception e){}
        
        return conectado;
    }
}
