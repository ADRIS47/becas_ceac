/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.Date;

/**
 *
 * @author sabagip
 */
public class Cobranza {
    
    long idCobranza;
    Date fechaPago;
    int montoPago;
    String referencia;
    long idBecario;

    public long getIdCobranza() {
        return idCobranza;
    }

    public void setIdCobranza(long idCobranza) {
        this.idCobranza = idCobranza;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(int montoPago) {
        this.montoPago = montoPago;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public long getIdBecario() {
        return idBecario;
    }

    public void setIdBecario(long idBecario) {
        this.idBecario = idBecario;
    }
    
    public static final String COL_ID = "idCobranza";
    public static final String COL_FECHA_PAGO = "fecha_pago";
    public static final String COL_MONTO = "monto_pago";
    public static final String COL_REFERENCIA = "referencia";
    public static final String COL_ID_BECARIO = "id_becario";
    
    
}
