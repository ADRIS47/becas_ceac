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

/**
 *
 * @author sabagip
 */
public class ReportePrimerBecado implements JRDataSource{
    
    List<Becario> lstPrimerBecado = new ArrayList<>();
    int contador = -1;

    public List<Becario> getLstTrabaja() {
        return lstPrimerBecado;
    }

    public void setLstTrabaja(List<Becario> lstTrabaja) {
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
        }
        return valor;
    }
    
}
