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
import pojos.PojoReporteIndividual;
import pojos.Telefono;

/**
 *
 * @author sergio
 */
public class HistorialIndividual implements JRDataSource{
    List<PojoReporteIndividual> lstDatosUnicos = new ArrayList<>();
    List<CatPrograma> programa = new ArrayList<>();
    List<CatEstatus> estatus = new ArrayList<>();
    List<CatUniversidad> universidad = new ArrayList<>();
    List<DatosEscolares> lstDatosEscolares = new ArrayList<>();
    List<CatCampo> campo = new ArrayList<>();
    List<Telefono> lstTelefono = new ArrayList<>();
    List<Kardex> lstKardex = new ArrayList<>();
    int contador = -1;

    @Override
    public boolean next() throws JRException {
        return ++contador < lstDatosUnicos.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        switch(jrf.getName()){
            case "folio":
                valor = lstDatosUnicos.get(contador).getFolio();
                break;
            case "aPaterno":
                valor = lstDatosUnicos.get(contador).getaPaterno();
                break;
            case "aMaterno":
                valor = lstDatosUnicos.get(contador).getaMaterno();
                break;
            case "nombre":
                valor = lstDatosUnicos.get(contador).getNombre();
                break;
            case "programa":
                valor = lstDatosUnicos.get(contador).getPrograma();
                break;
            case "estatus":
                valor = lstDatosUnicos.get(contador).getEstatus();
                break;
            case "escuela":
                valor = lstDatosUnicos.get(contador).getEscuela();
                break;
            case "carrera":
                valor = lstDatosUnicos.get(contador).getCarrera();
                break;
            case "campo":
                valor = lstDatosUnicos.get(contador).getCampo();
                break;
            case "telefonos":
                
                break;
            case "email":
                valor = lstDatosUnicos.get(contador).getEmail();
                break;
            case "fechaIngreso":
                valor = lstDatosUnicos.get(contador).getFechaIngreso();
                break;
            case "semestreIngreso":
                valor = lstDatosUnicos.get(contador).getSemestreIngreso();
                break;
            case "fechaGraduacion":
                valor = lstDatosUnicos.get(contador).getFechaGraduacion();
                break;
            case "becaTotal":
                valor = lstDatosUnicos.get(contador).getBecaTotal();
                break;
            case "pagoSemestral":
                valor = lstDatosUnicos.get(contador).getBecaSemestral();
                break;
            case "saldoAcumulado":
                
                break;
            case "servicioAcumulado":
                
                break;
            case "descuentoAcumulado":
                
                break;
            case "semestre":
                
                break;
            case "pago":
                
                break;
            case "promedio":
                
                break;
            case "horasServicio":
                
                break;
            case "tipoServicio":
                
                break;
            case "descuento":
                
                break;
            case "nombreCompleto":
                valor = lstDatosUnicos.get(0).getaPaterno() + " " + lstDatosUnicos.get(0).getaMaterno() + " " + lstDatosUnicos.get(0).getNombre();
                break;
        }
        
        return valor;
    }
    
    public void setBecario(PojoReporteIndividual becario){
        this.lstDatosUnicos.add(becario);
    }
    
}
