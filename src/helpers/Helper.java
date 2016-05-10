/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import com.toedter.calendar.JDateChooser;
import index.Index;
import java.awt.Color;
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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        
        if(becaAut <= costoCarrera){
            String semestresTotales = Integer.parseInt(cmbSemestresTotales.getSelectedItem().toString()) + 1 + "";
            String semestreInicioBeca = (String) cmbSemestreInicioBeca.getSelectedItem();
            int semestres = Integer.parseInt( semestresTotales) - Integer.parseInt(semestreInicioBeca);

            float total = Float.parseFloat(becaAutorizada) / semestres;

            DecimalFormat formato = new DecimalFormat("###,###,###,###");
            txtBecaSemestral.setText(formato.format(total));
        }
        else{
            JOptionPane.showMessageDialog(null, "Debes de ingresar un valor menor al Costo de Carrera");
            txtBecaAutorizada.setText(becaAutorizada.substring(0, becaAutorizada.length() - 1));
            //txtBecaAutorizada.setText("");
            
        }
        
        
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
        Pattern patron = null;
        Matcher matcher;
        patron = Pattern.compile("^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
        
        if(txtFechaNacimiento.getText().length() > 0){
            matcher = patron.matcher(txtFechaNacimiento.getText());
            if(!matcher.matches()){
                txtFechaNacimiento.setBackground(Color.ORANGE);
                JOptionPane.showMessageDialog(vista, "Fecha de nacimiento incorrecta");
            }
            else
                response = true;
            
        }
        else{
            response = true;
        }
        
        
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

    private void verificaDirectorio(Path rutaDirectorio) {
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
        fecha = calendario.get(Calendar.DATE) + "/" + mes + "/" + calendario.get(Calendar.YEAR);
        
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
        semestresTotales += 1;
        semestreInicioBeca -= 1;
        return semestresTotales - semestreInicioBeca;
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
        semestresTranscurridos -= 1;
        
        //Se llena la primer posicion que se brincará al recorrel la lista
        //lstFechasSemestres.add(null);
        
        
        
        //Se comienzan a calcular el inicio de cada semestre del becario
        int mesInicio = datosEscolares.getMesInicioBeca();
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
        for(int i = 0; i <=  semestresTranscurridos ; i++){
            if(i < (datosEscolares.getSemestreInicioBeca() - 1)){
                inicio.add(Calendar.MONTH, 6);
           
                int mes = inicio.get(Calendar.MONTH);
                if(mes >= 6)
                    mes = 7;
                if(mes < 6)
                    mes = 0;
                inicio.set(Calendar.MONTH, mes);
            }
            else{
                Calendar aux = new GregorianCalendar();
                aux.setTime(inicio.getTime());
                lstFechasSemestres.add(aux);
                inicio.add(Calendar.MONTH, 6);
           
                int mes = inicio.get(Calendar.MONTH);
                if(mes >= 6)
                    mes = 7;
                if(mes < 6)
                    mes = 0;
                inicio.set(Calendar.MONTH, mes);
                
                System.out.println("Antes de agregar fecha a lista: " + aux.getTime());
                
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
     * Agrega una fila a la tabla seleccionada
     * @param tabla 
     */
    public void eliminaFilaTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filas = modelo.getRowCount();
        
        //Si hay una fila seleccionada
        if(tabla.getSelectedRow() >= 0){
            modelo.removeRow(tabla.getSelectedRow());
        }
        else
            modelo.removeRow(filas - 1);
    }
    
    /**
     * Obtiene la fecha de un JDateChooser
     * @param chooser
     * @return 
     */
    public java.util.Date getFechaDateChooser(JDateChooser chooser){
        
        java.util.Date fecha = null;
        if(chooser.getDate() != null){
            fecha = chooser.getDate();
        }
        return fecha;
    }
    
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
            
            
}
