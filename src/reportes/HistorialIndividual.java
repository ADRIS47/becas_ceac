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
import pojos.PojoReporteIndividual;
import pojos.PojoReporteIndividualMuchosDatos;
import pojos.Telefono;

/**
 *
 * @author sergio
 */
public class HistorialIndividual 
                                    implements JRDataSource{
    List<PojoReporteIndividual> lstDatosUnicos = new ArrayList<>();
    List<PojoReporteIndividualMuchosDatos> lstMuchosDatos = new ArrayList<>();
    List<Telefono> lstTelefonos = new ArrayList<>();
    int contador = -1;
    
    public void setLstDatosUnicos(PojoReporteIndividual becario){
        this.lstDatosUnicos.add(becario);
    }

    public void setLstMuchosDatos(List<PojoReporteIndividualMuchosDatos> lstMuchosDatos) {
        this.lstMuchosDatos = lstMuchosDatos;
    }

    public void setLstTelefonos(List<Telefono> lstTelefonos) {
        this.lstTelefonos = lstTelefonos;
    }
    

    @Override
    public boolean next() throws JRException {
        return ++contador < lstMuchosDatos.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        float pagoSemestral = 0;
        switch(jrf.getName()){
            case "folio":
                valor = lstDatosUnicos.get(0).getFolio();
                break;
            case "aPaterno":
                valor = lstDatosUnicos.get(0).getaPaterno();
                break;
            case "aMaterno":
                valor = lstDatosUnicos.get(0).getaMaterno();
                break;
            case "nombre":
                valor = lstDatosUnicos.get(0).getNombre();
                break;
            case "programa":
                valor = lstDatosUnicos.get(0).getPrograma();
                break;
            case "estatus":
                valor = lstDatosUnicos.get(0).getEstatus();
                break;
            case "escuela":
                valor = lstDatosUnicos.get(0).getEscuela();
                break;
            case "carrera":
                valor = lstDatosUnicos.get(0).getCarrera();
                break;
            case "campo":
                valor = lstDatosUnicos.get(0).getCampo();
                break;
            case "telefonos":
                int tamanio = lstTelefonos.size();
                valor = "";
                for (int i = 0; i < tamanio; i++) {
                    if(i == tamanio - 1)
                        valor = valor + lstTelefonos.get(i).getTelefono();
                    else
                        valor = valor + lstTelefonos.get(i).getTelefono() + ", ";
                }
                break;
            case "email":
                valor = lstDatosUnicos.get(0).getEmail();
                break;
            case "fechaIngreso":
                valor = lstDatosUnicos.get(0).getFechaIngreso();
                break;
            case "semestreIngreso":
                valor = lstDatosUnicos.get(0).getSemestreIngreso();
                break;
            case "fechaGraduacion":
                valor = lstDatosUnicos.get(0).getFechaGraduacion();
                break;
            case "becaTotal":
                valor = lstDatosUnicos.get(0).getBecaTotal();
                break;
            case "pagoSemestral":
                valor = lstDatosUnicos.get(0).getBecaSemestral();
                break;
            case "saldoAcumulado":
                int saldo = 0;
                int becaSemestral = ((int) lstDatosUnicos.get(0).getBecaSemestral()) / 2;
                for (PojoReporteIndividualMuchosDatos datos : lstMuchosDatos) {
                    if(datos.getPago1())
                        saldo += becaSemestral;
                    if(datos.getPago2())
                        saldo += becaSemestral;
                }
                valor = saldo;
                break;
            case "servicioAcumulado":
                int servicio = 0;
                for (PojoReporteIndividualMuchosDatos datos : lstMuchosDatos) {
                    servicio += datos.getHorasServicio();
                }
                valor = servicio;
                break;
            case "descuentoAcumulado":
                int descuento = 0;
                for (PojoReporteIndividualMuchosDatos datos : lstMuchosDatos) {
                    descuento += datos.getDescuento();
                }
                valor = descuento;
                break;
            case "semestre":
                valor = lstMuchosDatos.get(contador).getSemestre();
                break;
            case "pago1":
                boolean pago1 = lstMuchosDatos.get(contador).getPago1();
                pagoSemestral = lstDatosUnicos.get(0).getBecaSemestral();
                if(pago1)
                    valor = pagoSemestral / 2;
                else
                    valor = 0;
                break;
            case "pago2":
                boolean pago2 = lstMuchosDatos.get(contador).getPago2();
                pagoSemestral = lstDatosUnicos.get(0).getBecaSemestral();
                if(pago2)
                    valor = pagoSemestral / 2;
                else
                    valor = 0;
                break;
            case "promedio":
                valor = lstMuchosDatos.get(contador).getPromedio();
                break;
            case "horasServicio":
                valor = lstMuchosDatos.get(contador).getHorasServicio();
                break;
            case "tipoServicio":
                valor = lstMuchosDatos.get(contador).getTipoServicio();
                break;
            case "descuento":
                valor = lstMuchosDatos.get(contador).getDescuento();
                break;
            case "nombreCompleto":
                valor = lstDatosUnicos.get(0).getaPaterno() + " " + lstDatosUnicos.get(0).getaMaterno() + " " + lstDatosUnicos.get(0).getNombre();
                break;
        }
        
        return valor;
    }
    
}
