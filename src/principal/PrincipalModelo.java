/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import crud.Conexion;
import crud.Consultas;
import crud.Insert;
import crud.Update;
import helpers.Helper;
import helpers.Log;
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
import pojos.CatCampoCarrera;
import pojos.CatEstadoCivil;
import pojos.CatGradoEscolar;
import pojos.CatParentesco;
import pojos.CatPrograma;
import pojos.CatSexo;
import pojos.CatUniversidad;
import pojos.DatosEscolares;
import pojos.Direccion;
import pojos.Hermanos;
import pojos.Hijos;
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

        Conexion conexion = new Conexion();
        Connection conn = null;
        conn = conexion.estableceConexion();
        if (conn == null) {
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
     *
     * @param conn COnexion a la base de datos
     * @return Categoria de sexos
     */
    protected LinkedHashMap<Integer, String> getSexo(Connection conn) {
        LinkedHashMap<Integer, String> catSexo = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        Map<Integer, String> result = new LinkedHashMap<>();

        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getSexo);
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
     * Obtiene la categoria de sexos
     *
     * @return Categoria de sexos
     */
    protected LinkedHashMap<Integer, String> getSexo() {
        LinkedHashMap<Integer, String> catSexo = new LinkedHashMap<>();
        Conexion conexion = new Conexion();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = conexion.estableceConexion();
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getSexo);
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
    private LinkedHashMap<Integer, String> getEstadoCivil(Connection conn) {
        LinkedHashMap<Integer, String> catEstadoCivil = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getEstadoCivil);
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
    private LinkedHashMap<Integer, String> getEstadoCivil() {
        Conexion conexion = new Conexion();
        Connection conn = null;
        LinkedHashMap<Integer, String> catEstadoCivil = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = conexion.estableceConexion();
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getEstadoCivil);
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
    private LinkedHashMap<Integer, String> getProgramas(Connection conn) {
        LinkedHashMap<Integer, String> catPrograma = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getProgramas);
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
        return catPrograma;
    }

    /**
     * Obtiene el catalogo de nivel de estudios
     *
     * @param conn
     * @return
     */
    private LinkedHashMap<Integer, String> getNivelEstudios(Connection conn) {
        LinkedHashMap<Integer, String> catNivelEstudios = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getNIvelEstudios);
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
    private LinkedHashMap<Integer, String> getParentesco(Connection conn) {
        LinkedHashMap<Integer, String> catNivelEstudios = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getParentesco);
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
    private LinkedHashMap<Integer, String> getUniversidades(Connection conn) {
        LinkedHashMap<Integer, String> catUniversidades = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getUniversidades);
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
     * Obtiene el catalogo de campo de estudio
     *
     * @param conn Conexion a la base de datos
     * @return Lista de campos de estudio
     */
    private LinkedHashMap<Integer, String> getCampoEstudio(Connection conn) {
        LinkedHashMap<Integer, String> catCampoEstudio = new LinkedHashMap<>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(Consultas.getCampoEstudio);
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
     * Inserta los hermanos del becario
     *
     * @param conexion Conexion a la base de datos
     * @param idBecario Id del becario
     * @param lstHermanos Lista de hermanos
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
     * Inserta los hijos del becario
     * @param conexion Conexion a la base de datos
     * @param idBecario Id del becario
     * @param lstHijos Lista de hijos del becario
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
    boolean insertDatosEscolares(Connection conexion, long idBecario, DatosEscolares lstDatosEscolares) {
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
            ps.setInt(12, becario.getPrimeroConBeca());
            ps.setString(13, becario.getNombreConyuge());
            ps.setString(14, becario.getApPaternoConyuge());
            ps.setString(15, becario.getApMaternoConyuge());
            ps.setString(16, becario.getTelefonoConyuge());
            ps.setString(17, becario.getObservaciones());
            ps.setString(18, becario.getActaNacimiento());
            ps.setString(19, becario.getSolicitudBeca());
            ps.setString(20, becario.getContatoBeca());
            ps.setString(21, becario.getIdentificacion());
            ps.setString(22, becario.getFolio());
            
            valor = ps.executeUpdate();
            
            if(valor == 0){
                throw new SQLException("No se pudo actualizar el becario");
            }
            response = true;
            
        }
        catch(SQLException e){
            log.crearLog(e.getMessage());
            System.err.println("Error: " + e.getMessage());
        }
        finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                log.crearLog(ex.getSQLState());
                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return response;
    }

    /**
     * Actualiza o inserta las direcciones del becario
     * @param conexion
     * @param idBecario
     * @param lstTelefonosBecario
     * @return True si operacion exitosa, False si no
     */
    protected boolean updateDireccionBecario(Connection conexion, long idBecario, List<Direccion> lstTelefonosBecario) {
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
                lstIdDirecciones.add(rs.getInt(Direccion.COL_ID));
            }
            
            if(direcciones == -1)
                throw new SQLException("No se pudo obtener las direcciones del becario");
            
            //Si no se tienen direcciones registradas se insertan las nuevas direcciones
            if(direcciones == 0){
                response = insertDireccionBecario(conexion, idBecario, lstTelefonosBecario);
            }
            
            
            //Si existe una sola direccion registrada, se actualiza la primera y la segunda se inserta
            else if(direcciones > 0 && direcciones < lstTelefonosBecario.size()){
                ps = conexion.prepareStatement(Update.updateDireccionesBecario);
                ps.setString(1, lstTelefonosBecario.get(0).getCalle());
                ps.setString(2, lstTelefonosBecario.get(0).getNumExt());
                ps.setString(3, lstTelefonosBecario.get(0).getNumInt());
                ps.setString(4, lstTelefonosBecario.get(0).getColonia());
                ps.setInt(5, lstTelefonosBecario.get(0).getCodigoPostal());
                ps.setString(6, lstTelefonosBecario.get(0).getCiudad());
                ps.setLong(7, idBecario);
                ps.setLong(8, lstIdDirecciones.get(0));
                int resp = ps.executeUpdate();
                //Si la actualizacion fue correcta
                if(resp >= 1){
                    List<Direccion> nuevaLista = new ArrayList<>();
                    nuevaLista.add(lstTelefonosBecario.get(1));
                    response = insertDireccionBecario(conexion, idBecario, nuevaLista);
                }
            }
            //Si existen la misma cantidad de registros con la misma cantidad de nuevas direcciones
            else if(direcciones > 0 && direcciones == lstTelefonosBecario.size()){
                int contador = 0;
                for (Direccion direccion : lstTelefonosBecario) {
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

    protected boolean updateTelefonoBecario(Connection conexion, long idBecario, List<Telefono> lstTelefonosBecario) {
        boolean response = false;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try{
//            //Se verifica si existen más direcciones que las que se van a actualizar
//            ps = conexion.prepareStatement(Consultas.getDireccionesBecario);
//            ps.setLong(1, idBecario);
//            rs = ps.executeQuery();
//            int telefonos = -1;
//            List<Integer> lstIdTelefonos = new ArrayList <>();
//            if(rs.next()){
//                telefonos = rs.getInt(1);
//                lstIdTelefonos.add(rs.getInt(Direccion.COL_ID));
//            }
//            
//            if(telefonos == -1)
//                throw new SQLException("No se pudo obtener las direcciones del becario");
//            
//            //Si no se tienen direcciones registradas se insertan las nuevas direcciones
//            if(telefonos == 0){
//                response = insertDireccionBecario(conexion, idBecario, lstTelefonosBecario);
//            }
//            
//            
//            //Si existe una sola direccion registrada, se actualiza la primera y la segunda se inserta
//            else if(telefonos > 0 && telefonos < lstTelefonosBecario.size()){
//                ps = conexion.prepareStatement(Update.updateDireccionesBecario);
//                ps.setString(1, lstTelefonosBecario.get(0).getCalle());
//                ps.setString(2, lstTelefonosBecario.get(0).getNumExt());
//                ps.setString(3, lstTelefonosBecario.get(0).getNumInt());
//                ps.setString(4, lstTelefonosBecario.get(0).getColonia());
//                ps.setInt(5, lstTelefonosBecario.get(0).getCodigoPostal());
//                ps.setString(6, lstTelefonosBecario.get(0).getCiudad());
//                ps.setLong(7, idBecario);
//                ps.setLong(8, lstIdDirecciones.get(0));
//                int resp = ps.executeUpdate();
//                //Si la actualizacion fue correcta
//                if(resp >= 1){
//                    List<Direccion> nuevaLista = new ArrayList<>();
//                    nuevaLista.add(lstTelefonosBecario.get(1));
//                    response = insertDireccionBecario(conexion, idBecario, nuevaLista);
//                }
//            }
//            //Si existen la misma cantidad de registros con la misma cantidad de nuevas direcciones
//            else if(telefonos > 0 && telefonos == lstTelefonosBecario.size()){
//                int contador = 0;
//                for (Telefono telefono : lstTelefonosBecario) {
//                    ps = conexion.prepareStatement(Update.updateDireccionesBecario);
//                    ps.setString(1, telefono.getCalle());
//                    ps.setString(2, telefono.getNumExt());
//                    ps.setString(3, telefono.getNumInt());
//                    ps.setString(4, telefono.getColonia());
//                    ps.setInt(5, telefono.getCodigoPostal());
//                    ps.setString(6, telefono.getCiudad());
//                    ps.setLong(7, idBecario);
//                    ps.setLong(8, lstIdDirecciones.get(contador));
//                    int resp = ps.executeUpdate();
//                    //Si la actualizacion fue correcta
//                    if(resp == 0)
//                        break;
//                    contador++;
//                    //Si ya se actualizo el ultimo registro
//                    if(contador == 1)
//                        response = true;
//                }
//            }      
//        }
//        catch(SQLException e){
//            log.muestraErrores(e);
//        }
//        finally{
//            try {
//                ps.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(PrincipalModelo.class.getName()).log(Level.SEVERE, null, ex);
//                log.muestraErrores(ex);
//            }
//        }
//        
        return response;
    }
}
