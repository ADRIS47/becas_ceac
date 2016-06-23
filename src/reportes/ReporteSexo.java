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
public class ReporteSexo implements JRDataSource{
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
            case "folio":
                valor = lstReporte.get(contador).getFolio();
                break;
            case "aPaterno":
                valor = lstReporte.get(contador).getaPaterno();
                break;
            case "aMaterno":
                valor = lstReporte.get(contador).getaMaterno();
                break;
            case "nombre":
                valor = lstReporte.get(contador).getNombre();
                break;
            case "nombreSexo":
                valor = lstReporte.get(contador).getSexo();
                break;
            case "idSexo":
                valor = lstReporte.get(contador).getIdGeneroSexo();
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
