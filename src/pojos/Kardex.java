/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author sergio
 */
public class Kardex {
    
    long id_kardex;
    int num_semestre;
    boolean pago_inicio_semestre;
    boolean pago_fin_semestre;
    boolean platica1;
    boolean platica2;
    float promedio;
    int descuento;
    int idServicioComunitario;
    String lugarServicioComunitario;
    String boleta;
    String carta_servicio_comunitario;
    long id_becario;
    boolean pago_extra;

    public long getId_kardex() {
        return id_kardex;
    }

    public void setId_kardex(long id_registro) {
        this.id_kardex = id_registro;
    }

    public int getNum_semestre() {
        return num_semestre;
    }

    public void setNum_semestre(int num_semestre) {
        this.num_semestre = num_semestre;
    }

    public boolean isPago_inicio_semestre() {
        return pago_inicio_semestre;
    }

    public void setPago_inicio_semestre(boolean pago_inicio_semestre) {
        this.pago_inicio_semestre = pago_inicio_semestre;
    }

    public boolean isPago_fin_semestre() {
        return pago_fin_semestre;
    }

    public void setPago_fin_semestre(boolean pago_fin_semestre) {
        this.pago_fin_semestre = pago_fin_semestre;
    }

    public boolean isPlatica1() {
        return platica1;
    }

    public void setPlatica1(boolean platica1) {
        this.platica1 = platica1;
    }

    public boolean isPlatica2() {
        return platica2;
    }

    public void setPlatica2(boolean platica2) {
        this.platica2 = platica2;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }

    public String getCarta_servicio_comunitario() {
        return carta_servicio_comunitario;
    }

    public void setCarta_servicio_comunitario(String carta_servicio_comunitario) {
        this.carta_servicio_comunitario = carta_servicio_comunitario;
    }

    public long getId_becario() {
        return id_becario;
    }

    public void setId_becario(long id_becario) {
        this.id_becario = id_becario;
    }

    public boolean isPago_extra() {
        return pago_extra;
    }

    public void setPago_extra(boolean pago_extra) {
        this.pago_extra = pago_extra;
    }

    public int getIdServicioComunitario() {
        return idServicioComunitario;
    }

    public void setIdServicioComunitario(int idServicioComunitario) {
        this.idServicioComunitario = idServicioComunitario;
    }

    public String getLugarServicioComunitario() {
        return lugarServicioComunitario;
    }

    public void setLugarServicioComunitario(String lugarServicioComunitario) {
        this.lugarServicioComunitario = lugarServicioComunitario;
    }
    
    
    
    public static final String COL_ID_KARDEX = "id_registro";
    public static final String COL_NUM_SEMESTRE = "num_semestre";
    public static final String COL_PAGO_INICIO_SEMESTRE = "pago_inicio_semestre";
    public static final String COL_PAGO_FIN_SEMESTRE = "pago_fin_semestre";
    public static final String COL_PLATICA_1 = "platica1";
    public static final String COL_PLATICA_2 = "platica2";
    public static final String COL_PROMEDIO = "promedio";
    public static final String COL_DESCUENTO = "descuento";
    public static final String COL_LUGAR_SERVICIO_COMUNITARIO = "id_servicio_comunitario";
    public static final String COL_ID_SERVICIO_COMUNITARIO = "lugar_servicio_comunitario";
    public static final String COL_BOLETA = "boleta";
    public static final String COL_CARTA_SERVICIO_COMUNITARIO = "carta_servicio_comunitario";
    public static final String COL_ID_BECARIO = "id_becario";
    public static final String COL_PAGO_EXTRA = "pago_extra";
    
}
