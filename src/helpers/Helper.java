/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import index.Index;
import java.awt.Color;
import java.awt.Component;
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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
            System.out.println("Archivo: " + archivo.toString());
            //definiendo la ruta en la propiedad file
            //Runtime.getRuntime().exec("cmd /c start "+ archivo.toString());
            Desktop.getDesktop().open(archivo);

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
    public int getTotalSemestresporHabilitarKardex(int mesInicioBeca, int anioInicioBeca, int semestreInicioBeca, int semestresTotales){
        int response = 0;
        Calendar inicio = Calendar.getInstance();
        inicio.set(anioInicioBeca, mesInicioBeca, 1);
        //System.out.println("Inicio1: " + inicio.getTimeInMillis());
        Calendar hoy = new GregorianCalendar();
        //System.out.println("hoy1: " + hoy.getTimeInMillis());
        
        //Se calcula la fecha en la que se inició la beca
        inicio.add(Calendar.MONTH, ((semestreInicioBeca - 1) * 6));
        //System.out.println("Inicio2: " + inicio.getTimeInMillis());
        
        //Se calculan los semestres que han pasado desde que se inició la beca
        long distancia = hoy.getTimeInMillis() - inicio.getTimeInMillis();
        long timeStampMesesTranscurridos = hoy.getTimeInMillis() - distancia;
        System.out.println("Calendario: " + ((distancia / (1000 * 60 * 60 * 24 * 30) * -1)) / 12); 
        //semestresTranscurridos = ( fecha / (milisegundos * segundos * minutos * horas * dias) * -1) / mesesXAño 
        int semestresTranscurridos = (int) (distancia / (1000 * 60 * 60 * 24 * 30) * -1) / 12;
        
        if(semestresTranscurridos <= semestresTotales)
            return semestresTranscurridos + 1;
        else
            return semestresTotales + 1;
    }

    public void tomaRutaBase() {
        
    }
}
