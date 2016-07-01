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
public class ReportePrimerBecado implements JRDataSource{
    
    List<PojoReporteGeneral> lstPrimerBecado = new ArrayList<>();
    int contador = -1;

    public List<PojoReporteGeneral> getLstTrabaja() {
        return lstPrimerBecado;
    }

    public void setLstTrabaja(List<PojoReporteGeneral> lstTrabaja) {
        this.lstPrimerBecado = lstTrabaja;
    }

    @Override
    public boolean next() throws JRException {
        return ++contador < lstPrimerBecado.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        String campo = jrf.getName();
        switch(campo){
            case "becado":
                valor = lstPrimerBecado.get(contador).getNombre();
                break;
                
            case "fechaDe":
                valor = lstPrimerBecado.get(contador).getFechaDe();
                break;
                
            case "fechaA":
                valor = lstPrimerBecado.get(contador).getFechaA();
                break;
                
            case "nombrePrograma":
                valor = lstPrimerBecado.get(contador).getNombrePrograma();
                break;
        }
        return valor;
    }
    
}
