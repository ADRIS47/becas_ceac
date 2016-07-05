/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import pojos.Becario;
import pojos.PojoReporteGeneral;

/**
 *
 * @author sabagip
 */
public class ReporteTrabajan implements JRDataSource{
    
    List<PojoReporteGeneral> lstTrabaja = new ArrayList<>();
    int contador = -1;

    public List<PojoReporteGeneral> getLstTrabaja() {
        return lstTrabaja;
    }

    public void setLstTrabaja(List<PojoReporteGeneral> lstTrabaja) {
        this.lstTrabaja = lstTrabaja;
    }

    @Override
    public boolean next() throws JRException {
        return ++contador < lstTrabaja.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        float pagoSemestral = 0;
        String campo = jrf.getName();
        switch(campo){
            case "trabaja":
                valor = lstTrabaja.get(contador).getNombre();
                break;
            case "fechaDe":
                valor = lstTrabaja.get(contador).getFechaDe();
                break;
            case "fechaA":
                valor = lstTrabaja.get(contador).getFechaA();
                break;
            case "nombrePrograma":
                valor = lstTrabaja.get(contador).getNombrePrograma();
                break;
                
        }
        return valor;
    }
    
}
