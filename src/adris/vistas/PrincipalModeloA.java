/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adris.vistas;

import principal.*;
import crud.Conexion;
import crud.Consultas;
import helpers.Log;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pojos.CatEstadoCivil;
import pojos.CatGradoEscolar;
import pojos.CatParentesco;
import pojos.CatPrograma;
import pojos.CatSexo;

/**
 *
 * @author sabagip
 */
public class PrincipalModeloA {
    
    Log log = new Log();
    
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
    
    /**
     * Obtiene los datos de las categorias de la pantall VistaRegistro
     * @return Lista con las categorias de datos
     * @throws SQLException Al no conectarse a la base de datos
     */
    protected List<TreeMap<Integer, String>> getCategoriasVistaRegistro() throws SQLException{
        
        List<TreeMap<Integer, String>> result = new ArrayList<>();
        TreeMap<Integer, String> catSexo = new TreeMap<>();
        TreeMap<Integer, String> catEstadoCivil = new TreeMap<>();
        TreeMap<Integer, String> catPrograma = new TreeMap<>();
        TreeMap<Integer, String> catNivelEstudios = new TreeMap<>();
        TreeMap<Integer, String> catParentesco = new TreeMap<>();
        
        Conexion conexion = new Conexion();
        Connection conn = null;
        conn = conexion.estableceConexion();
        if(conn == null){
            throw new SQLException("No se pudo conectar a la Base de datos");
        }
        //Se comienzan a jalar los datos de la BD
        catSexo = getSexo(conn);
        catEstadoCivil = getEstadoCivil(conn);
        catPrograma = getProgramas(conn);
        catNivelEstudios = getNivelEstudios(conn);
        catParentesco = getParentesco(conn);
        
        
        //Se llena la lista con las categorias
        result.add(catSexo);
        result.add(catEstadoCivil);
        result.add(catPrograma);
        result.add(catNivelEstudios);
        result.add(catParentesco);
        
        conn.close();
        return result;
    }
    
    /**
     * Obtiene la categoria de sexos
     * @param conn COnexion a la base de datos
     * @return Categoria de sexos
     */
    protected TreeMap<Integer, String> getSexo(Connection conn){
        TreeMap<Integer, String> catSexo = new TreeMap<>();
        Statement st = null;
        ResultSet rs = null;
        Map<Integer, String> result = new TreeMap<>();
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getSexo);
            while(rs.next()){
                CatSexo sexo = new CatSexo();
                sexo.setId(rs.getInt(CatSexo.COL_ID_GENERO));
                sexo.setNombre(rs.getString(CatSexo.COL_NOMBRE));
                catSexo.put(sexo.getId(), sexo.getNombre());
            }
        }
        catch(SQLException e){
            muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModeloA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catSexo;
    }
    
    /**
    * Obtiene la categoria de sexos
    * @return Categoria de sexos
    */
    protected TreeMap<Integer, String> getSexo(){
        TreeMap<Integer, String> catSexo = new TreeMap<>();
        Conexion  conexion = new Conexion();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = conexion.estableceConexion();
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getSexo);
            while(rs.next()){
                CatSexo sexo = new CatSexo();
                sexo.setId(rs.getInt(CatSexo.COL_ID_GENERO));
                sexo.setNombre(rs.getString(CatSexo.COL_NOMBRE));
                catSexo.put(sexo.getId(), sexo.getNombre());
            }
        }
        catch(SQLException e){
            muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModeloA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catSexo;
    }

    /**
     * Obtiene la lista de estados civiles
     * @param conn Conexion a la base de datos
     * @return Lista con los datos de estados civiles
     */
    private TreeMap<Integer, String> getEstadoCivil(Connection conn) {
        TreeMap<Integer, String> catEstadoCivil = new TreeMap<>();
        Statement st = null;
        ResultSet rs = null;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getEstadoCivil);
            while(rs.next()){
                CatEstadoCivil edoCivil = new CatEstadoCivil();
                edoCivil.setId(rs.getInt(CatEstadoCivil.COL_ID_ESTADO_CIVIL));
                edoCivil.setNombre(rs.getString(CatEstadoCivil.COL_NOMBRE));
                catEstadoCivil.put(edoCivil.getId(), edoCivil.getNombre());
            }
        }
        catch(SQLException e){
            muestraErrores(e);
            JOptionPane.showMessageDialog(null, "Error al consultar la BD", "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModeloA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catEstadoCivil;
    }
    
    /**
     * Obtiene la lista de estados civiles
     * @param conn Conexion a la base de datos
     * @return Lista con los datos de estados civiles
     */
    private TreeMap<Integer, String> getEstadoCivil() {
        Conexion conexion = new Conexion();
        Connection conn = null;
        TreeMap<Integer, String> catEstadoCivil = new TreeMap<>();
        Statement st = null;
        ResultSet rs = null;
        
        try{
            conn = conexion.estableceConexion();
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getEstadoCivil);
            while(rs.next()){
                CatEstadoCivil edoCivil = new CatEstadoCivil();
                edoCivil.setId(rs.getInt(CatEstadoCivil.COL_ID_ESTADO_CIVIL));
                edoCivil.setNombre(rs.getString(CatEstadoCivil.COL_NOMBRE));
                catEstadoCivil.put(edoCivil.getId(), edoCivil.getNombre());
            }
        }
        catch(SQLException e){
            muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModeloA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catEstadoCivil;
    }

    /**
     * Obtiene los programas que puede tener un becario
     * @param conn COnexion a la base de datos
     * @return 
     */
    private TreeMap<Integer, String> getProgramas(Connection conn) {
        TreeMap<Integer, String> catPrograma = new TreeMap<>();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getProgramas);
            while(rs.next()){
                CatPrograma programa = new CatPrograma();
                programa.setId(rs.getInt(CatPrograma.COL_ID));
                programa.setNombre(rs.getString(CatPrograma.COL_NOMBRE));
                catPrograma.put(programa.getId(), programa.getNombre());
            }
        }
        catch(SQLException e){
            muestraErrores(e);
        }
        return catPrograma;
    }

    /**
     * Obtiene el catalogo de nivel de estudios
     * @param conn
     * @return 
     */
    private TreeMap<Integer, String> getNivelEstudios(Connection conn) {
        TreeMap<Integer, String> catNivelEstudios = new TreeMap<>();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getNIvelEstudios);
            while(rs.next()){
                CatGradoEscolar grado = new CatGradoEscolar();
                grado.setId(rs.getInt(CatGradoEscolar.COL_ID));
                grado.setNombre(rs.getString(CatGradoEscolar.COL_NOMBRE));
                catNivelEstudios.put(grado.getId(), grado.getNombre());
            }
        }
        catch(SQLException e){
            muestraErrores(e);
        }
        return catNivelEstudios;
    }

    /**
     * OBtiene el catalogo de parenteco
     * @param conn
     * @return 
     */
    private TreeMap<Integer, String> getParentesco(Connection conn) {
        TreeMap<Integer, String> catNivelEstudios = new TreeMap<>();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getParentesco);
            while(rs.next()){
                CatParentesco parentesco = new CatParentesco();
                parentesco.setId(rs.getInt(CatParentesco.COL_ID));
                parentesco.setNombre(rs.getString(CatParentesco.COL_NOMBRE));
                catNivelEstudios.put(parentesco.getId(), parentesco.getNombre());
            }
        }
        catch(SQLException e){
            muestraErrores(e);
        }
        return catNivelEstudios;
    }
}
