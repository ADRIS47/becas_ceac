/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import pojos.PojoReporteGeneral;

/**
 *
 * @author sabagip
 */
public class ReporteCampoEstudio implements JRDataSource{
    List<PojoReporteGeneral> lstReporte;
    int contador = -1;

    public void setLstReporte(List<PojoReporteGeneral> lstReporte) {
        this.lstReporte = lstReporte;
    }
    

    @Override
    public boolean next() throws JRException {
        return ++contador < lstReporte.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        String campo = jrf.getName();
        switch(campo){
            case "nombreCampoAplicacion":
                valor = lstReporte.get(contador).getNombreCampoCarrera();
                break;
            case "nombrePrograma":
                valor = lstReporte.get(contador).getNombrePrograma();
                break;                
            case "fechaDe":
                valor = lstReporte.get(contador).getFechaDe();
                    break;
            case "fechaA":
                valor = lstReporte.get(contador).getFechaA();
                    break;
        }
        return valor;
    }
    
}
