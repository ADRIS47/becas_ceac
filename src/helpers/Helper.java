/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import index.Index;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import pojos.Becario;
import pojos.DatosEscolares;
import pojos.Kardex;
import principal.VistaReportes;

/**
 *
 * @author sabagip
 */
public class Helper {
    
    Log log = new Log();
    
    protected File fileFoto = null;
    protected File fileActaNacimiento;
    protected File fileBoleta_calificaciones_inicial;
    protected File fileCarta_solicitud;
    protected File fileEnsayo;
    protected File fileIneBecario;
    protected File fileIneAval;
    protected File fileContrato;
    protected File filePagare;
    protected File fileEstudioSocioeconomico;
    protected File fileCartaAsignacionBeca;
    
    public final static int FILE_ACTA_NACIMIENTO = 0;
    public final static int FILE_BOLETA_CALIFICACIONES_INICIAL = 1;
    public final static int FILE_CARTA_SOLICITUD = 2;
    public final static int FILE_ENSAYO = 3;
    public final static int FILE_INE_BECARIO = 4;
    public final static int FILE_INE_AVAL = 5;
    public final static int FILE_CONTRATO = 6;
    public final static int FILE_PAGARE = 7;
    public final static int FILE_ESTUDIO_SOCIECONOMICO = 8;
    public final static int FILE_CARTA_ASIGNACION_BECA = 9;
    public final static int FILE_CARTA_AGRADECIMIENTO = 10;
    
    public void cursorEspera(JFrame vista){
        //vista.setCursor(new Cursor(Cursor.WAIT_CURSOR));     
        Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
        vista.setCursor(cursor);
    }
    
    public void cursorNormal(JFrame vista){
        //vista.setCursor(new Cursor(Cursor.WAIT_CURSOR));     
        Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        vista.setCursor(cursor);
    }

    public static void getFechaGraduacion(JComboBox<?> cmbBoxMesInicioCarrera, JComboBox<?> cmbBoxAnioInicioBeca, JComboBox<?> cmbBoxMesGraduacion, JComboBox<?> cmbBoxAnioGraduacion, JComboBox<?> cmbBoxSemestreInicioBeca, JComboBox<?> cmbBoxTotalSemestres) {
        Calendar graduacion = new GregorianCalendar(Integer.parseInt((String) cmbBoxAnioInicioBeca.getSelectedItem()), 
        cmbBoxMesInicioCarrera.getSelectedIndex(), 1);

        graduacion.add(Calendar.MONTH, - Integer.parseInt(cmbBoxSemestreInicioBeca.getSelectedItem().toString()) * 6);
        graduacion.add(Calendar.MONTH, Integer.parseInt((String) cmbBoxTotalSemestres.getSelectedItem()) * 6);      
        graduacion.add(Calendar.MONTH, 5);
        
        int indexAnioGraduacion = graduacion.get(Calendar.YEAR) - Integer.parseInt(cmbBoxAnioGraduacion.getItemAt(0).toString()) ;

        cmbBoxAnioGraduacion.setSelectedIndex(indexAnioGraduacion);
        cmbBoxMesGraduacion.setSelectedIndex(graduacion.get(Calendar.MONTH));
    }

