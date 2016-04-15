/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author sabagip
 */
public class Direccion {
    
    long id;
    String calle;
    String numExt;
    String numInt;
    String colonia;
    int codigoPostal;
    String ciudad;
    long idBecario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumExt() {
        return numExt;
    }

    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    public String getNumInt() {
        return numInt;
    }

    public void setNumInt(String numInt) {
        this.numInt = numInt;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public long getIdBecario() {
        return idBecario;
    }

    public void setIdBecario(long idBecario) {
        this.idBecario = idBecario;
    }
    
    public final static String COL_ID = "id_direccion";
    public final static String COL_CALLE = "calle";
    public final static String COL_NUM_EXT = "num_exterior";
    public final static String COL_NUM_INT = "num_interior";
    public final static String COL_COLONIA = "colonia";
    public final static String COL_CODIGO_POSTAL = "codigo_postal";
    public final static String COL_CIUDAD = "ciudad";
    public final static String COL_ID_BECARIO = "id_becario";
    
}
