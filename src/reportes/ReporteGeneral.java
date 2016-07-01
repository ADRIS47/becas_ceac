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
public class ReporteGeneral implements JRDataSource{
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
            case "nombrePrograma":
                valor = lstReporte.get(contador).getNombrePrograma();
                break;
            case "nombreEstatus":
                valor = lstReporte.get(contador).getNombreEstatus();
                break;
            case "nombreUniversidad":
                valor = lstReporte.get(contador).getNombreUniversidad();
                break;
            case "nombreCampo":
                valor = lstReporte.get(contador).getNombreCampoCarrera();
                break;
            case "becaTotal":
                valor = lstReporte.get(contador).getBecaTotal();
                break;
            case "becaSemestral":
                valor = lstReporte.get(contador).getBecaSemestral();
                break;
            case "semestreInicioBeca":
                valor = lstReporte.get(contador).getSemestreInicioBeca();
                break;
            case "fechaInicioBeca":
                valor = lstReporte.get(contador).getFechaInicioBeca();
                break;
            case "fechaFinBeca":
                valor = lstReporte.get(contador).getFechaFinBeca();
                break;
            case "nombreCompleto":
                String nombre = lstReporte.get(contador).getaPaterno() + " " + lstReporte.get(contador).getaMaterno() + " " + lstReporte.get(contador).getNombre();
                valor = nombre;
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
