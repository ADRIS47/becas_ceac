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
import pojos.CatCampo;
import pojos.CatEstatus;
import pojos.CatPrograma;
import pojos.CatUniversidad;
import pojos.DatosEscolares;
import pojos.Kardex;
import pojos.Telefono;

/**
 *
 * @author sergio
 */
public class HistorialIndividual implements JRDataSource{
    Becario becario = new Becario();
    CatPrograma programa = new CatPrograma();
    CatEstatus estatus = new CatEstatus();
    CatUniversidad universidad = new CatUniversidad();
    List<DatosEscolares> lstDatosEscolares = new ArrayList<>();
    CatCampo campo = new CatCampo();
    List<Telefono> lstTelefono = new ArrayList<>();
    List<Kardex> lstKardex = new ArrayList<>();
    int contador = -1;

    @Override
    public boolean next() throws JRException {
        return ++contador < lstDatosEscolares.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        switch(jrf.getName()){
            case "folio":
                valor = becario.getFolio();
                break;
            case "aPaterno":
                valor = becario.getApPaterno();
                break;
            case "aMaterno":
                valor = becario.getApMaterno();
                break;
            case "nombre":
                valor = becario.getNombre();
                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
//            case "":
//                
//                break;
        }
        
        return valor;
    }
    
    public void setBecario(Becario becario){
        this.becario = becario;
    }
    
}
