/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adris.vistas;

import login.*;
import crud.Conexion;
import crud.Consultas;
import helpers.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sabagip
 */
public class LoginModelo {
    
    LoginControlador controlador;
    Log log = new Log();

    protected LoginModelo(LoginControlador controlador) {
        this.controlador = controlador;
    }
    
    /**
     * Muestra los errores generados por la excepcion en consola
     *
     * @param e Excepcion generada para mostrar sus errores
     */
    private void muestraErrores(SQLException e) {
        while (e != null) {
            System.err.println("SQLError: " + e.getSQLState());
            log.crearLog("SQLError: " + e.getSQLState());
            System.err.println("ERROR: Code" + e.getErrorCode());
            log.crearLog("ERROR: Code" + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            log.crearLog("Message: " + e.getMessage());
            Throwable t = e.getCause();
            while (t != null) {
                System.err.println("Cause: " + t);
                log.crearLog("Cause: " + t);
                t = t.getCause();
            }

            e = e.getNextException();
        }
    }

    protected boolean iniciarSesion(String clave) {
        boolean response = false;
        Conexion con = new Conexion();
        Connection conexion  =  null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conexion = con.estableceConexion();
            ps = conexion.prepareStatement(Consultas.getClave);
            ps.setString(1, clave);
            rs = ps.executeQuery();
            
            while(rs.next()){
                response = true;
            }
        }
        catch(SQLException e){
            muestraErrores(e);
        }
        finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                muestraErrores(ex);
            }
        }
        
        return response;
    }
    
    
    
}
