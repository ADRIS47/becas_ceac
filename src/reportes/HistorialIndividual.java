/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

//import java.util.ArrayList;
//import java.util.List;
//import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JRField;
//import pojos.CatCampo;
//import pojos.CatEstatus;
//import pojos.CatPrograma;
//import pojos.CatUniversidad;
//import pojos.DatosEscolares;
//import pojos.Kardex;
//import pojos.PojoReporteIndividual;
//import pojos.PojoReporteIndividualMuchosDatos;
//import pojos.Telefono;
//
///**
// *
// * @author sergio
// */
//public class HistorialIndividual implements JRDataSource{
//    List<PojoReporteIndividual> lstDatosUnicos = new ArrayList<>();
//    List<PojoReporteIndividualMuchosDatos> lstMuchosDatos = new ArrayList<>();
//    int contador = -1;
//    
//    public void setDatosUnicos(PojoReporteIndividual becario){
//        this.lstDatosUnicos.add(becario);
//    }
//
//    public void setLstMuchosDatos(List<PojoReporteIndividualMuchosDatos> lstMuchosDatos) {
//        this.lstMuchosDatos = lstMuchosDatos;
//    }
//
//    @Override
//    public boolean next() throws JRException {
//        return ++contador < lstMuchosDatos.size();
//    }
//
//    @Override
//    public Object getFieldValue(JRField jrf) throws JRException {
//        Object valor = null;
//        switch(jrf.getName()){
//            case "folio":
//                valor = lstDatosUnicos.get(0).getFolio();
//                break;
//            case "aPaterno":
//                valor = lstDatosUnicos.get(0).getaPaterno();
//                break;
//            case "aMaterno":
//                valor = lstDatosUnicos.get(0).getaMaterno();
//                break;
//            case "nombre":
//                valor = lstDatosUnicos.get(0).getNombre();
//                break;
//            case "programa":
//                valor = lstDatosUnicos.get(0).getPrograma();
//                break;
//            case "estatus":
//                valor = lstDatosUnicos.get(0).getEstatus();
//                break;
//            case "escuela":
//                valor = lstDatosUnicos.get(0).getEscuela();
//                break;
//            case "carrera":
//                valor = lstDatosUnicos.get(0).getCarrera();
//                break;
//            case "campo":
//                valor = lstDatosUnicos.get(0).getCampo();
//                break;
//            case "telefonos":
//                
//                break;
//            case "email":
//                valor = lstDatosUnicos.get(0).getEmail();
//                break;
//            case "fechaIngreso":
//                valor = lstDatosUnicos.get(0).getFechaIngreso();
//                break;
//            case "semestreIngreso":
//                valor = lstDatosUnicos.get(0).getSemestreIngreso();
//                break;
//            case "fechaGraduacion":
//                valor = lstDatosUnicos.get(0).getFechaGraduacion();
//                break;
//            case "becaTotal":
//                valor = lstDatosUnicos.get(0).getBecaTotal();
//                break;
//            case "pagoSemestral":
//                valor = lstDatosUnicos.get(0).getBecaSemestral();
//                break;
//            case "saldoAcumulado":
//                
//                break;
//            case "servicioAcumulado":
//                
//                break;
//            case "descuentoAcumulado":
//                
//                break;
//            case "semestre":
//                valor = lstMuchosDatos.get(contador).getSemestre();
//                break;
//            case "pago1":
//                valor = lstMuchosDatos.get(contador).getPago1();
//                break;
//            case "pago2":
//                valor = lstMuchosDatos.get(contador).getPago2();
//                break;
//            case "promedio":
//                
//                break;
//            case "horasServicio":
//                valor = lstMuchosDatos.get(contador).getHorasServicio();
//                break;
//            case "tipoServicio":
//                
//                break;
//            case "descuento":
//                
//                break;
//            case "nombreCompleto":
//                valor = lstDatosUnicos.get(0).getaPaterno() + " " + lstDatosUnicos.get(0).getaMaterno() + " " + lstDatosUnicos.get(0).getNombre();
//                break;
//        }
//        
//        return valor;
//    }
//    
//}
