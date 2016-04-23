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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pojos.CatCampoCarrera;
import pojos.CatEstadoCivil;
import pojos.CatGradoEscolar;
import pojos.CatParentesco;
import pojos.CatPrograma;
import pojos.CatSexo;
import pojos.CatUniversidad;

/**
 *
 * @author sabagip
 */
public class PrincipalModelo {
    
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
    //protected List<LinkedHashMap<Integer, String>> getCategoriasVistaRegistro() throws SQLException{
    protected List<LinkedHashMap<Integer, String>> getCategoriasVistaRegistro() throws SQLException{
        
        List<LinkedHashMap<Integer, String>> result = new ArrayList<>();
        LinkedHashMap<Integer, String> catSexo = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catEstadoCivil = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catPrograma = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catNivelEstudios = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catParentesco = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catUniversidad = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catCampoEstudio = new LinkedHashMap<>();
        
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
        catUniversidad = getUniversidades(conn);
        catCampoEstudio = getCampoEstudio(conn);
        
        
        //Se llena la lista con las categorias
        result.add(catSexo);
        result.add(catEstadoCivil);
        result.add(catPrograma);
        result.add(catNivelEstudios);
        result.add(catParentesco);
        result.add(catUniversidad);
        result.add(catCampoEstudio);
        
        conn.close();
        return result;
    }
    
    /**
     * Obtiene la categoria de sexos
     * @param conn COnexion a la base de datos
     * @return Categoria de sexos
     */
    protected LinkedHashMap<Integer, String> getSexo(Connection conn){
        LinkedHashMap<Integer, String> catSexo = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        Map<Integer, String> result = new LinkedHashMap<>();
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatSexo);
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
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catSexo;
    }
    
    /**
    * Obtiene la categoria de sexos
    * @return Categoria de sexos
    */
    protected LinkedHashMap<Integer, String> getSexo(){
        LinkedHashMap<Integer, String> catSexo = new LinkedHashMap<>();
        Conexion  conexion = new Conexion();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            conn = conexion.estableceConexion();
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatSexo);
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
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catSexo;
    }

    /**
     * Obtiene la lista de estados civiles
     * @param conn Conexion a la base de datos
     * @return Lista con los datos de estados civiles
     */
    private LinkedHashMap<Integer, String> getEstadoCivil(Connection conn) {
        LinkedHashMap<Integer, String> catEstadoCivil = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatEstadoCivil);
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
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catEstadoCivil;
    }
    
    /**
     * Obtiene la lista de estados civiles
     * @param conn Conexion a la base de datos
     * @return Lista con los datos de estados civiles
     */
    private LinkedHashMap<Integer, String> getEstadoCivil() {
        Conexion conexion = new Conexion();
        Connection conn = null;
        LinkedHashMap<Integer, String> catEstadoCivil = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        
        try{
            conn = conexion.estableceConexion();
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatEstadoCivil);
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
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catEstadoCivil;
    }

    /**
     * Obtiene los programas que puede tener un becario
     * @param conn COnexion a la base de datos
     * @return 
     */
    private LinkedHashMap<Integer, String> getProgramas(Connection conn) {
        LinkedHashMap<Integer, String> catPrograma = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatProgramas);
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
        finally{
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catPrograma;
    }

    /**
     * Obtiene el catalogo de nivel de estudios
     * @param conn
     * @return 
     */
    private LinkedHashMap<Integer, String> getNivelEstudios(Connection conn) {
        LinkedHashMap<Integer, String> catNivelEstudios = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatNIvelEstudios);
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
        finally{
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catNivelEstudios;
    }

    /**
     * OBtiene el catalogo de parenteco
     * @param conn
     * @return 
     */
    private LinkedHashMap<Integer, String> getParentesco(Connection conn) {
        LinkedHashMap<Integer, String> catNivelEstudios = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatParentesco);
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
        finally{
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catNivelEstudios;
    }

    /**
     * Obtiene el catalogo de universidades
     * @param conn Conexion a la base de datos
     * @return Lista de las universidades
     */
    private LinkedHashMap<Integer, String> getUniversidades(Connection conn) {
        LinkedHashMap<Integer, String> catUniversidades = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatUniversidades);
            while(rs.next()){
                CatUniversidad universidad = new CatUniversidad();
                universidad.setId(rs.getInt(CatUniversidad.COL_ID));
                universidad.setNombre(rs.getString(CatUniversidad.COL_NOMBRE));
                catUniversidades.put(universidad.getId(), universidad.getNombre());
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
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catUniversidades;
    }

    /**
     * Obtiene el catalogo de campo de estudio
     * @param conn Conexion a la base de datos
     * @return Lista de campos de estudio
     */
    private LinkedHashMap<Integer, String> getCampoEstudio(Connection conn) {
        LinkedHashMap<Integer, String> catCampoEstudio = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatCampoEstudio);
            while(rs.next()){
                CatCampoCarrera campo = new CatCampoCarrera();
                campo.setId(rs.getInt(CatCampoCarrera.COL_ID));
                campo.setNombre(rs.getString(CatCampoCarrera.COL_NOMBRE));
                catCampoEstudio.put(campo.getId(), campo.getNombre());
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
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return catCampoEstudio;
    }

    /**
     * Obtiene las iniciales del programa seleccionado
     * @param programa Id del programa seleccionado
     * @return 
     */
    protected String getClavePrograma(int programa) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Conexion conexion = new Conexion();
        String result = "";
        try{
            conn = conexion.estableceConexion();
            st = conn.prepareStatement(Consultas.getInicialesPrograma);
            st.setInt(1, programa);
            rs = st.executeQuery();
            while(rs.next()){
               result = rs.getString(CatPrograma.COL_INICIALES);
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
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
}