    /**
     * 
     * @param cmbSemestresTotales
     * @param cmbSemestreInicioBeca
     * @param cmbAnioInicioBeca
     * @param txtBecaAutorizada
     * @param txtBecaSemestral
     * @param txtCostoCarrera 
     */
    public static void getBecaSemestral(JComboBox<?> cmbSemestresTotales, JComboBox<?> cmbSemestreInicioBeca, 
                    JComboBox<?> cmbAnioInicioBeca, JTextField txtBecaAutorizada, 
                    JTextField txtBecaSemestral, JTextField txtCostoCarrera) {
        
        String becaAutorizada = txtBecaAutorizada.getText().replace(",", "");
        becaAutorizada = becaAutorizada.replace(".", "");
        String costoCarr = txtCostoCarrera.getText().replace(",", "");
        costoCarr = costoCarr.replace(".", "");
        
        int becaAut = Integer.parseInt(becaAutorizada);
        int costoCarrera = Integer.parseInt(costoCarr);
        
//        if(becaAut <= costoCarrera){
            String semestresTotales = Integer.parseInt(cmbSemestresTotales.getSelectedItem().toString()) + 1 + "";
            String semestreInicioBeca = (String) cmbSemestreInicioBeca.getSelectedItem();
            int semestres = Integer.parseInt( semestresTotales) - Integer.parseInt(semestreInicioBeca);

            float total = Float.parseFloat(becaAutorizada) / semestres;

            DecimalFormat formato = new DecimalFormat("###,###,###,###");
            txtBecaSemestral.setText(formato.format(total));
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "Debes de ingresar un valor menor al Costo de Carrera");
//            txtBecaAutorizada.setText(becaAutorizada.substring(0, becaAutorizada.length() - 1));
//            //txtBecaAutorizada.setText("");
//            
//        }
        
        
    }
    /**
     * Carga una imagen dentro de un label y la adapta al tamaño de la etiqueta
     * @param etiqueta Etiqueta donde se pondrá la imagen
     * @param ruta Ruta de la imagen que se pondrá en la etiqueta
     */
    public void cargaImagenLocal(JLabel etiqueta, String ruta){
        ImageIcon fot = new ImageIcon(getClass().getResource(ruta));
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(etiqueta.getWidth(), 
                etiqueta.getHeight(), Image.SCALE_DEFAULT));
        etiqueta.setIcon(icono);
    }
    
    public void cargaImagenExterna(JLabel etiqueta, Path path){
//        ImageIcon fot = new ImageIcon(path.toString());
//        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(etiqueta.getWidth(), 
//                etiqueta.getHeight(), Image.SCALE_DEFAULT));
//        etiqueta.setIcon(icono);

        Image image = Toolkit.getDefaultToolkit().getImage(path.toString());
        ImageIcon icon = new ImageIcon(image);
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(etiqueta.getWidth(), 
                etiqueta.getHeight(), Image.SCALE_DEFAULT));
        etiqueta.setIcon(icono);
        
    }

    /**
     * Agrega un JPanel a un JScrollPane 
     * @param componente Componente que se desea agregar al ScrollPane
     * @param spnlParentesco JScrollPane donde se agregará el componente
     */
    public void agregaJPanel(JComponent componente, JScrollPane spnlParentesco) {
        //spnlParentesco.setViewportView(componente);
        //spnlParentesco.getViewport().add(componente);
        spnlParentesco.getViewport().add(componente, -1);
        //spnlParentesco.validate();
    }
    
    /**
     * Agrega un JPanel a otro Jpanel 
     * @param componente Componente que se desea agregar al ScrollPane
     * @param panel JPanel donde se agregará el componente
     */
    public void agregaJPanel(JComponent componente, JPanel panel) {
        panel.add(componente);
        //panel.validate();
    }
    
    /**
     * Elimina el último JPnael 
     * @param componente Componente a eliminar
     * @param panel Panel donde se eliminará el componente
     */
    public void borraJpanel(JComponent componente, JPanel panel) {
        panel.remove(componente);
    }

    public boolean validaEmail(String cadena1, String cadena2) {
        if(cadena1.equals(cadena2))
            return true;
        else
            return false;
    }

    public String creaFolio(String iniciales, long contador) {
        String folio = "";
        String result = "";
        if(contador < 10){
            folio = "00000" + contador;
        }
        if(contador > 9 && contador < 100){
            folio = "0000" + contador;
        }
        if(contador > 99 && contador < 1-000){
            folio = "000" + contador;
        }
        if(contador > 999 && contador < 10-000){
            folio = "00" + contador;
        }
        if(contador > 9-999 && contador < 100-000){
            folio = "0" + contador;
        }
        if(contador > 99-999 && contador < 1-000-000){
            folio = "00" + contador;
        }
        
        result = iniciales + folio;
        return result;
        
    }

    public boolean validaFechaNacimiento(JTextField txtFechaNacimiento, Component vista) {
        boolean response = false;
//        Pattern patron = null;
//        Matcher matcher;
//        patron = Pattern.compile("^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
//        
//        if(txtFechaNacimiento.getText().length() > 0){
//            matcher = patron.matcher(txtFechaNacimiento.getText());
//            if(!matcher.matches()){
//                txtFechaNacimiento.setBackground(Color.ORANGE);
//                JOptionPane.showMessageDialog(vista, "Fecha de nacimiento incorrecta");
//            }
//            else
//                response = true;
//            
//        }
//        else{
//            response = true;
//        }
        
        String fecha = txtFechaNacimiento.getText();
        fecha = fecha.replace("/", "");
        if(!fecha.isEmpty()){
            int dia = Integer.parseInt(fecha.substring(0, 2));
            int mes = Integer.parseInt(fecha.substring(2, 4));
            int anio = Integer.parseInt(fecha.substring(4, 8));
//            
            //Si el mes es menor igual a 12 y mayor igual a 1
            if(mes <= 12 && mes >= 1){
                //Si el día es mayor igual a 1 o menor igual a 31 o el mes es igual a 2 y el dia es menor igual a 29 o mayor igual a 1
                if( (mes != 2 && (dia >= 1 && dia <= 31)) || (mes == 2 && (dia <= 29 && dia >= 1))){
                    if(anio > 1970 && anio <= 2040)
                        response = true;
                }
            }
        }
        
            if(!response)
                JOptionPane.showMessageDialog(vista, "Fecha de nacimiento incorrecta");
        return response;
    }
    
    /**
     * Crea la ruta del archivo y lo guarda
     * @param folioBecario Folio que tendrá el becario
     * @param tipoDocumento Tipo de documento que se guardará (actaNacimienot = acta-, Pagaré = pagare-)
     * @param archivo Archivo que se pretende copiar
     * @return Archivo con los datos de 
     */
    public Path CopiaArchivoADestino(String folioBecario, String tipoDocumento, File archivo){
        
        String extension = archivo.getName().substring(archivo.getName().length() - 4, archivo.getName().length());
        
        //Se verifica si ya existe el directorio del nuevo becario y si no, lo crea
        verificaDirectorio(Paths.get(Index.RUTA_BASE + Index.RUTA_SISTEMA + folioBecario));
        
        
        Path de = Paths.get(archivo.getAbsolutePath());
        Path a = Paths.get(Index.RUTA_BASE + Index.RUTA_SISTEMA + folioBecario + Index.SEPARADOR + tipoDocumento + folioBecario + extension);
        try {
            Files.copy(de, a, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            a = null;
            log.crearLog("No se pudo copiar el archivo " + archivo.getName() + "    " + ex.getMessage());
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return a;
        
    }
    
    /**
     * Adiciona los archivos del kardex del becario a su respectivo semestre
     * @param lstKardexs
     * @param lstFilesBoletas
     * @param lstFilesCartaServCom
     * @return 
     */
    public List<Kardex> putArchivosKardexBecario(List<Kardex> lstKardexs, File[] lstFilesBoletas,
                    File[] lstFilesCartaServCom, File[] lstFilesTransferencias, Becario becario) {
        
        int i = 0;
        List<Kardex> lstResult = new ArrayList<>();
        for (Kardex kardex : lstKardexs) {
            
            //Si existe la boleta a copiar
            if(lstFilesBoletas[i] != null){
            //Se obtiene la boleta y se copia al directorio
                String extension = lstFilesBoletas[i].getName().substring(lstFilesBoletas[i].getName().length() - 4, 
                                lstFilesBoletas[i].getName().length());
                
                System.out.println(Paths.get(Index.RUTA_BASE + Index.RUTA_SISTEMA + becario.getFolio()));
                
                verificaDirectorio(Paths.get(Index.RUTA_BASE + Index.RUTA_SISTEMA + becario.getFolio()));

                Path de = Paths.get(lstFilesBoletas[i].getAbsolutePath());
                Path a = Paths.get(Index.RUTA_BASE + Index.RUTA_SISTEMA + becario.getFolio() + Index.SEPARADOR + 
                        "boleta_" + i + "-" + becario.getFolio() + extension);
                
                try {
                    Files.copy(de, a, StandardCopyOption.REPLACE_EXISTING);
                    kardex.setBoleta(becario.getFolio() + Index.SEPARADOR + a.getFileName().toString());
                } catch (IOException ex) {
                    a = null;
                    log.crearLog("No se pudo copiar la boleta " + lstFilesBoletas[i].getName() + "    " + ex.getMessage());
                    Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
            
            //Si existe la boleta a copiar
            if(lstFilesCartaServCom[i] != null){
                //Se obtiene la carta de servicio comunitario y se copia al directorio del becario
                String extension = lstFilesCartaServCom[i].getName().substring(lstFilesCartaServCom[i].getName().length() - 4, 
                                lstFilesCartaServCom[i].getName().length());

                Path de = Paths.get(lstFilesCartaServCom[i].getAbsolutePath());
                Path a = Paths.get(Index.RUTA_BASE + Index.RUTA_SISTEMA + becario.getFolio() + Index.SEPARADOR + 
                        "serv_com_" + i + "-" + becario.getFolio() + extension);

                try {
                    Files.copy(de, a, StandardCopyOption.REPLACE_EXISTING);
                    kardex.setCarta_servicio_comunitario(becario.getFolio() + Index.SEPARADOR + a.getFileName().toString());
                } catch (IOException ex) {
                    a = null;
                    log.crearLog("No se pudo copiar la carta de servicio comunitario " + lstFilesCartaServCom[i].getName() + "    " + ex.getMessage());
                    Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
            //Se agregan los archivos de transferencias
            int posicionInicial = i * 2;
            int posicionFinal = (i * 2) + 1;
            int contador = 0;
            for (int j = posicionInicial; j <= posicionFinal ; j++) {          
                //Si existe la primer transferencia
                if(contador == 0 && lstFilesTransferencias[posicionInicial] != null){
                    //Se obtiene la carta de servicio comunitario y se copia al directorio del becario
                    String extension = lstFilesTransferencias[posicionInicial].getName().substring(lstFilesTransferencias[posicionInicial].getName().length() - 4, 
                                    lstFilesTransferencias[posicionInicial].getName().length());

                    Path de = Paths.get(lstFilesTransferencias[posicionInicial].getAbsolutePath());
                    Path a = Paths.get(Index.RUTA_BASE + Index.RUTA_SISTEMA + becario.getFolio() + Index.SEPARADOR + 
                            "transferencia_" + posicionInicial + "-" + becario.getFolio() + extension);

                    try {
                        Files.copy(de, a, StandardCopyOption.REPLACE_EXISTING);

                        kardex.setTransferencia1(becario.getFolio() + Index.SEPARADOR + a.getFileName().toString());

                    } catch (IOException ex) {
                        a = null;
                        log.crearLog("No se pudo copiar la carta de servicio comunitario " + lstFilesTransferencias[posicionInicial].getName() + "    " + ex.getMessage());
                        Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    }
                }
                //Si existe la segunda transferencia
                else if(contador != 0 && lstFilesTransferencias[posicionFinal] != null){
                    //Si existe la transferencia a copiar
                    if(lstFilesTransferencias[posicionFinal] != null){
                        //Se obtiene la carta de servicio comunitario y se copia al directorio del becario
                        String extension = lstFilesTransferencias[posicionFinal].getName().substring(lstFilesTransferencias[posicionFinal].getName().length() - 4, 
                                        lstFilesTransferencias[posicionFinal].getName().length());

                        Path de = Paths.get(lstFilesTransferencias[posicionFinal].getAbsolutePath());
                        Path a = Paths.get(Index.RUTA_BASE + Index.RUTA_SISTEMA + becario.getFolio() + Index.SEPARADOR + 
                                "transferencia_" + posicionFinal + "-" + becario.getFolio() + extension);

                        try {
                            Files.copy(de, a, StandardCopyOption.REPLACE_EXISTING);

                            kardex.setTransferencia2(becario.getFolio() + Index.SEPARADOR + a.getFileName().toString());
                        } 
                        catch (IOException ex) {
                            a = null;
                            log.crearLog("No se pudo copiar la carta de servicio comunitario " + lstFilesTransferencias[posicionFinal].getName() + "    " + ex.getMessage());
                            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
                            return null;
                        }
                    }
                }
                contador++;
            }
            i++;
            lstResult.add(kardex);
        }
        
        return lstResult;
    }

    public void verificaDirectorio(Path rutaDirectorio) {
        if(!Files.exists(rutaDirectorio)){
            try {
                Files.createDirectory(rutaDirectorio);
            } catch (IOException ex) {
                log.crearLog(ex.getMessage());
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void validaRutaInicial() {
        String sistemaOperativo = System.getProperty("os.name");
        //String rutaPrincipal = "";
        Index.SEPARADOR = System.getProperty("file.separator");
        //String homeUsuario = System.getProperty("user.home");
        System.out.println("SO: " + sistemaOperativo);
        
        if(sistemaOperativo.toUpperCase().contains("WIN")){
            Index.RUTA_BASE = "C:\\SIBEC";
        }
        else if(sistemaOperativo.toUpperCase().contains("LIN")){
            Index.RUTA_BASE = System.getProperty("user.home") + Index.SEPARADOR + "SIBEC";
        }
        
        Index.RUTA_SISTEMA = Index.SEPARADOR + "becarios" + Index.SEPARADOR;
        Index.RUTA_FINAL =Index.RUTA_BASE + Index.SEPARADOR + Index.RUTA_SISTEMA + Index.SEPARADOR;
                
        Path pathRutaPrincipal = Paths.get(Index.RUTA_BASE);
        Path pathRutaSistema =  Paths.get(Index.RUTA_BASE + Index.SEPARADOR + Index.RUTA_SISTEMA + Index.SEPARADOR);
        
        System.out.println("RutaPrincipal: " + pathRutaPrincipal);
        System.out.println("Path becas: "  + pathRutaSistema);
        
        if(!Files.exists(pathRutaPrincipal)){
            try {
                Files.createDirectory(pathRutaPrincipal);
            } catch (IOException ex) {
                log.crearLog(ex.getMessage());
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(!Files.exists(pathRutaSistema)){
            try {
                Files.createDirectory(pathRutaSistema);
            } catch (IOException ex) {
                log.crearLog(ex.getMessage());
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void bajaScrollVertical(JScrollPane scrollPane) {
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
    }

    /**
     * Regresa una fecha en formato humano
     * @param fecha_nac Fecha a formatear
     * @return Fecha formateada
     */
    public String formateaFechaBD(Date fecha_nac) {
        String fecha = "";
        
        java.util.Date dateJava = new Date(fecha_nac.getTime()) ;
        Calendar calendario = new GregorianCalendar();
        calendario.setTime(dateJava);
        
        String mes = new String(calendario.get(Calendar.MONTH) + 1 + "");
        if(mes.length() == 1)
            mes = "0" + mes;
        
        String dia = new String(calendario.get(Calendar.DATE) + "");
        if(dia.length() == 1)
            dia = "0" + dia;
        fecha = dia + "/" + mes + "/" + calendario.get(Calendar.YEAR);
        
        return fecha;
    }
    
    /**
     * Pone el año actual del sistema en un ComboBox
     * @param combo 
     */
    public void setAñoActualEnCombo(JComboBox<String> combo){
        Calendar calendario = new GregorianCalendar();
        int year = calendario.get(Calendar.YEAR) - 2007;
        combo.setSelectedIndex(year);
    }

    public void abreArchivoAdjunto(File archivo) {
        try{ 
            
            //System.out.println("Archivo: " + archivo.toString());
            //definiendo la ruta en la propiedad file
            if(archivo != null)
                Desktop.getDesktop().open(archivo);
            else
                JOptionPane.showMessageDialog(null, "Debe de cargar un archivo", "Error", JOptionPane.ERROR_MESSAGE);
            
        }catch(IOException e){
            e.printStackTrace();
        } 
    }
    
    /**
     * Obtiene el total de semestres que se pueden llenar para el registro del kardex
     * @param mesInicioBeca
     * @param anioInicioBeca
     * @param semestreInicioBeca
     * @param semestresTotales
     * @return Regresa el total de semestres a habilitar
     */
    public int getTotalSemestresporHabilitarKardex(int semestreInicioBeca, int semestresTotales){
//        semestresTotales += 1;
//        semestreInicioBeca -= 1;
//        return semestresTotales - semestreInicioBeca;
        return (semestresTotales - semestreInicioBeca) + 1;
    }
    
    public static void getDescuentoSemestral(JCheckBox chkPlatica1, JCheckBox chkPlatica2, 
            JTextField txtPromedio, JTextField txtDescuento){
        int descuento = 0;
        
        if(chkPlatica1.isSelected())
            descuento = descuento + 2;
        
        if(chkPlatica2.isSelected()){
            descuento = descuento + 2;
        }
        
        if(!txtPromedio.getText().equals("")){
            float valor = Float.parseFloat(txtPromedio.getText());
            if(valor >= 90){
                descuento = descuento + 2;
            }
        }
        
        txtDescuento.setText(descuento + "%");
    }
    
    /**
     * Se comienzan a evaluar las fechas tentativas de los inicios de semestre
     * @param datosEscolares
     * @return 
     */
    public java.util.List<Calendar> getFechaSemestres(DatosEscolares datosEscolares){
        java.util.List<Calendar> lstFechasSemestres = new java.util.ArrayList<>();
        
        int semestresTranscurridos = getTotalSemestresporHabilitarKardex(datosEscolares.getSemestreInicioBeca(), 
                datosEscolares.getSemestresTotalesCarrera());
        
        if(datosEscolares.getSemestreInicioBeca() > 1){
            semestresTranscurridos = (datosEscolares.getSemestresTotalesCarrera() - semestresTranscurridos) + 2;
        }
        
        
        
        //Se comienzan a calcular el inicio de cada semestre del becario
        int mesInicio = datosEscolares.getMesInicioBeca() + 1;
        //Se igualan los meses para que se comience en Enero o Agosto
        if(mesInicio >= 6)
            mesInicio = 7;
        if(mesInicio < 6)
            mesInicio = 0;
        
        //Se obtiene la fecha de inicio de la carrera y se calcula la fecha de inicio de beca
        Calendar inicio = new GregorianCalendar(datosEscolares.getAnioInicioBeca(), mesInicio, 1);
//        System.out.println("INicio: " + inicio.getTime());
//        inicio.add(Calendar.MONTH, semestresTranscurridos * 6);
//        System.out.println("INicio2: " + inicio.getTime());
        
        for(int i = 0; i <=  semestresTranscurridos  ; i++){
            if(i < (datosEscolares.getSemestreInicioBeca() - 2 )){
                inicio.add(Calendar.MONTH, 6);
           
                int mes = inicio.get(Calendar.MONTH);
                if(mesInicio >= 6)
                    mesInicio = 7;
                if(mesInicio < 6)
                    mesInicio = 0;
                inicio.set(Calendar.MONTH, mes);
            }
            else{
                Calendar aux = new GregorianCalendar();
                aux.setTime(inicio.getTime());
                lstFechasSemestres.add(aux);
                inicio.add(Calendar.MONTH, 6);
           
                int mes = inicio.get(Calendar.MONTH);
                if(mesInicio >= 6)
                    mesInicio = 7;
                if(mesInicio < 6)
                    mesInicio = 0;
                inicio.set(Calendar.MONTH, mes);
                
                //System.out.println("Antes de agregar fecha a lista: " + aux.getTime());
                
            }
            
        }
        return lstFechasSemestres;
    }

    /**
     * Agrega una fila a la tabla seleccionada
     * @param tabla 
     */
    public void agregaFilaTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addRow(new String[]{});
    }
    
    /**
     * Elimina una fila a la tabla seleccionada y también lo elimina de su respectivo catalogo
     * @param tabla 
     * @param lstCatalogo 
     */
    public void eliminaFilaTabla(JTable tabla, LinkedHashMap<Integer, String> lstCatalogo) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filas = modelo.getRowCount();
        
        //Si hay una fila seleccionada
        if(tabla.getSelectedRow() >= 0){
            for (Integer key : lstCatalogo.keySet()) {
                if(lstCatalogo.get(key).equals(tabla.getValueAt(tabla.getSelectedRow(), 0))){
                    lstCatalogo.remove(key);
                    modelo.removeRow(tabla.getSelectedRow());
                    break;
                }
            }
        }
        else{
            String dato = (String) tabla.getValueAt(tabla.getRowCount(), 0);
            for (Integer key : lstCatalogo.keySet()) {
                if(lstCatalogo.get(key).equals(dato)){
                    lstCatalogo.remove(key);
                    modelo.removeRow(tabla.getSelectedRow());
                    break;
                }
            }
            modelo.removeRow(filas - 1);
        }
    }
    
    /**
     * Vacia en su totalidad todas las filas de la tabla
     * @param tabla 
     */
    public void eliminaFilasTabla(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }
    
    /**
     * Obtiene la fecha de un JDateChooser
     * @param chooser
     * @return 
     */
//    public java.util.Date getFechaDateChooser(JDateChooser chooser){
//        
//        java.util.Date fecha = null;
//        if(chooser.getDate() != null){
//            fecha = chooser.getDate();
//        }
//        return fecha;
//    }
    
    /**
     * Convierte una fecha tipo util.Date a fecha sql.Date
     * @param fecha Fecha tipo java.util.Date
     * @return Fecha convertida en java.sql.Date
     */
    public java.sql.Date convertUtilDateToSqlDate(java.util.Date fecha){
        java.sql.Date nuevaFecha = new java.sql.Date(fecha.getTime());
        return nuevaFecha;
    }
    
    public java.util.Date convertCadenaAFecha(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = null;
        try{
            date = formato.parse(fecha);
        }
        catch(ParseException e){
            log.crearLog(e.getMessage());
        }
        
        return date;
    }

    /**
     * Toma el campo que se va a ingresar al catalogo, borra todos los datos de la tabla,
     * agrega el nuevo campo a una lista auxiliar e inserta el nuevo campo a la tabla
     * @param tabla
     * @param txtBuscador
     * @param texto
     * @param catDatosCatalogos
     * @return  Regresa el nuevo catalogo
     */
    public LinkedHashMap<Integer, String> agregaFilaTabla(JTable tabla, JTextField txtBuscador, String texto, 
                            LinkedHashMap<Integer, String> catDatosCatalogos) {
        LinkedHashMap<Integer, String> catNuevoCatalogo = new LinkedHashMap<>();
        DefaultTableModel tblModelo = (DefaultTableModel) tabla.getModel();
        //txtBuscador.setText("");
        
        int i = 0;
        //Se hace una copia de los registros de la tabla y se obtiene el id mayor que se ha agregado a la lista
        for (Integer idCat : catDatosCatalogos.keySet()) {
            catNuevoCatalogo.put(idCat, catDatosCatalogos.get(idCat));
            
            if(i <= idCat)
                i = idCat;
        }
        catNuevoCatalogo.put(i + 1, texto);
        
        eliminaFilasTabla(tabla);
        
        for (Integer id : catNuevoCatalogo.keySet()) {
            tblModelo.addRow(new String[]{catNuevoCatalogo.get(id)});
        }
        txtBuscador.setText("");
        
        
        return catNuevoCatalogo;
    }
            
    /**
     * Detecta si el sistema se está ejecutando en netbeans o en el .jar y
     * devuelve la ruta completa del archivo que se desea abrir
     * @param nombreArchivo
     * @return 
     */
    public Path getDirectorioReporte(String nombreArchivo){
        Path path;
        
        Path template = Paths.get(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        System.out.println(template);
        File isJar = new File(template.toString());
        //Si se está ejecutando en netbeans
        if(isJar.isDirectory()){
            path = Paths.get(template + Index.SEPARADOR +"reportes" + Index.SEPARADOR + "compilados" + Index.SEPARADOR + nombreArchivo);
        }
        //Si se está ejecutando en el jar
        else{
            path = Paths.get(template.getParent() + Index.SEPARADOR + "compilados" + Index.SEPARADOR + nombreArchivo);
        }
        
        return path;
    }

    /**
     * Obtiene las fechas de los filtros
     * @param filtros
     * @return 
     */
    public java.util.Date[] getFechasFiltro(String filtros, VistaReportes vistaReporte) {
        java.util.Date[] result = new java.util.Date[2];
        //Si se encontraron filtros
        if(!filtros.isEmpty() && filtros.contains("BETWEEN")){
            String[] separacion = filtros.split("BETWEEN");
            String[] fechas = separacion[1].split("AND");

            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
            try {
                //Se remplazan los caracteres raros
                fechas[0] = fechas[0].replace("'", "").trim();
                fechas[1] = fechas[1].replace("'", "").trim();
                fechas[0] = fechas[0].replace("-", "/").trim();
                fechas[1] = fechas[1].replace("-", "/").trim();
                //Se parsean las fechas
                result[0] = formato.parse(fechas[0].trim());
                result[1] = formato.parse(fechas[1].trim());
            } catch (ParseException ex) {
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
            
}
