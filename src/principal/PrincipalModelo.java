/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import crud.Conexion;
import crud.Consultas;
import crud.Delete;
import crud.Insert;
import crud.Update;
import helpers.Helper;
import helpers.Log;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pojos.Aval;
import pojos.Becario;
import pojos.CatBanco;
import pojos.CatCampoCarrera;
import pojos.CatCategorias;
import pojos.CatColumnasTabla;
import pojos.CatEstadoCivil;
import pojos.CatEstatus;
import pojos.CatGradoEscolar;
import pojos.CatLugarServicioComunitario;
import pojos.CatMunicipios;
import pojos.CatParentesco;
import pojos.CatPrograma;
import pojos.CatSexo;
import pojos.CatTipoEscuela;
import pojos.CatTipoServicioSocial;
import pojos.CatUniversidad;
import pojos.DatosEscolares;
import pojos.Direccion;
import pojos.Hermanos;
import pojos.Hijos;
import pojos.Kardex;
import pojos.Padres;
import pojos.Telefono;

/**
 *
 * @author sabagip
 */
public class PrincipalModelo {

    Log log = new Log();
    Helper helper = new Helper();

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
     *
     * @return Lista con las categorias de datos
     * @throws SQLException Al no conectarse a la base de datos
     */
    //protected List<LinkedHashMap<Integer, String>> getCategoriasVistaRegistro() throws SQLException{
    protected List<LinkedHashMap<Integer, String>> getCategoriasVistaRegistro() throws SQLException {

        List<LinkedHashMap<Integer, String>> result = new ArrayList<>();
        LinkedHashMap<Integer, String> catSexo = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catEstadoCivil = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catPrograma = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catNivelEstudios = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catParentesco = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catUniversidad = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catCampoEstudio = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catEstatus = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catBancos = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catTipoEscuela = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catTipoServicioSocial = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catLugarServicioSocial = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catCatalogos = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catMunicipios = new LinkedHashMap<>();

        Conexion conexion = new Conexion();
        Connection conn = null;
        conn = conexion.estableceConexion();
        if (conn == null) {
            throw new SQLException("No se pudo conectar a la Base de datos");
        }
        //Se comienzan a jalar los datos de la BD
        catSexo = PrincipalModelo.this.getCatSexo(conn);
        catEstadoCivil = PrincipalModelo.this.getCatEstadoCivil(conn);
        catPrograma = getCatProgramas(conn);
        catNivelEstudios = getCatNivelEstudios(conn);
        catParentesco = getCatParentesco(conn);
        catUniversidad = getCatUniversidades(conn);
        catCampoEstudio = getCatCampoEstudio(conn);
        catEstatus = getCatEstatus(conn);
        catBancos = getCatBancos(conn);
        catTipoEscuela = getCatTipoEscuela(conn);
        catTipoServicioSocial = getCatTipoServicioComunitario(conn);
        catLugarServicioSocial = getCatLugarServicioSocial(conn);
        catCatalogos = getCatCategorias(conn);
        catMunicipios = getCatMunicipios(conn);

        //Se llena la lista con las categorias
        result.add(catSexo);
        result.add(catEstadoCivil);
        result.add(catPrograma);
        result.add(catNivelEstudios);
        result.add(catParentesco);
        result.add(catUniversidad);
        result.add(catCampoEstudio);
        result.add(catEstatus);
        result.add(catBancos);
        result.add(catTipoEscuela);
        result.add(catTipoServicioSocial);
        result.add(catLugarServicioSocial);
        result.add(catCatalogos);
        result.add(catMunicipios);

        conn.close();
        return result;
    }

