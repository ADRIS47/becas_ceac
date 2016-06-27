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
import pojos.PojoReporteGeneral;

/**
 *
 * @author sabagip
 */
public class ReporteTipoUniversidad implements JRDataSource{
    
    List<PojoReporteGeneral> lstTipoUniversidad = new ArrayList<>();
    int contador = -1;

    public List<PojoReporteGeneral> getLstTrabaja() {
        return lstTipoUniversidad;
    }

    public void setLstTrabaja(List<PojoReporteGeneral> lstTrabaja) {
        this.lstTipoUniversidad = lstTrabaja;
    }

    @Override
    public boolean next() throws JRException {
        return ++contador < lstTipoUniversidad.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        String campo = jrf.getName();
        switch(campo){
            case "nombreUniversidad":
                valor = lstTipoUniversidad.get(contador).getNombreUniversidad();
                break;
            case "fechaDe":
                valor = lstTipoUniversidad.get(contador).getFechaDe();
                break;
                
            case "fechaA":
                valor = lstTipoUniversidad.get(contador).getFechaA();
                break;
            case "nombrePrograma":
                valor = lstTipoUniversidad.get(contador).getNombrePrograma();
                break;
        }
        return valor;
    }
    
}