    /**
     * Obtiene la municipio de sexos
     *
     * @param conn COnexion a la base de datos
     * @return Categoria de sexos
     */
    protected LinkedHashMap<Integer, String> getCatSexo(Connection conn) {
        LinkedHashMap<Integer, String> catSexo = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        Map<Integer, String> result = new LinkedHashMap<>();

        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatSexo);
            while (rs.next()) {
                CatSexo sexo = new CatSexo();
                sexo.setId(rs.getInt(CatSexo.COL_ID_GENERO));
                sexo.setNombre(rs.getString(CatSexo.COL_NOMBRE));
                catSexo.put(sexo.getId(), sexo.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
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
     * Obtiene la municipio de sexos
     *
     * @return Categoria de sexos
     */
    protected LinkedHashMap<Integer, String> getCatSexo() {
        LinkedHashMap<Integer, String> catSexo = new LinkedHashMap<>();
        Conexion conexion = new Conexion();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = conexion.estableceConexion();
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatSexo);
            while (rs.next()) {
                CatSexo sexo = new CatSexo();
                sexo.setId(rs.getInt(CatSexo.COL_ID_GENERO));
                sexo.setNombre(rs.getString(CatSexo.COL_NOMBRE));
                catSexo.put(sexo.getId(), sexo.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
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
     *
     * @param conn Conexion a la base de datos
     * @return Lista con los datos de estados civiles
     */
    private LinkedHashMap<Integer, String> getCatEstadoCivil(Connection conn) {
        LinkedHashMap<Integer, String> catEstadoCivil = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatEstadoCivil);
            while (rs.next()) {
                CatEstadoCivil edoCivil = new CatEstadoCivil();
                edoCivil.setId(rs.getInt(CatEstadoCivil.COL_ID_ESTADO_CIVIL));
                edoCivil.setNombre(rs.getString(CatEstadoCivil.COL_NOMBRE));
                catEstadoCivil.put(edoCivil.getId(), edoCivil.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
            JOptionPane.showMessageDialog(null, "Error al consultar la BD", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
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
     *
     * @param conn Conexion a la base de datos
     * @return Lista con los datos de estados civiles
     */
    private LinkedHashMap<Integer, String> getCatEstadoCivil() {
        Conexion conexion = new Conexion();
        Connection conn = null;
        LinkedHashMap<Integer, String> catEstadoCivil = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = conexion.estableceConexion();
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatEstadoCivil);
            while (rs.next()) {
                CatEstadoCivil edoCivil = new CatEstadoCivil();
                edoCivil.setId(rs.getInt(CatEstadoCivil.COL_ID_ESTADO_CIVIL));
                edoCivil.setNombre(rs.getString(CatEstadoCivil.COL_NOMBRE));
                catEstadoCivil.put(edoCivil.getId(), edoCivil.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
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
     *
     * @param conn COnexion a la base de datos
     * @return
     */
    private LinkedHashMap<Integer, String> getCatProgramas(Connection conn) {
        LinkedHashMap<Integer, String> catPrograma = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> catResult = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatProgramas);
            while (rs.next()) {
                CatPrograma programa = new CatPrograma();
                programa.setId(rs.getInt(CatPrograma.COL_ID));
                programa.setNombre(rs.getString(CatPrograma.COL_NOMBRE));
                catPrograma.put(programa.getId(), programa.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Se ordenan los programas
//        int i = 0;
//        int tamanioOriginal = catPrograma.size();
//        String[] programas = new String[]{"Devoluci", "Empuje", "Pura", "Apoyo", "Historico"};
//        while(i < tamanioOriginal){
//            for (Integer idPrograma : catPrograma.keySet()) {
//                String programa = catPrograma.get(idPrograma);
//                if(programa.contains(programas[i])){
//                    catResult.put(idPrograma, programa);
//                    i++;
//                    break;
//                }
//            }
//        }
        return catPrograma;
    }

    /**
     * Obtiene el catalogo de nivel de estudios
     *
     * @param conn
     * @return
     */
    private LinkedHashMap<Integer, String> getCatNivelEstudios(Connection conn) {
        LinkedHashMap<Integer, String> catNivelEstudios = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatNIvelEstudios);
            while (rs.next()) {
                CatGradoEscolar grado = new CatGradoEscolar();
                grado.setId(rs.getInt(CatGradoEscolar.COL_ID));
                grado.setNombre(rs.getString(CatGradoEscolar.COL_NOMBRE));
                catNivelEstudios.put(grado.getId(), grado.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
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
     *
     * @param conn
     * @return
     */
    private LinkedHashMap<Integer, String> getCatParentesco(Connection conn) {
        LinkedHashMap<Integer, String> catNivelEstudios = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatParentesco);
            while (rs.next()) {
                CatParentesco parentesco = new CatParentesco();
                parentesco.setId(rs.getInt(CatParentesco.COL_ID));
                parentesco.setNombre(rs.getString(CatParentesco.COL_NOMBRE));
                catNivelEstudios.put(parentesco.getId(), parentesco.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
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
     *
     * @param conn Conexion a la base de datos
     * @return Lista de las universidades
     */
    private LinkedHashMap<Integer, String> getCatUniversidades(Connection conn) {
        LinkedHashMap<Integer, String> catUniversidades = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatUniversidades);
            while (rs.next()) {
                CatUniversidad universidad = new CatUniversidad();
                universidad.setId(rs.getInt(CatUniversidad.COL_ID));
                universidad.setNombre(rs.getString(CatUniversidad.COL_NOMBRE));
                catUniversidades.put(universidad.getId(), universidad.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
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
     * Obtiene el catalogo de municipio de estudio
     *
     * @param conn Conexion a la base de datos
     * @return Lista de campos de estudio
     */
    private LinkedHashMap<Integer, String> getCatCampoEstudio(Connection conn) {
        LinkedHashMap<Integer, String> catCampoEstudio = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatCampoEstudio);
            while (rs.next()) {
                CatCampoCarrera campo = new CatCampoCarrera();
                campo.setId(rs.getInt(CatCampoCarrera.COL_ID));
                campo.setNombre(rs.getString(CatCampoCarrera.COL_NOMBRE));
                catCampoEstudio.put(campo.getId(), campo.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
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
     * Obtiene el catalogo de municipio
     * @param conn COneixon a la BD
     * @return Lista con el catalogo de los municipio
     */
    private LinkedHashMap<Integer, String> getCatEstatus(Connection conn) {
        LinkedHashMap<Integer, String> catEstatus = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatEstatus);
            while (rs.next()) {
                CatEstatus estatus = new CatEstatus();
                estatus.setId(rs.getInt(CatEstatus.COL_ID));
                estatus.setNombre(rs.getString(CatEstatus.COL_NOMBRE));
                catEstatus.put(estatus.getId(), estatus.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return catEstatus;
    }
    
    /**
     * Obtiene las categorias de los bancos
     * @param conn COnexion a la base de datos
     * @return 
     */
    private LinkedHashMap<Integer, String> getCatBancos(Connection conn) {
        LinkedHashMap<Integer, String> catBanco = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatBancos);
            while (rs.next()) {
                CatBanco banco = new CatBanco();
                banco.setId(rs.getInt(CatBanco.COL_ID));
                banco.setNombre(rs.getString(CatBanco.COL_NOMBRE));
                catBanco.put(banco.getId(), banco.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return catBanco;
    }

    /**
     * Obtiene las iniciales del programa seleccionado
     *
     * @param programa Id del programa seleccionado
     * @return
     */
    protected String getClavePrograma(int programa) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Conexion conexion = new Conexion();
        String result = "";
        try {
            conn = conexion.estableceConexion();
            st = conn.prepareStatement(Consultas.getInicialesPrograma);
            st.setInt(1, programa);
            rs = st.executeQuery();
            while (rs.next()) {
                result = rs.getString(CatPrograma.COL_INICIALES);
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
            
    /**
     * Obtiene las iniciales del programa seleccionado
     *
     * @return
     */
    protected LinkedHashMap<Integer, String> getCatTipoEscuela(Connection conn) {
        LinkedHashMap<Integer, String> catTipoEscuela = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatTipoEscuela);
            while (rs.next()) {
                CatTipoEscuela tipoEscuela = new CatTipoEscuela();
                tipoEscuela.setId(rs.getInt(CatTipoEscuela.COL_ID));
                tipoEscuela.setNombre(rs.getString(CatTipoEscuela.COL_NOMBRE));
                catTipoEscuela.put(tipoEscuela.getId(), tipoEscuela.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catTipoEscuela;
    }
    
    /**
     * Obtiene las categorias del tipo de servicio social
     * @param conn
     * @return 
     */
    private LinkedHashMap<Integer, String> getCatTipoServicioComunitario(Connection conn){
        LinkedHashMap<Integer, String> catTipoServicioComunitario = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatTipoServicioSocial);
            while (rs.next()) {
                CatTipoServicioSocial tipoEscuela = new CatTipoServicioSocial();
                tipoEscuela.setId(rs.getInt(CatTipoServicioSocial.COL_ID));
                tipoEscuela.setNombre(rs.getString(CatTipoServicioSocial.COL_NOMBRE));
                catTipoServicioComunitario.put(tipoEscuela.getId(), tipoEscuela.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catTipoServicioComunitario;
    }
    
    /**
     * Obtiene la municipio de los lugares donde se puede hacer el servicio social
     * @param conn
     * @return 
     */
    private LinkedHashMap<Integer, String> getCatLugarServicioSocial(Connection conn){
        LinkedHashMap<Integer, String> catLugarServicioComunitario = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatLugarServicioSocial);
            while (rs.next()) {
                CatLugarServicioComunitario tipoEscuela = new CatLugarServicioComunitario();
                tipoEscuela.setId(rs.getInt(CatLugarServicioComunitario.COL_ID));
                tipoEscuela.setNombre(rs.getString(CatLugarServicioComunitario.COL_NOMBRE));
                catLugarServicioComunitario.put(tipoEscuela.getId(), tipoEscuela.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catLugarServicioComunitario;
    }

    /**
     * Obtiene todos los catalogos existentes en la base de datos
     * @param conn
     * @return 
     */
    protected LinkedHashMap<Integer, String> getCatCategorias(Connection conn){
        LinkedHashMap<Integer, String> catCategorias = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatCatalogos);
            while (rs.next()) {
                CatCategorias categoria = new CatCategorias();
                categoria.setId(rs.getInt(CatCategorias.COL_ID));
                categoria.setNombre(rs.getString(CatCategorias.COL_NOMBRE));
                catCategorias.put(categoria.getId(), categoria.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catCategorias;
    }
    
    /**
     * Obtiene la categoría de los municipios del estado de chihuahua
     * @param conn
     * @return 
     */
    protected LinkedHashMap<Integer, String> getCatMunicipios(Connection conn) {
        LinkedHashMap<Integer, String> catCategorias = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCatMunicipios);
            while (rs.next()) {
                CatMunicipios municipio = new CatMunicipios();
                municipio.setId(rs.getInt(CatMunicipios.COL_ID));
                municipio.setNombre(rs.getString(CatMunicipios.COL_NOMBRE));
                catCategorias.put(municipio.getId(), municipio.getNombre());
            }
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return catCategorias;
    }
    
    /**
     * Inserta un nuevo becario en la base de datos
     *
     * @param bandera True es un becario borrador, False es un becario Completo
     * @param conexion Conexion a la base de datos
     * @param becario Becario que se va a insertar en la base de datos
     * @return Id del becario insertado
     */
    protected long insertBecario(boolean bandera, Connection conexion, Becario becario) {
        long idBecario = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {

            ps = conexion.prepareStatement(Insert.insertBecarioBorrador, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, becario.getNombre());
            ps.setString(2, becario.getApPaterno());
            ps.setString(3, becario.getApMaterno());
            ps.setDate(4, becario.getFecha_nac());
            ps.setInt(5, becario.getIdSexo());
            ps.setInt(6, becario.getIdEstadoCivil());
            ps.setInt(7, becario.getTrabaja());
            ps.setString(8, becario.getFoto());
            ps.setString(9, becario.getEmail());
            ps.setInt(10, becario.getPrimeroConBeca());
            ps.setString(11, becario.getNombreConyuge());
            ps.setString(12, becario.getApPaternoConyuge());
            ps.setString(13, becario.getApMaternoConyuge());
            ps.setString(14, becario.getTelefonoConyuge());
            ps.setString(15, becario.getObservaciones());
            ps.setString(16, becario.getActaNacimiento());
            ps.setString(17, becario.getSolicitudBeca());
            ps.setString(18, becario.getEnsayo());
            ps.setString(19, becario.getBoletaInicioBeca());
            ps.setBoolean(20, bandera);
            ps.setString(21, becario.getContatoBeca());
            ps.setString(22, becario.getIdentificacion());
            ps.setString(23, becario.getFolio());
            ps.setInt(24, becario.getIdEstatus());
            ps.setString(25, becario.getPagare());
            ps.setString(26, becario.getOcupacionConyuge());
            ps.setInt(27, becario.getIdPrograma());
            ps.setString(28, becario.getEstudioSocioEconomico());
            ps.setString(29, becario.getCartaAsignacionBeca());
            ps.setString(30, becario.getCartaAgradecimiento());
            
            
            int i = ps.executeUpdate();
            if (i == 0) {
                throw new SQLException("No se pudo insertar al nuevo becario: " + ps.toString());
            }

            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                idBecario = rs.getLong(1);
            }

        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                muestraErrores(e);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            muestraErrores(e);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idBecario;
    }

    public String creaFolio(Connection conexion, Becario becario) {
        long contador = 0;
        String folio = "";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(Consultas.getContadorFolio);
            ps.setInt(1, becario.getIdPrograma());
            rs = ps.executeQuery();
            while (rs.next()) {
                contador = rs.getLong(CatPrograma.COL_CONTADOR);
            }
            if (contador == 0) {
                throw new SQLException("No se pudo obtener el contador del programa");
            }

            folio = helper.creaFolio(becario.getInicialesFolio(), contador);
        } catch (SQLException e) {
            muestraErrores(e);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return folio;
    }

    /**
     * Inserta las direcciones del becario
     *
     * @param conexion Conexion a la base de datos
     * @param idBecario Id del becario
     * @param lstTelefonosBecario Lista de direcciones
     * @return True si operacion exitosa, False si no
     */
    protected boolean insertDireccionBecario(Connection conexion, long idBecario, List<Direccion> lstTelefonosBecario) {
        boolean response = false;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        try {
            for (Direccion direccion : lstTelefonosBecario) {
                ps = conexion.prepareStatement(Insert.insertDireccionBecario);
                ps.setString(1, direccion.getCalle());
                ps.setString(2, direccion.getNumExt());
                ps.setString(3, direccion.getNumInt());
                ps.setString(4, direccion.getColonia());
                ps.setInt(5, direccion.getCodigoPostal());
                ps.setString(6, direccion.getCiudad());
                ps.setLong(7, idBecario);
                int i = ps.executeUpdate();
                if (i == 0) {
                    throw new SQLException("Error al insertar direccion becario: " + ps.toString());
                }
            }

            response = true;

        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            muestraErrores(e);
        } finally {
            try {
                //rs.close();
                ps.close();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return response;
    }

    /**
     * Inserta los telefonos del nuevo becario
     *
     * @param conexion Conexion a la base de datos
     * @param idBecario id del becario
     * @param lstTelefonosBecario Lista de telefonos
     * @return True si la operacion exitosa, False si no
     */
    protected boolean insertTelefonoBecario(Connection conexion, long idBecario, List<Telefono> lstTelefonosBecario) {
        boolean response = false;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        try {
            for (Telefono telefono : lstTelefonosBecario) {
                ps = conexion.prepareStatement(Insert.insertTelefonoBecario);
                ps.setString(1, telefono.getTelefono());
                ps.setLong(2, idBecario);
                int i = ps.executeUpdate();
                if (i == 0) {
                    throw new SQLException("Error al insertar telefono becario: " + ps.toString());
                }
            }

            response = true;

        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            muestraErrores(e);
        } finally {
            try {
                //rs.close();
                if(ps != null)
                    ps.close();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return response;
    }

    /**
     * Inserta los padres del becario
     *
     * @param conexion Conexion a la base de datos
     * @param idBecario id del becario
     * @param lstPadresBecario lista de los padres del becario
     * @return
     */
    protected boolean insertPapasBecario(Connection conexion, long idBecario, List<Padres> lstPadresBecario) {
        boolean response = false;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        try {
            for (Padres papa : lstPadresBecario) {
                ps = conexion.prepareStatement(Insert.insertPadresBecario);
                ps.setString(1, papa.getNombre());
                ps.setString(2, papa.getaPaterno());
                ps.setString(3, papa.getaMaterno());
                ps.setString(4, papa.getTelefono());
                ps.setInt(5, papa.getGradoEscolar());
                ps.setInt(6, papa.getTrabaja());
                ps.setLong(7, idBecario);
                ps.setInt(8, papa.getParenteco());
                ps.setString(9, papa.getOcupacion());
                int i = ps.executeUpdate();
                if (i == 0) {
                    throw new SQLException("Error al insertar padres becario: " + ps.toString());
                }
            }

            response = true;

        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            muestraErrores(e);
        } finally {
            try {
                //rs.close();
                ps.close();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return response;
    }

    /**
     * Inserta los aval del becario
     *
     * @param conexion Conexion a la base de datos
     * @param idBecario Id del becario
     * @param lstHermanos Lista de aval
     * @return
     */
    protected boolean insertHermanosBecario(Connection conexion, long idBecario, List<Hermanos> lstHermanos) {
        boolean response = false;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        try {
            for (Hermanos hermano : lstHermanos) {
                ps = conexion.prepareStatement(Insert.insertHermanoBecario);
                ps.setString(1, hermano.getNombre());
                ps.setString(2, hermano.getAPaterno());
                ps.setString(3, hermano.getAMaterno());
                ps.setInt(4, hermano.getGradoEscolar());
                ps.setLong(5, idBecario);
                ps.setString(6, hermano.getComentario());
                int i = ps.executeUpdate();
                if (i == 0) {
                    throw new SQLException("Error al insertar hermanos becario: " + ps.toString());
                }
            }
            response = true;
        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            muestraErrores(e);
        } finally {
            try {
                //rs.close();
                ps.close();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return response;
    }

    /**
     * Inserta los aval del becario
     * @param conexion Conexion a la base de datos
     * @param idBecario Id del becario
     * @param lstHijos Lista de aval del becario
     * @return True si la operacion correcta, False si no
     */
    protected boolean insertHijosBecario(Connection conexion, long idBecario, List<Hijos> lstHijos) {
        boolean response = false;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        try {
            for (Hijos hijo : lstHijos) {
                ps = conexion.prepareStatement(Insert.insertHijoBecario);
                ps.setString(1, hijo.getNombre());
                ps.setString(2, hijo.getAPaterno());
                ps.setString(3, hijo.getAMaterno());
                ps.setDate(4, hijo.getFechaNac());
                ps.setLong(5, idBecario);
                int i = ps.executeUpdate();
                if (i == 0) {
                    throw new SQLException("Error al insertar hijos becario: " + ps.toString());
                }
            }
            response = true;
        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            muestraErrores(e);
        } finally {
            try {
                //rs.close();
                ps.close();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return response;
    }

    boolean updateContadorPrograma(Connection conexion, String inicialesFolio) {
        boolean response = false;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        try {
            
            ps = conexion.prepareStatement(Update.updateContadorPrograma);
            ps.setString(1, inicialesFolio);
            int i = ps.executeUpdate();
            if (i == 0) {
                throw new SQLException("Error al insertar hijos becario: " + ps.toString());
            }
            
            response = true;
        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            muestraErrores(e);
        } finally {
            try {
                //rs.close();
                ps.close();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return response;
    }

    /**
     * Insera los datos escolates del registro del becario
     * @param conexion
     * @param idBecario
     * @param lstDatosEscolares
     * @return 
     */
    boolean insertDatosEscolaresBecario(Connection conexion, long idBecario, DatosEscolares lstDatosEscolares) {
        boolean response = false;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        try {
            
                ps = conexion.prepareStatement(Insert.insertDatosEscolares);
                ps.setString(1, lstDatosEscolares.getEscuelaProcedencia());
                ps.setInt(2, lstDatosEscolares.getIdUniversidad());
                ps.setInt(3, lstDatosEscolares.getIdCampoCarrera());
                ps.setString(4, lstDatosEscolares.getNombreCarrera());
                ps.setInt(5, lstDatosEscolares.getMesInicioBeca());
                ps.setInt(6, lstDatosEscolares.getAnioInicioBeca());
                ps.setInt(7, lstDatosEscolares.getMesGraduacion());
                ps.setInt(8, lstDatosEscolares.getAnioGraduacion());
                ps.setInt(9, lstDatosEscolares.getSemestresTotalesCarrera());
                ps.setInt(10, lstDatosEscolares.getSemestreInicioBeca());
                ps.setFloat(11, lstDatosEscolares.getCostoCarrera());
                ps.setFloat(12, lstDatosEscolares.getBecaTotal());
                ps.setFloat(13, lstDatosEscolares.getBecaSemestral());
                ps.setInt(14, lstDatosEscolares.getCondicionado());
                ps.setLong(15, idBecario);
                ps.setInt(16, lstDatosEscolares.getIdTipoEscuela());
                
                int i = ps.executeUpdate();
                if (i == 0) {
                    throw new SQLException("Error al insertar los datos escolares del becario: " + ps.toString());
                }
            
            response = true;
        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            muestraErrores(e);
        } finally {
            try {
                //rs.close();
                ps.close();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return response;
    }

    /**
     * Inserta el aval del registro del becario
     * @param conexion
     * @param idBecario
     * @param lstAval
     * @return 
     */
    boolean insertAval(Connection conexion, long idBecario, Aval lstAval) {
        boolean response = false;
        PreparedStatement ps = null;
        //ResultSet rs = null;
        try {
            
            ps = conexion.prepareStatement(Insert.insertAvalDeFormulario);
            ps.setString(1, lstAval.getIdentificacion());
            ps.setLong(2, idBecario);
            int i = ps.executeUpdate();
            if (i == 0) {
                throw new SQLException("Error al insertar el aval del becario: " + ps.toString());
            }
            
            response = true;
        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
            muestraErrores(e);
        } finally {
            try {
                //rs.close();
                ps.close();
            } catch (SQLException ex) {
                muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return response;
    }

    /**
     * Actualiza los datos generales del becario
     * @param conexion COnexion a la base de datos
     * @param becario Becario a actualizar
     * @return True si actualizacion exitosa, False si no
     */
    protected boolean updateBecario(Connection conexion, Becario becario) {
        boolean response = false;
        PreparedStatement ps = null;
        int valor = 0;
        
        try{
            ps = conexion.prepareStatement(Update.updateBecario);
            ps.setString(1, becario.getNombre() );
            ps.setString(2, becario.getApPaterno());
            ps.setString(3, becario.getApMaterno());
            ps.setDate(4, becario.getFecha_nac());
            ps.setInt(5, becario.getIdSexo());
            ps.setInt(6, becario.getIdEstadoCivil());
            ps.setInt(7, becario.getTrabaja());
            ps.setInt(8, becario.getIdEstatus());
            ps.setString(9, becario.getFoto());
            ps.setString(10, becario.getEmail());
            ps.setInt(11, becario.getPrimeroConBeca());
            ps.setString(12, becario.getNombreConyuge());
            ps.setString(13, becario.getApPaternoConyuge());
            ps.setString(14, becario.getApMaternoConyuge());
            ps.setString(15, becario.getTelefonoConyuge());
            ps.setString(16, becario.getObservaciones());
            ps.setString(17, becario.getActaNacimiento());
            ps.setString(18, becario.getSolicitudBeca());
            ps.setString(19, becario.getContatoBeca());
            ps.setString(20, becario.getIdentificacion());
            ps.setString(21, becario.getFolio());
            ps.setString(22, becario.getOcupacionConyuge());
            ps.setString(23, becario.getEstudioSocioEconomico());
            ps.setString(24, becario.getCartaAsignacionBeca());
            ps.setInt(25, becario.getIdPrograma());
            ps.setString(26, becario.getEnsayo());
            ps.setString(27, becario.getBoletaInicioBeca());
            ps.setString(28, becario.getPagare());
            ps.setString(29, becario.getCartaAgradecimiento());
            ps.setString(30, becario.getFolio());
            valor = ps.executeUpdate();
            
            if(valor == 0){
                throw new SQLException("No se pudo actualizar el becario");
            }
            response = true;
            
        }
        catch(SQLException e){
            log.muestraErrores(e);
            System.err.println("Error: " + e);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                log.muestraErrores(ex);
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return response;
    }

    /**
     * Actualiza o inserta las direcciones del becario
     * @param conexion
     * @param idBecario
     * @param lstDireccionesBecario
     * @return True si operacion exitosa, False si no
     */
    protected boolean updateDireccionBecario(Connection conexion, long idBecario, List<Direccion> lstDireccionesBecario) {
        boolean response = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            //Se verifica si existen más direcciones que las que se van a actualizar
            ps = conexion.prepareStatement(Consultas.getDireccionesBecario);
            ps.setLong(1, idBecario);
            rs = ps.executeQuery();
            int direcciones = -1;
            List<Integer> lstIdDirecciones = new ArrayList <>();
            if(rs.next()){
                direcciones = rs.getInt(1);
            }
            
            ps = conexion.prepareStatement(Consultas.getDatosDireccionesBecario);
            ps.setLong(1, idBecario);
            rs = ps.executeQuery();
            while(rs.next()){
                lstIdDirecciones.add(rs.getInt(Direccion.COL_ID));
            }
            
            if(direcciones == -1)
                throw new SQLException("No se pudo obtener las direcciones del becario");
            
            //Si no se tienen direcciones registradas se insertan las nuevas direcciones
            if(direcciones == 0){
                response = insertDireccionBecario(conexion, idBecario, lstDireccionesBecario);
            }
            
            
            //Si existe una sola hijo registrada, se actualiza la primera y la segunda se inserta
            else if(direcciones > 0 && direcciones < lstDireccionesBecario.size()){
                ps = conexion.prepareStatement(Update.updateDireccionesBecario);
                ps.setString(1, lstDireccionesBecario.get(0).getCalle());
                ps.setString(2, lstDireccionesBecario.get(0).getNumExt());
                ps.setString(3, lstDireccionesBecario.get(0).getNumInt());
                ps.setString(4, lstDireccionesBecario.get(0).getColonia());
                ps.setInt(5, lstDireccionesBecario.get(0).getCodigoPostal());
                ps.setString(6, lstDireccionesBecario.get(0).getCiudad());
                ps.setLong(7, idBecario);
                ps.setLong(8, lstIdDirecciones.get(0));
                int resp = ps.executeUpdate();
                //Si la actualizacion fue correcta
                if(resp >= 1){
                    List<Direccion> nuevaLista = new ArrayList<>();
                    nuevaLista.add(lstDireccionesBecario.get(1));
                    response = insertDireccionBecario(conexion, idBecario, nuevaLista);
                }
            }
            //Si existen la misma cantidad de registros con la misma cantidad de nuevas direcciones
            else if(direcciones > 0 && direcciones == lstDireccionesBecario.size()){
                int contador = 0;
                for (Direccion direccion : lstDireccionesBecario) {
                    ps = conexion.prepareStatement(Update.updateDireccionesBecario);
                    ps.setString(1, direccion.getCalle());
                    ps.setString(2, direccion.getNumExt());
                    ps.setString(3, direccion.getNumInt());
                    ps.setString(4, direccion.getColonia());
                    ps.setInt(5, direccion.getCodigoPostal());
                    ps.setString(6, direccion.getCiudad());
                    ps.setLong(7, idBecario);
                    ps.setLong(8, lstIdDirecciones.get(contador));
                    int resp = ps.executeUpdate();
                    //Si la actualizacion fue correcta
                    if(resp == 0)
                        break;
                    contador++;
                    //Si ya se actualizo el ultimo registro
                    if(contador == 1)
                        response = true;
                }
            }      
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
        }
        
        return response;
    }

    /**
     * Obtiene el id del becario a modificar, borrar o eliminar a partir de un número de folio
     * @param conexion Conexion a la base de datos
     * @param folio Folio del becario
     * @return Id del becario a modificar, borrar o eliminar
     */
    protected long getIdBecarioPorFolio(Connection conexion, String folio) {
        long id = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conexion.prepareStatement(Consultas.getIdBecarioPorFolio);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            
            if(rs.next())
                id = rs.getLong(Becario.COL_ID);
            
            if(id == 0)
                throw new SQLException("Noo se encontró el id del becario a partir de su folio");
            
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
        }
        
        return id;
    }

    /**
     * Actualiza los telefonos del becario
     * @param conexion
     * @param idBecario
     * @param lstTelefonosBecario
     * @return 
     */
    protected boolean updateTelefonoBecario(Connection conexion, long idBecario, List<Telefono> lstTelefonosBecario) {
        boolean response = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            //Se verifica si existen más direcciones que las que se van a actualizar
            ps = conexion.prepareStatement(Consultas.getTelefonosBecario);
            ps.setLong(1, idBecario);
            rs = ps.executeQuery();
            int telefonos = -1;
            List<Integer> lstIdTelefonos = new ArrayList <>();
            while(rs.next()){
                telefonos = rs.getInt(1);
            }
            
            //Se obtienen los id's de los telefonos
            ps = conexion.prepareStatement(Consultas.getDatosTelefonosBecario);
            ps.setLong(1, idBecario);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lstIdTelefonos.add(rs.getInt(Telefono.COL_ID));
            }
            
            if(telefonos == -1)
                throw new SQLException("No se pudo obtener los teléfonos del becario");
            
            //Si no se tienen telefonos registrados se insertan las nuevas telefonos
            if(telefonos == 0){
                response = insertTelefonoBecario(conexion, idBecario, lstTelefonosBecario);
            }
            
            
            //Si existe una sola hijo registrado, se actualiza el primero y el segundo se inserta
            else if(telefonos > 0 && telefonos < lstTelefonosBecario.size()){
                ps = conexion.prepareStatement(Update.updateTelefonosBecario);
                ps.setString(1, lstTelefonosBecario.get(0).getTelefono());
                ps.setLong(2, idBecario);
                ps.setLong(3, lstIdTelefonos.get(0));
                int resp = ps.executeUpdate();
                //Si la actualizacion fue correcta
                if(resp >= 1){
                    List<Telefono> nuevaLista = new ArrayList<>();
                    nuevaLista.add(lstTelefonosBecario.get(1));
                    response = insertTelefonoBecario(conexion, idBecario, nuevaLista);
                }
            }
            //Si existen la misma cantidad de registros con la misma cantidad de nuevas direcciones
            else if(telefonos > 0 && telefonos == lstTelefonosBecario.size()){
                int contador = 0;
                for (Telefono telefono : lstTelefonosBecario) {
                    ps = conexion.prepareStatement(Update.updateTelefonosBecario);
                    ps.setString(1, telefono.getTelefono());
                    ps.setLong(2, idBecario);
                    ps.setLong(3, lstIdTelefonos.get(contador));
                    int resp = ps.executeUpdate();
                    //Si la actualizacion fue correcta
                    if(resp == 0)
                        break;
                    contador++;
                    //Si ya se actualizo el ultimo registro
                    if(contador == lstTelefonosBecario.size())
                        response = true;
                }
            }      
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
        }
        
        return response;
    }

    /**
     * Actualiza los papás del becario
     * @param conexion
     * @param idBecario
     * @param lstPadresBecario
     * @return 
     */
    protected boolean updatePapasBecario(Connection conexion, long idBecario, List<Padres> lstPadresBecario) {
        boolean response = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            //Se verifica si existen más direcciones que las que se van a actualizar
            ps = conexion.prepareStatement(Consultas.getPapasBecario);
            ps.setLong(1, idBecario);
            rs = ps.executeQuery();
            int papas = -1;
            List<Integer> lstIdPapas= new ArrayList <>();
            while(rs.next()){
                papas = rs.getInt(1);
            }
            
            //Se obtienen los id de los papas
            ps = conexion.prepareStatement(Consultas.getDatosPapasBecario);
            ps.setLong(1, idBecario);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lstIdPapas.add(rs.getInt(Padres.COL_ID));
            }
            
            if(papas == -1)
                throw new SQLException("No se pudo obtener los padres del becario");
            
            //Si no se tienen telefonos registrados se insertan las nuevas telefonos
            if(papas == 0){
                response = insertPapasBecario(conexion, idBecario, lstPadresBecario);
            }
            
            
            //Si existe una sola hijo registrado, se actualiza el primero y el segundo se inserta
            else if(papas > 0 && papas < lstPadresBecario.size()){
                ps = conexion.prepareStatement(Update.updatePapasBecario);
                ps.setString(1, lstPadresBecario.get(0).getNombre());
                ps.setString(2, lstPadresBecario.get(0).getaPaterno());
                ps.setString(3, lstPadresBecario.get(0).getaMaterno());
                ps.setString(4, lstPadresBecario.get(0).getTelefono());
                ps.setInt(5, lstPadresBecario.get(0).getGradoEscolar());
                ps.setInt(6, lstPadresBecario.get(0).getTrabaja());
                ps.setInt(7, lstPadresBecario.get(0).getParenteco());
                ps.setString(8, lstPadresBecario.get(0).getOcupacion());
                ps.setString(9, lstPadresBecario.get(0).getTelefono());
                ps.setLong(10, idBecario);
                ps.setLong(11, lstIdPapas.get(0));
                int resp = ps.executeUpdate();
                //Si la actualizacion fue correcta
                if(resp >= 1){
                    List<Padres> nuevaLista = new ArrayList<>();
                    nuevaLista.add(lstPadresBecario.get(1));
                    response = insertPapasBecario(conexion, idBecario, nuevaLista);
                }
            }
            //Si existen la misma cantidad de registros con la misma cantidad de nuevas direcciones
            else if(papas > 0 && papas == lstPadresBecario.size()){
                int contador = 0;
                for (Padres papa : lstPadresBecario) {
                    ps = conexion.prepareStatement(Update.updatePapasBecario);
                    ps.setString(1, papa.getNombre());
                    ps.setString(2, papa.getaPaterno());
                    ps.setString(3, papa.getaMaterno());
                    ps.setString(4, papa.getTelefono());
                    ps.setInt(5, papa.getGradoEscolar());
                    ps.setInt(6, papa.getTrabaja());
                    ps.setInt(7, papa.getParenteco());
                    ps.setString(8, papa.getOcupacion());
                    ps.setString(9, papa.getTelefono());
                    ps.setLong(10, idBecario);
                    ps.setLong(11, lstIdPapas.get(contador));
                    int resp = ps.executeUpdate();
                    //Si la actualizacion fue correcta
                    if(resp == 0)
                        break;
                    contador++;
                    //Si ya se actualizo el ultimo registro
                    if(contador == lstPadresBecario.size())
                        response = true;
                }
            }      
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
        }
        
        return response;
    }

    /**
     * Actualiza los aval del becario
     * @param conexion
     * @param idBecario
     * @param lstHermanos
     * @return 
     */
    protected boolean updateHermanosBecario(Connection conexion, long idBecario, List<Hermanos> lstHermanos) {
        boolean response = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            //Se verifica si existen más direcciones que las que se van a actualizar
            ps = conexion.prepareStatement(Consultas.getHermanosBecario);
            ps.setLong(1, idBecario);
            rs = ps.executeQuery();
            int hermanos = -1;
            List<Integer> lstIdHermanos= new ArrayList <>();
            while(rs.next()){
                hermanos = rs.getInt(1);
            }
            
            //Se obtienen los ids de los hermanos
            ps = conexion.prepareStatement(Consultas.getDatosHermanosBecario);
            ps.setLong(1, idBecario);
            rs = ps.executeQuery();
            while(rs.next()){
                lstIdHermanos.add(rs.getInt(Hermanos.COL_ID));
            }
            
            if(hermanos == -1)
                throw new SQLException("No se pudo obtener los hermanos del becario");
            
            //Si no se tienen telefonos registrados se insertan las nuevas telefonos
            if(hermanos == 0){
                response = insertHermanosBecario(conexion, idBecario, lstHermanos);
            }
            
            
            //Si existe una sola hijo registrado, se actualiza el primero y el segundo se inserta
            else if(hermanos > 0 && hermanos < lstHermanos.size()){
                ps = conexion.prepareStatement(Update.updateHermanosBecario);
                ps.setString(1, lstHermanos.get(0).getNombre());
                ps.setString(2, lstHermanos.get(0).getAPaterno());
                ps.setString(3, lstHermanos.get(0).getAMaterno());
                ps.setInt(4, lstHermanos.get(0).getGradoEscolar());
                ps.setString(5, lstHermanos.get(0).getComentario());
                ps.setLong(6, idBecario);
                ps.setLong(7, lstIdHermanos.get(0));
                int resp = ps.executeUpdate();
                //Si la actualizacion fue correcta
                if(resp >= 1){
                    List<Hermanos> nuevaLista = new ArrayList<>();
                    nuevaLista.add(lstHermanos.get(1));
                    response = insertHermanosBecario(conexion, idBecario, nuevaLista);
                }
            }
            //Si existen la misma cantidad de registros con la misma cantidad de nuevas direcciones
            else if(hermanos > 0 && hermanos == lstHermanos.size()){
                int contador = 0;
                for (Hermanos hermano : lstHermanos) {
                    ps = conexion.prepareStatement(Update.updateHermanosBecario);
                    ps.setString(1, hermano.getNombre());
                    ps.setString(2, hermano.getAPaterno());
                    ps.setString(3, hermano.getAMaterno());
                    ps.setInt(4, hermano.getGradoEscolar());
                    ps.setString(5, hermano.getComentario());
                    ps.setLong(6, idBecario);
                    ps.setLong(7, lstIdHermanos.get(contador));
                    int resp = ps.executeUpdate();
                    //Si la actualizacion fue correcta
                    if(resp == 0)
                        break;
                    contador++;
                    //Si ya se actualizo el ultimo registro
                    if(contador == lstHermanos.size())
                        response = true;
                }
            }      
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
        }
        
        return response;
    }

    /**
     * Actualiza los aval del becario
     * @param conexion
     * @param idBecario
     * @param lstHijos
     * @return True si exito, False si Error
     */
    protected boolean updateHijosBecario(Connection conexion, long idBecario, List<Hijos> lstHijos) {
        boolean response = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            //Se verifica si existen más direcciones que las que se van a actualizar
            ps = conexion.prepareStatement(Consultas.getHijosBecario);
            ps.setLong(1, idBecario);
            rs = ps.executeQuery();
            int hijos = -1;
            List<Integer> lstIdHijos= new ArrayList <>();
            while(rs.next()){
                hijos = rs.getInt(1);
            }
            
            //Se obtienen los ids de los hijos
            ps = conexion.prepareStatement(Consultas.getHijosBecario);
            ps.setLong(1, idBecario);
            rs = ps.executeQuery();
            while(rs.next()){
                lstIdHijos.add(rs.getInt(Hijos.COL_ID));
            }
            
            if(hijos == -1)
                throw new SQLException("No se pudo obtener los hijos del becario");
            
            //Si no se tienen telefonos registrados se insertan las nuevas telefonos
            if(hijos == 0){
                response = insertHijosBecario(conexion, idBecario, lstHijos);
            }
            
            
            //Si existe una sola hijo registrado, se actualiza el primero y el segundo se inserta
            else if(hijos > 0 && hijos < lstHijos.size()){
                ps = conexion.prepareStatement(Update.updateHijosBecario);
                ps.setString(1, lstHijos.get(0).getNombre());
                ps.setString(2, lstHijos.get(0).getAPaterno());
                ps.setString(3, lstHijos.get(0).getAMaterno());
                ps.setDate(4, lstHijos.get(0).getFechaNac());
                ps.setLong(5, idBecario);
                ps.setLong(6, lstIdHijos.get(0));
                int resp = ps.executeUpdate();
                //Si la actualizacion fue correcta
                if(resp >= 1){
                    List<Hijos> nuevaLista = new ArrayList<>();
                    nuevaLista.add(lstHijos.get(1));
                    response = insertHijosBecario(conexion, idBecario, nuevaLista);
                }
            }
            //Si existen la misma cantidad de registros con la misma cantidad de nuevas direcciones
            else if(hijos > 0 && hijos == lstHijos.size()){
                int contador = 0;
                for (Hijos hijo : lstHijos) {
                    ps = conexion.prepareStatement(Update.updateHijosBecario);
                    ps.setString(1, hijo.getNombre());
                    ps.setString(2, hijo.getAPaterno());
                    ps.setString(3, hijo.getAMaterno());
                    ps.setDate(4, hijo.getFechaNac());
                    ps.setLong(5, idBecario);
                    ps.setLong(6, lstIdHijos.get(contador));
                    int resp = ps.executeUpdate();
                    //Si la actualizacion fue correcta
                    if(resp == 0)
                        break;
                    contador++;
                    //Si ya se actualizo el ultimo registro
                    if(contador == 1)
                        response = true;
                }
            }      
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
        }
        
        return response;
    }

    /**
     * Actualiza los datos escolares del becario
     * @param conexion
     * @param idBecario
     * @param lstDatosEscolares
     * @return True si correcto, False si error
     */
    protected boolean updateDatosEscolares(Connection conexion, long idBecario, DatosEscolares lstDatosEscolares) {
        boolean response = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{

            ps = conexion.prepareStatement(Update.updateDatosEscolaresBecario);
            ps.setString(1, lstDatosEscolares.getEscuelaProcedencia());
            ps.setInt(2, lstDatosEscolares.getIdUniversidad());
            ps.setInt(3, lstDatosEscolares.getIdCampoCarrera());
            ps.setString(4, lstDatosEscolares.getNombreCarrera());
            ps.setInt(5, lstDatosEscolares.getMesInicioBeca());
            ps.setInt(6, lstDatosEscolares.getAnioInicioBeca());
            ps.setInt(7, lstDatosEscolares.getMesGraduacion());
            ps.setInt(8, lstDatosEscolares.getAnioGraduacion());
            ps.setInt(9, lstDatosEscolares.getSemestresTotalesCarrera());
            ps.setInt(10, lstDatosEscolares.getSemestreInicioBeca());
            ps.setFloat(11, lstDatosEscolares.getCostoCarrera());
            ps.setFloat(12, lstDatosEscolares.getBecaTotal());
            ps.setFloat(13, lstDatosEscolares.getBecaSemestral());
            ps.setInt(14, lstDatosEscolares.getCondicionado());
            ps.setInt(15, lstDatosEscolares.getIdTipoEscuela());
            ps.setLong(16, idBecario);
            int resp = ps.executeUpdate();
            //Si la actualizacion fue correcta
            if(resp == 0)
                throw new SQLException("No se pudo actualizar los datos escolares del becario");
            response = true;
     
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
        }
        
        return response;
    }

    /**
     * Actualiza los datos del aval del becario
     * @param conexion
     * @param idBecario
     * @param lstAval
     * @return True si correcto, False si no
     */
    protected boolean updateAval(Connection conexion, long idBecario, Aval lstAval) {
        boolean response = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{

            ps = conexion.prepareStatement(Update.updateAvalBecario);
            ps.setString(1, lstAval.getaPaterno());
            ps.setString(2, lstAval.getaMaterno());
            ps.setString(3, lstAval.getNombre());
            ps.setString(4, lstAval.getCalle());
            ps.setString(5, lstAval.getNumExt());
            ps.setString(6, lstAval.getNumInt());
            ps.setString(7, lstAval.getColonia());
            ps.setString(8, lstAval.getIdentificacion());
            ps.setLong(9, idBecario);
            int resp = ps.executeUpdate();
            //Si la actualizacion fue correcta
            if(resp == 0)
                throw new SQLException("No se pudo actualizar el aval del becario");
            response = true;
     
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
        }
        
        return response;
    }

    /**
     * Obtiene los becarios por número de folio
     * @param folio Numero de folio
     * @return Becario con la informacion encontrada
     */
    Becario getBecarioPorFolio(Connection conexion, String folio) {
        Becario becario = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            if(conexion == null)
                throw new SQLException("No se pudo conectar a la base de datos, intentelo de nuevo");
            ps = conexion.prepareStatement(Consultas.getBecarioPorFolio);
            ps.setString(1, folio);
            System.out.println("Query: " + ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
                becario = new Becario();
                becario.setId(rs.getLong(Becario.COL_ID));
                becario.setNombre(rs.getString(Becario.COL_NOMBRE));
                becario.setApPaterno(rs.getString(Becario.COL_APATERNO));
                becario.setApMaterno(rs.getString(Becario.COL_AMATERNO));
                becario.setFecha_nac(rs.getDate(Becario.COL_FECHA_NAC));
                becario.setIdSexo(rs.getInt(Becario.COL_SEXO));
                becario.setIdEstadoCivil(rs.getInt(Becario.COL_ESTADO_CIVIL));
                becario.setTrabaja(rs.getInt(Becario.COL_TRABAJA));
                becario.setFolio(rs.getString(Becario.COL_FOLIO));
                becario.setIdPrograma(rs.getInt(Becario.COL_PROGRAMA));
                becario.setIdEstatus(rs.getInt(Becario.COL_ESTATUS));
                becario.setIdTipoEstatus(rs.getInt(Becario.COL_TIPO_ESTATUS));
                becario.setFoto(rs.getString(Becario.COL_FOTO));
                becario.setEmail(rs.getString(Becario.COL_EMAIL));
                becario.setPrimeroConBeca(rs.getInt(Becario.COL_PRIMERO_CON_BECA));
                becario.setNombreConyuge(rs.getString(Becario.COL_NOMBRE_CONYUGE));
                becario.setApPaternoConyuge(rs.getString(Becario.COL_APATERNO_CONYUGE));
                becario.setApMaternoConyuge(rs.getString(Becario.COL_AMATERNO_CONYUGE));
                becario.setTelefonoConyuge(rs.getString(Becario.COL_TELEFONO_CONYUGE));
                becario.setOcupacionConyuge(rs.getString(Becario.COL_OCUPACION_CONYUGE));
                becario.setObservaciones(rs.getString(Becario.COL_OBSERVACIONES));
                becario.setActaNacimiento(rs.getString(Becario.COL_ACTA_NAC));
                becario.setSolicitudBeca(rs.getString(Becario.COL_SOLICITUD_BECA));
                becario.setEnsayo(rs.getString(Becario.COL_ENSAYO));
                becario.setBoletaInicioBeca(rs.getString(Becario.COL_BOLETA_INICIO_BECA));
                becario.setContatoBeca(rs.getString(Becario.COL_CONTRATO_BECA));
                becario.setIdentificacion(rs.getString(Becario.COL_IDENTIFICACION));
                becario.setPagare(rs.getString(Becario.COL_PAGARE));
                becario.setIdBanco(rs.getInt(Becario.COL_ID_BANCO));
                becario.setCuentaBancaria(rs.getString(Becario.COL_CUENTA_BANCO));
                becario.setClabeInterbancaria(rs.getString(Becario.COL_CLABE_INTERBANCARIA));
                becario.setActivo(rs.getInt(Becario.COL_ACTIVO));
                becario.setEstudioSocioEconomico(rs.getString(Becario.COL_ESTUDIO_SOCIOECONOMICO));
                becario.setCartaAsignacionBeca(rs.getString(Becario.COL_CARTA_ASIGNACION_BECA));
                becario.setCartaAgradecimiento(rs.getString(Becario.COL_CARTA_AGRADECIMIENTO));
                becario.setGraduado(rs.getBoolean(Becario.COL_GRADUADO));
            }
            
        } catch (SQLException e) {
            log.muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
            
        }
        
        return becario;
    }
    
    /**
     * Obtiene la informacion de los becarios filtrados por idPrograma y folio
     * @param conexion
     * @param idPrograma
     * @param idEstatus
     * @return Lista de becarios con la informacion de cada uno de ellos
     */
    protected List<Becario> getBecarioPorProgramaEstatus(Connection conexion, int idPrograma, int idEstatus) {
        List<Becario> lstBecario = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            if(conexion == null)
                throw new SQLException("No se pudo conectar a la base de datos, intentelo de nuevo");
            
            if(idPrograma != 10000){
                ps = conexion.prepareStatement(Consultas.getBecarioPorProgramaEstatus);
                ps.setInt(1, idPrograma);
                ps.setInt(2, idEstatus);
            }
            else{
                ps = conexion.prepareStatement(Consultas.getBecariosPorProgramaEstatus);
                ps.setInt(1, idEstatus);
            }
            
            System.out.println("Query: " + ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
                Becario becario = new Becario();
                becario.setId(rs.getLong(Becario.COL_ID));
                becario.setNombre(rs.getString(Becario.COL_NOMBRE));
                becario.setApPaterno(rs.getString(Becario.COL_APATERNO));
                becario.setApMaterno(rs.getString(Becario.COL_AMATERNO));
                becario.setFecha_nac(rs.getDate(Becario.COL_FECHA_NAC));
                becario.setIdSexo(rs.getInt(Becario.COL_SEXO));
                becario.setIdEstadoCivil(rs.getInt(Becario.COL_ESTADO_CIVIL));
                becario.setTrabaja(rs.getInt(Becario.COL_TRABAJA));
                becario.setFolio(rs.getString(Becario.COL_FOLIO));
                becario.setIdPrograma(rs.getInt(Becario.COL_PROGRAMA));
                becario.setIdEstatus(rs.getInt(Becario.COL_ESTATUS));
                becario.setIdTipoEstatus(rs.getInt(Becario.COL_TIPO_ESTATUS));
                becario.setFoto(rs.getString(Becario.COL_FOTO));
                becario.setEmail(rs.getString(Becario.COL_EMAIL));
                becario.setPrimeroConBeca(rs.getInt(Becario.COL_PRIMERO_CON_BECA));
                becario.setNombreConyuge(rs.getString(Becario.COL_NOMBRE_CONYUGE));
                becario.setApPaternoConyuge(rs.getString(Becario.COL_APATERNO_CONYUGE));
                becario.setApMaternoConyuge(rs.getString(Becario.COL_AMATERNO_CONYUGE));
                becario.setTelefonoConyuge(rs.getString(Becario.COL_TELEFONO_CONYUGE));
                becario.setOcupacionConyuge(rs.getString(Becario.COL_OCUPACION_CONYUGE));
                becario.setObservaciones(rs.getString(Becario.COL_OBSERVACIONES));
                becario.setActaNacimiento(rs.getString(Becario.COL_ACTA_NAC));
                becario.setSolicitudBeca(rs.getString(Becario.COL_SOLICITUD_BECA));
                becario.setEnsayo(rs.getString(Becario.COL_ENSAYO));
                becario.setBoletaInicioBeca(rs.getString(Becario.COL_BOLETA_INICIO_BECA));
                becario.setContatoBeca(rs.getString(Becario.COL_CONTRATO_BECA));
                becario.setIdentificacion(rs.getString(Becario.COL_IDENTIFICACION));
                becario.setPagare(rs.getString(Becario.COL_PAGARE));
                becario.setIdBanco(rs.getInt(Becario.COL_ID_BANCO));
                becario.setCuentaBancaria(rs.getString(Becario.COL_CUENTA_BANCO));
                becario.setClabeInterbancaria(rs.getString(Becario.COL_CLABE_INTERBANCARIA));
                becario.setActivo(rs.getInt(Becario.COL_ACTIVO));
                becario.setEstudioSocioEconomico(rs.getString(Becario.COL_ESTUDIO_SOCIOECONOMICO));
                becario.setCartaAsignacionBeca(rs.getString(Becario.COL_CARTA_ASIGNACION_BECA));
                becario.setCartaAgradecimiento(rs.getString(Becario.COL_CARTA_AGRADECIMIENTO));
                becario.setGraduado(rs.getBoolean(Becario.COL_GRADUADO));
                lstBecario.add(becario);
            }
            
        } catch (SQLException e) {
            log.muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
            
        }
        
        return lstBecario;
    }
    
    /**
     * Obtiene una lista de becarios a partir de su nombre y apellido
     * @param conexion
     * @param nombre
     * @param aPaterno
     * @param aMaterno
     * @return Lista de becarios que se parecen segun el nombre y el apellido
     */
    List<Becario> getBecarioPorNombres(Connection conexion, String nombre, String aPaterno, String aMaterno) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Becario> lstBecario = new ArrayList<>();
        try{
            boolean bandera = false;
            String consulta = Consultas.getBecarioPorNombres;
            
            //Se hace la instruccion de WHERE's
            if(!nombre.equals("") && bandera == false){
                consulta = consulta.concat("WHERE becario." + Becario.COL_NOMBRE + " LIKE ? ");
                bandera = true;
            }
            
            
            if(!aPaterno.equals("") && bandera == false){
                consulta = consulta.concat("WHERE becario." + Becario.COL_APATERNO + " LIKE ? ");
                bandera = true;
            }
            else if(!aPaterno.equals("") && bandera == true){
                consulta = consulta.concat("AND becario." + Becario.COL_APATERNO + " LIKE ? ");
            }
            
            if(!aMaterno.equals("") && bandera == false){
                consulta = consulta.concat("WHERE becario." + Becario.COL_AMATERNO + " LIKE ? ");
                bandera = true;
            }
            else if(!aMaterno.equals("") && bandera == true){
                consulta = consulta.concat("AND becario." + Becario.COL_AMATERNO + " LIKE ? ");
            }
            
            if(bandera == false){
                consulta = consulta.concat("WHERE becario." + Becario.COL_ACTIVO + " = 1");
            }
            else{
                consulta = consulta.concat("AND becario." + Becario.COL_ACTIVO + " = 1");
            }
            
            bandera = false;
            
            
            //Se hace la instruccion de ordenacion ORDER BY
            if(!nombre.equals("") && bandera == false){
                consulta = consulta.concat("ORDER BY becario." + Becario.COL_NOMBRE + " ");
                bandera = true;
            }
            
            if(!aPaterno.equals("") && bandera == false){
                consulta = consulta.concat("ORDER BY becario." + Becario.COL_APATERNO + " ");
                bandera = true;
            }
            else if(!aPaterno.equals("") && bandera == true){
                consulta = consulta.concat("AND becario." + Becario.COL_APATERNO + " ");
            }
            
            if(!aMaterno.equals("") && bandera == false){
                consulta = consulta.concat("ORDER BY becario." + Becario.COL_AMATERNO + " ");
                bandera = true;
            }
            else if(!aMaterno.equals("") && bandera == true){
                consulta = consulta.concat("AND becario." + Becario.COL_AMATERNO + " ");
            }
            
            
            //System.out.println("Consulta: " + consulta);
            ps = conexion.prepareStatement(consulta);
            
            //Se hace la instruccion de cambiar parametros
            int i = 1;
            bandera = false;
            if(!nombre.equals("") ){
                ps.setString(i, "%" + nombre + "%");
                i++;
            }
            
            if(!aPaterno.equals("") ){
                ps.setString(i, "%" + aPaterno + "%");
                i++;
            }
            
            if(!aMaterno.equals("") ){
                ps.setString(i, "%" + aMaterno + "%");
                i++;
            }
            System.out.println("Consulta: " + ps);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Becario becario = new Becario();
                becario.setId(rs.getLong(Becario.COL_ID));
                becario.setNombre(rs.getString(Becario.COL_NOMBRE));
                becario.setApPaterno(rs.getString(Becario.COL_APATERNO));
                becario.setApMaterno(rs.getString(Becario.COL_AMATERNO));
                becario.setFecha_nac(rs.getDate(Becario.COL_FECHA_NAC));
                becario.setIdSexo(rs.getInt(Becario.COL_SEXO));
                becario.setIdEstadoCivil(rs.getInt(Becario.COL_ESTADO_CIVIL));
                becario.setTrabaja(rs.getInt(Becario.COL_TRABAJA));
                becario.setFolio(rs.getString(Becario.COL_FOLIO));
                becario.setIdPrograma(rs.getInt(Becario.COL_PROGRAMA));
                becario.setIdEstatus(rs.getInt(Becario.COL_ESTATUS));
                becario.setIdTipoEstatus(rs.getInt(Becario.COL_TIPO_ESTATUS));
                becario.setFoto(rs.getString(Becario.COL_FOTO));
                becario.setEmail(rs.getString(Becario.COL_EMAIL));
                becario.setPrimeroConBeca(rs.getInt(Becario.COL_PRIMERO_CON_BECA));
                becario.setNombreConyuge(rs.getString(Becario.COL_NOMBRE_CONYUGE));
                becario.setApPaternoConyuge(rs.getString(Becario.COL_APATERNO_CONYUGE));
                becario.setApMaternoConyuge(rs.getString(Becario.COL_AMATERNO_CONYUGE));
                becario.setTelefonoConyuge(rs.getString(Becario.COL_TELEFONO_CONYUGE));
                becario.setOcupacionConyuge(rs.getString(Becario.COL_OCUPACION_CONYUGE));
                becario.setObservaciones(rs.getString(Becario.COL_OBSERVACIONES));
                becario.setActaNacimiento(rs.getString(Becario.COL_ACTA_NAC));
                becario.setSolicitudBeca(rs.getString(Becario.COL_SOLICITUD_BECA));
                becario.setEnsayo(rs.getString(Becario.COL_ENSAYO));
                becario.setBoletaInicioBeca(rs.getString(Becario.COL_BOLETA_INICIO_BECA));
                becario.setContatoBeca(rs.getString(Becario.COL_CONTRATO_BECA));
                becario.setIdentificacion(rs.getString(Becario.COL_IDENTIFICACION));
                becario.setPagare(rs.getString(Becario.COL_PAGARE));
                becario.setIdBanco(rs.getInt(Becario.COL_ID_BANCO));
                becario.setCuentaBancaria(rs.getString(Becario.COL_CUENTA_BANCO));
                becario.setClabeInterbancaria(rs.getString(Becario.COL_CLABE_INTERBANCARIA));
                becario.setGraduado(rs.getBoolean(Becario.COL_GRADUADO));
                lstBecario.add(becario);
            }
        } catch (SQLException e) {
            log.muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
            
        }
        
        return lstBecario;
    }

    /**
     * Obtiene las direcciones del becario por ID del mismo
     * @param conexion
     * @param id Id del becario
     * @return Lista de direcciones del becario
     */
    protected List<Direccion> getDireccionesBecario(Connection conexion, long id) {
        List<Direccion> lstDirecciones = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            if(conexion == null)
                throw new SQLException("No se pudo conectar a la base de datos, intentelo de nuevo");
            
            ps = conexion.prepareStatement(Consultas.getDatosDireccionesBecario);
            ps.setLong(1, id);
            System.out.println("Query: " + ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
               Direccion direccion = new Direccion();
               direccion.setCalle(rs.getString(Direccion.COL_CALLE));
               direccion.setNumExt(rs.getString(Direccion.COL_NUM_EXT));
               direccion.setNumInt(rs.getString(Direccion.COL_NUM_INT));
               direccion.setColonia(rs.getString(Direccion.COL_COLONIA));
               direccion.setCodigoPostal(rs.getInt(Direccion.COL_CODIGO_POSTAL));
               direccion.setCiudad(rs.getString(Direccion.COL_CIUDAD));
               direccion.setId(rs.getLong(Direccion.COL_ID));
               direccion.setIdBecario(id);
               lstDirecciones.add(direccion);
            }
        } catch (SQLException e) {
            log.muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
            
        }
        
        return lstDirecciones;
        
    }

    /**
     * Obtiene los telefonos del becario
     * @param conexion
     * @param id
     * @return 
     */
    protected List<Telefono> getTelefonosBecario(Connection conexion, long id) {
        List<Telefono> lstTelefonos = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            if(conexion == null)
                throw new SQLException("No se pudo conectar a la base de datos, intentelo de nuevo");
            
            ps = conexion.prepareStatement(Consultas.getDatosTelefonosBecario);
            ps.setLong(1, id);
            System.out.println("Query: " + ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
               Telefono telefono = new Telefono();
               telefono.setTelefono(rs.getString(Telefono.COL_TELEFONO));
               telefono.setId(rs.getLong(Telefono.COL_ID));
               telefono.setIdBecario(id);
               lstTelefonos.add(telefono);
            }
        } catch (SQLException e) {
            log.muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
            
        }
        
        return lstTelefonos;
    }

    /**
     * OBtiene los padres del becario
     * @param conexion
     * @param id
     * @return 
     */
    protected List<Padres> getPadresBecario(Connection conexion, long id) {
        List<Padres> lstPadres = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            if(conexion == null)
                throw new SQLException("No se pudo conectar a la base de datos, intentelo de nuevo");
            
            ps = conexion.prepareStatement(Consultas.getDatosPapasBecario);
            ps.setLong(1, id);
            System.out.println("Query: " + ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
               Padres padre = new Padres();
               padre.setTelefono(rs.getString(Padres.COL_TELEFONO));
               padre.setId(rs.getLong(Padres.COL_ID));
               padre.setGradoEscolar(rs.getInt(Padres.COL_ID_GRADO_ESCOLAR));
               padre.setNombre(rs.getString(Padres.COL_NOMBRE));
               padre.setParenteco(rs.getInt(Padres.COL_ID_PARENTESCO));
               padre.setTelefono(rs.getString(Padres.COL_TELEFONO));
               padre.setTrabaja(rs.getInt(Padres.COL_TRABAJA));
               padre.setaMaterno(rs.getString(Padres.COL_AMATERNO));
               padre.setaPaterno(rs.getString(Padres.COL_APATERNO));
               padre.setOcupacion(rs.getString(Padres.COL_OCUPACION));
               padre.setIdBecario(id);
               lstPadres.add(padre);
            }
        } catch (SQLException e) {
            log.muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
            
        }
        
        return lstPadres;
    }

    /**
     * Obtiene los hermanos de un becario
     * @param conexion
     * @param id
     * @return 
     */
    protected List<Hermanos> getHermanosBecario(Connection conexion, long id) {
        List<Hermanos> lstHermanos = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            if(conexion == null)
                throw new SQLException("No se pudo conectar a la base de datos, intentelo de nuevo");
            
            ps = conexion.prepareStatement(Consultas.getDatosHermanosBecario);
            ps.setLong(1, id);
            System.out.println("Query: " + ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
               Hermanos hermano = new Hermanos();
               hermano.setId(rs.getLong(Hermanos.COL_ID));
               hermano.setNombre(rs.getString(Hermanos.COL_NOMBRE));
               hermano.setAMaterno(rs.getString(Hermanos.COL_AMATERNO));
               hermano.setAPaterno(rs.getString(Hermanos.COL_APATERNO));
               hermano.setGradoEscolar(rs.getInt(Hermanos.COL_ID_GRADO_ESCOLAR));
               hermano.setComentario(rs.getString(Hermanos.COL_COMENTARIOS));
               hermano.setIdBecario(id);
               lstHermanos.add(hermano);
            }
        } catch (SQLException e) {
            log.muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
            
        }
        
        return lstHermanos;
    }

    protected List<Hijos> getHijosBecario(Connection conexion, long id) {
        List<Hijos> lstHijos = new ArrayList<>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            if(conexion == null)
                throw new SQLException("No se pudo conectar a la base de datos, intentelo de nuevo");
            
            ps = conexion.prepareStatement(Consultas.getDatosHijosBecario);
            ps.setLong(1, id);
            System.out.println("Query: " + ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
               Hijos hijo = new Hijos();
               hijo.setId(rs.getLong(Hijos.COL_ID));
               hijo.setNombre(rs.getString(Hijos.COL_NOMBRE));
               hijo.setAMaterno(rs.getString(Hijos.COL_AMATERNO));
               hijo.setAPaterno(rs.getString(Hijos.COL_APATERNO));
               hijo.setFechaNac(rs.getDate(Hijos.COL_FECHA_NAC));
               hijo.setIdBecario(id);
               lstHijos.add(hijo);
            }
        } catch (SQLException e) {
            log.muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
            
        }
        
        return lstHijos;
    }

    /**
     * Obtiene los datos escolares de un becario
     * @param conexion
     * @param idBecario
     * @return 
     */
    protected DatosEscolares getDatosEscolaresBecario(Connection conexion, long idBecario) {
        DatosEscolares datosEscolares = new DatosEscolares();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            if(conexion == null)
                throw new SQLException("No se pudo conectar a la base de datos, intentelo de nuevo");
            
            ps = conexion.prepareStatement(Consultas.getDatosDatosEscolaresBecario);
            ps.setLong(1, idBecario);
            System.out.println("Query: " + ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
               datosEscolares.setId(rs.getLong(DatosEscolares.COL_ID));
               datosEscolares.setEscuelaProcedencia(rs.getString(DatosEscolares.COL_ESCUELA_PROCEDENCIA));
               datosEscolares.setIdUniversidad(rs.getInt(DatosEscolares.COL_ID_UNIVERSIDAD));
               datosEscolares.setIdCampoCarrera(rs.getInt(DatosEscolares.COL_ID_CAMPO_CARRERA));
               datosEscolares.setNombreCarrera(rs.getString(DatosEscolares.COL_NOMBRE_CARRERA));
               datosEscolares.setMesInicioBeca(rs.getInt(DatosEscolares.COL_MES_INICIO_BECA));
               datosEscolares.setAnioInicioBeca(rs.getInt(DatosEscolares.COL_ANIO_INICIO_BECA));
               datosEscolares.setMesGraduacion(rs.getInt(DatosEscolares.COL_MES_GRADUACION));
               datosEscolares.setAnioGraduacion(rs.getInt(DatosEscolares.COL_ANIO_GRADUACION));
               datosEscolares.setSemestresTotalesCarrera(rs.getInt(DatosEscolares.COL_SEMESTRES_TOTALES_BECA));
               datosEscolares.setSemestreInicioBeca(rs.getInt(DatosEscolares.COL_SEMESTRE_INICIO_BECA));
               datosEscolares.setCostoCarrera(rs.getInt(DatosEscolares.COL_COSTO_CARRERA));
               datosEscolares.setBecaTotal(rs.getInt(DatosEscolares.COL_BECA_TOTAL));
               datosEscolares.setBecaSemestral(rs.getInt(DatosEscolares.COL_BECA_SEMESTRAL));
               datosEscolares.setCondicionado(rs.getInt(DatosEscolares.COL_CONDICIONADO));
               datosEscolares.setIdTipoEscuela(rs.getInt(DatosEscolares.COL_ID_TIPO_ESCUELA));
               datosEscolares.setIdBecario(idBecario);
            }
        } catch (SQLException e) {
            log.muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
            
        }
        
        return datosEscolares;
    }

    /**
     * Obtiene el aval del becario
     * @param conexion
     * @param id
     * @return 
     */
    protected Aval getAvalBecario(Connection conexion, long id) {
        Aval aval = new Aval();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            if(conexion == null)
                throw new SQLException("No se pudo conectar a la base de datos, intentelo de nuevo");
            
            ps = conexion.prepareStatement(Consultas.getDatosAvalBecario);
            ps.setLong(1, id);
            System.out.println("Query: " + ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
               aval.setId(rs.getLong(Aval.COL_ID));
               aval.setaPaterno(rs.getString(Aval.COL_APATERNO));
               aval.setaMaterno(rs.getString(Aval.COL_AMATERNO));
               aval.setNombre(rs.getString(Aval.COL_NOMBRE));
               aval.setCalle(rs.getString(Aval.COL_CALLE));
               aval.setNumExt(rs.getString(Aval.COL_NUM_EXT));
               aval.setNumInt(rs.getString(Aval.COL_NUM_INT));
               aval.setColonia(rs.getString(Aval.COL_COLONIA));
               aval.setIdentificacion(rs.getString(Aval.COL_IDENTIFICACION));
               aval.setIdBecario(id);
            }
        } catch (SQLException e) {
            log.muestraErrores(e);
        }
        finally{
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
                log.muestraErrores(ex);
            }
            
        }
        
        return aval;
    }

    /**
     * Obtiene el kardex del becario
     * @param conexion COnexion a la base de datos
     * @param idBecario Id del becario que se obtendran sus kardex
     * @return 
     */
    protected List<Kardex> getKardexPorIdBecario(Connection conexion, long idBecario) {
        List<Kardex> lstKardex = new ArrayList<Kardex>();
        PreparedStatement ps = null;
        ResultSet rs = null;    
        
        try{
            ps = conexion.prepareStatement(Consultas.getKardexBecario);
            ps.setLong(1, idBecario);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Kardex kardex = new Kardex();
                kardex.setId_kardex(rs.getLong(Kardex.COL_ID_KARDEX));
                kardex.setNum_semestre(rs.getInt(Kardex.COL_NUM_SEMESTRE));
                kardex.setPago_inicio_semestre(rs.getBoolean(Kardex.COL_PAGO_INICIO_SEMESTRE));
                kardex.setPago_fin_semestre(rs.getBoolean(Kardex.COL_PAGO_FIN_SEMESTRE));
                kardex.setPlatica1(rs.getBoolean(Kardex.COL_PLATICA_1));
                kardex.setPlatica2(rs.getBoolean(Kardex.COL_PLATICA_2));
                kardex.setPromedio(rs.getFloat(Kardex.COL_PROMEDIO));
                kardex.setDescuento(rs.getInt(Kardex.COL_DESCUENTO));
                kardex.setIdServicioComunitario(rs.getInt(Kardex.COL_ID_SERVICIO_COMUNITARIO));
                kardex.setLugarServicioComunitario(rs.getInt(Kardex.COL_LUGAR_SERVICIO_COMUNITARIO));
                kardex.setBoleta(rs.getString(Kardex.COL_BOLETA));
                kardex.setCarta_servicio_comunitario(rs.getString(Kardex.COL_CARTA_SERVICIO_COMUNITARIO));
                kardex.setId_becario(rs.getLong(Kardex.COL_ID_BECARIO));
                kardex.setPago_extra(rs.getBoolean(Kardex.COL_PAGO_EXTRA));
                kardex.setHorasServicio(rs.getInt(Kardex.COL_HORAS_SERVICIO));
                kardex.setTransferencia1(rs.getString(Kardex.COL_TRANSFERENCIA_1));
                kardex.setTransferencia2(rs.getString(Kardex.COL_TRANSFERENCIA_2));
                lstKardex.add(kardex);
            }
            
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        
        return lstKardex;
    }

    /**
     * Actualiza la informacion bancaria del becario
     * @param conexion
     * @param idBecario
     * @param idBanco
     * @param noCuenta
     * @param claveInterbancaria 
     */
    protected boolean updateInfoBanco(Connection conexion, long idBecario, int idBanco, String noCuenta, String claveInterbancaria) {
        PreparedStatement ps = null;
        int result = 0;
        boolean response = false;
        try{
            ps = conexion.prepareStatement(Update.updateCuentaBancariaBecario);
            ps.setInt(1, idBanco);
            ps.setString(2, noCuenta);
            ps.setString(3, claveInterbancaria);
            ps.setLong(4, idBecario);
            result = ps.executeUpdate();
            
            if(result > 0){
                response = true;
            }
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return response;
    }
    
    /**
     * Inserta o Actualiza los kardex del becario seleccionado.
     * @param conexion
     * @param lstKardex
     * @param idBecario
     * @param semestresTotales
     * @return True si exitoso, false si no
     */
    protected boolean insertOrUpdateKardexBecario(Connection conexion, List<Kardex> lstKardex, 
            File[] lstFilesBoletas, File[] lstFilesCartaServCom ,Becario becario){
        boolean response = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int totalKardex = 0;
        try{
            ps = conexion.prepareStatement(Consultas.getKardexBecario);
            ps.setLong(1, becario.getId());
            rs = ps.executeQuery();
            List<Long> idsKardex = new ArrayList<>();
            
            while(rs.next()){
                idsKardex.add(rs.getLong(Kardex.COL_ID_KARDEX));
            }
            
            //Si aún no se tiene registros semestrales del kardex del becario entonces se insertan todos los campos
            if(idsKardex.isEmpty()){
                for (Kardex kardex : lstKardex) {
                    ps = conexion.prepareStatement(Insert.insertKardexBecario);
                    ps.setInt(1, kardex.getNum_semestre());
                    ps.setBoolean(2, kardex.isPago_inicio_semestre());
                    ps.setBoolean(3, kardex.isPago_fin_semestre());
                    ps.setBoolean(4, kardex.isPlatica1());
                    ps.setBoolean(5, kardex.isPlatica2());
                    ps.setFloat(6, kardex.getPromedio());
                    ps.setFloat(7, kardex.getDescuento());
//                    ps.setInt(8, kardex.getIdServicioComunitario());
//                    ps.setInt(9, kardex.getLugarServicioComunitario());
                    ps.setInt(9, kardex.getIdServicioComunitario());
                    ps.setInt(8, kardex.getLugarServicioComunitario());
                    ps.setString(10, kardex.getBoleta());
                    ps.setString(11, kardex.getCarta_servicio_comunitario());
                    ps.setBoolean(12, kardex.isPago_extra());
                    ps.setInt(13, kardex.getHorasServicio());
                    ps.setLong(14, becario.getId());
                    ps.setString(15, kardex.getTransferencia1());
                    ps.setString(16, kardex.getTransferencia2());
                    int result = ps.executeUpdate();
                    if(result == 0){
                        return response;
                    }
                }
                response = true;
            }
            //Su existen menos kardex registrados que el total de semestres a registrar
            else{
                int i = 0;
                //Se recorren los kardex actualizables
                for (Kardex kardex : lstKardex) {
                    ps = conexion.prepareStatement(Update.updateKardexBecario);
                    ps.setInt(1, kardex.getNum_semestre());
                    ps.setBoolean(2, kardex.isPago_inicio_semestre());
                    ps.setBoolean(3, kardex.isPago_fin_semestre());
                    ps.setBoolean(4, kardex.isPlatica1());
                    ps.setBoolean(5, kardex.isPlatica2());
                    ps.setFloat(6, kardex.getPromedio());
                    ps.setFloat(7, kardex.getDescuento());
//                    ps.setInt(8, kardex.getIdServicioComunitario());
//                    ps.setInt(9, kardex.getLugarServicioComunitario());
                    ps.setInt(8, kardex.getLugarServicioComunitario());
                    ps.setInt(9, kardex.getIdServicioComunitario());
                    ps.setString(10, kardex.getBoleta());
                    ps.setString(11, kardex.getCarta_servicio_comunitario());
                    ps.setBoolean(12, kardex.isPago_extra());
                    ps.setInt(13, kardex.getHorasServicio());
                    ps.setString(14, kardex.getTransferencia1());
                    ps.setString(15, kardex.getTransferencia2());
                    ps.setLong(16, becario.getId());
                    ps.setLong(17, idsKardex.get(i));
                    int result = ps.executeUpdate();
                    
                    if(result == 0)
                        throw new SQLException("Error al actualizar el kardex del becario: " + ps.toString());
                    i++;
                }        
            }
            
            response = true;
            
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        finally{
            try{
                ps.close();
            }
            catch(SQLException e){
                log.muestraErrores(e);
            }
        }
        
        return response;
    }

    /**
     * Obtiene los registros de las tablas
     * @param conexion Conexion a la base de datos
     * @param idTabla id de la tabla
     * @return Nombre de la tabla
     */
    protected String getNombreTabla(Connection conexion, int idTabla) {
        String nombre = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conexion.prepareStatement(Consultas.getNombreCatalogo);
            ps.setInt(1, idTabla);
            rs = ps.executeQuery();
            
            while(rs.next()){
                nombre = rs.getString(CatCategorias.COL_NOMBRE_TABLA);
            }
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        
        return nombre;
    }

    /**
     * Obtiene todos los registros de un catalogo según el nombre de la tabla
     * @param conexion
     * @param nombreTabla
     * @return 
     */
    LinkedHashMap<Integer, String> getDatosCatalogo(Connection conexion, String nombreTabla) {
        LinkedHashMap<Integer, String> lstInfoCatalogo = new LinkedHashMap<>();
        Statement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conexion.createStatement();
            rs = ps.executeQuery(Consultas.getCatalogoPorNombreTabla + nombreTabla + " WHERE activo = 1 ORDER BY nombre");
            
            while(rs.next()){
                CatCategorias catalogo = new CatCategorias();
                catalogo.setId(rs.getInt(1));
                catalogo.setNombre(rs.getString(2));
               
                lstInfoCatalogo.put(catalogo.getId(), catalogo.getNombre());
            }
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        return lstInfoCatalogo;
    }

    /**
     * Obtiene el total de registros de una tabla, según el nombre de la misma
     * @param conexion
     * @param nombreTabla
     * @return Numero total de registros que contiene la tabla
     */
    protected int getTotalRegistrosDeCatalogo(Connection conexion, String nombreTabla) {
        int contador = 0;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(Consultas.getTotalRegistrosPorNombreTabla + nombreTabla);
            while(rs.next()){
                contador = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            log.muestraErrores(ex);
        }
        
        
        return contador;
    }
    
    /**
     * Obtiene el total de programas registrados
     * @param conexion
     * @return 
     */
    protected int getTotalProgramas(Connection conexion) {
        Statement st = null;
        ResultSet rs = null;
        int result = 0;
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(Consultas.getTotalProgramas);
            if(rs.next())
                result = rs.getInt(1);
            
        } catch (SQLException ex) {
            log.muestraErrores(ex);
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }

    /**
     * Actualiza los datos de un catalogo registro por registro
     * @param conexion
     * @param datoNuevo
     * @param idRegistro
     * @param nombreTabla 
     * @param nombreColumnas 
     * @return  
     */
    protected boolean updateCatalogo(Connection conexion, String datoNuevo, 
            int idRegistro, String nombreTabla, CatColumnasTabla nombreColumnas) {
        
        boolean response = false;
        Statement st = null;
        
        try {
            st = conexion.createStatement();
            int resp = st.executeUpdate(Update.updateRegistroCatalogo(nombreTabla, nombreColumnas, idRegistro, datoNuevo));
            if(resp > 0)
                response = true;
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            log.muestraErrores(ex);
        }
        
        return response;
    }
    
    /**
     * Actualiza los datos de beca_cat_universidad
     * @param conexion
     * @param datoNuevo
     * @param idRegistro
     * @param nombreTabla 
     * @param nombreColumnas 
     * @param isPublica 
     * @return  
     */
    protected boolean updateCatalogo(Connection conexion, String datoNuevo, 
            int idRegistro, String nombreTabla, CatColumnasTabla nombreColumnas, boolean isPublica) {
        
        boolean response = false;
        PreparedStatement st = null;
        int tipoEsc = 0;
        
        if(isPublica)
            tipoEsc = 1;
        else
            tipoEsc = 2;
        
        try {
            st = conexion.prepareStatement(Update.updateRegistroCatalogo(nombreTabla, nombreColumnas, idRegistro, datoNuevo, isPublica));
            st.setInt(1, tipoEsc);
            int resp = st.executeUpdate();
            if(resp > 0)
                response = true;
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            log.muestraErrores(ex);
        }
        
        return response;
    }

    /**
     * Obtiene los nombres de las columnas de una tabla a partir de su nombre
     * @param conexion
     * @param nombreTabla
     * @return 
     */
    protected CatColumnasTabla getNombreColumnasTabla(Connection conexion, String nombreTabla) {
        Statement st = null;
        ResultSet rs = null;
        CatColumnasTabla result = new CatColumnasTabla();
        try {
            st = conexion.createStatement();
            rs = st.executeQuery(Consultas.getNombreColumnasTabla + nombreTabla);
            
            int i = 0;
            while(rs.next()){
                
                switch(i){
                    //Nombre del la columna ID
                    case 0:
                        result.setNombreColumnaId(rs.getString(1));
                        break;
                    //NOmbre de la columna nombre
                    case 1:
                        result.setNombreColumnaNombre(rs.getString(1));
                        break;
                        //En caso de que se esté evaluando la universida se agrega
                    case 4:
                        if(nombreTabla.toLowerCase().contains("universidad")){
                            //result.setTipoEscuela(rs.getInt(1));
                            result.setNombreColumnaTipoEscuela(rs.getString(1));
                        }
                        break;
                }
                   
                i++;
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

    /**
     * Inserta registros en la tabla catalogo indicada
     * @param conexion
     * @param datoNuevo
     * @param idRegistro
     * @param nombreTabla
     * @param nombreColumnas
     * @return 
     */
    protected boolean insertRegistroCatalogo(Connection conexion, String datoNuevo, 
                    int idRegistro, String nombreTabla, CatColumnasTabla nombreColumnas) {
         boolean response = false;
        Statement st = null;
        
        try {
            st = conexion.createStatement();
            int resp = st.executeUpdate(Insert.insertRegistroCatalogo(nombreTabla, 
                                    nombreColumnas, datoNuevo, idRegistro));
            if(resp > 0)
                response = true;
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            log.muestraErrores(ex);
        }
        
        return response;
    }
    
    /**
     * Inserta registros en la tabla beca_cat_universidad
     * @param conexion
     * @param datoNuevo
     * @param idRegistro
     * @param nombreTabla
     * @param nombreColumnas
     * @param bandera False, indica que la tabla NO FUE filtrada.
     * TRUE indica que la tabla SI FUE filtrada
     * @param tipoUniversidad
     * @return 
     */
    protected boolean insertRegistroCatalogo(Connection conexion, String datoNuevo, 
                    int idRegistro, String nombreTabla, CatColumnasTabla nombreColumnas, 
                    boolean tipoUniversidad) {
         boolean response = false;
        PreparedStatement st = null;
        
        try {
            st = conexion.prepareStatement(Insert.insertRegistroCatalogo(nombreTabla, 
                                    nombreColumnas, datoNuevo, idRegistro, tipoUniversidad));
            int resp = st.executeUpdate();
            if(resp > 0)
                response = true;
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            log.muestraErrores(ex);
        }
        
        return response;
    }

    /**
     * Elimina un registro de un catalogo por el nombre del catalogo
     * @param conexion
     * @param idRegistro
     * @param nombreTabla
     * @param nombreColumnas
     * @return 
     */
    protected boolean deleteRegistroCatalogo(Connection conexion, 
            int idRegistro, String nombreTabla, CatColumnasTabla nombreColumnas) {
        boolean response = false;
        PreparedStatement ps = null;
        
        try {
            ps = conexion.prepareStatement(Update.desactivaRegistroCatalogo(nombreTabla, nombreColumnas));
            ps.setInt(1, idRegistro);
            System.out.println(ps);
            int resp = ps.executeUpdate();
            if(resp > 0)
                response = true;
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            log.muestraErrores(ex);
        }
        
        return response;
    }

    /**
     * Inhabilita a un becario
     * @param conexion
     * @param becario
     * @param activo Indica el estatus al que se cambiará el becario
     * @return 
     */
    protected boolean updateCampoActivoBecario(Connection conexion, Becario becario, boolean activo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            ps = conexion.prepareStatement(Update.updateCampoActivoBecario);
            if(activo)
                ps.setInt(1, 1);
            else
                ps.setInt(1, 0);
            ps.setLong(2, becario.getId());
            int res = ps.executeUpdate();
            
            if(res > 0)
                result = true;
        } catch (SQLException ex) {
            log.muestraErrores(ex);
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

    /**
     * Pone al becario en estatus truncado
     * @param conexion
     * @param becario
     * @return 
     */
    protected boolean updateTruncaBecario(Connection conexion, Becario becario) {
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            
            st = conexion.createStatement();
            rs = st.executeQuery(Consultas.getCatalogoPorNombreTabla + " beca_cat_estatus");
            int idCampoCancelado = 0;
            while(rs.next()){
                if(rs.getString(2).toLowerCase().contains("cancel"))
                    idCampoCancelado = rs.getInt(1);
            }
            
            st = conexion.createStatement();
            rs = st.executeQuery(Consultas.getCatalogoPorNombreTabla + "beca_tipo_estatus");
            int idCampoTruncado = 0;
            while(rs.next()){
                if(rs.getString(2).toLowerCase().contains("trunc")){
                    idCampoTruncado = rs.getInt(1);
                }
            }
            
            ps = conexion.prepareStatement(Update.updateTruncaBecario);
            ps.setInt(1, idCampoCancelado);
            ps.setInt(2, idCampoTruncado);
            ps.setLong(3, becario.getId());
            
            int res = ps.executeUpdate();
            
            if(res > 0)
                result = true;
        } catch (SQLException ex) {
            log.muestraErrores(ex);
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }

    protected int getEstatusCancelado(Connection conexion) {
        Statement st = null;
        ResultSet rs = null;
        int id = 0;
        try{
            st = conexion.createStatement();
            rs = st.executeQuery(Consultas.getEstatusCancelado);
            id = 0;
            while(rs.next()){
                id = rs.getInt(CatEstatus.COL_ID);
            }
            
        }
        catch(SQLException e){
            log.muestraErrores(e);
        }
        
        return id;
    }

    /**
     * Retorna una lista con los datos del tipo de escuela del catalogo beca_cat_universidad
     * @param conexion
     * @return 
     */
    protected String getIdTipoEscuela(Connection conexion, int id) {
        String lstTipoEscuela = "";
        PreparedStatement st;
        ResultSet rs;
        try {
            st = conexion.prepareStatement(Consultas.getTipoEscuela);
            st.setInt(1, id);
            rs = st.executeQuery();
            
            while(rs.next()){
                lstTipoEscuela = rs.getString(1);
            }
            
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            log.muestraErrores(ex);
        }
        
        return lstTipoEscuela;
    }

    /**
     * Obtiene el id mayor del catalogo
     * @param conexion
     * @param nombreTabla
     * @param nombreColumnas
     * @return Id mayor del catalogo
     */
    protected long getIdMayorCatalogo(Connection conexion, String nombreTabla, CatColumnasTabla nombreColumnas) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        long idCatalogo = 0;
        try {
            ps = conexion.prepareStatement(Consultas.getIdMayor);
            ps.setString(1, "MAX(" + nombreColumnas.getNombreColumnaId() + "");
            ps.setString(2, nombreTabla);
            rs = ps.executeQuery();
            
            if(rs.next()){
                idCatalogo = rs.getLong(1);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            muestraErrores(ex);
        }
        
        return idCatalogo;
    }

    /**
     * Actualiza los valores del catalogo
     * @param conexion
     * @param idRegistro
     * @param nuevoValorNombre
     * @param nombreTabla
     * @param nombreColumnas
     * @return 
     */
    protected boolean updateRegistroCatalogo(Connection conexion, int idRegistro, String nuevoValorNombre, String nombreTabla, CatColumnasTabla nombreColumnas) {
        Statement st = null;
        boolean response = false;
        
        try {
            st = conexion.createStatement();
            int resp = st.executeUpdate(Update.updateRegistroCatalogo(nombreTabla, nombreColumnas, idRegistro, nuevoValorNombre));
            
            if(resp>0)
                response = true;
        } catch (SQLException ex) {
            log.muestraErrores(ex);
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    /**
     * Actualiza los valores del catalogo de universidades
     * @param conexion
     * @param idRegistro
     * @param nuevoValorNombre
     * @param nombreTabla
     * @param nombreColumnas
     * @param isPublic
     * @return 
     */
    protected boolean updateRegistroCatalogo(Connection conexion, int idRegistro, 
            String nuevoValorNombre, String nombreTabla, CatColumnasTabla nombreColumnas,
            boolean isPublic) {
        Statement st = null;
        boolean response = false;
        
        try {
            st = conexion.createStatement();
            int resp = st.executeUpdate(Update.updateRegistroCatalogo(nombreTabla, nombreColumnas, idRegistro, nuevoValorNombre, isPublic));
            
            if(resp>0)
                response = true;
        } catch (SQLException ex) {
            log.muestraErrores(ex);
            Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
}
